package colecoes.ListaEstatica;

import colecoes.Lista;
import excecoes.ListaVaziaExcecao;
import excecoes.ListaCheiaExcecao;

import java.util.Comparator;

/**
 * Implementação de uma lista estática (baseada em array) que adere à interface {@link Lista}.
 * Esta lista tem um tamanho máximo fixo e lança uma exceção se for tentado adicionar elementos quando cheia.
 * @param <E> o tipo de elementos que esta lista irá conter
 */
public class ListaEstatica<E> implements Lista<E> {

    protected E[] elementos;
    protected int tamanho;
    protected final int TAMANHO_MAXIMO;

    /**
     * Constrói uma nova ListaEstatica com um tamanho máximo padrão de 24.
     */
    @SuppressWarnings("unchecked")
    public ListaEstatica(){
        this.TAMANHO_MAXIMO = 24; // Tamanho padrão
        elementos = (E[])new Object[TAMANHO_MAXIMO];
    }

    /**
     * Constrói uma nova ListaEstatica com o tamanho máximo especificado.
     * @param tamanhoMaximo o tamanho máximo da lista
     * @throws IllegalArgumentException se o tamanho máximo for menor ou igual a zero
     */
    @SuppressWarnings("unchecked")
    public ListaEstatica(int tamanhoMaximo){
        if (tamanhoMaximo <= 0) {
            throw new IllegalArgumentException("O tamanho máximo deve ser positivo.");
        }
        this.TAMANHO_MAXIMO = tamanhoMaximo;
        elementos = (E[])new Object[TAMANHO_MAXIMO];
    }

    /**
     * Adiciona o elemento especificado ao final desta lista.
     * @param valor o elemento a ser adicionado
     * @throws ListaCheiaExcecao se a lista estiver cheia
     */
    @Override
    public void adicionar(E valor) throws ListaCheiaExcecao {
        if(estaCheia()) throw new ListaCheiaExcecao("Lista Estática está Cheia!");
        elementos[tamanho] = valor;
        tamanho++;
    }
    
    /**
     * Remove todos os elementos desta lista.
     * A lista ficará vazia após esta chamada retornar.
     */
    @Override
    public void limpar() {
        // Não é necessário anular elementos em Java para coleta de lixo, apenas redefinir o tamanho
        tamanho = 0;        
    }
    
    /**
     * Retorna true se esta lista contiver o elemento especificado.
     * @param valor o elemento cuja presença nesta lista deve ser testada
     * @return true se esta lista contiver o elemento especificado
     * @throws ListaVaziaExcecao se esta lista estiver vazia
     */
    @Override
    public boolean contem(E valor) throws ListaVaziaExcecao {
        if(estaVazia()) throw new ListaVaziaExcecao("Lista Estática está Vazia!");
        for(int i = 0; i < tamanho; i++){
            if (valor == null) {
                if (elementos[i] == null) return true;
            } else {
                if (valor.equals(elementos[i])) return true;
            }
        }
        return false;
    }
    
    /**
     * Retorna o elemento na posição especificada nesta lista.
     * @param indice o índice do elemento a ser retornado
     * @return o elemento na posição especificada
     * @throws ListaVaziaExcecao se esta lista estiver vazia
     * @throws IndexOutOfBoundsException se o índice estiver fora do intervalo (indice < 0 || indice >= tamanho())
     */
    @Override
    public E obter(int indice) throws ListaVaziaExcecao {
        if(estaVazia()) throw new ListaVaziaExcecao("Lista Estática está Vazia!");
        verificarIndice(indice);
        return elementos[indice];
    }
    
    /**
     * Insere o elemento especificado no início desta lista.
     * Desloca o elemento atualmente nessa posição (se houver) e quaisquer elementos subsequentes para a direita.
     * @param valor o elemento a ser inserido
     * @throws ListaCheiaExcecao se a lista estiver cheia
     */
    @Override
    public void inserir(E valor) throws ListaCheiaExcecao {
        if(estaCheia()) throw new ListaCheiaExcecao("Lista Estática está Cheia!");
        for(int i = tamanho; i > 0; i-- ){
            elementos[i] = elementos[i-1];
        }
        elementos[0] = valor;
        tamanho++;
    }
    
    /**
     * Insere o elemento especificado na posição especificada nesta lista.
     * Desloca o elemento atualmente nessa posição (se houver) e quaisquer elementos subsequentes para a direita.
     * @param indice o índice no qual o elemento especificado deve ser inserido
     * @param valor o elemento a ser inserido
     * @throws ListaCheiaExcecao se a lista estiver cheia
     * @throws IndexOutOfBoundsException se o índice estiver fora do intervalo (indice < 0 || indice > tamanho())
     */
    @Override
    public void inserir(int indice, E valor) throws ListaCheiaExcecao {
        if(estaCheia()) throw new ListaCheiaExcecao("Lista Estática está Cheia!");

        if(indice <= 0){
            inserir(valor);
        }else if(indice >= tamanho){
            adicionar(valor);
        }else{
            for(int i = tamanho; i > indice; i--){
                elementos[i] = elementos[i-1];
            }
            elementos[indice] = valor;
            tamanho++;
        }
    }

    /**
     * Retorna true se esta lista estiver cheia.
     * @return true se esta lista estiver cheia
     */
    public boolean estaCheia(){
        return tamanho == TAMANHO_MAXIMO;
    }

    /**
     * Retorna true se esta lista não contiver elementos.
     * @return true se esta lista não contiver elementos
     */
    @Override
    public boolean estaVazia() {        
        return tamanho == 0;
    }

    /**
     * Verifica se o índice fornecido está dentro dos limites válidos da lista.
     * @param indice o índice a ser verificado
     * @throws IndexOutOfBoundsException se o índice estiver fora do intervalo (indice < 0 || indice >= tamanho())
     */
    protected void verificarIndice(int indice){
        if(indice < 0 || indice >= tamanho) throw new IndexOutOfBoundsException("Os índices disponíveis são [0 ~ "+(tamanho-1)+"]");
    }

    /**
     * Remove e retorna o elemento na posição especificada nesta lista.
     * Desloca quaisquer elementos subsequentes para a esquerda.
     * @param indice o índice do elemento a ser removido
     * @return o elemento que foi removido da lista
     * @throws ListaVaziaExcecao se esta lista estiver vazia
     * @throws IndexOutOfBoundsException se o índice estiver fora do intervalo (indice < 0 || indice >= tamanho())
     */
    @Override
    public E removerPorIndice(int indice) throws ListaVaziaExcecao, IndexOutOfBoundsException {
        if(estaVazia()) throw new ListaVaziaExcecao("Lista Estática está Vazia!");
        verificarIndice(indice);
        E valor = elementos[indice];
        tamanho--;
        for(int i = indice; i < tamanho; i++) {
            elementos[i] = elementos[i+1];
        }
        elementos[tamanho] = null; // Limpa o último elemento para coleta de lixo
        return valor;        
    }
    
    /**
     * Remove e retorna o primeiro elemento desta lista.
     * @return o primeiro elemento desta lista
     * @throws ListaVaziaExcecao se esta lista estiver vazia
     */
    @Override
    public E removerPrimeiro() throws ListaVaziaExcecao {
        if(estaVazia()) throw new ListaVaziaExcecao("Lista Estática está Vazia!");
        return removerPorIndice(0);
    }
    
    /**
     * Remove e retorna o último elemento desta lista.
     * @return o último elemento desta lista
     * @throws ListaVaziaExcecao se esta lista estiver vazia
     */
    @Override
    public E removerUltimo() throws ListaVaziaExcecao {
        if(estaVazia()) throw new ListaVaziaExcecao("Lista Estática está Vazia!");
        E valor = elementos[--tamanho];
        elementos[tamanho] = null; // Limpa o elemento para coleta de lixo
        return valor;
    }

    /**
     * Remove a primeira ocorrência do elemento especificado desta lista, se estiver presente.
     * @param valor o elemento a ser removido desta lista, se presente
     * @return true se esta lista continha o elemento especificado
     * @throws ListaVaziaExcecao se esta lista estiver vazia
     */
    @Override
    public boolean remover(E valor) throws ListaVaziaExcecao {
        if(estaVazia()) throw new ListaVaziaExcecao("Lista Estática está Vazia!");
        int indice = indiceDe(valor);
        if (indice != -1) {
            removerPorIndice(indice);
            return true;
        }
        return false;
    }
    
    /**
     * Substitui o elemento na posição especificada nesta lista pelo elemento especificado.
     * @param indice o índice do elemento a ser substituído
     * @param valor o elemento a ser armazenado na posição especificada
     * @throws ListaVaziaExcecao se esta lista estiver vazia
     * @throws IndexOutOfBoundsException se o índice estiver fora do intervalo (indice < 0 || indice >= tamanho())
     */
    @Override
    public void definir(int indice, E valor) throws ListaVaziaExcecao {
        if(estaVazia()) throw new ListaVaziaExcecao("Lista Estática está Vazia!");
        verificarIndice(indice);
        elementos[indice] = valor;
        
    }

    /**
     * Retorna o número de elementos nesta lista.
     * @return o número de elementos nesta lista
     */
    @Override
    public int tamanho() {        
        return tamanho;
    }

    /**
     * Retorna o índice da primeira ocorrência do elemento especificado nesta lista,
     * ou -1 se esta lista não contiver o elemento.
     * @param valor o elemento a ser pesquisado
     * @return o índice da primeira ocorrência do elemento especificado nesta lista,
     *         ou -1 se esta lista não contiver o elemento
     * @throws ListaVaziaExcecao se esta lista estiver vazia
     */
    @Override
    public int indiceDe(E valor) throws ListaVaziaExcecao {
        if(estaVazia()) throw new ListaVaziaExcecao("Lista Estática está Vazia!");
        for (int i = 0; i < tamanho; i++) {
            if (valor == null) {
                if (elementos[i] == null) return i;
            } else {
                if (valor.equals(elementos[i])) return i;
            }
        }
        return -1;
    }

    /**
     * Retorna um novo array contendo uma cópia dos elementos desta lista,
     * na ordem em que aparecem.
     * @return um novo array contendo todos os elementos da lista
     */
    @SuppressWarnings("unchecked")
    public E[] copiarArray() {
        E[] copia = (E[]) new Object[tamanho];
        for (int i = 0; i < tamanho; i++) {
            copia[i] = elementos[i];
        }
        return copia;
    }

    /**
     * Retorna um array contendo todos os elementos desta lista na sequência correta.
     * Implementação própria utilizando {@link #copiarArray()}.
     * @return um array contendo todos os elementos desta lista na sequência correta
     */
    @Override
    public E[] paraArray() {
        return copiarArray();
    }

    /**
     * Adiciona todos os elementos da lista especificada ao final desta lista.
     * @param outraLista a lista cujos elementos devem ser adicionados a esta lista
     */
    @Override
    public void adicionarTodos(colecoes.Lista<E> outraLista) {
        for (int i = 0; i < outraLista.tamanho(); i++) {
            try {
                adicionar(outraLista.obter(i));
            } catch (ListaCheiaExcecao | ListaVaziaExcecao e) {
                // Lidar ou relançar se necessário, por enquanto, parar de adicionar se estiver cheia
                break;
            }
        }
    }

    /**
     * Ordena esta lista de acordo com o ordem induzida pelo comparador especificado.
     * @param comparador o {@code Comparator} usado para comparar elementos da lista
     */
    @Override
    public void ordenar(Comparator<E> comparador) {
        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = 0; j < tamanho - 1 - i; j++) {
                if (comparador.compare(elementos[j], elementos[j + 1]) > 0) {
                    E temp = elementos[j];
                    elementos[j] = elementos[j + 1];
                    elementos[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Retorna uma representação em string desta lista.
     * @return uma representação em string desta lista
     */
    @Override
    public String toString() {
        StringBuilder dadosLista = new StringBuilder("[");

        for(int i = 0; i < tamanho; i++){
            dadosLista.append(elementos[i]);

            if(i < tamanho -1){
                dadosLista.append(", ");
            }
        }

        return dadosLista.append("]").toString();
    }

}