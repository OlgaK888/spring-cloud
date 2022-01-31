package com.springframework.cloud.springcloud;

import lombok.Data;

@Data
public class EchoGetResponse {

    private Args args;
    private Message message;

    @Data
    public static class Args {

        private String first;
        private String second;
    }

    @Data
    public class Message {

        private String description;
    }
}
