import sys
input = sys.stdin.readline

n = int(input())
m = list(map(int, input().split()))
answer = []

for i in range(n):
    answer.insert(i-m[i], i+1)

print(*answer)
