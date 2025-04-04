package main;

public class NodeEmilly<T> {
    public NodeEmilly<T> nodoAnterior;
    public NodeEmilly<T> nodoProximo;
    public T dado;

    public NodeEmilly(T dado){
        this.dado = dado;
        this.nodoAnterior = null;
        this.nodoProximo = null;
    }
}
