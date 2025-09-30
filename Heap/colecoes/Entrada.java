package colecoes;

/**
 * Interface que representa uma entrada genérica contendo uma chave e um valor.
 * 
 * @param <K> tipo da chave
 * @param <V> tipo do valor
 */
public interface Entrada<K,V> {
    
    /**
     * Retorna a chave desta entrada.
     * @return chave associada a esta entrada
     */
    K getKey();

    /**
     * Retorna o valor desta entrada.
     * @return valor associado a esta entrada
     */
    V getValue();
}