package JException;


/**
 * Classe Utilizada para chamar exceções;
 * 
 * @authors Gustavo Barbieri Esposar RA00297810
 *          Caio de Nasi Sclavi      RA00301504
 * @version 1.0 31/03/2022 08h10
 */
public class Chamar
{
    public static void nomeExcecao(String nome) throws NomeGrandeException{
        if(nome != null && nome.length() > 50){
            throw new NomeGrandeException("Limite de caracteres atingido");
       }
    }
    
    public static void stringVazia(String texto) throws Vazio{
        if(texto == null || texto.equals("")){
            throw new Vazio();
       }
    }
    
    public static void NotaInvalida(float _nota) throws NotaRangeException {
        if(_nota >10.0 || _nota <0.0){
            throw new NotaRangeException();
        }   
    }
    
    public static void TextoEhNumero(String texto, boolean ponto) throws TextoEhNumero{
        if(ponto){
            for(char a : texto.toCharArray()){ //Utilizado para float
                if((a < 48 || a > 57) && a != 46){
                    throw new TextoEhNumero();
                }
            }
        }else{
            for(char a : texto.toCharArray()){ //Utilizado quando não float
                if(a < 48 || a > 57){
                    throw new TextoEhNumero();
                }
            }
        }
    }
}
