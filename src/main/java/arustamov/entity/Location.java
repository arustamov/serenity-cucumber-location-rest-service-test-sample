package arustamov.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Location {

    private String id;
    private String cost;
    private String code;

    public Location(String id, String cost, String code) {
        this.id = id;
        this.cost = cost;
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public String getCost() {
        return cost;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
