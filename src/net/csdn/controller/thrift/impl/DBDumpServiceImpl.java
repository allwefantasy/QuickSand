package net.csdn.controller.thrift.impl;

import net.csdn.controller.thrift.DBDumpService;
import net.csdn.controller.thrift.document.CTask;
import net.csdn.document.DB;
import net.csdn.document.Task;
import net.csdn.modules.thrift.ThriftApplication;
import net.csdn.modules.thrift.util.PojoCopy;
import net.csdn.service.dump.DBDumper;
import org.apache.thrift.TException;

/**
 * 6/5/13 WilliamZhu(allwefantasy@gmail.com)
 */
public class DBDumpServiceImpl extends ThriftApplication implements DBDumpService.Iface {
    private DBDumper dbDumper = service(DBDumper.class);

    @Override
    public void dump(CTask task) throws TException {
        Task localTask = new Task();
        PojoCopy.copyProperties(task, localTask);
        DB db = localTask.dbs().findOne();
        dbDumper.dump(db);
    }
}
