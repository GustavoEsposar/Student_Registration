 

/**
 * No da lista
 * @author Julio Arakaki
 * @version 17/05/2021
 */

public class No implements java.io.Serializable
{
    // Atributos
    Object conteudo; // conteudo
    No proximo; // proximo
    
    long id;

    /**
     * Constroi um no da lista ligada
     * @param Object conteudo do no
     */
    public No(Object conteudo){
        setConteudo(conteudo);
        setProximo(null);
        setId(0);
    }
    public No(Object conteudo, long id){
        setConteudo(conteudo);
        setProximo(null);
        setId(id);
    }
    // setters e getters
    /**
     * Metodo setConteudo
     *
     * @param conteudo conteudo do no
     */
    public void setConteudo(Object conteudo){
        this.conteudo = conteudo;
    }
    
    public void setId(long id){
        this.id = id;
    }
    
    public long getId(){
        return (this.id);
    }
    
    
    /**
     * Metodo setProximo
     *
     * @param proximo referencia para o proximo no
     */
    public void setProximo(No proximo){
        this.proximo = proximo;
    }
    /**
     * Metodo getConteudo
     *
     * @return Object conteudo do no
     */
    public Object getConteudo(){
        return(this.conteudo);
    }   
    
    /**
     * Metodo getProximo
     *
     * @return NO referencia do proximo no
     */
    public No getProximo(){
        return(this.proximo);
    }
    /**
     * Metodo toString
     *
     * @return String conteudo do no como string
     */
    public String toString(){
        return("\n\nid: " + getId() + " "+ getConteudo().toString());
         //return("\n" + getConteudo().toString());
    }
}
