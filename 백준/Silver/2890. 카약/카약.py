import sys
input = sys.stdin.readline

r, c = map(int, input().split())
dp = [0] * 9
cnt = 1
s = [input().rstrip()[1: c-1] for _ in range(r)]
flag = 0
t = 0

for i in range(r):
    flag = 0
    for j in range(c-2):
        while flag == 0 and s[i][j] != '.':
            if dp[int(s[i][j])-1] == 0:
                dp[int(s[i][j])-1] = s[i].index(s[i][j])
                flag = 1
#print(dp)
m = max(dp)

s_dp = list(set(sorted(dp)))
rs_dp = list(reversed(s_dp))
#print(rs_dp)

for i in dp:
    print(rs_dp.index(i)+1)