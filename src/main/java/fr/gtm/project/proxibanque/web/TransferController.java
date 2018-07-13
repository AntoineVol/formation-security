package fr.gtm.project.proxibanque.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.gtm.project.proxibanque.business.ClientService;
import fr.gtm.project.proxibanque.entity.Client;

@Controller
@RequestMapping("/{id}/virement")
public class TransferController {

	@Autowired
	private ClientService clientService;

	@RequestMapping("/interne")
	public ModelAndView internalTransfert(@PathVariable Integer id) {
		final ModelAndView mav = new ModelAndView("transfer");
		final Client client = this.clientService.read(id);
		mav.addObject("accounts", client.getAccounts());
		return mav;
	}
}
