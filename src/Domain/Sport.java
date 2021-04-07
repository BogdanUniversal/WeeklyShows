package Domain;

import java.util.Comparator;

/**
 * Subclass of the Emisiune(Show) class that only has the category of the show as attribute and that implements the Comparator interface.
 */
public class Sport extends Emisiune implements Comparator<Sport> {
    private String categorie;

    /**
     * Default constructor.
     */
    public Sport()
    {
        super();
        this.categorie=null;
    }

    /**
     * Constructor with parameters that automatically instantiates if given values are wrong.
     * @param ora = int.
     * @param minut = int.
     * @param zi = int.
     * @param durata = int.
     * @param categorie = String.
     */
    public Sport(int ora, int minut, int zi, int durata, String categorie)
    {
        super(ora, minut, zi, durata);
        if(categorie.equals("sport"))
            this.categorie=new String(categorie);
        else {
            this.categorie=new String("sport");
            System.out.println("Categorie gresita!");
        }
    }

    /**
     * Get method for the "categorie"(category) attribute.
     * @return categorie = String.
     */
    public String getCategorie() {
        return this.categorie;
    }

    /**
     * Set method for the "categorie"(category) attribute.
     * @param categorie = String.
     */
    public void setCategorie(String categorie)
    {
        if(categorie.equals("film") || categorie.equals("show") || categorie.equals("jurnal") || categorie.equals("sport"))
            this.categorie=new String(categorie);
        else System.out.println("Categorie gresita la set!");
    }

    /**
     * Override compare method for two sports.
     * @param o1 = Sport.
     * @param o2 = Sport.
     * @return int.
     */
    @Override
    public int compare(Sport o1, Sport o2) {
        return o2.getDurata()-o1.getDurata();
    }
}
