package excecoes;

/**
 * Exceção lançada quando uma operação de empilhamento é tentada em uma pilha cheia.
 */
public class PilhaCheiaExcecao extends RuntimeException {
    /**
     * Constrói uma nova PilhaCheiaExcecao com a mensagem de erro especificada.
     * @param mensagemErro a mensagem de erro
     */
    public PilhaCheiaExcecao(String mensagemErro){
        super(mensagemErro);
    }

}