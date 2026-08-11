class BrowserHistory {

    class Node {
        String data;
        Node forward;
        Node back;

        Node(String d) {
            data = d;
            forward = null;
            back = null;
        }
    }

    Node current;

    public BrowserHistory(String homepage) {
        current = new Node(homepage);
    }

    public void visit(String url) {
        Node newNode = new Node(url);
        current.forward = newNode;
        newNode.back = current;
        current = newNode;
    }

    public String back(int steps) {
        while (steps-- > 0 && current.back != null) {
            current = current.back;
        }
        return current.data;
    }

    public String forward(int steps) {
        while (steps-- > 0 && current.forward != null) {
            current = current.forward;
        }
        return current.data;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */