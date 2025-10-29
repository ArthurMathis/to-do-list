package diaconat_mulhouse.fr.backend.core.converters.map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MapConverterImpl implements MapConverter {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String fromDto(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        try {
            return objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to convert Map to JSON", e);
        }
    }

    @Override
    public Map<String, String> toDto(String json) {
        if (json == null || json.isEmpty()) {
            return new HashMap<>();
        }

        try {
            return objectMapper.readValue(json, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException("Failed to convert JSON to Map", e);
        }
    }
}
