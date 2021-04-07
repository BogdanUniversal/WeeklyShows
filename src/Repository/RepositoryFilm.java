package Repository;

import Domain.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Subclass of repository for storage of movies.
 */
public class RepositoryFilm extends Repository{
    protected List programFilm=new ArrayList<Film>();

    /**
     * Default constructor.
     */
    public RepositoryFilm()
    {
        this.readFile();
    }

    /**
     * Try-catch method for reading movies from a file, using BufferedReader.
     */
    public void readFile()
    {
        try { BufferedReader fisIn =
                new BufferedReader(new FileReader("A:\\Laborator\\Java\\Lab4\\src\\filme"));
            String s;
            while((s = fisIn.readLine())!= null){
                String[] felii =s.split(",");
                int ora=Integer.parseInt(felii[0]);
                int minut=Integer.parseInt(felii[1]);
                int zi= Integer.parseInt(felii[2]);
                int durata=Integer.parseInt(felii[3]);
                String categorie= new String(felii[4]);
                this.programFilm.add(new Film(ora,minut,zi,durata,categorie));//alocarea efectiva pentru comp.
            }
            fisIn.close();

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Try-catch method for saving movies to a file, using BufferedWriter.
     */
    public void saveFile()
    {
        try { BufferedWriter fisOut =
                new BufferedWriter(new FileWriter("A:\\Laborator\\Java\\Lab4\\src\\filme"));
            int marime=this.programFilm.size();
            if(marime==1)
            {
                String emisiune=new String(this.getFilm(0).getOra() +","+this.getFilm(0).getMinut()+
                        ","+this.getFilm(0).getZi()+","+this.getFilm(0).getDurata()+","+this.getFilm(0).getCategorie());
                fisOut.write(emisiune);
            }
            else if(marime>1)
            {
                for(int i=0;i<this.programFilm.size()-1;i++)
                {
                    String emisiune=new String(this.getFilm(i).getOra() +","+this.getFilm(i).getMinut()+
                            ","+this.getFilm(i).getZi()+","+this.getFilm(i).getDurata()+","+this.getFilm(i).getCategorie());
                    fisOut.write(emisiune);
                    fisOut.newLine();
                }
                int ultim=this.programFilm.size()-1;
                String emisiuneFinala=new String(this.getFilm(ultim).getOra() +","+this.getFilm(ultim).getMinut()+
                        ","+this.getFilm(ultim).getZi()+","+this.getFilm(ultim).getDurata()+","+this.getFilm(ultim).getCategorie());
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
     * Get method for a "Film"(movie) at a given position.
     * @param position = int.
     * @return Film
     */
    public Film getFilm(int position)
    {
        return (Film) this.programFilm.get(position);
    }

    /**
     * Method that checks if a "film"(movie) already exists in the repository.
     * @param f = Film.
     * @return ex = 1 if it exists, 0 if not.
     */
    public boolean exista(Film f)
    {
        boolean ex=false;
        for(int i=0;i<programFilm.size();i++)
        {
            if(this.getFilm(i).getOra()==f.getOra() && this.getFilm(i).getMinut()==f.getMinut()
                    && this.getFilm(i).getZi()==f.getZi() && this.getFilm(i).getDurata()==f.getDurata()
                    && this.getFilm(i).getCategorie() == f.getCategorie())
                ex=true;
        }
        return ex;
    }

    /**
     * Method for adding a "film"(movie) to the repository.
     * @param f = Film.
     */
    public void addFilm(Film f)
    {
        if(this.exista(f)) System.out.println("Filmul exista deja!");
        else {
            this.programFilm.add(f);
            this.saveFile();
        }
    }

    /**
     * Method that returns the position of a given "film"(movie).
     * @param f = Film.
     * @return position if found, else -1 = int.
     */
    public int getPos(Film f)
    {
        for(int i=0;i<programFilm.size();i++)
        {
            if(this.getFilm(i).getOra()==f.getOra() && this.getFilm(i).getMinut()==f.getMinut()
                    && this.getFilm(i).getZi()==f.getZi() && this.getFilm(i).getDurata()==f.getDurata()
                    && this.getFilm(i).getCategorie() == f.getCategorie())
                return i;
        }
        return -1;
    }

    /**
     * Method for removing a "film"(movie) from the repository.
     * @param f = Film.
     */
    public void removeFilm(Film f)
    {
        if(this.exista(f)) {
            this.programFilm.remove(this.getPos(f));
            this.saveFile();
        }
        else System.out.println("Elementul nu exista!");
    }

    /**
     * Method for removing a "film"(movie) from the repository from a given position.
     * @param position = int.
     */
    public void removeFilm(int position)
    {
            this.programFilm.remove(position);
            this.saveFile();
    }

    /**
     * Set method that replaces the "film"(movie) at a given position with the given "film"(movie).
     * @param position = int.
     * @param f = Film.
     */
    public void set(int position, Film f)
    {
        this.programFilm.set(position,f);
        this.saveFile();
    }

    /**
     * Get method for the size of the repository.
     * @return size = int.
     */
    public int getSize()
    {
        return programFilm.size();
    }

    /**
     * Get method that returns all the objects in the repository.
     * @return ArrayList<Film>.
     */
    public ArrayList<Film> getAll()
    {
        return (ArrayList<Film>) this.programFilm;
    }

    /**
     * Swap method that swaps the elements at the given positions.
     * @param i = int.
     * @param j = int.
     */
    public void swap(int i, int j)
    {
        Film f=this.getFilm(i);
        this.set(i,this.getFilm(j));
        this.set(j,f);
    }

    /**
     * Method that compares the dates of two given movies.
     * @param f1 = Film.
     * @param f2  = Film.
     * @return 1 if f1 is later, 0 if f2 is = int.
     */
    public int isLower(Film f1, Film f2)
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
    public void sortare()
    {
        for(int i=0;i<programFilm.size()-1;i++)
        {
            for(int j=i+1;j<programFilm.size();j++)
            {
                if(this.isLower(this.getFilm(j),this.getFilm(i))==0)
                    swap(i,j);
            }
        }
    }
}
