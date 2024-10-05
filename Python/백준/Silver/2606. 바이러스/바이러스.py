import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
k = int(input())

li = [[] for _ in range(n + 1)]
visited = [False] * (n + 1)

for _ in range(k):
    a, b = map(int, input().split())
    li[a].append(b)
    li[b].append(a)

answer = 0
def bfs(x):
    global answer
    q = deque()
    q.append(x)
    visited[x] = True

    while q:
        tmp = q.popleft()

        for i in li[tmp]:
            if not visited[i]:
                q.append(i)
                answer += 1
                visited[i] = True

bfs(1)
print(answer)
