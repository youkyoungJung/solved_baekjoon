import sys
input = sys.stdin.readline

score = []
s_score = []
answer = []

for i in range(8):
    score.append(int(input()))

s_score = sorted(score, reverse=True)
s_score = s_score[:5]

for i in s_score:
    answer.append(score.index(i)+1)

answer.sort()

print(sum(s_score))
print(*answer)