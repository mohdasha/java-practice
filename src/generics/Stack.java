package generics;

import java.util.*;

public class Stack<E> {

    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E element) {
        ensureCapacity();
        elements[size++] = element;
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E result = elements[--size];
        elements[size] = null;
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        // if current size (size) == length of stack (stack full)
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    public void pushAll(Iterable<? extends E> src) {
        for (E e : src)
            push(e);
    }

    public void popAll(Collection<? super E> dst) {
        while (!isEmpty())
            dst.add(pop());
    }

    public static <T extends Comparable<? super T>> T max(List<? extends T> list) {
        if (list.isEmpty())
            throw new IllegalArgumentException("Empty Collection");

        T result = null;

        for (T elem : list) {
            if (result == null || elem.compareTo(result) > 0)
                result = Objects.requireNonNull(elem);
        }
        return result;
    }

    public static void main(String[] args) {

        String[] a = {"Hello", "World"};

        Stack<Number> stack = new Stack<>();


        Integer[] numbers = {1, 2, 3};
        Number[] numbers1 = {4, 5, 6};
        Double[] decimals = {2.2, 1.5, 5.9};

        for (Number arg : numbers1)
            stack.push(arg);
        Iterable<Integer> integers = Arrays.asList(numbers);
        Iterable<Double> doubles = Arrays.asList(decimals);

        stack.pushAll(integers);
        stack.pushAll(doubles);

        while (!stack.isEmpty())
            System.out.println(stack.pop());

        ArrayList<Integer> number = new ArrayList<>();
        number.add(1);
        number.add(2);
        System.out.println("Max: " + max(number));
    }
}
