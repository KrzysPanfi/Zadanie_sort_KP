import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.SplittableRandom;


public class Main {
    public static void main(String[] args) {
        String filepath="students.csv";
        ArrayList<Uczestnik> Wynik=Download(filepath);
        OlimpiadaManager om1=new OlimpiadaManager(Wynik);

        }

    public static ArrayList<Uczestnik> Download(String filepath) {
        ArrayList<Uczestnik> Wynik = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filepath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null && count!=0) {
               String[] lines= line.split("\\|");
               Uczestnik uczestnik=new Uczestnik(lines[0],lines[1],lines[2],Integer.parseInt(lines[3]),lines[4],Integer.parseInt(lines[5]));
               Wynik.add(uczestnik);

            }
            bufferedReader.close();
            return Wynik;

        } catch (IOException e) {

            e.printStackTrace();
        }
        return null;
    }
    }
