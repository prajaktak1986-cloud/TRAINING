package com.msedcl.main.domain;

public class LastNameStartsWithG implements Condition {

	@Override
	public boolean test(Person person) {
		// TODO Auto-generated method stub
		if(person.getLastName().startsWith("G"))
			return true;
		else
		return false;
	}
}
