package se.toneday.aoc.day;

import se.toneday.aoc.input.Input;
import se.toneday.aoc.utils.MatrixUtils;
import se.toneday.aoc.utils.records.Point;

import java.util.List;

/**
 * DAY 4
 * EXAMPLE INPUT:
 * SAXXAXMMSSSSSXMXMAMXSXMAMAMXXXAMXAXXMXMAXSXMMAMXXXMSSSSSMSSSSSSMSSMMXSAMMMMXSAMXSMMMSASASMXMASMMXSSMXSAMXSAMXMMXXXAMAMXMASXSSMSASXMXSMMMMXXM
 * MASXMSMAXAAAMMMAMAMSAMSXSAMSMSMMXMSSMMSAAXASAMSAMXAAAMAMXAASAASAAAASMMASMAAAMXSXAMAASXSASXMSXMASAXAAAAASAXAXAXMMSXMASMMMMSAMXAMMXASXXAAMMMSM
 * MAMAAAMXMMMMMAMAXASAMXAAMXAXAAXMAMXAAAMMXMAMAXSAAAMMSMAMMMXMMMMMMMMMAAAMMMMSSXXAMMMMXMMAMXAXASMMMSMMMSSMXSMSMSMAAAMAMAAMAMXMMXMASMMMSSMMSAAX
 * MXSMMMSASXSSSSXSXXMAXMMSMMSMSMSMMSSSMMXASMSMXMSXSXXMAXAXXMXSXSASMSMSSMSSXSAMMMMSXSXXXAMXMAXSMMAAAAAAXXAMMAXAAAMMMXMAMSMMAMMMSXMAAAAAMAAAMSSS
 * SMMMAXSXSAAAXAAXXXSAMXAAAXMXAAAASAMXAXMASAXASXMAXXMMMSXSXMSMASAXAAAXMAAXXMASAAMAXAAAASMSMSMSASXMSMSMMSAMMXXMMMSMXAMMXXXSASAAAAMSSSMSSMMMAAXA
 *
 * Task 1:
 * Find the word XMAS. It can be
 * horizontal, vertical, diagonal, written backwards, or even overlapping other words.
 * How many XMAS is there?
 *
 * Task 2:
 *
 */
public class Day4 implements Day{

    @Override
    public void run() {

        List<String> stringInput = Input.listStringRow("4");
        char[][] matrix = MatrixUtils.getCharMatrixPerRow(stringInput);

        // Task 1:

        List<Point> xPoints = MatrixUtils.getPointsWhereCharIsPresent(matrix, 'X');

        String stringToSearchFor = "MAS";
        int amountOfPresentXMAS = 0;

        for(Point xPoint : xPoints) {
            amountOfPresentXMAS += MatrixUtils.getTimesStringIsPresentInAllDirectionsFromStartPoint(matrix, xPoint, stringToSearchFor);
        }

        System.out.println("Day 4. Task 1 - The String XMAS is present: " + amountOfPresentXMAS + " times");
    }
}
