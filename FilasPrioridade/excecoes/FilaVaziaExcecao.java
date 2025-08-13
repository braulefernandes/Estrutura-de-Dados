package excecoes;

/**
 * Exceção lançada para indicar que uma operação foi tentada em uma fila de prioridade vazia.
 *
 * Esta exceção é usada quando métodos como {@code desenfileirar()}, {@code maiorPrioridade()} ou 
 * {@code menorPrioridade()} são chamados em uma estrutura que não contém elementos.
 *
 * Extende {@link RuntimeException}, portanto não é necessário ser capturada obrigatoriamente.
 */
public class FilaVaziaExcecao extends RuntimeException {

    /**
     * Constrói uma nova exceção com a mensagem especificada.
     *
     * @param message a mensagem que descreve o erro
     */
    public FilaVaziaExcecao(String message) {
        super(message);
    }
}
