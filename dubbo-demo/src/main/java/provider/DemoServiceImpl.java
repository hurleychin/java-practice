package provider;

import api.DemoService;

/**
 * @author qinhu
 * @date 2018/6/21
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
