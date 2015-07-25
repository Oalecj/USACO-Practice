/*
ID: nikhilf1
TASK: combo
LANG: C++
*/
#include <iostream>
#include <stdio.h>
#define optimizar_io ios_base::sync_with_stdio(0);cin.tie(0);
using namespace std;

int n, A[4], B[4];
int cont;

int main()
{
    freopen( "combo.in", "r", stdin );
    freopen( "combo.out", "w", stdout );
    cin >> n;
    for( int i = 1; i <= 3; i++ )
        cin >> A[i];
    for( int i = 1; i <= 3; i++ )
        cin >> B[i];

    for( int i = 1; i <= n; i++ ){
        for( int j = 1; j <= n; j++ ){
            for( int k = 1; k <= n; k++ ){

                int a, b, c;
                a = min( max( A[1], i ) - min( A[1], i ),
                        min( A[1], i ) + n - max( A[1], i ) );
                b = min( max( A[3], k ) - min( A[3], k ),
                        min( A[3], k ) + n - max( A[3], k ) );
                c = min( max( A[2], j ) - min( A[2], j ),
                        min( A[2], j ) + n - max( A[2], j ) );
                if( a <= 2 && b <= 2 && c <= 2 ){
                    cont++;
                    continue;
                }
                a = min( max( B[1], i ) - min( B[1], i ),
                        min( B[1], i ) + n - max( B[1], i ) );
                b = min( max( B[3], k ) - min( B[3], k ),
                        min( B[3], k ) + n - max( B[3], k ) );
                c = min( max( B[2], j ) - min( B[2], j ),
                        min( B[2], j ) + n - max( B[2], j ) );
                if( a <= 2 && b <= 2 && c <= 2 )
                    cont++;

            }
        }
    }
    cout << cont << "\n";

    return 0;

}
