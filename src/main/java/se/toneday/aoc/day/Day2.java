package se.toneday.aoc.day;

import se.toneday.aoc.input.Input;

import java.util.ArrayList;
import java.util.List;

import static se.toneday.aoc.utils.ListUtils.*;

/*
 * DAY 2
 * EXAMPLE INPUT:
 * 18 21 22 24 26 29 28
 * 9 11 14 17 18 21 21
 * 48 51 54 56 60
 *
 * TASK 1:
 * A report (row) only counts as safe if both of the following are true:
 *      - The levels are either all increasing or all decreasing.
 *      - Any two adjacent levels differ by at least one and at most three.
 * How many reports are safe?
 *
 * TASK 2:
 * A report (row) only counts as safe if the following are true:
 *      - The levels are either all increasing or all decreasing.
 *      - Any two adjacent levels differ by at least one and at most three.
 *      - If removing one level would make the report safe.
 * How many reports are safe?
 */
public class Day2 implements Day {

    @Override
    public void run() {

        List<String> input = Input.listStringRow("2");
        List<List<Integer>> reports = mapEachStringToListOfInteger(input);

        int sumTask1 = task1(reports);
        int sumTask2 = task2(reports);

        System.out.println("Day 2. Task 1 - The number of safe reports: " + sumTask1);
        System.out.println("Day 2. Task 2 - The number of safe reports: " + sumTask2);
    }

    private int task1(List<List<Integer>> reports) {

        int sumOfSafeReports = 0;

        for(List<Integer> report : reports) {
            if(isRising(report, 1, 3)){
                sumOfSafeReports++;
            } else if (isDecreasing(report, 1, 3)){
                sumOfSafeReports++;
            }
        }

        return sumOfSafeReports;
    }

    private int task2(List<List<Integer>> reports) {

        int sumOfSafeReports = 0;

        for(List<Integer> report : reports) {
            for(int i = 0; i < report.size(); i++){

                List<Integer> copyReport = new ArrayList<>(report);
                copyReport.remove(i);

                if(isRising(copyReport, 1, 3)){
                    sumOfSafeReports++;
                    break;
                } else if(isDecreasing(copyReport, 1,3)){
                    sumOfSafeReports++;
                    break;
                }
            }
        }

        return sumOfSafeReports;
    }
}
