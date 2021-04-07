package Domain;

/**
 * Subclass of the Ora(hour) class that is abstract and describes a show.
 */
abstract class Emisiune extends Ora {
    private int zi;
    private int durata;//minute

    /**
     * Default constructor.
     */
    public Emisiune()
    {
        super(0,0);
        this.zi=0;
        this.durata=0;
    }

    /**
     * Constructor with parameters that instantiates the attributes with 0 if given values are wrong.
     * @param ora = int.
     * @param minut = int.
     * @param zi = int.
     * @param durata = int.
     */
    public Emisiune(int ora, int minut, int zi, int durata) {
        super(ora, minut);
        if(zi>0 && zi<8)
            this.zi=zi;
        else {
            System.out.println("Zi gresita!");
            this.zi=0;
        }
        this.durata=durata;
    }

    /**
     * Get method for the "zi"(day) attribute.
     * @return zi = int.
     */
    public int getZi()
    {
        return this.zi;
    }

    /**
     * Abstract get method for the category of the show.
     * @return String.
     */
    abstract public String getCategorie();

    /**
     * Get method for the "durata"(duration) attribute.
     * @return durata = int.
     */
    public int getDurata()
    {
        return this.durata;
    }

    /**
     * Set method for the "zi"(day) attribute.
     * @param zi = int.
     */
    public void setZi(int zi)
    {
        if(zi>0&&zi<8)
            this.zi=zi;
        else System.out.println("Zi gresita la set!");
    }

    /**
     * Abstract set method for the category of the show.
     * @param categorie = String.
     */
    abstract public void setCategorie(String categorie);

    /**
     * Set method for the "durata"(duration) attribute.
     * @param durata = int.
     */
    public void setDurata(int durata)
    {
        this.durata=durata;
    }
}
