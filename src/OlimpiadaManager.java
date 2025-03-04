import java.util.HashMap;
import java.util.List;

public class OlimpiadaManager {

    public void zadanie(List<Uczestnik>uczestnicy){
        Algorytm_ukladania au=new Algorytm_ukladania(uczestnicy);
        au.listaobecnosci();
       HashMap<String, List<Uczestnik>> map= au.Sala();
 /*       for (Uczestnik u:au.getUczestnicy()){
            System.out.println(u.toString());
        }
  */
        map.forEach(((s, uczestniks) -> {
            System.out.println(s);
            for (Uczestnik u:uczestniks){
                System.out.println(u.toString());
            }
        }));
    }
}
