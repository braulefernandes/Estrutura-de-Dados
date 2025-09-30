package colecoes.ArvoreBinariaBuscaRecursiva;

import colecoes.ArvoreBinariaAbstrata;
/**
 * Implementação de uma Árvore Binária de Busca (BST) recursiva que estende {@link ArvoreBinariaAbstrata}.
 * Esta classe fornece métodos recursivos para inserção, remoção e percorrimento de elementos na árvore.
 * @param <E> o tipo de elementos que esta árvore binária de busca recursiva irá conter
 */
public class ArvoreBinariaBuscaRecursiva<E> extends ArvoreBinariaAbstrata<E> {

    /**
     * Remove o elemento especificado da árvore.
     * @param valor o elemento a ser removido
     * @return o elemento removido, ou null se não encontrado
     */
    @Override
    public E remover(E valor) {
        int tamanhoAux = tamanho;
        raiz = remover(raiz, valor);
        if(tamanhoAux != tamanho){
            return valor;
        }
        return null;
    }

    /**
     * Encontra o nó com o menor valor na subárvore especificada.
     * @param atual o nó raiz da subárvore a ser pesquisada
     * @return o nó com o menor valor na subárvore
     */
    private No noMinimo(No atual){
        if(atual.esquerda == null){
            return atual;
        }
        return noMinimo(atual.esquerda);
    }

    /**
     * Método recursivo para remover um elemento da árvore.
     * @param atual o nó atual sendo processado
     * @param valor o elemento a ser removido
     * @return o nó atual após a remoção
     */
    private No remover(No atual, E valor){
        if(atual == null){
            return null;
        }

        if(comparar(valor, atual)==0){
            //achei!!
            if(atual.esquerda == null && atual.direita == null){
                atual = null;
                tamanho--;
            }else if(atual.esquerda != null && atual.direita != null){
                atual.valor = noMinimo(atual.direita).valor;
                atual.direita = remover(atual.direita, atual.valor);
            }else{
                tamanho--;
                atual = atual.esquerda!=null ? atual.esquerda : atual.direita;
            }
        }else{
            if(comparar(valor, atual)<0){
                atual.esquerda = remover(atual.esquerda, valor);
            }else{
                atual.direita = remover(atual.direita, valor);
            }
        }
        return atual;
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
     * Método recursivo para inserir um elemento na árvore.
     * @param atual o nó atual sendo processado
     * @param valor o elemento a ser inserido
     * @return o nó atual após a inserção
     */
    private No inserir(No atual, E valor){
        if(atual==null){
            tamanho++;
            return new No(valor);
        }
        if(comparar(valor, atual)<0){
            atual.esquerda = inserir(atual.esquerda, valor);
            
        }else if(comparar(valor, atual)>0){
            atual.direita = inserir(atual.direita, valor);
        }        
        return atual;
    }

    /**
     * Insere o elemento especificado na árvore.
     * @param valor o elemento a ser inserido
     */
    @Override
    public void inserir(E valor) {
        raiz = inserir(raiz, valor);        
    }

    /**
     * Realiza um percorrimento em pré-ordem na árvore.
     * @param dadosArvore a string acumuladora dos dados da árvore
     * @param atual o nó atual sendo processado
     * @return a string com os dados da árvore em pré-ordem
     */
    private String preOrdem(String dadosArvore, No atual){
        if(atual!=null){
            dadosArvore += atual.valor + " ";
            dadosArvore = preOrdem(dadosArvore, atual.esquerda);
            dadosArvore = preOrdem(dadosArvore, atual.direita);
        }
        return dadosArvore;
    }

    /**
     * Realiza um percorrimento em ordem na árvore.
     * @param dadosArvore a string acumuladora dos dados da árvore
     * @param atual o nó atual sendo processado
     * @return a string com os dados da árvore em ordem
     */
    private String emOrdem(String dadosArvore, No atual){
        if(atual!=null){
            dadosArvore = emOrdem(dadosArvore, atual.esquerda);
            dadosArvore += atual.valor + " ";
            dadosArvore = emOrdem(dadosArvore, atual.direita);
        }
        return dadosArvore;
    }

    /**
     * Realiza um percorrimento em pós-ordem na árvore.
     * @param dadosArvore a string acumuladora dos dados da árvore
     * @param atual o nó atual sendo processado
     * @return a string com os dados da árvore em pós-ordem
     */
    private String posOrdem(String dadosArvore, No atual){
        if(atual!=null){
            dadosArvore = posOrdem(dadosArvore, atual.esquerda);
            dadosArvore = posOrdem(dadosArvore, atual.direita);
            dadosArvore += atual.valor + " ";
        }
        return dadosArvore;
    }

    /**
     * Realiza um percorrimento na árvore e retorna uma string com os elementos.
     * @param tipo o tipo de percorrimento (ex: "bfs", "inOrder", "preOrder", "postOrder")
     * @return uma string contendo os elementos da árvore no tipo de percorrimento especificado
     */
    @Override
    public String percorrerArvore(String tipo) {
        if(tipo.equals("bfs")){
            //pensem muito!!!
        }else{
            if(tipo.equals("preOrdem")){
                return preOrdem("",raiz);
            }else if(tipo.equals("emOrdem")){
                return emOrdem("",raiz);
                
            }else{
                return posOrdem("",raiz);

            }
        }
        return null;
    }

}