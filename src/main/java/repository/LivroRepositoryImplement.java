package repository;

import models.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroRepositoryImplement implements LivroRepository {
    private static final String URL = "jdbc:mysql://localhost:3306/Biblioteca";
    private static final String USER = "root";
    private static final String PASSWORD = "12345";


    public void testConnection() throws RepositoryException{
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            if (conn != null) {
                System.out.println("Connection to the database was successful!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while connecting to the database:");
            e.printStackTrace();
        }
    }

    public void salvar(Livro livro) throws RepositoryException {
        String sql = "INSERT INTO livro (titulo, autor, editora, status, nota, anotacao, isbn) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getEditora());
            stmt.setString(4, livro.getStatus());
            stmt.setInt(5, livro.getNota());
            stmt.setString(6, livro.getAnotacao());
            stmt.setString(7, livro.getIsbn());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
//            throw new RuntimeException("ERROR", e);
            throw new RepositoryException("Error saving book", e);
        }

    }

    public void cadastrarLivroPorIsbn(Livro  livro) throws  RepositoryException {
        String sql = "INSERT INTO livro (titulo, autor, editora, status, nota, anotacao, isbn) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getEditora());
            stmt.setString(4, livro.getStatus());
            stmt.setInt(5, livro.getNota());
            stmt.setString(6, livro.getAnotacao());
            stmt.setString(7, livro.getIsbn());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RepositoryException("Erro ao salvar livro por ISBN", e);
        }
    }

    public Livro buscarPorTitulo(String titulo) throws RepositoryException {
        String sql = "SELECT * FROM livro WHERE titulo = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, titulo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {

                return new Livro(
                		rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("editora"),
                        rs.getString("status"),
                        rs.getInt("nota"),
                        rs.getString("anotacao"),
                        rs.getString("isbn")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
    }
        return null;
    }

    public List<Livro> buscarTodos() throws RepositoryException {
        List<Livro> livros = new ArrayList<Livro>();
        String sql = "SELECT * FROM livro";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                livros.add(new Livro(
                		rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("editora"),
                        rs.getString("status"),
                        rs.getInt("nota"),
                        rs.getString("anotacao"),
                        rs.getString("isbn")
                ));
            }
        } catch (SQLException e) {
            throw new RepositoryException("Error fetching all books", e);
        }
        return livros;
    }

    public void atualizar(Livro livro) throws RepositoryException {
        String sql = "UPDATE livro SET autor = ?, editora = ?, WHERE titulo = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, livro.getAutor());
            stmt.setString(2, livro.getEditora());
            stmt.setString(3, livro.getTitulo());
            stmt.setString(4, livro.getStatus());
            stmt.setInt(5, livro.getNota());
            stmt.setString(6, livro.getAnotacao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RepositoryException("Error updating the book", e);
        }
    }

    public void deletarLivro(int id) throws RepositoryException {
        try {
        	Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        	String sql = "DELETE FROM biblioteca.livro WHERE id = ?";
        	PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RepositoryException("Error deleting the book", e);
        }
    }
    
    public Livro buscarLivroInfo(int id) throws RepositoryException {
    	String sql = "SELECT * FROM biblioteca.livro WHERE id = ?";
    	List<Livro> livros = new ArrayList<Livro>();
        try {
        	Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        	PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
            	Livro livro = new Livro(
            			rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("editora"),
                        rs.getString("status"),
                        rs.getInt("nota"),
                        rs.getString("anotacao"),
                        rs.getString("isbn")
            			);
            	livros.add(livro);
            }
            
              
        } catch (SQLException e) {

            throw new RepositoryException("Error fetching the book by ID", e);
//            throw new RuntimeException(e.getMessage());
        }
        
        return livros.get(0);
    }
    
    public void editarLivro(Livro livroAtualizado) throws RepositoryException {
        try {
        	Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        	String sql = "UPDATE biblioteca.livro SET titulo = ?, autor = ?, editora = ?, status = ?, nota = ?, anotacao = ?, isbn = ? WHERE id = ?";
        	PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, livroAtualizado.getTitulo());
            stmt.setString(2, livroAtualizado.getAutor());
            stmt.setString(3, livroAtualizado.getEditora());
            stmt.setString(4, livroAtualizado.getStatus());
            stmt.setInt(5, livroAtualizado.getNota());
            stmt.setString(6, livroAtualizado.getAnotacao());
            stmt.setString(7, livroAtualizado.getIsbn());
            stmt.setInt(8, livroAtualizado.getId());
            System.out.println(stmt.toString());
            stmt.executeUpdate();
        } catch (SQLException e) {

            throw new repository.RepositoryException("Error updating the book", e);
        }
    }

}
