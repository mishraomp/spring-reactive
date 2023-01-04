package com.om.example.utils.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.function.Consumer;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HandlerUtils {


  public static Consumer<ResponseStatusException> handleStatusResponse() {
    return t -> ServerResponse.status(t.getStatusCode())
        .body(
            BodyInserters
                .fromPublisher(
                    Mono
                        .justOrEmpty(
                            Optional
                                .ofNullable(t.getReason())
                        ),
                    String.class
                )
        );
  }

  public static Consumer<Throwable> handleError() {
    return throwable ->
        ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(BodyInserters.fromValue(throwable.getMessage()));
  }
}
