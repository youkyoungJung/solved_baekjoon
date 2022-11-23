while True:
    s = input()
    s_list = []

    if s == ".":
        break

    for i in s:
        if i == '[' or i == '(':
            s_list.append(i)
        elif i == ']' or i == ")":
            s_list.pop()#다 삭제
            break

    if len(s_list) == 0:
        print('yes')
    else:
        print('no')
