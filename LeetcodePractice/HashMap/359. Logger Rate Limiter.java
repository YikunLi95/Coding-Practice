class Logger {

    private Map<String, Integer> msgMap;
    public Logger() {
        msgMap = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!this.msgMap.containsKey(message)) {
            this.msgMap.put(message, timestamp);
            return true;
        }
        Integer oldTime = msgMap.get(message);
        if (timestamp - oldTime >= 10) {
            this.msgMap.put(message, timestamp);
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
// TC: O(1)
// SC: O(M) -> M represents for the size of all incoming messages
