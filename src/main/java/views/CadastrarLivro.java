package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;

public class CadastrarLivro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarLivro frame = new CadastrarLivro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastrarLivro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel CadastrarLivro = new JLabel("Cadastrar Livro");
		CadastrarLivro.setForeground(new Color(0, 0, 0));
		CadastrarLivro.setBackground(new Color(255, 255, 255));
		CadastrarLivro.setBounds(164, 28, 88, 32);
		contentPane.add(CadastrarLivro);
		
		JLabel NomeLivro = new JLabel("Nome do livro:");
		NomeLivro.setBounds(10, 65, 69, 14);
		contentPane.add(NomeLivro);
		
		textField = new JTextField();
		textField.setBounds(82, 62, 290, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel NomeAutor = new JLabel("Autor:");
		NomeAutor.setBounds(48, 90, 31, 14);
		contentPane.add(NomeAutor);
		
		textField_1 = new JTextField();
		textField_1.setBounds(82, 90, 290, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel NomeEditora = new JLabel("Editora:");
		NomeEditora.setBounds(41, 115, 38, 14);
		contentPane.add(NomeEditora);
		
		textField_2 = new JTextField();
		textField_2.setBounds(80, 112, 292, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	}
}
