a = int(input())
s = input()

r = 31
m = 1234567891

a = 1
result = 0
for x in s:
    result += (ord(x)-96)*a
    a *= r

print(result%m)