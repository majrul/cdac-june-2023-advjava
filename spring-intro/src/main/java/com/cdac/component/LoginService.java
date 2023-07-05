package com.cdac.component;

import org.springframework.stereotype.Component;

@Component("login")
public class LoginService {

	public boolean isValidUser(String username, String password) {
		if(username.equals("majrul") && password.equals("123"))
			return true;
		return false;
	}
}
