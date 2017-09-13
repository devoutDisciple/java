package com._520it.day3.transactionZhujie;

public interface IAccountDAO {

	public void transout(Long id, Double money);

	void transin(Long id, Double money);
}
