package com.yangs.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Ytadpole on 2018/2/14.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ContentVoDaoTest {
    @Autowired
    private ContentVoDao contentVoDao;

    @Test
    public void selectContent() throws Exception {
        List<ContentVo> list = contentVoDao.selectContent();
        assertEquals(5, list.size());
    }

}