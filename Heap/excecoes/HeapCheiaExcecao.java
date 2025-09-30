package excecoes;

/**
 * Exceção lançada quando uma operação tenta inserir um elemento em uma heap cheia.
 */
public class HeapCheiaExcecao extends RuntimeException {

    /**
     * Construtor que recebe a mensagem da exceção.
     * @param message mensagem detalhando o erro
     */
    public HeapCheiaExcecao(String message) {
        super(message);
    }
}