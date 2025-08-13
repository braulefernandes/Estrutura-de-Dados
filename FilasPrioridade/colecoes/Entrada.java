package colecoes;

/**
 * Interface que representa uma entrada (par chave-valor) em uma estrutura de dados de prioridade.
 *
 * @param <K> o tipo da chave (utilizada para comparação de prioridade)
 * @param <V> o tipo do valor associado à chave
 */
public interface Entrada<K, V> {

    /**
     * Retorna a chave desta entrada.
     * A chave é usada para determinar a prioridade em estruturas como filas de prioridade.
     *
     * @return a chave associada a esta entrada
     */
    K obterChave();

    /**
     * Retorna o valor associado a esta entrada.
     * O valor é o conteúdo armazenado vinculado à chave de prioridade.
     *
     * @return o valor associado a esta entrada
     */
    V obterValor();
}
