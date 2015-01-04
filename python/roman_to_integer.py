class Solution:
    # @return an integer
    def romanToInt(self, s):
        values = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]
        symbols = "M CM D CD C XC L XL X IX V IV I".split()
        result = 0
        idx = 0
        for sym, val in zip(symbols, values):
            while s[idx: idx+len(sym)] == sym:
                result += val
                idx += len(sym)
        return result