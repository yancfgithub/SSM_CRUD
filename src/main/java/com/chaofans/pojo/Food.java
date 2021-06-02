package com.chaofans.pojo;

import java.io.Serializable;

public class Food implements Serializable {
    private Integer fid;
    private String fname;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Override
    public String toString() {
        return "Food{" +
                "fid=" + fid +
                ", fname='" + fname + '\'' +
                '}';
    }
}
