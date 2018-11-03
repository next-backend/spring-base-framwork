package com.compony.spring.test.core;

import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.nio.charset.Charset;

public class WebClientUtil {
    public static final String ENCODING_UTF8 = "UTF-8";
    public static final String JSON = "json";

    public static void mockGet(WebTestClient client, String uri) throws Exception {
        client.get().uri(uri).accept(MediaType.APPLICATION_JSON).acceptCharset(Charset.defaultCharset()).exchange()
                .expectBody().returnResult().getRequestBodyContent() ;
    }

    public static void mockPost(WebTestClient client, String uri) throws Exception {
        client.post().uri(uri).accept(MediaType.APPLICATION_JSON).acceptCharset(Charset.defaultCharset()).exchange()
                .expectBody().returnResult().getRequestBodyContent() ;
    }
}
