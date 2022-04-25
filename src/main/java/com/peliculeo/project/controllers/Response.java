package com.peliculeo.project.controllers;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Response {
 
    public static int NO_ERROR = 0;
    public static int NOT_FOUND = 101;
 
    public static final String NO_MESSAGE = "";
 
    public Response(Error error ) {
	}
 
    @Data
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    static class Error {
    	
        public Error(int NO_ERROR, String NO_MESSAGE) {
			this.errorCode = NO_ERROR;
			this.message = NO_MESSAGE;
		}
		private int errorCode;
        private String message;
    }
 
  
	public static Response noErrorResponse() {
        return new Response(new Error(NO_ERROR, NO_MESSAGE));
    }
 
    public static Response errorResonse(int errorCode, String errorMessage) {
        return new Response(new Error(errorCode, errorMessage));
    }
}