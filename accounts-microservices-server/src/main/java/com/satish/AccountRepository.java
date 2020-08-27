package com.satish;

import java.util.List;

public interface AccountRepository {
	List<Account> getAllAcounts();
	Account getAccount(String number);
}
