package controllers;

import java.util.List;

import models.Livro;
import repository.LivroRepository;
import repository.LivroRepositoryImplement;
import repository.RepositoryException;
import api.GoogleBooksApi;
import com.google.gson.JsonObject;

import java.io.IOException;

public class LivroController {

    private final LivroRepository livroRepository;
    private final GoogleBooksApi googleBooksApi;

    public LivroController() {
        this.livroRepository = new LivroRepositoryImplement();
        this.googleBooksApi = new GoogleBooksApi();
    }

    public String cadastrarLivro(String titulo, String autor, String editora, String status, int nota, String anotacao, String isbn) throws RepositoryException {
        // Limpar os dados
        titulo = limparDados(titulo);
        autor = limparDados(autor);
        editora = limparDados(editora);
        status = limparDados(status);
        anotacao = limparDados(anotacao);
        isbn = limparDados(isbn);

        
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

    public String cadastrarLivroPorIsbn(String isbn) throws RepositoryException {
        try {
            JsonObject livroJson = googleBooksApi.buscarLivroPorIsbn(isbn);
            if (livroJson.has("items")) {
                JsonObject volumeInfo = livroJson.getAsJsonArray("items").get(0).getAsJsonObject().getAsJsonObject("volumeInfo");
                String titulo = volumeInfo.get("title").getAsString();
                String autor = volumeInfo.get("authors").getAsJsonArray().get(0).getAsString();
                String editora = volumeInfo.has("publisher") ? volumeInfo.get("publisher").getAsString() : "";
                String status = "Disponível"; // Definindo um status padrão
                int nota = 0; // Definindo uma nota padrão
                String anotacao = ""; // Definindo uma anotação padrão

                Livro livro = new Livro(0, titulo, autor, editora, status, nota, anotacao, isbn);
                livroRepository.cadastrarLivroPorIsbn(livro);
                return "Livro cadastrado com sucesso!";
            } else {
                return "Livro não encontrado na API do Google Books.";
            }
        } catch (IOException e) {
            return "Erro ao buscar livro na API do Google Books: " + e.getMessage();
        }
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