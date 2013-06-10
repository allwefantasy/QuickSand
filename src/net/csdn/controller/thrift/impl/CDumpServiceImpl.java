package net.csdn.controller.thrift.impl;

import net.csdn.controller.thrift.CDBException;
import net.csdn.controller.thrift.CDumpService;
import net.csdn.controller.thrift.CTask;
import net.csdn.document.DB;
import net.csdn.document.Task;
import net.csdn.modules.thrift.ThriftApplication;
import net.csdn.modules.thrift.util.PojoCopy;
import net.csdn.service.dump.DumpService;

import java.sql.SQLException;

/**
 * 6/5/13 WilliamZhu(allwefantasy@gmail.com)
 */
public class CDumpServiceImpl extends ThriftApplication implements CDumpService.Iface {
    private DumpService dbDumper = service(DumpService.class);

    @Override
    public void dump(CTask task) throws CDBException {
        DB db = PojoCopy.build(task, Task.class).dbs().findOne();
        try {
            dbDumper.dump(db);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CDBException(e.getMessage());
        }
    }
}
