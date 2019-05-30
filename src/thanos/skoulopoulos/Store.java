package thanos.skoulopoulos;

public class Store {

    private int id;
    private String storeName;
    private String storeAddress;
    private String storeWebSite;

    public Store(int id, String storeName, String storeAddress, String storeWebSite) {
        this.id = id;
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.storeWebSite = storeWebSite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStoreWebSite() {
        return storeWebSite;
    }

    public void setStoreWebSite(String storeWebSite) {
        this.storeWebSite = storeWebSite;
    }

    @Override
    public String toString() {
        return "{Store:" + id + ("Name: ") + storeName + " Address: " + storeAddress;
    }
}
