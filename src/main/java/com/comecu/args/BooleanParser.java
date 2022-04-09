package com.comecu.args;

import java.util.List;

/**
 * BooleanParser
 *
 * @author comeCU
 * @date 2022/4/9 0:37
 */
class BooleanParser implements OptionParser {

    @Override
    public Object parse(List<String> arguments, Option option) {
        return arguments.contains("-" + option.value());
    }
}
