/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Services.LogServices;
import Services.NoeudService;
import entity.Log;
import entity.Noeud;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sun.awt.DesktopBrowse;

/**
 *
 * @author Yassine
 */
public class Test {

    public static void main(String[] args) throws IOException {
//        LogServices ls = new LogServices();
//        Log l = new Log();
//        l.setDate(new Date());
//        l.setName("dd");
//        l.setType("qq");
//        ls.ajouterLog(l);
//        Date d = new Date();
//       // File f = new File("C:/Users/Yassine/Desktop/2016/8/11");
//       // f.mkdirs();
//        File f3 = new File("C:/Users/Yassine/Desktop/"+(d.getYear()+1900)+"/"+(1+d.getMonth())+"/"+d.getDate());
//        File f2 = new File("C:/Users/Yassine/Desktop/log");
//        Desktop dd = Desktop.getDesktop();
//       // dd.open(f2);
//        FileUtils.copyDirectory(f2, f3);

//        Noeud ne = new Noeud();
//        ne.setIp("127.20.20.10");
//        ne.setLogin("login");
//        ne.setPwd("password");
//        ne.setName("nom2");
//        ne.setId(2);
//        
//        NoeudService ns = new NoeudService();
//       // ns.ajouterNoeud(ne);
//        //ns.supprimerNoeud(ne);
//        ns.modifierNoeud(ne);
        LogServices ls = new LogServices();
//        List<File> a = ls.listerLog(new Date());
//        for (File a1 : a) {
//            System.out.println(a1.toString());
//        }
        
    }

   
}
