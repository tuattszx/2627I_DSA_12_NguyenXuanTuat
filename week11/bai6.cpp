#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);

/*
 * Complete the 'runningMedian' function below.
 *
 * The function is expected to return a DOUBLE_ARRAY.
 * The function accepts INTEGER_ARRAY a as parameter.
 */
struct tree{
    int n;
    vector<int> st;
    tree(int n){
        this->n = n;
        st.assign(4 * n, 0);
    }
    void modify(int p, int v, int id, int l, int r){
        if (p < l || p > r)return;
        if (l == r){
            st[id] += v;
            return;
        }
        int mid = (l + r) >> 1;
        modify(p, v, id << 1, l, mid);
        modify(p, v, id << 1 | 1, mid + 1, r);
        st[id] = st[id << 1] + st[id << 1 | 1];
    }
    int get(int k, int id, int l, int r){
        //cout << st[id] << ' ' << id << ' ' << l << ' ' << r << el;
        if (l == r) return r;
        int mid = (l + r) >> 1;
        if (k <= st[id << 1]) return get(k, id << 1, l, mid);
        return get(k - st[id << 1], id << 1 | 1, mid + 1, r);
    }
    void modify(int p){
        modify(p, 1, 1, 0, n);
    }
    int get(int k){
        return get(k, 1, 0, n);
    }
};
vector<double> runningMedian(vector<int> a) {
    tree seg((1 << 17) - 1);
    vector<double> res;
    int n = a.size();
    for (int i = 0; i < n; ++i){
        seg.modify(a[i]);
        if (i&1){
            double x = seg.get(i / 2), y = seg.get(i / 2 + 1);
            res.push_back((x + y) / 2);
        }else{
            double x = seg.get(i / 2 + 1);
            res.push_back(x);
            
        }
    }
    return res;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string a_count_temp;
    getline(cin, a_count_temp);

    int a_count = stoi(ltrim(rtrim(a_count_temp)));

    vector<int> a(a_count);

    for (int i = 0; i < a_count; i++) {
        string a_item_temp;
        getline(cin, a_item_temp);

        int a_item = stoi(ltrim(rtrim(a_item_temp)));

        a[i] = a_item;
    }

    vector<double> result = runningMedian(a);

    for (size_t i = 0; i < result.size(); i++) {
        fout << result[i];

        if (i != result.size() - 1) {
            fout << "\n";
        }
    }

    fout << "\n";

    fout.close();

    return 0;
}

string ltrim(const string &str) {
    string s(str);

    s.erase(
        s.begin(),
        find_if(s.begin(), s.end(), not1(ptr_fun<int, int>(isspace)))
    );

    return s;
}

string rtrim(const string &str) {
    string s(str);

    s.erase(
        find_if(s.rbegin(), s.rend(), not1(ptr_fun<int, int>(isspace))).base(),
        s.end()
    );

    return s;
}
