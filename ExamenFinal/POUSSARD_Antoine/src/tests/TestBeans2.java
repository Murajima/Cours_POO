package tests;

import beans.*;
import domaine.DomaineBdd;
import domaine.IDomaine;

public class TestBeans2 {
    public static void main(String[] args) {
        IDomaine domaine = new DomaineBdd();
        Acteurs acteurs = domaine.getAllActeurs();
        Films films = domaine.getAllFilms();
        boolean success = false;

        System.out.printf("*** Affichage de tous les acteurs ***");
        for (Acteur acteur: acteurs) {
            String genre = null;
            Films filmsActeur = acteur.getFilms();
            if (acteur.getSexeActeur() == Genre.Feminin) {
                genre = "Mme";
            } else if(acteur.getSexeActeur() == Genre.Masculin) {
                genre = "M.";
            }
            System.out.println("[Acteur " + acteur.getCodeActeur() + "] : " + genre + " " + acteur.getPrenomActeur() + " " + acteur.getNomActeur() + " (" + acteur.getAnneeNaissanceActeur() + ") a " + filmsActeur.size() + " roles : \n");
            for (Film film: filmsActeur) {
                System.out.println("-  [Film " + film.getCodeFilm() + "] : " + film.getTitreFilm() + " (" + film.getAnneeFilm() + ") <- " + film.getM_Roles().getRoleByCode(acteur.getCodeActeur(), film.getCodeFilm()).getM_Casting() );
            }
        }

        System.out.println("*** Affichage de tous les films ***");
        for (Film film: films) {
            Acteurs acteursFilm = film.getActeurs();
            System.out.printf("[Film " + film.getCodeFilm() + "] : " + film.getTitreFilm() + " a " + acteursFilm.size() +" acteurs : \n" );
            for (Acteur acteur: acteursFilm) {
                String genre = null;
                if (acteur.getSexeActeur() == Genre.Feminin) {
                    genre = "Mme";
                } else if(acteur.getSexeActeur() == Genre.Masculin) {
                    genre = "M.";
                }
                System.out.println("-  [Acteur " + acteur.getCodeActeur() + "] : " + genre + " " + acteur.getPrenomActeur() + " " + acteur.getNomActeur() + " (" + acteur.getAnneeNaissanceActeur() + ") <- " + film.getM_Roles().getRoleByCode(acteur.getCodeActeur(), film.getCodeFilm()).getM_Casting() );
            }
        }

        System.out.println("*** Insertion d'un film ***");
        System.out.println("- Taille avant : " + films.size());
        int code_film = domaine.addFilm("Oui-oui chez ynov", 2018);
        films = domaine.getAllFilms();
        System.out.println("- Taille après : " + films.size());

        System.out.println("*** Suppression d'un film ***");
        try {
            domaine.deleteFilm(1);
        } catch (Exception e) {
            Film film = films.getFilmByCode(1);
            System.out.printf("Le Film [Film "+ film.getCodeFilm() + "] : " + film.getTitreFilm() + " (" + film.getAnneeFilm() + ") contient " + film.getActeurs().size() +" acteurs\n");
        }

        try {
            success = domaine.deleteFilm(code_film);
        } catch (Exception e) {
            System.out.printf("Impossible le film a toujours des roles !");
        }

        System.out.println("- réussie : " + success);

        System.out.println("\n*** Acteurs communs aux films 1 et 2 ***");
        Acteurs actsComm = domaine.getAllFilms().acteursCommunsFilms(1, 2);
        for (Acteur a : actsComm) {
            System.out.println("- " + a);
        }
        System.out.println("\n*** Films communs aux acteurs 1 et 2 ***");
        Films fisComm = domaine.getAllActeurs().filmsCommunsActeurs(1, 2);
        for (Film f : fisComm) {
            System.out.println("- " + f);
        }
    }

}
