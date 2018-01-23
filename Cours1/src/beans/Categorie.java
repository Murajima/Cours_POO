package beans;

public class Categorie {
    private int code;
    private String nom;
    private Produits produits;

    /**
     * Constructeur de la classe Categorie
     * @param code
     * @param nom
     */
    public Categorie(int code, String nom) {
        super();
        this.code = code;
        this.nom = nom;
        produits = new Produits(); // Super important sinon null pointer exception
    }

    /**
     * Ajout d'un produit
     * @param p
     */
    public void addProduit(Produit p){
        produits.add(p);
    }

    /**
     * Getter de l'attribut code
     * @return
     */
    public int getCode() {
        return code;
    }

    /**
     * Getter de l'attribut nom
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     * toString de la classe Categorie
     * @return
     */
    @Override
    public String toString() {
        return "Categorie{" +
                "code=" + code +
                ", nom='" + nom + '\'' +
                '}';
    }
}
