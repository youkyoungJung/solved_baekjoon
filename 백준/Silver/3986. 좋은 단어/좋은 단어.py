import sys
input = sys.stdin.readline

n = int(input())
cnt = 0

for _ in range(n):
    data = input().strip()
    s = []
    for i in range(len(data)):
        if len(s) > 0:
            if data[i] == s[-1]:
                s.pop()
            else:
                s.append(data[i])
        else:
            s.append(data[i])

    if len(s) == 0:
        cnt += 1
print(cnt)