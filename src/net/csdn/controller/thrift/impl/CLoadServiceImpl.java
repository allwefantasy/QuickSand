package net.csdn.controller.thrift.impl;

import net.csdn.controller.thrift.CLoadService;
import net.csdn.modules.thrift.ThriftApplication;
import net.csdn.service.load.LoadService;
import org.apache.thrift.TException;

/**
 * 6/4/13 WilliamZhu(allwefantasy@gmail.com)
 */
public class CLoadServiceImpl extends ThriftApplication implements CLoadService.Iface {

    private LoadService dataLoader = service(LoadService.class);

    @Override
    public void load(String prefix, String objectList) throws TException {
        dataLoader.loadAsString(prefix, objectList);
    }
}
