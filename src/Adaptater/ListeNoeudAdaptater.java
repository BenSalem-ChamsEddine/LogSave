/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adaptater;

import Services.NoeudService;
import entity.Noeud;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author khadijahela
 */
public class ListeNoeudAdaptater extends AbstractTableModel {

    List<Noeud> maliste = new ArrayList<>();
    NoeudService nes =new NoeudService();
    String[] data = {"nom", "IP", "login", "password"};

    public ListeNoeudAdaptater() {
        maliste = nes.afficherNoeud();
    }

    @Override
    public int getRowCount() {
        return maliste.size();
    }

    @Override
    public int getColumnCount() {
        return data.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "" + maliste.get(rowIndex).getName();
            case 1:
                return maliste.get(rowIndex).getIp();
            case 2:
                return "" + maliste.get(rowIndex).getLogin();
            case 3:
                return "" + maliste.get(rowIndex).getPwd();
            default:
                return null;
        }
    }
    
     @Override
    public String getColumnName(int column) {
        return data[column];
    }
     

}
