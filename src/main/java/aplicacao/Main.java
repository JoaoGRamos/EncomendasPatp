package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.DAOfactory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Unidades;

public class Main extends Application {


    /* ----------------------------------------------------- JAVAFX */
    @Override
    public void start(Stage primaryStage) throws Exception{
    	
    	usingHibernate();
		Parent root = FXMLLoader.load(getClass().getResource("/view/hellofx.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 400, 300));
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

//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testepatp");
//		EntityManager em = emf.createEntityManager();

		DAOfactory<Unidades> dao = new DAOfactory<>(Unidades.class);
		dao.incluirAtomico(u1).fechar();

//		em.getTransaction().begin();
//		em.persist(u1);
//		em.persist(u2);
//		em.persist(u3);
//		em.getTransaction().commit();



		System.out.println(u1);
		System.out.println(u2);
		System.out.println(u3);

//		em.close();
//		emf.close();
    }


}
  