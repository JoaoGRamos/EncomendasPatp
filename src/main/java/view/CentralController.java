package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import java.io.File;
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
    private MenuItem miDespache;

    @FXML
    private MenuItem miRastreio;

    @FXML
    private MenuItem miRotas;

    @FXML
    private MenuItem miSobre;

    @FXML
    private Label nomeUsuario;

    @FXML
    private ImageView img;
    @FXML
    private MenuBar mbPrincipal;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void initialize() {
        File file = new File("logotop.png");
        Image image = new Image(file.toURI().toString());
        img.setImage(image);
    }

    @FXML
    void addDestinatario(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/destinatariofx.fxml"));
        Stage st = new Stage();
//        stage = (Stage) mbPrincipal.getScene().getWindow();
        st.setTitle("Cadastro de Destinatario!");
        st.setScene(new Scene(root));
        st.show();

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
    @FXML
    void acaoDespache(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/despachefx.fxml"));
        stage = (Stage) mbPrincipal.getScene().getWindow();
        stage.setTitle("Editar Remetente!");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void acaoRastreio(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/rastreiofx.fxml"));
        stage = (Stage) mbPrincipal.getScene().getWindow();
        stage.setTitle("Editar Remetente!");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void acaoRotas(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/rotasfx.fxml"));
        stage = (Stage) mbPrincipal.getScene().getWindow();
        stage.setTitle("Editar Remetente!");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void acaoSobre(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/sobrefx.fxml"));
        stage = (Stage) mbPrincipal.getScene().getWindow();
        stage.setTitle("Editar Remetente!");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
