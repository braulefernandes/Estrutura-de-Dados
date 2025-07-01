package colecoes;

import excecoes.PilhaVaziaExcecao;

/**
 * Interface que define as operações básicas de uma Pilha (Stack).
 * Uma Pilha é uma estrutura de dados que segue o princípio LIFO (Last In - First Out),
 * onde o último elemento adicionado é o primeiro a ser removido.
 * @param <E> o tipo de elementos que esta pilha irá conter
 */
public interface Pilha<E> {
    /**
     * Adiciona o elemento especificado ao topo desta pilha.
     * @param valor o elemento a ser adicionado
     */
    void empilhar(E valor);

    /**
     * Remove e retorna o elemento no topo desta pilha.
     * @return o elemento no topo desta pilha
     * @throws PilhaVaziaExcecao se esta pilha estiver vazia
     */
    E desempilhar() throws PilhaVaziaExcecao;

    /**
     * Retorna o elemento no topo desta pilha sem removê-lo.
     * @return o elemento no topo desta pilha
     * @throws PilhaVaziaExcecao se esta pilha estiver vazia
     */
    E topo() throws PilhaVaziaExcecao;

    /**
     * Retorna o número de elementos nesta pilha.
     * @return o número de elementos nesta pilha
     */
    int altura();

    /**
     * Retorna true se esta pilha não contiver elementos.
     * @return true se esta pilha não contiver elementos
     */
    boolean estaVazia();

    /**
     * Remove todos os elementos desta pilha.
     * A pilha ficará vazia após esta chamada retornar.
     */
    void limpar();

    /**
     * Retorna true se esta pilha contiver o elemento especificado.
     * @param valor o elemento cuja presença nesta pilha deve ser testada
     * @return true se esta pilha contiver o elemento especificado
     */
    boolean contem(E valor);

    /**
     * Retorna a posição baseada em 1 da primeira ocorrência do elemento especificado nesta pilha,
     * ou -1 se esta pilha não contiver o elemento.
     * @param valor o elemento a ser pesquisado
     * @return a posição baseada em 1 do elemento no topo da pilha, ou -1 se o elemento não for encontrado
     */
    int buscar(E valor);

    /**
     * Retorna um array contendo todos os elementos desta pilha na sequência correta (do topo para a base).
     * @return um array contendo todos os elementos desta pilha na sequência correta
     */
    E[] paraArray();
}