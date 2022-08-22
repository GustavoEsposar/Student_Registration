
/**
 * Onde as funções do view são chamadas;
 * 
 * @authors Gustavo Barbieri Esposar RA00297810
 *          Caio de Nasi Sclavi      RA00301504
 * @version 1.0 31/03/2022 08h10
 */
public interface IEntrada
{
    public String nomeAluno();
    public String idadeAluno();
    public String raAluno();
    public String cursoAluno();
    public String notaAluno();
    public int criarMenu();
    public String listarMenu(String resp);
    public void listarSelecao(String x);
    public void removerSucesso();
    public void Error(String x);
    public void chamarJanela(int aux, IStorage cad);
}