def palindrome(s):
    i,j = 0, len(s)-1
    while i<j:
        if s[i] == s[j]:
            i += 1
            j -= 1
        else:
            return 'no'
    return 'yes'



while True:
    s = input()
    if s == '0':
        break
    print(palindrome(s))
