#include<iostream>
#include<fstream>
using namespace std;
int main() {
    fstream f("out.txt", ios::in);
    string s;
    int lines=0;
    int cnt=0;
    while (getline(f,s)) {
        cout<<s<<endl;
        for (int i=0; i<s.length(); ++i)
            if (s[i]=='o') ++cnt;
        ++lines;
    }
    cout<<lines<<endl;
    cout<<cnt<<endl;
    f.close();

    return 0;
}