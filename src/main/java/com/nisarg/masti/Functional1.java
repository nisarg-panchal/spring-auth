package com.nisarg.masti;

import java.util.function.Function;

public class Functional1 {
  @FunctionalInterface
  interface Foo {
    String method(String s);
  }

  static class UseFoo {
    String method(String s, Foo foo) {
      return foo.method(s);
    }

    public String add(String s, Function<String, String> fn) {
      return fn.apply(s);
    }
  }

  public static void main(String[] args) {
    Function<String, String> fn = param -> param + " Same thing";
    UseFoo useFoo = new UseFoo();
    System.out.println(useFoo.add("With Function<String, String>", fn));
  }
}
