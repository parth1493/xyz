public class Chain {

    private String storeName;
    private long entries;

    public Chain(String storeName, long entries) {
        this.storeName = storeName;
        this.entries = entries;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public long getEntries() {
        return entries;
    }

    public void setEntries(int entries) {
        this.entries = entries;
    }
}
