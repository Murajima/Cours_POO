package beans;

public class Categorie {
    private int code;
    private String nom;

    public Categorie(int code, String nom) {
        super();
        this.code = code;
        this.nom = nom;
    }

    public int getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "code=" + code +
                ", nom='" + nom + '\'' +
                '}';
    }
}
