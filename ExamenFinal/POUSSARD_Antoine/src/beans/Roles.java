package beans;

import java.util.ArrayList;

public class Roles extends ArrayList<Role> {
    public Role getRoleByCode(int codeA, int codeF) {
        for(Role c:this)
            if(c.getM_Acteur().getCodeActeur() == codeA && c.getM_Film().getCodeFilm() == codeF)
                return c;
        return null;
    }
}
