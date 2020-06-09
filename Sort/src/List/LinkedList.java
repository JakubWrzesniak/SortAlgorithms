package List;

public class LinkedList implements List {
    private final Element headAndTail = new Element(null);
    private int size;

    public LinkedList() {
        clear();
    }

    private Element getElement(int index) {
        return index < size / 2 ? getElementForwards(index) : getElementBackwards(index);
    }

    private Element getElementForwards(int index) {
        Element element = headAndTail.getNext();
        for (int i = index; i > 0; --i) {
            element = element.getNext();
        }
        return element;
    }

    private Element getElementBackwards(int index) {
        Element element = headAndTail;
        for (int i = size - index; i > 0; --i) {
            element = element.getPrevious();
        }
        return element;
    }

    public void insert(int index, Object value) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        Element element = new Element(value);
        element.addBefore(getElement(index));
        size++;
    }

    private void chceckOutOfBounds(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
    }

    public void add(Object value) {
        insert(size(), value);
    }

    public int size() {
        return size;
    }

    public Object get(int index) throws IndexOutOfBoundsException {
        chceckOutOfBounds(index);
        return getElement(index).getValue();
    }

    public Object set(int index, Object value) throws IndexOutOfBoundsException {
        chceckOutOfBounds(index);
        Element element = getElement(index);
        Object old = element.getValue();
        element.setValue(value);
        return old;
    }

    public Object delete(int index) throws IndexOutOfBoundsException {
        chceckOutOfBounds(index);
        Element element = getElement(index);
        element.remove();
        size--;
        return element.getValue();
    }

    public boolean delete(Object value) {
        Element e = headAndTail.getNext();
        while (e != headAndTail && !value.equals(e.getValue())) {
            e = e.getNext();
        }
        if (e != headAndTail) {
            e.remove();
            size--;
            return true;
        } else
            return false;
    }

    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    public void clear() {
        headAndTail.setPrevious(headAndTail);
        headAndTail.setNext(headAndTail);
        size = 0;
    }

    public int indexOf(Object value) {
        int index = 0;
        Element e = headAndTail.getNext();
        while (e != headAndTail && !value.equals(e.getValue())) {
            e = e.getNext();
            index++;
        }
        return e != headAndTail ? index : -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Iterator iterator() {
        return new ValueIterator();
    }

    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append('[');
        if (!isEmpty()) {
            Iterator it = iterator();
            it.first();
            while (!it.isDone()) {
                buf.append(it.current());
                buf.append(',');
                it.next();
            }
            buf.setLength(buf.length() - 1);
        }
        buf.append(']');
        return buf.toString();
    }

    public void printList() {
        Iterator it = iterator();
        it.first();
        while (!it.isDone()) {
            System.out.println(it.current());
            it.next();
        }
    }

    private static final class Element {
        private Object value;
        private Element previous;
        private Element next;

        private Element(Object value) {
            setValue(value);
        }

        private Object getValue() {
            return value;
        }

        private void setValue(Object value) {
            this.value = value;
        }

        private Element getPrevious() {
            return previous;
        }

        private void setPrevious(Element previous) {
            assert previous != null;
            this.previous = previous;
        }

        private Element getNext() {
            return next;
        }

        private void setNext(Element next) {
            assert next != null;
            this.next = next;
        }

        private void addBefore(Element next) {
            Element previous = next.getPrevious();
            setNext(next);
            setPrevious(previous);
            next.setPrevious(this);
            previous.setNext(this);
        }

        private void remove() {
            previous.setNext(next);
            next.setPrevious(previous);
        }

        public String toString() {
            return value.toString();
        }
    }

    private final class ValueIterator implements Iterator {
        private Element current = headAndTail;

        public void first() {
            current = headAndTail.getNext();
        }

        public void last() {
            current = headAndTail.getPrevious();
        }

        public boolean isDone() {
            return current == headAndTail;
        }

        public void next() {
            current = current.getNext();
        }

        public void previous() {
            current = current.getPrevious();
        }

        public Object current() throws IndexOutOfBoundsException {
            if (isDone())
                throw new IndexOutOfBoundsException();
            return current.getValue();
        }
    }
}
