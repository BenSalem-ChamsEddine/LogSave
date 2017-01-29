/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Uttile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Yassine
 */
public class ConnexionBD {

    String url = "jdbc:mysql://localhost:3306/loghistory"; //api-langage-adresse-port-nomdelaBD
    String login = "root";
    String password = "";
    static Connection cnx = null;

    public ConnexionBD() {
        try {
            cnx = DriverManager.getConnection(url, login, password);
            System.out.println("Connection établie");
        } catch (SQLException ex) {
            System.out.println("Connection non établie");

        }

    }

    public static Connection getInstance() {

        if (cnx == null) {
            new ConnexionBD();
        }
        return cnx;

    }
}
