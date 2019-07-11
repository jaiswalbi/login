package com.services;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import com.dto.SignupDto;
import com.hib.entity.CustomerEntity;
import com.hib.entity.CustomerLoginEntity;
import com.hib.reposetory.CoustomerLoginRepository;

@Service
public class SignupService {

	private CoustomerLoginRepository coustomerLoginRepository;

	public boolean register(SignupDto signupDto) {
		CustomerLoginEntity existingLogin = coustomerLoginRepository.getLoginByUserName(signupDto.getUsername());

		if (existingLogin != null) {
			return false;
		} else {
			CustomerLoginEntity customerLogin = new CustomerLoginEntity();
			customerLogin.setUserName(signupDto.getUsername());

			String hashedPassword = DigestUtils.sha256Hex(signupDto.getPassword());
			customerLogin.setPassword(hashedPassword);

			CustomerEntity customerEntity = new CustomerEntity();
			customerEntity.setFirstName(signupDto.getFirstName());
			customerEntity.setLastName(signupDto.getLastName());
			customerEntity.setPhone(signupDto.getPhone());
			customerEntity.setEmail(signupDto.getEmail());
			customerEntity.setAddress(signupDto.getAddress());

			customerLogin.setCustomer(customerEntity);

			coustomerLoginRepository.save(customerLogin);

			return true;
		}
	}

	public CoustomerLoginRepository getCustomerLoginRepository() {
		return coustomerLoginRepository;
	}

	public void setCustomerLoginRepository(CoustomerLoginRepository coustomerLoginRepository) {
		this.coustomerLoginRepository = coustomerLoginRepository;
	}
}
