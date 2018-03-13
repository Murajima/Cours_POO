package DB;

import javax.persistence.*;

@Entity
@Table(name = "films", schema = "Films", catalog = "")
public class FilmsEntity {
    private int codeFilm;
    private String titreFilm;
    private int anneeFilm;

    @Id
    @Column(name = "codeFilm")
    public int getCodeFilm() {
        return codeFilm;
    }

    public void setCodeFilm(int codeFilm) {
        this.codeFilm = codeFilm;
    }

    @Basic
    @Column(name = "titreFilm")
    public String getTitreFilm() {
        return titreFilm;
    }

    public void setTitreFilm(String titreFilm) {
        this.titreFilm = titreFilm;
    }

    @Basic
    @Column(name = "anneeFilm")
    public int getAnneeFilm() {
        return anneeFilm;
    }

    public void setAnneeFilm(int anneeFilm) {
        this.anneeFilm = anneeFilm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmsEntity that = (FilmsEntity) o;

        if (codeFilm != that.codeFilm) return false;
        if (anneeFilm != that.anneeFilm) return false;
        if (titreFilm != null ? !titreFilm.equals(that.titreFilm) : that.titreFilm != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codeFilm;
        result = 31 * result + (titreFilm != null ? titreFilm.hashCode() : 0);
        result = 31 * result + anneeFilm;
        return result;
    }
}
