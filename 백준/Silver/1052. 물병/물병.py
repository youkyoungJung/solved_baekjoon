import sys
input = sys.stdin.readline
n,k = map(int, input().split())

cnt = 0


#1의개수(n의 이진수에서)가 k보다 클때 n을 더해가며 반복적으로 비교
while bin(n).count('1') > k:
    n+=1
    cnt+=1
print(cnt)