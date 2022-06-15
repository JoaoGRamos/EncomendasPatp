package view;

import dao.DAOfactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.*;


import java.util.List;


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

    @FXML
    private TextField tfStatus;

    private int vEncomenda = 0,eDestino = 0, eOrigem = 0, vStatus = 0;

    private ObservableList<Rastreio> obsRastreio;
    private ObservableList<Encomendas> obsEncomendas;
    private ObservableList<Status> obsStatus;
    private ObservableList<Rotas> obsRotas;

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
        DAOfactory daoE = new DAOfactory(Encomendas.class);
        int e1 = cbEncomenda.getSelectionModel().getSelectedIndex();
        Encomendas id = (Encomendas) cbEncomenda.getItems().get(e1);
        vEncomenda = id.getCodigo();
        eDestino = id.getDestino();
        eOrigem = id.getOrigem();
        System.out.println(vEncomenda);
        System.out.println(eDestino);
        System.out.println(eOrigem);
    }

    @FXML
    void acaoStatus(ActionEvent event) {
        DAOfactory daoS = new DAOfactory(Status.class);
        int e1 = cbStatus.getSelectionModel().getSelectedIndex();
        Status id = (Status) cbStatus.getItems().get(e1);
        vStatus = id.getId();
        System.out.println(vStatus);
    }

    @FXML
    void acaoSalvar(ActionEvent event) {
        if (!(vEncomenda == 0 || vStatus == 0)){
            try {
                DAOfactory<Rastreio> dao = new DAOfactory<>(Rastreio.class);
                DAOfactory<Rotas> daoRotas = new DAOfactory<>(Rotas.class);
                List<Rotas> listR = daoRotas.obterTodos();
                obsRotas = FXCollections.observableArrayList(listR);
                System.out.println(listR);
                Rastreio r1 = new Rastreio();
                DadosUsuario usuarioSelecionado = DadosUsuario.getInstance(null);

//                r1.setId(vEncomenda);
//                r1.setStatus(vStatus);
//                r1.setDestino(eDestino);
//                r1.setOrigem(eOrigem);
                if (vStatus == 2){//Em transito
                    r1.setLocalizacao(usuarioSelecionado.usuario.getUnidade());
                    for (Rotas i: obsRotas) {
                        if(i.getUnidade_origem() == usuarioSelecionado.usuario.getUnidade()){
//                            for (Rotas i2: obsRotas) {
//                                if (i.getUnidade_destino() == eDestino){
//
//                                }
//                            }
                            Integer rotaId = i.getId();
                            r1.setRota(rotaId);
                            r1.setId(vEncomenda);
                            r1.setStatus(vStatus);
                            r1.setDestino(eDestino);
                            r1.setOrigem(eOrigem);
                            dao.editar(r1);
                        }

                    }
                } else if (vStatus == 3) {//Recebido na unidade
                    r1.setLocalizacao(usuarioSelecionado.usuario.getUnidade());
//                    r1.setRota();
                }
//                dao.editar(r1);


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

}
