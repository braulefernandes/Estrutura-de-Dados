package excecoes;

/**
 * Exceção lançada quando uma operação de enfileiramento é tentada em uma fila cheia.
 */
public class FilaCheiaExcecao extends RuntimeException {
    /**
     * Constrói uma nova FilaCheiaExcecao com a mensagem de erro especificada.
     * @param mensagemErro a mensagem de erro
     */
    public FilaCheiaExcecao(String mensagemErro){
        super(mensagemErro);
    }

    /**
     * Constrói uma nova FilaCheiaExcecao sem mensagem de erro.
     */
    public FilaCheiaExcecao(){
        super();
    }
}