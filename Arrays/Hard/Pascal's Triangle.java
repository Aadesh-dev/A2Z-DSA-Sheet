public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for(int i=1; i<=numRows; i++) {
            List<Integer> list = new ArrayList<>();
            if(lists.isEmpty()) {
                list.add(1);
                lists.add(list);
            } else if(lists.size() == 1) {
                list.add(1);
                list.add(1);
                lists.add(list);
            } else {
                List<Integer> prevList = lists.get(lists.size() - 1);
                for(int j=0; j<prevList.size(); j++) {
                    if(j == prevList.size() - 1) {
                        list.add(1);
                    } else {
                        if(j == 0) {
                            list.add(1);
                        }
                        list.add(prevList.get(j) + prevList.get(j+1));
                    }
                }
                lists.add(list);
            }
        }
        return lists;
    }
// Time: O(n^2), Space: O(n^2)

// Smarter (Striver):

public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> row = null, pre = null;
        int n=numRows;
       
        for(int i=0; i<n; ++i){
            row = new ArrayList<>();
            for(int j=0; j<=i; ++j){
                if(j==0|| j==i){
                    row.add(1);
                }
                else{
                    row.add(pre.get(j-1) + pre.get(j));
                }
            }
            lists.add(row);
            pre = row;
        }
       
        return lists;
    }
// Time: O(n^2), Space: O(n^2)

// GFG:

// Return the Nth row of pascal's triangle.

ArrayList<Long> nthRowOfPascalTriangle(int n) {
        ArrayList<Long> row = null,pre = null;
        
        for(int i=0; i<n; ++i){
            row = new ArrayList<Long>();
            for(int j =0 ;j<=i;++j){
                if(j==0|| j==i){
                    row.add((long)1);
                }
                else{
                    row.add((pre.get(j-1) + pre.get(j))%1000000007);
                }
            }
            pre = row;
        }
        
        return row;
    }
// Time: O(n^2), Space: O(n)

// Below approach doesn’t work for n>50:

ArrayList<Long> list = new ArrayList<>();
        long res=1;
        for(int i=0; i<n; i++) {
            if(i==0) {
                res=1;
            } else {
                res=(res*(n-i))/i;
            }
            list.add(res%1000000007);
        }
        return list;
//Time: O(n), Space: O(n)

// Three types of problems:
// 1. Given row and col find element at that cell - nCr
// 2. Return nth row
// 3. Print whole pascal's triangle