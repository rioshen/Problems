class Solution:
    # @return a string
    def intToRoman(self, num):
        anums = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]
        rnums = "M CM D CD C XC L XL X IX V IV I".split()
        result = []
        for a, r in zip(anums, rnums):
            n, num = divmod(num, a)
            result.append(r*n)
        return ''.join(result)