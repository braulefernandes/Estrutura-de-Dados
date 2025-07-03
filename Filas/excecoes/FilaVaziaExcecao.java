package excecoes;

/**
 * Exceção lançada para indicar que uma operação foi tentada em uma fila vazia.
 */
public class FilaVaziaExcecao extends RuntimeException {
    /**
     * Constrói uma nova FilaVaziaExcecao com a mensagem de detalhe especificada.
     * @param mensagem a mensagem de detalhe
     */
    public FilaVaziaExcecao(String mensagem) {
        super(mensagem);
    }
}