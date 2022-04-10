package com.comecu.args;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.annotation.Annotation;
import java.util.function.Function;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * SingleValuedOptionParser
 *
 * @author comeCU
 * @date 2022/4/10 11:02
 */
public class SingleValuedOptionParserTest {
    // sad path
    // -int -p/ -p 8080 8081
    @Test
    public void should_not_accept_extra_argument_for_single_valued_option() {
        TooManyArgumentsException e = assertThrows(TooManyArgumentsException.class, () -> {
            new SingleValuedOptionParser<Integer>(0, Integer::parseInt).parse(asList("-p", "8080", "8081"), option("p"));
        });

        assertEquals("p", e.getOption());
    }

    @ParameterizedTest
    @ValueSource(strings = {"-p -l", "-p"})
    public void should_not_accept_insufficient_argument_for_single_valued_option(String arguments) {
        InsufficientArgumentsException e = assertThrows(InsufficientArgumentsException.class, () -> {
            new SingleValuedOptionParser<Integer>(0, Integer::parseInt).parse(asList(arguments.split(" ")), option("p"));
        });

        assertEquals("p", e.getOption());
    }

    // -string -d/ -d /usr/logs /usr/vars
    @Test
    public void should_not_accept_extra_argument_for_string_single_valued_option() {
        TooManyArgumentsException e = assertThrows(TooManyArgumentsException.class, () -> {
            new SingleValuedOptionParser<>("", String::valueOf).parse(asList("-d", "/usr/logs", "/usr/vars"), option("d"));
        });

        assertEquals("d", e.getOption());
    }

    // default value:
    // - int : 0
    @Test
    public void should_set_default_value_for_single_valued_option() {
        Function<String, Object> whatever = (it) -> null;
        Object defaultValue = new Object();
        assertSame(defaultValue, new SingleValuedOptionParser<>(defaultValue, whatever).parse(asList(), option("p")));
    }

    // happy path
    @Test
    public void should_parse_value_if_flag_present() {
        Object parsed = new Object();
        Function<String, Object> parse = (it) -> parsed;
        Object whatever = new Object();
        assertEquals(parsed, new SingleValuedOptionParser<>(whatever, parse).parse(asList("-p", "8080"), option("p")));
    }

    static Option option(String value) {
        return new Option() {

            @Override
            public Class<? extends Annotation> annotationType() {
                return Option.class;
            }

            @Override
            public String value() {
                return value;
            }
        };
    }

}
