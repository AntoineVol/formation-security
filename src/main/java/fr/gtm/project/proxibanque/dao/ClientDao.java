package fr.gtm.project.proxibanque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.project.proxibanque.entity.Client;

public interface ClientDao extends JpaRepository<Client, Integer> {

	List<Client> findAllByFirstnameAndLastname(String firstname,
			String lastname);

}
