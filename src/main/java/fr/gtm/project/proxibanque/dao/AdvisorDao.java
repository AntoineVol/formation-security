package fr.gtm.project.proxibanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.project.proxibanque.entity.Advisor;

public interface AdvisorDao extends JpaRepository<Advisor, Integer> {
	Advisor findOneByLogin(final String login);
}
