package com.bluetree.office.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Employee Record Already Existing")
public class EmployeeAlreadyExistingException extends Exception{
}
