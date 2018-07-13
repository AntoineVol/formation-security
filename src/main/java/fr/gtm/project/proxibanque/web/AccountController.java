package fr.gtm.project.proxibanque.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fr.gtm.project.proxibanque.business.AccountService;
import fr.gtm.project.proxibanque.business.ClientService;
import fr.gtm.project.proxibanque.entity.Account;
import fr.gtm.project.proxibanque.entity.Client;
import fr.gtm.project.proxibanque.entity.Message;

@Controller
@RequestMapping("/{id}/compte")
@SessionAttributes({ "accounts", "client" })
public class AccountController {

	@Autowired
	private ClientService clientService;

	@Autowired
	private AccountService accountService;

	@ModelAttribute
	public List<Account> accounts() {
		return new ArrayList<>();
	}

	@ModelAttribute
	public Client client() {
		return null;
	}

	@RequestMapping("/creation")
	public ModelAndView prepareForm(@PathVariable("id") Integer clientId) {
		final ModelAndView mav = new ModelAndView("new-account");
		mav.addObject("client", this.clientService.read(clientId));
		mav.addObject("accounts", this.accountService.getList());
		return mav;
	}

	@PostMapping("/creation")
	public String validateForm(Float balance, String label, String number,
			Model model, @ModelAttribute Client client) {
		final Message result = this.accountService.create(balance, label,
				number, client);
		model.addAttribute("result", result);
		return "new-account";
	}
}
