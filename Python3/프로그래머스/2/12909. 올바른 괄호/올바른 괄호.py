def solution(s):
    answer = True
    
    tmp = []
    
    for i in s:
        if i == "(":
            tmp.append("(")
        else:
            if not tmp:
                answer = False
                break
            else:
                tmp.pop(-1)
                
    if answer == True and tmp:
        answer = False

    return answer