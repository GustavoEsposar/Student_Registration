import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FilenameFilter;

/**
 * Janela para listar historico de contas
 * 
 * @author  Gustavo Barbieri Esposar RA00297810
 *          Caio de Nasi Sclavi      RA00301504
 * @version 10.0 24/05/2022
 */
public class JanelaLoad implements ActionListener
{   //Cria janela para listar
    JFrame frame = new JFrame("Carregar Arquivo");
    JList<Object> lista = new JList<Object>();
    DefaultListModel<Object> model = new DefaultListModel<>();
    JPanel panel = new JPanel();
    JButton carregar = new JButton("Carregar arquivo");
    JButton deletar = new JButton("Deletar save");
    JLabel label  = new JLabel();
    GridBagConstraints gbc = new GridBagConstraints();
    JSplitPane splitpane = new JSplitPane();
    IStorage cad;
    Object p;
    public JanelaLoad(IStorage _cad, IPersistencia per)
    {
        cad = _cad;
        lista.setModel(model);
        carregar.addActionListener(this);

        File dir = new File("./");
        File[] files = dir.listFiles(new FilenameFilter() {
                    public boolean accept(File dir, String name) {
                        return name.toLowerCase().endsWith(per.getExtencao());
                    }
                });

        for (File file : files) {
            model.addElement(new Object(file.getName()));
        }

        
        lista.getSelectionModel().addListSelectionListener(e -> {   
                p = lista.getSelectedValue();
                label.setText(" ");
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.gridx = 0;
                gbc.gridy = 0;  
                gbc.insets = new Insets(10,10,10,10);
                panel.add(carregar, gbc);
                gbc.gridx = 0;
                gbc.gridy = 1;

                panel.add(deletar, gbc);

            });

        deletar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new File(p.toString()).delete();
                    frame.setVisible(false);//fecha a aba
                    frame.dispose(); 
                    JanelaLoad lo = new JanelaLoad(cad, per);
                }
            });

        panel.setLayout(new GridBagLayout());

        panel.add(label);
        splitpane.setLeftComponent(new JScrollPane(lista));

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

    public class Object{
        String file;
        int i = 0;

        public Object(String nomeArquivo){
            file = nomeArquivo;
            i++;
        }

        public String getArquivo(){
            return file;
        }

        @Override
        public String toString(){
            return file;    
        }
    }

    public void actionPerformed (ActionEvent act) {
        App.ler(p.getArquivo());
        JOptionPane.showMessageDialog(null, "Carregado com sucesso!");
        frame.setVisible(false);//fecha a aba
        frame.dispose();  
        App.menu();
    }
}
