package lessen2;

import java.util.Scanner;
import java.util.HashMap;


public class calculator {
    public static void main(String[] agrs) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        String[] arrElement = str.split(" ");

        String[] signs = {"+", "-", "*", "/"};
        String[] arbi = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] rim = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] rimMore = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIV", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "Xl", "XlI", "XlII", "XlIII", "XlIV", "XlV", "XlVI", "XlVII", "XlVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "lV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX",  "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        int sumRoma = 0;
        HashMap<String, Integer> mapRim = new HashMap<>();
        mapRim.put("I", 1);
        mapRim.put("II", 2);
        mapRim.put("III", 3);
        mapRim.put("IV", 4);
        mapRim.put("V", 5);
        mapRim.put("VI", 6);
        mapRim.put("VII", 7);
        mapRim.put("VIII", 8);
        mapRim.put("IX", 9);
        mapRim.put("X", 10);

        pod(arrElement);
        String s = checkSigns(signs, arrElement);

        String x1 = checkElement1(arbi, rim, arrElement);
        String x2 = checkElement2(arbi, rim, arrElement);
        if (x1 != x2) {
            throw new RuntimeException("некорректно введены значения");
        }

        if (x1 == "a" & x2 == "a") {
            System.out.print(sumArab(s, arrElement));
        } else {
            if (s == "+") {
                sumRoma = mapRim.get(arrElement[0]) + mapRim.get(arrElement[2]);
            }
            if (s == "-") {
                if (mapRim.get(arrElement[0]) <= mapRim.get(arrElement[2])) {
                    throw new RuntimeException("некорректно введены значения");
                }
                sumRoma = mapRim.get(arrElement[0]) - mapRim.get(arrElement[2]);
            }
            if (s == "*") {
                sumRoma = mapRim.get(arrElement[0]) * mapRim.get(arrElement[2]);
            }
            if (s == "/") {
                sumRoma = mapRim.get(arrElement[0]) / mapRim.get(arrElement[2]);
            }

            System.out.print(rimMore[sumRoma-1]);
        }




    }


    static void pod(String[] arr) {
        if (arr.length != 3) {
            throw new RuntimeException("некорректно введены значения");
        }


    }

    static String checkSigns(String[] sings, String[] arrElement){
        for(String x : sings){
            if(x.equals(arrElement[1])){
                return x;
            }
        }
        throw new RuntimeException("некорректно введены значения");

    }

    static String checkElement1(String[] arbi, String[] rim, String[] arrElement) {
        for (String x : arbi) {
            if (x.equals(arrElement[0])) {
                return "a";
            }
        }
        for(String x : rim){
            if(x.equals(arrElement[0])){
                return "r";
            }
        }
        throw new RuntimeException("некорректно введены значения");
    }

    static String checkElement2(String[] arbi, String[] rim, String[] arrElement) {
        for (String x : arbi) {
            if (x.equals(arrElement[2])) {
                return "a";
            }
        }
        for(String x : rim){
            if(x.equals(arrElement[2])){
                return "r";
            }
        }
        throw new RuntimeException("некорректно введены значения");
    }

    static int sumArab(String s, String[] arrElement){
        if (s=="+"){
             return (Integer.valueOf(arrElement[0]) + Integer.valueOf(arrElement[2]));
        }
        if (s=="-"){
            return (Integer.valueOf(arrElement[0]) - Integer.valueOf(arrElement[2]));
        }
        if (s=="*"){
            return (Integer.valueOf(arrElement[0]) * Integer.valueOf(arrElement[2]));
        }
        if (s=="/"){
            return (Integer.valueOf(arrElement[0]) / Integer.valueOf(arrElement[2]));
        }
        throw new RuntimeException("некорректно введены значения");
    }












}
