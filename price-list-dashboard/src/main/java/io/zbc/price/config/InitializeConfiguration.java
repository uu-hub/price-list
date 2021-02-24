package io.zbc.price.config;

import io.zbc.price.dao.IGoodsInfoDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

@Configuration
public class InitializeConfiguration implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOG = LoggerFactory.getLogger(InitializeConfiguration.class);

    @Autowired
    private IGoodsInfoDao goodsInfoDao;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        createTables();
    }

    private void createTables() {
        goodsInfoDao.createGoodsInfoTable();
    }

}
