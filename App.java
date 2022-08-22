/**
 * Aplicação completa;
 * 
 * @authors Gustavo Barbieri Esposar RA00297810
 *          Caio de Nasi Sclavi      RA00301504
 * @version 1.0 31/03/2022 08h10
 */
public class App
{
    final static int Max = 500;
    static EntradaS ent = new EntradaS();
    //static IEntrada ent = new EntradaC();
    //static IPersistencia per = new ArquivoTextoOut();
    static IPersistencia per = new ArquivoBinario();
    static IStorage cad = new ALigada();
    static int aux;
    public static void main()
    {
        menu();
    }

    public static void setCad(IStorage _cad){
        cad = _cad;    
    }
    
    public static void menu()
    {                                        //loop para chamar menu principal[
        aux = ent.criarMenu();
        ent.chamarJanela(aux, cad, per);
    }
    
    public static void ler(String arq){
        per.lerObj(cad, arq);
    }
}
