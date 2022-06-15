package view;

import dao.DAOfactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.DadosUsuario;
import model.Usuario;


import java.io.IOException;
import java.util.List;

public class Controller {

    @FXML
    private Label label;

    @FXML
    private Button btEntrar;

    @FXML
    private ComboBox<Usuario> cbUsuario;

    private Stage stage;


    private ObservableList<Usuario> obsUsuarios;

    public void initialize() {
       carregarUsuarios();
    }



    public void ListarTodos() {
        DAOfactory dao = new DAOfactory(Usuario.class);
        List<Usuario> list = dao.obterTodos();
        obsUsuarios = FXCollections.observableArrayList(list);
        cbUsuario.setItems(obsUsuarios);
    }

    public void carregarUsuarios() {
        ListarTodos();

    }

    @FXML
    void acaoBotao(ActionEvent event) throws IOException {
        if ((cbUsuario.getSelectionModel().getSelectedIndex() >= 0)) {
            int e1 = cbUsuario.getSelectionModel().getSelectedIndex();
            Usuario usuario = (Usuario)cbUsuario.getItems().get(e1);
            DadosUsuario usuarioSelecionado = DadosUsuario.getInstance(usuario);

            Parent root = FXMLLoader.load(getClass().getResource("/view/centralfx.fxml"));

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Super Encomendas");
            stage.setScene(new Scene(root));
            stage.show();

        } else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Aviso");
            alerta.setHeaderText("Selecione um usuario para entrar!");
            alerta.show();
        }
    }

}