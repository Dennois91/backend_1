package com.example.backend_1.assignment_1;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class LuckyYouController {
    Random random = new Random();

    @RequestMapping("getLucky/list")
    private String getLuckyList(@RequestParam List<String> unluckyNumbers) {
        List<String> allNumbersList = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        List<Integer> possibleNumbers = new ArrayList<>();
        boolean allNumbers = unluckyNumbers.stream().allMatch(str -> str.matches("\\d+"));
        boolean hasMatch = true;
        String randomNumber = "";

        if (!allNumbers) {
            return "Only put numbers in the list";
        }

        unluckyNumbers = new java.util.ArrayList<>(unluckyNumbers.stream()
                .map(Integer::parseInt)
                .distinct()
                .sorted()
                .map(Objects::toString)
                .toList());

        if (unluckyNumbers.stream().mapToInt(Integer::parseInt).anyMatch(num -> num < 1 || num > 10)) {
            return "only put numbers 1-10";
        }

        if (unluckyNumbers.equals(allNumbersList)) {
            return "All numbers are unlucky!";
        }

        while (hasMatch) {
            randomNumber = Integer.toString(randomNumberGenerator());
            String finalRandomNumber = randomNumber;
            hasMatch = unluckyNumbers.stream().anyMatch(str -> str.equals(finalRandomNumber));
        }

        List<Integer> unluckyInts = unluckyNumbers.stream().map(Integer::parseInt).toList();

        for (int i = 1; i <= 10; i++) {
            if (!unluckyInts.contains(i)) {
                possibleNumbers.add(i);
            }
        }


        return "<html><body>Your lucky number is " + randomNumber +
                "<br>Possible numbers: " + possibleNumbers + "</body></html>";
    }

    @RequestMapping("/getLucky")
    private String getLucky(@RequestParam(required = false) String setType,
                            @RequestParam(required = false, defaultValue = "") String fName,
                            @RequestParam(required = false, defaultValue = "") String lName) {

        if (setType != null) {
            if (setType.equals("animal")) {
                return randomAnimal();
            } else if (setType.equals("number")) {
                return Integer.toString(randomNumberGenerator());
            }
        }

        if (fName.isEmpty() && lName.isEmpty()) {
            return "Din gamle galosch";
        }

        if (!fName.matches("^[A-Za-z]{0,20}$") || !lName.matches("^[A-Za-z]{0,20}$")) {
            return "Invalid name or surname entered";
        }

        int luckyNumber = randomNumberGenerator();
        return fName + " " + lName + ", ditt lyckonummer är: " + luckyNumber;
    }

    @RequestMapping("/getLuckyPathParam/{setType}")
    private String getLuckyPP(@PathVariable("setType") String setType){
        if (setType.equals("animal")) {
            return randomAnimal();
        }else if (setType.equals("number")){
            return Integer.toString(randomNumberGenerator());
        }
        else
            return "No valid path";
    }

    private int randomNumberGenerator() {
        return random.nextInt(10) + 1;
    }

    private String randomAnimal() {
        List<String> animals = Arrays.asList("hund", "katt", "spindel", "skata");
        return animals.get(random.nextInt(4));
    }
}

