package colecoes.Fila.FilaEstaticaCircular;

import colecoes.Fila.FilaEstaticaAbstrata;
import colecoes.Fila.Fila;
import excecoes.FilaVaziaExcecao;
import excecoes.FilaCheiaExcecao;


/**
 * Implementação de uma fila estática circular (baseada em array) que adere à interface {@link Fila}.
 * Esta fila otimiza as operações de enfileiramento e desenfileiramento, evitando a movimentação de elementos.
 * @param <E> o tipo de elementos que esta fila irá conter
 */
public class FilaEstaticaCircular<E> extends FilaEstaticaAbstrata<E> {

    private int indicePrimeiro;

    /**
     * Constrói uma nova FilaEstaticaCircular com um tamanho máximo padrão.
     */
    public FilaEstaticaCircular(){
        super();
    }

    /**
     * Constrói uma nova FilaEstaticaCircular com o tamanho máximo especificado.
     * @param tamanhoMaximo o tamanho máximo da fila
     */
    public FilaEstaticaCircular(int tamanhoMaximo){
        super(tamanhoMaximo);
    }

    /**
     * Remove e retorna o elemento do início desta fila.
     * @return o elemento do início desta fila
     * @throws FilaVaziaExcecao se esta fila estiver vazia
     */
    @Override
    public E desenfileirar() throws FilaVaziaExcecao {
        E valor = primeiro();
        this.fila[indicePrimeiro] = null; // Limpa a referência para coleta de lixo
        indicePrimeiro = (indicePrimeiro + 1) % this.fila.length;
        this.tamanho--;
        return valor;
    }

    /**
     * Adiciona o elemento especificado ao final desta fila.
     * @param valor o elemento a ser adicionado
     * @throws FilaCheiaExcecao se esta fila estiver cheia
     */
    @Override
    public void enfileirar(E valor) throws FilaCheiaExcecao {
        if(estaCheia()) throw new FilaCheiaExcecao("Fila está cheia!");
        this.fila[(indicePrimeiro + this.tamanho) % this.fila.length] = valor;
        this.tamanho++;
    }

    /**
     * Retorna o elemento do início desta fila sem removê-lo.
     * @return o elemento do início desta fila
     * @throws FilaVaziaExcecao se esta fila estiver vazia
     */
    @Override
    public E primeiro() throws FilaVaziaExcecao {
        if(estaVazia()) throw new FilaVaziaExcecao("Fila está vazia!");
        return this.fila[indicePrimeiro];
    }

    /**
     * Remove todos os elementos desta fila.
     * A fila ficará vazia após esta chamada retornar.
     */
    @Override
    public void limpar() {
        for (int i = 0; i < this.tamanho; i++) {
            this.fila[(indicePrimeiro + i) % this.fila.length] = null; // Limpa as referências
        }
        indicePrimeiro = 0;
        this.tamanho = 0;
    }

    /**
     * Retorna true se esta fila contiver o elemento especificado.
     * @param valor o elemento cuja presença nesta fila deve ser testada
     * @return true se esta fila contiver o elemento especificado
     */
    @Override
    public boolean contem(E valor) {
        for (int i = 0; i < this.tamanho; i++) {
            E elemento = this.fila[(indicePrimeiro + i) % this.fila.length];
            if (valor == null) {
                if (elemento == null) return true;
            } else {
                if (valor.equals(elemento)) return true;
            }
        }
        return false;
    }

    /**
     * Retorna um array contendo todos os elementos desta fila na sequência correta (do início para o fim).
     * @return um array contendo todos os elementos desta fila na sequência correta
     */
    @Override
    @SuppressWarnings("unchecked")
    public E[] paraArray() {
        E[] array = (E[]) new Object[this.tamanho];
        for (int i = 0; i < this.tamanho; i++) {
            array[i] = this.fila[(indicePrimeiro + i) % this.fila.length];
        }
        return array;
    }

    /**
     * Retorna uma representação em string desta fila.
     * @return uma representação em string desta fila
     */
    @Override
    public String toString() {
        StringBuilder dadosFila = new StringBuilder("\\/Início\n");
        for(int i = 0; i < this.tamanho; i++){
            dadosFila.append(this.fila[(indicePrimeiro + i) % this.fila.length]);
            if(i < this.tamanho-1){
                dadosFila.append(", ");
            }
        }
        return dadosFila.append("\n/\\Fim").toString();
    }
}