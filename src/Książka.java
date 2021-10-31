import java.util.ArrayList;
import java.util.List;

public class Książka {      //Zakładamy, że każda książka jest nazywana unikalnym kodem z okładki
    String tytul;
    String autor;
    int liczba_wolnych = 0;
    List<Egzemplarz> egzemplarze;

    public Książka(String tytuł, String autor)
    {
        this.tytul = tytuł;
        this.autor = autor;
        egzemplarze = new ArrayList<Egzemplarz>();
    }

    public void DodajEgzemplarz(Egzemplarz e)
    {
        egzemplarze.add(e);
        liczba_wolnych++;

    }

    public Boolean Wypozycz(Czytelnik c)
    {

        for(Egzemplarz egzemplarz : egzemplarze)
        {
          if(egzemplarz.CzyWolne == true)
          {
              egzemplarz.CzyWolne = false;
              c.wypozyczone.add(egzemplarz);
              System.out.println("Twój egzemplarz ma numer id: " + egzemplarz.id);
              liczba_wolnych--;
              return true;
          }
        }
        return false;
    }

}
