n = int(input())
data = []
names = {}
for i in range(n):
    data.append(input())
for name in data:
    if name[0] not in names:
        names[name[0]] = 1
    else:
        names[name[0]] += 1

answer = []
for key, value in names.items():
    if value >= 5:
        answer.append(key)
if len(answer) == 0:
    print('PREDAJA')
else:
    print(''.join(sorted(answer)))