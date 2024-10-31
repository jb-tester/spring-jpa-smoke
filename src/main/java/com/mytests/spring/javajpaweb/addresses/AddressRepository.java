package com.mytests.spring.javajpaweb.addresses;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AddressRepository {

    final
    EntityManager em;

    public AddressRepository(EntityManager em) {
        this.em = em;
    }

    public List<Address> collectAllAddresses() {
        return em.createQuery("select a from Address a", Address.class).getResultList();
    }

    public List<Address> getAllAddressesByTitle(String city) {
        return em.createQuery("select a from Address a where a.city like :arg", Address.class).setParameter("arg", city).getResultList();}

    @Transactional
    public void addNewAddress(Address address) {
        em.persist(address);
    }
}
