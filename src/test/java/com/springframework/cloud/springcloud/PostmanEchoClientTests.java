package com.springframework.cloud.springcloud;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostmanEchoClientTests {

    @Autowired
    private PostmanEchoClient client;

    @Test
    void postEcho() throws Exception {

        final EchoPostRequest request =
                new EchoPostRequest();
        request.setDescription("xyz");

        final EchoPostResponse response =
                client.postEcho("abc", "123", request);

        assertThat(
                response.getArgs().getFirst()
        ).isEqualTo("abc");
        assertThat(
                response.getArgs().getSecond()
        ).isEqualTo("123");
        assertThat(
                response.getMessage().getDescription()
        ).isEqualTo("xyz");

    }

    @Test
    void getEcho() throws Exception {

        final EchoGetResponse response =
                client.getEcho("abc", "123");

        assertThat(
                response.getArgs().getFirst()
        ).isEqualTo("abc");
        assertThat(
                response.getArgs().getSecond()
        ).isEqualTo("123");

    }
}
