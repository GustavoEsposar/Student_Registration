
/**
 * Interface das funções utilizadas para armazenamento externo dos dados 
 * criados em execução.
 * 
 *  @authors Gustavo Barbieri Esposar RA00297810
 *          Caio de Nasi Sclavi      RA00301504
 * @version 1.0 03/06/2022 09h10
 */

public interface IStorage
{
    public void limparCadastro();       

    public String getNomeAluno(int x);

    public int getIdadeAluno(int x);

    public String getRaAluno(int x);

    public String getCursoAluno(int x);

    public float getNotaAluno(int x);

    public int getTamanho();

    public String getAluno(int x);

    public boolean inserir(String nome, int idade, String ra, String curso, float nota);

    public boolean remover(String ra);

    public String listar();

    public void limpa(int qtd);
}