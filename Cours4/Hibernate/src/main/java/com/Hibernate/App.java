package com.Hibernate;

import org.hibernate.Session;
import utils.HibernateUtil;
import DB.*;

import javax.persistence.Query;
import java.util.List;
import java.util.Set;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println(
                        "JBoss Tools Reverse Engineering");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("from FilmsEntity");
        @SuppressWarnings("unchecked")
        List<FilmsEntity> films = q.getResultList();
        System.out.println("Les films (" + films.size()+ ") : ");
        for (FilmsEntity film : films) {
            @SuppressWarnings("unchecked")
            Set<JoueEntity> setJoues = film.getJoues();
            System.out.println(film.getCodeFilm() + " : " + film.getTitreFilm() + " (" + film.getAnneeFilm() + ") contient " + setJoues.size() + " acteur(s) : ");
            for (JoueEntity joue : setJoues) {
                ActeursEntity acteur = joue.getActeurs();
                System.out.println("- " + acteur.getPrenomActeur() + " " + acteur.getNomActeur() + " dans le rôle de '" + joue.getCasting() + "'.");
            }
        }
    }
}
