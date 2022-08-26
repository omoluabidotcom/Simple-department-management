package com.example.departmentproject.error;

public class DepartmentNameNotFound extends Exception{

    public DepartmentNameNotFound() {
    }

    public DepartmentNameNotFound(String message) {
        super(message);
    }

    public DepartmentNameNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentNameNotFound(Throwable cause) {
        super(cause);
    }

    public DepartmentNameNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
