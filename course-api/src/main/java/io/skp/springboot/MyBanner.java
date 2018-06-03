package io.skp.springboot;

import java.io.PrintStream;

import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;

public class MyBanner implements Banner{

	@Override
	public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
		out.println("================================");
		out.println("----------Hello World!----------");
		out.println("================================");
	}

}
