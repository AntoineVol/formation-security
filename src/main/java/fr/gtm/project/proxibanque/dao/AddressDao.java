package fr.gtm.project.proxibanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.project.proxibanque.entity.Address;

public interface AddressDao extends JpaRepository<Address, Integer> {

}
