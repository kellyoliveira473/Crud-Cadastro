package com.kelly.Compra_usuario_padaria.exceptions;

public class ResourceNotFoundException extends RuntimeException {
  public ResourceNotFoundException(String message) {
    super(message);
  }
  public ResourceNotFoundException(Long id){

  }

}
