package com.zsyj.fee.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CfgSubCondition {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfgSubCondition() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMainIdIsNull() {
            addCriterion("MAIN_ID is null");
            return (Criteria) this;
        }

        public Criteria andMainIdIsNotNull() {
            addCriterion("MAIN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMainIdEqualTo(Integer value) {
            addCriterion("MAIN_ID =", value, "mainId");
            return (Criteria) this;
        }

        public Criteria andMainIdNotEqualTo(Integer value) {
            addCriterion("MAIN_ID <>", value, "mainId");
            return (Criteria) this;
        }

        public Criteria andMainIdGreaterThan(Integer value) {
            addCriterion("MAIN_ID >", value, "mainId");
            return (Criteria) this;
        }

        public Criteria andMainIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("MAIN_ID >=", value, "mainId");
            return (Criteria) this;
        }

        public Criteria andMainIdLessThan(Integer value) {
            addCriterion("MAIN_ID <", value, "mainId");
            return (Criteria) this;
        }

        public Criteria andMainIdLessThanOrEqualTo(Integer value) {
            addCriterion("MAIN_ID <=", value, "mainId");
            return (Criteria) this;
        }

        public Criteria andMainIdIn(List<Integer> values) {
            addCriterion("MAIN_ID in", values, "mainId");
            return (Criteria) this;
        }

        public Criteria andMainIdNotIn(List<Integer> values) {
            addCriterion("MAIN_ID not in", values, "mainId");
            return (Criteria) this;
        }

        public Criteria andMainIdBetween(Integer value1, Integer value2) {
            addCriterion("MAIN_ID between", value1, value2, "mainId");
            return (Criteria) this;
        }

        public Criteria andMainIdNotBetween(Integer value1, Integer value2) {
            addCriterion("MAIN_ID not between", value1, value2, "mainId");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIsNull() {
            addCriterion("AREA_CODE is null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIsNotNull() {
            addCriterion("AREA_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeEqualTo(String value) {
            addCriterion("AREA_CODE =", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotEqualTo(String value) {
            addCriterion("AREA_CODE <>", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThan(String value) {
            addCriterion("AREA_CODE >", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("AREA_CODE >=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThan(String value) {
            addCriterion("AREA_CODE <", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThanOrEqualTo(String value) {
            addCriterion("AREA_CODE <=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLike(String value) {
            addCriterion("AREA_CODE like", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotLike(String value) {
            addCriterion("AREA_CODE not like", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIn(List<String> values) {
            addCriterion("AREA_CODE in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotIn(List<String> values) {
            addCriterion("AREA_CODE not in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeBetween(String value1, String value2) {
            addCriterion("AREA_CODE between", value1, value2, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotBetween(String value1, String value2) {
            addCriterion("AREA_CODE not between", value1, value2, "areaCode");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("TYPE like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("TYPE not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andServiceCodeIsNull() {
            addCriterion("service_code is null");
            return (Criteria) this;
        }

        public Criteria andServiceCodeIsNotNull() {
            addCriterion("service_code is not null");
            return (Criteria) this;
        }

        public Criteria andServiceCodeEqualTo(String value) {
            addCriterion("service_code =", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeNotEqualTo(String value) {
            addCriterion("service_code <>", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeGreaterThan(String value) {
            addCriterion("service_code >", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("service_code >=", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeLessThan(String value) {
            addCriterion("service_code <", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeLessThanOrEqualTo(String value) {
            addCriterion("service_code <=", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeLike(String value) {
            addCriterion("service_code like", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeNotLike(String value) {
            addCriterion("service_code not like", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeIn(List<String> values) {
            addCriterion("service_code in", values, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeNotIn(List<String> values) {
            addCriterion("service_code not in", values, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeBetween(String value1, String value2) {
            addCriterion("service_code between", value1, value2, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeNotBetween(String value1, String value2) {
            addCriterion("service_code not between", value1, value2, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andHintTypeIsNull() {
            addCriterion("HINT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andHintTypeIsNotNull() {
            addCriterion("HINT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andHintTypeEqualTo(String value) {
            addCriterion("HINT_TYPE =", value, "hintType");
            return (Criteria) this;
        }

        public Criteria andHintTypeNotEqualTo(String value) {
            addCriterion("HINT_TYPE <>", value, "hintType");
            return (Criteria) this;
        }

        public Criteria andHintTypeGreaterThan(String value) {
            addCriterion("HINT_TYPE >", value, "hintType");
            return (Criteria) this;
        }

        public Criteria andHintTypeGreaterThanOrEqualTo(String value) {
            addCriterion("HINT_TYPE >=", value, "hintType");
            return (Criteria) this;
        }

        public Criteria andHintTypeLessThan(String value) {
            addCriterion("HINT_TYPE <", value, "hintType");
            return (Criteria) this;
        }

        public Criteria andHintTypeLessThanOrEqualTo(String value) {
            addCriterion("HINT_TYPE <=", value, "hintType");
            return (Criteria) this;
        }

        public Criteria andHintTypeLike(String value) {
            addCriterion("HINT_TYPE like", value, "hintType");
            return (Criteria) this;
        }

        public Criteria andHintTypeNotLike(String value) {
            addCriterion("HINT_TYPE not like", value, "hintType");
            return (Criteria) this;
        }

        public Criteria andHintTypeIn(List<String> values) {
            addCriterion("HINT_TYPE in", values, "hintType");
            return (Criteria) this;
        }

        public Criteria andHintTypeNotIn(List<String> values) {
            addCriterion("HINT_TYPE not in", values, "hintType");
            return (Criteria) this;
        }

        public Criteria andHintTypeBetween(String value1, String value2) {
            addCriterion("HINT_TYPE between", value1, value2, "hintType");
            return (Criteria) this;
        }

        public Criteria andHintTypeNotBetween(String value1, String value2) {
            addCriterion("HINT_TYPE not between", value1, value2, "hintType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeIsNull() {
            addCriterion("FEE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andFeeTypeIsNotNull() {
            addCriterion("FEE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFeeTypeEqualTo(Integer value) {
            addCriterion("FEE_TYPE =", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeNotEqualTo(Integer value) {
            addCriterion("FEE_TYPE <>", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeGreaterThan(Integer value) {
            addCriterion("FEE_TYPE >", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("FEE_TYPE >=", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeLessThan(Integer value) {
            addCriterion("FEE_TYPE <", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("FEE_TYPE <=", value, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeIn(List<Integer> values) {
            addCriterion("FEE_TYPE in", values, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeNotIn(List<Integer> values) {
            addCriterion("FEE_TYPE not in", values, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeBetween(Integer value1, Integer value2) {
            addCriterion("FEE_TYPE between", value1, value2, "feeType");
            return (Criteria) this;
        }

        public Criteria andFeeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("FEE_TYPE not between", value1, value2, "feeType");
            return (Criteria) this;
        }

        public Criteria andTimesIsNull() {
            addCriterion("TIMES is null");
            return (Criteria) this;
        }

        public Criteria andTimesIsNotNull() {
            addCriterion("TIMES is not null");
            return (Criteria) this;
        }

        public Criteria andTimesEqualTo(Integer value) {
            addCriterion("TIMES =", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotEqualTo(Integer value) {
            addCriterion("TIMES <>", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesGreaterThan(Integer value) {
            addCriterion("TIMES >", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("TIMES >=", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesLessThan(Integer value) {
            addCriterion("TIMES <", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesLessThanOrEqualTo(Integer value) {
            addCriterion("TIMES <=", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesIn(List<Integer> values) {
            addCriterion("TIMES in", values, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotIn(List<Integer> values) {
            addCriterion("TIMES not in", values, "times");
            return (Criteria) this;
        }

        public Criteria andTimesBetween(Integer value1, Integer value2) {
            addCriterion("TIMES between", value1, value2, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("TIMES not between", value1, value2, "times");
            return (Criteria) this;
        }

        public Criteria andFeeIdIsNull() {
            addCriterion("FEE_ID is null");
            return (Criteria) this;
        }

        public Criteria andFeeIdIsNotNull() {
            addCriterion("FEE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFeeIdEqualTo(String value) {
            addCriterion("FEE_ID =", value, "feeId");
            return (Criteria) this;
        }

        public Criteria andFeeIdNotEqualTo(String value) {
            addCriterion("FEE_ID <>", value, "feeId");
            return (Criteria) this;
        }

        public Criteria andFeeIdGreaterThan(String value) {
            addCriterion("FEE_ID >", value, "feeId");
            return (Criteria) this;
        }

        public Criteria andFeeIdGreaterThanOrEqualTo(String value) {
            addCriterion("FEE_ID >=", value, "feeId");
            return (Criteria) this;
        }

        public Criteria andFeeIdLessThan(String value) {
            addCriterion("FEE_ID <", value, "feeId");
            return (Criteria) this;
        }

        public Criteria andFeeIdLessThanOrEqualTo(String value) {
            addCriterion("FEE_ID <=", value, "feeId");
            return (Criteria) this;
        }

        public Criteria andFeeIdLike(String value) {
            addCriterion("FEE_ID like", value, "feeId");
            return (Criteria) this;
        }

        public Criteria andFeeIdNotLike(String value) {
            addCriterion("FEE_ID not like", value, "feeId");
            return (Criteria) this;
        }

        public Criteria andFeeIdIn(List<String> values) {
            addCriterion("FEE_ID in", values, "feeId");
            return (Criteria) this;
        }

        public Criteria andFeeIdNotIn(List<String> values) {
            addCriterion("FEE_ID not in", values, "feeId");
            return (Criteria) this;
        }

        public Criteria andFeeIdBetween(String value1, String value2) {
            addCriterion("FEE_ID between", value1, value2, "feeId");
            return (Criteria) this;
        }

        public Criteria andFeeIdNotBetween(String value1, String value2) {
            addCriterion("FEE_ID not between", value1, value2, "feeId");
            return (Criteria) this;
        }

        public Criteria andMaxcountIsNull() {
            addCriterion("MAXCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andMaxcountIsNotNull() {
            addCriterion("MAXCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andMaxcountEqualTo(Integer value) {
            addCriterion("MAXCOUNT =", value, "maxcount");
            return (Criteria) this;
        }

        public Criteria andMaxcountNotEqualTo(Integer value) {
            addCriterion("MAXCOUNT <>", value, "maxcount");
            return (Criteria) this;
        }

        public Criteria andMaxcountGreaterThan(Integer value) {
            addCriterion("MAXCOUNT >", value, "maxcount");
            return (Criteria) this;
        }

        public Criteria andMaxcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("MAXCOUNT >=", value, "maxcount");
            return (Criteria) this;
        }

        public Criteria andMaxcountLessThan(Integer value) {
            addCriterion("MAXCOUNT <", value, "maxcount");
            return (Criteria) this;
        }

        public Criteria andMaxcountLessThanOrEqualTo(Integer value) {
            addCriterion("MAXCOUNT <=", value, "maxcount");
            return (Criteria) this;
        }

        public Criteria andMaxcountIn(List<Integer> values) {
            addCriterion("MAXCOUNT in", values, "maxcount");
            return (Criteria) this;
        }

        public Criteria andMaxcountNotIn(List<Integer> values) {
            addCriterion("MAXCOUNT not in", values, "maxcount");
            return (Criteria) this;
        }

        public Criteria andMaxcountBetween(Integer value1, Integer value2) {
            addCriterion("MAXCOUNT between", value1, value2, "maxcount");
            return (Criteria) this;
        }

        public Criteria andMaxcountNotBetween(Integer value1, Integer value2) {
            addCriterion("MAXCOUNT not between", value1, value2, "maxcount");
            return (Criteria) this;
        }

        public Criteria andHintTimesIsNull() {
            addCriterion("HINT_TIMES is null");
            return (Criteria) this;
        }

        public Criteria andHintTimesIsNotNull() {
            addCriterion("HINT_TIMES is not null");
            return (Criteria) this;
        }

        public Criteria andHintTimesEqualTo(Integer value) {
            addCriterion("HINT_TIMES =", value, "hintTimes");
            return (Criteria) this;
        }

        public Criteria andHintTimesNotEqualTo(Integer value) {
            addCriterion("HINT_TIMES <>", value, "hintTimes");
            return (Criteria) this;
        }

        public Criteria andHintTimesGreaterThan(Integer value) {
            addCriterion("HINT_TIMES >", value, "hintTimes");
            return (Criteria) this;
        }

        public Criteria andHintTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("HINT_TIMES >=", value, "hintTimes");
            return (Criteria) this;
        }

        public Criteria andHintTimesLessThan(Integer value) {
            addCriterion("HINT_TIMES <", value, "hintTimes");
            return (Criteria) this;
        }

        public Criteria andHintTimesLessThanOrEqualTo(Integer value) {
            addCriterion("HINT_TIMES <=", value, "hintTimes");
            return (Criteria) this;
        }

        public Criteria andHintTimesIn(List<Integer> values) {
            addCriterion("HINT_TIMES in", values, "hintTimes");
            return (Criteria) this;
        }

        public Criteria andHintTimesNotIn(List<Integer> values) {
            addCriterion("HINT_TIMES not in", values, "hintTimes");
            return (Criteria) this;
        }

        public Criteria andHintTimesBetween(Integer value1, Integer value2) {
            addCriterion("HINT_TIMES between", value1, value2, "hintTimes");
            return (Criteria) this;
        }

        public Criteria andHintTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("HINT_TIMES not between", value1, value2, "hintTimes");
            return (Criteria) this;
        }

        public Criteria andHintIntervalIsNull() {
            addCriterion("HINT_INTERVAL is null");
            return (Criteria) this;
        }

        public Criteria andHintIntervalIsNotNull() {
            addCriterion("HINT_INTERVAL is not null");
            return (Criteria) this;
        }

        public Criteria andHintIntervalEqualTo(Integer value) {
            addCriterion("HINT_INTERVAL =", value, "hintInterval");
            return (Criteria) this;
        }

        public Criteria andHintIntervalNotEqualTo(Integer value) {
            addCriterion("HINT_INTERVAL <>", value, "hintInterval");
            return (Criteria) this;
        }

        public Criteria andHintIntervalGreaterThan(Integer value) {
            addCriterion("HINT_INTERVAL >", value, "hintInterval");
            return (Criteria) this;
        }

        public Criteria andHintIntervalGreaterThanOrEqualTo(Integer value) {
            addCriterion("HINT_INTERVAL >=", value, "hintInterval");
            return (Criteria) this;
        }

        public Criteria andHintIntervalLessThan(Integer value) {
            addCriterion("HINT_INTERVAL <", value, "hintInterval");
            return (Criteria) this;
        }

        public Criteria andHintIntervalLessThanOrEqualTo(Integer value) {
            addCriterion("HINT_INTERVAL <=", value, "hintInterval");
            return (Criteria) this;
        }

        public Criteria andHintIntervalIn(List<Integer> values) {
            addCriterion("HINT_INTERVAL in", values, "hintInterval");
            return (Criteria) this;
        }

        public Criteria andHintIntervalNotIn(List<Integer> values) {
            addCriterion("HINT_INTERVAL not in", values, "hintInterval");
            return (Criteria) this;
        }

        public Criteria andHintIntervalBetween(Integer value1, Integer value2) {
            addCriterion("HINT_INTERVAL between", value1, value2, "hintInterval");
            return (Criteria) this;
        }

        public Criteria andHintIntervalNotBetween(Integer value1, Integer value2) {
            addCriterion("HINT_INTERVAL not between", value1, value2, "hintInterval");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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