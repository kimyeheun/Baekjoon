num=int(input())
l_ist=[]
for i in range(num):
    count=0
    s_um=0
    check = input()
    for y in range(len(check)):
        if check[y]=='O':
            count+=1
            s_um+=count
            if  y==len(check)-1:
            	 l_ist.append(s_um)
        elif check[y]=='X':
            count=0
            if  y==len(check)-1:
            	 l_ist.append(s_um)
for u in range(num):
    print(l_ist[u])