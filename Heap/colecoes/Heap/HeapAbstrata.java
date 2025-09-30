package colecoes.Heap;

import java.util.Comparator;

import colecoes.Entrada;
import colecoes.FilaPrioridade;
import colecoes.MeuComparador;

/**
 * Classe abstrata que implementa uma estrutura base para uma Heap (fila de prioridade)
 * utilizando array e um comparador para definir a ordem dos elementos.
 * 
 * @param <K> tipo da chave usada para prioridade (deve ser comparável via Comparator)
 * @param <V> tipo do valor armazenado na heap
 */
public abstract class HeapAbstrata<K,V> implements FilaPrioridade<K,V> {

    /**
     * Classe interna que representa uma entrada (par chave-valor) na heap.
     * Implementa a interface Entrada<K,V>.
     */
    class EntradaHeap implements Entrada<K,V>{
        private K key;
        private V value;        

        public EntradaHeap(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "(" + key + ", " + value + ")";
        }
    }

    protected int size; // número atual de elementos na heap
    protected Entrada<K,V>[] heap; // array que armazena os elementos da heap
    protected Comparator<K> myComparator; // comparador para definir a ordem da heap

    /**
     * Construtor que inicializa o array com capacidade fixa (500 elementos)
     * e define o comparador padrão.
     */
    @SuppressWarnings("unchecked")
    public HeapAbstrata() {
        heap = new Entrada[500];
        myComparator = new MeuComparador<>();
    }

    /**
     * Verifica se a heap está cheia, ou seja, se já atingiu a capacidade máxima.
     * @return true se cheia, false caso contrário
     */
    public boolean estaCheia(){
        return size == heap.length;
    }

    /**
     * Verifica se a heap está vazia (sem elementos).
     * @return true se vazia, false caso contrário
     */
    @Override
    public boolean estaVazia() {        
        return size == 0;
    }

    /**
     * Retorna a quantidade de elementos atualmente na heap.
     * @return tamanho atual da heap
     */
    @Override
    public int size() {        
        return size;
    }

    /**
     * Retorna o índice do nó pai de um nó filho dado seu índice.
     * @param childIndex índice do nó filho
     * @return índice do nó pai
     */
    protected int pai(int childIndex){
        return (childIndex - 1) / 2;
    }

    /**
     * Retorna o índice do filho esquerdo de um nó pai dado seu índice.
     * @param parentIndex índice do nó pai
     * @return índice do filho esquerdo
     */
    protected int filhoEsquerdo(int parentIndex){
        return parentIndex * 2 + 1;
    }

    /**
     * Retorna o índice do filho direito de um nó pai dado seu índice.
     * @param parentIndex índice do nó pai
     * @return índice do filho direito
     */
    protected int filhoDireito(int parentIndex){
        return filhoEsquerdo(parentIndex) + 1;
    }

    /**
     * Troca as posições de duas entradas no array da heap.
     * @param index1 índice do primeiro elemento
     * @param index2 índice do segundo elemento
     */
    protected void trocar(int index1, int index2){
        Entrada<K,V> auxEntry = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = auxEntry;
    }

    /**
     * Compara as chaves de duas entradas no array, usando o comparador.
     * @param idx1 índice da primeira entrada
     * @param idx2 índice da segunda entrada
     * @return valor negativo, zero ou positivo conforme a ordem das chaves
     */
    public int comparar(int idx1, int idx2){
        return myComparator.compare(heap[idx1].getKey(), heap[idx2].getKey());
    }

    /**
     * Retorna uma representação em string da heap,
     * listando todas as entradas separadas por vírgula.
     * @return string representando a heap
     */
    @Override
    public String toString() {
        String heapData = "";
        for(int i = 0; i < size; i++){
            heapData += heap[i];
            if(i < size - 1){
                heapData += ", ";
            }
        }
        return heapData;
    }

    /**
     * Constrói a heap a partir de um array de entradas fornecido.
     * Reorganiza os elementos para garantir a propriedade da heap.
     * @param array array inicial de entradas
     */
    public void construirHeap(Entrada<K,V>[] array){
        this.heap = array;
        this.size = array.length;
        // começa a "afundar" dos últimos pais até o topo para reorganizar a heap
        for(int i = pai(size - 1); i >= 0; i--){
            afundarParaBaixo(i);
        }
    }

    /**
     * Método abstrato que deve ser implementado para "afundar" um nó para baixo na heap,
     * garantindo a propriedade da heap.
     * @param index índice do nó a ser afundado
     */
    protected abstract void afundarParaBaixo(int index);

}