package view;

import dao.DAOfactory;
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
import model.Remetente;

import java.io.IOException;
import java.util.List;

import static java.lang.Integer.parseInt;

public class EditarRemetenteController {

    @FXML
    private Button btCancelar;

    @FXML
    private Button btSalvar;

    @FXML
    private ComboBox cbId;

    @FXML
    private TextField tfId;

    @FXML
    private TextField tfCpf;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfTelefone;

    private ObservableList<Remetente> obsRemetente;

    public void initialize() {
        carregarDestino();
    }

    public void ListarTodos() {
        DAOfactory dao = new DAOfactory(Remetente.class);
        List<Remetente> list = dao.obterTodos();
        obsRemetente = FXCollections.observableArrayList(list);

    }

    public void carregarDestino(){
        ListarTodos();
        cbId.setItems(obsRemetente);
    }

    @FXML
    void selecionarId(ActionEvent event) {
        DAOfactory dao = new DAOfactory(Remetente.class);
        int e1 = cbId.getSelectionModel().getSelectedIndex();
        Remetente id = (Remetente)cbId.getItems().get(e1);
        tfId.setText(String.valueOf(id.getId()));
        tfNome.setText(id.getNome());
        tfCpf.setText(id.getCpf());
        tfTelefone.setText(id.getTelefone());

    }

    @FXML
    void acaoCancelar(ActionEvent event) throws IOException {
        Stage stage = (Stage) btCancelar.getScene().getWindow(); //Obtendo a janela atual
        stage.close(); //Fechando o Stage

    }

    @FXML
    void acaoSalvar(ActionEvent event) {

        if (!(tfNome.getText() == "" || tfCpf.getText() == "" || tfTelefone.getText() == "")){
            try {

                DAOfactory dao = new DAOfactory(Remetente.class);
                Remetente r1 = new Remetente();

                r1.setId(parseInt(tfId.getText()));
                r1.setNome(tfNome.getText());
                r1.setCpf(tfCpf.getText());
                r1.setTelefone(tfTelefone.getText());
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
