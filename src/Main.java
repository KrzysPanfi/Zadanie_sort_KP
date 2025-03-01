import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.SplittableRandom;


public class Main {
    public static void main(String[] args) {
        String filepath="students.csv";
        ArrayList<Uczestnik> Wynik= Uczestnik.Download(filepath);
        OlimpiadaManager om1=new OlimpiadaManager();
        om1.zadanie(Wynik);

        }
    }

