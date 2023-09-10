package com.gradle.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class JavaUnitTests {

    @Test
    void test() {
        System.err.println("Hello " + this.getClass());
    }
}
