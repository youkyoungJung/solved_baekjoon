import sys
input = sys.stdin.readline

n = [(i+1) for i in range(int(input()))]
m = []

while(len(n)!=1):
    first = n.pop(0)
    m.append(first)
    n.append(n[0])
    n.pop(0)
m.append(*n)
print(*m)