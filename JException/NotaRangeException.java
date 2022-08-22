package JException;

/**
 * Escreva uma descrição da classe NotaRangeException aqui.
 * 
 * @author Gustavo Barbieri Esposar RA00297810
 *          Caio de Nasi Sclavi      RA00301504 
 * @version 10.0 24/05/2022
 */
public class NotaRangeException extends Exception
{
    public NotaRangeException(){
        super("Nota deve ser um valor entre 0 e 10!");
    }

    public NotaRangeException(String msg){
        super(msg);
    }
}
