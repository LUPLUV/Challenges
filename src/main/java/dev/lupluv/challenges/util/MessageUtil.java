package dev.lupluv.challenges.util;

import dev.lupluv.challenges.Challenges;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageUtil {

    public static String getMessage(String key){
        assert Challenges.getInstance().getFileProvider().getSelectedLanguageFile().exists();
        return formatMessage(Challenges.getInstance().getFileProvider().getSelectedLanguageFile().asConfig().getString(key));
    }

    protected static String formatMessage(String message){
        String toReturn;
        Pattern pattern = Pattern.compile("");
        Matcher matcher = pattern.matcher(message);
        return message;
    }

}
