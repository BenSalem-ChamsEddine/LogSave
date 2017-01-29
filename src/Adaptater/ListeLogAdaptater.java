/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adaptater;

import Services.LogServices;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author khadijahela
 */
public class ListeLogAdaptater extends AbstractTableModel {

    List<File> maliste = new ArrayList<>();
    LogServices nes =new LogServices();
    String[] data = {"Nom", "Path"};

    public ListeLogAdaptater() {
        maliste = nes.listerLog();
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
                return maliste.get(rowIndex).getPath();

            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return data[column];
    }
     

}
