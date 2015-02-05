public class PascalTriangleII {
    /**
     * Line 1: [1, 0]
     * Line 2: [1, 1] - res.set(0, res.get(i) + res.get(i + 1))
     */ 
    public List<Integer> getRow(int rowIndex) {
        List<Integer> line = new ArrayList<Integer>();
        line.add(1);
        if (rowIndex < 0) {
            return line;
        }

        for (int i = 1; i <= rowIndex; i++) {
            line.add(0, 1);
            for (int j = 1; j < i; j++) {
                line.set(j, line.get(j) + line.get(j + 1));
            }
        }
        return line;
    }
}