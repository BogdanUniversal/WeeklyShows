package Domain;

/**
 * Class that describes an hour that has "ora"(hour) and "minut"(minute) as attributes.
 */
public class Ora {
    private int ora;
    private int minut;

    /**
     * Constructor with parameters that instantiates the attributes with 0 if given values are wrong.
     * @param ora = int.
     * @param minut = int.
     */
    public Ora(int ora, int minut){
        if(ora<0 || ora>23) {
            System.out.println("Ora gresita!");
            this.ora=0;
        }
        else if(minut<0 || minut>59)
        {
            System.out.println("Minut gresit!");
            this.minut=0;
        }
        else
        {
            this.ora=ora;
            this.minut=minut;
        }
    }

    /**
     * Get method for the "ora"(hour) attribute.
     * @return ora = int.
     */
    public int getOra() {
        return this.ora;
    }

    /**
     * Get method for the "minut"(minute) attribute.
     * @return minut = int.
     */
    public int getMinut(){
        return this.minut;
    }

    /**
     * Set method for the "ora"(hour) attribute.
     * @param ora = int.
     */
    public void setOra(int ora){
        if(ora<0 || ora>23) System.out.println("Ora gresita la set!");
        else this.ora=ora;
    }

    /**
     * Set method for the "minut"(minute) attribute.
     * @param minut = int.
     */
    public void setMinut(int minut){
        if(minut<0 || minut>59) System.out.println("Minut gresit la set!");
        else this.minut=minut;
    }
}
