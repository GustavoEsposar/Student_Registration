package Model;
/**
 * Criação do construtor Aluno com seus devidos setters e getters.
 * 
 * @authors Gustavo Barbieri Esposar RA00297810
 *          Caio de Nasi Sclavi      RA00301504
 * @version 1.0 25/03/2022 07h57
 */
public class Aluno extends Pessoa implements java.io.Serializable
{
    //atributos
    private String ra;
    private String curso;
    private float nota;

    //construtor
    public Aluno (String nome, int idade, String _ra, String _curso, float _nota){
        //aciona o construtor da classe´pai;
        super(nome, idade);
        setRa(_ra);
        setCurso(_curso);
        setNota(_nota);
    }

    //setters Pessoa
    public void setRa(String _ra){
        ra = _ra;
    }

    public void setCurso(String _curso){
        curso = _curso;
    }

    public void setNota(float _nota){
        nota = _nota;
    }

    //getters Pessoa
    public String getRA(){
        return ra;
    }

    public String getCurso(){
        return curso;
    }

    public float getNota(){
        return nota;
    }

    /** toString utilizado para printar todos os valores do aluno junto */
    public String toString(){
        return "Nome: " + super.getNome() + "\nIdade: " + super.getIdade() + "\nRA: " + getRA() + "\nCurso: " + getCurso() + "\nNota: " + getNota();
    }  
}