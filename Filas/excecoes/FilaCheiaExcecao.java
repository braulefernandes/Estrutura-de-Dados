package excecoes;

/**
 * Exceção lançada para indicar que uma operação de adição foi tentada em uma fila cheia.
 */
public class FilaCheiaExcecao extends RuntimeException {
    /**
     * Constrói uma nova FilaCheiaExcecao com a mensagem de detalhe especificada.
     * @param mensagem a mensagem de detalhe
     */
    public FilaCheiaExcecao(String mensagem) {
        super(mensagem);
    }
}