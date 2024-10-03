n, m = map(int, input().split())

li = list(map(int, input().split()))
li.sort()

isselected = [False] * n
per_li = [0] * m


def permu(cnt):
    if cnt == m:
        print(" ".join(map(str, per_li)))
        return
    
    for idx in range(n):
        if not isselected[idx]:
            isselected[idx] = True
            per_li[cnt] = li[idx]
            permu(cnt + 1)
            isselected[idx] = False


permu(0)