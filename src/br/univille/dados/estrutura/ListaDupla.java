package br.univille.dados.estrutura;

import java.util.*;

public class ListaDupla<T> implements List<T> {

    protected No<T> inicio;
    protected No<T> fim;
    protected int tamanho;

    public ListaDupla(){
        inicio = null;

        fim = null;
        tamanho = 0;
    }

    @Override
    public int size() {
        return tamanho;
    }

    @Override
    public boolean isEmpty() {
        return tamanho == 0;
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void clear() {
        tamanho = 0;
        inicio = null;
        fim = null;
    }

    public T getFirst() {
        if(isEmpty()) throw new NoSuchElementException("List is empty");
        return inicio.getValue();
    }

    public T getLast() {
        if(isEmpty()) throw new NoSuchElementException("List is empty");
        return fim.getValue();
    }

    public void addFirst(T value) {
        No<T> first = new No<T>();
        first.setValue(value);
        first.setNext(inicio);
        if(inicio == null) {
            fim = first;
        }
        inicio = first;
        tamanho++;
    }

    public void addLast(T value) {
        if(inicio == null) { // Ainda não possui head
            addFirst(value);
        }else {
            No<T> last = new No<T>();
            last.setValue(value);
            fim.setNext(last);
            last.setPrevious(fim);
            fim = last;
            tamanho++;
        }
    }

    public T removeFirst() {
        if(isEmpty()) throw new NoSuchElementException("List is empty");
        T value = inicio.getValue();
        inicio = inicio.getNext();
        tamanho--;
        return value;
    }


    public T removeLast() {
        if(isEmpty()) throw new NoSuchElementException("List is empty");
        T value = fim.getValue();
        No<T> temp = null;

        if (fim.getPrevious() != null) {
            temp = fim.getPrevious();
        }

        temp.setNext(null);
        fim.setPrevious(null);
        fim = temp;
        fim.setNext(null);
        tamanho--;
        return value;
    }

    @Override
    public boolean contains(Object value) {
        No<T> temp = inicio;
        while(temp != null) {
            if(temp.getValue().equals(value)) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }


    public Object[] toArray() {
        Object[] array = new Object[(int) tamanho];
        No<T> temp = inicio;
        for(int i = 0; i < tamanho; i++) {
            array[i] = temp.getValue();
            temp = temp.getNext();
        }
        return array;
    }

    @Override
    public boolean add(T o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public T get(int index) {
        if(index >= tamanho || index < 0) throw new IndexOutOfBoundsException("index "+index);
        No<T> temp = inicio;
        for(int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp.getValue();
    }


    public T remove(int index) {
        if(index >= tamanho || index < 0) throw new IndexOutOfBoundsException("index "+index);
        No<T> temp = inicio;
        No<T> before = null;
        for(int i = 0; i < index; i++) {
            before = temp;
            temp = temp.getNext();
        }
        if(before == null) {
            inicio = temp.getNext();
        }else {
            before.setNext(temp.getNext());
            if(temp == fim) {
                fim = before;
            }
        }
        tamanho--;
        return temp.getValue();
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }


    public void add(int index, T value) {
        if(index > tamanho || index < 0) throw new IndexOutOfBoundsException("index "+index);
        No<T> temp = inicio;
        No<T> before = null;
        for(int i = 0; i < index; i++) {
            before = temp;
            temp = temp.getNext();
        }
        No<T> newNode = new No<T>();
        newNode.setValue(value);
        newNode.setNext(temp);
        newNode.setPrevious(before);
        if(before == null) {
            inicio = newNode;
        }else {
            before.setNext(newNode);
            if(temp == fim) {
                fim = newNode;
            }
        }
        tamanho++;
    }

    @Override
    public T set(int index, T value) {
        if(index >= tamanho || index < 0) throw new IndexOutOfBoundsException("index "+index);
        No<T> temp = inicio;
        for(int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        temp.setValue((T) value);
        return value;
    }
}