package net.csdn.service.dump;

import net.csdn.annotation.Service;
import net.csdn.document.DB;

import java.sql.SQLException;

/**
 * 5/30/13 WilliamZhu(allwefantasy@gmail.com)
 */
@Service(implementedBy = DumpServiceImpl.class)
public interface DumpService {
    public void dump(DB db) throws SQLException;
}
