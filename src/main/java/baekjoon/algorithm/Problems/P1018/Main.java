package baekjoon.algorithm.Problems.P1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static char[][] arr;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String inputs = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = inputs.charAt(j);
            }
        }

        char previous = arr[0][0];

        for (int i = 0; i < N; i++) {
            for(int j = 0; j <M; j++){
                if()
            }
        }
    }

    static void check(int x, int y, char[][] arr, int count){
        if(x-1 > -1){
            if(arr[x-1][y] == arr[x][y]){
                if(arr[x-1][y] == 'B')
                    arr[x][y] = 'W';
                else
                    arr[x][y] = 'B';
                count++;
            }
        } else if(y-1 > -1){
            if(arr[x][y-1] == arr[x][y]){
                if(arr[x][y-1] == 'B')
                    arr[x][y] = 'W';
                else
                    arr[x][y] = 'B';
                count++;
            }
        }

        if(x+1 < N){
            check(x+1,y,arr, count);
        } else if(y+1 < N){
            check(0, y+1, arr, count);
        } else{
            result.add(count);
        }
    }
}
