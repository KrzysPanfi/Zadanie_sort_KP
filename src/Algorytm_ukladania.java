import java.util.*;
import java.util.stream.Collectors;

public class Algorytm_ukladania {
    List<Uczestnik> uczestnicy;

    public Algorytm_ukladania(List<Uczestnik> uczestnicy) {
        this.uczestnicy = uczestnicy;
    }

    private <T> void bubbleSort(List<T> dane, Comparator<T> comparator, boolean desc) {
        int n = dane.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (desc) {
                    if (comparator.compare(dane.get(j), dane.get(j + 1)) < 0) {
                        T temp = dane.get(j);
                        dane.set(j, dane.get(j + 1));
                        dane.set(j + 1, temp);
                    }
                } else {
                    if (comparator.compare(dane.get(j), dane.get(j + 1)) > 0) {
                        T temp = dane.get(j);
                        dane.set(j, dane.get(j + 1));
                        dane.set(j + 1, temp);
                    }
                }
            }
        }

    }

    public HashMap<String, Map<Integer, List<Uczestnik>>> groupbyschoolandclass() {
        return (HashMap<String, Map<Integer, List<Uczestnik>>>)
                uczestnicy.stream().collect(Collectors.groupingBy(Uczestnik::getSzkola, Collectors.groupingBy(Uczestnik::getKlasa)));
    }

    public HashMap<String, Map<String, List<Uczestnik>>> groupbyschoolandlevel() {
        return (HashMap<String, Map<String, List<Uczestnik>>>)
                uczestnicy.stream().collect(Collectors.groupingBy(Uczestnik::getSzkola, Collectors.groupingBy(Uczestnik::getPoziom_trudnosci)));

    }

    public HashMap<String, List<Uczestnik>> Groupbyschool() {
        return (HashMap<String, List<Uczestnik>>) listadyplom().stream().collect(Collectors.groupingBy(Uczestnik::getSzkola));
    }

    public HashMap<String, List<Uczestnik>> Sala() {
        HashMap<String, List<Uczestnik>> sale = new HashMap<>();
        List<Uczestnik> uczestnicycopy = new ArrayList<>(uczestnicy);
        int countsala = 1;
        int capacity = 0;
        Random random = new Random();
        while (!uczestnicycopy.isEmpty()) {
            List<Uczestnik> skladsali = new ArrayList<>();
            //wybieranie pojemnosci poniewaz nie zostalo zdefiniowane w zadaniu
            int randint = random.nextInt(1, 4);
            if (randint == 1)
            {
                capacity = 60;
            }
            else if (randint == 2)
            {
                capacity = 45;
            }
            else if (randint == 3)
            {
                capacity = 30;
            }
            //pierwszy uczestnik w sali
            skladsali.add(uczestnicycopy.get(0));
            uczestnicycopy.remove(uczestnicycopy.get(0));
            int miejscewsali = 1;
            int indx = 0;
            while (skladsali.size() < capacity && indx < uczestnicycopy.size()) {
                skladsali.add(uczestnicycopy.get(indx));
                // jezeli niepasuje to jest usuwany z sali, a jesli pasuje to jest usuwany z glownej listy
                if (!(uczestnicycopy.get(indx).getPoziom_trudnosci().equals(skladsali.get(miejscewsali - 1).getPoziom_trudnosci()))
                        || uczestnicycopy.get(indx).getSzkola().equals(skladsali.get(miejscewsali - 1).getSzkola())) {
                    skladsali.remove(uczestnicycopy.get(indx));
                    indx++;
                }
                else
                {
                    uczestnicycopy.remove(uczestnicycopy.get(indx));
                    miejscewsali++;
                    indx = 0;
                }
            }

            sale.put(Integer.toString(countsala), skladsali);
            countsala++;
        }
        return sale;
    }

    public List<Uczestnik> listaobecnosci() {
        Comparator<Uczestnik> nazwiskocomparator = Comparator.comparing(Uczestnik::getNazwisko);
        bubbleSort(uczestnicy, nazwiskocomparator, false);
        return uczestnicy;
    }

    public List<Uczestnik> listadyplom() {
        Comparator<Uczestnik> punktycomparator = Comparator.comparing(Uczestnik::getPunkty);
        bubbleSort(uczestnicy, punktycomparator, true);
        return uczestnicy;


    }

    public HashMap<String, List<Uczestnik>> wyniki() {
        HashMap<String, List<Uczestnik>> uczestnicyGrouped = (HashMap<String, List<Uczestnik>>)
                uczestnicy.stream().collect(Collectors.groupingBy(Uczestnik::getSzkola));

        uczestnicyGrouped.forEach((k, v) -> {
            Comparator<Uczestnik> nazwiskocomparator = Comparator.comparing(Uczestnik::getNazwisko);
            bubbleSort(v, nazwiskocomparator, false);
        });
        return uczestnicyGrouped;
    }

    public List<Uczestnik> getUczestnicy() {
        return uczestnicy;
    }

    public void setUczestnicy(List<Uczestnik> uczestnicy) {
        this.uczestnicy = uczestnicy;
    }
    //metody szukania po różnych kryteriach
    public Uczestnik searchbyFName(String imie){
        for(Uczestnik u:uczestnicy){
            if(imie.equals(u.getImie())){
                return u;
            }
        }
        return null;
    }
    public Uczestnik searchbyLName(String nazwisko){
        for(Uczestnik u:uczestnicy){
            if(nazwisko.equals(u.getNazwisko())){
                return u;
            }
        }
        return null;
    }
    public Uczestnik searchbySchool(String szkola){
        for(Uczestnik u:uczestnicy){
            if(szkola.equals(u.getSzkola())){
                return u;
            }
        }
        return null;
    }
    public Uczestnik searchbyclass(int klasa){
        for(Uczestnik u:uczestnicy){
            if(klasa==u.getKlasa()){
                return u;
            }
        }
        return null;
    }
    public Uczestnik searchbylevel(String poziom){
        for(Uczestnik u:uczestnicy){
            if(poziom.equals(u.getPoziom_trudnosci())){
                return u;
            }
        }
        return null;
    }
    public Uczestnik searchbypoints(int punkty){
        for(Uczestnik u:uczestnicy){
            if(punkty==u.getPunkty()){
                return u;
            }
        }
        return null;
    }
}

