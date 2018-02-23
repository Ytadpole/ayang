package com.yangs.modal.vo;

public class RelationshipVoKey {
    private Integer cid;

    private Integer mid;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    @Override
    public String toString() {
        return "RelationshipVoKey{" +
                "cid=" + cid +
                ", mid=" + mid +
                '}';
    }
}