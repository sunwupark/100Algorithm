package baekjoon.algorithm.Problems.fruit_parksunwu;

import java.io.*;
import java.util.StringTokenizer;

/*
 * @fileName      : frust_parksunwu
 * @author        : 박선우
 * @since         : 2024년 4월 11일
 * @title         : 기숙사 식당 과일디저트물품 구매요청서
 * @description   : 매월말 25일에 출력해서 식자재 구매부서에 전달함.
                    #. 제공과일
                    봄/여름 : 딸기/수박 | 가을/겨울 : 사과/배
                    #. 일자별 제공
                    1,5로 끝나는날 : 딸기/사과 | 3,7로 끝나는날 : 수박/배
                    #. 월은 1 ~ 30일까지 있는 것으로 가정
                    #. 인당 제공 수량
                    딸기 : 5개/1인 , 수박 : 1개/10명 (초과분은 올림, 예를 들어 11명에게는 2개)
                    사과 : 1개/1인 , 배 : 1개/2인
                    #. 계절구분 (숫자는 월)
                    봄: 3~5, 여름 : 6~8, 가을 : 9~11, 겨울 12~2
                    # 입력값 : 월과 식당이용자수 (변수 초기값 : 3월, 70명)
                    # 출력값 : 디저트 구매내역서 (order.txt)
*/

public class fruit_parksunwu {
    public static void main(String[] args) throws IOException {
        // 입력값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 출력값 받기
        StringBuilder sb = new StringBuilder();
        // 파일 생성
        FileWriter fw = new FileWriter("./order.txt");

        // 변수 초기화
        int currentMonth = Integer.parseInt(st.nextToken());
        int numOfUsers = Integer.parseInt(st.nextToken());

        // 파일에 쓰기
        fw.write(currentMonth + "월 디저트 구매내역서 (총 " + numOfUsers + "명)\n");

        // 계절 구분
        String season;
        if(currentMonth <= 8 && currentMonth >= 3){
            season = "springOrsummer";
        } else{
            season = "fallOrwinter";
        }

        // 일자별 제공
        for (int i = 1; i <= 30; i++) {
            sb.append(currentMonth + "월 " + i + "일 : ");
            if(season.equals("springOrsummer")){
                if(i % 10 == 1 || i % 10 == 5) {
                    sb.append("딸기 " + numOfUsers*5 + "개");
                }
                else if(i % 10 == 3 || i % 10 == 7) {
                    sb.append("수박 " + (int) Math.ceil(numOfUsers/10) + "개");
                }
                else {
                    sb.append("-");
                }
            } else{
                if(i % 10 == 1 || i % 10 == 5 ) {
                    sb.append("사과 " + numOfUsers + "개");
                }
                else if(i % 10 == 3 || i % 10 == 7) {
                    sb.append("배 " + (int) Math.ceil(numOfUsers/2) + "개");
                }
            }
            sb.append("\n");
        }

        fw.write(sb.toString() + "\n");

        // 파일 닫기
        fw.close();
    }
}
