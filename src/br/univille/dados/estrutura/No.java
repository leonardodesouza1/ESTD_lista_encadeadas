package br.univille.dados.estrutura;

public class No<T> {

    private T value;
    private No<T> next;
    private No<T> previous;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public No<T> getNext() {
        return next;
    }

    public void setNext(No<T> next) {
        this.next = next;
    }

    public No<T> getPrevious() {
        return previous;
    }

    public void setPrevious(No<T> previous) {
        this.previous = previous;
    }

}