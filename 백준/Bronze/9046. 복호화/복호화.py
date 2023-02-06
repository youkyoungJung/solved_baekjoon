t = int(input())
for i in range(t):
    s = input()
    max_alpha = ''
    max_alpha_count = 0
    
    for j in range(ord('a'), ord('z')+1):
        current = s.count(chr(j))
        if current > max_alpha_count:
            max_alpha = chr(j)
            max_alpha_count = current
        elif current == max_alpha_count:
            max_alpha = '?'
        else:
            continue
    print(max_alpha)