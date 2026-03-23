
import java.io.*;
import java.util.*;

//배낭 문제는 물건을 쪼갤 수 있는 Fraction / 0-1 로 분류
//평범한 배낭(0-1 냅색 알고리즘)
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 물품 수
        int k = Integer.parseInt(st.nextToken()); // 배낭의 적재 가능한 무게

        int[][] dp = new int[n+1][k+1];
        int[] W = new int[n+1];
        int[] V = new int[n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            W[i] = w;
            V[i] = v;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                // 물건 무게가 배낭보다 크면 dp[i번쨰 물건][배낭 jkg] 값은 이전의 값(아무 변화없는 값)이다.
                if (W[i] > j) dp[i][j] = dp[i - 1][j];
                    // 물건 무게가 배낭보다 작다면 이전 값(아무 변화없는 값) vs 현재 물건을 넣었으니(V[i]) 남은 공간을 뺀다(j- W[i])
                else dp[i][j] = Math.max(dp[i - 1][j], V[i] + dp[i - 1][j - W[i]]);
            }
        }
        System.out.println(dp[n][k]);

        //배낭에 담을 수 있는 무게 = W
        //물건의 무게/가치 = N/M

        //최대 W 만큼 담을 수 있는 배낭 문제는 i번쨰 물건을 넣은 뒤 새로운 문제로 치환될 수 있음
        // ㄴ 최대 (W-N) 만큼 담을 수 있는 배낭

        //해당 로직을 반복하면 변하는 것은 2가지
        //1. 배낭의 최대 무게(W),
        //2. 담을 수 있는 봉투의 개수 및 종류

        //경우의 수가 여러가지로 갈리기 때문에 2차원 배열을 사용해서
        //각 경우의 수에 따른 답을 따로 저장해야함

        //최대이익[i][w] = 최대 무게가 w인 배낭에서 i번째 물건까지 판단했을 때의 최대 가치
        //ex : 최대이익[4][6] 의미는 최대 무게 W 인 배낭에서 4번째 물건까지 진행했을 때의 최대 가치를 의미함
        // 4$/3kg, 2$/1kg, 5$/6kg, 6$/5kg 의 경우 8$이 됨 (최대이익[4][6] = 2$/1kg + 6$/5kg) = 8$

        //이후 다음 i+1 의 물건을 탐색할 때의 최대가치를 구한다면?
        //경우의 수는 2가지이다
        //1.i 번 물건의 무게가 햔재 W 를 초과할 때
        // ㄴ 배낭에 적재 불가하므로 최대가치인 i 번째가 유지된다. 최대이익[i+1][w] = 촤대이익[i][w];
        //2.i 번 물건의 무게가 현재 W 를 초과하지않을 때
        // ㄴ 경우의 수 2가지로 나뉜다.
        // ㄴ 넣지 않는다 -> 이전 값 유지 최대이익[i+1][w] = 최대이익[i][w];
        // ㄴ 넣는다 -> 배낭에 만약 충분한 무게가 없다면 안에 있는 물건을 빼고 물건을 넣어야할 수 있음
        //    ㄴ여기서 최대 W 만큼 담을 수 있는 배낭 문제를 최대 (W-N) 담을 수 있는 문제로 치환하는 것
        //     ㄴ 예를 들어 6kg 배낭에 3kg인 물건을 넣으면 최대이익[i][w] = 4 + dp[0][3]
        //     ㄴ 최대 6kg 를 담을 수 있는 배날ㅇ에서 첫번째 물건까지 탐색했을 때의 최대 가치를 따지는데
        //     ㄴ 첫번째 물건을 뽑았다고 가정 시 이는 최대 3kg 담을 수 있는 배낭으로 0번 째 물건까지 탐색했을 때의 최대이익과 같음
        //     ㄴ 최대 W 까지 담을 수 있는 배낭이 i+1 번째 물건을 담았을 때가 최대 가치라면 최대이익[i+1][w] = i+1 가치 + 최대이익[i][w-n]
        //     ㄴ i+1 번째 물건의 가치 + 그 물건의 무게 m 을 뺀 (w-n) 로 1~i 물건으로 구할 수 있는 최대 가치
    }
}
