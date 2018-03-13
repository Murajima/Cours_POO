package beans;


public class Acteur {
	private int m_codeActeur;
	private String m_prenomActeur, m_nomActeur;
	private beans.Genre m_sexeActeur;
	private int m_anneeNaissanceActeur;
	private Roles m_Roles;

    public Acteur(int codeActeur, String prenomActeur, String nomActeur,
                  beans.Genre sexeActeur, int anneeNaissanceActeur) {
		m_codeActeur = codeActeur;
		m_prenomActeur = prenomActeur;
		m_nomActeur = nomActeur;
		m_sexeActeur = sexeActeur;
		m_anneeNaissanceActeur = anneeNaissanceActeur;
        m_Roles = new Roles();
	}
	
	public int getCodeActeur() {
		return m_codeActeur;
	}
	public String getPrenomActeur() {
		return m_prenomActeur;
	}
	public String getNomActeur() {
		return m_nomActeur;
	}
	public Genre getSexeActeur() {
		return m_sexeActeur;
	}
	public int getAnneeNaissanceActeur() {
		return m_anneeNaissanceActeur;
	}

	public void addRole(Role r) {
        m_Roles.add(r);
    }

    public Films getFilms() {
        Films films = new Films();
        for (Role r:m_Roles) {
            films.add(r.getM_Film());
        }

        return films;
    }

	public String toString() {
		String titre=m_sexeActeur==Genre.Feminin?"Mme":"M.";
		return "[Acteur "+m_codeActeur+"] : "+titre+" "+m_prenomActeur+" "+m_nomActeur+" ("+m_anneeNaissanceActeur+")";
	}
}
