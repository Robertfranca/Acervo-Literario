package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controllers.LivroController;
import repository.RepositoryException;


public class CadastrarLivro extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public JPanel contentPane;
    public JTextField textFieldTitulo;
    public JTextField textFieldAutor;
    public JTextField textFieldEditora;
    public JTextField textFieldStatus;
    public JTextField textFieldNota;
    public JTextField textFieldAnotacao;
    public JTextField textFieldIsbn;

    /**
     * Create the frame.
     */
    public CadastrarLivro() {
        setTitle("Cadastrar Livro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// Fecha apenas a janela de cadastro
        setBounds(500, 100, 800, 800); // Define o tamanho e posição da janela

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // Define a margem interna do painel
        setContentPane(contentPane);
        contentPane.setLayout(null); // Usando layout nulo para posicionamento absoluto

        JLabel lblCadastrarLivro = new JLabel("Cadastrar Livro");
        lblCadastrarLivro.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblCadastrarLivro.setHorizontalAlignment(SwingConstants.CENTER);
        lblCadastrarLivro.setForeground(Color.BLACK);
        lblCadastrarLivro.setBounds(327, 82, 141, 32); // Posição e tamanho do rótulo
        contentPane.add(lblCadastrarLivro);

        textFieldTitulo = new JTextField();
        textFieldTitulo.setBounds(303, 207, 210, 20);
        contentPane.add(textFieldTitulo);
        textFieldTitulo.setColumns(10);

        textFieldAutor = new JTextField();
        textFieldAutor.setBounds(303, 238, 210, 20);
        contentPane.add(textFieldAutor);
        textFieldAutor.setColumns(10);

        textFieldEditora = new JTextField();
        textFieldEditora.setBounds(303, 269, 210, 20);
        contentPane.add(textFieldEditora);
        textFieldEditora.setColumns(10);

        textFieldStatus = new JTextField();
        textFieldStatus.setBounds(303, 301, 210, 20);
        contentPane.add(textFieldStatus);
        textFieldStatus.setColumns(10);

        textFieldNota = new JTextField();
        textFieldNota.setBounds(303, 333, 210, 20);
        contentPane.add(textFieldNota);
        textFieldNota.setColumns(10);

        textFieldAnotacao = new JTextField();
        textFieldAnotacao.setBounds(303, 365, 210, 20);
        contentPane.add(textFieldAnotacao);
        textFieldAnotacao.setColumns(10);

        textFieldIsbn = new JTextField();
        textFieldIsbn.setBounds(303, 397, 210, 20);
        contentPane.add(textFieldIsbn);
        textFieldIsbn.setColumns(10);


        JLabel lblTitulo = new JLabel("Titulo:");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTitulo.setBounds(250, 206, 59, 14);
        contentPane.add(lblTitulo);

        JLabel lblAutor = new JLabel("Autor:");
        lblAutor.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAutor.setBounds(250, 238, 57, 14);
        contentPane.add(lblAutor);

        JLabel lblEditora = new JLabel("Editora:");
        lblEditora.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblEditora.setBounds(239, 269, 66, 14);
        contentPane.add(lblEditora);

        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblStatus.setBounds(239, 301, 66, 14);
        contentPane.add(lblStatus);

        JLabel lblNota = new JLabel("Nota:");
        lblNota.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNota.setBounds(254, 334, 39, 14);
        contentPane.add(lblNota);

        JLabel lblAnotacao = new JLabel("Anotacao:");
        lblAnotacao.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAnotacao.setBounds(225, 366, 77, 14);
        contentPane.add(lblAnotacao);

        JLabel lblIsbn = new JLabel("ISBN:");
        lblIsbn.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblIsbn.setBounds(246, 398, 47, 14);
        contentPane.add(lblIsbn);

        JButton btnCadastrar = getBtnCadastrar();

        contentPane.add(btnCadastrar);

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));
        botaoVoltar.setBounds(10, 10, 100, 30); // Posição e tamanho do botão
        botaoVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a janela de cadastro e volta para a tela anterior
            }
        });
        getContentPane().add(botaoVoltar);
    }

    private JButton getBtnCadastrar() {
        LivroController livroController = new LivroController();

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnCadastrar.setBounds(348, 432, 110, 32);
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = textFieldTitulo.getText();
                String autor = textFieldAutor.getText();
                String editora = textFieldEditora.getText();
                String status = textFieldStatus.getText();
                String anotacao = textFieldAnotacao.getText();
                String isbn = textFieldIsbn.getText();
                int nota;
                try{
                	nota = Integer.parseInt(textFieldNota.getText());
                }catch(NumberFormatException ex){
                	JOptionPane.showMessageDialog(null, "A nota deve ser um número inteiro válido.");
                    return;
                }


                String mensagem = null;
                try {
                    mensagem = livroController.cadastrarLivro(titulo, autor, editora, status, nota, anotacao, isbn);
                } catch (RepositoryException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println(mensagem);

                JOptionPane.showMessageDialog(null, mensagem);
                if(mensagem.equals("Livro cadastrado com sucesso!")) {
                	textFieldTitulo.setText("");
                    textFieldAutor.setText("");
                    textFieldEditora.setText("");
                    textFieldStatus.setText("");
                    textFieldNota.setText("");
                    textFieldAnotacao.setText("");
                    textFieldIsbn.setText("");
                }
            }
        });
        return btnCadastrar;
    }
}
