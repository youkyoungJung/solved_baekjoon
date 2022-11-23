#A
#A: B
#B: BA
#BA: BAB
#BAB: BABBA

# str = 'A'
# n = int(input())
# for i in range(n):
#     new_str = ''
#     for j in str:
#         if j == 'A':
#             new_str += 'B'
#         elif j == 'B':
#             new_str += 'BA'
#     str = new_str
#     print(str)    

# print(str.count('A'), str.count('B')) 

n = int(input())

d = [[] for _ in range(n+1)]
d[0] = [1,0]
d[1] = [0,1]

for i in range(2, n+1):
    d[i] = [d[i-1][0] +d[i-2][0], d[i-1][1]+d[i-2][1]]

print(d[n][0], d[n][1])