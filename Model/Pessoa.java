package Model;
/**
 * Representa uma pessoa.
 * 
 * @author Julio Arakaki
 * @version 0.1 24/03/2022
 */
public class Pessoa implements java.io.Serializable {
    // Atributos
    NomePessoa nome;
    int idade;
    
    // Construtor
    Pessoa (String nome, int idade){
        setNome(nome);
        setIdade(idade);
    }
    // setters
    public void setNome(String nome){
        this.nome = new NomePessoa(nome);
    }
    
    public void setIdade(int idade){
        this.idade = idade;
    }
    //getters
        public NomePessoa getNome(){
        return this.nome;
    }
    
    public int getIdade(){
        return this.idade;
    }

    public String getNomeInvertido(){
        return getNome().getNomeInvertido();
    }
    //funções
    public String getNomeBiblio(){ //Utilizado para transformar o nome em nome bibliografico (puxado de outra classe)
        return getNome().getNomeBiblio();
    }
        
    public String toString(){ //Utilizado para printar todas as informações ao juntas
        return "Nome: " + getNome() + "\nIdade: " + getIdade();
    }
    
}
