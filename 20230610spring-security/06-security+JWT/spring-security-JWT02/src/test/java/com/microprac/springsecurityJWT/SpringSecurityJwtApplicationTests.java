package com.microprac.springsecurityJWT;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser

class SpringSecurityJwtApplicationTests {

	@Test @WithUserDetails("customUsername@example.io")
	// @WithMockUser(username="customUsername@example.io", roles={"USER_ADMIN"})
	void contextLoads() {
	}

	@Test
	public void test1() {
		// Details omitted for brevity
	}

	@Test
	public void test2() {
		// Details omitted for brevity
	}

	@Test @WithAnonymousUser
	public void test3() throws Exception {
		// Details omitted for brevity
	}

}
