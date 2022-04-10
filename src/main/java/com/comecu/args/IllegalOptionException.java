package com.comecu.args;

/**
 * IllegalOptionException
 *
 * @author comeCU
 * @date 2022/4/10 20:02
 */
public class IllegalOptionException extends RuntimeException {
    private final String parameter;

    public IllegalOptionException(String parameter) {
        this.parameter = parameter;
    }

    public String getParameter() {
        return parameter;
    }
}
