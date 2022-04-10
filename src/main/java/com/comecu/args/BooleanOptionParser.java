package com.comecu.args;

import java.util.List;

/**
 * BooleanParser
 *
 * @author comeCU
 * @date 2022/4/9 0:37
 */
class BooleanOptionParser implements OptionParser<Boolean> {

    @Override
    public Boolean parse(List<String> arguments, Option option) {
        int index = arguments.indexOf("-" + option.value());
        if ((index + 1) < arguments.size() &&
                !arguments.get(index + 1).startsWith("-")) {
            throw new TooManyArgumentsException(option.value());
        }
        return index != -1;
    }
}
