package com.epam.backend.core.cleancode.sonarqube;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

@RestController
class SampleController {
    private Random random = new Random();
    @GetMapping("/unsafe")
    public String unsafeMethod(String input) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "password");
            Statement statement = connection.createStatement();
            // Intentional SQL Injection flaw
            statement.executeQuery("SELECT * FROM user_data WHERE user_name = '" + input + "'");
            return "Data Retrieved";
        } catch (SQLException e) {
            return "Error in SQL Handling";
        }
    }

    @GetMapping("/logic-error")
    public int faultyLogic() {
        int a = 10;
        int b = 0;
        // Intentional Division by Zero error
        return a / b;
    }


    @GetMapping("/duplicate-code")
    public String duplicateCodeExample(String input) {
        // Duplicated code from complexMethod
        int result = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 20; j++) {
                result += i * j;
            }
        }

        if (result > 1000) {
            return "Large Result";
        } else if (result > 500) {
            return "Medium Result";
        } else {
            return "Small Result";
        }
    }

    @GetMapping("/complex-method")
    public String complexMethod() {
        // Intentionally complex and long method
        int result = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 20; j++) {
                result += i * j;
            }
        }

        if (result > 1000) {
            return "Large Result";
        } else if (result > 500) {
            return "Medium Result";
        } else {
            return "Small Result";
        }
    }

    @GetMapping("/random-bug")
    public String randomBug() {
        int number = random.nextInt(10);
        // Intentional bug: ArrayIndexOutOfBoundsException
        int[] array = new int[5];
        array[number] = 1;
        return "Random number stored";
    }
}
