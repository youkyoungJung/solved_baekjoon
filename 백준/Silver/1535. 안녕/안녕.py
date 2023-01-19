N = int(input())
L = [int(x) for x in input().split()] #체력
J = [int(x) for x in input().split()] #기쁨

dp = [[0]*101 for _ in range(N+1)] #행 - 한명의 사람, 열-체력

for i in range(1, N+1):# 한명의 사람을 순환
    s = L[i-1]         # 해당 사람 만나는데 필요한 체력
    p = J[i-1]         # 해당 사람 만나서 얻는 기쁨
    
    for j in range(1, 101): #체력이 1-100일 경우
        if j <= s:          #현재 남아 있는 체력으로 현재 사람을 만날 수 없는경우
            dp[i][j] = dp[i-1][j] #현재 사람을 만나지 않음
            
        else:
            dp[i][j] = max(dp[i-1][j], p+dp[i-1][j-s])#남은 체력으로 현재사람 만나는 경우 추가

#사람을 안만나는 경우 vs 만나는 경우 중 더 큰 기쁨을 얻게되는 결과 선택
print(dp[N][100])