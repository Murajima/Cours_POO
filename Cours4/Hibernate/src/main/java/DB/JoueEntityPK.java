package DB;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class JoueEntityPK implements Serializable {
    private int codeF;
    private int codeA;

    @Column(name = "codeF")
    @Id
    public int getCodeF() {
        return codeF;
    }

    public void setCodeF(int codeF) {
        this.codeF = codeF;
    }

    @Column(name = "codeA")
    @Id
    public int getCodeA() {
        return codeA;
    }

    public void setCodeA(int codeA) {
        this.codeA = codeA;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JoueEntityPK that = (JoueEntityPK) o;

        if (codeF != that.codeF) return false;
        if (codeA != that.codeA) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codeF;
        result = 31 * result + codeA;
        return result;
    }
}
