#문빈이가 한수에게 팰린드롬 영어이름을 만들어 주려함

import sys
input = sys.stdin.readline

#팰린드롬 판별
def is_palindrome(word):
    return word == word[::-1]

#영어이름 넣기 - 딕셔너리 이용
name = list(map(str,input().strip()))
name.sort()
w = {}
for i in name:
    if i not in w:
        w[i] = 1
    else:
        w[i] += 1
#print(w)
cnt = 0
center = ""
res = ""
for key, value in w.items():
    if value % 2 != 0:
        cnt+=1
        center += key
        name.remove(key)
#print(name)
if cnt > 1 :
    print("I'm Sorry Hansoo")
else:
    for i in range(0, len(name), 2):
        res += name[i]

    print(res + center + res[::-1])