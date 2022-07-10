package com.bluetree.office.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Employee record Not Found")
public class EmployeeNotFoundException extends Exception{
}
