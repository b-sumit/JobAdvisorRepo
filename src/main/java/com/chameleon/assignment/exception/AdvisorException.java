package com.chameleon.assignment.exception;

public class AdvisorException extends RuntimeException {

  private int code;

  public AdvisorException(int code, String message) {
    super(message);
    this.code = code;
  }

  public int getCode() {
    return code;
  }
}
