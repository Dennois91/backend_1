package com.example.backend_1.assignment_2_8;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
public class FriendController {

    Friend friend = new Friend(0, Arrays.asList("Pelle", "P"), LocalDate.parse("1990-05-20"), "Storgatan", Arrays.asList("123", "4214"));
    Friend friend1 = new Friend(1, Arrays.asList("Snorre", "S"),LocalDate.parse("1980-05-20"), "mellangatan", Arrays.asList("222", "33333"));
    Friend friend2 = new Friend(2, Arrays.asList("Gonnor", "G"),LocalDate.parse("1970-05-20"), "lillgatan", Arrays.asList("4444", "5555555"));
    FriendDAO friendDAO = new FriendDAO();


    @RequestMapping("/friend")
    public Friend getFriend() {
        return friend;
    }

    @RequestMapping("/friends")
    public List<FriendNameAndNumber> getNameAndNumbers() throws Exception {
        return friendDAO.getNamesAndNumber();
    }

    @RequestMapping("/addFriends")
    public String addFriends() {
        friendDAO.addFriend(friend);
        friendDAO.addFriend(friend1);
        friendDAO.addFriend(friend2);

        return "Friends Added to FriendList";
    }
}

/*
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
