import java.util.ArrayList;

public class hirota_lab13 {
	ArrayList<Integer> values = new ArrayList<Integer>();
	
	public void readData(String filename) {
		try {
            java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(filename)));
            String inn;
            while ((inn = input.readLine()) != null) {
                java.util.StringTokenizer st = new java.util.StringTokenizer(inn);
                while (st.hasMoreTokens()) {
                	String token = st.nextToken();
                	values.add(Integer.parseInt(token));
                }
            } input.close();
		} catch (Exception e) {
			System.out.println("Error: There's no file");
			System.exit(0);
		}
	}
	
	public long getTotalCount() {
		return values.stream().count();
	}
	
	public long getOddCount() {
		return values.stream().filter(num -> (num % 2) == 1).count();
	}
	
	public long getEvenCount() {
		return values.stream().filter(num -> (num % 2) == 0).count();
	}
	
	public long getDistinctGreaterThanFiveCount() {
		return values.stream().filter(num -> num > 5).distinct().count();
	}
	
	public Integer[] getResult1() {
		return (Integer[]) values.stream().filter(num -> (num % 2 == 0) && (num > 5) && (num < 50)).sorted().toArray(Integer[]::new);
	}
	
	public Integer[] getResult2() {
		return (Integer[]) values.stream().limit(50).map(num -> num * num * 3).toArray(Integer[]::new);
	}
	
	public Integer[] getResult3() {
		return (Integer[]) values.stream().filter(num -> num % 2 == 1).map(num -> num * 2).sorted().skip(20).distinct().toArray(Integer[]::new);
	}
}
