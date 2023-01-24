import sys
n = int(input())
t = []
flag = False

for i in range(n):
    t.append(int(sys.stdin.readline()))
t.sort(reverse=True)

for i in range(len(t)-2):
    if t[i] < t[i+1] + t[i+2]:
        print((t[i]+t[i+1]+t[i+2]))
        flag = True
        break

if flag == False:
    print(-1)
