package views;

import controllers.LivroController;
import repository.RepositoryException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarLivroISBN extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldIsbn;

    public CadastrarLivroISBN() {
        setTitle("Cadastrar Livro por ISBN");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(500, 100, 800, 800);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblCadastrarLivroISBN = new JLabel("Cadastrar Livro por ISBN");
        lblCadastrarLivroISBN.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblCadastrarLivroISBN.setHorizontalAlignment(SwingConstants.CENTER);
        lblCadastrarLivroISBN.setForeground(Color.BLACK);
        lblCadastrarLivroISBN.setBounds(223, 82, 306, 32);
        contentPane.add(lblCadastrarLivroISBN);

        textFieldIsbn = new JTextField();
        textFieldIsbn.setBounds(271, 206, 210, 20);
        contentPane.add(textFieldIsbn);
        textFieldIsbn.setColumns(10);

        JLabel lblIsbn = new JLabel("ISBN:");
        lblIsbn.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblIsbn.setBounds(230, 208, 46, 14);
        contentPane.add(lblIsbn);

        JButton botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setFont(new Font("Tahoma", Font.BOLD, 13));
        botaoCadastrar.setBounds(327, 278, 107, 23);
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String isbn = textFieldIsbn.getText();
                LivroController livroController = new LivroController();
                String mensagem = null;
                try {
                    mensagem = livroController.cadastrarLivroPorIsbn(isbn);
                } catch (RepositoryException ex) {
                    throw new RuntimeException (ex) ;
                }
                JOptionPane.showMessageDialog(null, mensagem);
                if (mensagem.equals("Livro cadastrado com sucesso!")) {
                    textFieldIsbn.setText("");
                }
            }
        });
        contentPane.add(botaoCadastrar);

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));
        botaoVoltar.setBounds(10, 11, 89, 23);
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        contentPane.add(botaoVoltar);
    }

}
