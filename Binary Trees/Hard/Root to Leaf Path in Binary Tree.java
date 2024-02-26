class Tree{
    public ArrayList<ArrayList<Integer>> Paths(Node root){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        generatePaths(root, ans, path);
        return ans;
    }
    
    public void generatePaths(Node node, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> path) {
        if(node == null) return;
        path.add(node.data);
        if(node.left != null) generatePaths(node.left, ans, path);
        if(node.right != null) generatePaths(node.right, ans, path);
        if(node.left == null && node.right == null) ans.add(new ArrayList<>(path));
        path.remove(path.size() - 1);
    }
    
}
//Time: O(n), Space: O(h)