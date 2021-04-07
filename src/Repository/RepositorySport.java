package Repository;

import Domain.Film;
import Domain.Jurnal;
import Domain.Show;
import Domain.Sport;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Subclass of repository for storage of sports.
 */
public class RepositorySport extends Repository{
    public List programSport=new ArrayList<Sport>();

    /**
     * Default constructor.
     */
    public RepositorySport(){
        this.readFile();
    }

    /**
     * Try-catch method for reading journals from a file, using BufferedReader.
     */
    public void readFile()
    {
        try { BufferedReader fisIn =
                new BufferedReader(new FileReader("A:\\Laborator\\Java\\Lab4\\src\\sports"));
            String s;
            while((s = fisIn.readLine())!= null){
                String[] felii =s.split(",");
                int ora=Integer.parseInt(felii[0]);
                int minut=Integer.parseInt(felii[1]);
                int zi= Integer.parseInt(felii[2]);
                int durata=Integer.parseInt(felii[3]);
                String categorie= new String(felii[4]);
                this.programSport.add(new Sport(ora,minut,zi,durata,categorie));//alocarea efectiva pentru comp.
            }
            fisIn.close();

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Try-catch method for saving journals to a file, using BufferedWriter.
     */
    public void saveFile()
    {
        try { BufferedWriter fisOut =
                new BufferedWriter(new FileWriter("A:\\Laborator\\Java\\Lab4\\src\\sports"));
            int marime=this.programSport.size();
            if(marime==1)
            {
                String emisiune=new String(this.getSport(0).getOra() +","+this.getSport(0).getMinut()+
                        ","+this.getSport(0).getZi()+","+this.getSport(0).getDurata()+","+this.getSport(0).getCategorie());
                fisOut.write(emisiune);
            }
            else if(marime>1)
            {
                for(int i=0;i<this.programSport.size()-1;i++)
                {
                    String emisiune=new String(this.getSport(i).getOra() +","+this.getSport(i).getMinut()+
                            ","+this.getSport(i).getZi()+","+this.getSport(i).getDurata()+","+this.getSport(i).getCategorie());
                    fisOut.write(emisiune);
                    fisOut.newLine();
                }
                int ultim=this.programSport.size()-1;
                String emisiuneFinala=new String(this.getSport(ultim).getOra() +","+this.getSport(ultim).getMinut()+
                        ","+this.getSport(ultim).getZi()+","+this.getSport(ultim).getDurata()+","+this.getSport(ultim).getCategorie());
                fisOut.write(emisiuneFinala);
            }
            fisOut.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Get method for a sport at a given position.
     * @param position = int.
     * @return Sport.
     */
    public Sport getSport(int position)
    {
        return (Sport) this.programSport.get(position);
    }

    /**
     * Method that returns the position of a given sport.
     * @param f = Sport.
     * @return position if found, else -1 = int.
     */
    public int getPos(Sport f)
    {
        for(int i=0;i<programSport.size();i++)
        {
            if(this.getSport(i).getOra()==f.getOra() && this.getSport(i).getMinut()==f.getMinut()
                    && this.getSport(i).getZi()==f.getZi() && this.getSport(i).getDurata()==f.getDurata()
                    && this.getSport(i).getCategorie() == f.getCategorie())
                return i;
        }
        return -1;
    }

    /**
     * Method that checks if a sport already exists in the repository.
     * @param f = Sport.
     * @return ex = 1 if it exists, 0 if not.
     */
    public boolean exista(Sport f)
    {
        boolean ex=false;
        for(int i=0;i<programSport.size();i++)
        {
            if(this.getSport(i).getOra()==f.getOra() && this.getSport(i).getMinut()==f.getMinut()
                    && this.getSport(i).getZi()==f.getZi() && this.getSport(i).getDurata()==f.getDurata()
                    && this.getSport(i).getCategorie() == f.getCategorie())
                ex=true;
        }
        return ex;
    }

    /**
     * Method for adding a sport to the repository.
     * @param s = Sport.
     */
    public void addSport(Sport s)
    {
        if(this.exista(s)) System.out.println("Filmul exista deja!");
        else {
            this.programSport.add(s);
            this.saveFile();
        }
    }

    /**
     * Method for removing a sport from the repository.
     * @param s = Sport.
     */
    public void removeSport(Sport s)
    {
        if(this.exista(s)) {
            this.programSport.remove(this.getPos(s));
            this.saveFile();
        }
        else System.out.println("Elementul nu exista!");
    }

    /**
     * Set method that replaces the sport at a given position with the given sport.
     * @param position = int.
     * @param s = Sport.
     */
    public void set(int position, Sport s)
    {
        this.programSport.set(position,s);
        this.saveFile();
    }

    /**
     * Method for removing a sport from the repository from a given position.
     * @param position = int.
     */
    public void remove(int position)
    {
        this.programSport.remove(position);
        this.saveFile();
    }

    /**
     * Get method that returns all the objects in the repository.
     * @return ArrayList<Sport>.
     */
    public ArrayList<Sport> getAll()
    {
        return (ArrayList<Sport>) this.programSport;
    }

    /**
     * Get method for the size of the repository.
     * @return size = int.
     */
    public int getSize()
    {
        return programSport.size();
    }

    /**
     * Sort method that reorders the objects in the repository based on the overridden comparator.
     */
    public void sortare()
    {
        Collections.sort(this.programSport, new Sport());
        this.saveFile();
    }

    /**
     * Swap method that swaps the elements at the given positions.
     * @param i = int.
     * @param j = int.
     */
    public void swap(int i, int j)
    {
        Sport f=this.getSport(i);
        this.set(i,this.getSport(j));
        this.set(j,f);
    }

    /**
     * Method that compares the dates of two given sports.
     * @param f1 = Sport.
     * @param f2  = Sport.
     * @return 1 if f1 is later, 0 if f2 is = int.
     */
    public int isLower(Sport f1, Sport f2)
    {
        if(f1.getZi()<f2.getZi()) return 0;
        else if(f1.getZi()==f2.getZi())
        {
            if(f1.getOra()<f2.getOra()) return 0;
            else if(f1.getOra()==f2.getOra())
            {
                if(f1.getMinut()<=f2.getMinut()) return 0;
                else return 1;
            }
            else return 1;
        }
        else return 1;
    }

    /**
     * Method that sorts the elements of the repository ascending, based on their date.
     */
    public void sortare2()
    {
        for(int i=0;i<programSport.size()-1;i++)
        {
            for(int j=i+1;j<programSport.size();j++)
            {
                if(this.isLower(this.getSport(j),this.getSport(i))==0)
                    swap(i,j);
            }
        }
    }
}
