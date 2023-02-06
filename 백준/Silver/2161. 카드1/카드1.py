import sys
input = sys.stdin.readline

num = int(input())
n = [(i+1) for i in range(num)]
m = []
i=0
while(len(n)!=1):
    first = n.pop(0)
    m.append(first)
    n.append(n[0])
    n.pop(0)
m.append(*n)
print(*m)