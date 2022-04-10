package com.comecu.args;

/**
 * TooManyArgumentsException
 *
 * @author comeCU
 * @date 2022/4/10 11:17
 */
public class TooManyArgumentsException extends RuntimeException{
    private final String option;

    public TooManyArgumentsException(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
