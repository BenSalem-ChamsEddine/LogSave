/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Yassine
 */
public class LogServices {

    public List<File> listerLog() {
        Date d = new Date();
        List<File> maListe = new ArrayList<>();
        boolean test = false;
        File aa = new File("C:/Users/Yassine/Desktop/" + (d.getYear() + 1900) + "/");

        for (File month : aa.listFiles()) {

            for (File day : month.listFiles()) {

                for (File log : day.listFiles()) {
                    for (File f : maListe) {
                        if (f.getName().equals(log.getName())) {
                            test = true;
                        }
                    }
                    if (!test) {
                        maListe.add(log);
                    } else {
                        test = false;
                    }

                }

            }

        }

        return maListe;

    }

    public int differenceDate(Date from, Date to) {
        int diffInDays = (int) ((to.getTime() - from.getTime())
                / (1000 * 60 * 60 * 24));
        return diffInDays;
    }

    public List<File> listerLogDate(Date from, Date to) {
        List<File> maListe = new ArrayList<>();
        int dif = 0;
        boolean test = false;
        if (from == null && to == null) {
            return null;

        } else if (from != null && to == null) {
            dif = 0;
        } else if (from != null && to != null) {
            dif = differenceDate(from, to);
        }

        for (int i = 0; i <= dif; i++) {
            File aa = new File("C:/Users/Yassine/Desktop/" + (from.getYear() + 1900) + "/" + (from.getMonth() + 1) + "/" + (from.getDate() + i) + "/");

            for (File log : aa.listFiles()) {

                for (File f : maListe) {
                    if (f.getName().equals(log.getName())) {
                        test = true;
                    }
                }
                if (!test) {
                    maListe.add(log);

                } else {
                    test = false;
                }

            }

        }

        return maListe;

    }

}
