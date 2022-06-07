package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Unidades;

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

    public void carregarUnidades() {
        Unidades unidade = new Unidades();

        unidade.getDescricao();

        unidades.add(unidade);

        obsUnidades = FXCollections.observableArrayList(unidade);

        cbUnidades.setItems(obsUnidades);
    }

    
}