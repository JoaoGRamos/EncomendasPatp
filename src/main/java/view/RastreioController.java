package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RastreioController {

    @FXML
    private Button btPesquisar;

    @FXML
    private Button btVoltar;

    @FXML
    private TableColumn<?, ?> tcDataEntrada;

    @FXML
    private TableColumn<?, ?> tcDataSaida;

    @FXML
    private TableColumn<?, ?> tcDestino;

    @FXML
    private TableColumn<?, ?> tcLocal;

    @FXML
    private TableColumn<?, ?> tcOrigem;

    @FXML
    private TableColumn<?, ?> tcStatus;

    @FXML
    private TextField tfPesquisa;

    @FXML
    void acaoPesquisar(ActionEvent event) {

    }

    @FXML
    void acaoVoltar(ActionEvent event) {
        Stage stage = (Stage) btVoltar.getScene().getWindow(); //Obtendo a janela atual
        stage.close(); //Fechando o Stage

    }

}
