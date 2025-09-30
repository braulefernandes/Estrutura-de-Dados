package excecoes;

/**
 * Exceção lançada quando uma operação tenta acessar ou remover um elemento de uma heap vazia.
 */
public class HeapVaziaExcecao extends RuntimeException {

    /**
     * Construtor que recebe a mensagem da exceção.
     * @param message mensagem detalhando o erro
     */
    public HeapVaziaExcecao(String message) {
        super(message);
    }
}