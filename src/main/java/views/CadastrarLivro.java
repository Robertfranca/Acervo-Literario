package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;

public class CadastrarLivro extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

    /**
     * Create the frame.
     */
    public CadastrarLivro() {
    	setTitle("Tela de Cadastro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas a janela de cadastro
        setBounds(100, 100, 450, 300); // Define o tamanho e posição da janela

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // Define a margem interna do painel
        setContentPane(contentPane);
        contentPane.setLayout(null); // Usando layout nulo para posicionamento absoluto

        JLabel lblCadastrarLivro = new JLabel("Cadastrar Livro");
        lblCadastrarLivro.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblCadastrarLivro.setHorizontalAlignment(SwingConstants.CENTER);
        lblCadastrarLivro.setForeground(Color.BLACK);
        lblCadastrarLivro.setBounds(140, 28, 141, 32); // Posição e tamanho do rótulo
        contentPane.add(lblCadastrarLivro);
        
        textField = new JTextField();
        textField.setBounds(111, 71, 210, 20);
        contentPane.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBounds(111, 110, 210, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(111, 149, 210, 20);
        contentPane.add(textField_2);
        textField_2.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Título:");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel.setBounds(42, 72, 59, 14);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Autor:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setBounds(42, 111, 51, 14);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Editora:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2.setBounds(42, 150, 66, 14);
        contentPane.add(lblNewLabel_2);
    }
}
