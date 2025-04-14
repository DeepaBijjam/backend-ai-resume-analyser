package com.yimobility.airesume;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication

public class AiresumeApplication {

	private static ApplicationContext context;
	public static void main(String[] args) throws Exception{

		SpringApplication.run(AiresumeApplication.class, args);


	}
	


//	@Bean
//	CommandLineRunner commandLineRunner(ChatClient.Builder builder) {
//		return args -> {
//			var client = builder.build();
//			
//			String response = client.prompt("Tell me about Sri Rama Navami festival")
//			.call()
//					.content();
//			System.out.println(response);
//		};
//	}

	}
	


