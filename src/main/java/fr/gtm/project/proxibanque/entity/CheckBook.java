package fr.gtm.project.proxibanque.entity;

import java.time.LocalDate;

/**
 * Entité représentant un chéquier en base de données avec date d'envoi au
 * client et date de reception.
 * 
 * @author Adminl
 *
 */
public class CheckBook implements Entity {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private LocalDate receivedOn;
	private LocalDate sendOn;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getReceivedOn() {
		return receivedOn;
	}

	public void setReceivedOn(LocalDate receivedOn) {
		this.receivedOn = receivedOn;
	}

	public LocalDate getSendOn() {
		return sendOn;
	}

	public void setSendOn(LocalDate sendOn) {
		this.sendOn = sendOn;
	}

}
