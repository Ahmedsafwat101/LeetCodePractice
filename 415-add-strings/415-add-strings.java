class Solution {
    public String addStrings(String nums1, String nums2) {
        if(nums1.equals("0")) return nums2;
        if(nums2.equals("0")) return nums1;

        int pt1 = nums1.length()-1 ;
        int pt2 = nums2.length()-1 ;
        int cary = 0 , sum = 0, totalSum;
        StringBuilder ans = new StringBuilder();
        while(pt1>=0 && pt2>=0){
            
            int digit1 = nums1.charAt(pt1--)-'0';
            int digit2 = nums2.charAt(pt2--)-'0';
            
            totalSum = (digit1+digit2+cary);
            sum = totalSum%10;
            cary= totalSum/10;
            
            ans.append(sum);
        }
        
        while(pt1>=0 ){
            int digit1 = nums1.charAt(pt1--)-'0';
            totalSum = (digit1+cary);
            sum = totalSum%10;
            cary= totalSum/10;
            ans.append(sum);
        }
        
        while(pt2>=0 ){
            int digit2 = nums2.charAt(pt2--)-'0';
            totalSum = (digit2+cary);
            sum = totalSum%10;
            cary= totalSum/10;
            ans.append(sum);
        }
        
        if(cary!=0) ans.append(cary);
        
        return ans.reverse().toString();

    }
}