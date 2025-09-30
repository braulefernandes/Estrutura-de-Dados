package colecoes;

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

        /**
         * Constrói um novo nó com o valor especificado.
         * @param valor o valor a ser armazenado no nó
         */
        public No(E valor) {
            this.valor = valor;
            this.proximo = null;
        }

        /**
         * Retorna uma representação em string do nó.
         * @return uma representação em string do nó
         */
        @Override
        public String toString() {
            return valor.toString();
        }
    }

    private No primeiro;
    private No ultimo;
    private int tamanho;

    /**
     * Remove e retorna o elemento na frente desta fila.
     * @return o elemento na frente desta fila
     * @throws FilaVaziaExcecao se esta fila estiver vazia
     */
    @Override
    public E desenfileirar() throws FilaVaziaExcecao {
        E valor = primeiro();
        primeiro = primeiro.proximo;
        if(tamanho == 1){            
            ultimo = primeiro;
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
            ultimo = novoNo;
        }else{
            ultimo.proximo = novoNo;            
            ultimo = novoNo;
        }
        tamanho++;        
    }

    /**
     * Retorna o elemento na frente desta fila sem removê-lo.
     * @return o elemento na frente desta fila
     * @throws FilaVaziaExcecao se esta fila estiver vazia
     */
    @Override
    public E primeiro() throws FilaVaziaExcecao {
        if(estaVazia()) throw new FilaVaziaExcecao();
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
     * Retorna uma representação em string desta fila.
     * @return uma representação em string desta fila
     */
    @Override
    public String toString() {
        StringBuilder dadosFila = new StringBuilder("\\/Primeiro\n");
        No noAuxiliar = primeiro;
        String aux = "";
        while(noAuxiliar!=null){
            dadosFila.append(noAuxiliar);

            noAuxiliar = noAuxiliar.proximo;
            if(noAuxiliar!=null){
                dadosFila.append(", ");
                String dataList = noAuxiliar.valor.toString();
                for(int j = 0; j < dataList.length(); j++){
                    aux += " ";
                }
            }
            aux+="  ";
        }
        return dadosFila.append("\n").append(aux).append("/\\Ultimo").toString();
    }
}