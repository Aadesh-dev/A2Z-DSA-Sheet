import java.util.*;

public class Solution {
    public static List< String > generateString(int N) {
        if(N == 1) {
            List<String> result = new ArrayList<>(Arrays.asList("0", "1"));
            return result;
        }
        List<String> result = new ArrayList<>();
        List<String> prevList = generateString(N - 1);
        for(String s : prevList) {
            result.add(s + "0");
            if(s.charAt(s.length() - 1) != '1') {
                result.add(s + "1");
            }
        }
        return result;
    }
}
//Time: O(N + 2^N) => O(2^N), Space: O(2^N)
//https://www.geeksforgeeks.org/generate-binary-strings-without-consecutive-1s/

//Dry run:
//When n = 3:
// [] n=3
// 	[] n=2
// 		['0', '1'] n=1
// 	["00", "01", "10"] n=2
// ["000", "001", "010", "100", "101"] n=3


//When n = 4:	
// [] n=4
// 	[] n=3
// 		[] n=2
// 			['0', '1'] n=1
// 		["00", "01", "10"] n=2
// 	["000", "001", "010", "100", "101"] n=3
// ["0000", "0001", "0010", "0100", "0101", "1000", "1001", "1010"] n=4

//Dry run of the char array approach given in the GFG article:
//When n = 3:
// ['0'] 
// 	['0', '0'] n=1
// 		['0', '0', '0'] n=2
// 			['0', '0', '0'] n=3 // print
// 		['0', '0', '1'] n=2
// 			['0', '0', '1'] n=3 // print
// 		['0', '0', '1'] n=2
// 	['0', '1', '1'] n=1
// 		['0', '1', '0'] n=2
// 			['0', '1', '0'] n=3 // print
// 		['0', '1', '0'] n=2
// 	['0', '1', '0'] n=1
// ['1', '1', '0']
// 	['1', '0', '0'] n=1
// 		['1', '0', '0'] n=2
// 			['1', '0', '0'] n=3 // print
// 		['1', '0', '1'] n=2
// 			['1', '0', '1'] n=3 // print
// 		['1', '0', '1'] n=2
// 	['1', '0', '1'] n=1
// ['1', '0', '1']
