package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    Map<String, String> map = new HashMap<String, String>();

    public EnvController(@Value("${port:NOT SET}") String port, @Value("${memory.limit:NOT SET}") String mem, @Value("${cf.instance.index:NOT SET}") String ind, @Value("${cf.instance.addr:NOT SET}") String add){
        map.put("PORT",port);
        map.put("MEMORY_LIMIT",mem);
        map.put("CF_INSTANCE_INDEX",ind);
        map.put("CF_INSTANCE_ADDR",add);
    }


    @GetMapping("/env")
    public Map<String, String> getEnv(){
            return map;
    }
}
