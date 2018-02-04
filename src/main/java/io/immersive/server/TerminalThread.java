package io.immersive.server;

import lombok.*;
import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.UserInterruptException;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TerminalThread extends Thread {
    @Getter(AccessLevel.PRIVATE) private final Server server;

    @Getter(AccessLevel.PRIVATE) private final Terminal terminal;
    @Getter(AccessLevel.PRIVATE) private final LineReader reader;

    @Getter(AccessLevel.PROTECTED) @Setter(AccessLevel.PROTECTED) private boolean running;

    @SneakyThrows(IOException.class)
    TerminalThread(@NonNull final Server server) {
        super("Terminal Thread");

        this.server = server;
        this.terminal = TerminalBuilder.builder().name("Immersive Console").system(true).build();
        this.reader = LineReaderBuilder.builder().terminal(terminal).build();

        this.running = true;

        this.start();
    }

    public void run() {
        try {
            while(this.isRunning()) {
                String line = this.reader.readLine("> ");

                if(line == null)
                    continue;

                final List<String> args;
                final String label;

                if(line.contains(" ")) {
                    args = Arrays.asList(line.split(" "));
                } else {
                    args = new ArrayList<>();
                }

                if(line.contains(" ")) {
                    label = args.get(0);
                } else {
                    label = line;
                }

                this.getServer().getCommandManager().callCommand(this.getServer().getConsole(), label, args);
                this.terminal.flush();
            }
        } catch (UserInterruptException | EndOfFileException ignored) { }
    }
}
