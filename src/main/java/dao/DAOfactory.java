package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAOfactory<E> {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<E> classe;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("testepatp");
        } catch (Exception e){
            //log
        }
    }
    public DAOfactory() {
        this(null);
    }

    public DAOfactory(Class<E> classe) {
        this.classe = classe;
        em = emf.createEntityManager();
    }

    public DAOfactory<E> abrirT() {
        em.getTransaction().begin();
        return this;
    }

    public DAOfactory<E> fecharT() {
        em.getTransaction().commit();
        return this;
    }

    public DAOfactory<E> incluir(E entidade) {
        em.persist(entidade);
        return this;
    }

    public DAOfactory<E> incluirAtomico(E entidade) {
        return this.abrirT().incluir(entidade).fecharT();
    }

    public List<E> obterTodos(){
        return this.obterTodos(10, 0);
    }

    public List<E> obterTodos(int qtde, int deslocamento){
        if (classe == null){
            throw new UnsupportedOperationException("Classe nula.");
        }

        String jpql = "select e from " + classe.getName() + " e";
        TypedQuery<E> query = em.createQuery(jpql, classe);
        query.setMaxResults(qtde);
        query.setFirstResult(deslocamento);
        return query.getResultList();
    }

    public void fechar(){
        em.close();
    }
}
