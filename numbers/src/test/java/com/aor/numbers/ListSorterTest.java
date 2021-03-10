package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListSorterTest {
    public List<Integer> list;
    public List<Integer> expected;
    @BeforeEach
    public void setup(){
        list = new ArrayList();
        list.add(3);
        list.add(2);
        list.add(6);
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(7);

        expected = new ArrayList();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(7);

    }


    @Test
    public void sort() {

        ListSorter sorter = new ListSorter(list);
        List<Integer> sorted = sorter.sort();
        Assertions.assertEquals(expected, sorted);
    }

    @Test
    public void sort_bug() {
        List<Integer> list_bugged = Arrays.asList(new Integer[]{1, 2, 4, 2});
        List<Integer> expected_bug = Arrays.asList(new Integer[]{1, 2,2,4});
        ListSorter sorter = new ListSorter(list_bugged);
        List<Integer> sorted = sorter.sort();
        Assertions.assertEquals(expected_bug, sorted);
    }

    @Test
    public void testEquals(){
        ListSorter sorter1 = new ListSorter(Arrays.asList(new Integer[]{1, 2, 4, 2}));
        ListSorter sorter2 = new ListSorter(Arrays.asList(new Integer[]{1, 2, 4, 2,3}));
        boolean isEqual = sorter1.equals(sorter2);
        Assertions.assertEquals(isEqual,false);
    }

    @Test
    public void testEqualsNull(){
        ListSorter sorter1 = new ListSorter(Arrays.asList(new Integer[]{1, 2, 4, 2}));
        boolean isEqual = sorter1.equals(sorter1);
        Assertions.assertEquals(isEqual,true);

        ListDeduplicator sorter3 = new ListDeduplicator(list);
        isEqual = sorter1.equals(sorter3);
        Assertions.assertEquals(isEqual,false);
    }
}
