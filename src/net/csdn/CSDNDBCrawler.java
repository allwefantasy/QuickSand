package net.csdn;

import net.csdn.bootstrap.Application;

/**
 * 6/3/13 WilliamZhu(allwefantasy@gmail.com)
 */
public class CSDNDBCrawler {
    public static void main(String[] args) {
        ServiceFramwork.scanService.setLoader(CSDNDBCrawler.class);
        Application.main(args);
    }
}
