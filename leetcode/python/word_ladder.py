#!/usr/bin/env python

import collections
import string

# http://www.ardendertat.com/2011/10/17/programming-interview-questions-8-transform-word/

class Solution(object):
    def __init__(self):
        pass

    # @param start, a string
    # @param end, a string
    # @param dict, a set of string
    # @return an integer
    def ladderLength(self, start, end, dict):
        if not start or not end or not dict:
            return 0

        # formulate the dict as a undirected graph, each word in the dict
        # can be a node of the graph, and there's an undirected edge between
        # two nodes if one word can be converted to another by changing a letter
        graph = collections.defaultdict(list) # adjacent list
        letters = string.lowercase
        for word in dict:
            for i in xrange(len(word)):
                for char in letters:
                    change = word[:i] + char + word[i+1:]
                    if change in dict and change != word:
                        graph[word].append(change)

        import pprint
        pprint.pprint(graph)

        # bfs from the start word
        queue = collections.deque([[start]])
        length, visited = 1, set()
        while queue:
            current = queue.popleft()
            if current[-1] == end:
                return length
            elif current[-1] in visited:
                continue
            visited.add(current[-1])

            states = graph[current[-1]]
            for state in states:
                if state not in current:
                    queue.append(current[:]+[state])
                    length += 1

        return length

if __name__ == '__main__':
   sol = Solution()
   print sol.ladderLength("hit", "cog", ["hot","dot","dog","lot","log"])
