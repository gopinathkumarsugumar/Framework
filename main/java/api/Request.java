package api;

import java.util.HashMap;
import java.util.Map;

public class Request {

    private String endpoint;
    private String method;
    private Object body;

    private Map<String, Object> pathParams = new HashMap<>();
    private Map<String, Object> queryParams = new HashMap<>();
    private Map<String, Object> headers = new HashMap<>();

    public Request(String endpoint, String method) {
        this.endpoint = endpoint;
        this.method = method;
    }

    public Request pathParam(String name, Object value) {
        if (value != null) {
            pathParams.put(name, value);
        }
        return this;
    }

    public Request queryParam(String name, Object value) {
        if (value != null) {
            queryParams.put(name, value);
        }
        return this;
    }

    public Request header(String name, Object value) {
        if (value != null) {
            headers.put(name, value);
        }
        return this;
    }

    public Request body(Object body) {
        if (body != null) {
            this.body = body;
        }
        return this;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public String getMethod() {
        return method;
    }

    public Object getBody() {
        return body;
    }

    public Map<String, Object> getPathParams() {
        return pathParams;
    }

    public Map<String, Object> getQueryParams() {
        return queryParams;
    }

    public Map<String, Object> getHeaders() {
        return headers;
    }
}


