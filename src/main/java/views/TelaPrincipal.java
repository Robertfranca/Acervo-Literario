package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal {

    private JFrame frmMenuInicial;

    /**
     * Método principal para iniciar a aplicação.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaPrincipal window = new TelaPrincipal(); // Cria uma instância da TelaPrincipal
                    window.frmMenuInicial.setVisible(true); // Torna a janela visível
                } catch (Exception e) {
                    e.printStackTrace(); // Imprime qualquer erro que ocorra
                }
            }
        });
    }

    /**
     * Construtor da aplicação.
     */
    public TelaPrincipal() {
        initialize(); // Chama o método para configurar a janela
    }

    /**
     * Configura o conteúdo da janela.
     */
    private void initialize() {
        frmMenuInicial = new JFrame(); // Cria uma nova janela
        frmMenuInicial.setTitle("Menu Inicial");
        frmMenuInicial.setBounds(100, 100, 450, 300); // Define o tamanho e a posição da janela
        frmMenuInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha a aplicação quando a janela é fechada
        frmMenuInicial.getContentPane().setLayout(null);

        // Cria e configura o botão para adicionar livros
        JButton botaoAdicionarLivro = new JButton("Adicionar Livro");
        botaoAdicionarLivro.setBounds(72, 100, 128, 82); // Posição e tamanho do botão
        botaoAdicionarLivro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastrarLivro cadastrarLivro = new CadastrarLivro(); // Cria a instância da janela de cadastro
                cadastrarLivro.setVisible(true); // Torna a nova janela visível
            }
        });
        frmMenuInicial.getContentPane().add(botaoAdicionarLivro);

        // Cria e configura o botão para ver livros
        JButton VerLivros = new JButton("Ver Livros");
        VerLivros.setBounds(245, 100, 128, 82);
        VerLivros.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MeusLivros meusLivros = new MeusLivros();
                meusLivros.setVisible(true); // Exibe a tela 'Meus Livros'
            }
        });
        frmMenuInicial.getContentPane().add(VerLivros);
    }
}
