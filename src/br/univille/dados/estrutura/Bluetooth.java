package br.univille.dados.estrutura;

public class Bluetooth {

    private boolean sucesso;

    public void enviaPacote(Pacote pacote, Alpha alpha) {
        System.out.println("Enviando "+pacote.toString()+"...");
        alpha.adicionaPacote(pacote, this);
    }

    public boolean getSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }
}
