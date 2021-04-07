package Service;

import Domain.Film;
import Domain.Jurnal;
import Domain.Show;
import Domain.Sport;
import Repository.*;

import java.util.ArrayList;

/**
 * Class that manages all the repositores and their methods.
 */
public class Service {
    private final RepositoryFilm repoFilm = new RepositoryFilm();
    private final RepositoryJurnal repoJurnal = new RepositoryJurnal();
    private final RepositoryShow repoShow = new RepositoryShow();
    private final RepositorySport repoSport = new RepositorySport();

    /**
     * Default constructor.
     */
    public Service() { }

    /**
     * Method that adds an element to the repository based on the "categorie"(category) parameter and reorders them.
     * @param ora = int.
     * @param minut = int.
     * @param zi = int.
     * @param durata = int.
     * @param categorie = String.
     */
    public void add(int ora, int minut, int zi, int durata, String categorie)
    {
        if(categorie.equals("film"))
            this.repoFilm.addFilm(new Film(ora, minut, zi, durata, categorie));
        else if(categorie.equals("jurnal"))
            this.repoJurnal.addJurnal(new Jurnal(ora, minut, zi, durata, categorie));
        else if(categorie.equals("show"))
            this.repoShow.addShow(new Show(ora, minut, zi, durata, categorie));
        else if(categorie.equals("sport"))
            this.repoSport.addSport(new Sport(ora, minut, zi, durata, categorie));
        else System.out.println("Categorie gresita la add!");
        this.repoFilm.sortare();
        this.repoJurnal.sortare2();
        this.repoShow.sortare();
        this.repoSport.sortare2();
    }

    /**
     * Method that removes an element from the repository based on the "categorie"(category) parameter and reorders them.
     * @param ora = int.
     * @param minut = int.
     * @param zi = int.
     * @param durata = int.
     * @param categorie = String.
     */
    public void remove(int ora, int minut, int zi, int durata, String categorie)
    {
        if(categorie.equals("film"))
            this.repoFilm.removeFilm(new Film(ora, minut, zi, durata, categorie));
        else if(categorie.equals("jurnal"))
            this.repoJurnal.removeJurnal(new Jurnal(ora, minut, zi, durata, categorie));
        else if(categorie.equals("show"))
            this.repoShow.removeShow(new Show(ora, minut, zi, durata, categorie));
        else if(categorie.equals("sport"))
            this.repoSport.removeSport(new Sport(ora, minut, zi, durata, categorie));
        else System.out.println("Categorie gresita la remove!");
    }

    /**
     * Method that replaces a "film"(movie) at a given position.
     * @param position = int.
     * @param ora = int.
     * @param minut = int.
     * @param zi = int.
     * @param durata = int.
     */
    public void updateFilm(int position, int ora, int minut, int zi, int durata)
    {
        repoFilm.set(position, new Film(ora,minut,zi,durata,"film"));
        this.repoFilm.sortare();
    }

    /**
     * Method that replaces a "jurnal"(Journal) at a given position.
     * @param position = int.
     * @param ora = int.
     * @param minut = int.
     * @param zi = int.
     * @param durata = int.
     */
    public void updateJurnal(int position, int ora, int minut, int zi, int durata)
    {
        this.repoJurnal.set(position, new Jurnal(ora,minut,zi,durata,"jurnal"));
        this.repoJurnal.sortare2();
    }

    /**
     * Method that replaces a show at a given position.
     * @param position = int.
     * @param ora = int.
     * @param minut = int.
     * @param zi = int.
     * @param durata = int.
     */
    public void updateShow(int position, int ora, int minut, int zi, int durata)
    {
        this.repoShow.set(position, new Show(ora,minut,zi,durata,"show"));
        this.repoShow.sortare();
    }

    /**
     * Method that replaces a sport at a given position.
     * @param position = int.
     * @param ora = int.
     * @param minut = int.
     * @param zi = int.
     * @param durata = int.
     */
    public void updateSport(int position, int ora, int minut, int zi, int durata)
    {
        this.repoSport.set(position, new Sport(ora,minut,zi,durata,"sport"));
        this.repoSport.sortare2();
    }

    /**
     * Get method that returns a "film"(movie) at a given position.
     * @param position = int.
     * @return Film.
     */
    public Film getFilm(int position)
    {
        return repoFilm.getFilm(position);
    }

    /**
     * Get method that returns a "jurnal"(journal) at a given position.
     * @param position = int.
     * @return Film.
     */
    public Jurnal getJurnal(int position)
    {
        return repoJurnal.getJurnal(position);
    }

    /**
     * Get method that returns a show at a given position.
     * @param position = int.
     * @return Film.
     */
    public Show getShow(int position)
    {
        return repoShow.getShow(position);
    }

    /**
     * Get method that returns a sport at a given position.
     * @param position = int.
     * @return Film.
     */
    public Sport getSport(int position)
    {
        return repoSport.getSport(position);
    }


    /**
     * Get method that returns all the movies.
     * @return ArrayList<Film>.
     */
    public ArrayList<Film> getAllFilm()
    {
        return this.repoFilm.getAll();
    }

    /**
     * Get method that returns all the journals.
     * @return ArrayList<Jurnal>.
     */
    public ArrayList<Jurnal> getAllJurnal()
    {
        return this.repoJurnal.getAll();
    }

    /**
     * Get method that returns all the shows.
     * @return ArrayList<Show>.
     */
    public ArrayList<Show> getAllShow()
    {
        return this.repoShow.getAll();
    }

    /**
     * Get method that returns all the sports.
     * @return ArrayList<Show>.
     */
    public ArrayList<Sport> getAllSport()
    {
        return this.repoSport.getAll();
    }

    /**
     * Get method that returns the size of the movies repository.
     * @return int.
     */
    public int getSizeFilm()
    {
        return repoFilm.getSize();
    }

    /**
     * Get method that returns the size of the journals repository.
     * @return int.
     */
    public int getSizeJurnal()
    {
        return repoJurnal.getSize();
    }

    /**
     * Get method that returns the size of the shows repository.
     * @return int.
     */
    public int getSizeShow()
    {
        return repoShow.getSize();
    }

    /**
     * Get method that returns the size of the sports repository.
     * @return int.
     */
    public int getSizeSport()
    {
        return repoSport.getSize();
    }

    /**
     * Sort method that reorders the objects in the repository based on the overridden comparator.
     */
    public void sortareSport()
    {
        this.repoSport.sortare();
    }

    /**
     * Sort method that reorders the objects in the repository based on the overridden comparator.
     */
    public void sortareJurnal()
    {
        this.repoJurnal.sortare();
    }
}
