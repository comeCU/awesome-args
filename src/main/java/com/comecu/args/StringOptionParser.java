package com.comecu.args;

import java.util.List;

/**
 * StringOptionParser
 *
 * @author comeCU
 * @date 2022/4/9 0:38
 */
class StringOptionParser implements OptionParser {

    @Override
    public Object parse(List<String> arguments, Option option) {
        int index = arguments.indexOf("-" + option.value());
        return arguments.get(index + 1);
    }
}
