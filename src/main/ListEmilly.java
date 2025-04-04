package main;

public class ListEmilly<T> {
    private NodeEmilly<T> primeiro;
    private NodeEmilly<T> ultimo;
    private int size;

    public ListEmilly(){
        this.primeiro = null;
        this.ultimo = null;
    }

    public void addValorDireita(T valor){
        NodeEmilly<T> novoNo = new NodeEmilly<T>(valor);
        if(this.primeiro==null){
            this.primeiro = novoNo;
            this.ultimo = novoNo;
        } else{
            this.ultimo.nodoProximo = novoNo;
            novoNo.nodoAnterior = this.ultimo;
            this.ultimo = novoNo;
        }
    }

    public void addValorEsquerda(T valor){
        NodeEmilly<T> novoNo = new NodeEmilly<T>(valor);
        if(this.primeiro==null){
            this.primeiro = novoNo;
            this.ultimo = novoNo;
        } else{
            this.primeiro.nodoAnterior = novoNo;
            novoNo.nodoProximo = this.primeiro;
            this.primeiro = novoNo;
        }
    }

    public void removerEsquerda(){
        NodeEmilly<T> penultimo = this.ultimo.nodoAnterior;
        if(this.ultimo!=null){
             penultimo.nodoProximo = null;
             this.ultimo.nodoAnterior = null;
             this.ultimo = penultimo;
        }
    }

    public void listar() {
        if(this.primeiro != null) {
            NodeEmilly<T> atual = this.primeiro;
            while(atual.nodoProximo != null) {
                System.out.println(atual.dado.toString());
            }
        }
    }
}
