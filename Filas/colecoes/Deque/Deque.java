package colecoes.Deque;

import excecoes.FilaVaziaExcecao;

/**
 * Interface que define as operações de um Deque (Double-Ended Queue - Fila de Duas Pontas).
 * Um Deque permite a adição e remoção de elementos em ambas as extremidades.
 * @param <E> o tipo de elementos que este deque irá conter
 */
public interface Deque<E> {
    /**
     * Adiciona o elemento especificado no início deste deque.
     * @param valor o elemento a ser adicionado
     */
    void adicionarPrimeiro(E valor);

    /**
     * Adiciona o elemento especificado no final deste deque.
     * @param valor o elemento a ser adicionado
     */
    void adicionarUltimo(E valor);

    /**
     * Remove e retorna o elemento do início deste deque.
     * @return o elemento do início deste deque
     * @throws FilaVaziaExcecao se este deque estiver vazio
     */
    E removerPrimeiro() throws FilaVaziaExcecao;

    /**
     * Remove e retorna o elemento do final deste deque.
     * @return o elemento do final deste deque
     * @throws FilaVaziaExcecao se este deque estiver vazio
     */
    E removerUltimo() throws FilaVaziaExcecao;

    /**
     * Retorna o elemento do início deste deque sem removê-lo.
     * @return o elemento do início deste deque
     * @throws FilaVaziaExcecao se este deque estiver vazio
     */
    E obterPrimeiro() throws FilaVaziaExcecao;

    /**
     * Retorna o elemento do final deste deque sem removê-lo.
     * @return o elemento do final deste deque
     * @throws FilaVaziaExcecao se este deque estiver vazio
     */
    E obterUltimo() throws FilaVaziaExcecao;

    /**
     * Retorna o número de elementos neste deque.
     * @return o número de elementos neste deque
     */
    int tamanho();

    /**
     * Retorna true se este deque não contiver elementos.
     * @return true se este deque não contiver elementos
     */
    boolean estaVazio();

    /**
     * Remove todos os elementos deste deque.
     * O deque ficará vazio após esta chamada retornar.
     */
    void limpar();

    /**
     * Retorna true se este deque contiver o elemento especificado.
     * @param valor o elemento cuja presença neste deque deve ser testada
     * @return true se este deque contiver o elemento especificado
     */
    boolean contem(E valor);

    /**
     * Retorna um array contendo todos os elementos deste deque na sequência correta.
     * @return um array contendo todos os elementos deste deque na sequência correta
     */
    E[] paraArray();
}


