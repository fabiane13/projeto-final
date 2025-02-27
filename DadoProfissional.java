package com.example.models;

public class DadoProfissional {
    private String cargo;
    private String departamento;
    private String funcao;
    private String maquina_opera;
    private String admissao;
    private String salario;
    private String dados_bancarios;
    private String beneficios;
    private String escolaridade;
    private String ctps;
    private String pis_pasep;
    private String contrato;
    private String horario_trabalho;
    private String acidentes;
    private String advertencias;

    public DadoProfissional(String cargo, String departamento, String funcao,  String maquina_opera, String admissao, String salario, String dados_bancarios, String beneficios,
    String escolaridade, String ctps, String pis_pasep, String contrato, String horario_trabalho, String acidentes, String advertencias) {
        this.cargo = cargo;
        this.departamento = departamento;
        this.funcao = funcao;
        this.maquina_opera = maquina_opera;
        this.admissao = admissao;
        this.salario = salario;
        this.dados_bancarios = dados_bancarios;
        this.beneficios = beneficios;
        this.escolaridade = escolaridade;
        this.ctps = ctps;
        this.pis_pasep = pis_pasep;
        this.contrato = contrato;
        this.horario_trabalho = horario_trabalho;
        this.acidentes = acidentes;
        this.advertencias = advertencias;
}

public String getCargo() {
    return cargo;
}

public String getDepartamento() {
    return departamento;
}

public String getFuncao() {
    return funcao;
}

public String getMaquina_opera() {
    return maquina_opera;
}

public String getAdmissao(){
    return admissao;
}

public String getSalario() {
    return salario;
}

public String getDados_bancarios() {
    return dados_bancarios;
}

public String getBeneficios() {
    return beneficios;
}

public String getEscolaridade() {
    return escolaridade;
}

public String getCtps() {
    return ctps;
}

public String pis_pasep() {
    return pis_pasep;
}

public String getContrato() {
    return contrato;
}

public String getHorario_trabalho() {
    return horario_trabalho;
}

public String getAcidentes() {
    return acidentes;
}

public String getAdvertencia() {
    return advertencias;
}

}
