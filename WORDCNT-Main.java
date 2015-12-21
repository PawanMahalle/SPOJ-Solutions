import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int test = Integer.parseInt(br.readLine());

		while (test-- != 0) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int currentWrdCnt = 0;
			int currentCount = 0;
			int maxCount = -1;
			while (st.hasMoreTokens()) {
				int wrdCnt = st.nextToken().length();
				if (currentWrdCnt == wrdCnt) {
					currentCount++;
					if (currentCount > maxCount) {
						maxCount = currentCount;
					}
				} else {
					currentCount = 1;
					currentWrdCnt = wrdCnt;
				}
			}
			
			System.out.println(maxCount);
		}
	}
}
