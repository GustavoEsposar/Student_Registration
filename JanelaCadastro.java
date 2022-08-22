import JException.*;
import Model.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Escreva uma descrição da classe JanelaCadastro aqui.
 * 
 * @author Gustavo Barbieri Esposar RA00297810
 *          Caio de Nasi Sclavi      RA00301504
 * @version 10.0 24/05/2022
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;

public class JanelaCadastro implements ActionListener 
{
    // variáveis de instância
    private JTextField nome;
    private JTextField idade;
    private JTextField ra;
    private JTextField curso;
    private JTextField nota;
    JFrame frame;
    IStorage cad;
    /**
     * Construtor para objetos da classe JanelaCadastro
     */

    public JanelaCadastro(IStorage c)
    {
        String[] labels = {"Nome: ", "Idade: ", "RA: ", "Curso: ", "Nota: "};
        String[] dicas = {"Nome completo do aluno.", "Idade para registro do aluno.", "RA de identificação di aluno.", "Curso matriculado.", "Nota média do semestre."};
        int numPairs = labels.length;

        //Estruturando o painel.
        JPanel p = new JPanel(new SpringLayout());
        for (int i = 0; i < numPairs; i++) {
            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
            l.setToolTipText(dicas[i]);
            p.add(l);
            switch(i){
                case 0:
                    nome = new JTextField(10);
                    l.setLabelFor(nome);
                    p.add(nome);
                    break;
                case 1:
                    idade = new JTextField(10);
                    l.setLabelFor(idade);
                    p.add(idade);
                    break;
                case 2:
                    ra = new JTextField(10);
                    l.setLabelFor(ra);
                    p.add(ra);
                    break;
                case 3:
                    curso = new JTextField(10);
                    l.setLabelFor(curso);
                    p.add(curso);
                    break;
                case 4:
                    nota = new JTextField(10);
                    l.setLabelFor(nota);
                    p.add(nota);
                    break;
            }

        }
        //organização do painel criado.
        SpringUtilities.makeCompactGrid(p,
            numPairs, 2, //linhas, colunas
            25, 8,        //initX, initY
            25, 8);       //xPad, yPad

        //Criando a janela de Cadasatro.
        frame = new JFrame("Cadastro");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        //Criação do painel do botão.
        JPanel bot = new JPanel();
        bot.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
        //Criação do botão.
        JButton botao = new JButton("Concluir");
        bot.add(botao);

        botao.addActionListener(this);

        //Configurações do painel.
        p.setOpaque(true); 

        frame.setContentPane(new JPanel());
        frame.getContentPane().add(p);
        frame.getContentPane().add(bot);
        frame.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                    int i=JOptionPane.showConfirmDialog(null, "Tem certeza que quer cancelar?");
                    if(i==0){
                        frame.setVisible(false);//fecha a aba
                        frame.dispose();
                        App.menu();
                    }
                }
            });
        //Mostrando a janela.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        cad = c;
    }

    public void actionPerformed (ActionEvent act) {
        String nome = "";
        String ra = "";
        String curso = "";
        String nota = "";
        float notaFloat = 0;
        String idade = "";
        int idadeInt = 0;
        try{
            try{
                //atribuição do nome;
                nome = this.nome.getText();
                Chamar.stringVazia(nome);
                Chamar.nomeExcecao(nome);
                //atribuição do ra
                
                ra = this.ra.getText();
                Chamar.TextoEhNumero(ra, false);
                Chamar.stringVazia(ra);
                Chamar.nomeExcecao(ra);
                //atribuição da idade
                idade = this.idade.getText();
                Chamar.TextoEhNumero(idade, false);
                Chamar.stringVazia(idade);
                idadeInt = Integer.parseInt(idade);
                //atribuição do curso
                curso = this.curso.getText();
                Chamar.stringVazia(curso);
                Chamar.nomeExcecao(curso);
                //atribuição da nota
                nota = this.nota.getText();
                Chamar.TextoEhNumero(nota, true);
                Chamar.stringVazia(nota);
                Chamar.NotaInvalida(Float.parseFloat(nota));
                notaFloat = Float.parseFloat(nota);
                //atribuição do cadastro final.
                cad.inserir(nome, idadeInt, ra, curso, notaFloat);  //Envia os dados para realizar o cadastro
                frame.setVisible(false);
                frame.dispose();
                App.menu();
            }catch(NomeGrandeException e){
                JOptionPane.showMessageDialog(null, "Limite de caracteres atingido!");
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Formato nota e/ou idade incorretos!");
            }catch(NotaRangeException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }catch(TextoEhNumero e){
                JOptionPane.showMessageDialog(null, "Formato nota, idade ou ra incorretos!");
            }
        }catch(Vazio e){
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!");
        }

    }
}