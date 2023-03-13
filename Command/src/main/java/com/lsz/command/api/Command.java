package com.lsz.command.api;

public interface Command {
    void execute();

    public static enum Event {
        LIST
    }
}
