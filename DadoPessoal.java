package com.example.models;

public class DadoPessoal {
    private int id;
    private String nome_completo;
    private String data_nascimento;
    private String sexo;
    private String estado_civil;
    private String conjuge;
    private String dependentes;
    private String nacionalidade;
    private String naturalidade;
    private String cpf;
    private String rg;
    private String endereco;
    private String telefone;
    private String email;
    private String filiacao;
    private String tipo_sanguineo;
    private String contato_emergencia;

    public DadoPessoal(int id, String nome_completo, String data_nascimento, String sexo,  String estado_civil, String conjuge, String dependentes, String nacionalidade, String naturalidade,
    String cpf, String rg, String endereco, String telefone, String email, String filiacao, String tipo_sanguineo, String contato_emergencia) {
        this.id = id;
        this.nome_completo = nome_completo;
        this.data_nascimento = data_nascimento;
        this.sexo = sexo;
        this.estado_civil = estado_civil;
        this.conjuge = conjuge;
        this.dependentes = dependentes;
        this.nacionalidade = nacionalidade;
        this.naturalidade = naturalidade;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.filiacao = filiacao;
        this.tipo_sanguineo = tipo_sanguineo;
        this.contato_emergencia = contato_emergencia;
}

public int getId() {
    return id;
}

public String getNome_completo() {
    return nome_completo;
}

public String getData_nascimento() {
    return data_nascimento;
}

public String getSexo() {
    return sexo;
}

public String getEstado_civil() {
    return estado_civil;
}

public String getConjuge() {
    return conjuge;
}

public String getDependentes(){
    return dependentes;
}

public String getNacionalidade() {
    return nacionalidade;
}

public String getNaturalidade() {
    return naturalidade;
}

public String getCpf(){
    return cpf;
}

public String getRg() {
    return rg;
}

public String getEndereco() {
    return endereco;
}

public String getTelefone(){
    return telefone;
}

public String getEmail(){
    return email;
}

public String getFiliacao() {
    return filiacao;
}

public String getTipo_sanguineo(){
    return tipo_sanguineo;
}

public String getContato_emergencia() {
    return contato_emergencia;
}

}
