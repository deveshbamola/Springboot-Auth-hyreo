package com.example.model.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Persistence.LoginImpl;

@Service
public class ILoginImpl implements Ilogin {
	@Autowired
	LoginImpl loginImpl;

	@Override
	public boolean validate(String Username, String password) {
		return loginImpl.validate(Username, password);
	}

}
