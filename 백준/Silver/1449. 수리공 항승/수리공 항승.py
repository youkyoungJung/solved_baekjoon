n,l = map(int, input().split())
a = list(map(int, input().split()))
count = 1
a.sort()
start = a[0]

for i in a[1:]:
    if i in range(start, start+l):
        continue
    else:
        start = i
        count += 1
print(count)