package com.knubisoft.base.queue;

import com.knubisoft.base.queue.car.Car;
import com.knubisoft.base.queue.car.CarComparator;
import org.checkerframework.checker.units.qual.C;

import java.util.*;

public class QueueTasksImpl extends CarComparator implements QueueTasks {

    @Override
    public Queue<Integer> reverseQueueUsingRecursion(Queue<Integer> queue) {
        if (queue.isEmpty())
            return queue;
        int num = queue.poll();
        queue = reverseQueueUsingRecursion(queue);
        queue.add(num);
        return queue;
    }

    @Override
    public Queue<Integer> reverseFirstKElementsOfQueue(Queue<Integer> queue, int k) {
        List<Integer> list = new LinkedList<>();
        while (k > 0){
            list.add(0, queue.poll());
            k--;
        }
        list.addAll(queue);
        queue = (Queue<Integer>) list;
        return queue;
    }

    @Override
    public Queue<Integer> sortQueueOfInt(Queue<Integer> queue) {
        List<Integer> list = new LinkedList<>(queue);
        for (int j = 0; j < list.size()-1; j++) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    int temp = list.get(i + 1);
                    list.set(i + 1, list.get(i));
                    list.set(i, temp);
                }
            }
        }
        return (Queue<Integer>) list;
    }

    @Override
    public boolean validParentheses(String parentheses) {
        Queue<Character> queue = new ArrayDeque<>();
        char[] arr = parentheses.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            queue.add(arr[i]);
        }
        if (!queue.isEmpty()) {
            int k = 0;
            char ch = queue.poll();
            return ch == ')' && arr[k] == '(' ||
                    ch == '}' && arr[k] == '{' || ch == ']' && arr[k] == '[';
        }
        return false;
    }

    @Override
    public PriorityQueue<Car> implementPriorityQueueThroughComparator(List<Car> cars) {
        PriorityQueue<Car> priorityQueue = new PriorityQueue<>(cars.size(), new CarComparator());
        priorityQueue.addAll(cars);
        return priorityQueue;
    }
}
