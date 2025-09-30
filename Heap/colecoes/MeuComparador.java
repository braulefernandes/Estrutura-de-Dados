package colecoes;

import java.util.Comparator;

/**
 * Implementação personalizada da interface Comparator.
 * Compara objetos do tipo T de forma geral,
 * mas trata Strings comparando seu tamanho (quantidade de caracteres).
 * Para outros tipos, assume que T implementa Comparable e usa compareTo.
 * 
 * @param <T> tipo dos objetos a serem comparados
 */
public class MeuComparador<T> implements Comparator<T> {

    /**
     * Compara dois objetos do tipo T.
     * Se forem Strings, compara pelo tamanho da string.
     * Caso contrário, utiliza o método compareTo do Comparable.
     * 
     * @param o1 primeiro objeto
     * @param o2 segundo objeto
     * @return número negativo se o1 < o2, zero se iguais, positivo se o1 > o2
     */
    @Override
    @SuppressWarnings("unchecked")
    public int compare(T o1, T o2) {
        if(o1 instanceof String){
            // Compara pelo tamanho da string
            if(((String)o1).length() > ((String)o2).length()){
                return 1;
            } else if(((String)o1).length() < ((String)o2).length()){
                return -1;
            } else {
                return 0;
            }
        }
        // Assume que T implementa Comparable e realiza comparação natural
        return ((Comparable<T>)o1).compareTo(o2);
    }
}