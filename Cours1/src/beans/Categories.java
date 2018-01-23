package beans;

import java.util.ArrayList;

public class Categories extends ArrayList<Categorie>{
    /**
     * Initialise une liste de Catégories
     */
    public void init() {
        add(new Categorie(1,"Alcools"));
        add(new Categorie(2,"Gateaux Salés"));
        add(new Categorie(3,"Jus de Fruits"));
    }
    /**
     * Retourne la catégorie associée à cet ID
     * @param code
     * @return
     */
    public Categorie getCategorieByCode(int code){
        //foreach sur l'ArrayList interne de la classe
        for(Categorie cat:this){
            if(cat.getCode() == code){
                return cat;
            }
        }
        return null;
    }

    /**
     * Retourne la catégorie associée à ce libellé
     * @param nom
     * @return
     */
    public Categorie getByLibelle(String nom) {
        for (Categorie cat:this) {
            if(cat.getNom().equals(nom)) {
                return cat;
            }
        }
        return null;
    }

    /**
     * retourne la liste des catégories associées à ce nom
     * @param nom
     * @return
     */
    public ArrayList<Categorie> getCategoriesByMotif(String nom){
        ArrayList<Categorie> returnList = new ArrayList<Categorie>();
        for(Categorie cat:this){
            if(cat.getNom().toLowerCase().contains(nom.toLowerCase())){
                returnList.add(cat);
            }
        }
        return returnList;
    }

    /**
     * Override la méthode add qui permet d'ajouter une élément dans une ArrayList.
     * Vérifie si la catégorie ajoutée est bien absente de l'ArrayList
     * Utilisation du mot clé 'super' pour accéder à la liste (returnList.add(nom) <=> super.add(nom) dans la fonction
     * surchargée)
     * @param cat
     * @return
     */
    @Override
    public boolean add (Categorie cat){
        if(getCategorieByCode(cat.getCode()) == null){
            return super.add(cat);
        }
        else {
            return false;
        }
    }

}
