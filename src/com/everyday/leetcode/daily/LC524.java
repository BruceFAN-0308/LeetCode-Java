package com.everyday.leetcode.daily;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @description:
 * @author: Luoxin Fan
 * @create: 2024-06-17 15:42
 **/
public class LC524 {

    public String findLongestWord(String s, List<String> dictionary) {
        String result = "";

        for (String string : dictionary) {
            if (string.length() > s.length()) {
                continue;
            }
            Integer originalIndex = 0;
            Integer targetIndex = 0;
            while (originalIndex < s.length() && targetIndex < string.length()) {
                if (s.charAt(originalIndex) == string.charAt(targetIndex)) {
                    targetIndex++;
                }
                originalIndex++;

                if (targetIndex == string.length()) {
                    if (string.length() > result.length()
                            || (string.length() == result.length() && result.compareTo(string) > 0)) {
                        result = string;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        System.out.println(new LC524().findLongestWord("abce", Arrays.asList("abe", "abc")));
        System.out.println(new LC524().findLongestWord("wsmzffsupzgauxwokahurhhikapmqitytvcgrfpavbxbmmzdhnrazartkzrnsmoovmiofmilihynvqlmwcihkfskwozyjlnpkgdkayioieztjswgwckmuqnhbvsfoevdynyejihombjppgdgjbqtlauoapqldkuhfbynopisrjsdelsfspzcknfwuwdcgnaxpevwodoegzeisyrlrfqqavfziermslnlclbaejzqglzjzmuprpksjpqgnohjjrpdlofruutojzfmianxsbzfeuabhgeflyhjnyugcnhteicsvjajludwizklkkosrpvhhrgkzctzwcghpxnbsmkxfydkvfevyewqnzniofhsriadsoxjmsswgpiabcbpdjjuffnbvoiwotrbvylmnryckpnyemzkiofwdnpnbhkapsktrkkkakxetvdpfkdlwqhfjyhvlxgywavtmezbgpobhikrnebmevthlzgajyrmnbougmrirsxi"
                , Arrays.asList("ale", "apple", "monkey", "plea", "abpcplaaa", "abpcllllll", "abccclllpppeeaaaa")));
    }
}
