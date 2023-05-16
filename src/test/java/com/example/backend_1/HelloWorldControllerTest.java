package com.example.backend_1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloWorldControllerTest {

    @Value(value = "${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private HelloWorldController helloWorldController;

    @Test
    public void testHelloWorldController() {
        assert helloWorldController != null;
    }

    @Test
    public void testHelloWorld() {
        assert testRestTemplate.getForObject("http://localhost:" + port + "/",
                String.class).equals("Hello World!");

    }

    @Test
    public void testHolaMundo() {
        assert testRestTemplate.getForObject("http://localhost:" + port + "/esp",
                String.class).equals("Hola Mundo!!");

    }

    @Test
    public void testHelloParam() {
        assert testRestTemplate.getForObject("http://localhost:" + port + "/helloParam?fNamn=Dennis",
                String.class).equals("Hello Dennis");
    }

    @Test
    public void testHelloParams() {
        assert testRestTemplate.getForObject("http://localhost:" + port + "/helloParams?fName=Dennis&lName=MasterMannen",
                String.class).equals("Hello Dennis MasterMannen");
    }

    @Test
    public void testHelloParamsDefault() {
        assert testRestTemplate.getForObject("http://localhost:" + port + "/helloParams?fName=Dennis",
                String.class).equals("Hello Dennis ");
    }

    @Test
    public void testHelloParamList() {
        assert testRestTemplate.getForObject("http://localhost:" + port + "/helloParamList?list=1,2,3,4,hej",
                String.class).equals("Hello [1, 2, 3, 4, hej]");
    }

    @Test
    public void testHelloPathParam() {
        assert testRestTemplate.getForObject("http://localhost:" + port + "/helloPathParam/Dennis",
                String.class).equals("Hello Dennis");
    }
}