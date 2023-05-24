# Java
Az OOP elveinek megfelelően készítettem egy konzolos vastagkliens alkalmazást!

Egy háromelemű játéktérben áll egymással szemben egy harcos és egy varázsló. Kezdetben d6+3 életerejük van (d6: 6 oldalú kocka). Véletlenszerűen lépnek bármelyik mezőre, ha ugyanott vannak, akkor harcolnak! A harc során sebzik egymást, d6 pontot levonva a másik életerejéből. Minden kört és állást bemutattam a következő módon:

Kor: 1
VH_ --> H:9, V:9

Kor: 2
__X --> Harc! H:4, V:7

Kor: 3
VH_ --> H:4, V:7

Kor: 4
X__ --> Harc! H:0, V:3

Jatek vege!
A Varazslo gyozott!

Ha valamelyik karakternek az életereje eléri a 0-át, akkkor véget ér a játék és kiírjuk melyik karakter nyert.

Egy kis plusz dolgot beletettem, hogy ha lefut a játék és ezt kiírja a konzolra, utána felugrik egy ablak, hogy szeretnénk-e menteni a játék menetét. (Java Swing segítségével oldottam meg)
Igen esetén felugrik egy kezelő felület ahol tallőzva megadhatjuk a txt fájl mentésének helyét és el is nevezhetjük azt. Nem esetén véget ér a program.
