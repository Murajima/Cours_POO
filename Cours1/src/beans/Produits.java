package beans;

import java.util.ArrayList;

public class Produits extends ArrayList<Produit> {

    public Produit getProduitByCode(int code){
        //foreach sur l'ArrayList interne de la classe
        for(Produit prod:this){
            if(prod.getCode() == code){
                return prod;
            }
        }
        return null;
    }

    @Override
    public boolean add(Produit prod){
        if (getProduitByCode(prod.getCode()) == null){
            prod.getCategorie().addProduit(prod);
            return super.add(prod);
        }
        else{
            return false;
        }
    }
}
