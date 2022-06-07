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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Destinatario;



import java.io.IOException;
import java.util.List;

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

    private ObservableList<Destinatario> obsDestinatario;
    @FXML
    public void initilize(){
        carregarDestino();
    }

    public void ListarTodos() {
        DAOfactory<Destinatario> dao = new DAOfactory<>(Destinatario.class);
        List<Destinatario> list = dao.obterTodos();
        obsDestinatario = FXCollections.observableArrayList(list);
        cbID.setItems(obsDestinatario);
    }

    public void carregarDestino(){
        ListarTodos();
    }

    @FXML
    void selecionarId(ActionEvent event) {

    }

    @FXML
    void acaoCancelar(ActionEvent event) throws IOException {
        Stage stage = (Stage) btCancelar.getScene().getWindow(); //Obtendo a janela atual
        stage.close(); //Fechando o Stage

        Parent root = FXMLLoader.load(getClass().getResource("/view/centralfx.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Rastreio de Encomendas");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void acaoSalvar(ActionEvent event) throws IOException{

        if (!(tfNome.getText() == "" || tfCpf.getText() == "" || tfTelefone.getText() == "")){
            try {
                DAOfactory<Destinatario> dao = new DAOfactory<>(Destinatario.class);
                Destinatario r1 = new Destinatario();

                r1.setNome(tfNome.getText());
                r1.setCpf(tfCpf.getText());
                r1.setTelefone(tfTelefone.getText());
                r1.setEndereco(tfEndereco.getText());
                dao.incluirAtomico(r1);


                Parent root = FXMLLoader.load(getClass().getResource("/view/salvou.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setTitle("Salvou!");
                stage.setScene(new Scene(root));
                stage.show();
            } catch (Exception e) {
                Parent root = FXMLLoader.load(getClass().getResource("/view/naosalvou.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setTitle("Nao Salvou!");
                stage.setScene(new Scene(root));
                stage.show();
            }

        }
        else {
            Parent root = FXMLLoader.load(getClass().getResource("/view/naosalvou.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Nao Salvou!");
            stage.setScene(new Scene(root));
            stage.show();
        }


    }

}
