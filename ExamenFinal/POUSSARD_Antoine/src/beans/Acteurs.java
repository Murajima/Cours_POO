package beans;

import java.util.ArrayList;

public class Acteurs extends ArrayList<Acteur> {
    public Acteur getActeurByCode(int code) {
        for(Acteur c:this)
            if(c.getCodeActeur() == code)
                return c;
        return null;
    }

    public static Acteurs getIntersection(Acteurs act1, Acteurs act2) {
        Acteurs returnList = new Acteurs();
        for (Acteur a : act1) {
            if(act2.contains(a)) {
                returnList.add(a);
            }
        }
        return returnList;
    }

    public Films filmsCommunsActeurs(int codeA1, int codeA2){
        Films listA1 = this.getActeurByCode(codeA1).getFilms();
        Films listA2 = this.getActeurByCode(codeA2).getFilms();
        return Films.getIntersection(listA1, listA2);
    }
}
