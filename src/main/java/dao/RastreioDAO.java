package dao;

import db.DB;
import db.RastreioDaoJDBC;
import model.Rastreio;
import model.RastreioListagem;

import java.util.List;

public class RastreioDAO<E> extends DAOfactory{

    public RastreioDAO(Class<Rastreio> classe) {
        super(classe);
    }

    //public List<E> obterRastreio(){
    //    return this.obterRastreio(99, 0);
    //}

    public List<E> obterRastreio() {
        RastreioDaoJDBC listagemDao = new RastreioDaoJDBC(DB.getConnection());
        return (List<E>) listagemDao.findAll();
    }

    public RastreioListagem pesquisarRastreio(Integer id) {
        RastreioDaoJDBC listagemDao = new RastreioDaoJDBC(DB.getConnection());
        return listagemDao.findById(id);
    }


}
