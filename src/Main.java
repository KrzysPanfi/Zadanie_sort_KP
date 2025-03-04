import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        String filepath="students.csv";
        ArrayList<Uczestnik> Wynik= Uczestnik.Download(filepath);
        OlimpiadaManager om1=new OlimpiadaManager();
        om1.zadanie(Wynik);

        }
    }

