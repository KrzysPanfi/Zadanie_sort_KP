import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class OlimpiadaManager {

    public void zadanie(List<Uczestnik> uczestnicy) {
        Algorytm_ukladania au = new Algorytm_ukladania(uczestnicy);
        HashMap<String, List<Uczestnik>> map4 = au.Sala();
        //au.listaobecnosci();
        HashMap<String, Map<Integer, List<Uczestnik>>> map1 = au.groupbyschoolandclass();
        map1.forEach(((sz, klasa) -> {
            klasa.forEach(((klasa1, uczestnikList) -> {
                System.out.println("Szkola: " + sz + " Klasa: " + klasa1 + " Liczba: " + uczestnikList.size());
            }));
        }));

        HashMap<String, Map<String, List<Uczestnik>>> map2 = au.groupbyschoolandlevel();
        map2.forEach(((sz, poziom) -> {
            poziom.forEach(((poziom1, uczestnikList) -> {
                int count = 0;
                double avg;
                for (Uczestnik u : uczestnikList) {
                    count += u.getPunkty();
                }
                avg = (double) count / uczestnikList.size();
                System.out.println("Szkola: " + sz + " Poziom: " + poziom1 + " Srednia: " + avg);
            }));
        }));

        HashMap<String, List<Uczestnik>> map3 = au.Groupbyschool();
        map3.forEach(((sz, uczestnikList) -> {
            System.out.println("Szkola: " + sz + " Najlepszy: " + uczestnikList.get(0).getImie() + " " + uczestnikList.get(0).getNazwisko());
        }));

     /*   System.out.println(uczestnicy.size());
        map4.forEach(((s, uczestnikList) -> {

            System.out.println(s);
            System.out.println(uczestnikList.size());
            for (Uczestnik u : uczestnikList) {
                System.out.println(u.toString());
            }
        }));
      */

    }
}
