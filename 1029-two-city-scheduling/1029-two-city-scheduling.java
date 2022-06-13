class Solution {
    public int twoCitySchedCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        // Sort by diff of the profit between cost[0] and cost[1]
        Arrays.sort(costs,(obj1,obj2)->(obj1[0]-obj1[1])-(obj2[0]-obj2[1])); // Nlogn 
        
        int n = costs.length/2;
        int totalCost = 0;
        for(int i = 0;i<n;i++){
            totalCost+=costs[i][0]+costs[n+i][1];
        }
        
        return totalCost;
    }
}