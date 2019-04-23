package com.example.dao;

import com.example.model.Text;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author :
 * create : 2019-04-21 10:51
 * description
 */
@Component
public interface TextDao {
    Text findTextById(int id);
}
