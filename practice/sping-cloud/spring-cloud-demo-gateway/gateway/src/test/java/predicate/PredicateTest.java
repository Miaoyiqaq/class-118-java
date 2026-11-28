package predicate;


import org.junit.Test;

import java.util.function.Predicate;

public class PredicateTest {
    @Test
    public void test() {
        Predicate<String> predicate = new StringPredicate();
        System.out.println(predicate.test(""));
        System.out.println(predicate.negate().test(""));//否定
    }
    @Test
    public void test2() {
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s == null || s.isEmpty();
            }
        };
        System.out.println(predicate.test(""));
        System.out.println(predicate.negate().test(""));//否定
    }
    @Test
    public void test3() {
        Predicate<String> predicate = s -> s == null || s.isEmpty();
        System.out.println(predicate.test(""));
        System.out.println(predicate.test("a"));
    }

    /***
     * or
     * 包含其中一个字符串
     */
    @Test
    public void test4() {
        Predicate<String> predicate = s -> s != null && !s.isEmpty();
        Predicate<String> predicate2 = s -> s != null && s.chars().allMatch(Character::isDigit);
        System.out.println(predicate.or(predicate2).test(""));
        System.out.println(predicate.or(predicate2).test("aa"));
        System.out.println(predicate.or(predicate2).test("bb"));
        System.out.println(predicate.or(predicate2).test("ab"));
    }

    /***
     * and
     * 同时包含多个字符串
     */
    @Test
    public void test5() {
        Predicate<String> predicate = s ->  s != null && !s.isEmpty();
        Predicate<String> predicate2 = s -> s != null && s.chars().allMatch(Character::isDigit);
        System.out.println(predicate.and(predicate2).test(""));
        System.out.println(predicate.and(predicate2).test("aa"));
        System.out.println(predicate.and(predicate2).test("bb"));
        System.out.println(predicate.and(predicate2).test("123"));
    }
}
