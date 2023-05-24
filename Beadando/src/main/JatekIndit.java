package main;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class JatekIndit {

    public static void main(String[] args) {
        // Játék futtatása és konzolra kiírt szöveg elmentése
        String konzolSzoveg = runJatek();

        // Konzolon kiírt szöveg megjelenítése
        System.out.println(konzolSzoveg);

        // Felugró ablak a mentéshez
        int valasz = JOptionPane.showConfirmDialog(null, "Szeretné menteni a szöveget?");

        if (valasz == JOptionPane.YES_OPTION) {
            // Szöveg mentése
            saveToFile(konzolSzoveg);
            System.out.println("Szoveg sikeresen elmentve a fajlba.");
        } else {
            System.out.println("A program veget ert.");
        }
    }
    
    // Játék futtatása és konzolra kiírt szöveg visszaadása
    private static String runJatek() {
   
        Jatek jatek = new Jatek();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream eredetiSystemOut = System.out;
        System.setOut(ps);
        jatek.jatekFutas();
        System.setOut(eredetiSystemOut);
        return baos.toString();
    }

    //A konzolra kiírt szöveg implementálása egy mentés fájlba
    private static void saveToFile(String szoveg) {
        
    // Felugró ablak a fájl mentéséhez    
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Mentes");
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

    // Ha a felhasználó kiválasztott egy fájlt és megerősítette a mentést,
    // akkor a kiválasztott fájl neve és elérési útja alapján elkészül a fájl
    // és belekerül a szöveg. Ha bármilyen hiba történik a fájl írása közben,
    // akkor a hibaüzenet kiíródik a konzolra. Ha a mentés megszakadt vagy nem
    // választottak ki fájlt, akkor a Mentes megszakitva üzenet jelenik meg a konzolon.
    int result = fileChooser.showSaveDialog(null);
    if (result == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            writer.println(szoveg);
            System.out.println("Szoveg sikeresen elmentve a fajlba: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Hiba tortént a fajl irasa kozben: " + e.getMessage());
        }
    } else {
        System.out.println("Mentes megszakitva.");
    }
}
}


