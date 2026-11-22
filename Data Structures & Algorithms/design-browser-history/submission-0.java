class Node {
    String url;
    Node next;
    Node prev;

    Node(String website){
        url = website;
    }
}

class BrowserHistory {

    private Node current;

    public BrowserHistory(String homepage) {
        current = new Node (homepage);

    }
    
    public void visit(String url) {
        Node newPage = new Node(url);
        current.next = newPage;
        newPage.prev = current;
        current = newPage;
    }
    
    public String back(int steps) {
        for (int i = 0; i < steps; i++){
            if (current.prev != null){
                current = current.prev;
            } else {
                break;
            }
        }
        return current.url;
    }
    
    public String forward(int steps) {
        for (int i = 0; i < steps; i++){
            if (current.next != null){
                current = current.next;
            } else {
                break;
            }
        }
        return current.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */