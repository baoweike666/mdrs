package com.core.service.impl;

import com.core.dao.ScoreDao;
import com.core.po.Score;
import com.core.service.ScoreService;
import com.csvreader.CsvWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csvreader.CsvReader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service("scoreService")
@Transactional
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreDao scoreDao;
    @Override
    public List<Score> selectAll(){
        return scoreDao.selectAll();
    }
    @Override
    public Integer selectValue(Integer score_user_id, Integer score_movie_id){
        return scoreDao.selectValue(score_user_id,score_movie_id);
    }
    @Override
    public List<Score> refreshCSV(){
        List<Score> list=scoreDao.selectAll();
        List<String[]> slist=new ArrayList<>();
        for (Score lt:list) {
            String []tmp={lt.getScore_user_id().toString(),lt.getScore_movie_id().toString(),lt.getScore_value().toString()};
            slist.add(tmp);
        }
        TestCSV.exportCsv(slist,"/Users/omega/Desktop/to.csv");

        List<String[]> inlist=TestCSV.importCsv("/Users/omega/Desktop/to.csv");
        List<Score> outlist=new ArrayList<>();
        for (String [] lt:inlist) {
            Score score=new Score();
            score.setScore_user_id(Integer.valueOf(lt[0]));
            score.setScore_user_id(Integer.valueOf(lt[1]));
            score.setScore_user_id(Integer.valueOf(lt[2]));
            outlist.add(score);
        }
        return outlist;

    }
}


class TestCSV {
    //String srcCSV = "/Users/omega/Desktop/cnt_programa.csv";
    //String targetFile = "/Users/omega/Desktop/test.csv";

    String srcCSV = "/Users/omega/Desktop/from.csv";
    String targetFile = "/Users/omega/Desktop/to.csv";
    //List<String[]> list=importCsv(srcCSV);
    //exportCsv(list,targetFile);


    public static List<String[]> importCsv(String filePath)  {
        CsvReader reader = null;
        List<String[]> dataList = new ArrayList<String[]>();
        try {
            reader = new CsvReader(filePath, ',', Charset.forName("GBK"));

            // 读取表头  加上这一句是不算表头数据从第二行开始取
            reader.readHeaders();
            // 逐条读取记录，直至读完
            while (reader.readRecord()) {
                dataList.add(reader.getRawRecord().split(","));
                // // 下面是几个常用的方法
                // 读取一条记录
                System.out.println(reader.getRawRecord());
                // 按列名读取这条记录的值
                System.out.println(reader.get(0));
                System.out.println(reader.get(1));
                System.out.println(reader.get(2));
                System.out.println(reader.get(3));
            }
        } catch (Exception e) {
            System.out.println("读取CSV出错..." + e);
        } finally {
            if (null != reader) {
                reader.close();
            }
        }

        return dataList;
    }


    public static boolean exportCsv(List<String[]> dataList, String filePath)  {
        boolean isSuccess = false;
        CsvWriter writer = null;
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filePath);
            writer = new CsvWriter(out, ',', Charset.forName("GBK"));
            //Iterator<Score> iter=dataList.iterator();
            for (String[] strs : dataList) {
                writer.writeRecord(strs);
            }

            isSuccess = true;
        } catch (Exception e) {
            System.out.println("生成CSV出错..." + e);

        } finally {
            if (null != writer) {
                writer.close();
            }
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    System.out.println("exportCsv close Exception: " + e);

                }
            }
        }


        return isSuccess;
    }
}

