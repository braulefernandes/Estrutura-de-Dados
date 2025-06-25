package excecoes;

/**
 * Exceção lançada quando uma operação é tentada em uma lista vazia.
 */
public class ListaVaziaExcecao extends RuntimeException {
    /**
     * Constrói uma nova ListaVaziaExcecao com a mensagem de erro especificada.
     * @param mensagemErro a mensagem de erro
     */
    public ListaVaziaExcecao(String mensagemErro){
        super(mensagemErro);
    }
}


