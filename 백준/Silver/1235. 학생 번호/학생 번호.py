import sys
input = sys.stdin.readline

n = int(input())
numbers = [input().rstrip() for _ in range(n)]
cnt = 1

while True:
    check = set()
    for number in numbers:
        check.add(number[-cnt:])
    if len(check) == n:
        break
    cnt += 1
print(cnt)
