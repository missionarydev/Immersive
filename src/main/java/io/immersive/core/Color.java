package io.immersive.core;

import lombok.Getter;
import lombok.NonNull;

import java.util.regex.Pattern;

public enum Color {
    BLACK('0', 0x00),
    DARK_BLUE('1', 0x1),
    GREEN('2', 0x2),
    CYAN('3', 0x3),
    RED('4', 0x4),
    PURPLE('5', 0x5),
    ORANGE('6', 0x6),
    LIGHT_GRAY('7', 0x7),
    GRAY('8', 0x8),
    BLUE('9', 0x9),
    LIGHT_GREEN('a', 0xA),
    LIGHT_BLUE('b', 0xB),
    LIGHT_RED('c', 0xC),
    PINK('d', 0xD),
    YELLOW('e', 0xE),
    WHITE('f', 0xF),
    BOLD('l', 0x11, true),
    STRIKE_THROUGH('m', 0x12, true),
    UNDER_LINE('n', 0x13, true),
    ITALIC('o', 0x14, true),
    RESET('r', 0x15);

    public static final char COLOR_CODE = '\u00A7';
    private static final Pattern STRIP_PATTERN = Pattern.compile("(?i)" + String.valueOf(COLOR_CODE) + "[0-9A-FK-OR]");

    @Getter private final char code;
    @Getter private final int color;
    @Getter private final boolean format;

    Color(@NonNull final char code, @NonNull final int color, @NonNull final boolean format) {
        this.code = code;
        this.color = color;
        this.format = format;
    }

    Color(@NonNull final char code, @NonNull final int color) {
        this(code, color, false);
    }

    public static String color(@NonNull final String input) {
        return color('&', input);
    }

    public static String color(@NonNull final char code, @NonNull final String input) {
        char[] charInput = input.toCharArray();

        for (int i = 0; i < charInput.length - 1; i++) {
            if(charInput[i] == code && "0123456789AaBbCcDdEeFfKkLlMmNnOoRr".indexOf(charInput[i+1]) > -1) {
                charInput[i] = COLOR_CODE;
                charInput[i+1] = Character.toLowerCase(charInput[i+1]);
            }
        }

        return String.valueOf(charInput);
    }

    public static String strip(@NonNull final String input) {
        return STRIP_PATTERN.matcher(input).replaceAll("");
    }

    @Override
    public String toString() {
        return String.valueOf('\u00A7' + this.getCode());
    }
}
