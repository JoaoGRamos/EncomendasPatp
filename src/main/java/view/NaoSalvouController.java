package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class NaoSalvouController {

    @FXML
    private Button btOk;

    @FXML
    void acaoOk(ActionEvent event) throws IOException {
        Stage stage = (Stage) btOk.getScene().getWindow(); //Obtendo a janela atual
        stage.close(); //Fechando o Stage

        Parent root = FXMLLoader.load(getClass().getResource("/view/centralfx.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Rastreio de Encomendas");
        stage.setScene(new Scene(root));
        stage.show();
    }

}
