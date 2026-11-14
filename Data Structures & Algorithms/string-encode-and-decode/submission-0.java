class Solution {

    public String encode(List<String> strs) {

        StringBuilder result = new StringBuilder();

        for (String str : strs){
            result.append(str.length());
            result.append("#");
            result.append(str);
        }

        return result.toString();

    }

    public List<String> decode(String str) {

        List<String> result = new ArrayList<>();

        for (int i = 0; i < str.length(); ) {

            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            String digits = str.substring(i, j);
            int length = Integer.parseInt(digits);

            // 41#supercal....ous32#... (start at s now which is j + 1 since j = #.)
            int start = j + 1;
            int end = start + length;

            String word = str.substring(start, end);

            result.add(word);

            i = end;
        }

    return result;

    }
}