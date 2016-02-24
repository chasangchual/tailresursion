package com.surefor.functional;

/**
 * Created by chae on 2/23/2016.
 */
public class HelloTailCall {
    public static Long sum(Integer n) {
        if(n == 1) return 1L ;
        else return n + sum(n-1) ;
    }

    public static Long sumTail(Integer n) {
        return sumTail(n, 0L) ;
    }

    private static Long sumTail(Integer n, Long k) {
        if(n == 1) return k + n ;
        else return sumTail(n-1, n + k) ;
    }

    public static void main(String[] args) {
        System.out.println(HelloTailCall.sumTail(10000)) ;
        // System.out.println(HelloTailCall.sum(10000)) ;
    }
}
