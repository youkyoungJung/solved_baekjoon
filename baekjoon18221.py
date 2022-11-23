import sys
input = sys.stdin.readline

N = int(input())

array = []
sung = None
prof = None

for i in range(N):
    board = list(map(int, input().split()))
    for j in range(N):
        if board[j] == 2:
            sung = (i, j)
        elif board[j] == 5:
            prof = (i, j)
    array.append(board)
def algorithm(x1,y1,x2,y2):
    cnt = 0
    x_min, y_min = min(x1, x2), min(y1, y2)
    x_max, y_max = max(x1, x2), max(y1, y2) 

    for y in range(y_min, y_max+1):
        for x in range(x_min, x_max+1):
            if array[y][x] == 1:
                cnt += 1

    if cnt >= 3 and (x1-x2)**2 + (y1-y2)**2 >= 25:
        if x1 == x2 or y1 == y2:
            return True
        else:
            if (x1-x2)**2 + (y1-y2)**2 >= 25:
                return True
    else:
        return False

y1,x1 = sung
y2,x2 = prof
print(int(algorithm(x1,y1,x2,y2)))