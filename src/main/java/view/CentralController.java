package view;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class CentralController {

    @FXML
    private MenuItem miAddDestinatario;

    @FXML
    private MenuItem miAddRemetente;

    @FXML
    private MenuItem miEdDestinatario;

    @FXML
    private MenuItem miEdRemetente;

    @FXML
    private Label nomeUsuario;

    private Stage stage;
    private Scene scene;
    private Parent root;
   @FXML
    private MenuBar mbPrincipal;


    @FXML
    void addDestinatario(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/destinatariofx.fxml"));
        stage = (Stage) mbPrincipal.getScene().getWindow();
        stage.setTitle("Cadastro de Destinatario!");
        stage.setScene(new Scene(root));
        stage.show();

    }

    @FXML
    void addRemetente(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/remetentefx.fxml"));
        stage = (Stage) mbPrincipal.getScene().getWindow();
        stage.setTitle("Cadastro de Remetente!");
        stage.setScene(new Scene(root));
        stage.show();

    }

    @FXML
    void edDestinatario(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/editardestinatariofx.fxml"));
        stage = (Stage) mbPrincipal.getScene().getWindow();
        stage.setTitle("Editar Destinatario!");
        stage.setScene(new Scene(root));
        stage.show();

    }

    @FXML
    void edRemetente(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/editarremetentefx.fxml"));
        stage = (Stage) mbPrincipal.getScene().getWindow();
        stage.setTitle("Editar Remetente!");
        stage.setScene(new Scene(root));
        stage.show();
    }

}
