package com.comecu.args;

import java.util.List;
import java.util.function.Function;

/**
 * IntOptionParser
 *
 * @author comeCU
 * @date 2022/4/9 0:37
 */
class SingleValuedOptionParser<T> implements OptionParser {
    Function<String, T> valueParser;

    public SingleValuedOptionParser(Function<String, T> valueParser) {
        this.valueParser = valueParser;
    }

    @Override
    public Object parse(List<String> arguments, Option option) {
        int index = arguments.indexOf("-" + option.value());
        String value = arguments.get(index + 1);
        return valueParser.apply(value);
    }

}
