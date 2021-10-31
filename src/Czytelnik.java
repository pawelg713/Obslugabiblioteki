import java.util.ArrayList;
import java.util.List;

public class Czytelnik {
    String Imię;
    String Nazwisko;
    String haslo;
    List<Egzemplarz> wypozyczone;
    List<Książka> ksiazki;

    public Czytelnik(String imię, String Nazwisko, String haslo)
    {
        this.Imię = imię;
        this.Nazwisko = Nazwisko;
        this.haslo = haslo;
        wypozyczone = new ArrayList<Egzemplarz>();
        ksiazki = new ArrayList<Książka>();
    }

    public String getImię() {
        return Imię;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public String getHaslo() {
        return haslo;
    }

    public Boolean CzyTakieSame(String imie, String nazwisko, String haslo)
    {
        if(Imię.equals(imie) && Nazwisko.equals(nazwisko) && this.haslo.equals((haslo)))
        {
            return true;
        }
        return false;
    }
    public Boolean OddajKsiazke(int id) {
        for (Egzemplarz j : wypozyczone) {
            if (j.id == id) {

                wypozyczone.remove(j);
                j.CzyWolne = true;
                return true;
            }


        }
        return false;
    }
    public void Wypisz() {
        for(Książka x : this.ksiazki)
        {
            System.out.println("Tytuł: " +  x.tytul + " Autor: " + x.autor);

        }
    }
}
