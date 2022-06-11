package dao;

import model.Rastreio;

import javax.persistence.Query;

import java.util.List;

public class RastreioDAO<E> extends DAOfactory{

    public RastreioDAO(Class<Rastreio> classe) {
        super(classe);
    }


    public List<E> obterRastreio(){
        return this.obterRastreio(99, 0);
    }

    public List<E> obterRastreio(int qtde, int deslocamento) {
        UnidadesDAO daoU = new UnidadesDAO();

        String jpql = "select u.municipio as origem, u2.municipio as destino, u3.municipio as localizacao\n" +
                "from " + classe.getName() +" r\n" +
                "inner join " + daoU.classe.getName() + " u on u.codigo = r.origem\n" +
                "inner join " + daoU.classe.getName() + " u2 on u2.codigo = r.destino\n" +
                "inner join " + daoU.classe.getName() + " u3 on u3.codigo = r.localizacao";
        Query query = em.createQuery(jpql, classe);
        query.setMaxResults(qtde);
        query.setFirstResult(deslocamento);
        return query.getResultList();

        /* --Query para a listagem do rastreio--
    SELECT u.municipio as origem, u2.municipio as destino, status, datahora_entrada, datahora_saida, rota, u3.municipio as localizacao
    from rastreio r
    inner join unidades u on u.codigo = r.origem
    inner join unidades u2 on u2.codigo = r.destino
    inner join unidades u3 on u3.codigo = r.localizacao;
        * */
    }
}
