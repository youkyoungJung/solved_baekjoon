N = int(input())
L = [int(x) for x in input().split()]
J = [int(x) for x in input().split()]

dp = [[0]*101 for _ in range(N+1)]

for i in range(1, N+1):
    s = L[i-1]
    p = J[i-1]
    
    for j in range(1, 101):
        if j <= s:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i-1][j], p+dp[i-1][j-s])
print(dp[N][100])