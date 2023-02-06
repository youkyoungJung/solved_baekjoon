import sys
input = sys.stdin.readline

n = int(input())

for i in range(n):
    text = list(input().split())
    print('Case #%d: %s'%(i+1,  ' '.join(text[::-1])))