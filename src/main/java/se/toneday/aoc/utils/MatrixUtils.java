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
