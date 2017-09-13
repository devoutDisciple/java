package com._520it.day3.transactionZhujie;

public interface IAccountService {
	public void transin(Long id, Double money);

	public void transout(Long id, Double money);

	public void transfer(Long inid,Long outid, Double money);
}
