arr_init = [[0]*101 for i in range(101)]

for i in range(4):
    a,b,c,d = map(int, input().split())
    for i in range(a,b):
        for j in range(c,d):
            arr_init[i][j] == 1
        
cnt = 0
for i in range(101):
    for j in range(101):
        if arr_init[i][j] == 1:
            cnt += 1

print(cnt)
