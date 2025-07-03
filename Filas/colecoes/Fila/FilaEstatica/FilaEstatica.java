package colecoes.Fila.FilaEstatica;

import colecoes.Fila.FilaEstaticaAbstrata;
import colecoes.Fila.Fila;
import excecoes.FilaVaziaExcecao;
import excecoes.FilaCheiaExcecao;

/**
 * Implementação de uma fila estática (baseada em array) que adere à interface {@link Fila}.
 * Esta fila tem um tamanho máximo fixo e lança uma exceção se for tentado adicionar elementos quando cheia.
 * As operações de `desenfileirar` envolvem a movimentação de elementos, o que pode ser ineficiente para filas grandes.
 * @param <E> o tipo de elementos que esta fila irá conter
 */
public class FilaEstatica<E> extends FilaEstaticaAbstrata<E> {

    /**
     * Constrói uma nova FilaEstatica com um tamanho máximo padrão.
     */
    public FilaEstatica(){
        super();
    }

    /**
     * Constrói uma nova FilaEstatica com o tamanho máximo especificado.
     * @param tamanhoMaximo o tamanho máximo da fila
     */
    public FilaEstatica(int tamanhoMaximo){
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
        tamanho--;
        for(int i = 0; i < tamanho; i++){
            fila[i] = fila[i+1];
        }
        fila[tamanho] = null; // Limpa a referência para coleta de lixo
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
        fila[tamanho++] = valor;
    }

    /**
     * Retorna o elemento do início desta fila sem removê-lo.
     * @return o elemento do início desta fila
     * @throws FilaVaziaExcecao se esta fila estiver vazia
     */
    @Override
    public E primeiro() throws FilaVaziaExcecao {
        if(estaVazia()) throw new FilaVaziaExcecao("Fila está vazia!");
        return fila[0];
    }

    /**
     * Retorna uma representação em string desta fila.
     * @return uma representação em string desta fila
     */
    @Override
    public String toString() {
        StringBuilder dadosLista = new StringBuilder("\\/Início\n");     
        for(int i = 0; i < tamanho; i++){
            dadosLista.append(fila[i]);         
            if(i < tamanho-1){
                dadosLista.append(", ");
            }
        }
        dadosLista.append("\n");
        return dadosLista.append("/\\Fim").toString();
    }
}