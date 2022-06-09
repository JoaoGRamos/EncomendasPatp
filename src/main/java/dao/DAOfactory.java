package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAOfactory<E> {

    public static EntityManagerFactory emf;
    public EntityManager em;
    private Class<E> classe;

    private Class tClass;

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

// OBTER NOVA VERSÃO DE UMA LINHA.
    public DAOfactory refresh(E entidade) {
        em.refresh(entidade);
        return this;
    }

    public DAOfactory<E> editar(E entidade) {
        abrirT();
        em.merge(entidade);
        fecharT();
        return this;
    }

    public DAOfactory<E> find(Object primaryKey){
        return em.find(this.getClass(), primaryKey);
    }

    public DAOfactory<E> incluir(E entidade) {
        em.persist(entidade);
        return this;
    }

    public DAOfactory<E> incluirAtomico(E entidade) {
        return this.abrirT().incluir(entidade).fecharT();
    }

    public DAOfactory<E> deletar(E entidade) {
        abrirT();
        em.remove(entidade);
        fecharT();
        return this;
    }

    public List<E> obterTodos(){
        return this.obterTodos(99, 0);
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

    public E show(Object collumn, Object value) {
        if (classe == null){
            throw new UnsupportedOperationException("Classe nula.");
        }

        String jpql = "select e from " + classe.getName() + " e where "+ collumn + " = " + value;
        TypedQuery<E> query = em.createQuery(jpql, classe);
        return query.getSingleResult();
    }

    public void fechar(){
        em.close();
    }
}
