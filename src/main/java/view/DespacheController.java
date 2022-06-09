package view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Destinatario;
import model.Remetente;
import model.Unidades;

public class DespacheController {
    @FXML
    private Button btCadaDestinatario;

    @FXML
    private Button btCadaRemetente;

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

}
