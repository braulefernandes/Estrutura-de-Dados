package colecoes;

import java.util.Comparator;

/**
 * Implementação personalizada de comparador que define regras específicas para comparação de objetos.
 * 
 * Comportamento:
 * 
 *   Se ambos os objetos forem {@code null}, considera-os iguais.
 *   Se apenas um dos objetos for {@code null}, este será considerado "menor".
 *   Se os objetos forem do tipo {@code String}, a comparação será feita pelo comprimento da string.
 *   Caso contrário, utiliza o método {@code compareTo} se o objeto for uma instância de {@code Comparable}.
 *   Se não for possível comparar, lança {@code IllegalArgumentException}.
 *
 * @param <T> o tipo dos objetos a serem comparados
 */
public class MeuComparador<T> implements Comparator<T> {

    /**
     * Compara dois objetos com base em regras personalizadas.
     *
     * @param o1 o primeiro objeto a ser comparado
     * @param o2 o segundo objeto a ser comparado
     * @return um número negativo se o1 < o2, zero se o1 == o2, um número positivo se o1 > o2
     * @throws IllegalArgumentException se os objetos não forem comparáveis
     */
    @Override
    @SuppressWarnings("unchecked")
    public int compare(T o1, T o2) {
        // Ambos nulos são iguais
        if (o1 == null && o2 == null) return 0;
        if (o1 == null) return -1;
        if (o2 == null) return 1;

        // Comparação especial para strings: por tamanho
        if (o1 instanceof String && o2 instanceof String) {
            int len1 = ((String) o1).length();
            int len2 = ((String) o2).length();
            return Integer.compare(len1, len2);
        }

        // Comparação natural para objetos comparáveis
        if (o1 instanceof Comparable) {
            return ((Comparable<T>) o1).compareTo(o2);
        }

        // Objeto não é comparável
        throw new IllegalArgumentException("Tipo não comparável: " + o1.getClass().getName());
    }
}
