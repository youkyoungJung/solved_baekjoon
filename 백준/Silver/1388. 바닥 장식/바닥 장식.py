n,m = map(int, input().split())
board = []
for _ in range(n):
    board.append(list(input()))
cnt = 0
for i in range(n):
    flag = "/"
    for j in range(m):
        if board[i][j] == '-':
            if board[i][j] != flag:
                cnt += 1
        flag = board[i][j]
for j in range(m):
    flag = "/"
    for i in range(n):
        if board[i][j] == '|':
            if board[i][j] != flag:
                cnt+=1
        flag = board[i][j]
print(cnt)