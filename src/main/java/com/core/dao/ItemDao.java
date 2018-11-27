package com.core.dao;

import com.core.po.Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemDao {
   public List<Item> readItem(Integer item_user_id);
   public int writeItem(@Param(value = "item_user_id") Integer item_user_id,@Param(value = "item_movie_id") Integer item_movie_id);
   public int deleteItem();
}
