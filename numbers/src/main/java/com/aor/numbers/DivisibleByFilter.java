package com.aor.numbers;

public class DivisibleByFilter implements IListFilterer{
    Integer divisor;
    DivisibleByFilter(Integer integer){ divisor = integer;}
    @Override
    public boolean accept(Integer number) {
        if(number % divisor == 0){
            return true;
        }
        return false;
    }
}
