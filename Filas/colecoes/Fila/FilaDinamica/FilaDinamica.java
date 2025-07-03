package colecoes.Fila.FilaDinamica;

import colecoes.Fila.Fila;
import excecoes.FilaVaziaExcecao;

/**
 * Implementação de uma fila dinâmica (baseada em lista encadeada) que adere à interface {@link Fila}.
 * Esta fila cresce e diminui dinamicamente conforme os elementos são adicionados ou removidos.
 * @param <E> o tipo de elementos que esta fila irá conter
 */
public class FilaDinamica<E> implements Fila<E> {

    /**
     * Classe interna que representa um nó na fila encadeada.
     * Cada nó contém um valor e uma referência para o próximo nó na sequência.
     */
    class No{
        No proximo;
        E valor;
        public No(E valor) {
            this.valor = valor;
        }
        @Override
        public String toString() {
            return valor.toString();
        }
    }

    private No primeiro;
    private No ultimo;
    private int tamanho;

    /**
     * Remove e retorna o elemento do início desta fila.
     * @return o elemento do início desta fila
     * @throws FilaVaziaExcecao se esta fila estiver vazia
     */
    @Override
    public E desenfileirar() throws FilaVaziaExcecao {
        if(estaVazia()) throw new FilaVaziaExcecao("Fila está vazia!");
        E valor = primeiro.valor;
        primeiro = primeiro.proximo;
        if(primeiro == null){ // Se a fila se tornou vazia
            ultimo = null;
        }
        tamanho--;
        return valor;
    }

    /**
     * Adiciona o elemento especificado ao final desta fila.
     * @param valor o elemento a ser adicionado
     */
    @Override
    public void enfileirar(E valor) {
        No novoNo = new No(valor);
        if(estaVazia()){
            primeiro = novoNo;            
        }else{
            ultimo.proximo = novoNo;            
        }
        ultimo = novoNo;
        tamanho++;        
    }

    /**
     * Retorna o elemento do início desta fila sem removê-lo.
     * @return o elemento do início desta fila
     * @throws FilaVaziaExcecao se esta fila estiver vazia
     */
    @Override
    public E primeiro() throws FilaVaziaExcecao {
        if(estaVazia()) throw new FilaVaziaExcecao("Fila está vazia!");
        return primeiro.valor;
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
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }

    /**
     * Retorna true se esta fila contiver o elemento especificado.
     * @param valor o elemento cuja presença nesta fila deve ser testada
     * @return true se esta fila contiver o elemento especificado
     */
    @Override
    public boolean contem(E valor) {
        No atual = primeiro;
        while (atual != null) {
            if (valor == null) {
                if (atual.valor == null) return true;
            } else {
                if (valor.equals(atual.valor)) return true;
            }
            atual = atual.proximo;
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
        E[] array = (E[]) new Object[tamanho];
        No atual = primeiro;
        for (int i = 0; i < tamanho; i++) {
            array[i] = atual.valor;
            atual = atual.proximo;
        }
        return array;
    }

    /**
     * Retorna uma representação em string desta fila.
     * @return uma representação em string desta fila
     */
    @Override
    public String toString() {
        StringBuilder dadosLista = new StringBuilder("\\/Início\n");
        No noAuxiliar = primeiro;
        while(noAuxiliar!=null){
            dadosLista.append(noAuxiliar);
            noAuxiliar = noAuxiliar.proximo;
            if(noAuxiliar!=null){
                dadosLista.append(", ");
            }
        }
        return dadosLista.append("\n/\\Fim").toString();
    }
}