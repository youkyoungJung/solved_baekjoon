n = int(input())
dp = [0]*101
cnt = 0
m = list(map(int,input().split()))
for i in range(len(m)):
    if dp[m[i]] == 0:
        dp[m[i]] = 1
    else:
        cnt += 1
print(cnt)
