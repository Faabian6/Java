package main;

public class Varazslo extends Karakter {
    
    private int sebzesHatar;

    //A Varazslo osztály konstruktorának paramétereként megadott sebzesHatar értéket beállítja a sebzesHatar adattagba
    //Az ősosztály konstruktorát meghívja a super(nev, eletero) segítségével.
    public Varazslo(String nev, int eletero, int sebzesHatar) {
        super(nev, eletero);
        this.sebzesHatar = 6;
    }

    //A tamad metódusban ellenőrzi, hogy az ellenfél objektum Harcos típusú-e
    //Ha igen, akkor generál egy sebzés értéket és meghívja az ellenfél sebez metódusát a sebzés értékével
    //Ha az ellenfél nem Harcos, akkor kiírja egy üzenetet, hogy csak harcost támadhat meg a varázsló
    @Override
    public void tamad(Karakter ellenfel) {
        if (ellenfel instanceof Harcos) {
            int sebzes = RandomUtils.nextInt(sebzesHatar);
            ellenfel.sebez(sebzes);
        } else {
            System.out.println("Csak harcost tamadhat meg a varazslo!");
        }
    }
}

