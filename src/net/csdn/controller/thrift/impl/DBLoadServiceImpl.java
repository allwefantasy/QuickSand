package net.csdn.controller.thrift.impl;

import net.csdn.controller.thrift.DBLoadService;
import net.csdn.modules.thrift.ThriftApplication;
import net.csdn.service.load.DataLoader;
import org.apache.thrift.TException;

/**
 * 6/4/13 WilliamZhu(allwefantasy@gmail.com)
 */
public class DBLoadServiceImpl extends ThriftApplication implements DBLoadService.Iface {

    private DataLoader dataLoader = service(DataLoader.class);

    @Override
    public void load(String prefix, String objectList) throws TException {
        dataLoader.loadAsString(prefix, objectList);
    }
}
