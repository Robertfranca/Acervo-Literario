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
import models.Livro;
import repository.RepositoryException;


public class EditarLivro extends JFrame {

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
    public Livro info; 

    /**
     * Create the frame.
     * @throws RepositoryException 
     */
    
    private Livro buscarLivroInfo(int id) throws RepositoryException {
    	try {
    		LivroController controller = new LivroController();
    		Livro info = controller.buscarLivroInfo(id);
    		this.info  = info;
    		return info;
    	} catch (Exception e) {
    		throw new RepositoryException("Error",e);
    	}
    }
    
    public EditarLivro(int id) {
    	
    	
        setTitle("Editar Livro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// Fecha apenas a janela de cadastro
        setBounds(500, 100, 800, 800); // Define o tamanho e posição da janela

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // Define a margem interna do painel
        setContentPane(contentPane);
        contentPane.setLayout(null); // Usando layout nulo para posicionamento absoluto

        JLabel lblEditarLivro = new JLabel("Editar Livro");
        lblEditarLivro.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblEditarLivro.setHorizontalAlignment(SwingConstants.CENTER);
        lblEditarLivro.setForeground(Color.BLACK);
        lblEditarLivro.setBounds(138, 46, 141, 32); // Posição e tamanho do rótulo
        contentPane.add(lblEditarLivro);

        textFieldTitulo = new JTextField();
        textFieldTitulo.setBounds(111, 95, 210, 20);
        contentPane.add(textFieldTitulo);
        textFieldTitulo.setColumns(10);

        textFieldAutor = new JTextField();
        textFieldAutor.setBounds(111, 126, 210, 20);
        contentPane.add(textFieldAutor);
        textFieldAutor.setColumns(10);

        textFieldEditora = new JTextField();
        textFieldEditora.setBounds(111, 157, 210, 20);
        contentPane.add(textFieldEditora);
        textFieldEditora.setColumns(10);

        textFieldStatus = new JTextField();
        textFieldStatus.setBounds(111, 189, 210, 20);
        contentPane.add(textFieldStatus);
        textFieldStatus.setColumns(10);

        textFieldNota = new JTextField();
        textFieldNota.setBounds(111, 221, 210, 20);
        contentPane.add(textFieldNota);
        textFieldNota.setColumns(10);

        textFieldAnotacao = new JTextField();
        textFieldAnotacao.setBounds(111, 253, 210, 20);
        contentPane.add(textFieldAnotacao);
        textFieldAnotacao.setColumns(10);

        textFieldIsbn = new JTextField();
        textFieldIsbn.setBounds(111, 285, 210, 20);
        contentPane.add(textFieldIsbn);
        textFieldIsbn.setColumns(10);


        JLabel lblTitulo = new JLabel("Título:");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTitulo.setBounds(58, 94, 59, 14);
        contentPane.add(lblTitulo);

        JLabel lblAutor = new JLabel("Autor:");
        lblAutor.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAutor.setBounds(58, 126, 57, 14);
        contentPane.add(lblAutor);

        JLabel lblEditora = new JLabel("Editora:");
        lblEditora.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblEditora.setBounds(47, 157, 66, 14);
        contentPane.add(lblEditora);

        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblStatus.setBounds(47, 189, 66, 14);
        contentPane.add(lblStatus);

        JLabel lblNota = new JLabel("Nota:");
        lblNota.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNota.setBounds(47, 221, 66, 14);
        contentPane.add(lblNota);

        JLabel lblAnotacao = new JLabel("Anotação:");
        lblAnotacao.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAnotacao.setBounds(47, 253, 66, 14);
        contentPane.add(lblAnotacao);

        JLabel lblIsbn = new JLabel("ISBN:");
        lblIsbn.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblIsbn.setBounds(47, 285, 66, 14);
        contentPane.add(lblIsbn);

        JButton BtnEditar = getBtnEditar();

        contentPane.add(BtnEditar);

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
        botaoVoltar.setBounds(10, 10, 100, 30); // Posição e tamanho do botão
        botaoVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a janela de cadastro e volta para a tela anterior
            }
        });
        getContentPane().add(botaoVoltar);
        
        try {
			Livro info  = this.buscarLivroInfo(id);
			this.textFieldTitulo.setText(info.getTitulo());
		    this.textFieldAutor.setText(info.getAutor());
		    this.textFieldEditora.setText(info.getEditora());
		    textFieldStatus.setText(info.getStatus());
		    textFieldNota.setText(((Integer) info.getNota()).toString());
		    textFieldAnotacao.setText(info.getAnotacao());
		    
			
			info.getAutor();
		} catch (RepositoryException e) {
			
			e.printStackTrace();
		}
    }

    private JButton getBtnEditar() {
        LivroController livroController = new LivroController();

        JButton btnEditar = new JButton("Editar");
        btnEditar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnEditar.setBounds(156, 320, 110, 32);
        btnEditar.addActionListener(new ActionListener() {
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
                
                Livro livroAtualizado  = new Livro(info.id, titulo, autor, editora, status, nota, anotacao, isbn);


                String mensagem = null;
                try {
                   livroController.editarLivro(livroAtualizado);
                } catch (RepositoryException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println(mensagem);

                JOptionPane.showMessageDialog(null, mensagem);
                if(mensagem.equals("Livro Editado com sucesso!")) {
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
        return btnEditar;
    }
}