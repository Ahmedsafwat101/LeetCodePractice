class Solution {
    public String reverseVowels(String s) {
        Set<Character>vowel = new HashSet(Arrays.asList('A','I','E','O','U','a','e','i','o','u'));
        
        int left = 0;
        int right = s.length()-1;
        char[] arr = s.toCharArray();
        while(left<right){
            char ch1 = arr[left] ;
            char ch2 = arr[right];
            if(vowel.contains(ch1) && vowel.contains(ch2)){
                char temp = arr[left];
                arr[left++] = arr[right];
                 arr[right--] = temp;
                
            }else if(vowel.contains(ch1)){
                right--;
            }else{
                left++;
            }
        }
        return new String(arr);
    }
}