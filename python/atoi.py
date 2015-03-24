#!/usr/bin/env python

class Solution:
    # @return an integer
    def atoi(self, str):
        if not str:
            return 0

        # trim whitespace
        str = str.strip()
        if not str:
            return 0

        # deal with leading negative character
        negative = False
        if str[0] == '-':
            negative = True
            str = str[1:]
        elif str[0] == '+':
            str = str[1:]

        # multiply by 10 for each element in the string
        result = 0
        for elem in str:
            if elem.isdigit():
                result = result * 10 + int(elem)
            else: # within the string, if any special character is found
                break

        result = -result if negative else result

        # format result based on MAX and MIN value
        maxint, minint = (1<<31)-1, -(1<<31)
        result = maxint if result >= maxint else result
        result = minint if result <= minint else result

        return result
