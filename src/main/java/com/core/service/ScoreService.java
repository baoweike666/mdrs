package com.core.service;

import com.core.po.Score;

import java.util.List;

public interface ScoreService {
    public List<Score> selectAll();
    public Integer selectValue(Integer score_user_id, Integer score_movie_id);
    public List<Score> refreshCSV();
}
