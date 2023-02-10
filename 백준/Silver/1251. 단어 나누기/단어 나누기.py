import sys
input = sys.stdin.readline
#mobitel-> mob/ite/l -> bometil (사전 순으로 가장 앞서는 단어)
# 109 111 98 105 116 101 108 10
text = list(map(str, input().rstrip()))
a = []

for i in range(1, len(text)-1):
    for j in range(i+1, len(text)):
        f = text[:i]
        s = text[i:j]
        t = text[j:]

        f.reverse()
        s.reverse()
        t.reverse()

        a.append("".join(f+s+t))
print(min(a))

