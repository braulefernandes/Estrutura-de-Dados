package colecoes.ListaEncadeada;

import excecoes.ListaVaziaExcecao;

import java.util.Comparator;

/**
 * Implementação de uma lista simplesmente encadeada que estende {@link ListaDinamica}.
 * Cada elemento (nó) nesta lista contém uma referência para o próximo elemento na sequência.
 * @param <E> o tipo de elementos que esta lista irá conter
 */
public class ListaEncadeada<E> extends ListaDinamica<E>{

    /**
     * Adiciona o elemento especificado ao final desta lista.
     * @param valor o elemento a ser adicionado
     */
    @Override
    public void adicionar(E valor) {
        No novoNo = new No(valor);
        if(estaVazia()){
            cabeca = novoNo;            
        }else{
            cauda.proximo = novoNo;
        }
        cauda = novoNo;
        tamanho++;
        
    }
    
    /**
     * Retorna true se esta lista contiver o elemento especificado.
     * @param valor o elemento cuja presença nesta lista deve ser testada
     * @return true se esta lista contiver o elemento especificado
     * @throws ListaVaziaExcecao se esta lista estiver vazia
     */
    @Override
    public boolean contem(E valor) throws ListaVaziaExcecao {
        if(estaVazia()) throw new ListaVaziaExcecao("Lista Encadeada está Vazia!");
        return indiceDe(valor) != -1;
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
        if(estaVazia()) throw new ListaVaziaExcecao("Lista Encadeada está Vazia!");
        verificarIndice(indice);
        return obterNo(indice).valor;
    }
    
    /**
     * Insere o elemento especificado no início desta lista.
     * @param valor o elemento a ser inserido
     */
    @Override
    public void inserir(E valor) {
        No novoNo = new No(valor);
        if(estaVazia()){
            cauda = novoNo;        
        }else{
            novoNo.proximo = cabeca;
        }
        cabeca = novoNo;
        tamanho++;
    }
    
    /**
     * Insere o elemento especificado na posição especificada nesta lista.
     * Desloca o elemento atualmente nessa posição (se houver) e quaisquer elementos subsequentes para a direita.
     * @param indice o índice no qual o elemento especificado deve ser inserido
     * @param valor o elemento a ser inserido
     * @throws IndexOutOfBoundsException se o índice estiver fora do intervalo (indice < 0 || indice > tamanho())
     */
    @Override
    public void inserir(int indice, E valor) {
        if(indice<=0){
            inserir(valor);
        }else if(indice >= tamanho){
            adicionar(valor);
        }else{
            No novoNo = new No(valor);
            No noAuxiliar = obterNo(indice-1);
            novoNo.proximo = noAuxiliar.proximo;
            noAuxiliar.proximo = novoNo;
            tamanho++;
        }
        
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
        verificarIndice(indice);
        E valor = null;
        if(indice == 0){
            valor = removerPrimeiro();
        }else if(indice == tamanho-1){
            valor = removerUltimo();
        }else{
            No noAuxiliar = obterNo(indice-1);
            valor = noAuxiliar.proximo.valor;
            noAuxiliar.proximo = noAuxiliar.proximo.proximo;
            tamanho--;
        }

        return valor;
    }
    
    /**
     * Remove e retorna o primeiro elemento desta lista.
     * @return o primeiro elemento desta lista
     * @throws ListaVaziaExcecao se esta lista estiver vazia
     */
    @Override
    public E removerPrimeiro() throws ListaVaziaExcecao {
        if(estaVazia()) throw new ListaVaziaExcecao("Lista Encadeada está Vazia!");
        E valor = cabeca.valor;
        if(tamanho==1){            
            cauda = null;
        }        
        cabeca = cabeca.proximo;
        tamanho--;
        
        return valor;
    }
    
    /**
     * Remove e retorna o último elemento desta lista.
     * @return o último elemento desta lista
     * @throws ListaVaziaExcecao se esta lista estiver vazia
     */
    @Override
    public E removerUltimo() throws ListaVaziaExcecao {
        if(estaVazia()) throw new ListaVaziaExcecao("Lista Encadeada está Vazia!");
        E valor = cauda.valor;
        if(tamanho==1){
            cabeca = null;
            cauda = null;
        }else{
            No noAuxiliar = obterNo(tamanho-2);
            cauda = noAuxiliar;
            noAuxiliar.proximo = null;
        }
        tamanho--;
        
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
        if(estaVazia()) throw new ListaVaziaExcecao("Lista Encadeada está Vazia!");
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
        if(estaVazia()) throw new ListaVaziaExcecao("Lista Encadeada está Vazia!");
        verificarIndice(indice);
        obterNo(indice).valor = valor;
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
        if(estaVazia()) throw new ListaVaziaExcecao("Lista Encadeada está Vazia!");
        No atual = cabeca;
        for (int i = 0; i < tamanho; i++) {
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
     * Retorna um array contendo todos os elementos desta lista na sequência correta.
     * @return um array contendo todos os elementos desta lista na sequência correta
     */
    @Override
    @SuppressWarnings("unchecked")
    public E[] paraArray() {
        E[] array = (E[]) new Object[tamanho];
        No atual = cabeca;
        for (int i = 0; i < tamanho; i++) {
            array[i] = atual.valor;
            atual = atual.proximo;
        }
        return array;
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
            } catch (ListaVaziaExcecao e) {
                // Não deve acontecer se outraLista.tamanho() estiver correto
            }
        }
    }

    /**
     * Ordena esta lista de acordo com o ordem induzida pelo comparador especificado.
     * @param comparador o {@code Comparator} usado para comparar elementos da lista
     */
    @Override
    public void ordenar(Comparator<E> comparador) {
        if (estaVazia()) return;

        // Copia os elementos para um array local
        E[] array = paraArray();

        // Ordena manualmente usando Bubble Sort
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (comparador.compare(array[j], array[j + 1]) > 0) {
                    E temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        // Limpa a lista e insere novamente os elementos ordenados
        limpar();
        for (E elemento : array) {
            adicionar(elemento);
        }
    }

    /**
     * Retorna o nó na posição especificada nesta lista.
     * Este método é específico para listas simplesmente encadeadas.
     * @param indice o índice do nó a ser retornado
     * @return o nó na posição especificada
     */
    @Override
    protected No obterNo(int indice){
        No noAuxiliar = cabeca;
        for(int i = 0; i < indice; i++){
            noAuxiliar = noAuxiliar.proximo;
        }
        return noAuxiliar;
    }

}