package fr.gtm.project.proxibanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.project.proxibanque.entity.BankCard;

public interface BankCardDao extends JpaRepository<BankCard, Integer> {

}
