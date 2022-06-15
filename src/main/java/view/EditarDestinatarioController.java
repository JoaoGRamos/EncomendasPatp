package view;

import dao.DestinatarioDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Destinatario;


import java.io.IOException;
import java.util.List;

import static java.lang.Integer.parseInt;

public class EditarDestinatarioController {

    @FXML
    private Button btCancelar;

    @FXML
    private Button btSalvar;

    @FXML
    private ComboBox<Destinatario> cbID;

    @FXML
    private TextField tfCpf;

    @FXML
    private TextField tfEndereco;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfTelefone;

    @FXML
    private TextField tfId;


    private ObservableList<Destinatario> obsDestinatario;
    @FXML
    public void initialize() {
        carregarDestino();
    }

    public void ListarTodos() {
        DestinatarioDAO dao = new DestinatarioDAO(Destinatario.class);
        List<Destinatario> list = dao.obterTodos();
        obsDestinatario = FXCollections.observableArrayList(list);

    }

    public void carregarDestino(){
        ListarTodos();
        cbID.setItems(obsDestinatario);
    }

    @FXML
    void selecionarId(ActionEvent event) {
        DestinatarioDAO dao = new DestinatarioDAO(Destinatario.class);
        int e1 = cbID.getSelectionModel().getSelectedIndex();
        Destinatario id = (Destinatario)cbID.getItems().get(e1);
        tfId.setText(String.valueOf(id.getId()));
        tfNome.setText(id.getNome());
        tfCpf.setText(id.getCpf());
        tfTelefone.setText(id.getTelefone());
        tfEndereco.setText(id.getEndereco());

    }

    @FXML
    void acaoCancelar(ActionEvent event) throws IOException {
        Stage stage = (Stage) btCancelar.getScene().getWindow(); //Obtendo a janela atual
        stage.close(); //Fechando o Stage

    }

    @FXML
    void acaoSalvar(ActionEvent event) throws IOException{

        if (!(tfNome.getText() == "" || tfCpf.getText() == "" || tfTelefone.getText() == "")){
            try {

                DestinatarioDAO dao = new DestinatarioDAO(Destinatario.class);
                Destinatario r1 = new Destinatario();

                r1.setId(parseInt(tfId.getText()));
                r1.setNome(tfNome.getText());
                r1.setCpf(tfCpf.getText());
                r1.setTelefone(tfTelefone.getText());
                r1.setEndereco(tfEndereco.getText());
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
            alerta.show();

        }


    }
}
