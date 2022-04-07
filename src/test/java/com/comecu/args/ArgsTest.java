package com.comecu.args;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * ArgsTest
 *
 * @author comeCU
 * @date 2022/4/7 16:41
 */
public class ArgsTest {
    /* ----------- Happy Path start ----------- */
    // Single Option
    // - Bool -l
    @Test
    public void should_set_boolean_option_to_true_if_flag_present() {
        BooleanOption option = Args.parse(BooleanOption.class, "-l");

        assertTrue(option.logging());
    }

    // 写一个与之相反的测试
    @Test
    public void should_set_boolean_option_to_false_if_flag_not_present() {
        BooleanOption option = Args.parse(BooleanOption.class);

        assertFalse(option.logging());
    }

    static record BooleanOption(@Option("l") boolean logging) {}

    // - Integer -p 8080
    @Test
    public void should_set_int_option_value() {
        IntOption option = Args.parse(IntOption.class, "-p", "8080");

        assertEquals(8080, option.port());
    }

    static record IntOption(@Option("p") int port) {}

    // - String -d /usr/logs
    @Test
    public void should_get_string_option_value() {
        StringOption option = Args.parse(StringOption.class, "-d", "/usr/logs");

        assertEquals("/usr/logs", option.directory());
    }

    static record StringOption(@Option("d") String directory) {}

    // Multi Options
    // -l -p 8080 -d /usr/logs
    @Test
    public void should_parse_multi_options() {
        Options options = Args.parse(Options.class, "-l", "-p", "8080", "-d", "/usr/logs");
        assertTrue(options.logging());
        assertEquals(8080, options.port());
        assertEquals("/usr/logs", options.directory());
    }

    static record Options(@Option("l") boolean logging, @Option("p") int port, @Option("d") String directory) {
    }
    /* ----------- Happy Path end ----------- */

    // sad path:
    // -bool -l t / -l t f
    // -int -p/ -p 8080 8081
    // -string -d/ -d /usr/logs /usr/vars
    // default value
    // - bool : false
    // - int : 0
    // -string ""



    @Test
    @Disabled
    public void should_example_2() {
        ListOptions options = Args.parse(ListOptions.class, "-g", "this", "is", "a", "list", "-d", "1", "2", "-3", "5");

        assertArrayEquals(new String[] {"this", "is", "a", "list"}, options.group());
        assertArrayEquals(new int[] {1, 2, -3, 5}, options.decimals());
    }

    static record ListOptions(@Option("g") String[] group, @Option("d") int[] decimals) {
    }

}
