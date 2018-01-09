package beans;

public class Produit {
    private int code;
    private String nom;
    private Categorie categorie;

    public Produit(int code, String nom, Categorie categorie) {
        this.code = code;
        this.nom = nom;
        this.categorie = categorie;
    }

    public int getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "code=" + code +
                ", nom='" + nom + '\'' +
                ", categorie=" + categorie +
                '}';
    }
}
