/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/binary-representation
@Language: Java
@Datetime: 16-12-31 18:25
*/

public class Solution {
    /**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     */
    private String parseInteger(String str) {
        int n = Integer.parseInt(str);
        if (str.equals("") || str.equals("0")) {
            return "0";
        }
        /*String binary = "";
        while (n != 0) {
            binary = Integer.toString(n % 2) + binary;
            n = n / 2;
        }*/
        return Integer.toBinaryString(n);
    }
    
    private String parseFloat(String str) {
        double d = Double.parseDouble("0." + str);
        String binary = "";
        //HashSet<Double> set = new HashSet<Double>();
        while (d > 0) {
            if (binary.length() > 32/* || set.contains(d)*/) {
                return "ERROR";
            }
            //set.add(d);
            d = d * 2;
            if (d >= 1) {
                binary = binary + "1";
                d = d - 1;
            } else {
                binary = binary + "0";
            }
        }
        return binary;
    }
    
    public String binaryRepresentation(String n) {
        if (n.indexOf('.') == -1) {
            return parseInteger(n);
        }
        String[] params = n.split("\\.");
        String flt = parseFloat(params[1]);
        if (flt == "ERROR") {
            return flt;
        }
        if (flt.equals("0") || flt.equals("")) {
            return parseInteger(params[0]);
        }
        return parseInteger(params[0]) + "." + flt;
    }
}