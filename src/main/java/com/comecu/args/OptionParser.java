package com.comecu.args;

import java.util.List;

/**
 * OptionParser
 *
 * @author comeCU
 * @date 2022/4/9 0:37
 */
interface OptionParser {
    Object parse(List<String> arguments, Option option);
}
