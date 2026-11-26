class TimeEntry {
    int timestamp;
    String value;

    TimeEntry(int time, String text) {
        timestamp = time;
        value = text;
    }
}

class TimeMap {
    HashMap<String, ArrayList<TimeEntry>> histories = new HashMap<>();

    public TimeMap() {
    }

    public void set(String key, String value, int timestamp) {
        // Create a history list when this key first appears.
        if (!histories.containsKey(key)) {
            ArrayList<TimeEntry> newHistory = new ArrayList<>();
            histories.put(key, newHistory);
        }

        ArrayList<TimeEntry> history = histories.get(key);

        TimeEntry entry = new TimeEntry(timestamp, value);
        history.add(entry);
    }

    public String get(String key, int timestamp) {
        if (!histories.containsKey(key)) {
            return "";
        }

        ArrayList<TimeEntry> history = histories.get(key);

        int l = 0;
        int r = history.size() - 1;
        String answer = "";

        while (l <= r) {
            int mid = l + (r - l) / 2;

            TimeEntry entry = history.get(mid);

            if (entry.timestamp <= timestamp) {
                // This entry qualifies. Search for a later qualifying entry.
                answer = entry.value;
                l = mid + 1;
            } else {
                // This entry is too late. Search earlier timestamps.
                r = mid - 1;
            }
        }

        return answer;
    }
}