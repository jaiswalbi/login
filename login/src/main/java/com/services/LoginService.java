package com.services;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import com.hib.entity.CustomerLoginEntity;
import com.hib.reposetory.CoustomerLoginRepository;

@Service
public class LoginService {
	
	private CoustomerLoginRepository coustomerLoginRepository;

	public boolean isLoginValid(String username, String password) {
//		if(username.equals("test") && password.equals("test")) {
//			return true;
//		} else {

		CustomerLoginEntity customerLogin = coustomerLoginRepository.getLoginByUserName(username);
		if (customerLogin == null) {
			return false;
		} else {
			String hashedPassword = DigestUtils.sha256Hex(password);
			if (hashedPassword.equals(customerLogin.getPassword())) {
				customerLogin.setLastSignedOn(new Date());
				coustomerLoginRepository.update(customerLogin);
				return true;
			} else {
				return false;
			}
		}
	}

	public CoustomerLoginRepository getCoustomerLoginRepository() {
		return coustomerLoginRepository;
	}

	public void setCoustomerLoginRepository(CoustomerLoginRepository coustomerLoginRepository) {
		this.coustomerLoginRepository = coustomerLoginRepository;
	}

}
