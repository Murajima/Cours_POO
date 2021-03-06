package test;

import beans.Categorie;
import beans.Categories;

import java.util.ArrayList;

public class TestCategories {
    public static void main(String[] args) {
        Categories cats = new Categories();
        cats.init();
        System.out.println("********* Affichage de toutes les catégories *********");
        for (Categorie cat:cats) {
            System.out.println(cat);
        }
        System.out.println("****** Ajout d'une catégorie ******");
        Categorie surg = new Categorie(4,"Surgelés");
        System.out.println(cats.add(surg));
        System.out.println("****** Ajout d'une catégorie dont le code existe");
        System.out.println(cats.add(surg));
        System.out.println("******* Affichage d'une catégorie donct le code existe *******");
        System.out.println(cats.getCategorieByCode(1));
        System.out.println("****** Affichage d'une catégorie dont le code n'existe pas ******");
        System.out.println(cats.getCategorieByCode(34));
        System.out.println("****** Affichage d'une catégorie dont le libellé existe ******");
        System.out.println(cats.getByLibelle("Surgelés"));
        System.out.println("****** Affichage d'une catégorie dont le libellé n'existe pas  ******");
        System.out.println(cats.getByLibelle("Pizzas"));
        System.out.println("****** Ajout des catégories dont le libellé contient 'e' *******");
        ArrayList<Categorie> contI = cats.getCategoriesByMotif("e");
        for (Categorie cat:contI) {
            System.out.println(cat);
        }

    }
}
