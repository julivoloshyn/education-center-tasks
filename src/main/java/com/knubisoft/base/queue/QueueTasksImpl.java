package com.knubisoft.base.queue;

import com.knubisoft.base.queue.car.Car;
import com.knubisoft.base.queue.car.CarComparator;

import java.util.*;
import java.util.stream.Collectors;

public class QueueTasksImpl implements QueueTasks {

    @Override
    public Queue<Integer> reverseQueueUsingRecursion(Queue<Integer> queue) {

        if (queue.isEmpty()){
            return queue;
        }

        int data = queue.peek();
        queue.remove();

        queue = reverseQueueUsingRecursion(queue);
        queue.add(data);

        return queue;
    }

    @Override
    public Queue<Integer> reverseFirstKElementsOfQueue(Queue<Integer> queue, int k) {

        if(queue.isEmpty() || k > queue.size() || k <= 0){
            return queue;
        }

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i< k; i++){
            stack.push(queue.peek());
            queue.remove();
        }

        while(!stack.isEmpty()){
            queue.add(stack.peek());
            stack.pop();
        }

        for(int i =0; i< queue.size() - k; i++){
            queue.add(queue.peek());
            queue.remove();
        }

        return queue;
    }

    @Override
    public Queue<Integer> sortQueueOfInt(Queue<Integer> queue) {

        List<Integer> temp = new ArrayList<>();

        while (!queue.isEmpty()){
            temp.add(queue.peek());
            queue.poll();
        }
        Collections.sort(temp);
        queue.addAll(temp);

        return queue;
    }

    @Override
    public boolean validParentheses(String parentheses) {
        if(parentheses.length() % 2 == 1){
            return false;
        }

        char[] chars = parentheses.toCharArray();
        Deque<Character> deque = new LinkedList<>();

        for(char c : chars){
            if(c == '(' || c == '{' || c == '[') {
                deque.push(c);
            } else {
                char queueSymbol = deque.peek();

                if(c == ')' && queueSymbol == '(') {
                    deque.pop();
                } else if (c == '}' && queueSymbol == '{') {
                    deque.pop();
                } else if(c == ']' && queueSymbol == '[') {
                    deque.pop();
                } else {
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }

    @Override
    public PriorityQueue<Car> implementPriorityQueueThroughComparator(List<Car> cars) {
        PriorityQueue<Car> priorityQueue = new PriorityQueue<>(new CarComparator());
        priorityQueue.addAll(cars);

        return priorityQueue;
    }

}
