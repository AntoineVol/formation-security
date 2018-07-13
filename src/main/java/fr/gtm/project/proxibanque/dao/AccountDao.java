package fr.gtm.project.proxibanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.project.proxibanque.entity.Account;

public interface AccountDao extends JpaRepository<Account, Integer> {

}
