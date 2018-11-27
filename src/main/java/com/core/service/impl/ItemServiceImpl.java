package com.core.service.impl;

import com.core.UserCF;
import com.core.dao.ItemDao;
import com.core.po.Item;
import com.core.service.ItemService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("itemService")
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;

    @Override
    public List<Item> readItem(Integer item_user_id){
        return itemDao.readItem(item_user_id);
    }
    @Test
    @Override
    public void writeItem(){

        try{

            itemDao.deleteItem();
            List<Item> itemlist= UserCF.cf();
            //System.out.println((itemlist == null));

            for (Item item: itemlist) {
                int item_user_id=item.getItem_user_id();
                int item_movie_id=item.getItem_movie_id();
                System.out.println(item.getItem_user_id()+" be recommended of "+item.getItem_movie_id());
                itemDao.writeItem(item_user_id,item_movie_id);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
