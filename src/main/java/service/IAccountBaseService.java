package service;

import java.util.List;


import model.AccountBase;

public interface IAccountBaseService {


	int insert(AccountBase accountBase);

	int modifyByID(AccountBase accountBase);

	int deleteByID(AccountBase accountBase);

	List<AccountBase> loadAccountBases(AccountBase accountBase);

	List<AccountBase> loadAccountBasesByName(AccountBase accountBase);
}
