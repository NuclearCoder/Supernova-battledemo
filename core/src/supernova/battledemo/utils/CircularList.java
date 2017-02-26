package supernova.battledemo.utils;

import java.util.List;

public class CircularList<T> {

    private final List<T> list;
    private int origin;

    public CircularList(final List<T> list)
    {
        this.list = list;
    }

    public void setOrigin(final int origin)
    {
        this.origin = origin;
    }

    public T get(int index)
    {
        return list.get((origin + index) % list.size());
    }

    public int size()
    {
        return list.size();
    }

}
