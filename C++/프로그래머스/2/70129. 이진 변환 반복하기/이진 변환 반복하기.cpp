#include <string>
#include <algorithm>
#include <vector>

using namespace std;
vector<int> solution(string s) {
    vector<int> answer;
    int r1 = 0, r2 = 0;
    while (s != "1")
    {
        r1++;
        for (int i = 0; i < s.length(); i++)
        {
            if (s[i] == '0')
            {
                s.erase(s.begin() + i);
                r2++;
                i--;
            }
        }

        int len = s.length();
        string res = "";
        while (len != 0)
        {
            res += to_string(len % 2);
            len /= 2;
        }

        reverse(res.begin(), res.end());
        s = res;
    }
    answer.push_back(r1);
    answer.push_back(r2);
    return answer;
}