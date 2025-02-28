import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class OlimpiadaManager {
    ArrayList<Uczestnik>uczestnicy;

    public OlimpiadaManager(ArrayList<Uczestnik>uczestnicy){
        uczestnicy=this.uczestnicy;
    }

    private <T> void bubbleSort(ArrayList<T>dane, Comparator<T>comparator){
        int n=dane.size();
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(comparator.compare(dane.get(j),dane.get(j+1))>0 ){
                    T temp=dane.get(j);
                    dane.set(j,dane.get(j+1));
                    dane.set(j+1,temp);
                }
            }
        }

    }

    public HashMap<String,ArrayList<Uczestnik>>Sala(){

        return new HashMap<>();
    }
    public ArrayList<Uczestnik>listaobecnosci(){
        Comparator<Uczestnik>nazwiskocomparator=new Comparator<Uczestnik>(){

            @Override
            public int compare(Uczestnik o1, Uczestnik o2) {
                return o1.getNazwisko().compareTo(o2.getNazwisko());
            }
        };
        bubbleSort(uczestnicy,nazwiskocomparator );
        return uczestnicy;
    }

    public ArrayList<Uczestnik>listadyplom(){

        return new ArrayList<>();


    }
    public HashMap<String,ArrayList<Uczestnik>>wyniki(){

        return new HashMap<>();
    }
}
