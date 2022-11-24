s = int(input())
tmp = []

for i in str(s):
    tmp.append(int(i))

tmp.sort(reverse=True)
for i in tmp:
    print(i, end="")
