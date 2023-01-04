package com.om.example.routes;

import com.om.example.handlers.EmployeeHandler;
import com.om.example.struct.Employee;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.fn.builders.operation.Builder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.function.Consumer;

import static org.springdoc.core.fn.builders.apiresponse.Builder.responseBuilder;
import static org.springdoc.core.fn.builders.content.Builder.contentBuilder;
import static org.springdoc.core.fn.builders.schema.Builder.schemaBuilder;
import static org.springdoc.webflux.core.fn.SpringdocRouteBuilder.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Component
@RequiredArgsConstructor
public class EmployeeRoute implements BaseRouter{
  private final EmployeeHandler handler;
  @Override
  public String basePath() {
    return "/employee";
  }
  @Override
  public String routeTagName() {
    return "Employee";
  }

  @Override
  public String routeTagDescription() {
    return "Employee CRUD";
  }
  @Override
  public RouterFunction<ServerResponse> routerRoute() {
    return route()
      .GET(
        "",
        accept(MediaType.APPLICATION_JSON),
        handler::getAllEmployees,
        incorporationOps()
      )
      .build();
  }
  private Consumer<Builder> incorporationOps() {

    return ops -> ops
      .tag(routeTagName())
      .description("Sample Employee API")
      .beanClass(EmployeeHandler.class)
      .beanMethod("getAllEmployees")
      .operationId("getAllEmployees")
      .response(
        responseBuilder()
          .responseCode("200")
          .description("OK")
          .content(
            contentBuilder()
              .schema(
                schemaBuilder()
                  .name("TopicListResponse")
                  .implementation(Employee.class)
              )
              .mediaType(MediaType.APPLICATION_JSON_VALUE)
          )

      );
  }


}
