package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Sobrefx {

    @FXML
    private Button btOk;

    @FXML
    void acaoOk(ActionEvent event) {
        Stage stage = (Stage) btOk.getScene().getWindow(); //Obtendo a janela atual
        stage.close(); //Fechando o Stage

    }

}