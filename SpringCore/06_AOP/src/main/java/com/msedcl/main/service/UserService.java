
package com.msedcl.main.service;

import org.springframework.stereotype.Service;

//@Service
public class UserService {

	public void createUser(String name) {
		System.out.println("User Created :: " + name);
	}
}
