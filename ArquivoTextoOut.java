import java.io.*;
import java.util.StringTokenizer;
import JException.*;
import javax.swing.JOptionPane;

/**
 * 
 * 
 * @author Gustavo Barbieri Esposar RA00297810
 *          Caio de Nasi Sclavi      RA00301504
 * @version 10.0 03/06/2022 09h10
 */

public class ArquivoTextoOut implements IPersistencia {
    String ext = "cadt";
    public void Salvar(IStorage cad, String arquivo) {
        File file = null;
        String sn = "S";
        file = new File(arquivo + ".cadt");

     
        char separador = '|'; // caractere que sera utilizado para separar os dados
        // Classes de gravacao de dados
        PrintWriter pw = null;
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(file);
            pw = new PrintWriter(fos);
        } catch(IOException ex) {
            System.out.println("Nao conseguiu abrir o arquivo: " + arquivo);
            return;
        } catch(Exception ex) {
            System.out.println("Erro inesperado ao tentar abrir o arquivo: " + arquivo);
            return;
        }

        // Gravacao dos dado no arquivo
        try {
            for (int i = 1; i <= cad.getTamanho(); i++) { //para gravar algumas linhas
                pw.print(cad.getNomeAluno(i));
                pw.print(separador);
                pw.print(cad.getIdadeAluno(i));
                pw.print(separador);
                pw.print(cad.getRaAluno(i));
                pw.print(separador);
                pw.print(cad.getCursoAluno(i));
                pw.print(separador);
                pw.print(cad.getNotaAluno(i));
                pw.println(separador); // muda de linha
            }
        } catch(Exception ex) {
            System.out.println("Erro inesperado ao tentar escrever no arquivo: " + arquivo);
            return;
        } finally {
            try {
                pw.close();
            } catch(Exception ex) {
                // Nao faz nada!
            }
            try {
                fos.close();
            } catch(Exception ex) {
                // Nao faz nada!
            }
        }
    }

    public String getExtencao(){
        return ext;
    }
    
    public void lerObj(IStorage cad, String arquivo){
        cad.limparCadastro(); //limpa o cadastro para carregar save
        File file = null;
        boolean repetir = false;
        String nome = "";
        int idade = 0;
        String ra = "";
        String curso = "";
        float nota = 0;
        // Faz leitura do nome do arquivo
        do {
            repetir = false;
            file = new File(arquivo);
            if (!file.exists()) { // Verifica se o qruivo existe
                String sn = JOptionPane.showInputDialog("Arquivo:" + arquivo + " inexistente, deseja tentar de novo?(s/n): ");
                if (sn.toUpperCase().charAt(0) == 'S') {
                    repetir = true;
                } else {
                    System.exit(0);
                }
            }
        } while(repetir);

        // Classes para leitura de dados
        BufferedReader br = null;
        FileReader fr = null;

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
        } catch(FileNotFoundException ex) {
            System.out.println("Arquivo inexistente: " + arquivo);
            return;
        } catch(Exception ex) {
            System.out.println("Erro inesperado ao tentar abrir o arquivo: " + arquivo);
            ex.printStackTrace();
            return;
        }

        // Leitura de dados
        try {
            String line = br.readLine();
            while(line != null) { // Enquanto existir linha no arquivo
                String separadores = "\n"+ "|"; //"\t\n\r\f"+ "|";
                StringTokenizer st = new StringTokenizer(line, separadores);

                // nome
                if (st.hasMoreTokens()) {
                    String tok = st.nextToken();
                    nome = tok;
                }

                // idade    
                if (st.hasMoreTokens()) {
                    String tok = st.nextToken();
                    idade = Integer.parseInt(tok);
                }

                // ra
                if (st.hasMoreTokens()) {
                    String tok = st.nextToken();
                    ra = tok;
                }
                
                // curso
                if (st.hasMoreTokens()) {
                    String tok = st.nextToken();
                    curso = tok;
                }

                // nota
                if (st.hasMoreTokens()) {
                    String tok = st.nextToken();
                    nota = Float.parseFloat(tok);
                }
                
                cad.inserir(nome, idade, ra, curso, nota);//inserir os dados do cadastro;
                line = br.readLine(); // Le a proxima linha
            }

        
        } catch(EOFException ex) {
            System.out.println("Atingiu prematuramente o final do arquivo: " + arquivo);
            return;
        } catch(IOException ex) {
            System.out.println("Nao conseguiu ler do arquivo: " + arquivo);
            return;
        } catch(Exception ex) {
            System.out.println("Erro inesperado ao tentar ler o arquivo: " + arquivo);
            ex.printStackTrace();
            return;
        } finally {
            try {
                br.close();
            } catch(Exception ex) {
                // Nao faz nada !
            }
            try {
                fr.close();
            } catch(Exception ex) {
                // Nao faz nada !
            }
        }
    }
}
