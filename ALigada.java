import Model.Aluno;
/**
 * Escreva uma descrição da classe ArmazenadorListaLigada aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class ALigada implements IStorage, java.io.Serializable
{
    ListaLigada lista = new ListaLigada();
    private int tamanho;
    public void limparCadastro(){
        lista.setQtdNos(0);
    }
    //getters
    /**Retorna o nome do aluno na posição X (verificando se a posição é valida)*/
    public String getNomeAluno(int x){
        x = x - 1;
        No aux = lista.inicio;
        tamanho = lista.getQtdNos();

        if(x + 1 > tamanho || x + 1 < 1){
            return "-1";
        }else{
            for(int i = 0; i < x; i++){
                aux = aux.getProximo();
            }

            Aluno a = (Aluno) aux.getConteudo();
            return a.getNome().toString();
        }
    }

    /**Retorna a idade do objeto aluno na posição X (verificando se a posição é valida)*/
    public int getIdadeAluno(int x){
        x = x - 1;
        No aux = lista.inicio;
        Aluno saida;
        tamanho = lista.getQtdNos();

        if(x + 1 > tamanho || x + 1 < 1){
            return -1;
        }
        else{
            for(int i = 0; i < x; i++){
                aux = aux.getProximo();
            }

            saida = (Aluno) aux.getConteudo();
            return saida.getIdade(); 
        }
    }

    /**Retorna o RA do aluno na posição X (verificando se a posição é valida)*/
    public String getRaAluno(int x){
        x = x - 1;
        No aux = lista.inicio;
        Aluno saida;
        tamanho = lista.getQtdNos();

        if(x + 1 > tamanho || x + 1 < 1){
            return "-1";
        }else{
            for(int i = 0; i < x; i++){
                aux = aux.getProximo();
            }

            saida = (Aluno) aux.getConteudo();
            return saida.getRA();
        }
    }

    /**Retorna o curso do aluno na posição X (verificando se a posição é valida)*/
    public String getCursoAluno(int x){
        x = x - 1;
        No aux = lista.inicio;
        Aluno saida;
        tamanho = lista.getQtdNos();

        if(x + 1 > tamanho || x + 1 < 1){
            return "-1";
        }else{
            for(int i = 0; i < x; i++){
                aux = aux.getProximo();
            }

            saida = (Aluno) aux.getConteudo();
            return saida.getCurso();
        }
    }

    /**Retorna a nota do aluno na posição X (verificando se a posição é valida)*/
    public float getNotaAluno(int x){
        x = x - 1;
        No aux = lista.inicio;
        Aluno saida;
        tamanho = lista.getQtdNos(); 

        if(x + 1 > tamanho || x + 1 < 1){
            return -1;
        }else{
            for(int i = 0; i < x; i++){
                aux = aux.getProximo();
            }

            saida = (Aluno) aux.getConteudo();
            return saida.getNota();
        }
    }

    /**Retorna o tamanho/quantidade de alunos cadastrados o vetor*/
    public int getTamanho(){
        tamanho = lista.getQtdNos();
        return tamanho;
    }

    /**Retorna os dados do Objeto Aluno na posição x (verificando se a posição é valida)
    utilizando o método toString();
     */
    public String getAluno(int x){
        x = x - 1;
        No aux = lista.inicio;
        Aluno saida;
        tamanho = lista.getQtdNos();

        if(x + 1 > tamanho || x + 1 < 1){
            return "-1";
        }else{
            for(int i = 0; i < x; i++){
                aux = aux.getProximo();
            }

            saida = (Aluno) aux.getConteudo();
            return saida.toString();
        }
    }

    //métodos
    /** Inserir é utilizado para inserção de um novo aluno no vetor Alunos, criando uma nova instancia da classe Aluno */
    public boolean inserir(String nome, int idade, String ra, String curso, float nota){
        lista.inserirFim(new Aluno(nome, idade, ra, curso, nota));
        return true;
    }

    /** Remover é utilizado para, por meio do ra, remover um aluno do vetor e abrir o espaço vazio */
    public boolean remover(String ra){
        Aluno aluno;
        No aux;
        aux = lista.inicio;
        aluno = (Aluno) aux.getConteudo();
        String _ra = aluno.getRA();

        int contador = 1;
        tamanho = lista.getQtdNos();

        while(!(_ra.equals(ra)) && contador <= tamanho){
            aux = aux.getProximo();
            aluno = (Aluno) aux.getConteudo();
            _ra = aluno.getRA();
            contador++;
        }
        long id = aux.getId();
        lista.remover(id);
        return true;
    }

    /** Listar é utilizado para listar todos os alunos ja adicionados ao vetor alunos, mostrando todas suas informações  */
    public String listar(){
        String resp = "";
        tamanho = lista.getQtdNos();
        for(int i = 0; i < tamanho; i++){ //Cria uma lista com todos os alunos
            resp += ("" + (i + 1) + " - " + getNomeAluno(i) + "\n");
        }
        return resp;
    }

    /** Limpa é utilizado para limpar todo o vetor, definindo todos os campos de um vetor como null na criação */
    public void limpa(int qtd){ 
        No aux;
        Aluno aluno;
        aux = lista.inicio;
        tamanho = lista.getQtdNos();
        for(int i = 0; i < tamanho; i++){ //Cria uma lista com todos os alunos
            lista.removerFim();
        }
    }
}
