package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AccountBaseMapper;
import model.AccountBase;
import service.IAccountBaseService;

@Service("SaccountBase")
public class AccountBaseServiceImpl implements IAccountBaseService {
    
    private AccountBaseMapper accountBaseMapper;



	public AccountBaseMapper getAccountBase() {
		return accountBaseMapper;
	}
	@Autowired
	public void setAccountBase(AccountBaseMapper accountBase) {
		this.accountBaseMapper = accountBase;
	}
	
	
	@Override
	public List<AccountBase> loadAccountBases(AccountBase accountBase) {
		List<AccountBase> res=accountBaseMapper.queryAll(accountBase);
		for (AccountBase temp : res) {
			try {
				temp.deCode();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return res;
	}
	@Override
	public int insert(AccountBase accountBase) {
		return accountBaseMapper.insert(accountBase);
	}
	@Override
	public int deleteByID(AccountBase accountBase) {
		return accountBaseMapper.deleteByID(accountBase);
	}
	@Override
	public int modifyByID(AccountBase accountBase) {
		return accountBaseMapper.modifyByID(accountBase);
		
	}
	@Override
	public List<AccountBase> loadAccountBasesByName(AccountBase accountBase) {
		List<AccountBase> res=accountBaseMapper.queryByName(accountBase);
		for (AccountBase temp : res) {
			try {
				temp.deCode();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return res;
	}


    
}