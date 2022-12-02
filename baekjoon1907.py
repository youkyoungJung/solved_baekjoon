s = input().split('=')
s += s[0].split('+')
del s[0]
#print(s)

result = []

for element in s:
    dictionary = {}
    for i in range(len(s)):
            if element[i].isdigit():
                dictionary[element[i-1]] = dictionary.get(element[i-1])+(int(element[i]))-1
            else:
                dictionary[element[i]] = dictionary(element[i],0)+1
    result.append(dictionary)
print(result)