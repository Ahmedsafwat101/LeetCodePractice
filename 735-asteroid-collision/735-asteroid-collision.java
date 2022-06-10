class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids == null || asteroids.length == 0) return new int[]{};
        Stack<Integer> astStack = new Stack();
        boolean canBeAdded = false;
        for(int asteroid:asteroids){
            if(asteroid > 0 || astStack.isEmpty()){
                astStack.push(asteroid);
            }else{
                // negative 
                while(!astStack.isEmpty()){
                   int top = astStack.peek();
                    
                    if(top<0){
                        canBeAdded = true; 
                        break;
                    } 
    
                    if(top == Math.abs(asteroid)){
                        astStack.pop();
                        canBeAdded = false;
                        break;
                    }else if(top < Math.abs(asteroid)){
                        astStack.pop();
                        canBeAdded = true;    
                    }else{
                        //destroy if equal or greater
                        canBeAdded = false;
                        break;
                    }
                }
                if(canBeAdded)
                    astStack.add(asteroid);
            }
        }
        return astStack.stream().mapToInt(i->i).toArray();
    }
}