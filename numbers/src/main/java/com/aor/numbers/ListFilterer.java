package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;

public class ListFilterer {
    private List<Integer> list;
    public ListFilterer(List<Integer> list) {
        this.list = list;
    }

    public List<Integer> filter(IListFilterer filter){
        //return a list of numbers that pass the filter
        List<Integer> output = new ArrayList();
        for(Integer integer: list){
            if(filter.accept(integer)){
                output.add(integer);
            }
        }
        return output;
    }
}
