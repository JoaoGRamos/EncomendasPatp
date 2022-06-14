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
import model.RastreioListagem;
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
    private TableColumn<RastreioListagem, String> tcCodigo;

    @FXML
    private TableColumn<RastreioListagem, String> tcDataEntrada;

    @FXML
    private TableColumn<RastreioListagem, String> tcDataSaida;

    @FXML
    private TableColumn<RastreioListagem, String> tcDestino;

    @FXML
    private TableColumn<RastreioListagem, String> tcLocal;

    @FXML
    private TableColumn<RastreioListagem, String> tcOrigem;

    @FXML
    private TableColumn<RastreioListagem, String> tcStatus;

    @FXML
    private TableView<RastreioListagem> tvRastreio;

    @FXML
    private TextField tfPesquisa;
    private ObservableList<RastreioListagem> obsRastreio;
    private ObservableList<Unidades> obsUnidades;

    public void initialize(){
        ListarTodos();
    }

    public void ListarTodos() {
        RastreioDAO dao = new RastreioDAO(RastreioListagem.class);
        List<RastreioListagem> list = dao.obterRastreio();
        obsRastreio = FXCollections.observableArrayList(list);
        tvRastreio.setItems(obsRastreio);
        System.out.println(obsRastreio);
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
