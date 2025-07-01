package colecoes.PilhaDinamica;

import excecoes.PilhaVaziaExcecao;

import colecoes.Pilha;

/**
 * Implementação de uma pilha dinâmica (baseada em lista encadeada) que adere à interface {@link Pilha}.
 * Esta pilha cresce e diminui dinamicamente conforme os elementos são adicionados ou removidos.
 * @param <E> o tipo de elementos que esta pilha irá conter
 */
public class PilhaDinamica<E> implements Pilha<E> {

    /**
     * Classe interna que representa um nó na pilha encadeada.
     * Cada nó contém um valor e uma referência para o próximo nó na sequência.
     */
    class No{
        No proximo;
        E valor;
        public No(E valor){
            this.valor = valor;
            proximo = null;
        }
        @Override
        public String toString() {
            return "[" + valor + "]";
        }
        
    }

    private int altura;
    private No topo;

    /**
     * Retorna o número de elementos nesta pilha.
     * @return o número de elementos nesta pilha
     */
    @Override
    public int altura() {        
        return altura;
    }

    /**
     * Retorna true se esta pilha não contiver elementos.
     * @return true se esta pilha não contiver elementos
     */
    @Override
    public boolean estaVazia() {
        return topo == null;
    }

    /**
     * Remove e retorna o elemento no topo desta pilha.
     * @return o elemento no topo desta pilha
     * @throws PilhaVaziaExcecao se esta pilha estiver vazia
     */
    @Override
    public E desempilhar() throws PilhaVaziaExcecao {
        if(estaVazia()) throw new PilhaVaziaExcecao("Pilha está vazia!");
        E valor = topo.valor;
        topo = topo.proximo;
        altura--;
        return valor;
    }

    /**
     * Adiciona o elemento especificado ao topo desta pilha.
     * @param valor o elemento a ser adicionado
     */
    @Override
    public void empilhar(E valor) {
        No novoNo = new No(valor);
        novoNo.proximo = topo;
        topo = novoNo;
        altura++;
        
    }

    /**
     * Retorna o elemento no topo desta pilha sem removê-lo.
     * @return o elemento no topo desta pilha
     * @throws PilhaVaziaExcecao se esta pilha estiver vazia
     */
    @Override
    public E topo() throws PilhaVaziaExcecao {
        if(estaVazia()) throw new PilhaVaziaExcecao("Pilha está vazia!");
        return topo.valor;
    }

    /**
     * Remove todos os elementos desta pilha.
     * A pilha ficará vazia após esta chamada retornar.
     */
    @Override
    public void limpar() {
        topo = null;
        altura = 0;
    }

    /**
     * Retorna true se esta pilha contiver o elemento especificado.
     * @param valor o elemento cuja presença nesta pilha deve ser testada
     * @return true se esta pilha contiver o elemento especificado
     */
    @Override
    public boolean contem(E valor) {
        No atual = topo;
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
     * Retorna a posição baseada em 1 da primeira ocorrência do elemento especificado nesta pilha,
     * ou -1 se esta pilha não contiver o elemento.
     * @param valor o elemento a ser pesquisado
     * @return a posição baseada em 1 do elemento no topo da pilha, ou -1 se o elemento não for encontrado
     */
    @Override
    public int buscar(E valor) {
        No atual = topo;
        for (int i = 1; atual != null; i++) {
            if (valor == null) {
                if (atual.valor == null) return i;
            } else {
                if (valor.equals(atual.valor)) return i;
            }
            atual = atual.proximo;
        }
        return -1;
    }

    /**
     * Retorna um array contendo todos os elementos desta pilha na sequência correta (do topo para a base).
     * @return um array contendo todos os elementos desta pilha na sequência correta
     */
    @Override
    @SuppressWarnings("unchecked")
    public E[] paraArray() {
        E[] array = (E[]) new Object[altura];
        No atual = topo;
        for (int i = 0; i < altura; i++) {
            array[i] = atual.valor;
            atual = atual.proximo;
        }
        return array;
    }

    /**
     * Retorna uma representação em string desta pilha.
     * @return uma representação em string desta pilha
     */
    @Override
    public String toString() {
        StringBuilder dadosPilha = new StringBuilder("topo -> ");
        No noAuxiliar = topo;
        while(noAuxiliar!=null){
            dadosPilha.append(noAuxiliar);
            noAuxiliar = noAuxiliar.proximo;
            if(noAuxiliar!=null){
                dadosPilha.append("\n       ");
            }
        }
        return estaVazia()?"[]" : dadosPilha.append(" <- base").toString();
    }
}