import sys
input = sys.stdin.readline

n = int(input())
s = []
count = 0
start = 0

for i in range(n):
    num = int(input())
    s.append(num)

for i in range(1, n+1):
    t = s[-i]
    if t > start:
        start = t
        count += 1
print(count)