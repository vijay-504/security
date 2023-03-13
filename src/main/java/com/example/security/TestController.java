package com.example.security;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TestController {
    private static final String URL_DEBUG_LABELS_MVC = "/service/debug/labels.mvc";
    private static final String KEY_ENABLED = "enabled";
    private static final String KEY_SUCCESS = "success";



    @RequestMapping(
        value = URL_DEBUG_LABELS_MVC,
        produces = MediaType.APPLICATION_JSON_VALUE,
        params = KEY_ENABLED)
    public @ResponseBody ResponseEntity<Map<String, Object>> setDebuggingStatus(
        @RequestParam("enabled") Boolean enabled) {
      Map<String, Object> result = createResponse(enabled);
      return new ResponseEntity<>(result, HttpStatus.OK);
    }


    private Map<String, Object> createResponse(Boolean enabled) {
      Map<String,Object> hashMap=new HashMap<>();
      hashMap.put(KEY_SUCCESS,Boolean.TRUE);
      hashMap.put(KEY_ENABLED,enabled);
      return hashMap;
  }


}
