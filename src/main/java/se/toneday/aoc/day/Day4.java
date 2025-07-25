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
 * Find all occurrences of the word MAS that appear in an X shape.
 * Within the X, each MAS can be written forwards or backwards.
 * .M.S......
 * ..A..MSMS.
 * .M.S.MAA..
 * ..A.ASMSM.
 * .M.S.M....
 * ..........
 * S.S.S.S.S.
 * .A.A.A.A..
 * M.M.M.M.M.
 * ..........
 * In this example, an X-MAS appears 9 times.
 * How many MAS in an X shape is there?
 *
 */
public class Day4 implements Day{

    @Override
    public void run() {

        List<String> stringInput = Input.listStringRow("4");
        char[][] matrix = MatrixUtils.getCharMatrixPerRow(stringInput);

        // Task 1:
        // 1. Find all X in the matrix
        // 2. From each X, search for the word XMAS in all directions

        List<Point> startPointsX = MatrixUtils.getPointsWhereCharIsPresent(matrix, 'X');
        String stringToSearchFor = "XMAS";
        List<Point> startPointsWhereXMASisPresent = MatrixUtils.getStartPointsWhereStringIsPresentInAnyDirection(matrix, startPointsX, stringToSearchFor);
        int amountOfPresentXMAS = startPointsWhereXMASisPresent.size();

        System.out.println("Day 4. Task 1 - The String XMAS is present: " + amountOfPresentXMAS + " times");

        // Task 2:
        // 1. Find all M in the matrix
        // 2. From each M, search for the word MAS in all diagonal directions and get the position of the A where the word is found.
        // 3. Where 2 A positions are equal, an X of the word MAS is found since the A is shared between 2 MAS:es.
        //    By finding the amount of reductions made when making a distinct list of positions we find the answer.

        List<Point> startPointsM = MatrixUtils.getPointsWhereCharIsPresent(matrix, 'M');
        List<Point> middlePointsA = MatrixUtils.getDiagonalStringMiddlePointsInMatrix(matrix, startPointsM, "MAS");
        List<Point> distinct = middlePointsA.stream().distinct().toList();

        // counts amount of duplicates from middlePointsA list, these are the sum of the where 2 A:s meet, forming an X.
        int sumOfMASInX = middlePointsA.size() - distinct.size();

        System.out.println("Day 4. Task 1 - The String MAS in an X shape are present: " + sumOfMASInX + " times");
    }

}
