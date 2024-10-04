import sys

input = sys.stdin.readline
n = int(input())
li = [[] for _ in range(n + 1)]
answer = [0] * (n + 1)
visited = [False] * (n + 1)

for _ in range(n - 1):
    s, e = map(int,input().split())

    li[s].append(e)
    li[e].append(s)


from collections import deque
def bfs(x):
    q = deque()
    q.append(x)
    visited[x] = True
   
    while q:
        tmp = q.popleft()

        for i in li[tmp]:
            if not visited[i]:
                visited[i] = True
                q.append(i)
                answer[i] = tmp

bfs(1)

for i in range(2, n + 1):
    print(answer[i])