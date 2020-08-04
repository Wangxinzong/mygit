package com.wxz.personal.myproject.regular_expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularClass {
    String regex = "";

    public boolean matcherPhone(String... phones) {
        regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,1,2,5-9])|(177))\\d{8}$";
        Pattern pattern = Pattern.compile(regex);
        if (phones == null) {
            return false;
        }
        for (String phone : phones) {
            Matcher matcher = pattern.matcher(phone);
            return matcher.matches();
        }
        return false;
    }

    public void testMatcherMethod() {
        String parameter = "Java  is very easy!";
        regex = "\\w+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(parameter);

        while (matcher.find()) {
            System.out.println("group:" + matcher.group(1) + ",start:" + matcher.start(1) + ",end:" + matcher.end());
        }
    }

}
