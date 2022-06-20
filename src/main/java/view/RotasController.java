package view;

import dao.RotasDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.RotasListagem;

import java.util.List;

public class RotasController {

    @FXML
    private Button btVoltar;

    @FXML
    private TableColumn<RotasListagem, String> tcDestino;

    @FXML
    private TableColumn<RotasListagem, Integer> tcId;

    @FXML
    private TableColumn<RotasListagem, String> tcOrigem;

    @FXML
    private TableView<RotasListagem> tvRotas;

    private ObservableList<RotasListagem> obsRotas;

    public void initialize(){
        listarTodos();
    }

    public void listarTodos(){
        tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcOrigem.setCellValueFactory(new PropertyValueFactory<>("unidadeOrigem"));
        tcDestino.setCellValueFactory(new PropertyValueFactory<>("unidadeDestino"));
        RotasDAO dao = new RotasDAO(RotasListagem.class);
        List<RotasListagem> list = dao.obterRotas();
        obsRotas = FXCollections.observableArrayList(list);
        tvRotas.setItems(obsRotas);
    }

    @FXML
    void acaoVoltar(ActionEvent event) {
        Stage stage = (Stage) btVoltar.getScene().getWindow(); //Obtendo a janela atual
        stage.close(); //Fechando o Stage
    }

}
