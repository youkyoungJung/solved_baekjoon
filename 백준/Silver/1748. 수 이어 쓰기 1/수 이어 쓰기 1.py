import sys
input = sys.stdin.readline

n = int(input())

if n < 10:
    print(n)
else:
    cnt = 0
    len_n = len(str(n))
    cnt += (n-10**(len_n-1)+1)*len_n
    len_n -= 1

    while len_n>0:
        cnt += len_n*(10**len_n - 10**(len_n-1))
        len_n -= 1
    print(cnt)