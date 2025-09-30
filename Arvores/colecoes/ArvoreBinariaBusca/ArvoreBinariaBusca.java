package colecoes.ArvoreBinariaBusca;

import colecoes.ArvoreBinariaAbstrata;
import colecoes.FilaDinamica;

/**
 * Implementação de uma Árvore Binária de Busca (BST) que estende {@link ArvoreBinariaAbstrata}.
 * Esta árvore mantém seus elementos em ordem, permitindo busca, inserção e remoção eficientes.
 * Os elementos são organizados de forma que, para qualquer nó, todos os elementos na subárvore esquerda
 * são menores que o nó, e todos os elementos na subárvore direita são maiores.
 * @param <E> o tipo de elementos que esta árvore binária de busca irá conter
 */
public class ArvoreBinariaBusca<E> extends ArvoreBinariaAbstrata<E> {

    /**
     * Remove o nó com o menor valor na subárvore direita de um determinado pai.
     * Este método é auxiliar para a operação de remoção de um nó com dois filhos.
     * @param pai o nó pai da subárvore onde o menor valor será procurado e removido
     * @return o valor do nó mínimo removido
     */
    private E removerNoMinimoDireita(No pai){
        No minimoAlvo = pai.direita;
        while (minimoAlvo.esquerda!=null) {
            pai = minimoAlvo;
            minimoAlvo = minimoAlvo.esquerda;
        }
        if(pai.direita == minimoAlvo){
            pai.direita = minimoAlvo.direita;
        }else{
            pai.esquerda = minimoAlvo.direita;
        }
        return minimoAlvo.valor;
    }

    /**
     * Remove o elemento especificado da árvore.
     * @param valor o elemento a ser removido
     * @return o elemento removido, ou null se não encontrado
     * @throws RuntimeException se a árvore estiver vazia
     */
    @Override
    public E remover(E valor) {
        if(estaVazia()) throw new RuntimeException("Árvore está vazia!");
        No alvo = raiz, pai = null;
        while(alvo!=null && comparar(valor, alvo)!=0){
            pai = alvo;
            if(comparar(valor, alvo)<0){
                alvo = alvo.esquerda;
            }else{
                alvo = alvo.direita;
            }
        }
        if(alvo == null){
            return null;
        }
        E valorRemovido = alvo.valor;
        if(alvo.esquerda==null && alvo.direita==null){
            if(alvo == raiz){
                raiz = null;
            }else{
                if(pai.esquerda == alvo){
                    pai.esquerda = null;
                }else{
                    pai.direita = null;
                }
            }
        }else if(alvo.esquerda!=null && alvo.direita!=null){
            alvo.valor = removerNoMinimoDireita(alvo);
        }else{
            No filho = alvo.esquerda !=null? alvo.esquerda : alvo.direita;
            if(alvo == raiz){
                raiz = filho;
            }else{
                if(pai.esquerda == alvo){
                    pai.esquerda = filho;
                }else{
                    pai.direita = filho;
                }
            }
        }
        tamanho--;
        return valorRemovido;
    }

    /**
     * Busca e retorna o elemento especificado na árvore.
     * @param valor o elemento a ser buscado
     * @return o elemento encontrado, ou null se não encontrado
     */
    @Override
    public E buscar(E valor) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Insere o elemento especificado na árvore.
     * @param valor o elemento a ser inserido
     */
    @Override
    public void inserir(E valor) {
        No novoNo = new No(valor);
        if(estaVazia()){
            raiz = novoNo;
        }else{
            No noAuxiliar = raiz;
            while(noAuxiliar!=null){
                if(comparar(novoNo, noAuxiliar)<0){
                    if(noAuxiliar.esquerda == null){
                        noAuxiliar.esquerda = novoNo;
                        break;
                    }
                    noAuxiliar = noAuxiliar.esquerda;
                }else if(comparar(novoNo, noAuxiliar)>0){
                    if(noAuxiliar.direita == null){
                        noAuxiliar.direita = novoNo;
                        break;
                    }
                    noAuxiliar = noAuxiliar.direita;

                }else{
                    return;
                }
            }
        }
        tamanho++;        
    }

    /**
     * Realiza um percorrimento na árvore e retorna uma string com os elementos.
     * @param tipo o tipo de percorrimento (ex: "bfs", "inOrder", "preOrder", "postOrder")
     * @return uma string contendo os elementos da árvore no tipo de percorrimento especificado
     */
    @Override
    public String percorrerArvore(String tipo) {
        if(tipo.equals("bfs")){
            return buscaEmLargura();
        }else{
            if(tipo.equals("inOrder")){

            }else if(tipo.equals("preOrder")){

            }
        }
        return null;
    }

    /**
     * Realiza um percorrimento em largura (BFS) na árvore.
     * @return uma string contendo os elementos da árvore no percorrimento em largura
     */
    private String buscaEmLargura(){
        String dadosArvore = "";
        FilaDinamica<No> fila = new FilaDinamica<>();
        if(!estaVazia()){
            fila.enfileirar(raiz);
        }

        while (!fila.estaVazia()) {
            No noAuxiliar = fila.desenfileirar();
            dadosArvore += noAuxiliar;
            if(noAuxiliar.esquerda !=null){
                fila.enfileirar(noAuxiliar.esquerda);
            }
            if(noAuxiliar.direita !=null){
                fila.enfileirar(noAuxiliar.direita);

            }
            if(!fila.estaVazia()){
                dadosArvore += ", ";
            }
        }
        return dadosArvore;
    }

    /**
     * Retorna uma representação em string desta árvore, utilizando o percorrimento em largura.
     * @return uma representação em string desta árvore
     */
    @Override
    public String toString() {
        return buscaEmLargura();
    }

}