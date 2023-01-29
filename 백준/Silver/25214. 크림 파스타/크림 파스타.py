#bakjoon25214
a = int(input())
dp = [0]*a
num = list(map(int, input().split()))
#print(num)
for i in range(len(num)):
        if i == 0:
            dp[0]=0
            n_min = num[0]
        else:
            #print(num[i-1])
            if n_min > num[i]:
                n_min = num[i]
            dp[i] = (num[i] - n_min)
            if dp[i-1] > dp[i]:
                dp[i] = dp[i-1]
for i in dp:
    print(i, end =" ")