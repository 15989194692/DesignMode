package com.lsz.chain.array;

import java.util.ArrayList;
import java.util.List;

public class IFilterChain {
    private List<IHandler> handlers;

    public IFilterChain() {
        handlers = new ArrayList<IHandler>();
    }

    public IFilterChain(int size) {
        handlers = new ArrayList<IHandler>(size);
    }

    public void addHandler(IHandler handler) {
        handlers.add(handler);
    }

    public void handle() {
        for (IHandler handler : handlers) {
            boolean success = handler.handle();
            if (!success) {
                break;
            }
        }
    }



}
