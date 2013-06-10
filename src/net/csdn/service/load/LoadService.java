package net.csdn.service.load;

import net.csdn.annotation.Service;

import java.util.List;
import java.util.Map;

/**
 * 6/3/13 WilliamZhu(allwefantasy@gmail.com)
 */
@Service(implementedBy = LoadServiceImpl.class)
public interface LoadService {
    public void load(String prefix, List<Map> items);
    public void loadAsString(String prefix, String items);
}
