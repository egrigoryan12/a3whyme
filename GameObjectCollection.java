package com.mycompany.a3;
import java.util.Vector;

public class GameObjectCollection implements ICollection {
    public Vector<GameObject> objects = new Vector<GameObject>();


    private class gwIterator implements IIterator {
        private int currentIndex;

        public gwIterator() {
            currentIndex = -1;
        }

        @Override
        public boolean hasNext() {
            if (objects.size() <= 0) {
                return false;
            }
            return currentIndex < objects.size() - 1;
        }

        @Override
        public Object getNext() {
            currentIndex++;
            return objects.get(currentIndex);
        }
    }

    @Override
    public void add(Object iterator) {
    	objects.add((GameObject) iterator);
    }

    @Override
    public IIterator getIterator() {
        return new gwIterator();
    }
    public void clear() {
        objects.clear();
    }
    
}
