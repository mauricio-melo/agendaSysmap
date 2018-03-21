package br.com.sysmap.agendaSysmap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;
import org.springframework.web.servlet.LocaleResolver;


import java.util.Locale;

@SpringBootApplication
public class AgendaSysmapApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaSysmapApplication.class, args);
	}

}
