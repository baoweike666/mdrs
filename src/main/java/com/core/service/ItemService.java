package com.core.service;

import com.core.dao.ItemDao;
import com.core.po.Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemService {
    public List<Item> readItem(Integer item_user_id);
    public void writeItem();
}
