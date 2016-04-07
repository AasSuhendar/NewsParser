/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpreprocessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Basis Data
 */
public class TestPreprocessing {

    /**
     * @param args the command line arguments
     */
    List<String> lst = new ArrayList<String>();
    List<News> nws = new ArrayList<News>();
    String temp_url = null;
    String temp_penulis = null;
    String temp_tanggal = null;
    String temp_judul = null;

    void readfile(File path) throws FileNotFoundException, IOException {
        int count = 1;
        int cek = 0;
//        String inputfile = path + "\\" + numb + ".txt";
        for (File fileEntry : path.listFiles()) {
            BufferedReader br = new BufferedReader(new FileReader(new File(fileEntry.getAbsolutePath())));
            String line = br.readLine();
            while (line != null) {
                //nge get judul
                if (line.contains("            <meta property=\"og:title\" content=\"")) {
                    line = line.substring(line.indexOf("content=") + 1);
                    line = line.substring(0, line.indexOf(" |"));
                    line = line.replaceAll("ontent=\"", "");
                    System.out.println(line);
                    temp_judul = line;
                }
                //buat nge get link berita
                if (line.contains("            <meta property=\"og:url\" content=\"")) {
                    String[] tokenizedterm = line.split(" ");
                    for (String term : tokenizedterm) {
                        if (term.contains("content")) {
                            Pattern p = Pattern.compile("\"([^\"]*)\"");
                            Matcher m = p.matcher(term);
                            while (m.find()) {
                                temp_url = m.group(1);
                                System.out.println(m.group(1));
                            }
//                        System.out.println(term);
                        }
                    }
                }

                //buat nge get tgl dan penulis
                if (line.contains("	<div id=\"mdk-body-news-reporter\">")) {
                    String copy = line;
                    line = line.substring(line.indexOf("/\"") + 1);
                    line = line.substring(0, line.indexOf("</a>"));
                    line = line.replaceAll("\">", "");
                    System.out.println(line);
                    temp_penulis = line;

                    //get tanggal
                    copy = copy.substring(copy.indexOf("| ") + 1);
                    copy = copy.substring(0, copy.indexOf("</div>"));
                    copy = copy.replaceFirst(" ", "");
                    System.out.println(copy);
                    temp_tanggal = copy;

                }
                //buat nge get isi berita
                if (line.contains("<p><b>Merdeka.com - </b>")) {
                    cek++;
                }
                if (cek != 0) {
                    lst.add(line);
                    if (line.contains("</p>")) {
                        break;
                    }
                }
                count++;
                line = br.readLine();
            }
            String res = String.join(" ", lst);
            res = res.replaceAll("		|<p><b>Merdeka.com - </b>|<br>|</p>|", "");
            StringBuilder sb = new StringBuilder(res);
//            char kosong='\0';
            boolean mark=false;
            for(int i=0;i<res.length();i++){
                if(sb.charAt(i)=='<'){
                    mark=true;
                }
                if(sb.charAt(i)=='>'){
                    mark=false;
                    sb.setCharAt(i, '%');
                }
                if(mark){
                    sb.setCharAt(i, '%');
                }
            }
            res=sb.toString();
            res=res.replaceAll("%", "");
//            System.out.println(res);
            News n = new News(res, temp_url, temp_penulis, temp_tanggal, temp_judul);
            nws.add(n);
            lst.clear();
            cek=0;
        }

    }

    void savefile() throws IOException {
        int numb = 1;

        for (News ns : nws) {
            System.out.println(nws.size());
            File file = new File("F:\\Users\\Basis Data\\Documents\\hasil\\" + numb + ".txt");
            FileWriter fw = new FileWriter(file);
            fw.write(ns.getJudul());
            fw.write(System.lineSeparator());
            fw.write(ns.getUrl());
            fw.write(System.lineSeparator());
            fw.write(ns.getPenulis());
            fw.write(System.lineSeparator());
            fw.write(ns.getTanggal());
            fw.write(System.lineSeparator());
            fw.write(ns.getIsi());
            fw.flush();
            fw.close();
            numb++;
        }

    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        TestPreprocessing t = new TestPreprocessing();
        File folder = new File("C:\\Users\\Basis Data\\Documents\\berita");
        t.readfile(folder);
//        t.readfile("C:\\Users\\Basis Data\\Documents\\berita");
        t.savefile();
    }

}
