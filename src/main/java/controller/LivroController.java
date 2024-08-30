package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Livro;
import repository.LivroRepository;
import repository.LivroRepositoryImplement;
import repository.RepositoryException;

public class LivroController {

    private final LivroRepository livroRepository;

    public LivroController() {
        this.livroRepository = new LivroRepositoryImplement();
    }

    public String cadastrarLivro(String titulo, String autor, String editora, String status, int nota, String anotacao, String isbn) throws RepositoryException {
        // Limpar os dados
        titulo = limparDados(titulo);
        autor = limparDados(autor);
        editora = limparDados(editora);
        status = limparDados(status);
        anotacao = limparDados(anotacao);
        isbn = limparDados(isbn);

    // Validar e converter ISBN
    /*int isbnInt;
    try {
        isbnInt = validarEConverterISBN(isbn);
    } catch (NumberFormatException e) {
        return "O ISBN deve conter apenas números.";
    }*/

        
        if (titulo.isEmpty() || autor.isEmpty() || editora.isEmpty() || status.isEmpty() || anotacao.isEmpty() || isbn.isEmpty()) {
            return "Preencha todos os campos.";
        } else if (titulo.length() > 500) {
            return "O título excede o limite de 500 caracteres.";
        } else if (autor.length() > 500) {
            return "O autor excede o limite de 500 caracteres.";
        } else if (editora.length() > 500) {
            return "A editora excede o limite de 500 caracteres.";
        } else if (status.length() > 20) {
            return "O status excede o limite de 20 caracteres.";
        } else if (isbn.length() > 15) {
            return "O ISBN excede o limite de 15 caracteres."; 
        } else if (nota < 0 || nota > 10) {
                return "Avacalhou! As notas vão de 0 até 10.";
        } else {
            Livro novoLivro = new Livro(0,titulo, autor, editora, status, nota, anotacao, isbn);
            livroRepository.salvar(novoLivro);
            return "Livro cadastrado com sucesso!";
        }
    }

    public String MensagemEditarLivro(String titulo, String autor, String editora, String status, int nota, String anotacao, String isbn) throws RepositoryException {
        // Limpar os dados
        titulo = limparDados(titulo);
        autor = limparDados(autor);
        editora = limparDados(editora);
        status = limparDados(status);
        anotacao = limparDados(anotacao);
        isbn = limparDados(isbn);

    // Validar e converter ISBN
   /* int isbnInt;
    try {
        isbnInt = validarEConverterISBN(isbn);
    } catch (NumberFormatException e) {
        return "O ISBN deve conter apenas números.";
    }*/

        
        if (titulo.isEmpty() || autor.isEmpty() || editora.isEmpty() || status.isEmpty() || anotacao.isEmpty()) {
            return "Preencha corretamente.";
        } else if (titulo.length() > 500) {
            return "O título excede o limite de 500 caracteres.";
        } else if (autor.length() > 500) {
            return "O autor excede o limite de 500 caracteres.";
        } else if (editora.length() > 500) {
            return "A editora excede o limite de 500 caracteres.";
        } else if (status.length() > 20) {
            return "O status excede o limite de 20 caracteres.";
        } else if (isbn.length() > 15) {
            return "O ISBN excede o limite de 15 caracteres."; 
        } else if (nota < 0 || nota > 10) {
                return "Avacalhou! As notas vão de 0 até 10.";
        } else {
            
            return "Livro editado com sucesso!";
        }
	}
    
    private int validarEConverterISBN(String isbn) throws NumberFormatException {
        return Integer.parseInt(isbn.replaceAll("[^0-9]", ""));
    }

    private String limparDados(String dado) {
        // Remover caracteres especiais e espaços em branco extras
        return dado.replaceAll("[^a-zA-Z0-9\\s]", "").trim().replaceAll("\\s+", " ");
    }

    public List<Livro> listarLivros() throws RepositoryException {
        return livroRepository.buscarTodos();
    }

    public List<Livro> buscarLivros() throws RepositoryException {
        return listarLivros();
    }
    
    public Livro buscarLivroInfo(int id) throws RepositoryException {
    	return livroRepository.buscarLivroInfo(id);
    }
    
    public void editarLivro(Livro livroAtualizado) throws RepositoryException {
    	livroRepository.editarLivro(livroAtualizado);
    }
    
    public void deletarLivro (int id) throws RepositoryException {
    	livroRepository.deletarLivro(id);
    }



}