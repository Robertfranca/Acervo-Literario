package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	public JFrame frame; // Agora, o JFrame está acessível para ser chamado de uma classe externa


	/**
	 * Construtor da aplicação.
	 */
	public TelaPrincipal() {
		initialize();
	} // Inicializa a interface gráfica

	/**
	 * Inicializa o conteúdo da janela.
	 */

	private void initialize() {
		frame = new JFrame(); // Cria a nova janela
		frame.setTitle("Menu Inicial");
		frame.setBounds(500, 100, 800, 800); // Define o tamanho e a posição da janela
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha a aplicação quando a janela é fechada
		frame.getContentPane().setLayout(null); // Usa layout absoluto (null layout)

		// Cria e configura o botão para adicionar livros
		JButton botaoAdicionarLivro = new JButton("Adicionar Livro");
		botaoAdicionarLivro.setFont(new Font("Tahoma", Font.BOLD, 12));
		botaoAdicionarLivro.setBounds(151, 296, 186, 140); // Posição e tamanho do botão
		botaoAdicionarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TipoDeCadastro tipoDeCadastro = new TipoDeCadastro(TelaPrincipal.this); // Cria a instância da janela de cadastro
				tipoDeCadastro.setVisible(true); // Torna a nova janela visível
				frame.setVisible(false); // Torna a janela atual invisível
			}
		});
		frame.getContentPane().add(botaoAdicionarLivro);

		// REMOVI TRY CATCH POR CAUSA DE UM ERRO!!!
		JButton botaoVerLivros = new JButton("Ver Livros");
		botaoVerLivros.setFont(new Font("Tahoma", Font.BOLD, 12));
		botaoVerLivros.setBounds(436, 296, 186, 140); // Posição e tamanho do botão
		botaoVerLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MeusLivros meusLivros = new MeusLivros(); // Cria a instância da janela 'Meus Livros'
//                meusLivros = new MeusLivros();
				meusLivros.setVisible(true); // Exibe a janela 'Meus Livros'
				frame.setVisible(false); // Torna a janela atual invisível
			}
		});
		frame.getContentPane().add(botaoVerLivros);

		JLabel lblMenuInicial = new JLabel("Menu Inicial");
		lblMenuInicial.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuInicial.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMenuInicial.setBounds(327, 82, 120, 39);
		frame.getContentPane().add(lblMenuInicial);

//		JButton btnMeusLivros = new JButton("MeusLivrose\r\n");
//		btnMeusLivros.setBounds(172, 227, 89, 23);
//		btnMeusLivros.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				/*LivroController livroController = new LivroController();
//				Livro info = livroController.buscarLivroInfo(8);
//				System.out.println(info.getNota());
//				livroController.deletarLivro(info.getId());*/
//			}
//		});
//		frame.getContentPane().add(btnMeusLivros);
	}
}