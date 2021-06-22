package br.univille.dados.estrutura;


public class Pacote {

    private String identify;
    private String buffer;
    private String pacoteCompleto;

    public Pacote(String pacoteCompleto) {
        this.pacoteCompleto = pacoteCompleto;
    }

    public String intParaBinario(Integer numero){
        return Integer.toBinaryString(numero);
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public String getBuffer() {
        return buffer;
    }

    public void setBuffer(String buffer) {
        this.buffer = buffer;
    }

    public String getPacoteCompleto() {
        return pacoteCompleto;
    }

    public void setPacoteCompleto(String pacoteCompleto) {
        this.pacoteCompleto = pacoteCompleto;
    }

    @Override
    public String toString() {
        return "Pacote: " + pacoteCompleto;
    }
}
