package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel add_livro = new JLabel("Adicionar Livro");
		add_livro.setBounds(69, 74, 73, 28);
		frame.getContentPane().add(add_livro);
		
		JLabel list_livros = new JLabel("Ver Livros");
		list_livros.setBounds(290, 74, 73, 28);
		frame.getContentPane().add(list_livros);
		
		//Botao adicionar livro e seu listener e event.
		JButton AdicionarLivro = new JButton("+");
		AdicionarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarLivro cadastrarlivroobj = new CadastrarLivro (); 
				cadastrarlivroobj.setVisible(true);  
			}
		});
		AdicionarLivro.setBounds(63, 113, 89, 69);
		frame.getContentPane().add(AdicionarLivro);
		
		JButton VerLivros = new JButton("=");
		VerLivros.setBounds(273, 113, 89, 69);
		frame.getContentPane().add(VerLivros);
	}
}
