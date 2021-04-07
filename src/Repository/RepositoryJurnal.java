package Repository;

import Domain.Film;
import Domain.Jurnal;
import Domain.Sport;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Subclass of repository for storage of journals.
 */
public class RepositoryJurnal extends Repository{
    public List programJurnal=new ArrayList<Jurnal>();

    /**
     * Default constructor.
     */
    public RepositoryJurnal()
    {
        this.readFile();
    }

    /**
     * Try-catch method for reading journals from a file, using BufferedReader.
     */
    public void readFile()
    {
        try { BufferedReader fisIn =
                new BufferedReader(new FileReader("A:\\Laborator\\Java\\Lab4\\src\\jurnale"));
            String s;
            while((s = fisIn.readLine())!= null){
                String[] felii =s.split(",");
                int ora=Integer.parseInt(felii[0]);
                int minut=Integer.parseInt(felii[1]);
                int zi= Integer.parseInt(felii[2]);
                int durata=Integer.parseInt(felii[3]);
                String categorie= new String(felii[4]);
                this.programJurnal.add(new Jurnal(ora,minut,zi,durata,categorie));//alocarea efectiva pentru comp.
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
                new BufferedWriter(new FileWriter("A:\\Laborator\\Java\\Lab4\\src\\jurnale"));
            int marime=this.programJurnal.size();
            if(marime==1)
            {
                String emisiune=new String(this.getJurnal(0).getOra() +","+this.getJurnal(0).getMinut()+
                        ","+this.getJurnal(0).getZi()+","+this.getJurnal(0).getDurata()+","+this.getJurnal(0).getCategorie());
                fisOut.write(emisiune);
            }
            else if(marime>1)
            {
                for(int i=0;i<this.programJurnal.size()-1;i++)
                {
                    String emisiune=new String(this.getJurnal(i).getOra() +","+this.getJurnal(i).getMinut()+
                            ","+this.getJurnal(i).getZi()+","+this.getJurnal(i).getDurata()+","+this.getJurnal(i).getCategorie());
                    fisOut.write(emisiune);
                    fisOut.newLine();
                }
                int ultim=this.programJurnal.size()-1;
                String emisiuneFinala=new String(this.getJurnal(ultim).getOra() +","+this.getJurnal(ultim).getMinut()+
                        ","+this.getJurnal(ultim).getZi()+","+this.getJurnal(ultim).getDurata()+","+this.getJurnal(ultim).getCategorie());
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
     * Get method for a "jurnal"(journal) at a given position.
     * @param position = int.
     * @return Journal.
     */
    public Jurnal getJurnal(int position)
    {
        return (Jurnal) this.programJurnal.get(position);
    }

    /**
     * Method that returns the position of a given "jurnal"(Journal).
     * @param f = Journal.
     * @return position if found, else -1 = int.
     */
    public int getPos(Jurnal f)
    {
        for(int i=0;i<programJurnal.size();i++)
        {
            if(this.getJurnal(i).getOra()==f.getOra() && this.getJurnal(i).getMinut()==f.getMinut()
                    && this.getJurnal(i).getZi()==f.getZi() && this.getJurnal(i).getDurata()==f.getDurata()
                    && this.getJurnal(i).getCategorie() == f.getCategorie())
                return i;
        }
        return -1;
    }

    /**
     * Method that checks if a "jurnal"(Journal) already exists in the repository.
     * @param f = Film.
     * @return ex = 1 if it exists, 0 if not.
     */
    public boolean exista(Jurnal f)
    {
        boolean ex=false;
        for(int i=0;i<programJurnal.size();i++)
        {
            if(this.getJurnal(i).getOra()==f.getOra() && this.getJurnal(i).getMinut()==f.getMinut()
                    && this.getJurnal(i).getZi()==f.getZi() && this.getJurnal(i).getDurata()==f.getDurata()
                    && this.getJurnal(i).getCategorie() == f.getCategorie())
                ex=true;
        }
        return ex;
    }

    /**
     * Method for adding a "jurnal"(Journal) to the repository.
     * @param j = Journal.
     */
    public void addJurnal(Jurnal j)
    {
        if(this.exista(j)) System.out.println("Jurnalul exista deja!");
        else {
            this.programJurnal.add(j);
            this.saveFile();
        }
    }

    /**
     * Method for removing a "jurnal"(Journal) from the repository.
     * @param j = Journal.
     */
    public void removeJurnal(Jurnal j)
    {
        if(this.exista(j)==true) {
            this.programJurnal.remove(this.getPos(j));
            this.saveFile();
        }
        else System.out.println("Elementul nu exista!");
    }

    /**
     * Set method that replaces the "jurnal"(Journal) at a given position with the given "jurnal"(Journal).
     * @param position = int.
     * @param j = Journal.
     */
    public void set(int position, Jurnal j)
    {
        this.programJurnal.set(position,j);
        this.saveFile();
    }

    /**
     * Method for removing a "jurnal"(Journal) from the repository from a given position.
     * @param position = int.
     */
    public void remove(int position)
    {
        this.programJurnal.remove(position);
    }

    /**
     * Get method for the size of the repository.
     * @return size = int.
     */
    public int getSize()
    {
        return programJurnal.size();
    }

    /**
     * Get method that returns all the objects in the repository.
     * @return ArrayList<Journal>.
     */
    public ArrayList<Jurnal> getAll()
    {
        return (ArrayList<Jurnal>) this.programJurnal;
    }

    /**
     * Sort method that reorders the objects in the repository based on the overridden comparator.
     */
    public void sortare()
    {
        Collections.sort(this.programJurnal, new Jurnal());
        this.saveFile();
    }

    /**
     * Swap method that swaps the elements at the given positions.
     * @param i = int.
     * @param j = int.
     */
    public void swap(int i, int j)
    {
        Jurnal f=this.getJurnal(i);
        this.set(i,this.getJurnal(j));
        this.set(j,f);
    }

    /**
     * Method that compares the dates of two given journals.
     * @param f1 = Journal.
     * @param f2  = Journal.
     * @return 1 if f1 is later, 0 if f2 is = int.
     */
    public int isLower(Jurnal f1, Jurnal f2)
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
        for(int i=0;i<programJurnal.size()-1;i++)
        {
            for(int j=i+1;j<programJurnal.size();j++)
            {
                if(this.isLower(this.getJurnal(j),this.getJurnal(i))==0)
                    swap(i,j);
            }
        }
    }
}
