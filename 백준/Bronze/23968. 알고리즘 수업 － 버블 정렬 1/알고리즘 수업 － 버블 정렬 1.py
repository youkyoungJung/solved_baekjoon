import sys
input = sys.stdin.readline

n, k = map(int, input().split())
s = list(map(int, input().split()))

for i in range(n-1, 0, -1):
    for j in range(i):
        if s[j] > s[j+1]:
            s[j], s[j+1] = s[j+1], s[j]
            k -= 1
            if k == 0:
                print('%d %d'%(s[j], s[j+1]))
                exit(0)
print(-1)
