#!/usr/bin/env python

import urllib2
import re
from bs4 import BeautifulSoup

page = urllib2.urlopen("https://oj.leetcode.com/problems/").read()
soup = BeautifulSoup(page)
problems = soup.find_all('a', href=re.compile("problems"))
print len(problems)
for problem in problems:
    filename = problem['href'].replace("/problems/", "").replace("/", "").replace("-", "_") + ".py"
    with open(filename, 'w') as fout:
        fout.write("#!/usr/bin/env python")

