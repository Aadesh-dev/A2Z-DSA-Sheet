class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < asteroids.length; i++) {
           if(s.isEmpty() || asteroids[i] > 0) {
               s.push(asteroids[i]);
           } else {
               boolean collision = true;
               while(!s.isEmpty() && collision == true) {
                   if(s.peek() < 0) {
                       s.push(asteroids[i]);
                       collision = false;
                   } else if(Math.abs(s.peek()) > Math.abs(asteroids[i])) {
                       collision = false;
                   }  else if(Math.abs(s.peek()) < Math.abs(asteroids[i])) {
                       s.pop();
                       if(s.isEmpty()) {
                           s.push(asteroids[i]);
                           collision = false;
                       }
                   } else {
                       s.pop();
                       collision = false;
                   }
               }
           }
        }
        int res[] = new int[s.size()];
        int i = s.size() - 1;
        while(!s.isEmpty()) {
            res[i] = s.pop();
            i--;
        }
        return res;
    }
}
//Time: O(n), Space: O(n)