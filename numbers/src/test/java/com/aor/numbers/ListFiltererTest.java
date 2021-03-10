package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListFiltererTest {

    private List<Integer> list;
    private IListFilterer ListFiltererStub;

    @BeforeEach
    public void setup(){
        list = new ArrayList<>();
        list.add(-1);
        list.add(-2);
        list.add(-4);
        list.add(2);
        list.add(5);
        list.add(6);


    }

    @Test
    public void PositiveFilterTest(){
        List<Integer> expected = Arrays.asList(new Integer[]{2,5,6});
        ListFilterer filterer = new ListFilterer(list);

        //example stub for the PositiveStub
        ListFiltererStub = Mockito.mock(IListFilterer.class);
        Mockito.when(ListFiltererStub.accept(2)).thenReturn(true);
        Mockito.when(ListFiltererStub.accept(5)).thenReturn(true);
        Mockito.when(ListFiltererStub.accept(6)).thenReturn(true);
        Mockito.when(ListFiltererStub.accept(-1)).thenReturn(false);
        Mockito.when(ListFiltererStub.accept(-2)).thenReturn(false);
        Mockito.when(ListFiltererStub.accept(-4)).thenReturn(false);


        //List<Integer> filtered_list = filterer.filter(new PositiveFilter());
        //using the stub instead
        List<Integer> filtered_list = filterer.filter(ListFiltererStub);
        Assertions.assertEquals(expected,filtered_list);
    }

    @Test
    public void DivisibleFilterTest(){
        List<Integer> expected = Arrays.asList(new Integer[]{-2,-4,2,6});
        ListFilterer filterer = new ListFilterer(list);

        ListFiltererStub = Mockito.mock(IListFilterer.class);
        Mockito.when(ListFiltererStub.accept(2)).thenReturn(true);
        Mockito.when(ListFiltererStub.accept(5)).thenReturn(false);
        Mockito.when(ListFiltererStub.accept(6)).thenReturn(true);
        Mockito.when(ListFiltererStub.accept(-1)).thenReturn(false);
        Mockito.when(ListFiltererStub.accept(-2)).thenReturn(true);
        Mockito.when(ListFiltererStub.accept(-4)).thenReturn(true);

        //List<Integer> filtered_list = filterer.filter(new DivisibleByFilter(2));
        //using our stub
        List<Integer> filtered_list = filterer.filter(ListFiltererStub);

        Assertions.assertEquals(expected,filtered_list);
    }
}
