package se.toneday.aoc.day;

import se.toneday.aoc.input.Input;
import se.toneday.aoc.utils.ListUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/*
 * DAY 1
 * EXAMPLE INPUT:
 * 14764   28773
 * 59598   86587
 * 63147   83451
 *
 * TASK 1:
 * Pair up the smallest number in the left list with the smallest number in the right list,
 * then the second-smallest left number with the second-smallest right number, and so on.
 * Within each pair, figure out how far apart the two numbers are;
 * you'll need to add up all of those distances.
 *
 * TASK 2:
 * This time, you'll need to figure out
 * exactly how often each number from the left list appears in the right list.
 * Calculate a total similarity score by
 * adding up each number in the left list
 * after multiplying it by the number of times that number appears in the right list.
 */
public class Day1 implements Day {

    @Override
    public void run() {

        var numbers = Input.listIntegerEach("1");
        var left = ListUtils.getEvenIndexAsList(numbers);
        var right = ListUtils.getOddIndexAsList(numbers);

        task1(left, right);
        task2(left, right);
    }

    public void task1(List<Integer> left, List<Integer> right) {

        left.sort(Comparator.naturalOrder());
        right.sort(Comparator.naturalOrder());

        int sum = 0;

        for (int i = 0; i < left.size(); i++) {
            sum +=  Math.abs(left.get(i) - right.get(i));
        }

        System.out.println("The sum of the difference are: " + sum);
    }

    public void task2(List<Integer> left, List<Integer> right) {

        int sum = 0;

        for(Integer number: left){
            var amountOfTimes = right.stream().filter(n -> Objects.equals(n, number)).toList().size();
            sum += amountOfTimes * number;
        }

        System.out.println("The total simularity score is: " + sum);
    }


}
