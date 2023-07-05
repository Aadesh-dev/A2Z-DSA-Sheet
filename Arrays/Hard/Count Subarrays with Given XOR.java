public static int subarraysXor(ArrayList<Integer> arr, int x) {
        int xor=0, count=0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int element : arr) {
            xor ^= element;
            if(map.containsKey(xor ^ x)) {
                count += map.get(xor ^ x);
            }
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return count;
    }

//Time: O(n), Space: O(n)
