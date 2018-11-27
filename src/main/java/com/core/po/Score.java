package com.core.po;

import java.io.Serializable;

public class Score implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer score_id;
    private Integer score_user_id;
    private Integer score_movie_id;
    private Integer score_value;

//    public Score() {
//    }
//
//    public Score(Integer score_id, Integer score_user_id, Integer score_movie_id, Integer score_value) {
//        this.score_id = score_id;
//        this.score_user_id = score_user_id;
//        this.score_movie_id = score_movie_id;
//        this.score_value = score_value;
//    }

    public Integer getScore_id() {
        return score_id;
    }

    public void setScore_id(Integer score_id) {
        this.score_id = score_id;
    }

    public Integer getScore_user_id() {
        return score_user_id;
    }

    public void setScore_user_id(Integer score_user_id) {
        this.score_user_id = score_user_id;
    }

    public Integer getScore_movie_id() {
        return score_movie_id;
    }

    public void setScore_movie_id(Integer score_movie_id) {
        this.score_movie_id = score_movie_id;
    }

    public Integer getScore_value() {
        return score_value;
    }

    public void setScore_value(Integer score_value) {
        this.score_value = score_value;
    }
    
    public String toString(){
        return(score_user_id.toString()+","+score_movie_id.toString()+","+score_value.toString());
    }
}
