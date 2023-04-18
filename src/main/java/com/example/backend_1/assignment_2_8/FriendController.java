package com.example.backend_1.assignment_2_8;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class FriendController {

    Friend friend = new Friend(0, Arrays.asList("Pelle", "P")
            , LocalDate.parse("1990-05-20")
            , "Storgatan"
            , Arrays.asList("123", "4214"));
    Friend friend1 = new Friend(1, Arrays.asList("Snorre", "S")
            , LocalDate.parse("1980-05-20")
            , "mellangatan"
            , Arrays.asList("222", "33333"));
    Friend friend2 = new Friend(2, Arrays.asList("Gonnor", "G")
            , LocalDate.parse("1970-05-20")
            , "lillgatan"
            , Arrays.asList("4444", "5555555"));
    FriendDAO friendDAO = new FriendDAO();


    @RequestMapping("/friend")
    public Friend getFriend() {
        return friend;
    }

    @RequestMapping("/friends")
    public List<FriendNameAndNumber> getNameAndNumbers() throws Exception {
        return friendDAO.getNamesAndNumber();
    }
    @GetMapping("/friends/all")
    public CollectionModel<EntityModel<Friend>> all() {
        List<EntityModel<Friend>> friends = friendDAO.friendList.stream()
                .map(friend -> EntityModel.of(friend,
                        linkTo(methodOn(FriendController.class).getFriendById(String.valueOf(friend.getId()))).withSelfRel()
                        , linkTo(methodOn(FriendController.class).all()).withRel("friend")))
                .toList();
        return CollectionModel.of(friends, linkTo(methodOn(FriendController.class).all()).withSelfRel());
    }

    @RequestMapping("/addFriends")
    public String addFriends() {
        friendDAO.addFriend(friend);
        friendDAO.addFriend(friend1);
        friendDAO.addFriend(friend2);

        return "Friends Added to FriendList";
    }

    @GetMapping("friendById/{id}")
    EntityModel<Friend> getFriendById(@PathVariable("id") String id) {
        Friend one = friendDAO.friendList.stream()
                .filter(f -> String.valueOf(f.getId()).equals(id))
                .findFirst()
                .orElse(null);
        assert one != null;
        return EntityModel.of(one,
                linkTo(methodOn(FriendController.class).getFriendById(id)).withSelfRel()
                , linkTo(methodOn(FriendController.class).all()).withRel("friend"));

    }

    @RequestMapping("friendByName/{name}")
    public Friend getFriendByName(@PathVariable("name") String name) {
        return friendDAO.friendList.stream()
                .filter(f -> Objects.equals(f.getNames().get(0), name))
                .findFirst()
                .orElse(null);
    }

    @RequestMapping("friendDeleteById/{id}")
    public String deleteFriendById(@PathVariable("id") Integer id) {
        if (friendDAO.friendList.removeIf(f -> f.getId() == id)) {
            return "Friend with ID " + id + " removed";
        } else return "No Friend with id " + id + " found";
    }

    @PostMapping("/friends/add")
    public List<Friend> addFriendByPost(@RequestBody Friend f) {
        friendDAO.friendList.add(f);
        return friendDAO.friendList;
        //curl post command
        //curl -H "Content-Type: application/json" -d '{"id":3,"names":["Postgubben","Posten"],"birthday":"1995-05-20","adress":"Stoooorgatan","telefonnummer":["123","4214","5678"]}' http://localhost:8080/friends/add
    }

    @PutMapping("/friends/update")
    public List<Friend> updateFreind(@RequestBody Friend f) {
        Friend friendToUpdate = friendDAO.friendList.stream()
                .filter(fri -> fri.getId() == f.getId())
                .findFirst().orElse(null);
        if (friendToUpdate == null) {
            friendDAO.friendList.add(f);
        } else {
            friendToUpdate.setNames(f.getNames());
            friendToUpdate.setAdress(f.getAdress());
            friendToUpdate.setBirthday(f.getBirthday());
            friendToUpdate.setTelefonnummer(f.getTelefonnummer());
        }
        return friendDAO.friendList;
        //Curl update command
        //curl -X PUT -H "Content-Type: application/json" -d '{"id":3,"names":["Posten","Posten"],"birthday":"1995-05-20","adress":"gatan","telefonnummer":["123","4214","5678"]}' http://localhost:8080/friends/update
    }

}

/*

Uppgift 5 – Telefonboken som Web Service (radera kompis)
• Implementera deleteFriendByID i din applikation
• http://localhost:8080/kompis/5/delete
• Tar bort kompis med id=5
• Testa att angiven kompis verkligen tas bort


Uppgift 4
• Lägg till en funktion getFriendByID som tar en int som inparameter och skriver ut datat för
den av dina vänner som har det id:t
• Ex: Http://localhost:8080/friend/5
• Ska returnera kompisen med id=5
• Om du inte har instansvariabeln id sedan innan i din Kompis-klass, lägg till den nu
• I mån av tid, gör en getFriendByName som tar ett namn, säker igenom Kompis-listan och
skriver ut alla uppgifter för den Kompis som har angivet namn

Uppgift 3 – Telefonboken som Web Service (lista alla kompisar)
        • Gör en web service där du kan lista dina vänners namn och telefonnummer på JSON
        • Dina vänner ska lagras i en KompisDAO-klass
        • Det ska gå att anropa web servicen från en webbläsare och alla vänners namn och
        telefonnummer ska skrivas ut på JSON
        • För er som blir klara snabbt, bygg ut Kompis-modellen till att även innehålla nick, kunna ha
        flera telefonnummer, ha en födelsedag och kunna ha flera adresser.*/
