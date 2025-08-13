package colecoes.FilaPrioridadeOrdenada;

import colecoes.FilaPrioridadeAbstrata;
import colecoes.Entrada;
import excecoes.FilaVaziaExcecao;

/**
 * Implementação de uma Fila de Prioridade Ordenada.
 * Os elementos são mantidos em ordem decrescente de prioridade (maior prioridade no início da fila).
 * A inserção ocorre em tempo O(n), pois exige encontrar a posição correta.
 *
 * @param <K> o tipo da chave usada para determinar a prioridade
 * @param <V> o tipo do valor associado à chave
 */
public class FilaPrioridadeOrdenada<K,V> extends FilaPrioridadeAbstrata<K,V> {

    /**
     * Remove e retorna a entrada com a maior prioridade da fila.
     * Como a fila está ordenada em ordem decrescente, o maior elemento está sempre no início.
     *
     * @return a entrada com maior prioridade
     * @throws FilaVaziaExcecao se a fila estiver vazia
     */
    @Override
    public Entrada<K, V> desenfileirar() throws FilaVaziaExcecao {
        if (estaVazia()) throw new FilaVaziaExcecao("Fila de prioridade vazia.");

        Entrada<K, V> entrada = primeiro.entrada;
        primeiro = primeiro.proximo;

        if (primeiro != null) {
            primeiro.anterior = null;
        } else {
            ultimo = null;
        }

        tamanho--;
        return entrada;
    }

    /**
     * Insere uma nova entrada na fila, mantendo a ordenação pela prioridade.
     * A chave mais alta representa maior prioridade.
     *
     * @param chave a chave associada à entrada
     * @param valor o valor associado à entrada
     */
    @Override
    public void enfileirar(K chave, V valor) {
        No novoNo = new No(chave, valor);

        if (estaVazia()) {
            primeiro = novoNo;
            ultimo = novoNo;
        } else {
            // Percorre a fila até encontrar a posição correta para inserção
            No atual = primeiro;
            while (atual != null && comparar(chave, atual.entrada.obterChave()) > 0) {
                atual = atual.proximo;
            }

            if (atual == null) { // Inserir no final
                novoNo.anterior = ultimo;
                ultimo.proximo = novoNo;
                ultimo = novoNo;
            } else if (atual == primeiro) { // Inserir no início
                novoNo.proximo = primeiro;
                primeiro.anterior = novoNo;
                primeiro = novoNo;
            } else { // Inserir no meio
                novoNo.proximo = atual;
                novoNo.anterior = atual.anterior;
                atual.anterior.proximo = novoNo;
                atual.anterior = novoNo;
            }
        }

        tamanho++;
    }

    /**
     * Retorna a entrada com a maior prioridade sem removê-la da fila.
     * Como a fila está ordenada, esse elemento está sempre no início.
     *
     * @return a entrada com maior prioridade
     * @throws FilaVaziaExcecao se a fila estiver vazia
     */
    @Override
    public Entrada<K, V> maiorPrioridade() throws FilaVaziaExcecao {
        if (estaVazia()) throw new FilaVaziaExcecao("Fila de prioridade vazia.");
        return primeiro.entrada;
    }

    /**
     * Retorna a entrada com a menor prioridade sem removê-la da fila.
     * Como a fila está ordenada, esse elemento está sempre no final.
     *
     * @return a entrada com menor prioridade
     * @throws FilaVaziaExcecao se a fila estiver vazia
     */
    @Override
    public Entrada<K, V> menorPrioridade() throws FilaVaziaExcecao {
        if (estaVazia()) throw new FilaVaziaExcecao("Fila de prioridade vazia.");
        return ultimo.entrada;
    }
}