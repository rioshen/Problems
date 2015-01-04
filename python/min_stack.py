class MinStack:
    def __init__(self):
        self.stack = []
        self.minstack = []
        
    def push(self, x):
        self.stack.append(x)
        if not self.minstack or self.minstack[-1] >= x:
            self.minstack.append(x)
            
    def pop(self):
        if not self.stack:
            raise ValueError('stack underflow')
        val = self.stack.pop()
        if val == self.minstack[-1]:
            self.minstack.pop()
        return val
        
    def top(self):
        if not self.stack:
            raise ValueError('stack underflow')
        return self.stack[-1]
        
    def getMin(self):
        if self.minstack: return self.minstack[-1]