import sys
input = sys.stdin.readline

n = int(input())

def hanoi(num, desti, temp, to):
    if num == 1:
        print('%d %d' %(desti, to))
    else:
        hanoi(num-1, desti, to, temp)
        print('%d %d' %(desti, to))
        hanoi(num-1, temp, desti, to)

time = 2**n-1
print(time)
if n <= 20:
    hanoi(n, 1, 2, 3)