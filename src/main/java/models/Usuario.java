package models;

 public class Usuario {
    private String nome;
    private String email;
    private String cpf;
    private String senha;

 public Usuario(String nome, String email, String cpf, String senha) {
    this.nome = nome;
    this.email = email;
    this.cpf = cpf;
    this.senha = senha;
  }
 }

 public String getNome() {
    return nome;
 }

 public String getEmail() {
	return email;
}

public String getCpf() {
	return cpf;
}

public String getSenha() {
	return senha;
}