package com.comecu.args;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Args
 *
 * @author comeCU
 * @date 2022/4/7 16:40
 */
public class Args {

    public static <T> T parse(Class<T> optionClass, String... args) {
        try {
            List<String> arguments = Arrays.asList(args);
            Constructor<?> constructor = optionClass.getDeclaredConstructors()[0];

            Object[] values = Arrays.stream(constructor.getParameters()).map(it -> parseOption(arguments, it)).toArray();

            return (T) constructor.newInstance(values);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Object parseOption(List<String> arguments, Parameter parameter) {
        return PARSERS.get(parameter.getType()).parse(arguments, parameter.getAnnotation(Option.class));
    }
    
    private static Map<Class<?>, OptionParser> PARSERS = Map.of(
            boolean.class, new BooleanParser(),
            int.class, new IntOptionParser(),
            String.class, new StringOptionParser());

}
