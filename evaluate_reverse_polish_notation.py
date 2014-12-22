class Solution:
    # @param tokens, a list of string
    # @return an integer
    def evalRPN(self, tokens):
        if not tokens:
            return 0
        
        # use a {operator: result} table for effectively fetch 
        # corresponding operation
        operations = {'+': lambda x, y: x+y,
                      '-': lambda x, y: x-y,
                      '*': lambda x, y: x*y
                      '/': lambda x, y: int(float(x)/y)}
        stack = []
        for token in tokens:
            if token not in operations:
                stack.append(int(token))
            else:
                # stack is not ready, throw exception
                if not stack:
                    raise ValueError('underflow')
                # encounter a operator, pop two parameter
                # from the stack
                a, b = stack.pop(), stack.pop()
                
                # push the temporary result back to the stack
                stack.append(operations[token](b, a))

        return stack.pop()