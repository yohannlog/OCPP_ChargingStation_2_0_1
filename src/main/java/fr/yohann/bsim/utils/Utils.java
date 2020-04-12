package fr.yohann.bsim.utils;

import com.jfoenix.validation.RegexValidator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Utils
{

    public static String getActualTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'").withZone(ZoneId.of("UTC"));
        return formatter.format(new Date().toInstant());
    }

    public static Date parseRFC3339Date(String dateString) throws java.text.ParseException, IndexOutOfBoundsException {
        Date d;

        //if there is no time zone, we don't need to do any special parsing.
        if (dateString.endsWith("Z")) {
            try {
                SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());//spec for RFC3339 with a 'Z'
                s.setTimeZone(TimeZone.getTimeZone("UTC"));
                d = s.parse(dateString);
            } catch (java.text.ParseException pe) {//try again with optional decimals
                SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'", Locale.getDefault());//spec for RFC3339 with a 'Z' and fractional seconds
                s.setTimeZone(TimeZone.getTimeZone("UTC"));
                s.setLenient(true);
                d = s.parse(dateString);
            }
            return d;
        }

        //step one, split off the timezone.
        String firstPart;
        String secondPart;
        if (dateString.lastIndexOf('+') == -1) {
            firstPart = dateString.substring(0, dateString.lastIndexOf('-'));
            secondPart = dateString.substring(dateString.lastIndexOf('-'));
        } else {
            firstPart = dateString.substring(0, dateString.lastIndexOf('+'));
            secondPart = dateString.substring(dateString.lastIndexOf('+'));
        }

        //step two, remove the colon from the timezone offset
        secondPart = secondPart.substring(0, secondPart.indexOf(':')) + secondPart.substring(secondPart.indexOf(':') + 1);
        dateString = firstPart + secondPart;
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.getDefault());//spec for RFC3339
        try {
            d = s.parse(dateString);
        } catch (java.text.ParseException pe) {//try again with optional decimals
            s = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ", Locale.getDefault());//spec for RFC3339 (with fractional seconds)
            s.setLenient(true);
            d = s.parse(dateString);
        }
        return d;
    }

    public static String getDateToString(Date date) {
        String dateString;
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());//spec for RFC3339 with a 'Z'
        s.setTimeZone(TimeZone.getTimeZone("UTC"));
        dateString = s.format(date);
        return dateString;
    }

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty() || s.isBlank();
    }

    public static boolean isIdentifierString(String stringToVerify) {
        return stringToVerify.matches("^([a-zA-Z0-9*\\-_:+|@.]*)$");
    }
}
