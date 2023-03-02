import sys
input = sys.stdin.readline

a, b = map(int, input().split())
n = int(input())
answer = 0
s = abs(b-a)

for i in range(n):
    t = abs(b-int(input()))
    if t < s:
        answer = 1
        s = t
answer += s
print(answer)