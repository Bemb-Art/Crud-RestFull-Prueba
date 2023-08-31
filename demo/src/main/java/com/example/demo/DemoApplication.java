package com.example.demo;

import com.example.demo.controller.EmpresaControllerSpark;
import com.example.demo.service.ServiceEmpresa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		new EmpresaControllerSpark(new ServiceEmpresa());


	}

}
