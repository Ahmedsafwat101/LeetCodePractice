class Solution {
    public double myPow(double x, int n) {
        if(n > 0) {
			return helper(x, n);                
		} else {
			double val = helper(x, n * -1);    
			return 1.0 / val;
		}
        
    }
    
    private double helper(double x, int n){
        if(n == 0) return 1.0;
        double val = helper(x,n/2);
        if(n%2==0)
            return val*val;
        else
            return x*val*val;
    }

}