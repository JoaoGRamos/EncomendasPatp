package view;

import dao.RastreioDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.RastreioListagem;

import java.util.List;


public class RastreioController {
    @FXML
    private Button btAtualizar;
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

    public void initialize(){
        ListarTodos();
    }

    public void ListarTodos() {
        tcCodigo.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcOrigem.setCellValueFactory(new PropertyValueFactory<>("origem"));
        tcDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));
        tcStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        tcDataEntrada.setCellValueFactory(new PropertyValueFactory<>("dataHoraEntrada"));
        tcDataSaida.setCellValueFactory(new PropertyValueFactory<>("dataHoraSaida"));
        tcLocal.setCellValueFactory(new PropertyValueFactory<>("localizacao"));
        RastreioDAO dao = new RastreioDAO(RastreioListagem.class);
        List<RastreioListagem> list = dao.obterRastreio();
        obsRastreio = FXCollections.observableArrayList(list);
        tvRastreio.setItems(obsRastreio);
    }

    @FXML
    void acaoPesquisar(ActionEvent event) {
        tcCodigo.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcOrigem.setCellValueFactory(new PropertyValueFactory<>("origem"));
        tcDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));
        tcStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        tcDataEntrada.setCellValueFactory(new PropertyValueFactory<>("dataHoraEntrada"));
        tcDataSaida.setCellValueFactory(new PropertyValueFactory<>("dataHoraSaida"));
        tcLocal.setCellValueFactory(new PropertyValueFactory<>("localizacao"));
        RastreioDAO dao = new RastreioDAO(RastreioListagem.class);
        Integer id = Integer.valueOf(tfPesquisa.getText());
        RastreioListagem result = dao.pesquisarRastreio(id);
        obsRastreio = FXCollections.observableArrayList(result);
        tvRastreio.setItems(obsRastreio);
    }

    @FXML
    void acaoAtualizar(ActionEvent event) {
        ListarTodos();
    }
    @FXML
    void acaoVoltar(ActionEvent event) {
        Stage stage = (Stage) btVoltar.getScene().getWindow(); //Obtendo a janela atual
        stage.close(); //Fechando o Stage

    }

}
