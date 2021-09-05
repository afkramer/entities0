package com.udacity.persistence.entities0.repository;

import com.udacity.persistence.entities0.DTO.RecipientAndPrice;
import com.udacity.persistence.entities0.model.Delivery;
import com.udacity.persistence.entities0.model.Plant;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DeliveryRepository implements Deliverable {
    @PersistenceContext
    EntityManager entityManager;

    public void persist(Delivery delivery){
        entityManager.persist(delivery);
    };

    public Delivery find(Long id){
        return entityManager.find(Delivery.class, id);
    };

    public Delivery merge(Delivery delivery){
        return entityManager.merge(delivery);
    };

    public void delete(Long id){
        Delivery d = entityManager.find(Delivery.class, id);
        entityManager.remove(d);
    };

    public List<Delivery> findDeliveriesByName(String name){
        TypedQuery<Delivery> query = entityManager.createNamedQuery("Delivery.findByName", Delivery.class);
        query.setParameter("name", name);
        return query.getResultList();
    }



    public RecipientAndPrice getRecipientAndPrice(Long id){
        // return name of delivery recipient and total sum of all plants
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<RecipientAndPrice> criteria = builder.createQuery(RecipientAndPrice.class);
        Root<Plant> root = criteria.from(Plant.class);

        criteria.select(
                builder.construct(
                        RecipientAndPrice.class,
                        root.get("delivery").get("name"),
                        builder.sum(root.get("price"))))
                .where(builder.equal(root.get("delivery").get("id"), id));

        return entityManager.createQuery(criteria).getSingleResult();
    }
}
