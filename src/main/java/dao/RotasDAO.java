package dao;

import db.DB;
import db.RastreioDaoJDBC;
import db.RotasDaoJDBC;
import model.Rastreio;
import model.Rotas;

import java.util.List;

public class RotasDAO<E> extends DAOfactory{
    public RotasDAO(Class<Rotas> classe) {
        super(classe);
    }
    public List<E> obterRotas() {
        RotasDaoJDBC listagemRotasDao = new RotasDaoJDBC(DB.getConnection());
        return (List<E>) listagemRotasDao.listaAll();
    }
}
