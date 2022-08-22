import JException.*;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Escreva uma descrição da classe EntradaS aqui.
 * 
 * @author Gustavo Barbieri Esposar RA00297810
 *          Caio de Nasi Sclavi      RA00301504
 * @version 10.0 231/03/2022
 */
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class EntradaS
{
    public int criarMenu(){
        String[] opcoes = {"Inserir", "Listar","Salvar", "Carregar","Sair"}; //opções para switch
        return JOptionPane.showOptionDialog(null, "Escolha uma opção", //Switch com menu de escolha para funções do programa
            "Escolha",
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
    }

    public void chamarJanela(int aux, IStorage cad, IPersistencia per){
        //try catch para dar continue no loop caso seja selecionado cancelar        
        switch(aux){
                //Switch para buscar a escolha do menu pelo usuario
            case 0:                         //inserir
                JanelaCadastro c = new JanelaCadastro(cad);
                break;//volta para o menu    

            case 1:     //Listar e remover aluno
                JanelaLista l = new JanelaLista(cad);
                break;

            case 2:
                String nome = JOptionPane.showInputDialog("Forneça o nome do arquivo: ");
                if(nome == null || nome.equals("") ){
                    App.menu();
                    break;
                }
                nome = nome.replaceAll("[^a-zA-Z0-9\\.\\-]", "_");
                per.Salvar(cad, nome);
                App.menu();
                break;

            case 3:
                JanelaLoad lo = new JanelaLoad(cad, per);
                break;

            default: //sair
                break;
        }
    }   //volta caso seja selecionado cancelar
}

