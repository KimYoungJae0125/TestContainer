package com.testContainer.integration;

import com.testContainer.Container.MySQLTestContainer;
import com.testContainer.users.model.entity.Users;
import com.testContainer.users.model.repository.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class IntegrationTest extends MySQLTestContainer {

    private UsersRepository usersRepository;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp(@Autowired UsersRepository usersRepository) {
        this.objectMapper = new ObjectMapper();
        this.usersRepository = usersRepository;
    }

    @Test
    void RepoT() {
        Users users = Users.builder()
                .name("tester")
                .password("pw")
                .build();
        usersRepository.save(users);
        List<Users> usersList = usersRepository.findAll();

        assertThat(usersList.get(0).getName(), is("tester"));
        assertThat(usersList.get(0).getPassword(), is("pw"));

    }

    @Test
    void hello() throws Exception {
        Users users = Users.builder()
                            .name("tester")
                            .password("pw")
                            .build();

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(users))
                        ).andExpect(status().isOk())
                .andDo(print());

    }

}
