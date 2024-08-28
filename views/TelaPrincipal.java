package views;

import java.awt.*;

import javax.swing.*;

import controllers.LivroController;
import models.Livro;
import repository.RepositoryException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		frame.setBounds(100, 100, 450, 300); // Define o tamanho e a posição da janela
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha a aplicação quando a janela é fechada
		frame.getContentPane().setLayout(null); // Usa layout absoluto (null layout)

		// Cria e configura o botão para adicionar livros
		JButton botaoAdicionarLivro = new JButton("Adicionar Livro");
		botaoAdicionarLivro.setBounds(72, 100, 128, 82); // Posição e tamanho do botão
		botaoAdicionarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarLivro cadastrarLivro = new CadastrarLivro(); // Cria a instância da janela de cadastro
				cadastrarLivro.setVisible(true); // Torna a nova janela visível
			}
		});
		frame.getContentPane().add(botaoAdicionarLivro);

		// Cria e configura o botão para ver livros
		JButton botaoVerLivros = new JButton("Ver Livros");
		botaoVerLivros.setBounds(245, 100, 128, 82); // Posição e tamanho do botão
		botaoVerLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                MeusLivros meusLivros = null; // Cria a instância da janela 'Meus Livros'
                try {
                    meusLivros = new MeusLivros(null);
                } catch (RepositoryException ex) {
                    throw new RuntimeException(ex);
                }
                meusLivros.setVisible(true); // Exibe a janela 'Meus Livros'
			}
		});
		frame.getContentPane().add(botaoVerLivros);

		JLabel lblMenuInicial = new JLabel("Menu Inicial");
		lblMenuInicial.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuInicial.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMenuInicial.setBounds(156, 35, 120, 39);
		frame.getContentPane().add(lblMenuInicial);
		
//		JButton btnTest = new JButton("Teste\r\n");
//		btnTest.setBounds(172, 227, 89, 23);
//		btnTest.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				/*LivroController livroController = new LivroController();
//				Livro info = livroController.buscarLivroInfo(8);
//				System.out.println(info.getNota());
//				livroController.deletarLivro(info.getId());*/
//			}
//		});
//		frame.getContentPane().add(btnTest);
	}
}