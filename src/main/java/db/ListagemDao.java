package db;

import java.util.List;

import model.RastreioListagem;

public interface ListagemDao {

	List<RastreioListagem> findAll();
	RastreioListagem findById(Integer id);
	
}
