import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Janela para listar historico de contas
 * 
 * @author  Gustavo Barbieri Esposar RA00297810
 *          Caio de Nasi Sclavi      RA00301504
 * @version 10.0 24/05/2022
 */
public class JanelaLista implements ActionListener
{   //Cria janela para listar
    JFrame frame = new JFrame("Alunos");
    JList<Object> lista = new JList<Object>();
    DefaultListModel<Object> model = new DefaultListModel<>();
    JLabel label = new JLabel();
    JPanel panel = new JPanel();
    JButton remover = new JButton("Remover Cadastro");
    
    GridBagConstraints gbc = new GridBagConstraints();
    JSplitPane splitpane = new JSplitPane();
    IStorage cad;
    Object p;
    public JanelaLista(IStorage _cad)
    {
        cad = _cad;
        lista.setModel(model);
        remover.addActionListener(this);
        for(int i = 1; i <= cad.getTamanho(); i++){
            model.addElement(new Object(cad.getNomeAluno(i), cad.getIdadeAluno(i), cad.getRaAluno(i), cad.getCursoAluno(i), cad.getNotaAluno(i)));
        }

        lista.getSelectionModel().addListSelectionListener(e -> {
                p = lista.getSelectedValue();
                label.setText("<html>" + "Nome: " + p.getNome() + "<br>Idade: " + p.getIdade() + "<br>RA" + p.getRa() + "<br>Curso: " + p.getCurso() + "<br>Nota: " + p.getNota() + "</html>");
                gbc.gridx = 0;
                gbc.gridy = 1;
                panel.add(remover, gbc);
            });

        panel.setLayout(new GridBagLayout());

        splitpane.setLeftComponent(new JScrollPane(lista));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty=0.5;
        panel.add(label, gbc);

        splitpane.setRightComponent(panel);
        splitpane.setDividerLocation(150);

        frame.setSize(500, 250);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.add(splitpane);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                    int i=JOptionPane.showConfirmDialog(null, "Tem certeza que quer sair?");
                    if(i==0){
                        frame.setVisible(false);//fecha a aba
                        frame.dispose();
                        App.menu();
                    }
                }
            });

    }

    private class Object{
        String nome;
        String idade;
        String ra;
        String curso;
        String nota;

        public Object(String nome, int idade, String ra, String curso, float nota){
            this.nome = nome;
            this.idade = Integer.toString(idade);
            this.ra = ra;
            this.curso = curso;
            this.nota = Float.toString(nota);

        }

        public String getNome() {
            return nome;
        }

        public String getIdade() {
            return idade;
        }

        public String getRa() {
            return ra;
        }

        public String getCurso() {
            return curso;
        }

        public String getNota() {
            return nota;
        }

        @Override
        public String toString(){
            return nome;
        }
    }

    public void actionPerformed (ActionEvent act) {
        cad.remover(p.getRa());
        frame.setVisible(false);//fecha a aba
        frame.dispose();    
        JanelaLista l = new JanelaLista(cad);
    }
}
