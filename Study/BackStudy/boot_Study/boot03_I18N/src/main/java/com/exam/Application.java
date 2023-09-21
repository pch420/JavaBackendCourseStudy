package com.exam;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.out.println("BootTemplateApplication 실행");
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		String mesg = ctx.getMessage("greeting", null, null, Locale.KOREA);
		String mesg2 = ctx.getMessage("greeting", null, null, Locale.ENGLISH);
		String mesg3 = ctx.getMessage("greeting", null, null, Locale.CHINA);

		System.out.println(mesg);
		System.out.println(mesg2);
		System.out.println(mesg3);
	}

}
