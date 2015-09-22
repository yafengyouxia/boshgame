package com.zsyj.fee.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdvanceConfigCondition {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdvanceConfigCondition() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSpidIsNull() {
            addCriterion("spid is null");
            return (Criteria) this;
        }

        public Criteria andSpidIsNotNull() {
            addCriterion("spid is not null");
            return (Criteria) this;
        }

        public Criteria andSpidEqualTo(String value) {
            addCriterion("spid =", value, "spid");
            return (Criteria) this;
        }

        public Criteria andSpidNotEqualTo(String value) {
            addCriterion("spid <>", value, "spid");
            return (Criteria) this;
        }

        public Criteria andSpidGreaterThan(String value) {
            addCriterion("spid >", value, "spid");
            return (Criteria) this;
        }

        public Criteria andSpidGreaterThanOrEqualTo(String value) {
            addCriterion("spid >=", value, "spid");
            return (Criteria) this;
        }

        public Criteria andSpidLessThan(String value) {
            addCriterion("spid <", value, "spid");
            return (Criteria) this;
        }

        public Criteria andSpidLessThanOrEqualTo(String value) {
            addCriterion("spid <=", value, "spid");
            return (Criteria) this;
        }

        public Criteria andSpidLike(String value) {
            addCriterion("spid like", value, "spid");
            return (Criteria) this;
        }

        public Criteria andSpidNotLike(String value) {
            addCriterion("spid not like", value, "spid");
            return (Criteria) this;
        }

        public Criteria andSpidIn(List<String> values) {
            addCriterion("spid in", values, "spid");
            return (Criteria) this;
        }

        public Criteria andSpidNotIn(List<String> values) {
            addCriterion("spid not in", values, "spid");
            return (Criteria) this;
        }

        public Criteria andSpidBetween(String value1, String value2) {
            addCriterion("spid between", value1, value2, "spid");
            return (Criteria) this;
        }

        public Criteria andSpidNotBetween(String value1, String value2) {
            addCriterion("spid not between", value1, value2, "spid");
            return (Criteria) this;
        }

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(String value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(String value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(String value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(String value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(String value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(String value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLike(String value) {
            addCriterion("cid like", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotLike(String value) {
            addCriterion("cid not like", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<String> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<String> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(String value1, String value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(String value1, String value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNull() {
            addCriterion("province_code is null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNotNull() {
            addCriterion("province_code is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeEqualTo(String value) {
            addCriterion("province_code =", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotEqualTo(String value) {
            addCriterion("province_code <>", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThan(String value) {
            addCriterion("province_code >", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("province_code >=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThan(String value) {
            addCriterion("province_code <", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThanOrEqualTo(String value) {
            addCriterion("province_code <=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLike(String value) {
            addCriterion("province_code like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotLike(String value) {
            addCriterion("province_code not like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIn(List<String> values) {
            addCriterion("province_code in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotIn(List<String> values) {
            addCriterion("province_code not in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeBetween(String value1, String value2) {
            addCriterion("province_code between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotBetween(String value1, String value2) {
            addCriterion("province_code not between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andPercentIsNull() {
            addCriterion("percent is null");
            return (Criteria) this;
        }

        public Criteria andPercentIsNotNull() {
            addCriterion("percent is not null");
            return (Criteria) this;
        }

        public Criteria andPercentEqualTo(Byte value) {
            addCriterion("percent =", value, "percent");
            return (Criteria) this;
        }

        public Criteria andPercentNotEqualTo(Byte value) {
            addCriterion("percent <>", value, "percent");
            return (Criteria) this;
        }

        public Criteria andPercentGreaterThan(Byte value) {
            addCriterion("percent >", value, "percent");
            return (Criteria) this;
        }

        public Criteria andPercentGreaterThanOrEqualTo(Byte value) {
            addCriterion("percent >=", value, "percent");
            return (Criteria) this;
        }

        public Criteria andPercentLessThan(Byte value) {
            addCriterion("percent <", value, "percent");
            return (Criteria) this;
        }

        public Criteria andPercentLessThanOrEqualTo(Byte value) {
            addCriterion("percent <=", value, "percent");
            return (Criteria) this;
        }

        public Criteria andPercentIn(List<Byte> values) {
            addCriterion("percent in", values, "percent");
            return (Criteria) this;
        }

        public Criteria andPercentNotIn(List<Byte> values) {
            addCriterion("percent not in", values, "percent");
            return (Criteria) this;
        }

        public Criteria andPercentBetween(Byte value1, Byte value2) {
            addCriterion("percent between", value1, value2, "percent");
            return (Criteria) this;
        }

        public Criteria andPercentNotBetween(Byte value1, Byte value2) {
            addCriterion("percent not between", value1, value2, "percent");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUseMyselftIsNull() {
            addCriterion("use_myselft is null");
            return (Criteria) this;
        }

        public Criteria andUseMyselftIsNotNull() {
            addCriterion("use_myselft is not null");
            return (Criteria) this;
        }

        public Criteria andUseMyselftEqualTo(Byte value) {
            addCriterion("use_myselft =", value, "useMyselft");
            return (Criteria) this;
        }

        public Criteria andUseMyselftNotEqualTo(Byte value) {
            addCriterion("use_myselft <>", value, "useMyselft");
            return (Criteria) this;
        }

        public Criteria andUseMyselftGreaterThan(Byte value) {
            addCriterion("use_myselft >", value, "useMyselft");
            return (Criteria) this;
        }

        public Criteria andUseMyselftGreaterThanOrEqualTo(Byte value) {
            addCriterion("use_myselft >=", value, "useMyselft");
            return (Criteria) this;
        }

        public Criteria andUseMyselftLessThan(Byte value) {
            addCriterion("use_myselft <", value, "useMyselft");
            return (Criteria) this;
        }

        public Criteria andUseMyselftLessThanOrEqualTo(Byte value) {
            addCriterion("use_myselft <=", value, "useMyselft");
            return (Criteria) this;
        }

        public Criteria andUseMyselftIn(List<Byte> values) {
            addCriterion("use_myselft in", values, "useMyselft");
            return (Criteria) this;
        }

        public Criteria andUseMyselftNotIn(List<Byte> values) {
            addCriterion("use_myselft not in", values, "useMyselft");
            return (Criteria) this;
        }

        public Criteria andUseMyselftBetween(Byte value1, Byte value2) {
            addCriterion("use_myselft between", value1, value2, "useMyselft");
            return (Criteria) this;
        }

        public Criteria andUseMyselftNotBetween(Byte value1, Byte value2) {
            addCriterion("use_myselft not between", value1, value2, "useMyselft");
            return (Criteria) this;
        }

        public Criteria andCloseHourIsNull() {
            addCriterion("close_hour is null");
            return (Criteria) this;
        }

        public Criteria andCloseHourIsNotNull() {
            addCriterion("close_hour is not null");
            return (Criteria) this;
        }

        public Criteria andCloseHourEqualTo(String value) {
            addCriterion("close_hour =", value, "closeHour");
            return (Criteria) this;
        }

        public Criteria andCloseHourNotEqualTo(String value) {
            addCriterion("close_hour <>", value, "closeHour");
            return (Criteria) this;
        }

        public Criteria andCloseHourGreaterThan(String value) {
            addCriterion("close_hour >", value, "closeHour");
            return (Criteria) this;
        }

        public Criteria andCloseHourGreaterThanOrEqualTo(String value) {
            addCriterion("close_hour >=", value, "closeHour");
            return (Criteria) this;
        }

        public Criteria andCloseHourLessThan(String value) {
            addCriterion("close_hour <", value, "closeHour");
            return (Criteria) this;
        }

        public Criteria andCloseHourLessThanOrEqualTo(String value) {
            addCriterion("close_hour <=", value, "closeHour");
            return (Criteria) this;
        }

        public Criteria andCloseHourLike(String value) {
            addCriterion("close_hour like", value, "closeHour");
            return (Criteria) this;
        }

        public Criteria andCloseHourNotLike(String value) {
            addCriterion("close_hour not like", value, "closeHour");
            return (Criteria) this;
        }

        public Criteria andCloseHourIn(List<String> values) {
            addCriterion("close_hour in", values, "closeHour");
            return (Criteria) this;
        }

        public Criteria andCloseHourNotIn(List<String> values) {
            addCriterion("close_hour not in", values, "closeHour");
            return (Criteria) this;
        }

        public Criteria andCloseHourBetween(String value1, String value2) {
            addCriterion("close_hour between", value1, value2, "closeHour");
            return (Criteria) this;
        }

        public Criteria andCloseHourNotBetween(String value1, String value2) {
            addCriterion("close_hour not between", value1, value2, "closeHour");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andMaxcountIsNull() {
            addCriterion("maxcount is null");
            return (Criteria) this;
        }

        public Criteria andMaxcountIsNotNull() {
            addCriterion("maxcount is not null");
            return (Criteria) this;
        }

        public Criteria andMaxcountEqualTo(Integer value) {
            addCriterion("maxcount =", value, "maxcount");
            return (Criteria) this;
        }

        public Criteria andMaxcountNotEqualTo(Integer value) {
            addCriterion("maxcount <>", value, "maxcount");
            return (Criteria) this;
        }

        public Criteria andMaxcountGreaterThan(Integer value) {
            addCriterion("maxcount >", value, "maxcount");
            return (Criteria) this;
        }

        public Criteria andMaxcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("maxcount >=", value, "maxcount");
            return (Criteria) this;
        }

        public Criteria andMaxcountLessThan(Integer value) {
            addCriterion("maxcount <", value, "maxcount");
            return (Criteria) this;
        }

        public Criteria andMaxcountLessThanOrEqualTo(Integer value) {
            addCriterion("maxcount <=", value, "maxcount");
            return (Criteria) this;
        }

        public Criteria andMaxcountIn(List<Integer> values) {
            addCriterion("maxcount in", values, "maxcount");
            return (Criteria) this;
        }

        public Criteria andMaxcountNotIn(List<Integer> values) {
            addCriterion("maxcount not in", values, "maxcount");
            return (Criteria) this;
        }

        public Criteria andMaxcountBetween(Integer value1, Integer value2) {
            addCriterion("maxcount between", value1, value2, "maxcount");
            return (Criteria) this;
        }

        public Criteria andMaxcountNotBetween(Integer value1, Integer value2) {
            addCriterion("maxcount not between", value1, value2, "maxcount");
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

        public Criteria andStartCountIsNull() {
            addCriterion("start_count is null");
            return (Criteria) this;
        }

        public Criteria andStartCountIsNotNull() {
            addCriterion("start_count is not null");
            return (Criteria) this;
        }

        public Criteria andStartCountEqualTo(Integer value) {
            addCriterion("start_count =", value, "startCount");
            return (Criteria) this;
        }

        public Criteria andStartCountNotEqualTo(Integer value) {
            addCriterion("start_count <>", value, "startCount");
            return (Criteria) this;
        }

        public Criteria andStartCountGreaterThan(Integer value) {
            addCriterion("start_count >", value, "startCount");
            return (Criteria) this;
        }

        public Criteria andStartCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("start_count >=", value, "startCount");
            return (Criteria) this;
        }

        public Criteria andStartCountLessThan(Integer value) {
            addCriterion("start_count <", value, "startCount");
            return (Criteria) this;
        }

        public Criteria andStartCountLessThanOrEqualTo(Integer value) {
            addCriterion("start_count <=", value, "startCount");
            return (Criteria) this;
        }

        public Criteria andStartCountIn(List<Integer> values) {
            addCriterion("start_count in", values, "startCount");
            return (Criteria) this;
        }

        public Criteria andStartCountNotIn(List<Integer> values) {
            addCriterion("start_count not in", values, "startCount");
            return (Criteria) this;
        }

        public Criteria andStartCountBetween(Integer value1, Integer value2) {
            addCriterion("start_count between", value1, value2, "startCount");
            return (Criteria) this;
        }

        public Criteria andStartCountNotBetween(Integer value1, Integer value2) {
            addCriterion("start_count not between", value1, value2, "startCount");
            return (Criteria) this;
        }

        public Criteria andStartPercentIsNull() {
            addCriterion("start_percent is null");
            return (Criteria) this;
        }

        public Criteria andStartPercentIsNotNull() {
            addCriterion("start_percent is not null");
            return (Criteria) this;
        }

        public Criteria andStartPercentEqualTo(Byte value) {
            addCriterion("start_percent =", value, "startPercent");
            return (Criteria) this;
        }

        public Criteria andStartPercentNotEqualTo(Byte value) {
            addCriterion("start_percent <>", value, "startPercent");
            return (Criteria) this;
        }

        public Criteria andStartPercentGreaterThan(Byte value) {
            addCriterion("start_percent >", value, "startPercent");
            return (Criteria) this;
        }

        public Criteria andStartPercentGreaterThanOrEqualTo(Byte value) {
            addCriterion("start_percent >=", value, "startPercent");
            return (Criteria) this;
        }

        public Criteria andStartPercentLessThan(Byte value) {
            addCriterion("start_percent <", value, "startPercent");
            return (Criteria) this;
        }

        public Criteria andStartPercentLessThanOrEqualTo(Byte value) {
            addCriterion("start_percent <=", value, "startPercent");
            return (Criteria) this;
        }

        public Criteria andStartPercentIn(List<Byte> values) {
            addCriterion("start_percent in", values, "startPercent");
            return (Criteria) this;
        }

        public Criteria andStartPercentNotIn(List<Byte> values) {
            addCriterion("start_percent not in", values, "startPercent");
            return (Criteria) this;
        }

        public Criteria andStartPercentBetween(Byte value1, Byte value2) {
            addCriterion("start_percent between", value1, value2, "startPercent");
            return (Criteria) this;
        }

        public Criteria andStartPercentNotBetween(Byte value1, Byte value2) {
            addCriterion("start_percent not between", value1, value2, "startPercent");
            return (Criteria) this;
        }

        public Criteria andEndCountIsNull() {
            addCriterion("end_count is null");
            return (Criteria) this;
        }

        public Criteria andEndCountIsNotNull() {
            addCriterion("end_count is not null");
            return (Criteria) this;
        }

        public Criteria andEndCountEqualTo(Integer value) {
            addCriterion("end_count =", value, "endCount");
            return (Criteria) this;
        }

        public Criteria andEndCountNotEqualTo(Integer value) {
            addCriterion("end_count <>", value, "endCount");
            return (Criteria) this;
        }

        public Criteria andEndCountGreaterThan(Integer value) {
            addCriterion("end_count >", value, "endCount");
            return (Criteria) this;
        }

        public Criteria andEndCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("end_count >=", value, "endCount");
            return (Criteria) this;
        }

        public Criteria andEndCountLessThan(Integer value) {
            addCriterion("end_count <", value, "endCount");
            return (Criteria) this;
        }

        public Criteria andEndCountLessThanOrEqualTo(Integer value) {
            addCriterion("end_count <=", value, "endCount");
            return (Criteria) this;
        }

        public Criteria andEndCountIn(List<Integer> values) {
            addCriterion("end_count in", values, "endCount");
            return (Criteria) this;
        }

        public Criteria andEndCountNotIn(List<Integer> values) {
            addCriterion("end_count not in", values, "endCount");
            return (Criteria) this;
        }

        public Criteria andEndCountBetween(Integer value1, Integer value2) {
            addCriterion("end_count between", value1, value2, "endCount");
            return (Criteria) this;
        }

        public Criteria andEndCountNotBetween(Integer value1, Integer value2) {
            addCriterion("end_count not between", value1, value2, "endCount");
            return (Criteria) this;
        }

        public Criteria andEndPercentIsNull() {
            addCriterion("end_percent is null");
            return (Criteria) this;
        }

        public Criteria andEndPercentIsNotNull() {
            addCriterion("end_percent is not null");
            return (Criteria) this;
        }

        public Criteria andEndPercentEqualTo(Byte value) {
            addCriterion("end_percent =", value, "endPercent");
            return (Criteria) this;
        }

        public Criteria andEndPercentNotEqualTo(Byte value) {
            addCriterion("end_percent <>", value, "endPercent");
            return (Criteria) this;
        }

        public Criteria andEndPercentGreaterThan(Byte value) {
            addCriterion("end_percent >", value, "endPercent");
            return (Criteria) this;
        }

        public Criteria andEndPercentGreaterThanOrEqualTo(Byte value) {
            addCriterion("end_percent >=", value, "endPercent");
            return (Criteria) this;
        }

        public Criteria andEndPercentLessThan(Byte value) {
            addCriterion("end_percent <", value, "endPercent");
            return (Criteria) this;
        }

        public Criteria andEndPercentLessThanOrEqualTo(Byte value) {
            addCriterion("end_percent <=", value, "endPercent");
            return (Criteria) this;
        }

        public Criteria andEndPercentIn(List<Byte> values) {
            addCriterion("end_percent in", values, "endPercent");
            return (Criteria) this;
        }

        public Criteria andEndPercentNotIn(List<Byte> values) {
            addCriterion("end_percent not in", values, "endPercent");
            return (Criteria) this;
        }

        public Criteria andEndPercentBetween(Byte value1, Byte value2) {
            addCriterion("end_percent between", value1, value2, "endPercent");
            return (Criteria) this;
        }

        public Criteria andEndPercentNotBetween(Byte value1, Byte value2) {
            addCriterion("end_percent not between", value1, value2, "endPercent");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIsNull() {
            addCriterion("account_type is null");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIsNotNull() {
            addCriterion("account_type is not null");
            return (Criteria) this;
        }

        public Criteria andAccountTypeEqualTo(Integer value) {
            addCriterion("account_type =", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotEqualTo(Integer value) {
            addCriterion("account_type <>", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeGreaterThan(Integer value) {
            addCriterion("account_type >", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_type >=", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLessThan(Integer value) {
            addCriterion("account_type <", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLessThanOrEqualTo(Integer value) {
            addCriterion("account_type <=", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIn(List<Integer> values) {
            addCriterion("account_type in", values, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotIn(List<Integer> values) {
            addCriterion("account_type not in", values, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeBetween(Integer value1, Integer value2) {
            addCriterion("account_type between", value1, value2, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("account_type not between", value1, value2, "accountType");
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