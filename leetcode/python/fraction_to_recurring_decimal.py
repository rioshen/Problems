class Solution:
    # @return a string
    def fractionToDecimal(self, numerator, denominator):
        if not denominator:
            return ""
        content = str(float(numerator) / denominator).split('.')
        if len(content[1]) > 6:
            content[1] = content[1][:5]
        fraction = self.encode(content[1]) 
        return content[0]+'.'+fraction