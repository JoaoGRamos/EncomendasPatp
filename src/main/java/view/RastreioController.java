package view;

import dao.DAOfactory;
import dao.RastreioDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Rastreio;
import model.Remetente;
import model.Unidades;

import java.time.LocalDateTime;
import java.util.List;


public class RastreioController {

    @FXML
    private Button btPesquisar;

    @FXML
    private Button btVoltar;

    @FXML
    private TableColumn<Rastreio, LocalDateTime> tcDataEntrada;

    @FXML
    private TableColumn<Rastreio, LocalDateTime> tcDataSaida;

    @FXML
    private TableColumn<Rastreio, String> tcDestino;

    @FXML
    private TableColumn<Rastreio, String> tcLocal;

    @FXML
    private TableColumn<Rastreio, String> tcOrigem;

    @FXML
    private TableColumn<Rastreio, String> tcStatus;

    @FXML
    private TableView<Rastreio> tvRastreio;

    @FXML
    private TextField tfPesquisa;
    private ObservableList<Rastreio> obsRastreio;
    private ObservableList<Unidades> obsUnidades;

    public void initialize(){
        ListarTodos();
    }

    public void ListarTodos() {
        RastreioDAO dao = new RastreioDAO(Rastreio.class);
        List<Rastreio> list = dao.obterRastreio();
        obsRastreio = FXCollections.observableArrayList(list);
        tvRastreio.setItems(obsRastreio);

    }

    @FXML
    void acaoPesquisar(ActionEvent event) {

    }

    @FXML
    void acaoVoltar(ActionEvent event) {
        Stage stage = (Stage) btVoltar.getScene().getWindow(); //Obtendo a janela atual
        stage.close(); //Fechando o Stage

    }

}
