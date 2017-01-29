/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.File;
import java.util.Date;

/**
 *
 * @author Yassine
 */
public class Log {
    private String name;
    private Date date;
    private String type;
    private File fichier;
    private Noeud ne;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public File getFichier() {
        return fichier;
    }

    public void setFichier(File fichier) {
        this.fichier = fichier;
    }

    public Noeud getNe() {
        return ne;
    }

    public void setNe(Noeud ne) {
        this.ne = ne;
    }
    
    
}
