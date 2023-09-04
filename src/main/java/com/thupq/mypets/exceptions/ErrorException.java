package com.thupq.mypets.exceptions;

import com.thupq.mypets.common.MessageUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * @author Charizard
 */
@Getter
@AllArgsConstructor
public class ErrorException extends RuntimeException {

  private Error error;
  private HttpStatus status;


  public static ErrorException notFound(String codeMessage) {
    return new ErrorException(
        Error.builder()
            .code(Error.CodeEnum.NOT_FOUND)
            .messages(List.of(MessageUtils.getMessage(codeMessage)))
            .build(),
        HttpStatus.NOT_FOUND
    );
  }
}
