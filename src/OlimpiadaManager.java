import java.util.HashMap;
import java.util.List;

public class OlimpiadaManager {

    public void zadanie(List<Uczestnik>uczestnicy){
        Algorytm_ukladania au=new Algorytm_ukladania(uczestnicy);
        au.listaobecnosci();
       HashMap<String, List<Uczestnik>> map= au.wyniki();
 /*       for (Uczestnik u:au.getUczestnicy()){
            System.out.println(u.toString());
        }
  */
        map.forEach(((s, uczestniks) -> {
            for (Uczestnik u:uczestniks){
                System.out.println(u.toString());
            }
        }));
    }
}
