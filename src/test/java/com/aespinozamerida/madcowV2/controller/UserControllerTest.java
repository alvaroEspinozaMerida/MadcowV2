package com.aespinozamerida.madcowV2.controller;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.aespinozamerida.madcowV2.model.User;
import com.aespinozamerida.madcowV2.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UserController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private UserService userService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    public void testCreateUser() throws Exception{
//
//        User user = new User();
//
//        user.setId(1);
//        user.setFirstName("David");
//
//        when(userService.createUser(any(User.class))).thenReturn(user);
//
//        MvcResult result = mockMvc.perform(post("/api/v1/add")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(user)))
//                .andExpect(status().isOk())
//                .andReturn();
//        assertThat(result.getResponse().getContentAsString()).isEqualTo("New User was added");
//
//    }

}
