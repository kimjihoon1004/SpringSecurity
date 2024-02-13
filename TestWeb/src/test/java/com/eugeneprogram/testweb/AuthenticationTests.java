package com.eugeneprogram.testweb;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthenticationTests {
    // 이 java파일이 있던 없던 작동함
    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("Test calling /hello endpoint authenticating with valid credentials returns ok.")
    public void helloAuthenticatingWithValidUser() throws Exception {
        mvc.perform(get("/main.do")
                .with(httpBasic("john","12345")))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test calling /hello endpoint authenticating with wrong credentials returns unauthorized.")
    public void helloAuthenticatingWithInvalidUser() throws Exception {
        mvc.perform(get("/main.do")
                .with(httpBasic("mary","12345")))
                .andExpect(status().isUnauthorized());
    }
}
