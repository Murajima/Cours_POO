
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.IOError;
import java.io.IOException;
import java.io.OutputStream;

public class EditXML {
    private Document doc;

    public EditXML() throws IOException {
        Element racine = new Element("Table_Categorie");
        doc = new Document(racine);
        Element e_data = new Element("data");
        racine.addContent(e_data);

        // ajout d'une categorie version char d'assaut
        Element e_categorie, e_nom;
        Attribute a_code;

        e_categorie = new Element("Categorie");
        e_nom = new Element("nom");
        a_code = new Attribute("code", "1");
        e_nom.setText("Alcools");

        e_data.addContent(e_categorie);
        e_categorie.setAttribute(a_code);
        e_categorie.addContent(e_nom);

        // ajout d'une categorie - methode geek

        e_data.addContent(new Element("Categorie")
                .setAttribute(new Attribute("code", "2"))
                .addContent(new Element("nom").setText("Gateaux Sales")));


        affiche(System.out);

    }

    public void affiche(OutputStream out) throws IOException {
        XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
        sortie.output(doc, out);
    }
}
