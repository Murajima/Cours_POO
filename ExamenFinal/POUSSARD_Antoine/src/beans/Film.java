package beans;

public class Film {
	private int m_codeFilm;
	private String m_titreFilm;
	private int m_anneeFilm;
	private Roles m_Roles;
	
	public Film(int codeFilm, String titreFilm, int anneeFilm) {
		m_codeFilm = codeFilm;
		m_titreFilm = titreFilm;
		m_anneeFilm = anneeFilm;
		m_Roles = new Roles();
	}
	
	public int getCodeFilm() {
		return m_codeFilm;
	}
	public String getTitreFilm() {
		return m_titreFilm;
	}
	public int getAnneeFilm() {
		return m_anneeFilm;
	}

    public Roles getM_Roles() {
        return m_Roles;
    }

    public void addRole(Role r) {
        m_Roles.add(r);
    }

    public Acteurs getActeurs() {
        Acteurs acteurs = new Acteurs();
        for (Role r:m_Roles) {
            acteurs.add(r.getM_Acteur());
        }

        return acteurs;
    }

    public String toString() {
		return "[Film "+m_codeFilm+"] : "+m_titreFilm+" ("+m_anneeFilm+")";
	}
}
