package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

    public void fechar(){
        em.close();
    }
}
