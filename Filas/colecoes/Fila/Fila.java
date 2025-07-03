package colecoes.Fila;

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
     * Remove e retorna o elemento do início desta fila.
     * @return o elemento do início desta fila
     * @throws FilaVaziaExcecao se esta fila estiver vazia
     */
    E desenfileirar() throws FilaVaziaExcecao;

    /**
     * Retorna o elemento do início desta fila sem removê-lo.
     * @return o elemento do início desta fila
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

    /**
     * Remove todos os elementos desta fila.
     * A fila ficará vazia após esta chamada retornar.
     */
    void limpar();

    /**
     * Retorna true se esta fila contiver o elemento especificado.
     * @param valor o elemento cuja presença nesta fila deve ser testada
     * @return true se esta fila contiver o elemento especificado
     */
    boolean contem(E valor);

    /**
     * Retorna um array contendo todos os elementos desta fila na sequência correta (do início para o fim).
     * @return um array contendo todos os elementos desta fila na sequência correta
     */
    E[] paraArray();
}


