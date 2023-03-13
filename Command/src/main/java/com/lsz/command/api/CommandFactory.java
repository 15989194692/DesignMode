package com.lsz.command.api;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CommandFactory {

    private static final Map<String, Class<? extends Command>> COMMAND_MAP = new HashMap<>();
    static {
        COMMAND_MAP.put(Command.Event.LIST.name(), ListCommand.class);
    }

    public static Command getCommand(String event, Objects... params) {
        Class<? extends Command> commandClass = null;
        if ((commandClass = COMMAND_MAP.get(event)) == null) {
            throw new IllegalArgumentException("Can not find command which event: " + event);
        }
        try {
            Class[] paramTypes = new Class[params.length];
            int curator = 0;
            for (Object param : params) {
                paramTypes[curator++] = param.getClass();
            }
            Constructor<? extends Command> constructor = commandClass.getConstructor(paramTypes);
            Command command = constructor.newInstance(params);
            return command;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
