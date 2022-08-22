import Model.Aluno;
/**
 * 
 * 
 * @authors Gustavo Barbieri Esposar RA00297810
 *          Caio de Nasi Sclavi      RA00301504
 * @version 1.0 03/06/2022 09h10
 */

import javax.swing.JOptionPane;
public class Array implements java.io.Serializable, IStorage
{
    //Atributos

    private Aluno alunos[];
    private int tamanho;
    private int max;    
    //Construtor
    public Array(int qtd){
        this.alunos = new Aluno[qtd];
        this.tamanho = 0;
        this.max = qtd;
        limpa(qtd);
    }
    /**Esvazia o tamanho do array*/
    public void limparCadastro(){
        this.tamanho = 0;
    }
    //getters
    /**Retorna o nome do aluno na posição X (verificando se a posição é valida)*/
    public String getNomeAluno(int x){
        x = x - 1;
        if(x + 1 > tamanho || x + 1 < 1){
            return "-1";
        }else return alunos[x].getNome().toString();
    }
    /**Retorna a idade do objeto aluno na posição X (verificando se a posição é valida)*/
    public int getIdadeAluno(int x){
        x = x - 1;
        if(x + 1 > tamanho || x + 1 < 1){
            return -1;
        }else return alunos[x].getIdade();
    }
    /**Retorna o RA do aluno na posição X (verificando se a posição é valida)*/
    public String getRaAluno(int x){
        x = x - 1;
        if(x + 1 > tamanho || x + 1 < 1){
            return "-1";
        }else return alunos[x].getRA();
    }
    /**Retorna o curso do aluno na posição X (verificando se a posição é valida)*/
    public String getCursoAluno(int x){
        x = x - 1;
        if(x + 1 > tamanho || x + 1 < 1){
            return "-1";
        }else return alunos[x].getCurso();
    }
    /**Retorna a nota do aluno na posição X (verificando se a posição é valida)*/
    public float getNotaAluno(int x){
        x = x - 1;
        if(x + 1 > tamanho || x + 1 < 1){
            return -1;
        }else return alunos[x].getNota();
    }
    /**Retorna o tamanho/quantidade de alunos cadastrados o vetor*/
    public int getTamanho(){
        return this.tamanho;
    }
    /**Retorna os dados do Objeto Aluno na posição x (verificando se a posição é valida)
    utilizando o método toString();
       */
    public String getAluno(int x){
        x = x - 1;
        if(x + 1 > tamanho || x + 1 < 1){
            return "-1";
        }else return alunos[x].toString();
    }
    //métodos
    /** Inserir é utilizado para inserção de um novo aluno no vetor Alunos, criando uma nova instancia da classe Aluno */
    public boolean inserir(String nome, int idade, String ra, String curso, float nota){
        int i;
        for(i = 0 ;i < this.max; i++){
            if(alunos[i] == null){
                alunos[i] = new Aluno(nome, idade, ra, curso, nota);
                tamanho++;
                return true;
            }
        }
        return false;
    }

    /** Remover é utilizado para, por meio do ra, remover um aluno do vetor e abrir o espaço vazio */
    public boolean remover(String ra){
        String _ra = ra;
        int i = 0;
        // if(ra == null){
        // return false;
        // }
        while(i < tamanho && !alunos[i].getRA().equals(_ra)){ //Encontra o aluno com o ra fornecido
            i++;
        }

        if(i == tamanho){ //Retora false se aluno não encontrado
            return false;
        }
        else{
            alunos[i] = null; //Remove o aluno
            for(int j = i; j < tamanho; j++){ //Passa tudo para o lado
                alunos[j] = alunos[j+1];
            }
            tamanho--;
            return true;
        }
    }

    /** Listar é utilizado para listar todos os alunos ja adicionados ao vetor alunos, mostrando todas suas informações  */
    public String listar(){
        String resp = "";

        for(int i = 0; i < this.tamanho; i++){ //Cria uma lista com todos os alunos
            resp += ("" + (i + 1) + " - " + this.alunos[i].getNome() + "\n");
        }
        return resp;
    }

    /** Limpa é utilizado para limpar todo o vetor, definindo todos os campos de um vetor como null na criação */
    public void limpa(int qtd){
        int i;
        for(i = 0; i < qtd; i++){
            this.alunos[i] = null;
        }
    }

}