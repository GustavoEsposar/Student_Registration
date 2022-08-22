
/**
 * Escreva uma descrição da classe IPersistencia aqui.
 * 
 * @author Gustavo Barbieri Esposar RA00297810
 *          Caio de Nasi Sclavi      RA00301504
 * @version 10.0 24/05/2022
 */
public interface IPersistencia
{
    public void Salvar(IStorage x, String y);
    public void lerObj(IStorage x, String y);
    public String getExtencao();
}
