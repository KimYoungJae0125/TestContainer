package com.testContainer.Container;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.trilead.ssh2.log.Logger;


@Testcontainers
@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
public class MySQLTestContainer {

    Logger log = Logger.getLogger(MySQLTestContainer.class);

    @Autowired
    protected MockMvc mockMvc;


    static final String MYSQL_IMAGE = "mysql:8";
    @Container
    static final MySQLContainer MY_SQL_CONTAINER;
    static {
        MY_SQL_CONTAINER = new MySQLContainer(MYSQL_IMAGE);
        MY_SQL_CONTAINER.start();
    }


}
