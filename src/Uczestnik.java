import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Uczestnik {
    private String imie;
    private String nazwisko;
    private String szkola;
    private int klasa;
    private String poziom_trudnosci;
    private int punkty;

    public static ArrayList<Uczestnik> Download(String filepath) {
        ArrayList<Uczestnik> Wynik = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filepath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            int count = 0;

            while ((line = bufferedReader.readLine()) != null) {
                if (count != 0) {
                    String[] lines = line.split("\\|");
                    Uczestnik uczestnik = new Uczestnik(lines[0], lines[1], lines[2], Integer.parseInt(lines[3]), lines[4], Integer.parseInt(lines[5]));
                    Wynik.add(uczestnik);
                }
                count++;
            }
            bufferedReader.close();
            return Wynik;

        } catch (IOException e) {

            e.printStackTrace();
        }
        return null;
    }

    public Uczestnik(String Imie, String Nazwisko, String Szkola, int Klasa, String Poziom_trudnosci, int punkty) {
        this.imie = Imie;
        this.nazwisko = Nazwisko;
        this.szkola = Szkola;
        this.klasa = Klasa;
        this.poziom_trudnosci = Poziom_trudnosci;
        setPunkty(punkty);

    }

    @Override
    public String toString() {
        return "Uczestnik{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", szkola='" + szkola + '\'' +
                ", klasa=" + klasa +
                ", poziom_trudnosci='" + poziom_trudnosci + '\'' +
                ", punkty=" + punkty +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Uczestnik uczestnik = (Uczestnik) o;
        return klasa == uczestnik.klasa && punkty == uczestnik.punkty && Objects.equals(imie, uczestnik.imie) && Objects.equals(nazwisko, uczestnik.nazwisko) && Objects.equals(szkola, uczestnik.szkola) && Objects.equals(poziom_trudnosci, uczestnik.poziom_trudnosci);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, nazwisko, szkola, klasa, poziom_trudnosci, punkty);
    }

    public int getKlasa() {
        return klasa;
    }

    public void setKlasa(int klasa) {
        this.klasa = klasa;
    }

    public int getPunkty() {
        return punkty;
    }

    public void setPunkty(int punkty) throws IllegalArgumentException {
        if (punkty < 0 || punkty > 100) {
            throw new IllegalArgumentException("Wynik musi być między 1 i 100");
        }
        this.punkty = punkty;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPoziom_trudnosci() {
        return poziom_trudnosci;
    }

    public void setPoziom_trudnosci(String poziom_trudnosci) {
        this.poziom_trudnosci = poziom_trudnosci;
    }

    public String getSzkola() {
        return szkola;
    }

    public void setSzkola(String szkola) {
        this.szkola = szkola;
    }

}

