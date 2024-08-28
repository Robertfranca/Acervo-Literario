package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import controller.ControladorUsuario;
import models.Conexao;

@SuppressWarnings("unused")
public class CadastrarUsuario {

	private JFrame frmCadastro;
	private JTextField nome;
	private JTextField cpf;
	private JTextField email;
	private JPasswordField senha;
	private JPasswordField verificarSenha;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarUsuario window = new CadastrarUsuario();
					window.frmCadastro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public CadastrarUsuario() {
		initialize();
	}

	private void initialize() {
		frmCadastro = new JFrame();
		frmCadastro.setTitle("Cadastro");
		frmCadastro.setBounds(100, 100, 450, 300);
		frmCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastro.getContentPane().setLayout(null);
		
		JLabel nomeLabel = new JLabel("Informe o seu nome:");
		nomeLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		nomeLabel.setBounds(10, 80, 125, 14);
		frmCadastro.getContentPane().add(nomeLabel);
		
		JLabel cpfLabel = new JLabel("Informe o seu cpf:");
		cpfLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		cpfLabel.setBounds(10, 105, 125, 14);
		frmCadastro.getContentPane().add(cpfLabel);
		
		nome = new JTextField();
		nome.setBounds(125, 77, 131, 20);
		frmCadastro.getContentPane().add(nome);
		nome.setColumns(10);
		
		cpf = new JTextField();
		cpf.setBounds(125, 102, 111, 20);
		frmCadastro.getContentPane().add(cpf);
		cpf.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CADASTRE-SE NO ACERVO LITER\u00C1RIO");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(128, 128, 255));
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(84, 11, 274, 40);
		frmCadastro.getContentPane().add(lblNewLabel_2);
		
		JLabel emailLabel = new JLabel("Informe o seu email:");
		emailLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		emailLabel.setBounds(10, 130, 125, 14);
		frmCadastro.getContentPane().add(emailLabel);
		
		email = new JTextField();
		email.setBounds(125, 127, 179, 20);
		frmCadastro.getContentPane().add(email);
		email.setColumns(10);
		
		JLabel senhaLabel = new JLabel("Informe a senha:");
		senhaLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		senhaLabel.setBounds(10, 155, 111, 14);
		frmCadastro.getContentPane().add(senhaLabel);
		
		senha = new JPasswordField();
		senha.setBounds(125, 152, 111, 20);
		frmCadastro.getContentPane().add(senha);
		
		JLabel senha2label = new JLabel("Repita a senha:");
		senha2label.setFont(new Font("Arial", Font.PLAIN, 12));
		senha2label.setBounds(10, 180, 111, 14);
		frmCadastro.getContentPane().add(senha2label);
		
		verificarSenha = new JPasswordField();
		verificarSenha.setBounds(125, 177, 111, 20);
		frmCadastro.getContentPane().add(verificarSenha);
		
		JButton btCadastro = new JButton("CADASTRAR");
		btCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Acesso exibir = new Acesso();
				exibir.setVisible(true);
				
				setVisible(false);
			}
		});
		btCadastro.setFont(new Font("Arial", Font.BOLD, 14));
		btCadastro.setIcon(null);
		btCadastro.setBounds(147, 208, 125, 30);
		frmCadastro.getContentPane().add(btCadastro);
		
		
}

	protected void setVisible(boolean b) {
		
	}
};
