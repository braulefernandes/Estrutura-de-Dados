package colecoes.ListaEncadeada;
import colecoes.Lista;

/**
 * Classe abstrata que serve como base para implementações de listas encadeadas.
 * Define a estrutura básica de um nó e operações comuns a listas encadeadas.
 * @param <E> o tipo de elementos que esta lista irá conter
 */
public abstract class ListaDinamica<E> implements Lista<E> {

    /**
     * Classe interna que representa um nó na lista encadeada.
     * Cada nó contém um valor e referências para o nó anterior e próximo (para listas duplamente encadeadas).
     */
    protected class No{
        E valor;
        No anterior;
        No proximo;
        public No(E valor){
            this.valor = valor;
        }
    }

    protected int tamanho;
    protected No cabeca;
    protected No cauda;

    /**
     * Remove todos os elementos desta lista.
     * A lista ficará vazia após esta chamada retornar.
     */
    @Override
    public void limpar(){
        tamanho = 0;
        cabeca = null;
        cauda = null;
    }

    /**
     * Verifica se o índice fornecido está dentro dos limites válidos da lista.
     * @param indice o índice a ser verificado
     * @throws IndexOutOfBoundsException se o índice estiver fora do intervalo (indice < 0 || indice >= tamanho())
     */
    protected void verificarIndice(int indice){
        if(indice < 0 || indice >= tamanho) throw new IndexOutOfBoundsException("Índice fora dos limites: " + indice + ", Tamanho: " + tamanho);
    }

    /**
     * Retorna true se esta lista não contiver elementos.
     * @return true se esta lista não contiver elementos
     */
    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    /**
     * Retorna o número de elementos nesta lista.
     * @return o número de elementos nesta lista
     */
    @Override
    public int tamanho() {        
        return tamanho;
    }

    /**
     * Retorna o nó na posição especificada nesta lista.
     * @param indice o índice do nó a ser retornado
     * @return o nó na posição especificada
     */
    protected No obterNo(int indice){
        No noAuxiliar = cabeca;
        for(int i = 0; i < indice; i++){
            noAuxiliar = noAuxiliar.proximo;
        }
        return noAuxiliar;
    }

    /**
     * Retorna uma representação em string desta lista.
     * @return uma representação em string desta lista
     */
    @Override
    public String toString() {
        StringBuilder dadosLista = new StringBuilder("[");
        No noAuxiliar = cabeca;
        while (noAuxiliar != null) {
            dadosLista.append(noAuxiliar.valor);
            if(noAuxiliar.proximo != null){
                dadosLista.append(" -> ");                
            }
            noAuxiliar = noAuxiliar.proximo;
        }
        return dadosLista.append("]").toString();
    }

}