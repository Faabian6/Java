package main;

public class Harcos extends Karakter {
    
    private int sebzesHatar;

    //A Harcos osztály konstruktorának paramétereként megadott sebzesHatar értéket beállítja a sebzesHatar adattagba
    //Az ősosztály konstruktorát meghívja a super(nev, eletero) segítségével
    public Harcos(String nev, int eletero, int sebzesHatar) {
        super(nev, eletero);
        this.sebzesHatar = 6;
    }

    //A tamad metódusban ellenőrzi, hogy az ellenfél objektum Varazslo típusú-e
    //Ha igen, akkor generál egy sebzés értéket és meghívja az ellenfél sebez metódusát a sebzés értékével
    //Ha az ellenfél nem Varazslo, akkor kiírja egy üzenetet, hogy csak varázslót támadhat meg a harcos
    @Override
    public void tamad(Karakter ellenfel) {
        if (ellenfel instanceof Varazslo) {
            int sebzes = RandomUtils.nextInt(sebzesHatar);           
            ellenfel.sebez(sebzes);
        } else {
            System.out.println("Csak varazslot tamadhat meg a harcos!");
        }
    }
}
