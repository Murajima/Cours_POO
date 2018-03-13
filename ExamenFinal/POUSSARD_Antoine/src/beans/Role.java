package beans;

public class Role {
    private Acteur m_Acteur;
    private Film m_Film;
    private String m_Casting;

    public Role(Acteur m_Acteur, Film m_Film, String m_Casting) {
        this.m_Acteur = m_Acteur;
        this.m_Film = m_Film;
        this.m_Casting = m_Casting;
    }

    public Acteur getM_Acteur() {
        return m_Acteur;
    }

    public Film getM_Film() {
        return m_Film;
    }

    public String getM_Casting() {
        return m_Casting;
    }

    @Override
    public String toString() {
        return "Role{" +
                "m_Acteur=" + m_Acteur +
                ", m_Film=" + m_Film +
                ", m_Casting='" + m_Casting + '\'' +
                '}';
    }
}
