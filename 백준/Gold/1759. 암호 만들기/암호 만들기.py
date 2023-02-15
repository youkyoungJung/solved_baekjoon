from itertools import combinations

l,c = map(int, input().split()) #ㅣ가지, c문자종류스
#최소 한개의 모음 두개의 자음
s = list(map(str, input().split(' ')))
s = sorted(s)
comb = combinations(s, l)
mo = ['a','e','i','o','u']
result = []
#acis,acit,aciw,acst,acsw,aist,aisw
for c in comb:
    j = 0
    m = 0
    for i in range(l):
        if c[i] in mo:
            m+=1
        else:
            j+=1
    if m>=1 and j>=2:
        print(''.join(c))