package fr.gtm.project.proxibanque.entity;

import java.time.LocalDate;

/**
 * <h3>Entité représentant une carte bancaire en base de données :</h3>
 * <ul>
 * <li>de type Visa eletron ou premier</li>
 * <li>avec un numéro d'identification (pin) sur 8 chiffres</li>
 * </ul>
 * 
 * @author Adminl
 *
 */
public class BankCard implements Entity {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String pin;
	private String type;
	private LocalDate expiredOn;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDate getExpiredOn() {
		return expiredOn;
	}

	public void setExpiredOn(LocalDate expiredOn) {
		this.expiredOn = expiredOn;
	}

}
