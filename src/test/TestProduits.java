package test;

import beans.Categories;
import beans.Produit;
import beans.Produits;

public class TestProduits {
    public static void main(String[] args) {
        Categories cats = new Categories();
        cats.init();
        Produits prods = new Produits();
        Produit testProd = new Produit(1,"Vin",cats.getCategorieByCode(1));
        // prods.add(testProd);

        for (Produit prod:prods) {
            System.out.println(prod);
        }
    }
}
