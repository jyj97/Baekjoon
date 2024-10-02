n = int(input())
li = list(map(int, input().split()))

x = int(input())

li.sort()

answer = 0
left, right = 0, n - 1

while left < right:
    tmpsum = li[left] + li[right]

    if tmpsum == x:
        answer += 1
        left += 1
        right -= 1

    elif tmpsum < x:
        left += 1

    else:
        right -= 1

print(answer)