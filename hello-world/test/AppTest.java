package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AppTest {
    @Test
    public void testSayHello() {
        App app = new App();
        assertEquals("Hello, Jenkins CI/CD!", app.sayHello());
    }
}

