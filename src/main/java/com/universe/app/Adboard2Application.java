package com.universe.app;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataIntegrityViolationException;

import com.universe.app.dao.UserDao;
import com.universe.app.domain.Role;
import com.universe.app.domain.UserEntity;
import com.universe.app.mapper.UserMapper;
import com.universe.app.service.AdService;
import com.universe.app.service.UserService;
import com.universe.app.transfer.AdDTO;
import com.universe.app.transfer.UserDTO;

@SpringBootApplication
public class Adboard2Application implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private AdService adService;

	private Logger logger = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		SpringApplication.run(Adboard2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		UserDTO user1 = new UserDTO();
		user1.setUsername("bercik");
		user1.setFullname("Hubert Dworniok");
		user1.setEmail("hubert.dworniok@gmail.com");
		user1.setPhone("+48 505 214 755");
		user1.setPassword("korfantego13/6");
		UserDTO userDTO = userService.saveUserWithRole(user1, Role.ROLE_USER);
		
		
		AdDTO ad1 = new AdDTO();
		ad1.setTitle("lalala");
		ad1.setDescription("ala ma kota");
		ad1.setLocation("Katowice");
		ad1.setPrice(new BigDecimal(500));
		ad1.setExpiryDate(LocalDateTime.of(2018, 10, 25, 10, 25));
		
		adService.assignToUserAndSave(ad1, userDTO);
		


	}
}
