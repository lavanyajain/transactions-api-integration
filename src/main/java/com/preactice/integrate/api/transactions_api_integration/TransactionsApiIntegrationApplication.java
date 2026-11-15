package com.preactice.integrate.api.transactions_api_integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class TransactionsApiIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionsApiIntegrationApplication.class, args);
	}

}
