a = int(input())

while 1:
    op = input()
    if op == '=':
        break
    b = int(input())

    if op == "+":
        a += b
    elif op == '-':
        a -= b
    elif op == "*":
        a *= b
    elif op == "/":
        a //= b

print(a)