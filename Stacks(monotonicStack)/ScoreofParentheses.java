public class ScoreofParentheses{
    public int scoreOfParentheses(String s) {
        
        int score=0;

        Stack<Integer> stack = new Stack<>();

        for(char ch:s.toCharArray()){
            if(ch=='{' || ch=='[' || ch=='('){
                stack.push(score);
                score=0;
            }
            else{
                score=stack.pop()+Math.max(2*score,1);
            }
            
        }

        return score;
    }
}
