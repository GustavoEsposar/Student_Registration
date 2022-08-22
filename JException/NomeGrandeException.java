package JException; 
/**
 * Escreva uma descrição da classe Excecoes aqui.
 * 
 * @author Gustavo Barbieri Esposar RA00297810
 *          Caio de Nasi Sclavi      RA00301504
 * @version 31/03/2022 08h10
 */

public class NomeGrandeException extends Exception{
    public NomeGrandeException(){
          super("Excessao");
    }

    public NomeGrandeException(String msg){
          super(msg);
    }
}