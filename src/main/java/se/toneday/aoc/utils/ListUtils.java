package se.toneday.aoc.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListUtils {

    public static List<Integer> getEvenIndexAsList(List<Integer> list) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {

            if(i % 2 == 0) {
                result.add(list.get(i));
            }
        }

        return result;
    }

    public static List<Integer> getOddIndexAsList(List<Integer> list) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {

            if(i % 2 != 0) {
                result.add(list.get(i));
            }
        }

        return result;
    }

    public static List<List<Integer>> mapEachStringToListOfInteger(List<String> strings) {

        List<List<Integer>> result = new ArrayList<>();

        for(String row : strings) {

            Scanner scanner = new Scanner(row);
            List<Integer> listOfInteger = new ArrayList<>();

            while(scanner.hasNextInt()) {
                listOfInteger.add(scanner.nextInt());
            }
            result.add(listOfInteger);
            scanner.close();
        }

        return result;
    }

    public static boolean isRising(List<Integer> report, int minDiff, int maxDiff) {

        for(int i = 1; i < report.size(); i++){

            int previous = report.get(i-1);
            int level = report.get(i);
            int risingDiff = level - previous;

            if(risingDiff < minDiff || risingDiff > maxDiff){
                return false;
            }
        }
        return true;
    }

    public static boolean isDecreasing(List<Integer> report, int minDiff, int maxDiff) {

        for(int i = 1; i < report.size(); i++){

            int previous = report.get(i-1);
            int level = report.get(i);
            int decreasingDiff = previous - level;

            if(decreasingDiff < minDiff || decreasingDiff > maxDiff){
                return false;
            }
        }
        return true;
    }
}
