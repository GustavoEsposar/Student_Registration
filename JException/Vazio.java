package JException; 
/**
 * Escreva uma descrição da classe Excecoes aqui.
 * 
 * @author Gustavo Barbieri Esposar RA00297810
 *          Caio de Nasi Sclavi      RA00301504
 * @version 31/03/2022 08h10
 */

public class Vazio extends Exception{
    public Vazio(){
          super("Excessao");
    }

    public Vazio(String msg){
          super(msg);
    }
}
