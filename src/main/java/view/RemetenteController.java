package view;

import dao.DAOfactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Remetente;


import java.io.IOException;

public class RemetenteController {

    @FXML
    private Button btCancelar;

    @FXML
    private Button btSalvar;

    @FXML
    private TextField tfCpf;

    @FXML
    private TextField tfID;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfTelefone;

    @FXML
    void acaoCancelar(ActionEvent event) throws IOException {
        Stage stage = (Stage) btCancelar.getScene().getWindow(); //Obtendo a janela atual
        stage.close(); //Fechando o Stage

    }

    @FXML
    void acaoSalvar(ActionEvent event) throws IOException {

        if (!(tfNome.getText() == "" || tfCpf.getText() == "" || tfTelefone.getText() == "")){
            try {
                DAOfactory<Remetente> dao = new DAOfactory<>(Remetente.class);
                Remetente r1 = new Remetente();

                r1.setNome(tfNome.getText());
                r1.setCpf(tfCpf.getText());
                r1.setTelefone(tfTelefone.getText());
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
            alerta.show();
        }

    }
}