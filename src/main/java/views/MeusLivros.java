package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.SwingConstants;

public class MeusLivros extends JFrame {

    private static final long serialVersionUID = 1L; // Identificador para serialização
    private JPanel contentPane;

    /**
     * Create the frame.
     */
    public MeusLivros() {
    	setTitle("Lista de Livros");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas a janela de 'Meus Livros'
        setBounds(100, 100, 450, 300); // Define o tamanho e posição da janela

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // Define a margem interna do painel
        setContentPane(contentPane);
        contentPane.setLayout(null); // Usando layout nulo para posicionamento absoluto

        JLabel lblMeusLivros = new JLabel("Meus Livros");
        lblMeusLivros.setHorizontalAlignment(SwingConstants.CENTER);
        lblMeusLivros.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblMeusLivros.setForeground(Color.BLACK);
        lblMeusLivros.setBounds(158, 31, 120, 32); // Posição e tamanho do rótulo
        contentPane.add(lblMeusLivros);
    }
}

