package fr.gtm.project.proxibanque.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.gtm.project.proxibanque.business.AccountService;
import fr.gtm.project.proxibanque.business.ClientService;
import fr.gtm.project.proxibanque.entity.Client;
import fr.gtm.project.proxibanque.entity.TYPE_COMPTE;

@Controller
@RequestMapping("/{id}/retrait")
public class WithdrawalController {

	@Autowired
	private ClientService clientService;

	@Autowired
	private AccountService accountService;

	@RequestMapping("/espece")
	public ModelAndView cashWithdrawal(@PathVariable Integer id) {
		final ModelAndView mav = new ModelAndView("withdrawal/cash");
		final Client client = this.clientService.read(id);
		mav.addObject("accounts",
				client.getAccounts().stream().filter(
						(account) -> account.getType() == TYPE_COMPTE.MAIN)
						.toArray());
		return mav;
	}

	@RequestMapping("/cartebleue")
	public ModelAndView cbWithdrawal(@PathVariable Integer id) {
		final ModelAndView mav = new ModelAndView("withdrawal/bankcard");
		final Client client = this.clientService.read(id);
		// TODO: Filter les comptes n'ayant pas de CB ou CB expirée.
		mav.addObject("accounts", client.getAccounts());
		return mav;
	}

	@RequestMapping("/chequier")
	public ModelAndView checkWithdrawal(@PathVariable Integer id) {
		final ModelAndView mav = new ModelAndView("withdrawal/checkbook");
		final Client client = this.clientService.read(id);
		// TODO: Filter les comptes n'ayant pas de chéquier ou délai de 3 mois
		// dépassé.
		mav.addObject("accounts", client.getAccounts());
		return mav;
	}

	@PostMapping("/espece")
	public ModelAndView confirmCashWithdrawal(@RequestParam Integer debitId,
			@RequestParam Float amount) {
		final ModelAndView mav = new ModelAndView("withdrawal/cash");
		mav.addObject("result",
				this.accountService.withdrawCash(debitId, amount));
		return mav;
	}
}
