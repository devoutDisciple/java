package com._520it.day3.transactionZhujie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//@Transactional直接打在类上面，表示类中的所有方法都用事务管理器
@Service
@Transactional(propagation=Propagation.REQUIRED)
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private IAccountDAO dao;
	
	public IAccountDAO getDao() {
		return dao;
	}

	public void setDao(IAccountDAO dao) {
		this.dao = dao;
	}

	@Transactional(readOnly=true)
	public void transin(Long id, Double money) {
		dao.transin(id, money);
	}

	public void transout(Long id, Double money) {
		dao.transout(id, money);
	}

	public void transfer(Long inid,Long outid, Double money) {
		dao.transin(inid, money);
//		int i = 1/0;
		dao.transout(outid, money);
	}

}
