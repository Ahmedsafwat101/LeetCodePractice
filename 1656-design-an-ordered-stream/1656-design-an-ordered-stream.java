class OrderedStream {
    private int iterator;
    private String[]arr;
    public OrderedStream(int n) {
        iterator = 0;
        arr = new String[n];
    }
    
    public List<String> insert(int idKey, String value) {
        List<String> ans = new ArrayList();
        int index = idKey-1;
        arr[index] = value;
        while(iterator<arr.length && arr[iterator] != null){
            ans.add(arr[iterator++]);
        }
        return ans;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */