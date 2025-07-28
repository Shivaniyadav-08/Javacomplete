package com.microservices.user.service.UserService.Exception;


import com.microservices.user.service.UserService.Payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionhandler {

    // it will handle exception globally

    @ExceptionHandler(ResourceNotFoundException.class)// any expection occur in this project it will execute this method
   public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex){
        String message = ex.getMessage();//Extracts the exception message from ResourceNotFoundException,


        /*Creates a custom response object (ApiResponse) using Lombok's @Builder pattern.It fills in 3 fields:
            message → the error message (from the exception)
            success → tells if request was successful (⚠️ should be false for error actually)
            status → sets HTTP status (404 NOT FOUND)*/
        ApiResponse apiResponse =ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();

        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);

   }
}
