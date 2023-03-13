package com.lsz.observer.eventbus;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AsyncEventBus extends EventBus {
    private Executor executor;

    public AsyncEventBus(Executor executor) {
        super();
        this.executor = executor;
    }

    public AsyncEventBus() {
        this(Executors.newSingleThreadExecutor());
    }

    @Override
    public void post(Object event) {
        executor.execute(() -> super.post(event));
    }
}
