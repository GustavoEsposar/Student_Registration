import JException.*;
/**
 * Fuções de view por Console;
 * 
 * @authors Gustavo Barbieri Esposar RA00297810
 *          Caio de Nasi Sclavi      RA00301504
 * @version 1.0 31/03/2022 08h10
 */

import java.util.Scanner;
import javax.swing.JOptionPane;
public class EntradaC implements IEntrada
{
    /** Função para chamar a interface de fornecer o nome do aluno */
    public String nomeAluno(){
        System.out.print("Nome: ");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        
        return (nome);
    }
    /** Função para chamar a interface de fornecer a idade do aluno */
    public String idadeAluno(){
        System.out.print("Idade: ");
        Scanner scanner = new Scanner(System.in);
        String i = scanner.nextLine();
        return i;
    }
    /** Função para chamar a interface de fornecer o ra do aluno */
    public String raAluno(){
        System.out.print("Ra: ");
        Scanner scanner = new Scanner(System.in);
        String ra = scanner.nextLine();
        return ra;
    }
    /** Função para chamar a interface de fornecer o curso do aluno */
    public String cursoAluno(){
        System.out.print("Curso: ");
        Scanner scanner = new Scanner(System.in);
        String curso = scanner.nextLine();
        return curso;
    }
    /** Função para chamar a interface de fornecer a nota do aluno */
    public String notaAluno(){
        System.out.print("Nota: ");
        Scanner scanner = new Scanner(System.in);
        String nota = scanner.nextLine();
        return nota;
    }
    /** Função para chamar a interface do menu principal */
    public int criarMenu(){
        String[] opcoes = {"Inserir", "Remover", "Listar", "Sair"}; //opções para switch
        return JOptionPane.showOptionDialog(null, "Escolha uma opção", //Switch com menu de escolha para funções do programa
                "Escolha",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
    }
    /** Função para chamar a interface de fornecer listar os alunos */
    public String listarMenu(String resp){
        System.out.print("-------------------------\n" + resp + "Escolha um aluno: ");
        Scanner scanner = new Scanner(System.in);
        String i = scanner.nextLine();
        return i;
    }
    /** Função para chamar notificar a remoção bem sucedida de um aluno  */
    public void removerSucesso(){
        JOptionPane.showMessageDialog(null, "Removido com sucesso");
    }
    /** Função para chamar a interface do aluno selecionado  */    
    public void listarSelecao(String aluno){
        
        JOptionPane.showMessageDialog(null, aluno);
    }
    /** Função para chamar a mensagem de erro para exceções  */
    public void Error(String tipo){
        JOptionPane.showMessageDialog(null, tipo);
    }
    public void chamarJanela(int aux, IStorage cad){
        String nome = "";
        String ra = "";
        String curso = "";
        String nota = "";
        float notaFloat = 0;
        String idade = "";
        int idadeInt = 0;
        boolean check = false;
        try{                                    //try catch para dar continue no loop caso seja selecionado cancelar        
                switch(aux){
                        //Switch para buscar a escolha do menu pelo usuario
                    case 0:                         //inserir
                        do{                         //loop para erros no nome
                            check = false;
                            try{
                                nome = nomeAluno();
                                Chamar.stringVazia(nome);
                                Chamar.nomeExcecao(nome);
                            }catch(NomeGrandeException e){
                                Error(e.getMessage());
                                check = true;
                                continue;
                            }
                        }while(check);
                        do{                     //loop para erros no ra
                            check = false;
                            try{
                                ra = raAluno();
                                Chamar.stringVazia(ra);
                                Chamar.nomeExcecao(ra);
                            }catch(NomeGrandeException e){
                                Error(e.getMessage());
                                check = true;
                                continue; 
                            }
                        }while(check);
                        do{                    //loop para erros na idade
                            check = false;
                            try{
                                idade = idadeAluno();
                                Chamar.stringVazia(idade);
                                idadeInt = Integer.parseInt(idade);
                            }catch(NumberFormatException e){
                                Error("Caracter invalido!");
                                check = true;
                            }
                        }while(check);
                        do{                //loop para erros no curso do aluno
                            check = false;
                            curso = cursoAluno();
                            Chamar.stringVazia(curso);
                            try{
                                Chamar.nomeExcecao(curso);
                            }catch(NomeGrandeException e){
                                Error(e.getMessage());
                                check = true;
                                continue; 
                            }
                        }while(check);
                        do{             //loop para erros na nota do aluno
                            check = false;
                            nota = notaAluno();
                            Chamar.stringVazia(nota);
                            try{
                                Chamar.NotaInvalida(Float.parseFloat(nota));
                                notaFloat = Float.parseFloat(nota);
                            }catch(NumberFormatException e){
                                Error("Caracter invalido!");
                                check = true;
                            }catch(NotaRangeException e){
                                Error("Nota deve ser um valor entre 0 e 10!");
                                check = true;
                            }
                        }while(check);
                        cad.inserir(nome, idadeInt, ra, curso, notaFloat);  //Envia os dados para realizar o cadastro
                        App.menu();
                        break;//volta para o menu    

                    case 1:     //remover aluno
                        boolean removido = cad.remover(raAluno());
                        if(removido){
                            removerSucesso();
                        }
                        App.menu();
                        break;
                    case 2: //listar alunos
                        int aux2 = 0;
                        do{
                            check = false;
                            String escolha = listarMenu(cad.listar());
                            Chamar.stringVazia(escolha);
                            try{
                                aux2 = Integer.parseInt(escolha);
                            }catch(NumberFormatException e){
                                Error("Caracter invalido!");
                                check = true;
                            }
                        }while(check);
                        String aluno = cad.getAluno(aux2);
                        if(aluno == "-1"){
                            Error("Aluno invalido");
                        }else
                        listarSelecao(aluno);
                        App.menu();
                        break;
                }
            }catch(Vazio e){   //volta caso seja selecionado cancelar
                App.menu();
            }
    }
}
