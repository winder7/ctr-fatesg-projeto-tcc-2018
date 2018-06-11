package br.com.marcosviniciusti.projetotcc.entities;

public class Auth {

    private String id;
    private String nome;
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if (email != null || !email.isEmpty()) this.email = email;
        else throw new Exception("O e-mail é obrigatório.");
    }
}