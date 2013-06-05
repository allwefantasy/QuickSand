package net.csdn.service.dump;

import net.csdn.annotation.Service;
import net.csdn.document.DB;

/**
 * 5/30/13 WilliamZhu(allwefantasy@gmail.com)
 */
@Service(implementedBy = DBDumperImpl.class)
public interface DBDumper {
    public void dump(DB db);
}
