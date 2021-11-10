class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<asteroids.length;i++){
            int asteroid = asteroids[i];
            if(asteroid>0)
                stack.push(asteroid);
            else{
                while(!stack.isEmpty() && stack.peek()>0 && stack.peek() <-asteroid)
                    stack.pop();
                if(stack.isEmpty() || stack.peek() <0)
                    stack.push(asteroid);
                else if(stack.peek() == -asteroid)
                    stack.pop();
            }
            
        }
        int[] result = new int[stack.size()];
        for(int i=result.length-1; i>=0;i--){
            result[i] = stack.pop();
        }
        return result;
    }
}