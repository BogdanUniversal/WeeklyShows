package UI;


import Service.*;

import java.util.Scanner;

/**
 * Command line interface class.
 */
public class UI {
    Service s;

    /**
     * Default constructor.
     */
    public UI() {
        s=new Service();
    }

    public void afisMenu()
    {
        System.out.println("\n1. Filme");
        System.out.println("2. Jurnale");
        System.out.println("3. Showuri");
        System.out.println("4. Sporturi");
        System.out.println("5. Program pe o zi");
        System.out.println("0. Iesire");
    }

    public void afisMenuFilme()
    {
        System.out.println("\n1. Adaugare");
        System.out.println("2. Stergere");
        System.out.println("3. Update");
        System.out.println("4. Afisare tabel filme");
        System.out.println("0. Inapoi");
    }

    public void afisMenuJurnale()
    {
        System.out.println("\n1. Adaugare");
        System.out.println("2. Stergere");
        System.out.println("3. Update");
        System.out.println("4. Ordonare descrescatoare dupa durata");
        System.out.println("5. Afisare tabel jurnale");
        System.out.println("0. Inapoi");
    }

    public void afisMenuShowuri()
    {
        System.out.println("\n1. Adaugare");
        System.out.println("2. Stergere");
        System.out.println("3. Update");
        System.out.println("4. Afisare tabel showuri");
        System.out.println("0. Inapoi");
    }

    public void afisMenuSporturi()
    {
        System.out.println("\n1. Adaugare");
        System.out.println("2. Stergere");
        System.out.println("3. Update");
        System.out.println("4. Ordonare descrescatoare dupa durata");
        System.out.println("5. Afisare tabel sporturi");
        System.out.println("0. Inapoi");
    }

    public void add(int opt)
    {
        Scanner scn=new Scanner(System.in);
        System.out.print("\nIntroduceti ora: ");
        int ora=scn.nextInt();
        System.out.print("\nIntroduceti minutul: ");
        int minut=scn.nextInt();
        System.out.print("\nIntroduceti ziua: ");
        int zi=scn.nextInt();
        System.out.print("\nIntroduceti durata: ");
        int durata=scn.nextInt();
        String categorie;
        if(opt==1) {
            categorie = new String("film");
            s.add(ora,minut,zi,durata,categorie);
        }
        else if(opt==2)
        {
            categorie=new String("jurnal");
            s.add(ora,minut,zi,durata,categorie);
        }
        else if(opt==3)
        {
            categorie=new String("show");
            s.add(ora,minut,zi,durata,categorie);
        }
        else if(opt==4)
        {
            categorie=new String("sport");
            s.add(ora,minut,zi,durata,categorie);
        }
        System.out.println();
    }

    public void remove(int opt)
    {
        Scanner scn=new Scanner(System.in);
        System.out.print("\nIntroduceti ora: ");
        int ora=scn.nextInt();
        System.out.print("\nIntroduceti minutul: ");
        int minut=scn.nextInt();
        System.out.print("\nIntroduceti ziua: ");
        int zi=scn.nextInt();
        System.out.print("\nIntroduceti durata: ");
        int durata=scn.nextInt();
        String categorie;
        if(opt==1) {
            categorie = new String("film");
            s.remove(ora,minut,zi,durata,categorie);
        }
        else if(opt==2)
        {
            categorie=new String("jurnal");
            s.remove(ora,minut,zi,durata,categorie);
        }
        else if(opt==3)
        {
            categorie=new String("show");
            s.remove(ora,minut,zi,durata,categorie);
        }
        else if(opt==4)
        {
            categorie=new String("sport");
            s.remove(ora,minut,zi,durata,categorie);
        }
        System.out.println();
    }

    public String citireCategorie()
    {
        Scanner scn=new Scanner(System.in);
        System.out.print("\nIntroduceti categoria: ");
        String categorie;
        categorie=scn.nextLine();
        System.out.println("\n"+categorie);
        return categorie;
    }

    public void update(int opt)
    {
        Scanner scn=new Scanner(System.in);
        System.out.print("\nIntroduceti pozitia elemetului de updatat: ");
        int index=scn.nextInt();
        System.out.println("\nNoul element: ");
        System.out.print("\nIntroduceti ora: ");
        int ora=scn.nextInt();
        System.out.print("\nIntroduceti minutul: ");
        int minut=scn.nextInt();
        System.out.print("\nIntroduceti ziua: ");
        int zi=scn.nextInt();
        System.out.print("\nIntroduceti durata: ");
        int durata=scn.nextInt();
        System.out.println();
        if(opt==1)
            s.updateFilm(index,ora,minut,zi,durata);
        else if(opt==2)
            s.updateJurnal(index,ora,minut,zi,durata);
        else if(opt==3)
            s.updateShow(index,ora,minut,zi,durata);
        else if(opt==4)
            s.updateSport(index,ora,minut,zi,durata);
    }

    public void afisare(int opt)
    {
        System.out.format("\n%-7s | %-6s | %-5s | %-3s | %-1s\n","Zi","Ora","Minut","Durata","Categorie");
        System.out.print("-----------------------------------------------");
        if(opt==1)
        {
            for(int i=0;i<s.getSizeFilm();i++)
            {
                System.out.format("\n%7d | %6d | %5d | %3d | %1s",s.getFilm(i).getZi(),s.getFilm(i).getOra(),
                        s.getFilm(i).getMinut(),s.getFilm(i).getDurata(),s.getFilm(i).getCategorie());
            }
        }
        else if(opt==2)
        {
            for(int i=0;i<s.getSizeJurnal();i++)
            {
                System.out.format("\n%7d | %6d | %5d | %3d | %1s",s.getJurnal(i).getZi(),s.getJurnal(i).getOra(),
                        s.getJurnal(i).getMinut(),s.getJurnal(i).getDurata(),s.getJurnal(i).getCategorie());
            }
        }
        else if(opt==3)
            for(int i=0;i<s.getSizeShow();i++)
            {
                System.out.format("\n%7d | %6d | %5d | %3d | %1s",s.getShow(i).getZi(),s.getShow(i).getOra(),
                        s.getShow(i).getMinut(),s.getShow(i).getDurata(),s.getShow(i).getCategorie());
            }
        else if(opt==4)
            for(int i=0;i<s.getSizeSport();i++)
            {
                System.out.format("\n%7d | %6d | %5d | %3d | %1s",s.getSport(i).getZi(),s.getSport(i).getOra(),
                        s.getSport(i).getMinut(),s.getSport(i).getDurata(),s.getSport(i).getCategorie());
            }
    }

    public void afisareProgramZi(int zi)
    {
            System.out.println("\nProgram pentru ziua "+zi);
            System.out.println("\nFilme: ");
            System.out.format("\n%-7s | %-6s | %-5s | %-3s | %-1s\n","Zi","Ora","Minut","Durata","Categorie");
            System.out.print("-----------------------------------------------");
            for(int j=0;j<this.s.getSizeFilm();j++)
                if(s.getFilm(j).getZi()==zi)
                    System.out.format("\n%7d | %6d | %5d | %3d | %1s",s.getFilm(j).getZi(),s.getFilm(j).getOra(),
                            s.getFilm(j).getMinut(),s.getFilm(j).getDurata(),s.getFilm(j).getCategorie());
            System.out.println("\n\n\nJurnale: ");
            System.out.format("\n%-7s | %-6s | %-5s | %-3s | %-1s\n","Zi","Ora","Minut","Durata","Categorie");
            System.out.print("-----------------------------------------------");
            for(int j=0;j<this.s.getSizeJurnal();j++)
                if(s.getJurnal(j).getZi()==zi)
                    System.out.format("\n%7d | %6d | %5d | %3d | %1s",s.getJurnal(j).getZi(),s.getJurnal(j).getOra(),
                            s.getJurnal(j).getMinut(),s.getJurnal(j).getDurata(),s.getJurnal(j).getCategorie());
            System.out.println("\n\n\nShow-uri: ");
            System.out.format("\n%-7s | %-6s | %-5s | %-3s | %-1s\n","Zi","Ora","Minut","Durata","Categorie");
            System.out.print("-----------------------------------------------");
            for(int j=0;j<this.s.getSizeShow();j++)
                if(s.getShow(j).getZi()==zi)
                    System.out.format("\n%7d | %6d | %5d | %3d | %1s",s.getShow(j).getZi(),s.getShow(j).getOra(),
                            s.getShow(j).getMinut(),s.getShow(j).getDurata(),s.getShow(j).getCategorie());
            System.out.println("\n\n\nSporturi: ");
            System.out.format("\n%-7s | %-6s | %-5s | %-3s | %-1s\n","Zi","Ora","Minut","Durata","Categorie");
            System.out.print("-----------------------------------------------");
            for(int j=0;j<this.s.getSizeSport();j++)
                if(s.getSport(j).getZi()==zi)
                    System.out.format("\n%7d | %6d | %5d | %3d | %1s",s.getSport(j).getZi(),s.getSport(j).getOra(),
                            s.getSport(j).getMinut(),s.getSport(j).getDurata(),s.getSport(j).getCategorie());
    }

    public void run()
    {
        Scanner scn=new Scanner(System.in);
        int opt;
        int optMenu=-1;
        while(optMenu!=0)
        {
            afisMenu();
            System.out.print("\nIntroduceti optiunea: ");
            optMenu=scn.nextInt();
                switch (optMenu)
                {
                    case 1:
                        while(optMenu!=0)
                        {
                            afisMenuFilme();
                            System.out.print("\nIntroduceti optiunea: ");
                            optMenu= scn.nextInt();
                            switch (optMenu)
                            {
                                case 1:
                                    add(1);
                                    break;
                                case 2:
                                    remove(1);
                                    break;
                                case 3:
                                    update(1);
                                    break;
                                case 4:
                                    afisare(1);
                                    break;
                            }
                        }
                        optMenu=-1;
                        break;
                    case 2:
                        while(optMenu!=0)
                        {
                            afisMenuJurnale();
                            System.out.print("\nIntroduceti optiunea: ");
                            optMenu= scn.nextInt();
                            switch (optMenu)
                            {
                                case 1:
                                    add(2);
                                    break;
                                case 2:
                                    remove(2);
                                    break;
                                case 3:
                                    update(2);
                                    break;
                                case 4:
                                    this.s.sortareJurnal();
                                    break;
                                case 5:
                                    afisare(2);
                                    break;
                            }
                        }
                        optMenu=-1;
                        break;
                    case 3:
                        while(optMenu!=0)
                        {
                            afisMenuShowuri();
                            System.out.print("\nIntroduceti optiunea: ");
                            optMenu= scn.nextInt();
                            switch (optMenu)
                            {
                                case 1:
                                    add(3);
                                    break;
                                case 2:
                                    remove(3);
                                    break;
                                case 3:
                                    update(3);
                                    break;
                                case 4:
                                    afisare(3);
                                    break;
                            }
                        }
                        optMenu=-1;
                        break;
                    case 4:
                        while(optMenu!=0)
                        {
                            afisMenuSporturi();
                            System.out.print("\nIntroduceti optiunea: ");
                            optMenu= scn.nextInt();
                            switch (optMenu)
                            {
                                case 1:
                                    add(4);
                                    break;
                                case 2:
                                    remove(4);
                                    break;
                                case 3:
                                    update(4);
                                    break;
                                case 4:
                                    this.s.sortareSport();
                                    break;
                                case 5:
                                    afisare(4);
                                    break;
                            }
                        }
                        optMenu=-1;
                        break;
                    case 5:
                        System.out.print("\nIntroduceti ziua: ");
                        int zi=scn.nextInt();
                        this.afisareProgramZi(zi);
                        optMenu=-1;
                        break;
                }
        }
    }
}
