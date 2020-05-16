package ru.spsuace.homework2.collections;

import java.util.Iterator;

/**
 * Реализовать двусвязный список, аналог LinkedList в java (то что я рассказывал на лекции)
 * Если не понятно, что должны возвращать методы, смотрите документацию интерфейсов List и Collection
 * Если в метод передается индекс, которого не существует (за исключением, add(size(), obj)), то надо бросить ошибку:
 * throw new IndexOutOfBoundsException()
 * Полный балл - 6
 */
public class DoubleLinkedList<T> implements Iterable<T> {
    private int size;
    private DNode first;
    private DNode last;

    private class DNode<T> {
        private T data;
        private DNode<T> previous;
        private DNode<T> next;

        private DNode(T data, DNode<T> prev, DNode<T> next) {
            this.data = data;
            this.previous = prev;
            this.next = next;
        }
    }

    private DNode<T> getElement(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        DNode<T> node;
        if (index < size / 2) {
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }

        } else {
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.previous;
            }
        }
        return node;
    }
    // ----------- 1 балл -----------

    public int size() {
        return size;
    }

    public boolean contains(T o) {
        return indexOf(o) != -1;
    }

    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    public int indexOf1(T o) {
        int index = 0;
        DNode<T> node = first;
        while (node != null) {
            if (node.data.equals(o)) {
                return index;
            }
            node = node.next;
            index++;
        }
        return -1;
    }

    // ----------- 1 балл -----------

    public void add(int index, T element) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            addFirst(element);
        } else {
            if (index == size) {
                addLast(element);
            } else {
                DNode<T> node = new DNode<T>(element, null, null);
                DNode<T> oldNode = getElement(index);
                node.previous = oldNode.previous;
                node.next = oldNode;
                oldNode.previous.next = node;
                size++;
            }
        }

    }

    public void addLast(T element) {
        DNode<T> node = new DNode<T>(element, null, null);
        if (size != 0) {
            node.previous = last;
            last.next = node;
            last = node;
        } else {
            first = node;
            last = node;
        }
        size++;
    }

    public void addFirst(T element) {
        DNode<T> node = new DNode<T>(element, null, null);
        if (size != 0) {
            node.next = first;
            last.previous = node;
            first = node;
        } else {
            first = node;
            last = node;
        }
        size++;
    }

    // ----------- 1 балл -----------

    public T set(int index, T element) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        DNode<T> node = getElement(index);
        T replacedData = node.data;
        node.data = element;
        return replacedData;
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return getElement(index).data;
    }

    public int indexOf(T o) {
        int index = 0;
        DNode<T> node = first;
        while (node != null) {
            if (node.data.equals(o)) {
                return index;
            }
            node = node.next;
            index++;
        }
        return -1;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        DNode<T> node = getElement(index);
        if (index == 0) {
            node.next.previous = null;
            first = node.next;
        } else if (index == size - 1) {
            node.previous.next = null;
            last = node.previous;
        } else {
            node.previous.next = node.next;
            node.next.previous = node.previous;
        }
        size--;
        return node.data;
    }


    /**
     * Надо реализовать свой итератор, который будет последовательно идти с первого по последний элемент
     * 3 балла
     *
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public T next() {
                return get(count++);
            }
        };
    }
}