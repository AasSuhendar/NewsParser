/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpreprocessing;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Basis Data
 */

public class test2 {
    static List<String> lst = new ArrayList<String>();
    
    public static void main(String[] args) {
//        lst.add("a");
//        lst.add("b");
//        
//        String res = String.join(" ", lst);
//        System.out.println(res);
        String str = "abc";
        str=str.replaceFirst("a", "");
        System.out.println(str);
    }
}
