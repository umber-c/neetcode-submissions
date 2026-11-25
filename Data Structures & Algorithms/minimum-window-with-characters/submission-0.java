class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) {
            return "";
        }

        HashMap<Character, Integer> frequencyNeeded = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char letter = t.charAt(i);
            int currentCount = frequencyNeeded.getOrDefault(letter, 0);
            frequencyNeeded.put(letter, currentCount + 1);
        }

        int l = 0;
        int r = 0;
        int missing = t.length();
        int bestStart = 0;
        int bestLength = Integer.MAX_VALUE;

        while (r < s.length()) {
            char letter = s.charAt(r);

            if (frequencyNeeded.containsKey(letter)) {
                int count = frequencyNeeded.get(letter);

                if (count > 0) {
                    missing--;
                }

                frequencyNeeded.put(letter, count - 1);
            }

            while (missing == 0) {
                int currentLength = r - l + 1;

                if (currentLength < bestLength) {
                    bestLength = currentLength;
                    bestStart = l;
                }

                char outgoing = s.charAt(l);

                if (frequencyNeeded.containsKey(outgoing)) {
                    int count = frequencyNeeded.get(outgoing);
                    count++;
                    frequencyNeeded.put(outgoing, count);

                    if (count > 0) {
                        missing++;
                    }
                }

                l++;
            }

            r++;
        }

        if (bestLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(bestStart, bestStart + bestLength);
    }
}