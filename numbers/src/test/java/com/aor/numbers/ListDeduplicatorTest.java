package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListDeduplicatorTest {
    private List<Integer> list;
    private List<Integer> expected;

    @BeforeEach
    public void setup(){
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);

        expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);


    }
    @Test
    public void deduplicate() {

        ListDeduplicator deduplicator = new ListDeduplicator(list);
        List<Integer> distinct = deduplicator.deduplicate(new ListSorter(list));

        Assertions.assertEquals(expected, distinct);
    }

    @Test
    public void deduplicate_bug() {
        /*
        class SorterStub implements IListSorter{
            public List<Integer> sort() {
                return Arrays.asList(new Integer[]{1, 2, 4});
            }
        }
        */
        //equivalent to above commented code

        List<Integer> expected_new = Arrays.asList(new Integer[]{1, 2, 4});

        IListSorter SorterStub = Mockito.mock(IListSorter.class);
        Mockito.when(SorterStub.sort()).thenReturn(expected_new);

        List<Integer> new_list = Arrays.asList(new Integer[]{1, 2, 4, 2});
        ListDeduplicator deduplicator = new ListDeduplicator(new_list);

        List<Integer> distinct = deduplicator.deduplicate(SorterStub);

        Assertions.assertEquals(expected_new, distinct);
    }
}
