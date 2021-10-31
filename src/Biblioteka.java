import java.util.ArrayList;
import java.util.List;

public class Biblioteka {
    List<Książka> ZbiorKsiazek;
    public Biblioteka()
    {
        ZbiorKsiazek = new ArrayList<Książka>();
    }

    public void DodajKsiazke(Książka k)
    {
        ZbiorKsiazek.add(k);
    }
}
