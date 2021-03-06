package me.aikin.bicyclestore.bicycle.security.principal;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleGrantedAuthorityDeserializer extends JsonDeserializer<Collection<SimpleGrantedAuthority>> {
    @Override
    public Collection<SimpleGrantedAuthority> deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);
        Iterator<JsonNode> elements = node.elements();
        return Stream.of(elements)
            .map(element -> {
                JsonNode next = elements.next();
                JsonNode authority = next.get("authority");
                return new SimpleGrantedAuthority(authority.asText());
            })
            .collect(Collectors.toList());
    }
}
