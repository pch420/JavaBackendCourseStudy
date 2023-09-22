package com.exam;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.exam.dto.DeptDTO;
import com.exam.service.DeptService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.out.println("BootTemplateApplication 실행");
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		DeptService service = ctx.getBean("xxx", DeptService.class);
		List<DeptDTO> list = service.deptList();
		System.out.println(list);
	}

}
