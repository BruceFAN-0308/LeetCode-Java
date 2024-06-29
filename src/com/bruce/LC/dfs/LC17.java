package com.bruce.LC.dfs;

import java.util.*;

public class LC17 {
    public List<String> letterCombinations(String digits) {
        int length = digits.length();
        if (length == 0) {
            return new ArrayList<>();
        }

        List<String> list = new ArrayList<>();
        for (Character c : getCharacter(digits.charAt(length - 1))) {
            list.add(c.toString());
        }

        for (int i = length - 2; i >= 0; i--) {
            Character pop = digits.charAt(i);
            List<String> temp = new ArrayList<>();
            List<Character> character = getCharacter(pop);
            for (Character c : character) {
                for (String s : list) {
                    temp.add(c + s);
                }
            }
            list = temp;
        }

        return list;
    }

    private List<Character> getCharacter(Character c) {
        switch (c) {
            case '2':
                return Arrays.asList('a', 'b', 'c');
            case '3':
                return Arrays.asList('d', 'e', 'f');
            case '4':
                return Arrays.asList('g', 'h', 'i');
            case '5':
                return Arrays.asList('j', 'k', 'l');
            case '6':
                return Arrays.asList('m', 'n', 'o');
            case '7':
                return Arrays.asList('p', 'q', 'r', 's');
            case '8':
                return Arrays.asList('t', 'u', 'v');
            case '9':
                return Arrays.asList('w', 'x', 'y', 'z');
            default:
                return new ArrayList<>();

        }
    }

    public static void main(String[] args) {
        for (String s : new LC17().letterCombinations("234")) {
            System.out.println(s);
        }
    }
}
