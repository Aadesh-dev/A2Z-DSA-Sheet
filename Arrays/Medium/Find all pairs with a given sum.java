public pair[] allPairs( long A[], long B[], long N, long M, long X) {
        Arrays.sort(A);
        Arrays.sort(B);
        List<pair> list = new ArrayList<>();
        int low, high, mid;
        for(int i=0; i<N; i++) {
            low = 0;
            high = (int) M - 1;
            while(low <= high) {
                mid = low + (high - low) / 2;
                if(B[mid] == X - A[i]) {
                    list.add(new pair(A[i], B[mid]));
                    break;
                } else if(B[mid] < X - A[i]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        pair[] ans = new pair[list.size()];
        return list.toArray(ans);
    }
// Time: O(N * log(N) + M * log(M) + N * log(M)), Space: O(N)

// Better:

public pair[] allPairs( long A[], long B[], long N, long M, long X) {
        Arrays.sort(A);
        List<pair> list = new ArrayList<>();
        HashMap<Long, Integer> map = new HashMap<>();
        for(int i=0; i<M; i++) {
            map.put(B[i], i);
        }
        for(int i=0; i<N; i++) {
            if(map.containsKey(X - A[i])) {
                list.add(new pair(A[i], B[map.get(X - A[i])]));
            }
        }
        pair[] ans = new pair[list.size()];
        return list.toArray(ans);
    }

//Time: O(N*log(N) + N + M) => O(N*log(N)), Space: O(N + M)
