def solution(s):
    li = list(map(int, s.split()))
    mini = min(li)
    maxi = max(li)
    answer = "{} {}".format(mini, maxi)
    return answer