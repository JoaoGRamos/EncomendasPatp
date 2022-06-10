package dao;

import model.Unidades;
import model.Rastreio;

import javax.persistence.TypedQuery;
import java.util.List;

public class RastreioDAO extends DAOfactory{


    public RastreioDAO(Class<Rastreio> classe) {
        super(classe);
    }

    public List<Rastreio> obterRastreio(){
        return this.obterRastreio(99, 0);
    }

    public List<Rastreio> obterRastreio(int qtde, int deslocamento) {
        Rastreio rastreio = new Rastreio();
        Unidades unidades = new Unidades();
        String jpql = "SELECT u.`local` as origem, u2.`local` as destino, status, datahora_entrada, datahora_saida, rota, u3.`local` as 'local'\n" +
                "from rastreio r\n" +
                "inner join unidades u on u.codigo = r.origem\n" +
                "inner join unidades u2 on u2.codigo = r.destino\n" +
                "inner join unidades u3 on u3.codigo = r.`local`";
        TypedQuery query = em.createQuery(jpql, classe);
        query.setMaxResults(qtde);
        query.setFirstResult(deslocamento);
        return query.getResultList();

        /* --Script para a listagem do rastreio--
        SELECT u.`local` as origem, u2.`local` as destino, status, datahora_entrada, datahora_saida, rota, u3.`local` as 'local'
        from rastreio r
        inner join unidades u on u.codigo = r.origem
        inner join unidades u2 on u2.codigo = r.destino
        inner join unidades u3 on u3.codigo = r.`local` ;
        * */
    }
}
