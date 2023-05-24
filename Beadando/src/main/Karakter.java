package main;

//ez egy abstract osztály, amiből öröklödtetjük majd a Harcos és Varazslo osztályt
public abstract class Karakter {
    protected String nev;
    protected int eletero;

    //2 paraméteres konstruktor
    public Karakter(String nev, int eletero) {
        this.nev = nev;
        this.eletero = eletero;
    }

    //tamad metódust itt deklaráljuk, de a implementációt a leszármaztatott osztályokban hajtjuk végre
    public abstract void tamad(Karakter ellenfel);

    //életerőből levonja a sebzés értékét, ha az életerő kisebb vagy egyenlő lenne mint 0, akkor 0-ra állítja
    public void sebez(int sebzes) {
        eletero -= sebzes;
        if (eletero <= 0) {
            eletero = 0;            
        }
    }

    public int getEletero() {
        return eletero;
    }
}
