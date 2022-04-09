package com.comecu.args;

import java.util.List;

/**
 * IntOptionParser
 *
 * @author comeCU
 * @date 2022/4/9 0:37
 */
class IntOptionParser implements OptionParser {

    @Override
    public Object parse(List<String> arguments, Option option) {
        int index = arguments.indexOf("-" + option.value());
        return Integer.parseInt(arguments.get(index + 1));
    }
}
