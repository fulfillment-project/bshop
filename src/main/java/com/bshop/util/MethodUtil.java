package com.bshop.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MethodUtil {

    public static String ChangeDateToString(LocalDateTime date){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        return dateTimeFormatter.format(date);
    }

    public static String changeImageUrl(String rest, String url, String folder, String image){
        if(rest.equals("rest")){
            return url + folder + image;
        } else {
            return image;
        }
    }
}
