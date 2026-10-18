class Solution {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();

        for (String str : strs) {
            result.append(str.length())
                  .append("#")
                  .append(str);
        }

        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;

            // Find the separator after the length
            while (str.charAt(j) != '#') {
                j++;
            }

            // Convert the length into an integer
            int length = Integer.parseInt(str.substring(i, j));

            // Read exactly 'length' characters
            int start = j + 1;
            int end = start + length;

            result.add(str.substring(start, end));

            // Move to the beginning of the next length
            i = end;
        }

        return result;
    }
}
