package se.toneday.aoc.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    public static List<Integer> listIntegerEach(String day){

        List<Integer> list = new ArrayList<>();

        try{

            Scanner scanner = new Scanner(new File(getUrl(day)));

            while(scanner.hasNext()){
                if(scanner.hasNextInt()){
                    list.add(scanner.nextInt());
                }
            }

            scanner.close();

        } catch (NullPointerException np){
            System.out.println("Could not read file from url");
        } catch (FileNotFoundException e){
            System.out.println("Scanner source not found");
        }

        return list;
    }

    public static List<String> listStringRow(String day){

        List<String> list = new ArrayList<>();

        try{

            Scanner scanner = new Scanner(new File(getUrl(day)));

            while(scanner.hasNext()){
                list.add(scanner.nextLine());
            }

            scanner.close();

        } catch (NullPointerException np){
            System.out.println("Could not read file from url");
        } catch (FileNotFoundException e){
            System.out.println("Scanner source not found");
        }

        return list;
    }

    public static String getStringSingle(String day) {

        String result = "";

        try{

            Scanner scanner = new Scanner(new File(getUrl(day)));

            while(scanner.hasNext()){
                result += scanner.nextLine();
            }

            scanner.close();

        } catch (NullPointerException np){
            System.out.println("Could not read file from url");
        } catch (FileNotFoundException e){
            System.out.println("Scanner source not found");
        }

        return result;

    }

    private static String getUrl(String day) {
        return "src/main/resources/input/Day" + day + ".txt";
    }
}
