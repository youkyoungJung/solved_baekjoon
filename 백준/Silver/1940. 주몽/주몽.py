import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
s = list(map(int, input().split()))
s = sorted(s)
cnt = 0
i , j = 0, n-1

while i < j:
    if m == s[i] + s[j]:
        cnt += 1
        i += 1
        j -= 1
    elif m > s[i] + s[j]:
        i += 1
    else:
        j -= 1
print(cnt)