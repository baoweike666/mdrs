package com.core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.core.po.Item;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.junit.Test;


public class UserCF {

    final static int NEIGHBORHOOD_NUM = 2;
    final static int RECOMMENDER_NUM = 3;

    public static List<Item> cf() throws IOException, TasteException {

        String file = "/Users/omega/Desktop/to.csv";
        DataModel model = new FileDataModel(new File(file));
        UserSimilarity user = new EuclideanDistanceSimilarity(model);
        NearestNUserNeighborhood neighbor = new NearestNUserNeighborhood(NEIGHBORHOOD_NUM, user, model);
        Recommender r = new GenericUserBasedRecommender(model, neighbor, user);
        LongPrimitiveIterator iter = model.getUserIDs();

        List<Item> ilist=new ArrayList<>();

        while (iter.hasNext()) {
            long uid = iter.nextLong();
            int user_id=(int)uid;

            List<RecommendedItem> list1 = r.recommend(uid, RECOMMENDER_NUM);
            for (RecommendedItem ritem : list1) {

                int movie_id=(int)ritem.getItemID();

                Item item=new Item();
                System.out.println(user_id+" "+movie_id);
                item.setItem_user_id(user_id);
                item.setItem_movie_id(movie_id);
                ilist.add(item);
            }
        }
        return ilist;
    }

}
