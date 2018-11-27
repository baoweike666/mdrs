package com.core.dao;
import java.util.List;
import com.core.po.Score;
import org.apache.ibatis.annotations.Param;

public interface ScoreDao {
    public List<Score> selectAll();
    public Integer selectValue(@Param("score_user_id") Integer score_user_id, @Param("score_movie_id") Integer score_movie_id);
}
