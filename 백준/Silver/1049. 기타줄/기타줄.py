#N: 끊어진 기타줄, M: 기타줄 브랜드
#p: 기타줄 6개가 들어있는 패키지 가격, u: 낱개 가격
#a: 몫, b: 나머지
import sys
#input = sys.stdin.readline

N,M = map(int, input().split(' '))

a = N //6
b = N %6
minPack = 1001
minUnit = 1001
sum = 0

for i in range(M):
    p, u = map(int, input().split(' '))
    minPack = min(minPack,p)
    minUnit = min(minUnit,u)

if minPack > minUnit*6:
    sum += N * minUnit
else:
    sum += a *minPack
    if b*minUnit > minPack:
        sum += minPack
    else:
        sum += b*minUnit

print(sum)