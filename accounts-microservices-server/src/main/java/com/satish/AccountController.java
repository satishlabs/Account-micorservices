package com.satish;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	private static final Logger log = LoggerFactory.getLogger(StubAccountRepository.class); 
	
	@Autowired
	private AccountRepository accountRepository;
	
	@RequestMapping("/accounts")
	public Account[] all() {
		log.info("accounts-microservice all() invoked");
		List<Account>accounts = accountRepository.getAllAcounts();
		log.info("accounts-microservice all() found: " + accounts.size());
		return accounts.toArray(new Account[accounts.size()]);
	}
	
	@RequestMapping("/accounts/{id}")
	public Account byId(@PathVariable("id") String id) {
		log.info("accounts-microservice byId() invoked: " + id);
		Account account = accountRepository.getAccount(id);
		log.info("accounts-microservice byId() found: " + account);
		return account;
	}
}
