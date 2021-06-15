package com.UniofBath2;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

// this should check that the string is compatible with an int
public class IntegerHandling {
    /*public boolean isStringInt(String s) {
        if (parseLong(s) > 2147483647 || parseLong(s) < -2147483648) {
            return true;
        } else {
            return false;
        }
    }*/
    public static boolean willAdditionOverflow(int left, int right) {
        try {
            Math.addExact(left, right);
            return false;
        } catch (ArithmeticException e) {
            return true;
        }
    }

    public static boolean willSubtractionOverflow(int left, int right) {
        try {
            Math.subtractExact(left, right);
            return false;
        } catch (ArithmeticException e) {
            return true;
        }
    }
}



/*public string calculation(String s){
    if (s == "+" || s=="-"||s=="*"||s=="/" ){
        string operand = s;
        return operand;
} else if( )*/
        /*if (s == null) {
            return false;
        }
        int length = s.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (s.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }*/

