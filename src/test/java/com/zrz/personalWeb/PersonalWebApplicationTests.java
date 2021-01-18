package com.zrz.personalWeb;

//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;

import com.zrz.personalWeb.domain.User;
import com.zrz.personalWeb.service.UserService;

@SpringBootTest
//@RunWith(SpringRunner.class)
class PersonalWebApplicationTests {
	
	@Autowired
	UserService us;

	//@Test
	void contextLoads() {
		User user = us.login("zrz", "123456");
//		if(user != null)
//			System.out.println("success");
//		else
//			System.out.println("error");
//		long uid = user.getId();
//		String uname = user.getName();
//		System.out.println("------------------------------" + uname);
//		if(us.register(2, "rzz", "12345", "316677100@qq.com"))
//			System.out.println("success");
//		else
//			System.out.println("error");
	}
}
