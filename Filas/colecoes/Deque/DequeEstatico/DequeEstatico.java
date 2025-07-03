package colecoes.Deque.DequeEstatico;

import colecoes.Deque.DequeAbstrato;
import colecoes.Deque.Deque;
import excecoes.FilaVaziaExcecao;
import excecoes.FilaCheiaExcecao;

/**
 * Implementação de um Deque estático (baseado em array) que adere à interface {@link Deque}.
 * Este deque tem um tamanho máximo fixo e lança uma exceção se for tentado adicionar elementos quando cheio.
 * As operações de adição e remoção nas extremidades podem ser ineficientes devido à movimentação de elementos.
 * @param <E> o tipo de elementos que este deque irá conter
 */
public class DequeEstatico<E> extends DequeAbstrato<E> {

    private E[] deque;
    private int primeiro;

    /**
     * Constrói um novo DequeEstatico com uma capacidade padrão de 10.
     */
    public DequeEstatico() {
        this(10); // Capacidade padrão
    }

    /**
     * Constrói um novo DequeEstatico com a capacidade especificada.
     * @param capacidade a capacidade do deque
     * @throws IllegalArgumentException se a capacidade for menor ou igual a zero
     */
    @SuppressWarnings("unchecked")
    public DequeEstatico(int capacidade) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("A capacidade deve ser positiva.");
        }
        deque = (E[]) new Object[capacidade];
    }

    /**
     * Retorna true se este deque estiver cheio.
     * @return true se este deque estiver cheio
     */
    public boolean estaCheio(){
        return tamanho == deque.length;
    }

    /**
     * Adiciona o elemento especificado no início deste deque.
     * @param valor o elemento a ser adicionado
     * @throws FilaCheiaExcecao se este deque estiver cheio
     */
    @Override
    public void adicionarPrimeiro(E valor) throws FilaCheiaExcecao {
        if(estaCheio()) throw new FilaCheiaExcecao("Deque está cheio!");
        primeiro = (primeiro - 1 + deque.length) % deque.length;
        deque[primeiro] = valor;
        tamanho++;
    }

    /**
     * Adiciona o elemento especificado no final deste deque.
     * @param valor o elemento a ser adicionado
     * @throws FilaCheiaExcecao se este deque estiver cheio
     */
    @Override
    public void adicionarUltimo(E valor) throws FilaCheiaExcecao {
        if(estaCheio()) throw new FilaCheiaExcecao("Deque está cheio!");
        deque[(primeiro + tamanho) % deque.length] = valor;
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
        E valor = deque[primeiro];
        deque[primeiro] = null; // Limpa a referência
        primeiro = (primeiro + 1) % deque.length;
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
        int ultimoIndice = (primeiro + tamanho - 1) % deque.length;
        E valor = deque[ultimoIndice];
        deque[ultimoIndice] = null; // Limpa a referência
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
        return deque[primeiro];
    }

    /**
     * Retorna o elemento do final deste deque sem removê-lo.
     * @return o elemento do final deste deque
     * @throws FilaVaziaExcecao se este deque estiver vazio
     */
    @Override
    public E obterUltimo() throws FilaVaziaExcecao {
        if(estaVazio()) throw new FilaVaziaExcecao("Deque está vazio!");
        return deque[(primeiro + tamanho - 1) % deque.length];
    }

    /**
     * Remove todos os elementos deste deque.
     * O deque ficará vazio após esta chamada retornar.
     */
    @Override
    public void limpar() {
        for (int i = 0; i < tamanho; i++) {
            deque[(primeiro + i) % deque.length] = null;
        }
        primeiro = 0;
        tamanho = 0;
    }

    /**
     * Retorna true se este deque contiver o elemento especificado.
     * @param valor o elemento cuja presença neste deque deve ser testada
     * @return true se este deque contiver o elemento especificado
     */
    @Override
    public boolean contem(E valor) {
        for (int i = 0; i < tamanho; i++) {
            E elemento = deque[(primeiro + i) % deque.length];
            if (valor == null) {
                if (elemento == null) return true;
            } else {
                if (valor.equals(elemento)) return true;
            }
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
        for (int i = 0; i < tamanho; i++) {
            array[i] = deque[(primeiro + i) % deque.length];
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
        for(int i = 0; i < tamanho; i++){
            dadosDeque.append(deque[(primeiro + i) % deque.length]);
            if(i < tamanho-1){
                dadosDeque.append(", ");
            }
        }
        return dadosDeque.append("]").toString();
    }
}


