package net.csdn.api.impl;

import net.csdn.api.DBDumpService;
import net.csdn.api.document.CDB;
import net.csdn.api.document.CTask;
import net.csdn.document.DB;
import net.csdn.modules.thrift.ThriftApplication;
import net.csdn.service.dump.DBDumper;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.thrift.TException;

import java.lang.reflect.InvocationTargetException;

/**
 * 6/5/13 WilliamZhu(allwefantasy@gmail.com)
 */
public class DBDumpServiceImpl extends ThriftApplication implements DBDumpService.Iface {
    private DBDumper dbDumper = service(DBDumper.class);

    @Override
    public void dump(CTask task) throws TException {
        CDB cdb = task.getDbs().get(0);
        DB db = new DB();
        try {
            BeanUtils.copyProperties(db, cdb);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        dbDumper.dump(db);
    }
}
