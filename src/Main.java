import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Biblioteka biblioteka = new Biblioteka();
    Czytelnicy czytelnicy = new Czytelnicy();
    Książka a1 = new Książka("Pan Tadeusz", "Adam Mickiewicz");
    Książka a2 = new Książka("Lalka", "Bolesław Prus");
    Egzemplarz a11 = new Egzemplarz(92384);
    Egzemplarz a12 = new Egzemplarz(290389304);
    Egzemplarz a21 = new Egzemplarz(40234);
    Egzemplarz a22 = new Egzemplarz(293425);
    Egzemplarz a23 = new Egzemplarz(020303);
    a1.DodajEgzemplarz(a11);
    a1.DodajEgzemplarz(a12);
    a2.DodajEgzemplarz(a21);
    a2.DodajEgzemplarz(a22);
    a2.DodajEgzemplarz(a23);
    biblioteka.ZbiorKsiazek.add(a1);
    biblioteka.ZbiorKsiazek.add(a2);





    int Podaj = 0;

                //  INTERAKCJA Z UŻYTKOWNIKIEM
        while(Podaj != 4) {
            Podaj = 0;
            System.out.println("Witamy w bibliotece. Co chcesz zrobić? ");
            System.out.println("1 - zalogować się jako czytelnik\n2 - zalogować się jako bibliotekarz\n3 - założyć konto czytelnika\n4- Zakończ");
            Scanner scan = new Scanner(System.in);
            Podaj = scan.nextInt();
            scan.nextLine();

            if (Podaj == 1) {
                String imie, nazwisko, haslo;


                System.out.println("Podaj imię!");
                imie = scan.nextLine();

                System.out.println("Podaj nazwisko!");
                nazwisko = scan.nextLine();

                System.out.println("Podaj hasło!");
                haslo = scan.nextLine();

                Boolean zalogowany = false;
                Czytelnik użytkownik = null;
                for (Czytelnik c : czytelnicy.ZbiorCzytelników) {

                    if (c != null && c.CzyTakieSame(imie, nazwisko, haslo)) {
                        zalogowany = true;
                        użytkownik = c;
                        System.out.println("Zalogowałeś się!");
                    }
                }


                // ZALOGOWANY UŻYTKOWNIK


                if (zalogowany == true) {
                    System.out.println("Co chcesz zrobić\n1 - Wypożyczyć książkę\n 2- Oddać książkę");
                    Podaj = scan.nextInt();
                    scan.nextLine();
                                        // WYPOŻYCZANIE KSIĄŻKI
                    if (Podaj == 1) {

                        Boolean czyJest = false;
                        System.out.println("Podaj tytuł książki!");
                        String szukany = scan.nextLine();
                        for (Książka k : biblioteka.ZbiorKsiazek) {
                            if (k.tytul.equals(szukany)) {
                                czyJest = true;
                                Książka wypożyczana = k;
                                if (k.Wypozycz(użytkownik)) {
                                    System.out.println("Wypożyczyłeś książkę: " + szukany);
                                    użytkownik.ksiazki.add(wypożyczana);
                                } else {
                                    System.out.println("Niestety książka nie jest obecnie dostępna!");
                                }

                            }
                        }
                        if (czyJest == false) {
                            System.out.println("Podanego tytułu nie ma w naszej bibliotece!");
                        }
                       }
                                            // ODDANIE KSIĄŻKI
                        if(Podaj == 2)
                        {

                            Boolean czyJest = false;
                            System.out.println("Podaj tytuł książki!");
                            String tytulszukany = scan.nextLine();
                            System.out.println("Podaj numer egzemplarza!");
                            int szukana = scan.nextInt();
                            scan.nextLine();

                            if(użytkownik.OddajKsiazke(szukana))
                            {
                                for(Książka a : biblioteka.ZbiorKsiazek)
                                {
                                    if (tytulszukany.equals(a.tytul))
                                    {
                                        a.liczba_wolnych++;
                                    }
                                }
                                System.out.println("Książka została oddana!");
                            }
                            else
                            {
                                System.out.println("Nie wypożyczałeś tego egzemplarza!");
                            }
                        }


                }   // NIE ZALOGOWAŁ SIĘ
                else {
                    System.out.println("Nie ma takiego użytkownika!");
                }
            }



            // ZAKŁADANIE KONTA CZYTELNIKA
            if (Podaj == 3) {
                String a, b, c;
                System.out.println("Podaj imię!");
                a = scan.nextLine();

                System.out.println("Podaj nazwisko!");
                b = scan.nextLine();

                System.out.println("Podaj hasło!");
                c = scan.nextLine();

                Czytelnik nowy = new Czytelnik(a, b, c);
                czytelnicy.ZbiorCzytelników.add(nowy);

                System.out.println("Zarejestrowano użytkownika!");
            }

            if(Podaj == 2)
            {
                System.out.println("Podaj hasło!");
                String password = scan.nextLine();
                if (password.equals("admin")) // Umowne hasło
                {
                    System.out.println("1 - Sprawdź wypożyczone książki danego czytelnika");
                    System.out.println("Podaj imię czytelnika!");
                    String x = scan.nextLine();
                    System.out.println("Podaj nazwisko czytelnika!");
                    String y = scan.nextLine();
                    for(Czytelnik a : czytelnicy.ZbiorCzytelników)
                    {
                        if (a.Imię.equals(x) && a.Nazwisko.equals(y))
                        {
                            System.out.println("Wypożyczone książki " + x + " "+ y + ":");
                            for(Książka ks : a.ksiazki)
                            {
                                System.out.println("Tytuł: " +  ks.tytul + " Autor: " + ks.autor);

                            }

                        }
                    }
                }
            }
        }
        System.out.println("Dziękujemy za odwiedzenie biblioteki!");
    }
}
