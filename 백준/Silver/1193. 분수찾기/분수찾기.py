import sys
input = sys.stdin.readline
# [0][0] (1) 0
# -[0][1]-[1][0] (2, 3) 1
# -[2][0]-[1][1]-[0][2] (4, 5, 6) 2
# -[3][0]-[2][1]-[1][2]-[0][3] (7, 8, 9, 10) 3
# -[0][4]-[1][3]-[2][2]-[3][1]-[4][0] (11, 12, 13, 14, 15) 4

n = int(input())

line = 0
end = 0
while n > end:
    line += 1
    end += line
diff = end- n
if line % 2 == 0:
    top = line - diff
    bottom = diff + 1
else:
    top = diff + 1
    bottom = line - diff
        #print(a,b)
print('%d/%d'%(top, bottom))

