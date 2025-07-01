package excecoes;

/**
 * Exceção lançada quando uma operação é tentada em uma pilha vazia.
 */
public class PilhaVaziaExcecao extends RuntimeException {
    /**
     * Constrói uma nova PilhaVaziaExcecao com a mensagem de erro especificada.
     * @param mensagemErro a mensagem de erro
     */
    public PilhaVaziaExcecao(String mensagemErro){
        super(mensagemErro);
    }
}