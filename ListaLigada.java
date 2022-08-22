
import java.util.Random;

/**
 * Implementa Lista Ligada simples.
 * 
 * @author Julio Arakaki
 * @version 18/05/2021
 */
public class ListaLigada implements java.io.Serializable
{
    // Atributos
    No inicio,  // Ponteiro para o inicio
    fim;     // Ponteiro para o fim

    int qtdNos; // Quantidade de nos
    private Random r = new Random(System.currentTimeMillis());

    /**
     * ListaLigadaSimples Construtor
     *
     * Inicia uma lista ligada simples. Inicia ponteiros e contador de nos.
     * 
     */
    public ListaLigada(){
        setInicio(null);
        setFim(null);
        setQtdNos(0);
    }

    /**
     * Metodo setInicio
     *
     * @param inicio no inicial
     */
    private void setInicio(No inicio){
        this.inicio = inicio;
    }

    /**
     * Metodo getInicio
     *
     * @return No no inicial
     */
    public No getInicio(){
        return(this.inicio);
    }

    /**
     * Metodo getFim
     *
     * @return No no final
     */
    public No getFim(){
        return(this.fim);
    }

    /**
     * Metodo setFim
     *
     * @param fim no final
     */
    private void setFim(No fim){
        this.fim = fim;
    }

    /**
     * Metodo getQtdNos
     *
     * @return qtidade de nos
     */
    public int getQtdNos(){
        return this.qtdNos;
    }

    /**
     * Metodo setQtdNos
     *
     * @param qtdNos atualiza qtde de nos
     */
    public void setQtdNos(int qtdNos){
        this.qtdNos = qtdNos;
    }

    /**
     * Metodo estaVazia
     *
     * @return true - lista vazia, false - lista nao vazia
     */
    public boolean estaVazia(){
        boolean ret = false; 
        if (getQtdNos() == 0 && getInicio() == null && getFim() == null){
            ret = true;
        }
        return ret;
    }

    /**
     * Metodo inserirInicio
     *
     * @param elem Objeto a ser inserido na lista
     */
    public void inserirInicio(Object elem) {
        No novo = new No(elem, r.nextLong()); // Cria um no com o objeto a ser inserido

        if (estaVazia()){ // Se a lista estiver vazia
            setInicio(novo);
            setFim(novo);
        } else{ // A lista nï¿½o esta vazia
            novo.setProximo(inicio);
            setInicio(novo);
        }

        // Incrementa quantidade de nos
        setQtdNos(getQtdNos() + 1);
    }

    /**
     * Metodo inserirFim
     *
     * @param elem Objeto a ser inserido na lista
     */
    public void inserirFim(Object elem){
        No novo = new No(elem, r.nextLong());// Cria um no com o objeto a ser inserido

        // Se a lista estiver vazia
        if (estaVazia()){
            setInicio(novo);
            setFim(novo);
        } else{ // Alista nao esta vazia
            getFim().setProximo(novo);
            setFim(novo);
        }

        // Incrementa quantidade de nos
        setQtdNos(getQtdNos() + 1);
    }

    /**
     * Metodo removerInicio
     *
     * @return Object objeto a ser removido
     */
    public Object removerInicio(){
        No aux = null;
        Object obj = null; 

        if(!estaVazia()){ 
            if ((getInicio() == getFim())){ // Se existir apenas um no
                aux = getInicio();
                setInicio(null);
                setFim(null);
            } else { // Existe mais de um no
                aux = getInicio();
                setInicio(aux.getProximo());
                aux.setProximo(null);
            }

            // Decrementa qtidade de nos
            setQtdNos(getQtdNos() - 1);
            obj = aux.getConteudo(); // pega conteudo do no removido
        }

        return(obj); // retorna o conteudo removido
    }

    /**
     * Metodo removerFim
     *
     * @return Object objeto a ser removido
     */
    public Object removerFim(){
        No ant = getInicio();
        No aux = null;
        Object obj = null; 

        if (!estaVazia()){
            if ((getInicio() == getFim())){ // Se existir apenas um no
                aux = getInicio();
                setInicio(null);
                setFim(null);
            } else { // Existe mais de um no           
                // percorre ate achar o no antes do fim
                while(ant.getProximo() != fim){
                    ant = ant.getProximo();
                }
                ant.setProximo(null); // desliga o no a ser removido
                aux = fim; // guarda no a ser removido
                setFim(ant); // atualiza ponteiro fim
            }

            // Decrementa qtidade de nos
            setQtdNos(getQtdNos() - 1);
            obj = aux.getConteudo(); // pega conteudo do no removido          
        }
        return obj;
    }

    public Object remover (long id){
        No ret = null, temp = null, ant = null;
        if (!estaVazia() ){
            if(getInicio().getId() == id) {
                ret = getInicio();
                removerInicio();
            } else if(getFim().getId() == id){
                ret = getFim();
                removerFim();
            } else {
                ant = getInicio();
                temp = getInicio().getProximo();
                while (temp != null){ // percorre toda a lista
                    if (temp.getId() == id){ // Achou o elemento a ser removido
                        ret = temp;
                        ant.setProximo(temp.getProximo());
                        temp.setProximo(null);
                        // Decrementa qtidade de nos
                        setQtdNos(getQtdNos() - 1);
                        break;
                    }
                    ant = temp;
                    temp = temp.getProximo();
                }
            }
        }
        return ret.getConteudo();
    }

    /**
     * Metodo toString
     *
     * @return String todos os nos da lista
     * 
     */
    public String toString(){
        No temp = getInicio();
        String valores = "[ ";
        if (!estaVazia() ){
            while (temp != null){ // percorre toda a lista
                valores += temp + " ";
                temp = temp.getProximo();
            }
        }
        valores = valores + "\n]";
        return valores;
    }
}