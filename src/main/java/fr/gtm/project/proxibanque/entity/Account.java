package fr.gtm.project.proxibanque.entity;

import java.time.LocalDate;

public class Account implements Entity {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Float balance;
	private String type;
	private String number;
	private String label;
	private LocalDate openedOn;
	private BankCard bankCard;
	private CheckBook checkBook;
	private Client client;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	public TYPE_COMPTE getType() {
		return TYPE_COMPTE.valueOf(this.type);
	}

	public void setType(TYPE_COMPTE type) {
		this.type = type.name();
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public LocalDate getOpenedOn() {
		return openedOn;
	}

	public void setOpenedOn(LocalDate openedOn) {
		this.openedOn = openedOn;
	}

	public BankCard getBankCard() {
		return bankCard;
	}

	public void setBankCard(BankCard bankCard) {
		this.bankCard = bankCard;
	}

	public CheckBook getCheckBook() {
		return checkBook;
	}

	public void setCheckBook(CheckBook checkBook) {
		this.checkBook = checkBook;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
