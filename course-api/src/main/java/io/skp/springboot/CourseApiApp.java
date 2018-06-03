package io.skp.springboot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseApiApp {

	public static void main(String[] args) {
		/*SpringApplication application=new SpringApplication(CourseApiApp.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);*/
		//SpringApplication.run(CourseApiApp.class, args);
		SpringApplication application=new SpringApplication(CourseApiApp.class);
		application.setBanner(new MyBanner());
		application.run(args);
	}

}
