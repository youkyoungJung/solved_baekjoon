t = int(input())


for i in range(t):
    n = int(input())
    s = list(map(int, input().split()))
    MaxSum, ThisSum = 0,0
    for k in range(n):
        ThisSum = max(ThisSum + s[k], 0)
        MaxSum = max(MaxSum, ThisSum)

    print(MaxSum)