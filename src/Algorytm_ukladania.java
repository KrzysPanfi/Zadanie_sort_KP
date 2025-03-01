import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Algorytm_ukladania {
    List<Uczestnik> uczestnicy;
    public Algorytm_ukladania(List<Uczestnik>uczestnicy){
        this.uczestnicy=uczestnicy;
    }
    private <T> void bubbleSort(List<T>dane, Comparator<T> comparator,boolean desc){
        int n=dane.size();
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(desc){
                    if(comparator.compare(dane.get(j),dane.get(j+1))<0 ){
                        T temp=dane.get(j);
                        dane.set(j,dane.get(j+1));
                        dane.set(j+1,temp);
                    }
                }
                if(comparator.compare(dane.get(j),dane.get(j+1))>0 ){
                    T temp=dane.get(j);
                    dane.set(j,dane.get(j+1));
                    dane.set(j+1,temp);
                }
            }
        }

    }

    public HashMap<String,ArrayList<Uczestnik>> Sala(){

        return new HashMap<>();
    }
    public List<Uczestnik>listaobecnosci(){
        Comparator<Uczestnik>nazwiskocomparator= Comparator.comparing(Uczestnik::getNazwisko);
        bubbleSort(uczestnicy,nazwiskocomparator,false );
        return uczestnicy;
    }

    public List<Uczestnik>listadyplom(){
        Comparator<Uczestnik>punktycomparator= Comparator.comparing(Uczestnik::getPunkty);
        bubbleSort(uczestnicy,punktycomparator,true );
        return uczestnicy;


    }
    public HashMap<String,List<Uczestnik>>wyniki(){
        HashMap<String,List<Uczestnik>>uczestnicyGrouped= (HashMap<String, List<Uczestnik>>) uczestnicy.stream().collect(Collectors.groupingBy(Uczestnik::getSzkola));

        uczestnicyGrouped.forEach((k,v)->{
            Comparator<Uczestnik>nazwiskocomparator= Comparator.comparing(Uczestnik::getNazwisko);
            bubbleSort(v,nazwiskocomparator,false );
        });
        return uczestnicyGrouped;
    }

    public List<Uczestnik> getUczestnicy() {
        return uczestnicy;
    }

    public void setUczestnicy(List<Uczestnik> uczestnicy) {
        this.uczestnicy = uczestnicy;
    }
}

