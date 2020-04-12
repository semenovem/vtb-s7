package ru.vtb.s7.client.mkb;

/**
 * Просто эксперимент для параллельной работы потоков на чтение / запись
 */
public class MessageQueue {
    private static class Item {
        public Status status = Status.EMPTY;
        String msg;
    }

    private enum Status {
        EMPTY,
        DURING,
        READY,
        IN_PROGRESS,
        ERROR;
    }

    /**
     * Указывает на последний добавленный элемент
     */
    private int pointerLast = 0;

    /**
     * Указывает на последний элемент, который был взят в работу
     */
    private int pointerInProgress = -1;

    private int size;

    private Item[] queue;

    MessageQueue() {
        init(100);
    }

    MessageQueue(int size) {
        init(size);
    }

    private void init(int size) {
        this.size = size;
        queue = new Item[size];
    }

    private int maxCount = 1000;

    public void add(String msg) throws Exception {
        if (movePointerLast()) {
            throw new Exception("Queue is full");
        }


        queue[pointerLast].msg = msg;
        queue[pointerLast].status = Status.READY;
        pointerLast++;
    }

    public String get() {
        if (pointerInProgress == -1) {
            return null;
        }

        if (queue[pointerInProgress + 1].status == Status.READY) {
            pointerInProgress++;
            queue[pointerInProgress].status = Status.IN_PROGRESS;

            return queue[pointerInProgress].msg;
        }

        return "test";
    }

    /**
     * Передвигаем указатель на следующую свободную ячейку
     * TODO Этому методу нужно обеспечить потокобезопасность
     *
     */
    private boolean movePointerLast() {
        int next;

        do {
            next = pointerLast + 1;
            if (next == size) {
                next = 0;
            }

            // догнали указатель pointerInProgress - значит все занято
            if (next == pointerInProgress) {
                return false;
            }

        } while(queue[next].status != Status.EMPTY);

        pointerLast = next;
        queue[next].status = Status.DURING;

        return true;
    }
}
