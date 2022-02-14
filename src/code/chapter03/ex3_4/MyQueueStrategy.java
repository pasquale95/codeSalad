package chapter03.ex3_4;

import utils.exceptions.EmptyQueueException;

public interface MyQueueStrategy {
    void add(Integer data);
    Integer remove() throws EmptyQueueException;
    Integer peek() throws EmptyQueueException;
}
