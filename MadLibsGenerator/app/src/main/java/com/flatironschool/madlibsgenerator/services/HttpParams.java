package com.flatironschool.madlibsgenerator.services;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by altyus on 9/19/14.
 */
public class HttpParams extends HashMap<String, List<String>> {
    private static final long serialVersionUID = 1L;

    public HttpParams() {
        super();
    }

    public HttpParams(int capacity){
        super(capacity);
    }

    public HttpParams(int capacity, float loadFactor){
        super(capacity, loadFactor);
    }

    public void add(String key, String value) {
        if (containsKey(key)){
            get(key).add(value);
        }
        else {
            List<String> list = new ArrayList<String>();
            list.add(value);
            put(key, list);
        }
    }

    public byte[] encodeParameters(String paramsEncoding) {
        StringBuilder encodedParams = new StringBuilder();
        try {
            for (Map.Entry<String, List<String>> entry : entrySet()) {
                String key = URLEncoder.encode(entry.getKey(), paramsEncoding);
                for (String value : entry.getValue()) {
                    encodedParams.append(key);
                    encodedParams.append('=');
                    encodedParams.append(URLEncoder.encode(value, paramsEncoding));
                    encodedParams.append('&');
                }
            }
            return encodedParams.toString().getBytes(paramsEncoding);
        } catch (UnsupportedEncodingException uee) {
            throw new RuntimeException("Encoding not supported: " + paramsEncoding,     uee);
        }
    }
}
