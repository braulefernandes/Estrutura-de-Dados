package colecoes.PilhaEstatica;

import excecoes.PilhaVaziaExcecao;

import colecoes.Pilha;
import excecoes.PilhaCheiaExcecao;

/**
 * Implementação de uma pilha estática (baseada em array) que adere à interface {@link Pilha}.
 * Esta pilha tem um tamanho máximo fixo e lança uma exceção se for tentado adicionar elementos quando cheia.
 * @param <E> o tipo de elementos que esta pilha irá conter
 */
public class PilhaEstatica<E> implements Pilha<E> {

    private int altura;
    private E[] elementos;
    private final int CAPACIDADE_MAXIMA;

    /**
     * Constrói uma nova PilhaEstatica com uma capacidade máxima padrão de 10.
     */
    public PilhaEstatica(){
        this(10); // Chama o outro construtor com uma capacidade padrão
    }
    
    /**
     * Constrói uma nova PilhaEstatica com a capacidade máxima especificada.
     * @param capacidadeMaxima a capacidade máxima da pilha
     * @throws IllegalArgumentException se a capacidade máxima for menor ou igual a zero
     */
    @SuppressWarnings("unchecked")
    public PilhaEstatica(int capacidadeMaxima){
        if (capacidadeMaxima <= 0) {
            throw new IllegalArgumentException("A capacidade máxima deve ser positiva.");
        }
        this.CAPACIDADE_MAXIMA = capacidadeMaxima;
        elementos =(E[]) new Object[CAPACIDADE_MAXIMA];       

    }

    /**
     * Retorna o número de elementos nesta pilha.
     * @return o número de elementos nesta pilha
     */
    @Override
    public int altura() {
        return altura;
    }

    /**
     * Retorna true se esta pilha estiver cheia.
     * @return true se esta pilha estiver cheia
     */
    public boolean estaCheia(){
        return altura == CAPACIDADE_MAXIMA;
    }

    /**
     * Retorna true se esta pilha não contiver elementos.
     * @return true se esta pilha não contiver elementos
     */
    @Override
    public boolean estaVazia() {        
        return altura == 0;
    }
    
    /**
     * Remove e retorna o elemento no topo desta pilha.
     * @return o elemento no topo desta pilha
     * @throws PilhaVaziaExcecao se esta pilha estiver vazia
     */
    @Override
    public E desempilhar() throws PilhaVaziaExcecao {
        if(estaVazia()) throw new PilhaVaziaExcecao("Pilha está vazia!");
        
        E valor = elementos[--altura];
        elementos[altura] = null; // Limpa a referência para coleta de lixo
        return valor;
    }

    /**
     * Adiciona o elemento especificado ao topo desta pilha.
     * @param valor o elemento a ser adicionado
     * @throws PilhaCheiaExcecao se esta pilha estiver cheia
     */
    @Override
    public void empilhar(E valor) throws PilhaCheiaExcecao {
        if(estaCheia()) {
            throw new PilhaCheiaExcecao("Pilha está cheia!");
        }
        elementos[altura++] = valor;        
    }

    /**
     * Retorna o elemento no topo desta pilha sem removê-lo.
     * @return o elemento no topo desta pilha
     * @throws PilhaVaziaExcecao se esta pilha estiver vazia
     */
    @Override
    public E topo() throws PilhaVaziaExcecao {
        if(estaVazia()) throw new PilhaVaziaExcecao("Pilha está vazia!");
        return elementos[altura-1];
    }

    /**
     * Remove todos os elementos desta pilha.
     * A pilha ficará vazia após esta chamada retornar.
     */
    @Override
    public void limpar() {
        for (int i = 0; i < altura; i++) {
            elementos[i] = null; // Limpa as referências
        }
        altura = 0;
    }

    /**
     * Retorna true se esta pilha contiver o elemento especificado.
     * @param valor o elemento cuja presença nesta pilha deve ser testada
     * @return true se esta pilha contiver o elemento especificado
     */
    @Override
    public boolean contem(E valor) {
        for (int i = 0; i < altura; i++) {
            if (valor == null) {
                if (elementos[i] == null) return true;
            } else {
                if (valor.equals(elementos[i])) return true;
            }
        }
        return false;
    }

    /**
     * Retorna a posição baseada em 1 da primeira ocorrência do elemento especificado nesta pilha,
     * ou -1 se esta pilha não contiver o elemento.
     * @param valor o elemento a ser pesquisado
     * @return a posição baseada em 1 do elemento no topo da pilha, ou -1 se o elemento não for encontrado
     */
    @Override
    public int buscar(E valor) {
        for (int i = altura - 1; i >= 0; i--) {
            if (valor == null) {
                if (elementos[i] == null) return (altura - i);
            } else {
                if (valor.equals(elementos[i])) return (altura - i);
            }
        }
        return -1;
    }

    /**
     * Retorna um array contendo todos os elementos da pilha do topo à base, sem usar java.util.Arrays.
     */
    @Override
    @SuppressWarnings("unchecked")
    public E[] paraArray() {
        E[] copia = (E[]) new Object[altura];
        for (int i = 0; i < altura; i++) {
            copia[i] = elementos[i];
        }
        return copia;
    }

    /**
     * Retorna uma representação em string desta pilha.
     * @return uma representação em string desta pilha
     */
    @Override
    public String toString() {
        StringBuilder dadosPilha = new StringBuilder("topo -> ");
        for(int i = altura-1; i >= 0; i--){
            dadosPilha.append(elementos[i]);
            if(i > 0){
                dadosPilha.append("\n       ");
            }
        }
        return estaVazia() ? "[]" : dadosPilha.append(" <- base").toString();
    }
}