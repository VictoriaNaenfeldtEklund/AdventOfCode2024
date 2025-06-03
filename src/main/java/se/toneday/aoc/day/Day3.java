package se.toneday.aoc.day;

import se.toneday.aoc.input.Input;
import se.toneday.aoc.utils.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * DAY 3
 * EXAMPLE INPUT:
 * xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))
 *
 * Task1:
 * Find multiplication instructions like mul(X,Y), where X and Y are each 1-3 digit numbers.
 * For instance, mul(44,46) multiplies 44 by 46 to get a result of 2024. Similarly, mul(123,4) would multiply 123 by 4.
 * Sequences like mul(4*, mul(6,9!, ?(12,34), or mul ( 2 , 4 ) do nothing.
 *
 * What do you get if you add up all the results of the multiplications?
 *
 * Task 2:
 * There are two new instructions you'll need to handle:
 *
 * The do() instruction enables future mul instructions.
 * The don't() instruction disables future mul instructions.
 * Only the most recent do() or don't() instruction applies. At the beginning of the program, mul instructions are enabled.
 *
 * What do you get if you add up all the results of just the enabled multiplications?
 */
public class Day3 implements Day {

    @Override
    public void run() {

        String input = Input.getStringSingle("3");

        // Task 1:
        System.out.println("The sum of the multiplication for task 1 is: " + getSum(input));

        // Task 2:
        input = StringUtils.replacePatternFromStringWithReplacement(input, "don't\\(\\).*?do\\(\\)", "");
        input = StringUtils.replacePatternFromStringWithReplacement(input, "don't\\(\\).*", "");

        System.out.println("The sum of the multiplication for task 2 is: " + getSum(input));

    }

    private static long getSum(String input) {
        long sum = 0;

        Pattern patternMul = Pattern.compile("mul\\(([0-9]{1,3}),([0-9]{1,3})\\)");
        Matcher matcher = patternMul.matcher(input);

        while(matcher.find()) {
            sum += Long.parseLong(matcher.group(1)) * Long.parseLong(matcher.group(2));
        }
        return sum;
    }
}
