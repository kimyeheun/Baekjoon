n=int(input())

for i in range(n):
    word=input()
    for j in range(len(word)-1):
        if word[j]!=word[j+1]:
            if word[j] in word[j+1:]:
                n-=1
                break
                         
print(n)                
