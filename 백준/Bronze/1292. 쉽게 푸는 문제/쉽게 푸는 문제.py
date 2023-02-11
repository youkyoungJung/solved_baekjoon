import sys
input = sys.stdin.readline

a, b = map(str, input().split())
s = []
for i in range(int(b)):
    s.append(i+1)
#print(s)
k = []
for i in s:
    for j in range(i):
        k.append(i)
#print(k)
su = k[int(a)-1:int(b)]
print(sum(su))