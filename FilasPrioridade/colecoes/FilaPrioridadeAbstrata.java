package colecoes;

import excecoes.FilaVaziaExcecao;
import java.util.Comparator;

/**
 * Classe abstrata que implementa funcionalidades comuns para uma Fila de Prioridade.
 * Fornece uma estrutura de lista duplamente encadeada, gerenciamento de tamanho e métodos utilitários.
 * Subclasses concretas devem implementar as estratégias específicas de enfileiramento e desempilhamento.
 *
 * @param <K> o tipo da chave usada para determinar a prioridade
 * @param <V> o tipo do valor associado à chave
 */
public abstract class FilaPrioridadeAbstrata<K, V> implements FilaPrioridade<K, V> {

    /**
     * Classe interna que representa um nó na lista duplamente encadeada,
     * armazenando uma entrada (par chave-valor) e referências ao próximo e anterior nós.
     */
    protected class No {
        public No proximo;
        public No anterior;
        public Entrada<K, V> entrada;

        public No(Entrada<K, V> entrada) {
            this.entrada = entrada;
        }

        public No(K chave, V valor) {
            this.entrada = new EntradaPrioridade(chave, valor);
        }
    }

    /**
     * Implementação interna da interface {@link Entrada}, armazenando uma chave e um valor.
     */
    protected class EntradaPrioridade implements Entrada<K, V> {
        private K chave;
        private V valor;

        public EntradaPrioridade(K chave, V valor) {
            this.chave = chave;
            this.valor = valor;
        }

        @Override
        public K obterChave() {
            return chave;
        }

        @Override
        public V obterValor() {
            return valor;
        }

        @Override
        public String toString() {
            return "(" + chave + ", " + valor + ")";
        }
    }

    /** Número de elementos na fila. */
    protected int tamanho;

    /** Referência para o primeiro nó da fila. */
    protected No primeiro;

    /** Referência para o último nó da fila. */
    protected No ultimo;

    /** Comparador usado para determinar a ordem de prioridade. */
    protected Comparator<K> meuComparador;

    /**
     * Construtor padrão que inicializa a fila com um comparador padrão.
     */
    public FilaPrioridadeAbstrata() {
        meuComparador = new MeuComparador<>();
    }

    /**
     * Compara duas chaves usando o comparador configurado.
     *
     * @param k1 a primeira chave
     * @param k2 a segunda chave
     * @return um número negativo, zero ou positivo conforme k1 seja menor, igual ou maior que k2
     */
    protected int comparar(K k1, K k2) {
        return meuComparador.compare(k1, k2);
    }

    /**
     * Compara duas entradas com base em suas chaves.
     *
     * @param e1 a primeira entrada
     * @param e2 a segunda entrada
     * @return resultado da comparação entre as chaves
     */
    protected int comparar(Entrada<K, V> e1, Entrada<K, V> e2) {
        return meuComparador.compare(e1.obterChave(), e2.obterChave());
    }

    /**
     * Verifica se a fila está vazia.
     *
     * @return true se estiver vazia, false caso contrário
     */
    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    /**
     * Retorna o número de elementos na fila.
     *
     * @return o tamanho da fila
     */
    @Override
    public int tamanho() {
        return tamanho;
    }

    /**
     * Remove todos os elementos da fila.
     */
    @Override
    public void limpar() {
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }

    /**
     * Verifica se a fila contém uma entrada com a chave especificada.
     *
     * @param chave a chave a ser buscada
     * @return true se encontrar a chave, false caso contrário
     */
    @Override
    public boolean contem(K chave) {
        No atual = primeiro;
        while (atual != null) {
            if (chave == null) {
                if (atual.entrada.obterChave() == null) return true;
            } else {
                if (chave.equals(atual.entrada.obterChave())) return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    /**
     * Verifica se a fila contém a entrada especificada.
     *
     * @param entrada a entrada a ser verificada
     * @return true se a entrada estiver presente, false caso contrário
     */
    @Override
    public boolean contem(Entrada<K, V> entrada) {
        No atual = primeiro;
        while (atual != null) {
            if (entrada == null) {
                if (atual.entrada == null) return true;
            } else {
                if (entrada.equals(atual.entrada)) return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    /**
     * Retorna um array com todas as entradas da fila, na ordem atual.
     *
     * @return um array de objetos com todas as entradas
     */
    @Override
    public Object[] paraArray() {
        Object[] array = new Object[tamanho];
        No atual = primeiro;
        for (int i = 0; i < tamanho; i++) {
            array[i] = atual.entrada;
            atual = atual.proximo;
        }
        return array;
    }

    /**
     * Retorna uma representação textual da fila.
     *
     * @return string contendo as entradas da fila
     */
    @Override
    public String toString() {
        StringBuilder dadosFilaPrioridade = new StringBuilder("[");
        No noAuxiliar = primeiro;
        while (noAuxiliar != null) {
            dadosFilaPrioridade.append(noAuxiliar.entrada);
            noAuxiliar = noAuxiliar.proximo;
            if (noAuxiliar != null) {
                dadosFilaPrioridade.append(", ");
            }
        }
        return dadosFilaPrioridade.append("]").toString();
    }

    /**
     * Insere uma nova entrada na fila com a chave e valor especificados.
     * Implementação depende da estratégia adotada pela subclasse.
     *
     * @param chave a chave da nova entrada
     * @param valor o valor associado à chave
     */
    public abstract void enfileirar(K chave, V valor);

    /**
     * Remove e retorna a entrada com maior prioridade da fila.
     * Implementação depende da estratégia adotada pela subclasse.
     *
     * @return a entrada removida
     * @throws FilaVaziaExcecao se a fila estiver vazia
     */
    public abstract Entrada<K, V> desenfileirar() throws FilaVaziaExcecao;

    /**
     * Retorna a entrada com a maior prioridade sem removê-la.
     * Implementação depende da estratégia adotada pela subclasse.
     *
     * @return a entrada com maior prioridade
     * @throws FilaVaziaExcecao se a fila estiver vazia
     */
    public abstract Entrada<K, V> maiorPrioridade() throws FilaVaziaExcecao;

    /**
     * Retorna a entrada com a menor prioridade sem removê-la.
     * Implementação depende da estratégia adotada pela subclasse.
     *
     * @return a entrada com menor prioridade
     * @throws FilaVaziaExcecao se a fila estiver vazia
     */
    public abstract Entrada<K, V> menorPrioridade() throws FilaVaziaExcecao;
}