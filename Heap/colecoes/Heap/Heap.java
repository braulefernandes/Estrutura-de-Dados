package colecoes.Heap;

import colecoes.Entrada;
import excecoes.HeapCheiaExcecao;
import excecoes.HeapVaziaExcecao;

/**
 * Implementação concreta de uma Heap (fila de prioridade) baseada em array.
 * Suporta operações básicas como enfileirar, desenfileirar, aumentar e diminuir chave.
 * 
 * @param <K> Tipo da chave usada para prioridade (deve ser comparável)
 * @param <V> Tipo do valor armazenado na heap
 */
public class Heap<K,V> extends HeapAbstrata<K,V> {

    /**
     * Remove e retorna a entrada de maior prioridade da heap (topo da heap).
     * Reorganiza a heap para manter a propriedade após remoção.
     * @return a entrada com a prioridade máxima
     * @throws HeapVaziaExcecao se a heap estiver vazia
     */
    @Override
    public Entrada<K, V> desenfileirar() {
        Entrada<K,V> entry = prioridadeMaxima(); // captura topo da heap
        heap[0] = heap[size - 1]; // substitui topo pelo último elemento
        if (size > 1)
            afundarParaBaixo(0); // reequilibra a heap a partir do topo
        size--; // diminui o tamanho efetivo da heap
        return entry;
    }

    /**
     * Método auxiliar que "afunda" um nó da heap para baixo,
     * trocando com seus filhos caso algum tenha prioridade maior,
     * até que a propriedade da heap seja restaurada.
     * @param min índice inicial para afundar
     */
    protected void afundarParaBaixo(int min){
        int current;
        int filhoEsquerdo, filhoDireito;
        do {
            current = min;
            filhoEsquerdo = filhoEsquerdo(current);
            filhoDireito = filhoDireito(current);

            // verifica se filho esquerdo tem prioridade maior que o atual
            if (filhoEsquerdo < size && comparar(filhoEsquerdo, min) > 0) {
                min = filhoEsquerdo;
            }
            // verifica se filho direito tem prioridade maior que o atual
            if (filhoDireito < size && comparar(filhoDireito, min) > 0) {
                min = filhoDireito;
            }
            // se algum filho tem prioridade maior, troca com o atual
            if (current != min) {
                trocar(min, current);
            }
        } while (current != min); // repete até que não precise mais trocar
    }

    /**
     * Método auxiliar que "borbulha" um nó para cima na heap,
     * trocando com o pai enquanto a prioridade do nó for maior que a do pai.
     * @param current índice do nó que será "borbulhado" para cima
     */
    private void borbulharParaCima(int current){
        int pai = pai(current);
        // enquanto não chegou no topo e a prioridade atual for menor que a do pai
        while(current > 0 && comparar(current, pai) < 0){
            trocar(current, pai);
            current = pai;
            pai = pai(current);
        }
    }

    /**
     * Adiciona um novo elemento na heap.
     * Se a heap estiver cheia, lança exceção.
     * @param key chave de prioridade do novo elemento
     * @param value valor do novo elemento
     * @throws HeapCheiaExcecao se a heap estiver cheia
     */
    @Override
    public void enfileirar(K key, V value) {
        if (estaCheia()) throw new HeapCheiaExcecao("Heap está cheia.");
        heap[size] = new EntradaHeap(key, value);
        borbulharParaCima(size++); // ajusta a posição do novo elemento para manter a heap
    }

    /**
     * Retorna a entrada com maior prioridade da heap (topo).
     * @return a entrada de maior prioridade
     * @throws HeapVaziaExcecao se a heap estiver vazia
     */
    @Override
    public Entrada<K, V> prioridadeMaxima() {
        if (estaVazia()) throw new HeapVaziaExcecao("Heap está vazia.");
        return heap[0];
    }

    /**
     * Retorna a entrada do topo da heap sem removê-la.
     * @return a entrada de maior prioridade (topo)
     */
    @Override
    public Entrada<K, V> espiar() {
        return prioridadeMaxima();
    }

    /**
     * Aumenta a chave (prioridade) do elemento no índice especificado,
     * garantindo que a nova chave seja maior ou igual à chave atual.
     * @param index índice do elemento a ser atualizado
     * @param newKey nova chave para o elemento
     * @throws IndexOutOfBoundsException se índice for inválido
     * @throws IllegalArgumentException se a nova chave for menor que a atual
     */
    @Override
    public void aumentarChave(int index, K newKey) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index fora dos limites");
        }
        if (myComparator.compare(newKey, heap[index].getKey()) < 0) {
            throw new IllegalArgumentException("Nova chave é menor que a chave atual");
        }
        heap[index] = new EntradaHeap(newKey, heap[index].getValue());
        borbulharParaCima(index);
    }

    /**
     * Diminui a chave (prioridade) do elemento no índice especificado,
     * garantindo que a nova chave seja menor ou igual à chave atual.
     * @param index índice do elemento a ser atualizado
     * @param newKey nova chave para o elemento
     * @throws IndexOutOfBoundsException se índice for inválido
     * @throws IllegalArgumentException se a nova chave for maior que a atual
     */
    @Override
    public void diminuirChave(int index, K newKey) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index fora dos limites");
        }
        if (myComparator.compare(newKey, heap[index].getKey()) > 0) {
            throw new IllegalArgumentException("Nova chave é maior que a chave atual");
        }
        heap[index] = new EntradaHeap(newKey, heap[index].getValue());
        afundarParaBaixo(index);
    }
}