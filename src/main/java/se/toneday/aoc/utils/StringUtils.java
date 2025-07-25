package se.toneday.aoc.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static String replacePatternFromStringWithReplacement(String string, String pattern, String replacement) {

        Pattern patterDontUntilDo = Pattern.compile(pattern);
        Matcher matcher = patterDontUntilDo.matcher(string);

        while(matcher.find()) {
            string = string.replace(matcher.group(), replacement);
        }

        return string;
    }

    public static boolean isEven(String string) {
        return string.length() % 2 == 0;
    }

}
