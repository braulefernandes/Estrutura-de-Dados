package colecoes;

/**
 * Interface que define as operações básicas de uma Árvore.
 * @param <E> o tipo de elementos que esta árvore irá conter
 */
public interface Arvore<E> {

    /**
     * Insere o elemento especificado na árvore.
     * @param valor o elemento a ser inserido
     */
    void inserir(E valor);

    /**
     * Remove e retorna o elemento especificado da árvore.
     * @param valor o elemento a ser removido
     * @return o elemento removido, ou null se não encontrado
     */
    E remover(E valor);

    /**
     * Busca e retorna o elemento especificado na árvore.
     * @param valor o elemento a ser buscado
     * @return o elemento encontrado, ou null se não encontrado
     */
    E buscar(E valor);

    /**
     * Realiza um percorrimento na árvore e retorna uma string com os elementos.
     * @param tipo o tipo de percorrimento (ex: "bfs", "inOrder", "preOrder", "postOrder")
     * @return uma string contendo os elementos da árvore no tipo de percorrimento especificado
     */
    String percorrerArvore(String tipo);

    /**
     * Retorna o número de elementos nesta árvore.
     * @return o número de elementos nesta árvore
     */
    int tamanho();

    /**
     * Retorna true se esta árvore não contiver elementos.
     * @return true se esta árvore não contiver elementos
     */
    boolean estaVazia();

}