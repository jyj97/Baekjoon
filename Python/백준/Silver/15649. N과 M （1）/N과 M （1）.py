def permutation(cnt):
    if(cnt == m):
        print(" ".join(map(str,num_permu)))
        return
    
    else:
        for idx in range(0, n):
            if(isselected[idx] == True):
                continue
            else:
                isselected[idx] = True
                num_permu[cnt] = numlist[idx]
                permutation(cnt + 1)
                isselected[idx] = False


n, m = map(int, input().split())

num_permu = [0] * m

numlist = list(range(1, n+1))

isselected = [False] * n

permutation(0)