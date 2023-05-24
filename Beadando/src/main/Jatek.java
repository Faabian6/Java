package main;

import java.util.Random;

public class Jatek {
    private static final int MERET = 3; // Játéktér mérete

    private static final char HAROS_JEL = 'H'; // Harcos jelölése
    private static final char VARAZSLO_JEL = 'V'; // Varázsló jelölése
    private static final char URES_MEZO = '_'; // Üres mező karaktere
    private static final char EGYHELYEN_JELOLO = 'X'; // Ha mindkét karakter egy helyen áll

    private static final int KEZDO_ELETEK = 9; // Kezdő életpontok száma
    private static final int SEBZES_HATAR = 6; // Maximális sebzés értéke

    private char[] jatekTer;
    private Random random;

    private Harcos harcos;
    private Varazslo varazslo;

    public Jatek() {
        //jatekTer tömb és a random inicializálása
        jatekTer = new char[MERET];
        random = new Random();
        initJatekTer();

        //harcos és varazslo objektumok létrehozása és felparaméterezése
        harcos = new Harcos("Harcos", KEZDO_ELETEK, SEBZES_HATAR);
        varazslo = new Varazslo("Varazslo", KEZDO_ELETEK, SEBZES_HATAR);
    }

    //jatekTer tömb elemeinek inicializálása az URES_MEZO értékre
    private void initJatekTer() {
        for (int i = 0; i < MERET; i++) {
            jatekTer[i] = URES_MEZO;
        }
    }

    
    //karakterek elhelyezése a jatekTer tömbben a megfelelő indexeken
    public void elhelyezKarakterek() {
        
        //harcosIndex és varazsloIndex változóknak véletlenszerű index generálása a MERET határok között
        int harcosIndex = random.nextInt(MERET);
        int varazsloIndex = random.nextInt(MERET);

        //karakterek megfelelő indexen való elhelyezése a tömbben,
        //azonos index esetén "X", üres hely esetén "_" jel kirajzolása
        for (int i = 0; i < MERET; i++) {
            if (i == harcosIndex && i == varazsloIndex) {
                jatekTer[i] = EGYHELYEN_JELOLO;
            } else if (i == harcosIndex) {
                jatekTer[i] = HAROS_JEL;
            } else if (i == varazsloIndex) {
                jatekTer[i] = VARAZSLO_JEL;
            } else {
                jatekTer[i] = URES_MEZO;
            }
        }
    }

    //harc esetén az adott karakter a dobásának megfelelő értékkel sebzi ellenfelét
    public void harcEsSebzodes() {
        for (char karakter : jatekTer) {
            if (karakter == EGYHELYEN_JELOLO) {
                harcos.tamad(varazslo);
                varazslo.tamad(harcos);
                break; // Kilépünk a ciklusból, ha találtunk harcot
            }
        }
    }

    //kirajzoljuk a jatekter elemeit egy for ciklussal, ha valahol "X"-et találunk,
    //akkor  harci állapotot rajzoljuk ki, különben az alap állapotot
    public void jatekTerKirajzol() {
        boolean vanHarc = false;

        for (int i = 0; i < MERET; i++) {
            System.out.print(jatekTer[i]);
            if (jatekTer[i] == EGYHELYEN_JELOLO) {
                vanHarc = true;
            }
        }

        if (vanHarc) {
            System.out.println(" --> Harc! H:" + harcos.eletero + ", V:" + varazslo.eletero);
        } else {
            System.out.println(" --> H:" + harcos.eletero + ", V:" + varazslo.eletero);
        }
    }

    //Addig futatjuk a programunkat amíg az egyik karakter életereje 0 vagy kevesebb lesz
    //kiírjuk a győztest
    public void jatekFutas() {
        int kor = 1;
        while (harcos.getEletero() > 0 && varazslo.getEletero() > 0) {
            System.out.println("Kor: " + kor);
            elhelyezKarakterek();
            harcEsSebzodes();
            jatekTerKirajzol();
            System.out.println();
            kor++;
        }
        System.out.println("Jatek vege!");
        if (harcos.getEletero() <= 0 && varazslo.getEletero() <= 0) {
            System.out.println("Dontetlen!");
        } else if (harcos.getEletero() <= 0) {
            System.out.println("A Varazslo gyozott!");
        } else {
            System.out.println("A Harcos gyozott!");
        }
    }
    //alapfeladat teljes
    
    
}
