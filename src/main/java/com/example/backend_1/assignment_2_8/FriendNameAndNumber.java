package com.example.backend_1.assignment_2_8;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class FriendNameAndNumber {
    String name;
    String number;
}
