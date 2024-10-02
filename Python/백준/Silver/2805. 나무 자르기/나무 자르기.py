n, m = map(int, input().split())

li = list(map(int, input().split()))

start = 0
end = max(li)

answer = 0
while start <= end:
    mid = (start + end) // 2
    plus = sum(i - mid for i in li if i > mid)
    
    
    if plus >= m:
        start = mid + 1
        answer = mid
    
    else:
        end = mid - 1

print(answer)