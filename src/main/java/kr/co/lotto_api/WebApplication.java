package kr.co.lotto_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class WebApplication extends SpringBootServletInitializer {

  public static String licensePath;
  public static String licenseName;

  public static void main(String[] args) {

    for (String a : args) {
      if (a.contains("license.path")) {
        licensePath = a.split("license.path=")[1];
      }
      if (a.contains("license.file")) {
        licenseName = a.split("license.file=")[1];
      }
    }
    //TODO plink 디비 생성 CreatePlink.create("1009");
    SpringApplication.run(WebApplication.class, args);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    return builder.sources(WebApplication.class);
  }
}