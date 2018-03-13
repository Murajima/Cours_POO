package tests;

import beans.*;

public class TestBeans {
    public static void main(String[] args) {
        Acteur a = new Acteur(1, "Jodie", "FOSTER", Genre.Feminin, 1962);
        Film f = new Film(1, "Contact", 1997);
        Role r = new Role(a, f, "Eleanore ARROWAY");
        a.addRole(r);
        f.addRole(r);
        System.out.println(f);
        for (Acteur a1 : f.getActeurs()) {
            System.out.println("- " + a1);
        }

        System.out.println(a);
        for (Film f1 : a.getFilms()) {
            System.out.println("- " + f1);
        }
    }
}
