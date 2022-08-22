import java.io.*;
/**
 * Escreva uma descrição da classe ArquivoBinario aqui.
 * 
 * @author Gustavo Barbieri Esposar RA00297810
 *          Caio de Nasi Sclavi      RA00301504
 * @version 10.0 24/05/2022
 */
public class ArquivoBinario implements IPersistencia
{
    String ext = "cad";
    public void Salvar(IStorage cad, String arquivo){
        
        ObjectOutputStream output = null;
        try {
            File file = new File(arquivo + ".cad");
            output = new ObjectOutputStream(new FileOutputStream(file));
            output.writeObject((Object)cad);  // escreve o objeto no arquivo

        } catch(Exception e){
            System.out.println(e.toString());
        } finally {
            try {
                output.close();
            } catch(Exception ex) {
                // Nao faz nada!
            }
        }
    }
    
    public String getExtencao(){
        return ext;
    }
    
    public void lerObj(IStorage cad, String arquivo){
        ObjectInputStream input = null;
        try {
            File file = new File(arquivo);
            if(file.exists()){
                input = new ObjectInputStream(new FileInputStream(file));
                App.setCad((IStorage)input.readObject());  // le o objeto do arquivo
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        } finally {
            try {
                input.close();
            } catch(Exception ex) {
                // Nao faz nada!
            }
        }
    }
}
