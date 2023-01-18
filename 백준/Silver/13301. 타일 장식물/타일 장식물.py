N = int(input())
dp = [0]*81
dp[1] = 1
dp[2] = 1

for i in range(3, N+1):
    dp[i] = dp[i-1]+dp[i-2]
    
print(2*(dp[N]+(dp[N]+dp[N-1])))