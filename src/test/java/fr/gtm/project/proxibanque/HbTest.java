package fr.gtm.project.proxibanque;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.gtm.project.proxibanque.business.SearchClientComponent;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/proxibanque-context-test.xml" })
public class HbTest {

	@Autowired
	SearchClientComponent searchClient;

	@Test
	public void testTruc() {
		this.searchClient.setSearch("test super");
	}
}
