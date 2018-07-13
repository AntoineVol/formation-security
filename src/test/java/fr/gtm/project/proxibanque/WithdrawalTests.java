package fr.gtm.project.proxibanque;

import java.time.LocalDate;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.gtm.project.proxibanque.business.WithdrawalComponent;
import fr.gtm.project.proxibanque.entity.Account;
import fr.gtm.project.proxibanque.entity.BankCard;
import fr.gtm.project.proxibanque.entity.CheckBook;
import fr.gtm.project.proxibanque.entity.Message;
import fr.gtm.project.proxibanque.entity.TYPE_CARD;

public class WithdrawalTests {

	private WithdrawalComponent component;
	private Account account;

	@Before
	public void setUp() {
		this.component = new WithdrawalComponent();
		this.account = new Account();
		this.account.setBalance(200F);
		BankCard bankCard = new BankCard();
		bankCard.setId(1);
		bankCard.setExpiredOn(LocalDate.of(2018, 07, 01));
		bankCard.setPin("4564328465499873");
		this.account.setBankCard(bankCard);
		CheckBook checkBook = new CheckBook();
		checkBook.setId(1);
		checkBook.setSendOn(LocalDate.of(2018, 03, 14));
		checkBook.setReceivedOn(LocalDate.of(2018, 04, 8));
		this.account.setCheckBook(checkBook);
	}

	@Test
	public void testCashBalance() {
		final Message msg = component.processCash(this.account, 250F);
		Assert.assertTrue(
				"Should not be able to withdraw more than the account's balance.",
				msg.isError());
	}

	@Test
	public void testCashLimitMax() {
		final Message msg = component.processCash(this.account, 400F);
		Assert.assertTrue("Should not be able to withdraw more than 300€",
				msg.isError());
	}

	@Test
	public void testCardFirst() {
		this.account.setBankCard(null);
		final Message msg = component.processBankCard(this.account,
				TYPE_CARD.VISA_ELECTRON);
		Assert.assertTrue("Should accept card withdraw immediately.",
				!msg.isError());
	}

	@Test
	public void testCardExpired() {
		final Message msg = component.processBankCard(this.account,
				TYPE_CARD.VISA_ELECTRON);
		Assert.assertTrue("Should accept card withdraw immediately.",
				!msg.isError());
	}

	@Test
	public void testCardNotExpired() {
		this.account.getBankCard().setExpiredOn(LocalDate.of(2019, 8, 01));
		final Message msg = component.processBankCard(this.account,
				TYPE_CARD.VISA_ELECTRON);
		Assert.assertTrue(
				"Should not accept card withdraw if old card is not expired.",
				msg.isError());
		Assert.assertThat(msg.getContent(), CoreMatchers.is(
				"Impossible d’effectuer le retrait, votre ancienne carte est encore valide"));
	}

	@Test
	public void testCheckFirst() {
		this.account.setCheckBook(null);
		final Message msg = component.processCheckBook(this.account);
		Assert.assertTrue("Should accept checkbook withdraw immediately.",
				!msg.isError());
	}

	@Test
	public void testCheckDelayOK() {
		final Message msg = component.processCheckBook(this.account);
		Assert.assertTrue("Should accept checkbook withdraw immediately.",
				!msg.isError());
	}

	@Test
	public void testCheckDelayKO() {
		this.account.getCheckBook().setReceivedOn(LocalDate.of(2018, 05, 25));
		final Message msg = component.processCheckBook(this.account);
		Assert.assertTrue("Should accept checkbook withdraw immediately.",
				!msg.isError());
	}
}
