package br.univille.dados.estrutura;

import java.text.DecimalFormat;
import java.text.NumberFormat;


public class Alpha {

    private ListaDupla lista = new ListaDupla();
    private Bluetooth bluetooth;
    private boolean listable = true;
    private int numPacote;

    public void adicionaPacote(Pacote pacote, Bluetooth bluetooth){
        this.bluetooth = bluetooth;
        if(listable) {
            if (lista.isEmpty() | isPacoteBegin(pacote)) {
                lista.addFirst(pacote);
                System.out.println(pacote.toString()+" Adicionado na lista.");
            } else {
                lista.addLast(pacote);
                System.out.println(pacote.toString()+" Adicionado na lista.");
            }
            if (isPacoteEnd(pacote)) {
                System.out.println("Pacote END recebido, não é possivel mais inserir pacotes na lista.");
                System.out.println("-------------------------------------------------------------------------------------------");
                dividirPacotes();
                ordenarPacotes();
                checkPacotes();
                if(bluetooth.getSucesso()){
                    String cadeiaString = concatenaBuffer();
                    Double valor = cadeiaToDecimal(cadeiaString);
                    System.out.println("Valor Decimal: "+valor);
                }
            }
        } else {
            System.out.println("Não é possivel adicionar mais pacotes.");
        }
    }

    private Double cadeiaToDecimal(String cadeiaString) {
        System.out.println("Transformando cadeia de String em decimal...");
        long valorInteiro = Long.parseLong(cadeiaString.substring(4), 2);
        int casasDecimais = Integer.parseInt(cadeiaString.substring(1 ,4), 2);
        String pattern = casasDecimais == 0 ? "0" : "0".repeat(casasDecimais);
        NumberFormat format = new DecimalFormat("#0," + pattern);
        String temp = format.format(valorInteiro);
        Double valor = Double.parseDouble(temp);
        if (cadeiaString.startsWith("1")){
            valor *= -1;
        }
        return valor;
    }

    private String concatenaBuffer() {
        String cadeiaString = "";
        for (int i = 1; i < lista.size() - 1; i++){
            Pacote pacote = (Pacote) lista.get(i);
            cadeiaString = cadeiaString.concat(pacote.getBuffer());
        }
        System.out.println("Cadeia de String: "+cadeiaString);
        return cadeiaString;
    }

    private void ordenarPacotes() {
        System.out.println("Ordenando pacotes...");
        BubbleSort sort = new BubbleSort();
        OrdenacaoIdentify comparador = new OrdenacaoIdentify();
        sort.sort(lista, comparador);
    }

    private void dividirPacotes() {
        System.out.println("Dividindo pacotes...");
        for (int i = 0; i < lista.size(); i++){
            Pacote pacote = (Pacote) lista.get(i);
            pacote.setIdentify(pacote.getPacoteCompleto().substring(0,4));
            pacote.setBuffer(pacote.getPacoteCompleto().substring(4));
        }
    }

    private void checkPacotes() {
        if (lista.size() - 2 == numPacote){
            bluetooth.setSucesso(true);
        } else {
            bluetooth.setSucesso(false);
        }
    }

    private boolean isPacoteEnd(Pacote pacote) {
        if (pacote.getPacoteCompleto().equals("111111111111")){
            listable = false;
            return true;

        } else {
            return false;
        }
    }

    private boolean isPacoteBegin(Pacote pacote) {
        if (pacote.getPacoteCompleto().startsWith("0000")){
            numPacote = Integer.parseInt(pacote.getPacoteCompleto().substring(4), 2 );
            return true;

        } else {
            return false;
        }
    }
}
