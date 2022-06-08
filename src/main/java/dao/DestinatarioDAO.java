package dao;

import model.Destinatario;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class DestinatarioDAO extends DAOfactory<Destinatario> {
    public DestinatarioDAO(Class<Destinatario> classe) {
        super(classe);
    }

}




