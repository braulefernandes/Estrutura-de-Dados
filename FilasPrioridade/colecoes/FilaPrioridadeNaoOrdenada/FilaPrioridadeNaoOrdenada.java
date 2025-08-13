package colecoes.FilaPrioridadeNaoOrdenada;

import colecoes.FilaPrioridadeAbstrata;
import colecoes.Entrada;
import excecoes.FilaVaziaExcecao;

/**
 * Implementação de uma Fila de Prioridade Não Ordenada.
 * Os elementos são armazenados em ordem de inserção, e a prioridade é avaliada apenas no momento da remoção ou consulta.
 * A operação de inserção (enfileirar) é constante, mas a remoção exige busca pelo maior (ou menor) elemento.
 *
 * @param <K> o tipo da chave usada para determinar a prioridade
 * @param <V> o tipo do valor associado à chave
 */
public class FilaPrioridadeNaoOrdenada<K,V> extends FilaPrioridadeAbstrata<K,V> {

    /**
     * Retorna o nó com a maior prioridade (maior chave) na fila.
     * A busca percorre todos os elementos da fila para encontrar o maior.
     *
     * @return o nó com a maior prioridade
     * @throws FilaVaziaExcecao se a fila estiver vazia
     */
    private No obterNoMaiorPrioridade() {
        if (estaVazia()) throw new FilaVaziaExcecao("Fila de prioridade vazia.");

        No maiorPrioridade = primeiro;
        No noAuxiliar = primeiro.proximo;

        while (noAuxiliar != null) {
            int comp = comparar(noAuxiliar.entrada.obterChave(), maiorPrioridade.entrada.obterChave());
            if (comp > 0) {
                maiorPrioridade = noAuxiliar;
            }
            noAuxiliar = noAuxiliar.proximo;
        }

        return maiorPrioridade;
    }

    /**
     * Retorna o nó com a menor prioridade (menor chave) na fila.
     * A busca percorre todos os elementos da fila para encontrar o menor.
     *
     * @return o nó com a menor prioridade
     * @throws FilaVaziaExcecao se a fila estiver vazia
     */
    private No obterNoMenorPrioridade() {
        if (estaVazia()) throw new FilaVaziaExcecao("Fila de prioridade vazia.");

        No menorPrioridade = primeiro;
        No noAuxiliar = primeiro.proximo;

        while (noAuxiliar != null) {
            int comp = comparar(noAuxiliar.entrada.obterChave(), menorPrioridade.entrada.obterChave());
            if (comp < 0) {
                menorPrioridade = noAuxiliar;
            }
            noAuxiliar = noAuxiliar.proximo;
        }

        return menorPrioridade;
    }

    /**
     * Remove e retorna a entrada com a maior prioridade da fila.
     *
     * @return a entrada com maior prioridade
     * @throws FilaVaziaExcecao se a fila estiver vazia
     */
    @Override
    public Entrada<K, V> desenfileirar() throws FilaVaziaExcecao {
        No aSerRemovido = obterNoMaiorPrioridade();

        if (aSerRemovido == primeiro) {
            primeiro = primeiro.proximo;
            if (tamanho == 1) {
                ultimo = primeiro;
            } else {
                primeiro.anterior = null;
            }
        } else if (aSerRemovido == ultimo) {
            ultimo = ultimo.anterior;
            ultimo.proximo = null;
        } else {
            aSerRemovido.anterior.proximo = aSerRemovido.proximo;
            aSerRemovido.proximo.anterior = aSerRemovido.anterior;
        }

        tamanho--;
        return aSerRemovido.entrada;
    }

    /**
     * Insere uma nova entrada na fila com a chave e valor especificados.
     * A inserção é feita no final da fila.
     *
     * @param chave a chave associada à entrada
     * @param valor o valor associado à entrada
     */
    @Override
    public void enfileirar(K chave, V valor) {   // O(1)
        No novoNo = new No(chave, valor);

        if (estaVazia()) {
            primeiro = novoNo;
        } else {
            novoNo.anterior = ultimo;
            ultimo.proximo = novoNo;
        }

        ultimo = novoNo;
        tamanho++;
    }

    /**
     * Retorna a entrada com a maior prioridade sem removê-la da fila.
     *
     * @return a entrada com maior prioridade
     * @throws FilaVaziaExcecao se a fila estiver vazia
     */
    @Override
    public Entrada<K, V> maiorPrioridade() throws FilaVaziaExcecao {
        return obterNoMaiorPrioridade().entrada;
    }

    /**
     * Retorna a entrada com a menor prioridade sem removê-la da fila.
     *
     * @return a entrada com menor prioridade
     * @throws FilaVaziaExcecao se a fila estiver vazia
     */
    @Override
    public Entrada<K, V> menorPrioridade() throws FilaVaziaExcecao {
        return obterNoMenorPrioridade().entrada;
    }
}