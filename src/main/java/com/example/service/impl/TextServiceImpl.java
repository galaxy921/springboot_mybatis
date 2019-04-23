package com.example.service.impl;

import com.example.dao.TextDao;
import com.example.model.Text;
import com.example.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 吴亚斌
 * create : 2019-04-21 11:36
 * description
 */
@Service
public class TextServiceImpl implements TextService

{
    @Autowired
    TextDao dao;
    @Override
    public Text findTextById(int id) {
        return dao.findTextById(id);
    }
}
