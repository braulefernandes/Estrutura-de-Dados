package colecoes;

/**
 * Interface que define os métodos para uma fila de prioridade.
 * 
 * @param <K> tipo da chave usada para prioridade
 * @param <V> tipo do valor armazenado na fila
 */
public interface FilaPrioridade<K,V> {

    /**
     * Insere um elemento com a chave e valor especificados na fila.
     * @param key chave do elemento
     * @param value valor do elemento
     */
    void enfileirar(K key, V value);

    /**
     * Remove e retorna o elemento com maior prioridade da fila.
     * @return a entrada removida (com maior prioridade)
     */
    Entrada<K,V> desenfileirar();

    /**
     * Retorna o elemento com maior prioridade sem removê-lo.
     * @return a entrada com maior prioridade
     */
    Entrada<K,V> prioridadeMaxima();

    /**
     * Retorna o número de elementos na fila.
     * @return tamanho da fila
     */
    int size();

    /**
     * Verifica se a fila está vazia.
     * @return true se vazia, false caso contrário
     */
    boolean estaVazia();

    /**
     * Espia (visualiza) o elemento de maior prioridade sem removê-lo.
     * @return a entrada no topo da fila
     */
    Entrada<K,V> espiar();

    /**
     * Aumenta a chave do elemento no índice especificado para uma nova chave maior.
     * @param index índice do elemento
     * @param newKey nova chave, que deve ser maior que a atual
     */
    void aumentarChave(int index, K newKey);

    /**
     * Diminui a chave do elemento no índice especificado para uma nova chave menor.
     * @param index índice do elemento
     * @param newKey nova chave, que deve ser menor que a atual
     */
    void diminuirChave(int index, K newKey);
}