package fr.gtm.project.proxibanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.project.proxibanque.entity.CheckBook;

public interface CheckBookDao extends JpaRepository<CheckBook, Integer> {

}
