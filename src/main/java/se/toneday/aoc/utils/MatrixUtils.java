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

    public static int getTimesStringIsPresentInAllDirectionsFromStartPoint(char[][] matrix, Point startPoint, String stringToSearchFor) {

        int startRow = startPoint.x();
        int startCol = startPoint.y();

        int sumOfPresentStrings = 0;

        if(isStringPresentEast(matrix, stringToSearchFor, startRow, startCol)){
            sumOfPresentStrings++;
        }

        if(isStringPresentSouthEast(matrix, stringToSearchFor, startRow, startCol)){
            sumOfPresentStrings++;
        }

        if(isStringPresentSouth(matrix, stringToSearchFor, startRow, startCol)){
            sumOfPresentStrings++;
        }

        if(isStringPresentSouthWest(matrix, stringToSearchFor, startRow, startCol)){
            sumOfPresentStrings++;
        }

        if(isStringPresentWest(matrix, stringToSearchFor, startRow, startCol)){
            sumOfPresentStrings++;
        }

        if(isStringPresentNorthWest(matrix, stringToSearchFor, startRow, startCol)){
            sumOfPresentStrings++;
        }

        if(isStringPresentNorth(matrix, stringToSearchFor, startRow, startCol)){
            sumOfPresentStrings++;
        }

        if(isStringPresentNorthEast(matrix, stringToSearchFor, startRow, startCol)){
            sumOfPresentStrings++;
        }

        return sumOfPresentStrings;
    }

    public static int getTimesStringIsPresentInAllDiagonalDirectionsFromStartPoint(char[][] matrix, Point startPoint, String stringToSearchFor) {

        int startRow = startPoint.x();
        int startCol = startPoint.y();
        int sumOfPresentStrings = 0;

        if(isStringPresentSouthEast(matrix, stringToSearchFor, startRow, startCol)){
            sumOfPresentStrings++;
        }

        if(isStringPresentSouthWest(matrix, stringToSearchFor, startRow, startCol)){
            sumOfPresentStrings++;
        }

        if(isStringPresentNorthWest(matrix, stringToSearchFor, startRow, startCol)){
            sumOfPresentStrings++;
        }

        if(isStringPresentNorthEast(matrix, stringToSearchFor, startRow, startCol)){
            sumOfPresentStrings++;
        }

        return sumOfPresentStrings;

    }

    /*
    Returns the position where the middle character of an uneven string placed on the diagonal is present in a matrix.
    Ex: Looking for the word MAS in this 3x3 grid would return a list with the Point(2,2) for the middle char A:s position in the matrix
    I I S
    I A I
    M I I
     */
    public static List<Point> getDiagonalStringMiddlePointsInMatrix(char[][] matrix, List<Point> startPoints, String stringToSearchFor) throws IllegalArgumentException {

        if((stringToSearchFor.length() + 1) % 2 == 0) {
            throw new IllegalArgumentException("stringToSearchFor must not be even");
        }

        List<Point> middlePoints = new ArrayList<>();
        int stepsToMiddleChar = (stringToSearchFor.length() + 1) / 2;

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

            if (!isCharPresent(matrix, charToSearchFor, startRow, ++startCol)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isStringPresentSouthEast(char[][] matrix, String stringToSearchFor, int startRow, int startCol) {

        // go through all chars in the string
        for (char charToSearchFor : stringToSearchFor.toCharArray()) {

            // Check if the character is not present in the next east index, in that case, return false
            // isCharPresent checks for IndexOutOfBounds
            if (!isCharPresent(matrix, charToSearchFor, ++startRow, ++startCol)) {
                return false;
            }
        }

        // if all characters is present in the east direction, return true.
        return true;
    }

    public static boolean isStringPresentSouth(char[][] matrix, String stringToSearchFor, int startRow, int startCol) {

        for (char charToSearchFor : stringToSearchFor.toCharArray()) {

            if (!isCharPresent(matrix, charToSearchFor, ++startRow, startCol)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isStringPresentSouthWest(char[][] matrix, String stringToSearchFor, int startRow, int startCol) {

        for (char charToSearchFor : stringToSearchFor.toCharArray()) {

            if (!isCharPresent(matrix, charToSearchFor, ++startRow, --startCol)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isStringPresentWest(char[][] matrix, String stringToSearchFor, int startRow, int startCol) {

        for (char charToSearchFor : stringToSearchFor.toCharArray()) {

            if (!isCharPresent(matrix, charToSearchFor, startRow, --startCol)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isStringPresentNorthWest(char[][] matrix, String stringToSearchFor, int startRow, int startCol) {

        for (char charToSearchFor : stringToSearchFor.toCharArray()) {

            if (!isCharPresent(matrix, charToSearchFor, --startRow, --startCol)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isStringPresentNorth(char[][] matrix, String stringToSearchFor, int startRow, int startCol) {

        for (char charToSearchFor : stringToSearchFor.toCharArray()) {

            if (!isCharPresent(matrix, charToSearchFor, --startRow, startCol)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isStringPresentNorthEast(char[][] matrix, String stringToSearchFor, int startRow, int startCol) {

        for (char charToSearchFor : stringToSearchFor.toCharArray()) {

            if (!isCharPresent(matrix, charToSearchFor, --startRow, ++startCol)) {
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
