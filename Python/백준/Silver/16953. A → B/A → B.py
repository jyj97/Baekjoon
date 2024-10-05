import sys
input = sys.stdin.readline
a, b = map(int, input().split())

visited = set()
answer = float('inf')
def dfs(num, cnt):
    global answer

    if num > b:
        return

    if num in visited:
        return

    if num == b:
        if cnt < answer:
            answer = cnt
        return

    visited.add(num)

    dfs(num * 2, cnt + 1)
    dfs(num * 10 + 1, cnt + 1)

    
dfs(a, 0)
if answer == float('inf'):
    print(-1)
else:
    print(answer + 1)