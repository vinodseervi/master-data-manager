package com.vi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MasterDataManagerApplication  {

	@Bean
	public ModelMapper modelMapper(){
		return modelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(MasterDataManagerApplication.class, args);
	}



}
