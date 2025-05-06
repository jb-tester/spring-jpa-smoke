package com.mytests.spring.javajpaweb.addresses;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AddressRepository {

    public static final String Q1 = """
            select a
             from Address a
             where a.city like :arg""";
    final
    EntityManager em;


    public AddressRepository(EntityManager em) {
        this.em = em;
    }

    public List<Address> collectAllAddresses() {
        String entity = "Address";
        String alias = "a";
        return em.createQuery("select " + alias + " from " + entity + " " + alias, Address.class).getResultList();
    }

    public List<Address> getAllAddressesByZipCode(String zipcode) {
        String q1 = "select a from Address a ";
        String q2 = "where a.zipcode = :arg";
        return em.createQuery(q1+q2, Address.class).setParameter("arg", zipcode).getResultList();}

    public Address getAddressById(int id) {
        String entity = "Address";
        TypedQuery<Address> query = em.createQuery("select a from " + entity + " a where a.id = :arg", Address.class);
        return query.setParameter("arg", id).getSingleResult();

    }

    public List<Address> getAllAddressesByCityName(String city) {
        return em.createQuery(Q1, Address.class).setParameter("arg", city).getResultList();}

    @Transactional
    public void addNewAddress(Address address) {
        em.persist(address);
    }
}
