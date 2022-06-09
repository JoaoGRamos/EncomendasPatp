/*Mudar classe para Cadastro e renomear "Encomendas", o despache é onde a magica do programa vai
* acontecer.*/

package view;

import dao.DAOfactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Destinatario;
import model.Encomendas;
import model.Remetente;
import model.Unidades;

import java.io.IOException;
import java.util.List;
import java.time.LocalDate;

public class DespacheController {
    @FXML
    private Button btCadDestinatario;

    @FXML
    private Button btCadRemetente;

    @FXML
    private Button btCancelar;

    @FXML
    private Button btSalvar;

    @FXML
    private ComboBox<Destinatario> cbDestinatario;

    @FXML
    private ComboBox<Unidades> cbDestino;

    @FXML
    private ComboBox<Remetente> cbRemetente;

    @FXML
    private DatePicker dpDataPost;

    private ObservableList<Destinatario> obsDestinatario;
    private ObservableList<Remetente> obsRemetente;
    private ObservableList<Unidades> obsUnidades;
    private Integer idDestino = 0, idDestinatario = 0, idRemetente = 0;
    private LocalDate data;

    @FXML
    public void initialize(){
        CarregarTodos();
        PegarData();
        System.out.println(data);
    }

    public void PegarData(){
        data = LocalDate.now();
    }

    public void ListarTodos() {
        DAOfactory daoR = new DAOfactory(Remetente.class);
        DAOfactory daoD = new DAOfactory(Destinatario.class);
        DAOfactory daoU = new DAOfactory(Unidades.class);
        List<Destinatario> list = daoD.obterTodos();
        List<Remetente> list2 = daoR.obterTodos();
        List<Unidades> list3 = daoU.obterTodos();
        obsDestinatario = FXCollections.observableArrayList(list);
        obsRemetente = FXCollections.observableArrayList(list2);
        obsUnidades = FXCollections.observableArrayList(list3);
    }

    public void CarregarTodos(){
        ListarTodos();
        cbDestinatario.setItems(obsDestinatario);
        cbDestino.setItems(obsUnidades);
        cbRemetente.setItems(obsRemetente);
    }

    @FXML
    void acaoCadDestinatario(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/destinatariofx.fxml"));
        Stage st = new Stage();
        st.setTitle("Cadastro de Destinatario");
        st.setScene(new Scene(root));
        st.show();
    }

    @FXML
    void acaoCadRemetente(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/remetentefx.fxml"));
        Stage st = new Stage();
        st.setTitle("Cadastro de Remetente");
        st.setScene(new Scene(root));
        st.show();
    }

    @FXML
    void acaoDestinatario(ActionEvent event) {
        DAOfactory daoD = new DAOfactory(Destinatario.class);
        int e1 = cbDestinatario.getSelectionModel().getSelectedIndex();
        Destinatario id = (Destinatario) cbDestinatario.getItems().get(e1);
        idDestinatario = id.getId();
        System.out.println(idDestinatario);

    }

    @FXML
    void acaoDestino(ActionEvent event) {
        DAOfactory daoU = new DAOfactory(Unidades.class);
        int e1 = cbDestino.getSelectionModel().getSelectedIndex();
        Unidades id = (Unidades) cbDestino.getItems().get(e1);
        idDestino = id.getCodigo();
        System.out.println(idDestino);
    }

    @FXML
    void acaoRemetente(ActionEvent event) {
        DAOfactory daoR = new DAOfactory(Remetente.class);
        int e1 = cbRemetente.getSelectionModel().getSelectedIndex();
        Remetente id = (Remetente) cbRemetente.getItems().get(e1);
        idRemetente = id.getId();
        System.out.println(idRemetente);
    }

    @FXML
    void acaoSalvar(ActionEvent event) throws IOException {
        if (!(idDestino == 0 || idRemetente == 0 || idDestinatario == 0)){
            try {
                DAOfactory<Encomendas> dao = new DAOfactory<>(Encomendas.class);
                Encomendas r1 = new Encomendas();

                r1.setDestino(idDestino);
                r1.setRemetente(idRemetente);
                r1.setDestinatario(idDestinatario);
                r1.setDataPostagem(data);
                r1.setOrigem(idDestino);
                r1.setDataEntregaPrev(data);
                r1.setDataEntregaReal(data);
                dao.incluirAtomico(r1);


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
    void acaoCancelar(ActionEvent event) {
        Stage stage = (Stage) btCancelar.getScene().getWindow(); //Obtendo a janela atual
        stage.close(); //Fechando o Stage

    }


}
