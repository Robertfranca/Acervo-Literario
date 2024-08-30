package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TipoDeCadastro extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
//	public JFrame frame; // Agora, o JFrame está acessível para ser chamado de uma classe externa

    public  TipoDeCadastro(TelaPrincipal telaPrincipal) {
        setTitle("Tipo de Cadastro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(500, 100, 800, 800);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton botaoCadastroManual = new JButton("Cadastro Manual");
        botaoCadastroManual.setFont(new Font("Tahoma", Font.BOLD, 12));
        botaoCadastroManual.setBounds(151, 296, 186, 140);
        botaoCadastroManual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastrarLivro cadastrarLivro = new CadastrarLivro();
                cadastrarLivro.setVisible(true);
//				frame.setVisible(false); // Torna a janela atual invisível
            }
        });
        contentPane.add(botaoCadastroManual);

        JButton botaoCadastroPorISBN = new JButton("Cadastro por ISBN");
        botaoCadastroPorISBN.setFont(new Font("Tahoma", Font.BOLD, 12));
        botaoCadastroPorISBN.setBounds(436, 296, 186, 140);
        botaoCadastroPorISBN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastrarLivroISBN cadastrarLivroISBN = new CadastrarLivroISBN();
                cadastrarLivroISBN.setVisible(true);

            }
        });
        contentPane.add(botaoCadastroPorISBN);

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));
        botaoVoltar.setBounds(10, 11, 89, 23);
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                telaPrincipal.frame.setVisible(true);
            }
        });
        contentPane.add(botaoVoltar);
        
        JLabel lblSelecioneotipo = new JLabel("Selecione o tipo de cadastro");
        lblSelecioneotipo.setHorizontalAlignment(SwingConstants.CENTER);
        lblSelecioneotipo.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblSelecioneotipo.setBounds(223, 82, 311, 43);
        contentPane.add(lblSelecioneotipo);
    }
}
