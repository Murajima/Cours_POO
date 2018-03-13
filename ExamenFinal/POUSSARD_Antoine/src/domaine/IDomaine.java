package domaine;

import beans.*;

@SuppressWarnings("unused")
public interface IDomaine {
    Acteurs getAllActeurs();
    Films getAllFilms();
    int addActeur(String s, String s1, Genre g, int i);
    int addFilm(String s, int i);
    boolean addRole(int i, int i1, String s);
    boolean deleteRole(int i, int i1);
    boolean deleteActeur(int i);
    boolean deleteFilm(int i) throws Exception;
}
