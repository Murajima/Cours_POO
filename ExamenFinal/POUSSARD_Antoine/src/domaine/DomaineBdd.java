package domaine;

import beans.*;
import com.sun.tools.javah.Gen;
import connecteurs.MySqlB3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DomaineBdd implements IDomaine {

    boolean m_toRefresh = true;
    Acteurs m_Acteurs;
    Films m_Films;
    MySqlB3 m_myB3 = null;



    private void realBdd(){
        int nbJoue = 0;
        Genre g = null;
        m_Acteurs = new Acteurs();
        m_Films = new Films();
        if(m_myB3 == null){
            m_myB3 = new MySqlB3("Films");
        }

        ResultSet rs_Acteurs = m_myB3.requete("acteurs");
        ResultSet rs_Films = m_myB3.requete("films");
        ResultSet rs_Joue = m_myB3.requete("joue");
        // tant que
        try {
            while(rs_Acteurs.next()) {
                // on récupère les champs de l'enregistrement
                int codeActeur = rs_Acteurs.getInt("codeActeur");
                String prenomActeur = rs_Acteurs.getString("prenomActeur");
                String nomActeur = rs_Acteurs.getString("nomActeur");
                int sexeActeur = rs_Acteurs.getInt("sexeActeur");
                int anneeNaissance = rs_Acteurs.getInt("anneeNaissanceActeur");

                if(sexeActeur == 0) {
                    g = Genre.Masculin;
                } else {
                    g = Genre.Feminin;
                }
                Acteur tmp_act = new Acteur(codeActeur, prenomActeur, nomActeur, g, anneeNaissance);
                m_Acteurs.add(tmp_act);

            }

            while(rs_Films.next()) {
                // on récupère les champs de l'enregistrement
                int codeFilm = rs_Films.getInt("codeFilm");
                String nomFilm = rs_Films.getString("titreFilm");
                int anneeFilm = rs_Films.getInt("anneeFilm");

                Film tmp_film = new Film(codeFilm, nomFilm, anneeFilm);
                m_Films.add(tmp_film);

            }

            while(rs_Joue.next()) {
                int codeF = rs_Joue.getInt("codeF");
                int codeA = rs_Joue.getInt("codeA");
                String casting = rs_Joue.getString("casting");
                Film film = m_Films.getFilmByCode(codeF);
                Acteur acteur = m_Acteurs.getActeurByCode(codeA);

                Role role = new Role(acteur, film, casting);
                film.addRole(role);
                acteur.addRole(role);
                nbJoue ++;
            }
            // et maintenant on va dans la table des produits
            m_toRefresh = false;
            System.out.println("Régénération [" + m_Films.size() + " Films, " + m_Acteurs.size() + " Acteurs, " + nbJoue + " rôles]"  );
        } catch (SQLException e) {
            System.err.println("Error");
        }
    }


    public Acteurs getAllActeurs() {
        if(m_toRefresh == true) {
            m_toRefresh = false;
            realBdd();
        }
        return m_Acteurs;
    }

    public Films getAllFilms() {
        if(m_toRefresh == true) {
            m_toRefresh = false;
            realBdd();
        }
        return m_Films;
    }

    public int addActeur(String s, String s1, Genre g, int i) {
        int sexe = -1;
        if(m_myB3.equals(null)){
            m_myB3 = new MySqlB3("Films");
        }

        if(g.equals(Genre.Masculin)){
            sexe = 0;
        } else if (g.equals(Genre.Feminin)) {
            sexe = 1;
        }

        String sql="INSERT INTO acteurs VALUES (null,  "+ s + s1 + sexe + i + ")";
        int l = m_myB3.insereAI(sql);
        if(l != -1){
            m_toRefresh = true;
        }
        return l;
    }

    public int addFilm(String s, int i) {
        if(m_myB3.equals(null)){
            m_myB3 = new MySqlB3("Films");
        }

        String sql = "INSERT INTO films VALUES (null,  "+ "\"" + s + "\"" + ", " + String.valueOf(i) + ")";
        int l = m_myB3.insereAI(sql);
        if(l != -1){
            m_toRefresh = true;
        }
        return l;
    }

    public boolean addRole(int i, int i1, String s) {
        if(m_myB3.equals(null)){
            m_myB3 = new MySqlB3("Films");
        }

        String sql="INSERT INTO joue VALUES (null,  "+ i + i1 + s + ")";
        int l = m_myB3.update(sql);

        if(l == 1){
            m_toRefresh = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteRole(int i, int i1) {
        if(m_myB3.equals(null)){
            m_myB3 = new MySqlB3("Films");
        }

        String sql= "DELETE FROM joue WHERE codeF = " + String.valueOf(i) + "AND codeA = " + String.valueOf(i1);
        int l = m_myB3.update(sql);

        if(l == 1){
            m_toRefresh = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteActeur(int i) {
        if(m_myB3.equals(null)){
            m_myB3 = new MySqlB3("Films");
        }
        String sql = "codeA = " + String.valueOf(i);

        int nbR = nbRoles(sql);
        if(nbR == 0) {
            sql = "DELETE FROM acteurs WHERE codeActeur = " + String.valueOf(i);
            int l = m_myB3.update(sql);
            if(l == 1){
                m_toRefresh = true;
                return true;
            } else {
                return false;
            }
        } else{
            return false;
        }
    }

    public boolean deleteFilm(int i) throws Exception {
        if(m_myB3.equals(null)){
            m_myB3 = new MySqlB3("Films");
        }
        String sql = "codeF = " + String.valueOf(i);

        int nbR = nbRoles(sql);
        if(nbR == 0) {
            sql = "DELETE FROM films WHERE codeFilm = " + String.valueOf(i);
            int l = m_myB3.update(sql);
            if(l == 1){
                m_toRefresh = true;
                return true;
            } else {
                return false;
            }
        } else{
            throw new Exception("Erruer");
        }
    }

    private int nbRoles(String sqlFin) {
        String sql = "SELECT count(*) as nb FROM joue WHERE " + sqlFin;
        System.out.println(sql);
        int res =0;
        ResultSet rs = m_myB3.requete(sql);
        try {
            rs.next();
            res = rs.getInt("nb");
        }
        catch (SQLException e) {}
        return res;
    }
}
