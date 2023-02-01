package threadSafeList;

import java.util.ArrayList;
import java.util.List;

public class ThreadSafeList<E> {
    private volatile List<E> list = new ArrayList<>();
    private static volatile Boolean mutex = true;

    public void add(int index, E i) {
        synchronized (mutex) {
            list.add(index, i);
        }
    }

    public void remove(int index) {
        synchronized (mutex) {
            if (!list.isEmpty()) {
                list.remove(index);
            } else {
                return;
            }
        }
    }

    public E get(int index) {
        synchronized (mutex) {
            if (!list.isEmpty()) {
                return list.get(index);
            } else {
                return null;
            }
        }
    }
}

class ThreadListAdd implements Runnable {
    private ThreadSafeList list = new ThreadSafeList();
    private int index;
    private String object;

    public ThreadListAdd(int index, String object) {
        this.index = index;
        this.object = object;
    }

    @Override
    public void run() {
        list.add(index, object);
    }
}

class ThreadListRemove implements Runnable {
    private ThreadSafeList list = new ThreadSafeList();
    private int index;
    private int object;

    public ThreadListRemove(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        list.remove(index);
    }
}

class ThreadListGet implements Runnable {
    private ThreadSafeList list = new ThreadSafeList();
    private int index;
    private int object;

    public ThreadListGet(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        list.get(index);
    }
}
