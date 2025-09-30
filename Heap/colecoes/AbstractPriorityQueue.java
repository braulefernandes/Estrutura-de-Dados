package colecoes;

import java.util.Comparator;

/**
 * Classe abstrata que implementa a base para uma fila de prioridade usando lista encadeada.
 * Fornece estrutura para armazenar entradas em nós encadeados e métodos auxiliares de comparação.
 * 
 * @param <K> tipo da chave usada para prioridade (deve ser comparável via Comparator)
 * @param <V> tipo do valor armazenado na fila de prioridade
 */
public abstract class AbstractPriorityQueue<K,V> implements FilaPrioridade<K,V> {

    /**
     * Classe interna que representa um nó da lista encadeada.
     * Cada nó mantém referência para o próximo e o anterior, além da entrada (par chave-valor).
     */
    class Node {
        Node next;
        Node prev;
        Entrada<K,V> entrada;

        /**
         * Construtor para criar um nó a partir de uma entrada já existente.
         * @param entrada a entrada chave-valor armazenada no nó
         */
        public Node(Entrada<K, V> entrada) {
            this.entrada = entrada;
        }

        /**
         * Construtor para criar um nó a partir de chave e valor, criando a entrada internamente.
         * @param key chave da entrada
         * @param value valor da entrada
         */
        public Node(K key, V value) {
            entrada = new PriorityEntrada(key, value);
        }
    }

    /**
     * Classe interna que implementa a interface Entrada<K,V>,
     * representando um par chave-valor na fila de prioridade.
     */
    class PriorityEntrada implements Entrada<K,V> {
        private K key;
        private V value;

        public PriorityEntrada(K key, V value) {
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

    protected int size;       // número de elementos na fila
    protected Node first;     // primeiro nó da lista (mais alta prioridade)
    protected Node last;      // último nó da lista (menor prioridade)
    protected Comparator<K> meuComparador;  // comparador para definir ordem das chaves

    /**
     * Construtor que inicializa o comparador padrão.
     */
    public AbstractPriorityQueue() {
        meuComparador = new MeuComparador<>();
    }

    /**
     * Compara uma chave com a chave armazenada em um nó.
     * @param k chave a comparar
     * @param n nó cuja chave será comparada
     * @return valor negativo, zero ou positivo conforme a ordem
     */
    protected int compare(K k, Node n) {
        return meuComparador.compare(k, n.entrada.getKey());
    }

    /**
     * Compara as chaves armazenadas em dois nós.
     * @param n1 primeiro nó
     * @param n2 segundo nó
     * @return valor negativo, zero ou positivo conforme a ordem
     */
    protected int compare(Node n1, Node n2) {
        return compare(n1.entrada, n2.entrada);
    }

    /**
     * Compara duas entradas pela chave.
     * @param e1 primeira entrada
     * @param e2 segunda entrada
     * @return valor negativo, zero ou positivo conforme a ordem
     */
    protected int compare(Entrada<K,V> e1, Entrada<K,V> e2) {
        return meuComparador.compare(e1.getKey(), e2.getKey());
    }

    /**
     * Verifica se a fila de prioridade está vazia.
     * @return true se vazia, false caso contrário
     */
    @Override
    public boolean estaVazia() {
        return size == 0;
    }

    /**
     * Retorna o número de elementos na fila.
     * @return tamanho da fila
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Retorna uma representação em string da fila, listando as entradas na ordem.
     * @return string representando a fila
     */
    @Override
    public String toString() {
        String priorityQueueData = "";
        Node auxNode = first;
        while(auxNode != null) {
            priorityQueueData += auxNode.entrada;
            auxNode = auxNode.next;
            if(auxNode != null) {
                priorityQueueData += ", ";
            }
        }
        return priorityQueueData;
    }
}