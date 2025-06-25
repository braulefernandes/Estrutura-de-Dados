package colecoes.ListaEstatica;

/**
 * Implementação de uma lista dinâmica (baseada em array) que estende {@link ListaEstatica}.
 * Esta lista automaticamente redimensiona seu array subjacente quando atinge a capacidade máxima,
 * permitindo que a lista cresça conforme a necessidade.
 * @param <E> o tipo de elementos que esta lista irá conter
 */
public class ListaDinamica<E> extends ListaEstatica<E> {

    /**
     * Constrói uma nova ListaDinamica com o tamanho máximo inicial especificado.
     * @param tamanhoMaximo o tamanho máximo inicial da lista
     */
    public ListaDinamica(int tamanhoMaximo){
        super(tamanhoMaximo);
    }

    /**
     * Recria o array subjacente com o dobro do tamanho atual, copiando os elementos existentes.
     */
    @SuppressWarnings("unchecked")
    private void recriarArray(){
        E[] novaLista = (E[]) new Object[elementos.length*2];
        for(int i = 0; i < tamanho; i++){
            novaLista[i] = elementos[i];
        }
        elementos = novaLista;
    }

    /**
     * Adiciona o elemento especificado ao final desta lista.
     * Se a lista estiver cheia, o array subjacente é redimensionado antes da adição.
     * @param valor o elemento a ser adicionado
     */
    @Override
    public void adicionar(E valor) {
        if(tamanho == elementos.length) recriarArray(); // Verifica a capacidade atual do array
        super.adicionar(valor);
    }

    /**
     * Insere o elemento especificado no início desta lista.
     * Se a lista estiver cheia, o array subjacente é redimensionado antes da inserção.
     * @param valor o elemento a ser inserido
     */
    @Override
    public void inserir(E valor) {
        if(tamanho == elementos.length) recriarArray();
        super.inserir(valor);
    }

    /**
     * Insere o elemento especificado na posição especificada nesta lista.
     * Se a lista estiver cheia, o array subjacente é redimensionado antes da inserção.
     * @param indice o índice no qual o elemento especificado deve ser inserido
     * @param valor o elemento a ser inserido
     */
    @Override
    public void inserir(int indice, E valor) {
        if(tamanho == elementos.length) recriarArray();
        super.inserir(indice, valor);
    }

    /**
     * Retorna true se esta lista estiver cheia.
     * Para ListaDinamica, a lista está cheia quando o número de elementos
     * atinge o comprimento do array subjacente.
     * @return true se esta lista estiver cheia
     */
    @Override
    public boolean estaCheia(){
        return tamanho == elementos.length; // A lista está cheia quando o tamanho atinge o comprimento do array
    }

}