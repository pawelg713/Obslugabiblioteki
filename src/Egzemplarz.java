public class Egzemplarz {
    int id;
    Boolean CzyWolne = true;


    public Egzemplarz(int id)
    {
        this.id = id;
    }

    @Override
    public String toString() {
        if(CzyWolne == true) {
            return "Egzemplarz książki o numerze id + " + id + "jest wolny.";
        }
        else
        {
            return "Egzemplarz książki o numerze id + " + id + "jest zajęty.";

        }
    }
}
