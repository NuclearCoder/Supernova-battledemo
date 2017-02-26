package supernova.battledemo;

import supernova.battledemo.utils.RandomUtils;
import supernova.battledemo.utils.SortedList;

public class Tests {

    public static final void main(String[] args)
    {
        SortedList<Integer> list = new SortedList<>(Integer::compareTo);

        for (int i = 0; i < 20; i++)
        {
            list.add(RandomUtils.nextInt(-20, 20));
        }

        System.out.println(list.toString());
    }

}
