package org.demo.entities;

import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Getter
public class TestConfig {

    private final Properties props;
    private String validUserName;
    private String validPassword;
    private String inValidUserName;
    private String inValidPassword;
    private String baseUrl;
    private String apiUrl;

    public TestConfig() {
        props = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("configs/configs.properties")) {
            props.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configs.properties", e);
        }
    }

}
