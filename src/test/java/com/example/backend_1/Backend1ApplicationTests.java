package com.example.backend_1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Backend1ApplicationTests {

    @Autowired
    private HelloWorldController helloWorldController;

    @Test
    void contextLoads() {
    }

    @Test
    public void testHelloWorldController() {
        assert helloWorldController != null;
    }

    @Test
    public void testHelloWorld() {
        assert helloWorldController.helloWorld().equals("Hello World!");
    }

    @Test
    public void testHolaMundo() {
        assert helloWorldController.holaMundo().equals("Hola Mundo!!");
    }

    @Test
    public void testHelloParam() {
        assert helloWorldController.helloParam("Dennis").equals("Hello Dennis");
    }

    @Test
    public void testHelloParams() {
        assert helloWorldController.helloParams("Dennis", "MasterMannen").equals("Hello Dennis MasterMannen");
    }

    @Test
    public void testHelloParamsDefault() {
        assert helloWorldController.helloParams("Dennis", null).equals("Hello Dennis ");
    }

    @Test
    public void testHelloParamList() {
        assert helloWorldController.helloWorldList(List.of("1", "2", "3", "4", "hej")).equals("Hello [1, 2, 3, 4, hej]");
    }

    @Test
    public void testHelloPathParam() {
        assert helloWorldController.helloWPathParam("Dennis").equals("Hello Dennis");
    }

}
