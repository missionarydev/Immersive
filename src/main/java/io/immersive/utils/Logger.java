package io.immersive.utils;

import io.immersive.game.Color;
import lombok.Getter;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.fusesource.jansi.Ansi;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.EnumMap;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class Logger extends Formatter {
    @Getter private static final Color[] COLORS = Color.values();
    @Getter private static final EnumMap<Color, String> REPLACEMENTS = new EnumMap<>(Color.class);
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("hh:mm:ssaa");

    static {
        // Colors 0-9
        REPLACEMENTS.put(Color.BLACK, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.BLACK).boldOff().toString());
        REPLACEMENTS.put(Color.DARK_BLUE, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.BLUE).boldOff().toString());
        REPLACEMENTS.put(Color.GREEN, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.GREEN).boldOff().toString());
        REPLACEMENTS.put(Color.CYAN, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.CYAN).boldOff().toString());
        REPLACEMENTS.put(Color.RED, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.RED).boldOff().toString());
        REPLACEMENTS.put(Color.PURPLE, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.MAGENTA).boldOff().toString());
        REPLACEMENTS.put(Color.ORANGE, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.YELLOW).boldOff().toString());
        REPLACEMENTS.put(Color.LIGHT_GRAY, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.WHITE).boldOff().toString());
        REPLACEMENTS.put(Color.GRAY, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.BLACK).bold().toString());
        REPLACEMENTS.put(Color.BLUE, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.BLUE).bold().toString());

        // Colors a-f
        REPLACEMENTS.put(Color.LIGHT_BLUE, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.CYAN).bold().toString());
        REPLACEMENTS.put(Color.LIGHT_GREEN, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.GREEN).bold().toString());
        REPLACEMENTS.put(Color.LIGHT_RED, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.RED).bold().toString());
        REPLACEMENTS.put(Color.PINK, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.MAGENTA).bold().toString());
        REPLACEMENTS.put(Color.YELLOW, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.YELLOW).bold().toString());
        REPLACEMENTS.put(Color.WHITE, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.WHITE).bold().toString());

        // Modifiers
        REPLACEMENTS.put(Color.BOLD, Ansi.ansi().a(Ansi.Attribute.UNDERLINE_DOUBLE).toString());
        REPLACEMENTS.put(Color.STRIKE_THROUGH, Ansi.ansi().a(Ansi.Attribute.STRIKETHROUGH_ON).toString());
        REPLACEMENTS.put(Color.UNDER_LINE, Ansi.ansi().a(Ansi.Attribute.UNDERLINE).toString());
        REPLACEMENTS.put(Color.ITALIC, Ansi.ansi().a(Ansi.Attribute.ITALIC).toString());
        REPLACEMENTS.put(Color.RESET, Ansi.ansi().a(Ansi.Attribute.RESET).toString());
    }

    @Override
    public String format(@NonNull final LogRecord record) {
        final String message = String.format("[%s %s]: %s\n", DATE_FORMAT.format(record.getMillis()), record.getLevel().getName(), record.getMessage());

        appendToFile(message);

        return message;
    }

    @SneakyThrows(IOException.class)
    public static void appendToFile(@NonNull final String display) {
        final FileWriter fw = new FileWriter(Directories.getLogsDirectory() + File.separator + "latest.log", true);
        final BufferedWriter bw = new BufferedWriter(fw);
        final PrintWriter out = new PrintWriter(bw);

        out.print(display);
        out.close();
    }
}
