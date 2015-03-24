class Solution:
    def __init__(self):
        self.phonebook = {'0': None,
                          '1': None,
                          '2': 'abc',
                          '3': 'def',
                          '4': 'ghi',
                          '5': 'jkl',
                          '6': 'mno',
                          '7': 'pqrs',
                          '8': 'tuv',
                          '9': 'wxyz'}
    
    # @return a list of strings, [s1, s2]
    def letterCombinations(self, digits):
        if not digits:
            return [""]
        result = []
        self.combination(digits, "", result)
        return result
        
    def combination(self, digits, sol, res):
        if not digits:
            res.append(sol)
            return
        for letter in self.phonebook[digits[0]]:
            self.combination(digits[1:], sol+letter, res)