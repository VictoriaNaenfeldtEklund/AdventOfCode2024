package se.toneday.aoc;

import se.toneday.aoc.day.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Day> days = getDaysList();

        days.get(3).run();
    }

    public static List<Day> getDaysList(){

        List<Day> days = new ArrayList<>();
        days.add(new Day1());
        days.add(new Day1());
        days.add(new Day2());
        days.add(new Day3());

        return days;
    }
}
