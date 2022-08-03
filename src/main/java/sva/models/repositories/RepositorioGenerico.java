package sva.models.repositories;

import sva.db.EntityManagerHelper;
import sva.models.entities.Persistente;
import sva.models.repositories.modificadores.BusquedaCondicional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositorioGenerico<T extends Persistente> {
    private Class<T> type;

    public RepositorioGenerico(Class<T> type) {
        this.type = type;
    }

    public List<T> buscarTodos() {
        CriteriaBuilder builder = EntityManagerHelper.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> critera = builder.createQuery(this.type);
        critera.from(type);
        List<T> entities = EntityManagerHelper.getEntityManager().createQuery(critera).getResultList();
        return entities;
    }
    public Optional<T> buscar(int id) {
        return Optional.of(EntityManagerHelper.getEntityManager().find(type, id));
    }

    @SuppressWarnings("unchecked")
    public Optional<T> buscar(BusquedaCondicional condicional) {
        return Optional.of((T) EntityManagerHelper.getEntityManager()
                .createQuery(condicional.getCondicionCritero())
                .getSingleResult());
    }

    public List<T> buscarTodos(BusquedaCondicional condicional) {
        return EntityManagerHelper.getEntityManager()
                .createQuery(condicional.getCondicionCritero())
                .getResultList();
    }

    public void agregar(T elemento) {
        EntityManagerHelper.getEntityManager().getTransaction().begin();
        EntityManagerHelper.getEntityManager().persist(elemento);
        EntityManagerHelper.getEntityManager().getTransaction().commit();
        EntityManagerHelper.closeEntityManager();
    }

    public void modificar(T elemento) {
        EntityManagerHelper.getEntityManager().getTransaction().begin();
        EntityManagerHelper.getEntityManager().merge(elemento);
        EntityManagerHelper.getEntityManager().getTransaction().commit();
        EntityManagerHelper.closeEntityManager();
    }

    public void eliminar(T unElemento) {
        EntityManagerHelper.getEntityManager().getTransaction().begin();
        EntityManagerHelper.getEntityManager().remove(unElemento);
        EntityManagerHelper.getEntityManager().getTransaction().commit();
    }

    public CriteriaBuilder criteriaBuilder(){
        return EntityManagerHelper.getEntityManager().getCriteriaBuilder();
    }
}
