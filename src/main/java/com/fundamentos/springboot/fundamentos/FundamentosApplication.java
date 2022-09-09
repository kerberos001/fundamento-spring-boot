package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bean.MyBean;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.springboot.fundamentos.component.ComponentDependency;
import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.pojo.UserPojo;
import com.fundamentos.springboot.fundamentos.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependency componentDependency;
	private MyBean myBean;

	private MyBeanWithDependency myBeanWithDependency;

	private MyBeanWithProperties myBeanWithProperties;

	private UserPojo userPojo;

	private UserRepository userRepository;

	public FundamentosApplication( @Qualifier("componentTwoImplement") ComponentDependency componentDependency,
								  MyBean myBean ,
								   MyBeanWithDependency myBeanWithDependency,
								   MyBeanWithProperties myBeanWithProperties,
								   UserPojo userPojo,
								   UserRepository userRepository) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo=userPojo;
		this.userRepository= userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//ejemplosAnteriores();
		saveUserInDataBase();


	}

	private void saveUserInDataBase() {
		List<User> userList = new ArrayList<>();

		User user1 = new User("Jorge", "jlmt@hotmail.com", LocalDate.of(2021,03,20));
		User user2 = new User("Nathy", "nat@hotmail.com", LocalDate.of(2022,03,20));

		for ( int i=1; i<10; i++) {

			user2 = new User("Nathy"+i, "nat"+i+"@hotmail.com", LocalDate.of(2022,03,20));
			userList.add(user2);
		}
		userList.add(user1);
		userList.stream().forEach(userRepository::save);
	}

	private void ejemplosAnteriores() {
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail()+" - "+userPojo.getPassword());

		try {

			int valor = 10/0;

		} catch (Exception e) {
			LOGGER.error("Error: "+e.getMessage());//getStackTrace()
		}
		LOGGER.error("Esto es un error");
	}

}
