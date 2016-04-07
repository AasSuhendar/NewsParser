/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpreprocessing;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Basis Data
 */
public class test {

    public void listFilesForFolder( File folder) {
        for ( File fileEntry : folder.listFiles()) {
//            if (fileEntry.isDirectory()) {
//                listFilesForFolder(fileEntry);
//            } else {
                System.out.println(fileEntry.getAbsolutePath());
            }
        }
    

    public static void main(String[] args) {
         File folder = new File("C:\\Users\\Basis Data\\Documents\\berita");
        test t = new test();
        t.listFilesForFolder(folder);

//        String charToDel = ">[],-";
//        String pat = "[" + Pattern.quote(charToDel) + "]";
//        String str = "a>b[c]d,e-f";
//        System.out.println(str);
//        str = str.replaceAll(pat, "");
//        System.out.println(str);
//        String s = "Here just one \"comillas\"";
//        
//
////        s = s.substring(s.indexOf("(") + 1);
////        s = s.substring(0, s.indexOf(")"));
////
////        System.out.println(s);
//        
//        Pattern p = Pattern.compile("\"([^\"]*)\"");
//        Matcher m  = p.matcher(s);
//        
////        Matcher m = p.matcher(line);
//        while (m.find()) {
//            System.out.println(m.group(1));
//        }
    }
}
