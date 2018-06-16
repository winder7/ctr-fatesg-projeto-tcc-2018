package br.com.senai.ctr.model;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.List;

public class Modelo implements IEntidade {

    private String id;
    private String nome;
    private Marca marca;
    private EnumTipoEquipamento tipo;
    private HashMap<String, Comando> comandos;

    @Exclude
    @Override
    public String getId() {
        return id;
    }

    @Override
    public Modelo setId(String id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Modelo setNome(String nome) {
        this.nome = nome;
        return this;
    }

    @Exclude
    public Marca getMarca() {
        return marca;
    }

    public Modelo setMarca(Marca marca) {
        this.marca = marca;
        return this;
    }

    @Exclude
    public EnumTipoEquipamento getTipo() {
        return tipo;
    }

    public Modelo setTipo(EnumTipoEquipamento tipo) {
        this.tipo = tipo;
        return this;
    }

    public HashMap<String, Comando> getComandos() {
        return comandos;
    }

    public Modelo setComandos(HashMap<String, Comando> comandos) {
        this.comandos = comandos;
        return this;
    }
}
