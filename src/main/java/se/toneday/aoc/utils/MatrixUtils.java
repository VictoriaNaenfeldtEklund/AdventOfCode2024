package se.toneday.aoc.utils;

import se.toneday.aoc.utils.records.Point;

import java.util.ArrayList;
import java.util.List;

public class MatrixUtils {

    public static char[][] getCharMatrixPerRow(List<String> stringList) {

        char[][] matrix = new char[stringList.size()][];

        for (int i = 0; i < stringList.size(); i++) {
            matrix[i] = stringList.get(i).toCharArray();
        }

        return matrix;
    }

    public static List<Point> getPointsWhereCharIsPresent(char[][] matrix, char charToSearchFor) {

        List<Point> points = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] == charToSearchFor) {
                    points.add(new Point(i, j));
                }

            }
        }

        return points;
    }

    public static List<Point> getStartPointsWhereStringIsPresentInAnyDirection(char[][] matrix, List<Point> startPoints, String stringToSearchFor) {

        List<Point> startPointsWhereStringIsPresent = new ArrayList<>();

        for(Point startPoint : startPoints) {

            int startRow = startPoint.x();
            int startCol = startPoint.y();


            if(isStringPresentEast(matrix, stringToSearchFor, startRow, startCol)){
                startPointsWhereStringIsPresent.add(new Point(startRow, startCol));
            }

            if(isStringPresentSouthEast(matrix, stringToSearchFor, startRow, startCol)){
                startPointsWhereStringIsPresent.add(new Point(startRow, startCol));
            }

            if(isStringPresentSouth(matrix, stringToSearchFor, startRow, startCol)){
                startPointsWhereStringIsPresent.add(new Point(startRow, startCol));
            }

            if(isStringPresentSouthWest(matrix, stringToSearchFor, startRow, startCol)){
                startPointsWhereStringIsPresent.add(new Point(startRow, startCol));
            }

            if(isStringPresentWest(matrix, stringToSearchFor, startRow, startCol)){
                startPointsWhereStringIsPresent.add(new Point(startRow, startCol));
            }

            if(isStringPresentNorthWest(matrix, stringToSearchFor, startRow, startCol)){
                startPointsWhereStringIsPresent.add(new Point(startRow, startCol));
            }

            if(isStringPresentNorth(matrix, stringToSearchFor, startRow, startCol)){
                startPointsWhereStringIsPresent.add(new Point(startRow, startCol));
            }

            if(isStringPresentNorthEast(matrix, stringToSearchFor, startRow, startCol)){
                startPointsWhereStringIsPresent.add(new Point(startRow, startCol));
            }
        }

        return startPointsWhereStringIsPresent;
    }

    /*
    Returns the position where the middle character of an uneven string placed on the diagonal is present in a matrix.
    Ex: Looking for the word MAS in this 3x3 grid would return a list with the Point(1,1) for the middle char A:s position in the matrix
    I I S
    I A I
    M I I
     */
    public static List<Point> getDiagonalStringMiddlePointsInMatrix(char[][] matrix, List<Point> startPoints, String stringToSearchFor) throws IllegalArgumentException {

        if(StringUtils.isEven(stringToSearchFor)) {
            throw new IllegalArgumentException("stringToSearchFor must not be even");
        }

        List<Point> middlePoints = new ArrayList<>();
        int stepsToMiddleChar = stringToSearchFor.length() / 2;

        for (Point startPoint : startPoints) {

            int startRow = startPoint.x();
            int startCol = startPoint.y();

            if(isStringPresentSouthEast(matrix, stringToSearchFor, startRow, startCol)){
                middlePoints.add(new Point(startRow + stepsToMiddleChar, startCol + stepsToMiddleChar));
            }

            if(isStringPresentSouthWest(matrix, stringToSearchFor, startRow, startCol)){
                middlePoints.add(new Point(startRow + stepsToMiddleChar, startCol - stepsToMiddleChar));
            }

            if(isStringPresentNorthWest(matrix, stringToSearchFor, startRow, startCol)){
                middlePoints.add(new Point(startRow - stepsToMiddleChar, startCol - stepsToMiddleChar));
            }

            if(isStringPresentNorthEast(matrix, stringToSearchFor, startRow, startCol)){
                middlePoints.add(new Point(startRow - stepsToMiddleChar, startCol + stepsToMiddleChar));
            }
        }

        return middlePoints;
    }

    public static boolean isStringPresentEast(char[][] matrix, String stringToSearchFor, int startRow, int startCol) {

        for (char charToSearchFor : stringToSearchFor.toCharArray()) {

            if (!isCharPresent(matrix, charToSearchFor, startRow, startCol++)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isStringPresentSouthEast(char[][] matrix, String stringToSearchFor, int startRow, int startCol) {

        for (char charToSearchFor : stringToSearchFor.toCharArray()) {

            if (!isCharPresent(matrix, charToSearchFor, startRow++, startCol++)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isStringPresentSouth(char[][] matrix, String stringToSearchFor, int startRow, int startCol) {

        for (char charToSearchFor : stringToSearchFor.toCharArray()) {

            if (!isCharPresent(matrix, charToSearchFor, startRow++, startCol)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isStringPresentSouthWest(char[][] matrix, String stringToSearchFor, int startRow, int startCol) {

        for (char charToSearchFor : stringToSearchFor.toCharArray()) {

            if (!isCharPresent(matrix, charToSearchFor, startRow++, startCol--)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isStringPresentWest(char[][] matrix, String stringToSearchFor, int startRow, int startCol) {

        for (char charToSearchFor : stringToSearchFor.toCharArray()) {

            if (!isCharPresent(matrix, charToSearchFor, startRow, startCol--)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isStringPresentNorthWest(char[][] matrix, String stringToSearchFor, int startRow, int startCol) {

        for (char charToSearchFor : stringToSearchFor.toCharArray()) {

            if (!isCharPresent(matrix, charToSearchFor, startRow--, startCol--)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isStringPresentNorth(char[][] matrix, String stringToSearchFor, int startRow, int startCol) {

        for (char charToSearchFor : stringToSearchFor.toCharArray()) {

            if (!isCharPresent(matrix, charToSearchFor, startRow--, startCol)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isStringPresentNorthEast(char[][] matrix, String stringToSearchFor, int startRow, int startCol) {

        for (char charToSearchFor : stringToSearchFor.toCharArray()) {

            if (!isCharPresent(matrix, charToSearchFor, startRow--, startCol++)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isCharPresent(char[][] matrix, char charToSearchFor, int row, int col) {

        try {

            if (matrix[row][col] == charToSearchFor) {
                return true;
            }

        } catch (IndexOutOfBoundsException _) {
            return false;
        }

        return false;
    }

}
