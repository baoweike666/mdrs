package com.core.web.controller;

import com.core.dao.ScoreDao;
import com.core.po.Item;
import com.core.po.Score;
import com.core.service.ItemService;
import com.core.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RecommendController {
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/recommend/display.action")
    public String displayScore(Model model){
        List<Score> list=scoreService.selectAll();
        model.addAttribute("scorelist",list);
        return "recommend";
    }
    @RequestMapping (value = "/recommend/refresh.action")
    public String refresh(int user_id,Model model){


        List<Score> list=scoreService.selectAll();
        model.addAttribute("scorelist",list);

        scoreService.refreshCSV();
        itemService.writeItem();

        List<Item> ilist=  itemService.readItem(user_id);
        List<Integer> rlist=new ArrayList<>();
         for (Item item:ilist) {
           //model.addAttribute("result",item.getItem_movie_id());
             rlist.add(item.getItem_movie_id());
        }
        model.addAttribute("result",rlist);

        return "recommend";
    }
}
