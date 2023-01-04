package com.om.example;

import com.om.example.routes.BaseRouter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.List;

import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;

@SpringBootApplication
@EnableR2dbcRepositories
public class SbReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbReactiveApplication.class, args);
	}
  @Bean
  public RouterFunction<ServerResponse> routes(List<BaseRouter> routes) {
    return
      routes
        .stream()
        .map(route -> nest(
          path(String.format("/api%s", route.basePath())),
          route.routerRoute())
        )
        .reduce(RouterFunction::and)
        .orElseThrow();

  }
}
