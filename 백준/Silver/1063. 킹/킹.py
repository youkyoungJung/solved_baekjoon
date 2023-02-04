import sys
input = sys.stdin.readline

k, r, n = input().split()

king = list(map(int, [ord(k[0])-64, k[1]]))
rock = list(map(int, [ord(r[0])-64, r[1]]))

#print(k_row, k_column, r_row, r_column)

steps = {'R':[1, 0], 'L':[-1,0], 'B':[0,-1], 'T':[0,1],
         'RT':[1,1], 'LT':[-1,1], 'RB':[1,-1], 'LB':[-1,-1]}

for i in range(int(n)):
    s = input().strip()
    row_k = king[0] + steps[s][0]
    column_k = king[1] + steps[s][1]

    if 0 < row_k <= 8 and 0 < column_k <= 8:
        if row_k == rock[0] and column_k == rock[1]:
            row_r = rock[0] + steps[s][0]
            column_r = rock[1] + steps[s][1]
            if 0 < row_r <= 8 and 0 < column_r <= 8:
                king = [row_k, column_k]
                rock = [row_r, column_r]
        else:
            king = [row_k, column_k]
answer_k = chr(king[0] + 64)+str(king[1])
answer_r = chr(rock[0] + 64)+str(rock[1])
print(answer_k)
print(answer_r)




