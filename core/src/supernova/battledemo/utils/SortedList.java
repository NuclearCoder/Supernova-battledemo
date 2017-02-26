package supernova.battledemo.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

/*
 * We use an ArrayList for this, because we need quick random access.
 * The add method will not be called after the initialisation,
 * indexed access prioritised over iterating.
 */
public class SortedList<E> extends ArrayList<E> {

    private final Comparator<E> comparator;
    private final CircularList<E> circularList;

    public SortedList(final Comparator<E> comparator)
    {
        this.comparator = comparator;
        this.circularList = new CircularList<>(this);
    }

    @Override public boolean add(final E element)
    {
        final int length = size();
        for (int index = 0; index < length; index++)
        {
            if (comparator.compare(element, get(index)) <= 0)
            {
                super.add(index, element);
                return true;
            }
        }
        return super.add(element);
    }

    @Override public boolean addAll(final Collection<? extends E> collection)
    {
        boolean success = true;
        for (final E element : collection)
        {
            if (!this.add(element))
            {
                success = false;
            }
        }
        return success;
    }

    public CircularList<E> getCircularList(final int origin)
    {
        circularList.setOrigin(origin);
        return circularList;
    }

}
