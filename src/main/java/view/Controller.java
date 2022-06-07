package view;

import dao.UnidadesDAO;
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
import model.Unidades;
import dao.UnidadesDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML
    private Label label;

    @FXML
    private Button btEntrar;

    @FXML
    private ComboBox<Unidades> cbUnidades;

    private List<Unidades> unidades = new ArrayList<>();
    private Stage stage;
    private Scene scene;
    private Parent root;

    private ObservableList<Unidades> obsUnidades;

    public void initialize() {
       carregarUnidades();
    }

    public void ListarTodos() {
        UnidadesDAO unid = new UnidadesDAO();
        List<Unidades> list = unid.obterTodos();
        obsUnidades = FXCollections.observableArrayList(list);
        cbUnidades.setItems(obsUnidades);
    }

    public void carregarUnidades() {

        ListarTodos();

    }

    @FXML
    void acaoBotao(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/centralfx.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Rastreio de Encomendas");
        stage.setScene(new Scene(root));
        stage.show();

    }

}