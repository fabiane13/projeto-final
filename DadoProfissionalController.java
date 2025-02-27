package com.example.controllers;

import com.example.database.Database;
import com.example.models.DadoProfissional;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;

public class DadoProfissionalController {
    @FXML private TextField txtcargo;
    @FXML private TextField txtdepartamento;
    @FXML private TextField txtfuncao;
    @FXML private TextField txtmaquina_opera;
    @FXML private TextField txtadmissao;
    @FXML private TextField txtsalario;
    @FXML private TextField txtdados_bancarios;
    @FXML private TextField txtbeneficios;
    @FXML private TextField txtescolaridade;
    @FXML private TextField txtctps;
    @FXML private TextField txtpis_pasep;
    @FXML private TextField txtcontrato;
    @FXML private TextField txthorario_trabalho;
    @FXML private TextField txtacidentes;
    @FXML private TextField txtadvertencias;
   
    @FXML private TableView<DadoProfissional> tableDadoProfissional;
    @FXML private TableColumn<DadoProfissional, Integer> colId;
    @FXML private TableColumn<DadoProfissional, String> colcargo;
    @FXML private TableColumn<DadoProfissional, String> colDepartamento;
    @FXML private TableColumn<DadoProfissional, String> colfuncao;
    @FXML private TableColumn<DadoProfissional, String> colmaquina_opera;
    @FXML private TableColumn<DadoProfissional, String> coladmissao;
    @FXML private TableColumn<DadoProfissional, String> colsalario;
    @FXML private TableColumn<DadoProfissional, String> coldados_bancarios;
    @FXML private TableColumn<DadoProfissional, String> colbeneficios;
    @FXML private TableColumn<DadoProfissional, String> colescolaridade;
    @FXML private TableColumn<DadoProfissional, String> colctps;
    @FXML private TableColumn<DadoProfissional, String> colpis_pasep;
    @FXML private TableColumn<DadoProfissional, String> colcontrato;
    @FXML private TableColumn<DadoProfissional, String> colhorario_trabalho;
    @FXML private TableColumn<DadoProfissional, String> colacidentes;
    @FXML private TableColumn<DadoProfissional, String> coladvertencias;
    

    private ObservableList<DadoProfissional> listaDadoProfissional = FXCollections.observableArrayList();

    // Campos para Atualizaçao
    @FXML private TextField txtcargoaAtualizar;
    @FXML private TextField txtdepartamentoAtualizar;
    @FXML private TextField txtfuncaoAtualizar;
    @FXML private TextField txtmaquina_operaAtualizar;
    @FXML private TextField txtsalarioAtualizar;
    @FXML private TextField txtdados_bancariosAtualizar;
    @FXML private TextField txtescolaridade;
    @FXML private TextField txtcontratoAtualizar;
    @FXML private TextField txthorario_trabalhoAtualizar;
    @FXML private TextField txtacidentesAtualizar;
    @FXML private TextField txtadvertenciasAtualizar;



    @FXML private TextField txtIdAtualizar; 
    @FXML

    private void salvarDadoProfissional() {
        String cargo = txtcargo.getText();
        String departamento = txtdepartamento.getText();
        String funcao = txtfuncao.getText();
        String maquina_opera = txtmaquina_opera.getText();
        String admissao = txtadmissao.getText();
        String salario = txtsalario.getText();
        String dados_bancarios = txtdados_bancarios.getText();
        String beneficios = txtbeneficios.getText();
        String escolaridade = txtescolaridade.getText();
        String ctps = txtctps.getText();
        String pis_pasep = txtpis_pasep.getText();
        String contrato = txtcontrato.getText();
        String horario_trabalho = txthorario_trabalho.getText();
        String acidentes = txtacidentes.getText();
        String advertencias = txtadvertencias.getText();
       

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO DadoProfissional (cargo, departamento, funcao, maquina_opera, admissao, salario, dados_bancarios, beneficios, escolaridade, ctps, pis_pasep, contrato, horario_trabalho, acidentes, advertencias) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

            stmt.setString(1, cargo);
            stmt.setString(2, departamento);
            stmt.setString(3, funcao);
            stmt.setString(4, maquina_opera);
            stmt.setString(5, admissao);
            stmt.setString(6, salario);
            stmt.setString(7, dados_bancarios);
            stmt.setString(8, beneficios);
            stmt.setString(9, escolaridade);
            stmt.setString(10, ctps);
            stmt.setString(11, pis_pasep);
            stmt.setString(12, contrato);
            stmt.setString(13, horario_trabalho);
            stmt.setString(14, acidentes);
            stmt.setString(15, advertencias);
           

            stmt.executeUpdate();
            carregarDadoProfissional();
            limparCampos();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colcargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
        coldepartamento.setCellValueFactory(new PropertyValueFactory<>("departamento"));
        colfuncaotxtfuncao.setCellValueFactory(new PropertyValueFactory<>("funcao"));
        colmaquina_opera.setCellValueFactory(new PropertyValueFactory<>("maquina_opera"));
        coladmissao.setCellValueFactory(new PropertyValueFactory<>("admissao"));
        colsalario.setCellValueFactory(new PropertyValueFactory<>("salario"));
        coldados_bancarios.setCellValueFactory(new PropertyValueFactory<>("dados_bancarios"));
        colbeneficios.setCellValueFactory(new PropertyValueFactory<>("beneficios"));
        colescolaridade.setCellValueFactory(new PropertyValueFactory<>("escolaridade"));
        colctps.setCellValueFactory(new PropertyValueFactory<>("ctps"));
        colpis_pasep.setCellValueFactory(new PropertyValueFactory<>("pis_pasep"));
        colcontrato.setCellValueFactory(new PropertyValueFactory<>("contrato"));
        colhorario_trabalho.setCellValueFactory(new PropertyValueFactory<>("horario_trabalho"));
        colacidentes.setCellValueFactory(new PropertyValueFactory<>("acidentes"));
        coladvertencias.setCellValueFactory(new PropertyValueFactory<>("advertencias"));
        colContato_Emectpsencia.setCellValueFactory(new PropertyValueFactory<>("contato_emectpsencia"));

        carregarDadoProfissional();
    }

    private void carregarDadoProfissional() {
        listaDadoProfissional.clear();
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM DadoProfissional")) {

            while (rs.next()) {
                listaDadoProfissional.add(new DadoProfissional(rs.getInt("id"), rs.getString("cargo"), rs.getString("departamento"), rs.getString("funcao"), rs.getString("maquina_opera"), rs.getString("admissao"), rs.getString("salario"), rs.getString("dados_bancarios"), rs.getString("beneficios"), rs.getString("escolaridade"), rs.getString("ctps"), rs.getString("pis_pasep"), rs.getString("contrato"), rs.getString("horario_trabalho"), rs.getString("acidentes"), rs.getString("advertencias")));
            }
            tableDadoProfissional.setItems(listaDadoProfissional);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void limparCampos() {
        txtcargo.clear();
        txtdepartamento.clear();
        txtfuncao.clear();
        txtmaquina_opera.clear();
        txtadmissao.clear();
        txtsalario.clear();
        txtdados_bancarios.clear();
        txtbeneficios.clear();
        txtescolaridade.clear();
        txtctps.clear();
        txtpis_pasep.clear();
        txtcontrato.clear();
        txthorario_trabalho.clear();
        txtacidentes.clear();
        txtadvertencias.clear();
        }

    @FXML
private void atualizarDadoProfissional() {
    try {
        int id = Integer.parseInt(txtIdAtualizar.getText());
        String cargo = txtcargoaAtualizar.getText();
        String departamento = txtdepartamentoAtualizar.getText();
        String funcao = txtfuncaoAtualizar.getText();
        String maquina_opera = txtmaquina_operaAtualizar.getText();
        String admissao = txtadmissaoAtualizar.getText();
        String salario = txtsalarioAtualizar.getText();
        String dados_bancarios = txtdados_bancariosAtualizar.getText();
        String beneficios = txtbeneficiosAtualizar.getText();
        String escolaridade = txtescolaridadeAtualizar.getText();
        String contrato = txtcontratoAtualizar.getText();
        String horario_trabalho = txthorario_trabalhoAtualizar.getText();
        String acidentes = txtacidentesAtualizar.getText();
        String advertencias = txtadvertenciasAtualizar.getText();
       



        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE DadoProfissional SET cargo = ?, departamento = ?, funcao = ?, maquina_opera = ?, salario = ?, dados_bancarios = ?, beneficios = ?, escolaridade = ?, contrato = ?, horario_trabalho = ?, acidentes = ?, advertencias = ?, WHERE id = ?")) {

            statement.setString(1, cargo);
            statement.setString(2, departamento);
            statement.setString(3, funcao);
            statement.setString(4, maquina_opera);
            statement.setString(5, salario);
            statement.setString(6, dados_bancarios);
            statement.setString(7, beneficios);
            statement.setString(8, escolaridade);
            statement.setString(9, contrato);
            statement.setString(10, horario_trabalho);
            statement.setString(11, acidentes);
            statement.setString(12, advertencias);
            statement.setInt(13, id);

            statement.executeUpdate();
            carregarDadoProfissional(); // Recarrega os dados na tabela após a atualização
            limparCamposAtualizar(); // Limpa os campos de atualização
        }
    } catch (NumberFormatException e) {
        // Lidar com erro de conversão de número (ID)
        e.printStackTrace();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("ID inválido");
        alert.setContentText("Por favor, insira um ID numérico válido.");
        alert.showAndWait();
    } catch (SQLException e) {
        // Lidar com erros de SQL
        e.printStackTrace();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Erro ao atualizar dado pessoal");
        alert.setContentText("Ocorreu um erro ao atualizar os dados no banco de dados.");
        alert.showAndWait();
    }
}

private void limparCamposAtualizar() {
    txtIdAtualizar.clear();
    txtcargoaAtualizar.clear();
    txtdepartamentoAtualizar.clear();
    txtfuncaoAtualizar.clear();
    txtmaquina_operaAtualizar.clear();
    txtsalarioAtualizar.clear();
    txtdados_bancariosAtualizar.clear();
    txtbeneficiosAtualizar.clear();
    txtescolaridade.clear();
    txtcontratoAtualizar.clear();
    txthorario_trabalhoAtualizar.clear();
    txtacidentesAtualizar.clear();
    txtadvertenciasAtualizar.clear();




}
}