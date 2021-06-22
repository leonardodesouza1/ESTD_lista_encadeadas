package br.univille.dados.estrutura;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Alpha alpha = new Alpha();
        Bluetooth bluetooth = new Bluetooth();
        Pacote pacote1 = new Pacote("000000000100");
        Pacote pacote2 = new Pacote("001011110110");
        Pacote pacote3 = new Pacote("011100001000");
        Pacote pacote4 = new Pacote("101010110111");
        Pacote pacote5 = new Pacote("111010000111");
        Pacote pacote6 = new Pacote("111111111111");
        bluetooth.enviaPacote(pacote1,alpha);
        bluetooth.enviaPacote(pacote2,alpha);
        bluetooth.enviaPacote(pacote3,alpha);
        bluetooth.enviaPacote(pacote4,alpha);
        bluetooth.enviaPacote(pacote5,alpha);
        bluetooth.enviaPacote(pacote6,alpha);
        System.out.println("-------------------------------------------------------------------------------------------");
        if (bluetooth.getSucesso()){
            System.out.println("Pacotes recebidos com sucesso!");
        } else {
            System.out.println(":(");
        }
    }
}
