package colecoes;

import excecoes.FilaVaziaExcecao;

/**
 * Interface que define as operações básicas de uma Fila (Queue).
 * Uma Fila é uma estrutura de dados que segue o princípio FIFO (First In - First Out),
 * onde o primeiro elemento adicionado é o primeiro a ser removido.
 * @param <E> o tipo de elementos que esta fila irá conter
 */
public interface Fila<E> {
    /**
     * Adiciona o elemento especificado ao final desta fila.
     * @param valor o elemento a ser adicionado
     */
    void enfileirar(E valor);

    /**
     * Remove e retorna o elemento na frente desta fila.
     * @return o elemento na frente desta fila
     * @throws FilaVaziaExcecao se esta fila estiver vazia
     */
    E desenfileirar() throws FilaVaziaExcecao;

    /**
     * Retorna o elemento na frente desta fila sem removê-lo.
     * @return o elemento na frente desta fila
     * @throws FilaVaziaExcecao se esta fila estiver vazia
     */
    E primeiro() throws FilaVaziaExcecao;

    /**
     * Retorna o número de elementos nesta fila.
     * @return o número de elementos nesta fila
     */
    int tamanho();

    /**
     * Retorna true se esta fila não contiver elementos.
     * @return true se esta fila não contiver elementos
     */
    boolean estaVazia();
}