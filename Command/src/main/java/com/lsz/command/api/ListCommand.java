package com.lsz.command.api;

public class ListCommand<T> implements Command {
    private T t;

    public ListCommand(T t) {
        this.t = t;
    }

    @Override
    public void execute() {
        /*
        do your action
        * */
    }
}
