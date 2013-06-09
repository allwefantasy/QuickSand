package net.csdn.controller.thrift.impl;

import net.csdn.controller.thrift.DBDumpService;
import net.csdn.controller.thrift.DBException;
import net.csdn.controller.thrift.CTask;
import net.csdn.document.DB;
import net.csdn.document.Task;
import net.csdn.modules.thrift.ThriftApplication;
import net.csdn.modules.thrift.util.PojoCopy;
import net.csdn.service.dump.DBDumper;

import java.sql.SQLException;

/**
 * 6/5/13 WilliamZhu(allwefantasy@gmail.com)
 */
public class DBDumpServiceImpl extends ThriftApplication implements DBDumpService.Iface {
    private DBDumper dbDumper = service(DBDumper.class);

    @Override
    public void dump(CTask task) throws DBException {
        DB db = PojoCopy.build(task, Task.class).dbs().findOne();
        try {
            dbDumper.dump(db);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException(e.getMessage());
        }
    }
}
