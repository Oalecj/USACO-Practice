/*
ID: nikhilf1
PROG: crypt1
LANG: C++11
*/
#include <fstream>
#include <iostream>
#include <cmath>
#include <algorithm>
#include <string>
#include <cstring>
#include <vector>
#include <stack>
#include <queue>
using namespace std;
ofstream fout ("crypt1.out");
ifstream fin ("crypt1.in");
int N;
vector<int> numbers;
int arrayN[6];
int counts = 0;
int toInt(vector<int> numb)
{
    int res = 0;
    for(int i = 0; i < numb.size(); ++i)
    {
        res *= 10;
        res += numb[i];
    }
    return res;
}
void print()
{
    for(int i = 1; i <= 5; ++i)
    {
        cout<<arrayN[i];
    }
    cout<<endl;
}
bool validNumber(int number)
{
    while(number != 0)
    {
        int rem = number % 10;
        number /= 10;
        bool has = false;
        for(int i = 0; i < N; ++i)
        {
            if(rem == numbers[i])
            {
                has = true;
                break;
            }
        }
        if(!has) return false;
    }
    return true;
}
void rec(int n)
{
    if(n == 6)
    {
        vector<int> first, second;
        first.push_back(arrayN[1]);first.push_back(arrayN[2]);first.push_back(arrayN[3]);
        second.push_back(arrayN[4]);second.push_back(arrayN[5]);
        int number1 = toInt(first);
        int number2 = toInt(second);
        if(number1 * second[0] >= 1000 || !validNumber(number1 * second[0])) return;
        if(number1 * second[1] >= 1000 || !validNumber(number1 * second[1])) return;
        if(number1 * number2 >= 10000 || number1 * number2 < 1000 || !validNumber(number1 * number2)) return;
        ++counts;
        print();
        return;
    }
    for(int i = 0; i < N; ++i)
    {
        arrayN[n] = numbers[i];
        rec(n+1);
    }
}
int main()
{
    fin >> N;
    for(int i = 0; i < N; ++i)
    {
        int current;
        fin >> current;
        numbers.push_back(current);
    }
    rec(1);
    fout<< counts <<endl;
    return 0;
}
