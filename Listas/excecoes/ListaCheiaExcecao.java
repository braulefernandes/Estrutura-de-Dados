package excecoes;

/**
 * Exceção lançada quando uma operação de adição é tentada em uma lista cheia (geralmente estática).
 */
public class ListaCheiaExcecao extends RuntimeException {
    /**
     * Constrói uma nova ListaCheiaExcecao com a mensagem de erro especificada.
     * @param mensagemErro a mensagem de erro
     */
    public ListaCheiaExcecao(String mensagemErro){
        super(mensagemErro);
    }

}


