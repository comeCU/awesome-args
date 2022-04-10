package com.comecu.args;

/**
 * InsufficientArgumentsException
 *
 * @author comeCU
 * @date 2022/4/10 17:56
 */
public class InsufficientArgumentsException extends RuntimeException {
    private final String option;

    public InsufficientArgumentsException(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
