/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Uttile.ConnexionBD;
import entity.Noeud;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yassine
 */
public class NoeudService {

    Connection cnx = ConnexionBD.getInstance();

    public boolean ajouterNoeud(Noeud ne) {

        String requete2 = "INSERT INTO noeud (name, ip, login, pwd) VALUES (?,?,?,?)";

        try {

            PreparedStatement st = cnx.prepareStatement(requete2);
            st.setString(1, ne.getName());
            st.setString(2, ne.getIp());

            st.setString(3, ne.getLogin());
            st.setString(4, ne.getPwd());

            st.executeUpdate();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;

    }

    public boolean supprimerNoeud(Noeud ne) {

        String requete2 = "delete from noeud where id=" + ne.getId();

        try {

            PreparedStatement st = cnx.prepareStatement(requete2);
            st.executeUpdate();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;

    }

    public boolean modifierNoeud(Noeud ne) {

        String requete2 = "update noeud set name=?, ip=?, login=?, pwd=? where id=" + ne.getId();

        try {

            PreparedStatement st = cnx.prepareStatement(requete2);
            st.setString(1, ne.getName());
            st.setString(2, ne.getIp());

            st.setString(3, ne.getLogin());
            st.setString(4, ne.getPwd());

            st.executeUpdate();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;

    }

    public List afficherNoeud() {

        String requete2 = "select * from noeud";
        List<Noeud> maliste = new ArrayList<Noeud>();

        try {

            PreparedStatement st = cnx.prepareStatement(requete2);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Noeud ne = new Noeud();
                ne.setId(rs.getInt("id"));
                ne.setIp(rs.getString("ip"));
                ne.setLogin(rs.getString("login"));
                ne.setPwd(rs.getString("pwd"));
                ne.setName(rs.getString("name"));
                maliste.add(ne);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return maliste;

    }

    public Noeud rechercherNoeud(String nom, String ip, String username, String password) {

        String requete2 = "select * from noeud where name='" + nom + "' and ip='" + ip + "' and login='" + username + "' and pwd='" + password + "'";
        Noeud ne = new Noeud();
        try {

            PreparedStatement st = cnx.prepareStatement(requete2);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                ne.setId(rs.getInt("id"));
                ne.setIp(rs.getString("ip"));
                ne.setLogin(rs.getString("login"));
                ne.setPwd(rs.getString("pwd"));
                ne.setName(rs.getString("name"));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

        return ne;

    }
}
