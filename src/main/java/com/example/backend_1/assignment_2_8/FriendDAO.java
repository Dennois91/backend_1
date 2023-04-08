package com.example.backend_1.assignment_2_8;

import java.util.ArrayList;
import java.util.List;

public class FriendDAO {

    List<Friend> friendList = new ArrayList<>();

    public void addFriend(Friend friend) {
        friendList.add(friend);
    }

    public List<FriendNameAndNumber> getNamesAndNumber() throws Exception {
        List<FriendNameAndNumber> result = new ArrayList<>();

        for (Friend friend : friendList) {
            FriendNameAndNumber f = new FriendNameAndNumber("", "");
            f.name = friend.getNames().get(0) + " Nickname: "+  friend.getNames().get(1);
            f.number = friend.getTelefonnummer().get(0);
            result.add(f);
        }
        return result;
    }
}

/*
Uppgift 3 – Telefonboken som Web Service (lista alla kompisar)
        • Gör en web service där du kan lista dina vänners namn och telefonnummer på JSON
        • Dina vänner ska lagras i en KompisDAO-klass
        • Det ska gå att anropa web servicen från en webbläsare och alla vänners namn och
        telefonnummer ska skrivas ut på JSON
        • För er som blir klara snabbt, bygg ut Kompis-modellen till att även innehålla nick, kunna ha
        flera telefonnummer, ha en födelsedag och kunna ha flera adresser.*/