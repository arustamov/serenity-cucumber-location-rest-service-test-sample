package arustamov.ws;

public enum EndPoint {

    GET_ALL_LOCATIONS("/location/get/all"),
    GET_LOCATION("/location/get/{code}"),
    POST_LOCATION("/location/post");

    private final String url;

    EndPoint(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
