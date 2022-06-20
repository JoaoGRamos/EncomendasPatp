package db;

public class DaoFactory {
	
	public static ListagemDao createCadastroDao() {
		return new RastreioDaoJDBC(DB.getConnection());
	}
	public static ListagemRotasDao createRotasDao() {
		return new RotasDaoJDBC(DB.getConnection());
	}

}
