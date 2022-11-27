n = int(input())
s = list(map(int, input().split()))
#print(s)
a = sorted(s)
tmp = a[-2]
a.append(tmp)
del a[-3]

sum = 0
for i in range(0,n-1):
    sum += abs(a[i]-a[i+1])
print(sum + (a[-1]-a[0]))
