package com.example.nba;

import com.example.nba.dao.Filler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NbaApplication {
    public static void main(String[] args) {
        SpringApplication.run(NbaApplication.class, args);
    }

}
