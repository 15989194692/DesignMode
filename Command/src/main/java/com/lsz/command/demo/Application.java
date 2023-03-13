package com.lsz.command.demo;

import com.lsz.command.api.Command;
import com.lsz.command.api.CommandFactory;
import com.lsz.command.api.Request;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Application {

    private static final int MAX_HANDLED_REQ_COUNT_PER_LOOP = 100;
    private Queue<Command> queue = new LinkedList<>();

    public void mainloop() {
        while (true) {
            List<Request> requests = new ArrayList<>();
            for (Request request : requests) {
                Command command = CommandFactory.getCommand(request.getEvent().name());
                queue.add(command);
            }

            int count = MAX_HANDLED_REQ_COUNT_PER_LOOP;
            while (count-- > 0 && !queue.isEmpty()) {
                final Command command = queue.remove();
                command.execute();
            }
        }
    }

}
