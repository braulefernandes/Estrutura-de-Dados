package colecoes.Deque;

/**
 * Classe abstrata que fornece uma implementação base para Deques.
 * Implementa métodos comuns como `estaVazio()`, `tamanho()`, `limpar()`, `contem()` e `paraArray()`.
 * As subclasses devem implementar os métodos específicos de adição e remoção nas extremidades.
 * @param <E> o tipo de elementos que este deque irá conter
 */
public abstract class DequeAbstrato<E> implements Deque<E> {
    protected int tamanho;

    /**
     * Retorna true se este deque não contiver elementos.
     * @return true se este deque não contiver elementos
     */
    @Override
    public boolean estaVazio() {        
        return tamanho == 0;
    }

    /**
     * Retorna o número de elementos neste deque.
     * @return o número de elementos neste deque
     */
    @Override
    public int tamanho() {        
        return tamanho;
    }

    /**
     * Remove todos os elementos deste deque.
     * O deque ficará vazio após esta chamada retornar.
     */
    @Override
    public void limpar() {
        // Implementação específica será nas subclasses
        tamanho = 0;
    }

    /**
     * Retorna true se este deque contiver o elemento especificado.
     * @param valor o elemento cuja presença neste deque deve ser testada
     * @return true se este deque contiver o elemento especificado
     */
    @Override
    public boolean contem(E valor) {
        // Implementação específica será nas subclasses
        return false;
    }

    /**
     * Retorna um array contendo todos os elementos deste deque na sequência correta.
     * @return um array contendo todos os elementos deste deque na sequência correta
     */
    @Override
    @SuppressWarnings("unchecked")
    public E[] paraArray() {
        // Implementação específica será nas subclasses
        return (E[]) new Object[0];
    }
}