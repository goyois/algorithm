import java.util.*;


class Solution {
    public String solution(String my_string) {
        char[] charArr = {'a','e','i','o','u'};
        String regex = "[" + new String(charArr) + "]";
        return my_string.replaceAll(regex,"");
    }
}