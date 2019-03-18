package com.petsfamily.yunximao.momentsService.mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PetMomentsInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    /**
     *
     */
    public PetMomentsInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @param orderByClause
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @param distinct
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @param criteria
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSeqIdIsNull() {
            addCriterion("seq_id is null");
            return (Criteria) this;
        }

        public Criteria andSeqIdIsNotNull() {
            addCriterion("seq_id is not null");
            return (Criteria) this;
        }

        public Criteria andSeqIdEqualTo(Integer value) {
            addCriterion("seq_id =", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdNotEqualTo(Integer value) {
            addCriterion("seq_id <>", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdGreaterThan(Integer value) {
            addCriterion("seq_id >", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("seq_id >=", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdLessThan(Integer value) {
            addCriterion("seq_id <", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdLessThanOrEqualTo(Integer value) {
            addCriterion("seq_id <=", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdIn(List<Integer> values) {
            addCriterion("seq_id in", values, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdNotIn(List<Integer> values) {
            addCriterion("seq_id not in", values, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdBetween(Integer value1, Integer value2) {
            addCriterion("seq_id between", value1, value2, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdNotBetween(Integer value1, Integer value2) {
            addCriterion("seq_id not between", value1, value2, "seqId");
            return (Criteria) this;
        }

        public Criteria andUserNumberIsNull() {
            addCriterion("user_number is null");
            return (Criteria) this;
        }

        public Criteria andUserNumberIsNotNull() {
            addCriterion("user_number is not null");
            return (Criteria) this;
        }

        public Criteria andUserNumberEqualTo(String value) {
            addCriterion("user_number =", value, "userNumber");
            return (Criteria) this;
        }

        public Criteria andUserNumberNotEqualTo(String value) {
            addCriterion("user_number <>", value, "userNumber");
            return (Criteria) this;
        }

        public Criteria andUserNumberGreaterThan(String value) {
            addCriterion("user_number >", value, "userNumber");
            return (Criteria) this;
        }

        public Criteria andUserNumberGreaterThanOrEqualTo(String value) {
            addCriterion("user_number >=", value, "userNumber");
            return (Criteria) this;
        }

        public Criteria andUserNumberLessThan(String value) {
            addCriterion("user_number <", value, "userNumber");
            return (Criteria) this;
        }

        public Criteria andUserNumberLessThanOrEqualTo(String value) {
            addCriterion("user_number <=", value, "userNumber");
            return (Criteria) this;
        }

        public Criteria andUserNumberLike(String value) {
            addCriterion("user_number like", value, "userNumber");
            return (Criteria) this;
        }

        public Criteria andUserNumberNotLike(String value) {
            addCriterion("user_number not like", value, "userNumber");
            return (Criteria) this;
        }

        public Criteria andUserNumberIn(List<String> values) {
            addCriterion("user_number in", values, "userNumber");
            return (Criteria) this;
        }

        public Criteria andUserNumberNotIn(List<String> values) {
            addCriterion("user_number not in", values, "userNumber");
            return (Criteria) this;
        }

        public Criteria andUserNumberBetween(String value1, String value2) {
            addCriterion("user_number between", value1, value2, "userNumber");
            return (Criteria) this;
        }

        public Criteria andUserNumberNotBetween(String value1, String value2) {
            addCriterion("user_number not between", value1, value2, "userNumber");
            return (Criteria) this;
        }

        public Criteria andPetNumberIsNull() {
            addCriterion("pet_number is null");
            return (Criteria) this;
        }

        public Criteria andPetNumberIsNotNull() {
            addCriterion("pet_number is not null");
            return (Criteria) this;
        }

        public Criteria andPetNumberEqualTo(String value) {
            addCriterion("pet_number =", value, "petNumber");
            return (Criteria) this;
        }

        public Criteria andPetNumberNotEqualTo(String value) {
            addCriterion("pet_number <>", value, "petNumber");
            return (Criteria) this;
        }

        public Criteria andPetNumberGreaterThan(String value) {
            addCriterion("pet_number >", value, "petNumber");
            return (Criteria) this;
        }

        public Criteria andPetNumberGreaterThanOrEqualTo(String value) {
            addCriterion("pet_number >=", value, "petNumber");
            return (Criteria) this;
        }

        public Criteria andPetNumberLessThan(String value) {
            addCriterion("pet_number <", value, "petNumber");
            return (Criteria) this;
        }

        public Criteria andPetNumberLessThanOrEqualTo(String value) {
            addCriterion("pet_number <=", value, "petNumber");
            return (Criteria) this;
        }

        public Criteria andPetNumberLike(String value) {
            addCriterion("pet_number like", value, "petNumber");
            return (Criteria) this;
        }

        public Criteria andPetNumberNotLike(String value) {
            addCriterion("pet_number not like", value, "petNumber");
            return (Criteria) this;
        }

        public Criteria andPetNumberIn(List<String> values) {
            addCriterion("pet_number in", values, "petNumber");
            return (Criteria) this;
        }

        public Criteria andPetNumberNotIn(List<String> values) {
            addCriterion("pet_number not in", values, "petNumber");
            return (Criteria) this;
        }

        public Criteria andPetNumberBetween(String value1, String value2) {
            addCriterion("pet_number between", value1, value2, "petNumber");
            return (Criteria) this;
        }

        public Criteria andPetNumberNotBetween(String value1, String value2) {
            addCriterion("pet_number not between", value1, value2, "petNumber");
            return (Criteria) this;
        }

        public Criteria andMomentNumberIsNull() {
            addCriterion("moment_number is null");
            return (Criteria) this;
        }

        public Criteria andMomentNumberIsNotNull() {
            addCriterion("moment_number is not null");
            return (Criteria) this;
        }

        public Criteria andMomentNumberEqualTo(String value) {
            addCriterion("moment_number =", value, "momentNumber");
            return (Criteria) this;
        }

        public Criteria andMomentNumberNotEqualTo(String value) {
            addCriterion("moment_number <>", value, "momentNumber");
            return (Criteria) this;
        }

        public Criteria andMomentNumberGreaterThan(String value) {
            addCriterion("moment_number >", value, "momentNumber");
            return (Criteria) this;
        }

        public Criteria andMomentNumberGreaterThanOrEqualTo(String value) {
            addCriterion("moment_number >=", value, "momentNumber");
            return (Criteria) this;
        }

        public Criteria andMomentNumberLessThan(String value) {
            addCriterion("moment_number <", value, "momentNumber");
            return (Criteria) this;
        }

        public Criteria andMomentNumberLessThanOrEqualTo(String value) {
            addCriterion("moment_number <=", value, "momentNumber");
            return (Criteria) this;
        }

        public Criteria andMomentNumberLike(String value) {
            addCriterion("moment_number like", value, "momentNumber");
            return (Criteria) this;
        }

        public Criteria andMomentNumberNotLike(String value) {
            addCriterion("moment_number not like", value, "momentNumber");
            return (Criteria) this;
        }

        public Criteria andMomentNumberIn(List<String> values) {
            addCriterion("moment_number in", values, "momentNumber");
            return (Criteria) this;
        }

        public Criteria andMomentNumberNotIn(List<String> values) {
            addCriterion("moment_number not in", values, "momentNumber");
            return (Criteria) this;
        }

        public Criteria andMomentNumberBetween(String value1, String value2) {
            addCriterion("moment_number between", value1, value2, "momentNumber");
            return (Criteria) this;
        }

        public Criteria andMomentNumberNotBetween(String value1, String value2) {
            addCriterion("moment_number not between", value1, value2, "momentNumber");
            return (Criteria) this;
        }

        public Criteria andMomentTypeIsNull() {
            addCriterion("moment_type is null");
            return (Criteria) this;
        }

        public Criteria andMomentTypeIsNotNull() {
            addCriterion("moment_type is not null");
            return (Criteria) this;
        }

        public Criteria andMomentTypeEqualTo(Integer value) {
            addCriterion("moment_type =", value, "momentType");
            return (Criteria) this;
        }

        public Criteria andMomentTypeNotEqualTo(Integer value) {
            addCriterion("moment_type <>", value, "momentType");
            return (Criteria) this;
        }

        public Criteria andMomentTypeGreaterThan(Integer value) {
            addCriterion("moment_type >", value, "momentType");
            return (Criteria) this;
        }

        public Criteria andMomentTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("moment_type >=", value, "momentType");
            return (Criteria) this;
        }

        public Criteria andMomentTypeLessThan(Integer value) {
            addCriterion("moment_type <", value, "momentType");
            return (Criteria) this;
        }

        public Criteria andMomentTypeLessThanOrEqualTo(Integer value) {
            addCriterion("moment_type <=", value, "momentType");
            return (Criteria) this;
        }

        public Criteria andMomentTypeIn(List<Integer> values) {
            addCriterion("moment_type in", values, "momentType");
            return (Criteria) this;
        }

        public Criteria andMomentTypeNotIn(List<Integer> values) {
            addCriterion("moment_type not in", values, "momentType");
            return (Criteria) this;
        }

        public Criteria andMomentTypeBetween(Integer value1, Integer value2) {
            addCriterion("moment_type between", value1, value2, "momentType");
            return (Criteria) this;
        }

        public Criteria andMomentTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("moment_type not between", value1, value2, "momentType");
            return (Criteria) this;
        }

        public Criteria andMomentTitleIsNull() {
            addCriterion("moment_title is null");
            return (Criteria) this;
        }

        public Criteria andMomentTitleIsNotNull() {
            addCriterion("moment_title is not null");
            return (Criteria) this;
        }

        public Criteria andMomentTitleEqualTo(String value) {
            addCriterion("moment_title =", value, "momentTitle");
            return (Criteria) this;
        }

        public Criteria andMomentTitleNotEqualTo(String value) {
            addCriterion("moment_title <>", value, "momentTitle");
            return (Criteria) this;
        }

        public Criteria andMomentTitleGreaterThan(String value) {
            addCriterion("moment_title >", value, "momentTitle");
            return (Criteria) this;
        }

        public Criteria andMomentTitleGreaterThanOrEqualTo(String value) {
            addCriterion("moment_title >=", value, "momentTitle");
            return (Criteria) this;
        }

        public Criteria andMomentTitleLessThan(String value) {
            addCriterion("moment_title <", value, "momentTitle");
            return (Criteria) this;
        }

        public Criteria andMomentTitleLessThanOrEqualTo(String value) {
            addCriterion("moment_title <=", value, "momentTitle");
            return (Criteria) this;
        }

        public Criteria andMomentTitleLike(String value) {
            addCriterion("moment_title like", value, "momentTitle");
            return (Criteria) this;
        }

        public Criteria andMomentTitleNotLike(String value) {
            addCriterion("moment_title not like", value, "momentTitle");
            return (Criteria) this;
        }

        public Criteria andMomentTitleIn(List<String> values) {
            addCriterion("moment_title in", values, "momentTitle");
            return (Criteria) this;
        }

        public Criteria andMomentTitleNotIn(List<String> values) {
            addCriterion("moment_title not in", values, "momentTitle");
            return (Criteria) this;
        }

        public Criteria andMomentTitleBetween(String value1, String value2) {
            addCriterion("moment_title between", value1, value2, "momentTitle");
            return (Criteria) this;
        }

        public Criteria andMomentTitleNotBetween(String value1, String value2) {
            addCriterion("moment_title not between", value1, value2, "momentTitle");
            return (Criteria) this;
        }

        public Criteria andMomentContentIsNull() {
            addCriterion("moment_content is null");
            return (Criteria) this;
        }

        public Criteria andMomentContentIsNotNull() {
            addCriterion("moment_content is not null");
            return (Criteria) this;
        }

        public Criteria andMomentContentEqualTo(String value) {
            addCriterion("moment_content =", value, "momentContent");
            return (Criteria) this;
        }

        public Criteria andMomentContentNotEqualTo(String value) {
            addCriterion("moment_content <>", value, "momentContent");
            return (Criteria) this;
        }

        public Criteria andMomentContentGreaterThan(String value) {
            addCriterion("moment_content >", value, "momentContent");
            return (Criteria) this;
        }

        public Criteria andMomentContentGreaterThanOrEqualTo(String value) {
            addCriterion("moment_content >=", value, "momentContent");
            return (Criteria) this;
        }

        public Criteria andMomentContentLessThan(String value) {
            addCriterion("moment_content <", value, "momentContent");
            return (Criteria) this;
        }

        public Criteria andMomentContentLessThanOrEqualTo(String value) {
            addCriterion("moment_content <=", value, "momentContent");
            return (Criteria) this;
        }

        public Criteria andMomentContentLike(String value) {
            addCriterion("moment_content like", value, "momentContent");
            return (Criteria) this;
        }

        public Criteria andMomentContentNotLike(String value) {
            addCriterion("moment_content not like", value, "momentContent");
            return (Criteria) this;
        }

        public Criteria andMomentContentIn(List<String> values) {
            addCriterion("moment_content in", values, "momentContent");
            return (Criteria) this;
        }

        public Criteria andMomentContentNotIn(List<String> values) {
            addCriterion("moment_content not in", values, "momentContent");
            return (Criteria) this;
        }

        public Criteria andMomentContentBetween(String value1, String value2) {
            addCriterion("moment_content between", value1, value2, "momentContent");
            return (Criteria) this;
        }

        public Criteria andMomentContentNotBetween(String value1, String value2) {
            addCriterion("moment_content not between", value1, value2, "momentContent");
            return (Criteria) this;
        }

        public Criteria andFavoritesCountIsNull() {
            addCriterion("favorites_count is null");
            return (Criteria) this;
        }

        public Criteria andFavoritesCountIsNotNull() {
            addCriterion("favorites_count is not null");
            return (Criteria) this;
        }

        public Criteria andFavoritesCountEqualTo(Integer value) {
            addCriterion("favorites_count =", value, "favoritesCount");
            return (Criteria) this;
        }

        public Criteria andFavoritesCountNotEqualTo(Integer value) {
            addCriterion("favorites_count <>", value, "favoritesCount");
            return (Criteria) this;
        }

        public Criteria andFavoritesCountGreaterThan(Integer value) {
            addCriterion("favorites_count >", value, "favoritesCount");
            return (Criteria) this;
        }

        public Criteria andFavoritesCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("favorites_count >=", value, "favoritesCount");
            return (Criteria) this;
        }

        public Criteria andFavoritesCountLessThan(Integer value) {
            addCriterion("favorites_count <", value, "favoritesCount");
            return (Criteria) this;
        }

        public Criteria andFavoritesCountLessThanOrEqualTo(Integer value) {
            addCriterion("favorites_count <=", value, "favoritesCount");
            return (Criteria) this;
        }

        public Criteria andFavoritesCountIn(List<Integer> values) {
            addCriterion("favorites_count in", values, "favoritesCount");
            return (Criteria) this;
        }

        public Criteria andFavoritesCountNotIn(List<Integer> values) {
            addCriterion("favorites_count not in", values, "favoritesCount");
            return (Criteria) this;
        }

        public Criteria andFavoritesCountBetween(Integer value1, Integer value2) {
            addCriterion("favorites_count between", value1, value2, "favoritesCount");
            return (Criteria) this;
        }

        public Criteria andFavoritesCountNotBetween(Integer value1, Integer value2) {
            addCriterion("favorites_count not between", value1, value2, "favoritesCount");
            return (Criteria) this;
        }

        public Criteria andReadCountIsNull() {
            addCriterion("read_count is null");
            return (Criteria) this;
        }

        public Criteria andReadCountIsNotNull() {
            addCriterion("read_count is not null");
            return (Criteria) this;
        }

        public Criteria andReadCountEqualTo(Integer value) {
            addCriterion("read_count =", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountNotEqualTo(Integer value) {
            addCriterion("read_count <>", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountGreaterThan(Integer value) {
            addCriterion("read_count >", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("read_count >=", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountLessThan(Integer value) {
            addCriterion("read_count <", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountLessThanOrEqualTo(Integer value) {
            addCriterion("read_count <=", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountIn(List<Integer> values) {
            addCriterion("read_count in", values, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountNotIn(List<Integer> values) {
            addCriterion("read_count not in", values, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountBetween(Integer value1, Integer value2) {
            addCriterion("read_count between", value1, value2, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountNotBetween(Integer value1, Integer value2) {
            addCriterion("read_count not between", value1, value2, "readCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountIsNull() {
            addCriterion("like_count is null");
            return (Criteria) this;
        }

        public Criteria andLikeCountIsNotNull() {
            addCriterion("like_count is not null");
            return (Criteria) this;
        }

        public Criteria andLikeCountEqualTo(Integer value) {
            addCriterion("like_count =", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountNotEqualTo(Integer value) {
            addCriterion("like_count <>", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountGreaterThan(Integer value) {
            addCriterion("like_count >", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("like_count >=", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountLessThan(Integer value) {
            addCriterion("like_count <", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountLessThanOrEqualTo(Integer value) {
            addCriterion("like_count <=", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountIn(List<Integer> values) {
            addCriterion("like_count in", values, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountNotIn(List<Integer> values) {
            addCriterion("like_count not in", values, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountBetween(Integer value1, Integer value2) {
            addCriterion("like_count between", value1, value2, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("like_count not between", value1, value2, "likeCount");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Integer> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Integer> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andKeyWordIsNull() {
            addCriterion("key_word is null");
            return (Criteria) this;
        }

        public Criteria andKeyWordIsNotNull() {
            addCriterion("key_word is not null");
            return (Criteria) this;
        }

        public Criteria andKeyWordEqualTo(String value) {
            addCriterion("key_word =", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordNotEqualTo(String value) {
            addCriterion("key_word <>", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordGreaterThan(String value) {
            addCriterion("key_word >", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordGreaterThanOrEqualTo(String value) {
            addCriterion("key_word >=", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordLessThan(String value) {
            addCriterion("key_word <", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordLessThanOrEqualTo(String value) {
            addCriterion("key_word <=", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordLike(String value) {
            addCriterion("key_word like", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordNotLike(String value) {
            addCriterion("key_word not like", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordIn(List<String> values) {
            addCriterion("key_word in", values, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordNotIn(List<String> values) {
            addCriterion("key_word not in", values, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordBetween(String value1, String value2) {
            addCriterion("key_word between", value1, value2, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordNotBetween(String value1, String value2) {
            addCriterion("key_word not between", value1, value2, "keyWord");
            return (Criteria) this;
        }

        public Criteria andCommentsCountIsNull() {
            addCriterion("comments_count is null");
            return (Criteria) this;
        }

        public Criteria andCommentsCountIsNotNull() {
            addCriterion("comments_count is not null");
            return (Criteria) this;
        }

        public Criteria andCommentsCountEqualTo(Integer value) {
            addCriterion("comments_count =", value, "commentsCount");
            return (Criteria) this;
        }

        public Criteria andCommentsCountNotEqualTo(Integer value) {
            addCriterion("comments_count <>", value, "commentsCount");
            return (Criteria) this;
        }

        public Criteria andCommentsCountGreaterThan(Integer value) {
            addCriterion("comments_count >", value, "commentsCount");
            return (Criteria) this;
        }

        public Criteria andCommentsCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("comments_count >=", value, "commentsCount");
            return (Criteria) this;
        }

        public Criteria andCommentsCountLessThan(Integer value) {
            addCriterion("comments_count <", value, "commentsCount");
            return (Criteria) this;
        }

        public Criteria andCommentsCountLessThanOrEqualTo(Integer value) {
            addCriterion("comments_count <=", value, "commentsCount");
            return (Criteria) this;
        }

        public Criteria andCommentsCountIn(List<Integer> values) {
            addCriterion("comments_count in", values, "commentsCount");
            return (Criteria) this;
        }

        public Criteria andCommentsCountNotIn(List<Integer> values) {
            addCriterion("comments_count not in", values, "commentsCount");
            return (Criteria) this;
        }

        public Criteria andCommentsCountBetween(Integer value1, Integer value2) {
            addCriterion("comments_count between", value1, value2, "commentsCount");
            return (Criteria) this;
        }

        public Criteria andCommentsCountNotBetween(Integer value1, Integer value2) {
            addCriterion("comments_count not between", value1, value2, "commentsCount");
            return (Criteria) this;
        }

        public Criteria andMomentVideoIsNull() {
            addCriterion("moment_video is null");
            return (Criteria) this;
        }

        public Criteria andMomentVideoIsNotNull() {
            addCriterion("moment_video is not null");
            return (Criteria) this;
        }

        public Criteria andMomentVideoEqualTo(String value) {
            addCriterion("moment_video =", value, "momentVideo");
            return (Criteria) this;
        }

        public Criteria andMomentVideoNotEqualTo(String value) {
            addCriterion("moment_video <>", value, "momentVideo");
            return (Criteria) this;
        }

        public Criteria andMomentVideoGreaterThan(String value) {
            addCriterion("moment_video >", value, "momentVideo");
            return (Criteria) this;
        }

        public Criteria andMomentVideoGreaterThanOrEqualTo(String value) {
            addCriterion("moment_video >=", value, "momentVideo");
            return (Criteria) this;
        }

        public Criteria andMomentVideoLessThan(String value) {
            addCriterion("moment_video <", value, "momentVideo");
            return (Criteria) this;
        }

        public Criteria andMomentVideoLessThanOrEqualTo(String value) {
            addCriterion("moment_video <=", value, "momentVideo");
            return (Criteria) this;
        }

        public Criteria andMomentVideoLike(String value) {
            addCriterion("moment_video like", value, "momentVideo");
            return (Criteria) this;
        }

        public Criteria andMomentVideoNotLike(String value) {
            addCriterion("moment_video not like", value, "momentVideo");
            return (Criteria) this;
        }

        public Criteria andMomentVideoIn(List<String> values) {
            addCriterion("moment_video in", values, "momentVideo");
            return (Criteria) this;
        }

        public Criteria andMomentVideoNotIn(List<String> values) {
            addCriterion("moment_video not in", values, "momentVideo");
            return (Criteria) this;
        }

        public Criteria andMomentVideoBetween(String value1, String value2) {
            addCriterion("moment_video between", value1, value2, "momentVideo");
            return (Criteria) this;
        }

        public Criteria andMomentVideoNotBetween(String value1, String value2) {
            addCriterion("moment_video not between", value1, value2, "momentVideo");
            return (Criteria) this;
        }

        public Criteria andIsPassIsNull() {
            addCriterion("is_pass is null");
            return (Criteria) this;
        }

        public Criteria andIsPassIsNotNull() {
            addCriterion("is_pass is not null");
            return (Criteria) this;
        }

        public Criteria andIsPassEqualTo(Integer value) {
            addCriterion("is_pass =", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassNotEqualTo(Integer value) {
            addCriterion("is_pass <>", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassGreaterThan(Integer value) {
            addCriterion("is_pass >", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_pass >=", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassLessThan(Integer value) {
            addCriterion("is_pass <", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassLessThanOrEqualTo(Integer value) {
            addCriterion("is_pass <=", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassIn(List<Integer> values) {
            addCriterion("is_pass in", values, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassNotIn(List<Integer> values) {
            addCriterion("is_pass not in", values, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassBetween(Integer value1, Integer value2) {
            addCriterion("is_pass between", value1, value2, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassNotBetween(Integer value1, Integer value2) {
            addCriterion("is_pass not between", value1, value2, "isPass");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(String value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(String value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(String value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(String value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(String value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLike(String value) {
            addCriterion("task_id like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotLike(String value) {
            addCriterion("task_id not like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<String> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<String> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(String value1, String value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(String value1, String value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}