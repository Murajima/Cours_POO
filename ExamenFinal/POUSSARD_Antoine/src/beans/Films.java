package beans;

import java.util.ArrayList;

public class Films extends ArrayList<Film> {
    public Film getFilmByCode(int code) {
        for(Film c:this)
            if(c.getCodeFilm() == code)
                return c;
        return null;
    }

    public static Films getIntersection(Films act1, Films act2) {
        Films returnList = new Films();
        for (Film a : act1) {
            if(act2.contains(a)) {
                returnList.add(a);
            }
        }
        return returnList;
    }

    public Acteurs acteursCommunsFilms(int codeF1, int codeF2){
        Acteurs listA1 = this.getFilmByCode(codeF1).getActeurs();
        Acteurs listA2 = this.getFilmByCode(codeF2).getActeurs();

        return Acteurs.getIntersection(listA1, listA2);
    }
}
