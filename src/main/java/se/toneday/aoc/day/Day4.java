package se.toneday.aoc.day;

import se.toneday.aoc.input.Input;
import se.toneday.aoc.utils.MatrixUtils;
import se.toneday.aoc.utils.records.Point;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        List<Point> xPoints = MatrixUtils.getPointsWhereCharIsPresent(matrix, 'X');

        String stringToSearchFor = "MAS";
        int amountOfPresentXMAS = 0;

        for(Point xPoint : xPoints) {
            amountOfPresentXMAS += MatrixUtils.getTimesStringIsPresentInAllDirectionsFromStartPoint(matrix, xPoint, stringToSearchFor);
        }

        System.out.println("Day 4. Task 1 - The String XMAS is present: " + amountOfPresentXMAS + " times");

        // Task 2:
//        List<Point> aPoints = MatrixUtils.getPointsWhereCharIsPresent(matrix, 'A');
//        int amountOfPresentMAS = getAmountOfPresentMAS(aPoints, matrix);
//
//        System.out.println("Day 4. Task 2 - The String MAS is present: " + amountOfPresentMAS + " times");

        // get all M
        List<Point> mPoints = MatrixUtils.getPointsWhereCharIsPresent(matrix, 'M');
        List<Point> aPoints = MatrixUtils.getDiagonalStringMiddlePointsInMatrix(matrix, mPoints, "AS");
        List<Point> distinct = aPoints.stream().distinct().toList();

        int sumOfMASInX = aPoints.size() - distinct.size();

        System.out.println("Day 4. Task 1 - The String MAS in an X shape are present: " + sumOfMASInX + " times");
    }

    private static int getAmountOfPresentMAS(List<Point> aPoints, char[][] matrix) {
        int amountOfPresentMAS = 0;

        for(Point aPoint : aPoints) {

            int row = aPoint.x();
            int col = aPoint.y();

            if(MatrixUtils.isStringPresentNorthWest(matrix, "M", row, col)){
                if(MatrixUtils.isStringPresentSouthEast(matrix, "S", row, col)){
                    if(MatrixUtils.isStringPresentNorthEast(matrix, "M", row, col)){
                        if(MatrixUtils.isStringPresentSouthWest(matrix, "S", row, col)){
                            amountOfPresentMAS++;
                        }
                    } else if(MatrixUtils.isStringPresentNorthEast(matrix, "S", row, col)){
                        if(MatrixUtils.isStringPresentSouthWest(matrix, "M", row, col)){
                            amountOfPresentMAS++;
                        }
                    }
                }

            } else if(MatrixUtils.isStringPresentNorthWest(matrix, "S", row, col)){
                if(MatrixUtils.isStringPresentSouthEast(matrix, "M", row, col)){
                    if(MatrixUtils.isStringPresentNorthEast(matrix, "M", row, col)){
                        if(MatrixUtils.isStringPresentSouthWest(matrix, "S", row, col)){
                            amountOfPresentMAS++;
                        }
                    } else if(MatrixUtils.isStringPresentNorthEast(matrix, "S", row, col)){
                        if(MatrixUtils.isStringPresentSouthWest(matrix, "M", row, col)){
                            amountOfPresentMAS++;
                        }
                    }
                }
            }
        }
        return amountOfPresentMAS;
    }
}
