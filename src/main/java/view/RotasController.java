package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

public class RotasController {

    @FXML
    private Button btVoltar;

    @FXML
    private TableColumn<?, ?> tcDestino;

    @FXML
    private TableColumn<?, ?> tcId;

    @FXML
    private TableColumn<?, ?> tcOrigem;

    @FXML
    void acaoVoltar(ActionEvent event) {
        Stage stage = (Stage) btVoltar.getScene().getWindow(); //Obtendo a janela atual
        stage.close(); //Fechando o Stage
    }

}
