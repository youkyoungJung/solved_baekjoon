from collections import defaultdict

n = int(input())
#d = dict()
d = defaultdict(int)
for x in map(int, input().split()):
    #if x in d:
    d[x] += 1
    #else:
    #    d[x] = 1

m = int(input())
for x in map(int, input().split()):
    if x in d:
        print(d[x], end=" ")
    else:
        print(0, end= " ")

