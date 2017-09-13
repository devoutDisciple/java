package com._520it.day3.transction;

public class AccountServiceImpl implements IAccountService {

	private IAccountDAO dao;
	
	public IAccountDAO getDao() {
		return dao;
	}

	public void setDao(IAccountDAO dao) {
		this.dao = dao;
	}

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
