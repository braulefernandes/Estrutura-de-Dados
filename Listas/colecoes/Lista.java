package colecoes;

import excecoes.ListaVaziaExcecao;

import java.util.Comparator;

/**
 * Interface que define as operações básicas para uma estrutura de dados de lista.
 * @param <E> o tipo de elementos que esta lista irá conter
 */
public interface Lista<E> {
    /**
     * Adiciona o elemento especificado ao final desta lista.
     * @param valor o elemento a ser adicionado
     */
    void adicionar(E valor);

    /**
     * Insere o elemento especificado no início desta lista.
     * @param valor o elemento a ser inserido
     */
    void inserir(E valor);

    /**
     * Insere o elemento especificado na posição especificada nesta lista.
     * Desloca o elemento atualmente nessa posição (se houver) e quaisquer elementos subsequentes para a direita.
     * @param indice o índice no qual o elemento especificado deve ser inserido
     * @param valor o elemento a ser inserido
     * @throws IndexOutOfBoundsException se o índice estiver fora do intervalo (indice < 0 || indice > tamanho())
     */
    void inserir(int indice, E valor);

    /**
     * Remove e retorna o último elemento desta lista.
     * @return o último elemento desta lista
     * @throws ListaVaziaExcecao se esta lista estiver vazia
     */
    E removerUltimo() throws ListaVaziaExcecao;

    /**
     * Remove e retorna o primeiro elemento desta lista.
     * @return o primeiro elemento desta lista
     * @throws ListaVaziaExcecao se esta lista estiver vazia
     */
    E removerPrimeiro() throws ListaVaziaExcecao;

    /**
     * Remove e retorna o elemento na posição especificada nesta lista.
     * Desloca quaisquer elementos subsequentes para a esquerda.
     * @param indice o índice do elemento a ser removido
     * @return o elemento que foi removido da lista
     * @throws ListaVaziaExcecao se esta lista estiver vazia
     * @throws IndexOutOfBoundsException se o índice estiver fora do intervalo (indice < 0 || indice >= tamanho())
     */
    E removerPorIndice(int indice) throws ListaVaziaExcecao, IndexOutOfBoundsException;

    /**
     * Remove a primeira ocorrência do elemento especificado desta lista, se estiver presente.
     * @param valor o elemento a ser removido desta lista, se presente
     * @return true se esta lista continha o elemento especificado
     * @throws ListaVaziaExcecao se esta lista estiver vazia
     */
    boolean remover(E valor) throws ListaVaziaExcecao;

    /**
     * Retorna o elemento na posição especificada nesta lista.
     * @param indice o índice do elemento a ser retornado
     * @return o elemento na posição especificada
     * @throws ListaVaziaExcecao se esta lista estiver vazia
     * @throws IndexOutOfBoundsException se o índice estiver fora do intervalo (indice < 0 || indice >= tamanho())
     */
    E obter(int indice) throws ListaVaziaExcecao;

    /**
     * Substitui o elemento na posição especificada nesta lista pelo elemento especificado.
     * @param indice o índice do elemento a ser substituído
     * @param valor o elemento a ser armazenado na posição especificada
     * @throws ListaVaziaExcecao se esta lista estiver vazia
     * @throws IndexOutOfBoundsException se o índice estiver fora do intervalo (indice < 0 || indice >= tamanho())
     */
    void definir(int indice, E valor) throws ListaVaziaExcecao;

    /**
     * Retorna true se esta lista contiver o elemento especificado.
     * @param valor o elemento cuja presença nesta lista deve ser testada
     * @return true se esta lista contiver o elemento especificado
     * @throws ListaVaziaExcecao se esta lista estiver vazia
     */
    boolean contem(E valor) throws ListaVaziaExcecao;

    /**
     * Retorna o índice da primeira ocorrência do elemento especificado nesta lista,
     * ou -1 se esta lista não contiver o elemento.
     * @param valor o elemento a ser pesquisado
     * @return o índice da primeira ocorrência do elemento especificado nesta lista,
     *         ou -1 se esta lista não contiver o elemento
     * @throws ListaVaziaExcecao se esta lista estiver vazia
     */
    int indiceDe(E valor) throws ListaVaziaExcecao;

    /**
     * Retorna o número de elementos nesta lista.
     * @return o número de elementos nesta lista
     */
    int tamanho();

    /**
     * Remove todos os elementos desta lista.
     * A lista ficará vazia após esta chamada retornar.
     */
    void limpar();

    /**
     * Retorna true se esta lista não contiver elementos.
     * @return true se esta lista não contiver elementos
     */
    boolean estaVazia();

    /**
     * Retorna um array contendo todos os elementos desta lista na sequência correta.
     * @return um array contendo todos os elementos desta lista na sequência correta
     */
    E[] paraArray();

    /**
     * Adiciona todos os elementos da lista especificada ao final desta lista.
     * @param outraLista a lista cujos elementos devem ser adicionados a esta lista
     */
    void adicionarTodos(Lista<E> outraLista);

    /**
     * Ordena esta lista de acordo com o ordem induzida pelo comparador especificado.
     * @param comparador o {@code Comparator} usado para comparar elementos da lista
     */
    void ordenar(Comparator<E> comparador);

}


