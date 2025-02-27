package com.example.controllers;

import com.example.database.Database;
import com.example.models.DadoPessoal;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;

public class DadoPessoalController {
    @FXML private TextField txtnome_completo;
    @FXML private TextField txtdatanascimento;
    @FXML private TextField txtsexo;
    @FXML private TextField txtestado_civil;
    @FXML private TextField txtconjuge;
    @FXML private TextField txtdependentes;
    @FXML private TextField txtnacionalidade;
    @FXML private TextField txtnaturalidade;
    @FXML private TextField txtcpf;
    @FXML private TextField txtrg;
    @FXML private TextField txtendereco;
    @FXML private TextField txttelefone;
    @FXML private TextField txtemail;
    @FXML private TextField txtfiliacao;
    @FXML private TextField txttipo_sanguineo;
    @FXML private TextField txtcontato_emergencia;

    @FXML private TableView<DadoPessoal> tableDadoPessoal;
    @FXML private TableColumn<DadoPessoal, Integer> colId;
    @FXML private TableColumn<DadoPessoal, String> colNome;
    @FXML private TableColumn<DadoPessoal, String> colDataNascimento;
    @FXML private TableColumn<DadoPessoal, String> colSexo;
    @FXML private TableColumn<DadoPessoal, String> colEstado_Civil;
    @FXML private TableColumn<DadoPessoal, String> colConjuge;
    @FXML private TableColumn<DadoPessoal, String> colDependentes;
    @FXML private TableColumn<DadoPessoal, String> colNacionalidade;
    @FXML private TableColumn<DadoPessoal, String> colNaturalidade;
    @FXML private TableColumn<DadoPessoal, String> colCpf;
    @FXML private TableColumn<DadoPessoal, String> colRg;
    @FXML private TableColumn<DadoPessoal, String> colEndereco;
    @FXML private TableColumn<DadoPessoal, String> colTelefone;
    @FXML private TableColumn<DadoPessoal, String> colEmail;
    @FXML private TableColumn<DadoPessoal, String> colFiliacao;
    @FXML private TableColumn<DadoPessoal, String> colTipo_Sanguineo;
    @FXML private TableColumn<DadoPessoal, String> colContato_Emergencia;

    private ObservableList<DadoPessoal> listaDadoPessoal = FXCollections.observableArrayList();

    // Campos para Atualizaçao
    @FXML private TextField txtEstado_CivilAtualizar;
    @FXML private TextField txtConjugeAtualizar;
    @FXML private TextField txtDependentesAtualizar;
    @FXML private TextField txtEnderecoAtualizar;
    @FXML private TextField txtTelefoneAtualizar;
    @FXML private TextField txtEmailAtualizar;
    @FXML private TextField txtContato_EmergenciaAtualizar;
    @FXML private TextField txtIdAtualizar; 
    @FXML

    private void salvarDadoPessoal() {
        String nome = txtnome_completo.getText();
        String datanascimento = txtdatanascimento.getText();
        String sexo = txtsexo.getText();
        String estado_civil = txtestado_civil.getText();
        String conjuge = txtconjuge.getText();
        String dependentes = txtdependentes.getText();
        String nacionalidade = txtnacionalidade.getText();
        String naturalidade = txtnaturalidade.getText();
        String cpf = txtcpf.getText();
        String rg = txtrg.getText();
        String endereco = txtendereco.getText();
        String telefone = txttelefone.getText();
        String email = txtemail.getText();
        String filiacao = txtfiliacao.getText();
        String tipo_sanguineo = txttipo_sanguineo.getText();
        String contato_emergencia = txtcontato_emergencia.getText();

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO dadopessoal (nome, datanascimento, sexo, estado_civil, conjuge, dependentes, nacionalidade, naturalidade, cpf, rg, endereco, telefone, email, filiacao, tipo_sanguineo, contato_emergencia) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

            stmt.setString(1, nome);
            stmt.setString(2, datanascimento);
            stmt.setString(3, sexo);
            stmt.setString(4, estado_civil);
            stmt.setString(5, conjuge);
            stmt.setString(6, dependentes);
            stmt.setString(7, nacionalidade);
            stmt.setString(8, naturalidade);
            stmt.setString(9, cpf);
            stmt.setString(10, rg);
            stmt.setString(11, endereco);
            stmt.setString(12, telefone);
            stmt.setString(13, email);
            stmt.setString(14, filiacao);
            stmt.setString(15, tipo_sanguineo);
            stmt.setString(16, contato_emergencia);

            stmt.executeUpdate();
            carregarDadoPessoal();
            limparCampos();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colDataNascimento.setCellValueFactory(new PropertyValueFactory<>("datanascimento"));
        colSexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        colEstado_Civil.setCellValueFactory(new PropertyValueFactory<>("estado_civil"));
        colConjuge.setCellValueFactory(new PropertyValueFactory<>("conjuge"));
        colDependentes.setCellValueFactory(new PropertyValueFactory<>("dependentes"));
        colNacionalidade.setCellValueFactory(new PropertyValueFactory<>("nacionalidade"));
        colNaturalidade.setCellValueFactory(new PropertyValueFactory<>("naturalidade"));
        colCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colRg.setCellValueFactory(new PropertyValueFactory<>("rg"));
        colEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        colTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colFiliacao.setCellValueFactory(new PropertyValueFactory<>("filiacao"));
        colTipo_Sanguineo.setCellValueFactory(new PropertyValueFactory<>("tipo_sanguineo"));
        colContato_Emergencia.setCellValueFactory(new PropertyValueFactory<>("contato_emergencia"));

        carregarDadoPessoal();
    }

    private void carregarDadoPessoal() {
        listaDadoPessoal.clear();
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM dadopessoal")) {

            while (rs.next()) {
                listaDadoPessoal.add(new DadoPessoal(rs.getInt("id"), rs.getString("nome"), rs.getString("datanascimento"), rs.getString("sexo"), rs.getString("estado_civil"), rs.getString("conjuge"), rs.getString("dependentes"), rs.getString("nacionalidade"), rs.getString("naturalidade"), rs.getString("cpf"), rs.getString("rg"), rs.getString("endereco"), rs.getString("telefone"), rs.getString("email"), rs.getString("filiacao"), rs.getString("tipo_sanguineo"), rs.getString("contato_emergencia")));
            }
            tableDadoPessoal.setItems(listaDadoPessoal);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void limparCampos() {
        txtnome_completo.clear();
        txtdatanascimento.clear();
        txtsexo.clear();
        txtestado_civil.clear();
        txtconjuge.clear();
        txtdependentes.clear();
        txtnacionalidade.clear();
        txtnaturalidade.clear();
        txtcpf.clear();
        txtrg.clear();
        txtendereco.clear();
        txttelefone.clear();
        txtemail.clear();
        txtfiliacao.clear();
        txttipo_sanguineo.clear();
        txtcontato_emergencia.clear();
    }

    @FXML
private void atualizarDadoPessoal() {
    try {
        int id = Integer.parseInt(txtIdAtualizar.getText());
        String estadoCivil = txtEstado_CivilAtualizar.getText();
        String conjuge = txtConjugeAtualizar.getText();
        String dependentes = txtDependentesAtualizar.getText();
        String endereco = txtEnderecoAtualizar.getText();
        String telefone = txtTelefoneAtualizar.getText();
        String email = txtEmailAtualizar.getText();
        String contatoEmergencia = txtContato_EmergenciaAtualizar.getText();

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE dadopessoal SET estado_civil = ?, conjuge = ?, dependentes = ?, endereco = ?, telefone = ?, email = ?, contato_emergencia = ? WHERE id = ?")) {

            statement.setString(1, estadoCivil);
            statement.setString(2, conjuge);
            statement.setString(3, dependentes);
            statement.setString(4, endereco);
            statement.setString(5, telefone);
            statement.setString(6, email);
            statement.setString(7, contatoEmergencia);
            statement.setInt(8, id);

            statement.executeUpdate();
            carregarDadoPessoal(); // Recarrega os dados na tabela após a atualização
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
    txtEstado_CivilAtualizar.clear();
    txtConjugeAtualizar.clear();
    txtDependentesAtualizar.clear();
    txtEnderecoAtualizar.clear();
    txtTelefoneAtualizar.clear();
    txtEmailAtualizar.clear();
    txtContato_EmergenciaAtualizar.clear();
}
}