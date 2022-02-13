package level34_KMPAndTrie;

import java.io.*;
import java.util.*;

public class pb02_P5_4354_backup {

	static class Point {
		int start, now;

		public Point(int start, int now) {
			this.start = start;
			this.now = now;
		}

	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String s = br.readLine();
			if(s.equals(".")) break;
			
			char[] T = s.toCharArray();
			
			ArrayList<Point> iList = new ArrayList<>(); 
			/*
			 * 백만자가 넘는 문자열도 들어오므로 딱 한번만 돌아야한다
			 * best : 1글자로 반복되는경우, worst : 부분문자열이 없는경우
			 * 한자리씩 늘어날때마다 처음 자리와 비교하면서 같으면 ilist에 추가
			 * 이후 ilist에 있는것과 비교하고 같으면 1씩 증가하면서 비교
			 * 비교하면서 같지않으면 인덱스 제거해버림
			 */
			iList.add(new Point(1, 0));
			for (int i = 1; i < T.length; i++) {
				for (int j = 0; j < iList.size(); j++) {
					Point np= iList.get(j);
					if(T[i] != T[np.now])
						iList.remove(j);
					np.now = (np.now + 1) % np.start;
				}
				// 원문자열의 절반보다 길면 부분문자열에 속할 수없으므로 조건으로 처리
				if(T[i] == T[0] && i < Math.ceil(T.length / 2)) {
					iList.add(new Point(i, 1));
				}
			}
			/*
			 * 제일 앞에 살아남은놈이 가장 짧은 문자열길이임
			 * iList에 아무것도없으면 부분문자열이 아예없는것이므로 1이출력되도록 세팅
			 */
			int size = 0;
			if(iList.isEmpty()) {
				size = 1;
//				sb.append("blank ");
			} else {
				size = T.length / iList.get(0).start;
			}
			sb.append(size).append("\n");
		}
		System.out.println(sb);
	}
}
