import java.util.Scanner;

class student1 {
    String name;
    int id;
    int[] score = new int[subcnt+1];
    double avg;
    char grade;
    int rank;
    static int subcnt;
}

public class Score {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("성적을 조회할 학생 수 입력 : ");
        int m_cnt = sc.nextInt();
        student[] stu = new student[m_cnt];

        System.out.print("조회할 과목 수 입력 : ");
        int subcnt = sc.nextInt();

        int[] id = new int[m_cnt];
        String[] name = new String[m_cnt];
        String[] sub = {"국어", "영어", "수학", "자바", "한국사", "일본어", "자바", "CG", "기가"};
        int[][] score = new int[m_cnt][subcnt + 1];
        int[] total = new int[m_cnt];
        double[] avg = new double[m_cnt];
        char[] grade = new char[m_cnt];
        int[] Tscore = new int[subcnt];
        int[] rank = new int[m_cnt];
        for (int i = 0; i < m_cnt; i++) {
            System.out.print("학번 : ");
            id[i] = sc.nextInt();
            System.out.print("이름 : ");
            name[i] = sc.next();
            for (int j = 0; j < subcnt; j++) {
                do {
                    System.out.print(sub[j] + " : ");
                    score[i][j] = sc.nextInt();
                } while (score[i][j] > 100 || score[i][j] < 0);
                score[i][subcnt] += score[i][j];
                Tscore[j] += score[i][j];
            }
            total[i] += score[i][subcnt];
            avg[i] = (double) (total[i] / subcnt);

            switch ((int) avg[i] / 10) {
                case 10, 9:
                    grade[i] = 'A';
                    break;
                case 8:
                    grade[i] = 'B';
                    break;
                case 7:
                    grade[i] = 'C';
                    break;
                case 6:
                    grade[i] = 'D';
                    break;
                default:
                    grade[i] = 'F';
            }
        }
        for (int i = 0; i < m_cnt - 1; i++) {
            for (int j = i + 1; j < m_cnt; j++) {
                if (avg[i] < avg[j]) {
                    rank[i]++;
                } else if (avg[i] > avg[j]) {
                    rank[j]++;
                }
            }
        }
        for (int i = 0; i < m_cnt; i++) {
            System.out.printf("%-5d %5s", id[i], name[i]);
            System.out.print("           ");
            for (int j = 0; j < subcnt; j++) {
                System.out.printf("%-5d", score[i][j]);
            }
            System.out.printf("%-5d %5.2f %5s %5d\n", total[i], avg[i], grade[i], rank[i]+1);
        }
        System.out.print("                        ");
        for (int i = 0; i < subcnt; i++) {
            System.out.printf("%-5d", Tscore[i]);
        }
    }
}
