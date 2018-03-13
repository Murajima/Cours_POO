package DB;

import javax.persistence.*;

@Entity
@Table(name = "joue", schema = "Films", catalog = "")
@IdClass(JoueEntityPK.class)
public class JoueEntity {
    private int codeF;
    private int codeA;
    private String casting;

    @Id
    @Column(name = "codeF")
    public int getCodeF() {
        return codeF;
    }

    public void setCodeF(int codeF) {
        this.codeF = codeF;
    }

    @Id
    @Column(name = "codeA")
    public int getCodeA() {
        return codeA;
    }

    public void setCodeA(int codeA) {
        this.codeA = codeA;
    }

    @Basic
    @Column(name = "casting")
    public String getCasting() {
        return casting;
    }

    public void setCasting(String casting) {
        this.casting = casting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JoueEntity that = (JoueEntity) o;

        if (codeF != that.codeF) return false;
        if (codeA != that.codeA) return false;
        if (casting != null ? !casting.equals(that.casting) : that.casting != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codeF;
        result = 31 * result + codeA;
        result = 31 * result + (casting != null ? casting.hashCode() : 0);
        return result;
    }
}
