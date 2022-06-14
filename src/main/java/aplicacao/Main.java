package aplicacao;

import dao.DAOfactory;

import dao.UnidadesDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.DadosUsuario;
import model.Unidades;

import java.util.List;

public class Main extends Application {

    /* ----------------------------------------------------- JAVAFX */

    @Override
    public void start(Stage primaryStage) throws Exception{
    	
//    	usingHibernate();
//      primaryStage.setResizable(false);
		Parent root = FXMLLoader.load(getClass().getResource("/view/hellofx.fxml"));
        primaryStage.setTitle("Rastreio de Encomendas");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


    /* ----------------------------------------------------- HIBERNATE*/ 
    public static void usingHibernate() {
		Unidades u1 = new Unidades(null, "Unidade de tratamento de Sertão", "Sertão");
		Unidades u2 = new Unidades(null, "Unidade de tratamento de Getúlio Vargas", "Getúlio Vargas");
		Unidades u3 = new Unidades(null, "Unidade de tratamento de Erechin", "Erechin");


		DAOfactory<Unidades> dao = new DAOfactory<>(Unidades.class);
//		dao.incluirAtomico(u1);
//        dao.incluirAtomico(u2);
//        dao.incluirAtomico(u3);

        UnidadesDAO daoU = new UnidadesDAO();
        List<Unidades> unidades = daoU.obterTodos();

        for (Unidades unidade: unidades){
            System.out.println("ID: " + unidade.getCodigo() + ", Nome: " + unidade.getDescricao() +
                    " Local: " + unidade.getMunicipio());
//            if (unidade.getCodigo() == 8) {
//                daoU.deletar(unidade);
//            }
            if (unidade.getCodigo() == 1) {
                unidade.setDescricao(unidade.getDescricao()+ "a");
                daoU.editar(unidade);
            }
        }

        unidades = daoU.obterTodos();

        Unidades tmp = daoU.show("codigo", 100);
        System.out.println(tmp.getDescricao());

        for (Unidades unidade: unidades) {
            System.out.println("ID: " + unidade.getCodigo() + ", Nome: " + unidade.getDescricao() +
                    " Local: " + unidade.getMunicipio());
        }



    }



}
  