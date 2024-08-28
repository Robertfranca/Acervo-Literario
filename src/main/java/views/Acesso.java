package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Acesso extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acesso frame = new Acesso();
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
	public Acesso() {
		setTitle("Acesse o Acervo Liter\u00E1rio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Informe seu cpf:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 47, 105, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblInformeSuaSenha = new JLabel("Informe sua senha:");
		lblInformeSuaSenha.setFont(new Font("Arial", Font.BOLD, 12));
		lblInformeSuaSenha.setBounds(10, 104, 125, 26);
		contentPane.add(lblInformeSuaSenha);
		
		textField = new JTextField();
		textField.setBounds(120, 50, 143, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(133, 107, 130, 20);
		contentPane.add(passwordField);
		
		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.setFont(new Font("Arial", Font.BOLD, 14));
		btnAcessar.setBounds(133, 154, 105, 35);
		contentPane.add(btnAcessar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarUsuario exibir = new CadastrarUsuario();
				exibir.setVisible(true);
				
				setVisible(false);
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 14));
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnVoltar.setBounds(133, 207, 108, 26);
		contentPane.add(btnVoltar);
	}
}
