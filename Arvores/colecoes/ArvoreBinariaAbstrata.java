package colecoes;

import java.util.Comparator;

/**
 * Classe abstrata que implementa as funcionalidades comuns de uma Árvore Binária.
 * Esta classe fornece a estrutura básica para árvores binárias, incluindo a definição de nós
 * e métodos para comparação de elementos.
 * @param <E> o tipo de elementos que esta árvore binária irá conter
 */
public abstract class ArvoreBinariaAbstrata<E> implements Arvore<E> {

    /**
     * Classe interna que representa um nó na árvore binária.
     * Cada nó contém um valor e referências para os nós filhos esquerdo e direito.
     */
    public class No{
        public No esquerda;
        public No direita;
        public E valor;

        /**
         * Constrói um novo nó com o valor especificado.
         * @param valor o valor a ser armazenado no nó
         */
        public No(E valor) {
            this.valor = valor;
            this.esquerda = null;
            this.direita = null;
        }

        /**
         * Retorna uma representação em string do nó.
         * @return uma representação em string do nó
         */
        @Override
        public String toString() {
            return "(" + valor + ")";
        }    
    }

    protected int tamanho;
    protected No raiz;
    protected Comparator<E> comparador;

    /**
     * Constrói uma nova ArvoreBinariaAbstrata com um comparador padrão.
     */
    public ArvoreBinariaAbstrata() {
        comparador = new ComparadorPadrao<>();
    }

    /**
     * Compara os valores de dois nós usando o comparador da árvore.
     * @param n1 o primeiro nó a ser comparado
     * @param n2 o segundo nó a ser comparado
     * @return um valor negativo, zero ou um valor positivo se o primeiro nó for menor, igual ou maior que o segundo
     */
    protected int comparar(No n1, No n2){
        return comparador.compare(n1.valor,n2.valor);
    }

    /**
     * Compara um valor com o valor de um nó usando o comparador da árvore.
     * @param valor o valor a ser comparado
     * @param no o nó cujo valor será comparado
     * @return um valor negativo, zero ou um valor positivo se o valor for menor, igual ou maior que o valor do nó
     */
    protected int comparar(E valor, No no){
        return comparador.compare(valor,no.valor);
    }

    /**
     * Retorna true se esta árvore não contiver elementos.
     * @return true se esta árvore não contiver elementos
     */
    @Override
    public boolean estaVazia() {        
        return tamanho == 0;
    }

    /**
     * Retorna o número de elementos nesta árvore.
     * @return o número de elementos nesta árvore
     */
    @Override
    public int tamanho() {
        return tamanho;
    }

}