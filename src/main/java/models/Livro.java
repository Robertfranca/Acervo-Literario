package models;

public class Livro {
	public int id;
    private String titulo;
    private String autor;
    private String editora;
    private String status;
    private int nota;
    private String anotacao;
    private String isbn;

    //Construtor

    public Livro(int id, String titulo, String autor, String editora, String status, int nota, String anotacao, String isbn) {
    	this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.status = status;
        this.nota = nota;
        this.anotacao = anotacao;
        this.isbn = isbn;
    }

    //Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getAnotacao() {
        return anotacao;
    }

    public void setAnotacao(String anotacao) {
        this.anotacao = anotacao;
    }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /*@Override
    public String toString() {
        return "Livro{" +
        		"id='" + id + '\'' + 
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editora='" + editora + '\'' +
                ", status=" + status +
                ", nota=" + nota +
                ", anotacao='" + anotacao + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }*/


}
