package com.hsulimann.henrique.utils;

import com.hsulimann.henrique.handlers.exceptions.ResourceNotFoundException;

public abstract class Assert {

    public static void isPresent(Object object, String message, Object... args){
        if(object == null){
            String formattedMessage = String.format(message, args);
            throw new ResourceNotFoundException(formattedMessage);
        }
    }
    
}
