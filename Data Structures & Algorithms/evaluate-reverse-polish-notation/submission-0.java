class Solution {
    public int evalRPN(String[] tokens) {

        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < tokens.length; i++) {
            
            if (!(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/"))){
                int number = Integer.parseInt(tokens[i]);
                stack.push(number);

            } else if (tokens[i].equals("+")){
                int second = stack.pop();
                int first = stack.pop();

                int answer = first + second;

                stack.push(answer);
                
            } else if (tokens[i].equals("-")){
                int second = stack.pop();
                int first = stack.pop();

                int answer = first - second;

                stack.push(answer);
                
            } else if (tokens[i].equals("*")){
                int second = stack.pop();
                int first = stack.pop();

                int answer = first * second;

                stack.push(answer);
                
            } else if (tokens[i].equals("/")){
                int second = stack.pop();
                int first = stack.pop();

                int answer = first / second;

                stack.push(answer);
                
            }

        }
        return stack.pop();
    }
}
