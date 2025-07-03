package colecoes.Fila;

import java.util.Arrays;

/**
 * Classe abstrata que fornece uma implementação base para filas estáticas (baseadas em array).
 * Implementa métodos comuns como `estaVazia()`, `tamanho()`, `limpar()`, `contem()` e `paraArray()`.
 * As subclasses devem implementar os métodos específicos de enfileiramento e desenfileiramento.
 * @param <E> o tipo de elementos que esta fila irá conter
 */
public abstract class FilaEstaticaAbstrata<E> implements Fila<E> {

    protected int tamanho;
    protected E[] fila;

    protected final int TAMANHO_MAXIMO_PADRAO = 5;

    /**
     * Constrói uma nova FilaEstaticaAbstrata com um tamanho máximo padrão.
     */
    @SuppressWarnings("unchecked")
    public FilaEstaticaAbstrata(){
        fila = (E[]) new Object[TAMANHO_MAXIMO_PADRAO];
    }

    /**
     * Constrói uma nova FilaEstaticaAbstrata com o tamanho máximo especificado.
     * @param tamanhoMaximo o tamanho máximo da fila
     */
    @SuppressWarnings("unchecked")
    public FilaEstaticaAbstrata(int tamanhoMaximo){
        fila = (E[]) new Object[tamanhoMaximo];
    }

    /**
     * Retorna true se esta fila estiver cheia.
     * @return true se esta fila estiver cheia
     */
    public boolean estaCheia(){
        return tamanho == fila.length;
    }

    /**
     * Retorna true se esta fila não contiver elementos.
     * @return true se esta fila não contiver elementos
     */
    @Override
    public boolean estaVazia() {        
        return tamanho == 0;
    }

    /**
     * Retorna o número de elementos nesta fila.
     * @return o número de elementos nesta fila
     */
    @Override
    public int tamanho() {   
        return tamanho;
    }

    /**
     * Remove todos os elementos desta fila.
     * A fila ficará vazia após esta chamada retornar.
     */
    @Override
    public void limpar() {
        for (int i = 0; i < tamanho; i++) {
            fila[i] = null; // Limpa as referências
        }
        tamanho = 0;
    }

    /**
     * Retorna true se esta fila contiver o elemento especificado.
     * @param valor o elemento cuja presença nesta fila deve ser testada
     * @return true se esta fila contiver o elemento especificado
     */
    @Override
    public boolean contem(E valor) {
        for (int i = 0; i < tamanho; i++) {
            if (valor == null) {
                if (fila[i] == null) return true;
            } else {
                if (valor.equals(fila[i])) return true;
            }
        }
        return false;
    }

    /**
     * Retorna um array contendo todos os elementos desta fila na sequência correta (do início para o fim).
     * @return um array contendo todos os elementos desta fila na sequência correta
     */
    @Override
    public E[] paraArray() {
        return Arrays.copyOf(fila, tamanho);
    }
}