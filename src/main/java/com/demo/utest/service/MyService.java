package com.demo.utest.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {
    public String getName(){
        return "llj";
    }

    public int getAge(){
        return 100;
    }

    public boolean whoBig(int a,int b){
        return a>b?true:false;
    }

    public void test(){
        System.out.println("--------------------");
    }
}
