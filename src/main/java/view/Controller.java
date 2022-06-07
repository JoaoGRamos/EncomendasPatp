package view;

import dao.UnidadesDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Unidades;
import dao.UnidadesDAO;

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

    
}