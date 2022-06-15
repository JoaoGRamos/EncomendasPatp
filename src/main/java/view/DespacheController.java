package view;

import dao.DAOfactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.DadosUsuario;
import model.Encomendas;
import model.Rastreio;
import model.Status;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class DespacheController {

    @FXML
    private Button btCancelar;

    @FXML
    private Button btSalvar;

    @FXML
    private ComboBox<Encomendas> cbEncomenda;

    @FXML
    private ComboBox<Status> cbStatus;

    @FXML
    private DatePicker dpDataCheg;

    @FXML
    private TextField tfId;

    private int vEncomenda = 0, vStatus = 0;

    private ObservableList<Rastreio> obsRastreio;
    private ObservableList<Encomendas> obsEncomendas;
    private ObservableList<Status> obsStatus;

    @FXML
    public void initialize(){
        CarregarTodos();
    }

    public void ListarTodos(){
        DAOfactory daoR = new DAOfactory(Rastreio.class);
        DAOfactory daoE = new DAOfactory(Encomendas.class);
        DAOfactory daoS = new DAOfactory(Status.class);
        List<Status> listS = daoS.obterTodos();
        List<Rastreio> listR = daoR.obterTodos();
        List<Encomendas> listE = daoE.obterTodos();
        obsRastreio = FXCollections.observableArrayList(listR);
        obsEncomendas = FXCollections.observableArrayList(listE);
//        private String[] status = {"Em tratamento", "Em transito","Recebido na unidade","Saiu para entrega","Entregue"};
//        List<Status> listSS = new ArrayList<>();
//        listSS.add(1, new Status(1, "Em transito"));
        obsStatus = FXCollections.observableArrayList(listS);
    }

    @FXML
    public void CarregarTodos(){

        ListarTodos();
        cbStatus.setItems(obsStatus);
        cbEncomenda.setItems(obsEncomendas);
    }

    @FXML
    void acaoCancelar(ActionEvent event) {
        Stage stage = (Stage) btCancelar.getScene().getWindow();
        stage.close();
    }

    @FXML
    void acaoEncomenda(ActionEvent event) {

    }

    @FXML
    void acaoSalvar(ActionEvent event) {
        if (!(vEncomenda == 0 || vStatus == 0)){
            try {
                DAOfactory<Rastreio> dao = new DAOfactory<>(Rastreio.class);
                Rastreio r1 = new Rastreio();
                DadosUsuario usuarioSelecionado = DadosUsuario.getInstance(null);

                r1.setId(parseInt(tfId.getText()));
//                r1.setStatus();
                dao.editar(r1);


                Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                alerta.setTitle("Aviso");
                alerta.setHeaderText("Dados salvos com sucesso!");
                alerta.show();

            } catch (Exception e) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Aviso");
                alerta.setHeaderText("Os dados não foram salvos no banco!");
                alerta.show();
            }

        }
        else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Aviso");
            alerta.setHeaderText("Os dados não foram salvos no banco!");
            alerta.setContentText("Nenhum campo deve estar vazio!");
            alerta.show();

        }

    }

    @FXML
    void acaoStatus(ActionEvent event) {

    }

}
