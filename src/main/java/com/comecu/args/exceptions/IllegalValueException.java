package com.comecu.args.exceptions;

/**
 * IllegalValueException
 *
 * @author comeCU
 * @date 2022/4/21 16:35
 */
public class IllegalValueException extends RuntimeException {
    private final String option;
    private final String value;

    public IllegalValueException(String option, String value) {
        this.option = option;
        this.value = value;
    }
}
