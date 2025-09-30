package colecoes;

import java.util.Comparator;

/**
 * Implementação de um comparador padrão para tipos genéricos que implementam a interface {@link Comparable}.
 * Este comparador é utilizado para definir a ordem natural dos elementos em estruturas de dados como árvores.
 * @param <T> o tipo de objetos que podem ser comparados por este comparador
 */
public class ComparadorPadrao<T> implements Comparator<T> {

    /**
     * Compara dois objetos para determinar sua ordem.
     * @param o1 o primeiro objeto a ser comparado
     * @param o2 o segundo objeto a ser comparado
     * @return um valor negativo, zero ou um valor positivo se o primeiro objeto for menor, igual ou maior que o segundo
     * @throws ClassCastException se os objetos não forem do tipo {@link Comparable}
     */
    @SuppressWarnings("unchecked")
    @Override
    public int compare(T o1, T o2) {
        
        return ((Comparable<T>)o1).compareTo(o2);
    }
}