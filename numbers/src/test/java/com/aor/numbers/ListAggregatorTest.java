package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {
    private List<Integer> list;
    @BeforeEach
    public void setup(){
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);
    }

    @Test
    public void sum() {
        ListAggregator aggregator = new ListAggregator(list);

        int sum = aggregator.sum();

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {
        ListAggregator aggregator = new ListAggregator(list);

        int max = aggregator.max();

        Assertions.assertEquals(5, max);
    }

    @Test
    public void max_bug_7263(){
        List<Integer> expected = Arrays.asList(new Integer[]{-1,-4,-5});
        ListAggregator aggregator = new ListAggregator(expected);

        int max = aggregator.max();
        Assertions.assertEquals(-1, max);
    }
    @Test
    public void min() {
        ListAggregator aggregator = new ListAggregator(list);

        int min = aggregator.min();

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {
        class StubDeduplicator implements IListDeduplicator{
            public List<Integer> deduplicate(IListSorter sorter) {
                return Arrays.asList(new Integer[]{1,2,4,5});
            }
        }

        ListAggregator aggregator = new ListAggregator(list);

        int distinct = aggregator.distinct(new StubDeduplicator());

        Assertions.assertEquals(4, distinct);
    }

    @Test
    public void distinct_bug(){
        class StubDeduplicator implements IListDeduplicator{
            public List<Integer> deduplicate(IListSorter sorter) {
                return Arrays.asList(new Integer[]{1,2,4});
            }
        }
        List<Integer> expected = Arrays.asList(new Integer[]{1,2,4,2});
        ListAggregator aggregator = new ListAggregator(expected);

        int distinct = aggregator.distinct(new StubDeduplicator());

        Assertions.assertEquals(3, distinct);
    }
}
