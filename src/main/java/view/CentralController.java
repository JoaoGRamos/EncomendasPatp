package view;

import dao.DAOfactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Usuario;

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
    private MenuItem miCadEncomendas;

    @FXML
    private ImageView imageView;

    @FXML
    private MenuBar mbPrincipal;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void initialize() {
        PegarNome();

    }

    public void PegarNome(){
        Controller contr = new Controller();
        System.out.println(contr.idUnidade);
        System.out.println(contr.nomeUsuario);
        System.out.println(contr.idUnidade);
        nomeUsuario.setText("Seja Bem-Vindo " + contr.nomeUsuario);

    }

    @FXML
    void acaoCadEncomendas(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/encomendafx.fxml"));
        Stage st = new Stage();
//        stage = (Stage) mbPrincipal.getScene().getWindow();
        st.setTitle("Cadastrar Encomenda");
        st.setScene(new Scene(root));
        st.show();
    }

    @FXML
    void addDestinatario(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/destinatariofx.fxml"));
        Stage st = new Stage();
//        stage = (Stage) mbPrincipal.getScene().getWindow();
        st.setTitle("Cadastro de Destinatario");
        st.setScene(new Scene(root));
        st.show();

    }

    @FXML
    void addRemetente(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/remetentefx.fxml"));
        Stage st = new Stage();
//        stage = (Stage) mbPrincipal.getScene().getWindow();
        st.setTitle("Cadastro de Remetente");
        st.setScene(new Scene(root));
        st.show();

    }

    @FXML
    void edDestinatario(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/editardestinatariofx.fxml"));
        Stage st = new Stage();
//        stage = (Stage) mbPrincipal.getScene().getWindow();
        st.setTitle("Editar Destinatario");
        st.setScene(new Scene(root));
        st.show();

    }

    @FXML
    void edRemetente(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/editarremetentefx.fxml"));
        Stage st = new Stage();
//        stage = (Stage) mbPrincipal.getScene().getWindow();
        st.setTitle("Editar Remetente");
        st.setScene(new Scene(root));
        st.show();
    }
    @FXML
    void acaoDespache(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/despachefx.fxml"));
        Stage st = new Stage();
//        stage = (Stage) mbPrincipal.getScene().getWindow();
        st.setTitle("Cadastrar Encomenda");
        st.setScene(new Scene(root));
        st.show();
    }

    @FXML
    void acaoRastreio(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/rastreiofx.fxml"));
        Stage st = new Stage();
//        stage = (Stage) mbPrincipal.getScene().getWindow();
        st.setTitle("Rastrear Encomendas");
        st.setScene(new Scene(root));
        st.show();
    }

    @FXML
    void acaoRotas(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/rotasfx.fxml"));
        Stage st = new Stage();
//        stage = (Stage) mbPrincipal.getScene().getWindow();
        st.setTitle("Rotas");
        st.setScene(new Scene(root));
        st.show();
    }

    @FXML
    void acaoSobre(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/sobrefx.fxml"));
        Stage st = new Stage();
//        stage = (Stage) mbPrincipal.getScene().getWindow();
        st.setTitle("Sobre Rastreio de Encomendas");
        st.setScene(new Scene(root));
        st.show();
    }
}
