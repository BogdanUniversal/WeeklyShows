package Domain;

/**
 * Subclass of the Emisiune(Show) class that only has the category of the show as attribute.
 */
public class Show extends Emisiune {
    private String categorie;

    /**
     * Constructor with parameters that automatically instantiates if given values are wrong.
     * @param ora = int.
     * @param minut = int.
     * @param zi = int.
     * @param durata = int.
     * @param categorie = String.
     */
    public Show(int ora, int minut, int zi, int durata, String categorie){
        super(ora, minut, zi, durata);
        if(categorie.equals("show"))
            this.categorie=new String(categorie);
        else {
            this.categorie=new String("show");
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
}
