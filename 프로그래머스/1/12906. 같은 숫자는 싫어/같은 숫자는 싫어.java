import java.util.*;
import java.util.stream.Stream;

public class Solution {
    public int[] solution(int [] arr) {

        
        Stack<Integer> stack = new Stack();
        stack.add(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] != stack.peek()) {
                stack.add(arr[i]);
            }
        }
        
        return stack.stream().mapToInt(Integer::valueOf).toArray();
    }
}