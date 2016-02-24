Hello Tail Call Recursion in Java
====================

Once we open the door way to the functional programming, the first rabbit you met could be tail call recursion. When I read about tail recursion, I did not realize how tail call is connected with functional programming at that moment. If there was a sort of hello tail call !!, I should have started functional programming earlier. Let's see Hello Tail Call !! sample code in Java below.

----------
###**What is Tail Call**

>**Tail Call**
>Wiki says that In computer science, a tail call is a subroutine call performed as the final action of a procedure. If a tail call might lead to the same subroutine being called again later in the call chain, the subroutine is said to be tail-recursive, which is a special case of recursion. Tail recursion (or tail-end recursion) is particularly useful, and often easy to handle in implementations.
https://en.wikipedia.org/wiki/Tail_call

So, now you have a clear definition on Tail Call ? We are Java programmers. Give me Java codes.

###**Codes**

Let me define a function, sum(x)  as below. 
```
sum(10) = 10 + 9 + 8 + ... + 1
```

and write a method.
```java
public static Long sum(Integer n) {
	if(n == 1) return 1L ;
	else return n + sum(n-1) ;
}
```
Looks OK for now. Do you know what is sum(10000) ? Let's get my new method work to answer it. 

```
Exception in thread "main" java.lang.StackOverflowError
	at java.lang.Number.<init>(Number.java:49)
	at java.lang.Integer.<init>(Integer.java:659)
	at java.lang.Integer.valueOf(Integer.java:642)
	at com.surefor.functional.HelloTailCall.sum(HelloTailCall.java:9)
	at com.surefor.functional.HelloTailCall.sum(HelloTailCall.java:9)
	at com.surefor.functional.HelloTailCall.sum(HelloTailCall.java:9)
	at com.surefor.functional.HelloTailCall.sum(HelloTailCall.java:9)
	at com.surefor.functional.HelloTailCall.sum(HelloTailCall.java:9)
```
Hmm.. It died with **sjava.lang.StackOverflowError** actually as expected. But no worries, it is time to dive deeper. Let me share another methods to do same thing but run with tail call recursion.

```java
    public static Long sumTail(Integer n) {
        return sumTail(n, 0L) ;
    }

    private static Long sumTail(Integer n, Long k) {
        if(n == 1) return k + n;
        else return sumTail(n-1, n + k) ;
    }
```
```
System.out.println(HelloTailCall.sumTail(10000)) ;
50005000
```
This time we got the answer. You could say that So what, I can read Java code but it does not touch engineer's brain.  Probably there are tens of pages to explain how it works and how they are different. Too much, right ? 

###**Explained**
I would like say that in here, just focus on recursion exit condition. Meaning what you return. Every magic comes from **what you return**.

Back to the first code snippet, it populated  stack over flow because it returns **_n + sum(n-1)_**.
> DO NOT **_return n + sum(n-1) ;_**

 Java compiler generates byte codes to stack every recursion call in order to calculate **_n + ..._** . if you want to tell Java do tail call optimization, you have to just simply call the function.  That is it.

Next, can you find difference in recursion exit condition ? Tail call recursion returns _actual answer_ when it meets exit condition. 

> **_if(n == 1) return k + n ;_**

In the tail call codes, **_k_** is answer until previous recursion call and **_k+n_** is the answer in current call.

One more thing, in functional programming paradigm it passes a function as a parameter when it calls another function. Given **sumTail(n-1, n + k)** we passe **+** operator as a function.

 

>  __The first step in functional programming is to design proper returning value.__

----------
#### **About me**
I am [**_Ethan Cha_**](https://ca.linkedin.com/in/ethancha) who is a 20-ish years experienced software developer, and will be a developer in another 20 years. 

----------
