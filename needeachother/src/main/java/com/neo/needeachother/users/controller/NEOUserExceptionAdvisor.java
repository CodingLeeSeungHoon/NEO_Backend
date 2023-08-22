package com.neo.needeachother.users.controller;

import com.neo.needeachother.common.enums.NEOResponseCode;
import com.neo.needeachother.common.exception.NEOExpectedException;
import com.neo.needeachother.common.response.NEOErrorResponse;
import com.neo.needeachother.common.response.NEOResponseBody;
import com.neo.needeachother.users.exception.NEOUserExpectedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

/**
 * @author 이승훈<br>
 * @since 23.08.21<br>
 * User 도메인에서 발생한 Exception을 컨트롤러 레벨에서 제어할 수 있습니다.
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.neo.needeachother.users.controller")
public class NEOUserExceptionAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NEOUserExpectedException.class})
    public ResponseEntity<NEOResponseBody<?>> handleUserExceptionFromAPIMethod(NEOUserExpectedException ex){
        log.warn(ex.getMessage());
        return handleUserExceptionInternal(ex);
    }

    @ExceptionHandler(value = {NEOExpectedException.class})
    public ResponseEntity<?> handleExpectedExceptionFromAPIMethod(NEOExpectedException ex){
        return null;
    }

    public ResponseEntity<NEOResponseBody<?>> handleUserExceptionInternal(final NEOUserExpectedException ex){
        List<NEOErrorResponse> errorResponseList = ex.getErrorResponseList();
        NEOUserInformationController.NEOUserOrder userOrder = ex.getUserOrder();

        return ResponseEntity.status(ex.getErrorResponseList().get(0).getNeoErrorCode().getHttpStatus())
                .body(renderResponseBody(errorResponseList, userOrder));
    }

    public NEOResponseBody<?> renderResponseBody(final List<NEOErrorResponse> errorResponseList, final NEOUserInformationController.NEOUserOrder userOrder){
        return NEOResponseBody.builder()
                .requestedMethodAndURI(userOrder.getRequestedMethodAndURI())
                .responseCode(NEOResponseCode.FAIL)
                .msg(userOrder.getFailMessage())
                .errors(errorResponseList)
                .build();
    }

}
