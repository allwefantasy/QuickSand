package net.csdn.service.dump;

import net.csdn.annotation.Service;
import net.csdn.document.DB;

/**
 * 5/30/13 WilliamZhu(allwefantasy@gmail.com)
 */
@Service(implementedBy = DBCrawlerImpl.class)
public interface DBCrawler {
    public void query(DB db);
}
