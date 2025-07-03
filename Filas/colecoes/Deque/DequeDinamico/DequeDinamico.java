package colecoes.Deque.DequeDinamico;

import colecoes.Deque.DequeAbstrato;
import colecoes.Deque.Deque;
import excecoes.FilaVaziaExcecao;


/**
 * Implementação de um Deque dinâmico (baseado em lista duplamente encadeada) que adere à interface {@link Deque}.
 * Este deque cresce e diminui dinamicamente conforme os elementos são adicionados ou removidos.
 * @param <E> o tipo de elementos que este deque irá conter
 */
public class DequeDinamico<E> extends DequeAbstrato<E> {

    /**
     * Classe interna que representa um nó na lista duplamente encadeada.
     * Cada nó contém um valor e referências para o nó anterior e o próximo nó na sequência.
     */
    class No{
        No proximo;
        No anterior;
        E valor;
        public No(E valor) {
            this.valor = valor;
        }        
    }

    private No primeiro;
    private No ultimo;
    
    /**
     * Adiciona o elemento especificado no início deste deque.
     * @param valor o elemento a ser adicionado
     */
    @Override
    public void adicionarPrimeiro(E valor) {
        No novoNo = new No(valor);
        if(estaVazio()){
            primeiro = novoNo;
            ultimo = novoNo;
        }else{
            novoNo.proximo = primeiro;
            primeiro.anterior = novoNo;
            primeiro = novoNo;
        }
        tamanho++;
    }

    /**
     * Adiciona o elemento especificado no final deste deque.
     * @param valor o elemento a ser adicionado
     */
    @Override
    public void adicionarUltimo(E valor) {
        No novoNo = new No(valor);
        if(estaVazio()){
            primeiro = novoNo;
            ultimo = novoNo;
        }else{
            ultimo.proximo = novoNo;
            novoNo.anterior = ultimo;
            ultimo = novoNo;
        }
        tamanho++;
    }

    /**
     * Remove e retorna o elemento do início deste deque.
     * @return o elemento do início deste deque
     * @throws FilaVaziaExcecao se este deque estiver vazio
     */
    @Override
    public E removerPrimeiro() throws FilaVaziaExcecao {
        if(estaVazio()) throw new FilaVaziaExcecao("Deque está vazio!");
        E valor = primeiro.valor;
        primeiro = primeiro.proximo;
        if(primeiro != null){
            primeiro.anterior = null;
        } else { // Deque se tornou vazio
            ultimo = null;
        }
        tamanho--;
        return valor;
    }

    /**
     * Remove e retorna o elemento do final deste deque.
     * @return o elemento do final deste deque
     * @throws FilaVaziaExcecao se este deque estiver vazio
     */
    @Override
    public E removerUltimo() throws FilaVaziaExcecao {
        if(estaVazio()) throw new FilaVaziaExcecao("Deque está vazio!");
        E valor = ultimo.valor;
        ultimo = ultimo.anterior;
        if(ultimo != null){
            ultimo.proximo = null;
        } else { // Deque se tornou vazio
            primeiro = null;
        }
        tamanho--;
        return valor;
    }

    /**
     * Retorna o elemento do início deste deque sem removê-lo.
     * @return o elemento do início deste deque
     * @throws FilaVaziaExcecao se este deque estiver vazio
     */
    @Override
    public E obterPrimeiro() throws FilaVaziaExcecao {
        if(estaVazio()) throw new FilaVaziaExcecao("Deque está vazio!");
        return primeiro.valor;
    }
    
    /**
     * Retorna o elemento do final deste deque sem removê-lo.
     * @return o elemento do final deste deque
     * @throws FilaVaziaExcecao se este deque estiver vazio
     */
    @Override
    public E obterUltimo() throws FilaVaziaExcecao {        
        if(estaVazio()) throw new FilaVaziaExcecao("Deque está vazio!");
        return ultimo.valor;        
    }

    /**
     * Remove todos os elementos deste deque.
     * O deque ficará vazio após esta chamada retornar.
     */
    @Override
    public void limpar() {
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }

    /**
     * Retorna true se este deque contiver o elemento especificado.
     * @param valor o elemento cuja presença neste deque deve ser testada
     * @return true se este deque contiver o elemento especificado
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
     * Retorna um array contendo todos os elementos deste deque na sequência correta.
     * @return um array contendo todos os elementos deste deque na sequência correta
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
     * Retorna uma representação em string deste deque.
     * @return uma representação em string deste deque
     */
    @Override
    public String toString() {
        StringBuilder dadosDeque = new StringBuilder("[");
        No noAuxiliar = primeiro;
        while(noAuxiliar != null){
            dadosDeque.append(noAuxiliar.valor);
            noAuxiliar = noAuxiliar.proximo;
            if(noAuxiliar!=null){
                dadosDeque.append(", ");
            }
        }
        return dadosDeque.append("]").toString();
    }
}