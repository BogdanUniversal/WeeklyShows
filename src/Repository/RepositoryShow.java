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
import java.util.List;

/**
 * Subclass of repository for storage of shows.
 */
public class RepositoryShow extends Repository{
    public List programShow=new ArrayList<Show>();

    /**
     * Default constructor
     */
    public RepositoryShow()
    {
        this.readFile();
    }

    /**
     * Try-catch method for reading shows from a file, using BufferedReader.
     */
    public void readFile()
    {
        try { BufferedReader fisIn =
                new BufferedReader(new FileReader("A:\\Laborator\\Java\\Lab4\\src\\showuri"));
            String s;
            //Masina
            while((s = fisIn.readLine())!= null){
                String[] felii =s.split(",");
                int ora=Integer.parseInt(felii[0]);
                int minut=Integer.parseInt(felii[1]);
                int zi= Integer.parseInt(felii[2]);
                int durata=Integer.parseInt(felii[3]);
                String categorie= new String(felii[4]);
                this.programShow.add(new Show(ora,minut,zi,durata,categorie));//alocarea efectiva pentru comp.
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
                new BufferedWriter(new FileWriter("A:\\Laborator\\Java\\Lab4\\src\\showuri"));
            int marime=this.programShow.size();
            if(marime==1)
            {
                String emisiune=new String(this.getShow(0).getOra() +","+this.getShow(0).getMinut()+
                        ","+this.getShow(0).getZi()+","+this.getShow(0).getDurata()+","+this.getShow(0).getCategorie());
                fisOut.write(emisiune);
            }
            else if(marime>1)
            {
                for(int i=0;i<this.programShow.size()-1;i++)
                {
                    String emisiune=new String(this.getShow(i).getOra() +","+this.getShow(i).getMinut()+
                            ","+this.getShow(i).getZi()+","+this.getShow(i).getDurata()+","+this.getShow(i).getCategorie());
                    fisOut.write(emisiune);
                    fisOut.newLine();
                }
                    int ultim=this.programShow.size()-1;
                    String emisiuneFinala=new String(this.getShow(ultim).getOra() +","+this.getShow(ultim).getMinut()+
                            ","+this.getShow(ultim).getZi()+","+this.getShow(ultim).getDurata()+","+this.getShow(ultim).getCategorie());
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
     * Get method for a show at a given position.
     * @param position = int.
     * @return Show.
     */
    public Show getShow(int position)
    {
        return (Show) this.programShow.get(position);
    }

    /**
     * Method that returns the position of a given show.
     * @param f = Show.
     * @return position if found, else -1 = int.
     */
    public int getPos(Show f)
    {
        for(int i=0;i<programShow.size();i++)
        {
            if(this.getShow(i).getOra()==f.getOra() && this.getShow(i).getMinut()==f.getMinut()
                    && this.getShow(i).getZi()==f.getZi() && this.getShow(i).getDurata()==f.getDurata()
                    && this.getShow(i).getCategorie() == f.getCategorie())
                return i;
        }
        return -1;
    }

    /**
     * Method that checks if a show already exists in the repository.
     * @param f = Show.
     * @return ex = 1 if it exists, 0 if not.
     */
    public boolean exista(Show f)
    {
        boolean ex=false;
        for(int i=0;i<programShow.size();i++)
        {
            if(this.getShow(i).getOra()==f.getOra() && this.getShow(i).getMinut()==f.getMinut()
                    && this.getShow(i).getZi()==f.getZi() && this.getShow(i).getDurata()==f.getDurata()
                    && this.getShow(i).getCategorie() == f.getCategorie())
                ex=true;
        }
        return ex;
    }

    /**
     * Method for adding a show to the repository.
     * @param s = Show.
     */
    public void addShow(Show s)
    {
        if(this.exista(s)) System.out.println("Filmul exista deja!");
        else {
            this.programShow.add(s);
            this.saveFile();
        }
    }

    /**
     * Method for removing a show from the repository.
     * @param s = Show.
     */
    public void removeShow(Show s)
    {
        if(this.exista(s)) {
            this.programShow.remove(this.getPos(s));
            this.saveFile();
        }
        else System.out.println("Elementul nu exista!");
    }

    /**
     * Set method that replaces the show at a given position with the given show.
     * @param position = int.
     * @param s = Show.
     */
    public void set(int position, Show s)
    {
        this.programShow.set(position,s);
        this.saveFile();
    }

    /**
     * Method that removes a show from a given position.
     * @param position = int.
     */
    public void remove(int position)
    {
        this.programShow.remove(position);
    }

    /**
     * Get method for the size of the repository.
     * @return size = int.
     */
    public int getSize()
    {
        return programShow.size();
    }

    /**
     * Get method that returns all the objects in the repository.
     * @return ArrayList<Show>.
     */
    public ArrayList<Show> getAll()
    {
        return (ArrayList<Show>) this.programShow;
    }

    /**
     * Swap method that swaps the elements at the given positions.
     * @param i = int.
     * @param j = int.
     */
    public void swap(int i, int j)
    {
        Show f=this.getShow(i);
        this.set(i,this.getShow(j));
        this.set(j,f);
    }

    /**
     * Method that compares the dates of two given shows.
     * @param f1 = Show.
     * @param f2  = Show.
     * @return 1 if f1 is later, 0 if f2 is = int.
     */
    public int isLower(Show f1, Show f2)
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
        for(int i=0;i<programShow.size()-1;i++)
        {
            for(int j=i+1;j<programShow.size();j++)
            {
                if(this.isLower(this.getShow(j),this.getShow(i))==0)
                    swap(i,j);
            }
        }
    }
}
