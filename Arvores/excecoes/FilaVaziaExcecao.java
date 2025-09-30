package excecoes;

/**
 * Exceção lançada quando uma operação em fila é tentada em uma fila vazia.
 */
public class FilaVaziaExcecao extends RuntimeException {
    /**
     * Constrói uma nova FilaVaziaExcecao com a mensagem de erro especificada.
     * @param mensagemErro a mensagem de erro
     */
    public FilaVaziaExcecao(String mensagemErro){
        super(mensagemErro);
    }

    /**
     * Constrói uma nova FilaVaziaExcecao sem mensagem de erro.
     */
    public FilaVaziaExcecao(){
        super();
    }
}