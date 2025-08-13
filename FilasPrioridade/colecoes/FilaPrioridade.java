package colecoes;

import excecoes.FilaVaziaExcecao;

/**
 * Interface que define as operações fundamentais de uma Fila de Prioridade.
 * Uma fila de prioridade permite inserção de elementos com uma chave associada e
 * possibilita o acesso e remoção do elemento com maior (ou menor) prioridade.
 *
 * @param <K> o tipo da chave usada para determinar a prioridade
 * @param <V> o tipo do valor associado à chave
 */
public interface FilaPrioridade<K, V> {

    /**
     * Insere uma nova entrada (chave-valor) na fila de prioridade.
     *
     * @param chave a chave que determina a prioridade
     * @param valor o valor associado à chave
     */
    void enfileirar(K chave, V valor);

    /**
     * Remove e retorna a entrada com a maior prioridade da fila.
     *
     * @return a entrada com maior prioridade
     * @throws FilaVaziaExcecao se a fila estiver vazia
     */
    Entrada<K, V> desenfileirar() throws FilaVaziaExcecao;

    /**
     * Retorna a entrada com a maior prioridade sem removê-la da fila.
     *
     * @return a entrada com maior prioridade
     * @throws FilaVaziaExcecao se a fila estiver vazia
     */
    Entrada<K, V> maiorPrioridade() throws FilaVaziaExcecao;

    /**
     * Retorna a entrada com a menor prioridade sem removê-la da fila.
     *
     * @return a entrada com menor prioridade
     * @throws FilaVaziaExcecao se a fila estiver vazia
     */
    Entrada<K, V> menorPrioridade() throws FilaVaziaExcecao;

    /**
     * Retorna a quantidade de elementos na fila de prioridade.
     *
     * @return o número de entradas armazenadas
     */
    int tamanho();

    /**
     * Retorna true se a fila de prioridade estiver vazia.
     *
     * @return true se estiver vazia, false caso contrário
     */
    boolean estaVazia();

    /**
     * Remove todos os elementos da fila de prioridade.
     */
    void limpar();

    /**
     * Verifica se a fila de prioridade contém uma entrada com a chave especificada.
     *
     * @param chave a chave a ser buscada
     * @return true se a chave estiver presente, false caso contrário
     */
    boolean contem(K chave);

    /**
     * Verifica se a fila de prioridade contém a entrada especificada.
     *
     * @param entrada a entrada a ser buscada
     * @return true se a entrada estiver presente, false caso contrário
     */
    boolean contem(Entrada<K, V> entrada);

    /**
     * Retorna um array contendo todas as entradas da fila de prioridade em ordem interna.
     *
     * @return um array com todas as entradas
     */
    Object[] paraArray();
}
