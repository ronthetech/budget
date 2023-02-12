package com.ronjeanfrancois.budget;

import com.ronjeanfrancois.budget.config.RedisSessionConfig;
import jakarta.servlet.http.HttpSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Import(RedisSessionConfig.class)
@RestController
public class BudgetApplication {

	public static void main(String[] args) {
		SpringApplication.run(BudgetApplication.class, args);
	}

	@GetMapping("/")
	String example(HttpSession session) {
		session.setAttribute("example", "value");
		return "Example";
	}
}
