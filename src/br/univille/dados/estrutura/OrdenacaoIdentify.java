package br.univille.dados.estrutura;

import java.util.Comparator;

public class OrdenacaoIdentify implements Comparator<Pacote> {

    @Override
    public int compare(Pacote a, Pacote b) {
        int result = 0;
        if(a == null && b == null){
            return 0;
        }
        if(a == null){
            return -1;
        }
        if(b == null){
            return 1;
        }
        int identifyA = Integer.parseInt(a.getIdentify(),2);
        int identifyB = Integer.parseInt(b.getIdentify(),2);
        if(identifyA > identifyB) {
            result = 1;
        }
        if(identifyA < identifyB) {
            result = -1;
        }
        if(identifyA == identifyB) {
            result = 0;
        }
        return result;
    }
}

