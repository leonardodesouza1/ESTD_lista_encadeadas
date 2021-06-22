package br.univille.dados.estrutura;

import java.util.Comparator;
import java.util.List;

public class BubbleSort<T> {


    public BubbleSort() {
        super();
    }

    public void sort(List<T> list, Comparator<T> comparator) {
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < list.size(); j++){
                T primeira = list.get(i);
                T segunda = list.get(j);
                if(comparator.compare(primeira, segunda) < 0 ){
                    T temp = list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,temp);
                }
            }
        }
    }
}