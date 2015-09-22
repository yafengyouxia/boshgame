package com.zsyj.fee.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CfgRoleCondition {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfgRoleCondition() {
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

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("CODE is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("CODE =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("CODE <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("CODE >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CODE >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("CODE <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("CODE <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("CODE like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("CODE not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("CODE in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("CODE not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("CODE between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("CODE not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andRecommendIsNull() {
            addCriterion("recommend is null");
            return (Criteria) this;
        }

        public Criteria andRecommendIsNotNull() {
            addCriterion("recommend is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendEqualTo(String value) {
            addCriterion("recommend =", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotEqualTo(String value) {
            addCriterion("recommend <>", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendGreaterThan(String value) {
            addCriterion("recommend >", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendGreaterThanOrEqualTo(String value) {
            addCriterion("recommend >=", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendLessThan(String value) {
            addCriterion("recommend <", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendLessThanOrEqualTo(String value) {
            addCriterion("recommend <=", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendLike(String value) {
            addCriterion("recommend like", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotLike(String value) {
            addCriterion("recommend not like", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendIn(List<String> values) {
            addCriterion("recommend in", values, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotIn(List<String> values) {
            addCriterion("recommend not in", values, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendBetween(String value1, String value2) {
            addCriterion("recommend between", value1, value2, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotBetween(String value1, String value2) {
            addCriterion("recommend not between", value1, value2, "recommend");
            return (Criteria) this;
        }

        public Criteria andFeelimitmonthIsNull() {
            addCriterion("feeLimitMonth is null");
            return (Criteria) this;
        }

        public Criteria andFeelimitmonthIsNotNull() {
            addCriterion("feeLimitMonth is not null");
            return (Criteria) this;
        }

        public Criteria andFeelimitmonthEqualTo(Integer value) {
            addCriterion("feeLimitMonth =", value, "feelimitmonth");
            return (Criteria) this;
        }

        public Criteria andFeelimitmonthNotEqualTo(Integer value) {
            addCriterion("feeLimitMonth <>", value, "feelimitmonth");
            return (Criteria) this;
        }

        public Criteria andFeelimitmonthGreaterThan(Integer value) {
            addCriterion("feeLimitMonth >", value, "feelimitmonth");
            return (Criteria) this;
        }

        public Criteria andFeelimitmonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("feeLimitMonth >=", value, "feelimitmonth");
            return (Criteria) this;
        }

        public Criteria andFeelimitmonthLessThan(Integer value) {
            addCriterion("feeLimitMonth <", value, "feelimitmonth");
            return (Criteria) this;
        }

        public Criteria andFeelimitmonthLessThanOrEqualTo(Integer value) {
            addCriterion("feeLimitMonth <=", value, "feelimitmonth");
            return (Criteria) this;
        }

        public Criteria andFeelimitmonthIn(List<Integer> values) {
            addCriterion("feeLimitMonth in", values, "feelimitmonth");
            return (Criteria) this;
        }

        public Criteria andFeelimitmonthNotIn(List<Integer> values) {
            addCriterion("feeLimitMonth not in", values, "feelimitmonth");
            return (Criteria) this;
        }

        public Criteria andFeelimitmonthBetween(Integer value1, Integer value2) {
            addCriterion("feeLimitMonth between", value1, value2, "feelimitmonth");
            return (Criteria) this;
        }

        public Criteria andFeelimitmonthNotBetween(Integer value1, Integer value2) {
            addCriterion("feeLimitMonth not between", value1, value2, "feelimitmonth");
            return (Criteria) this;
        }

        public Criteria andFeelimitdayIsNull() {
            addCriterion("feeLimitDay is null");
            return (Criteria) this;
        }

        public Criteria andFeelimitdayIsNotNull() {
            addCriterion("feeLimitDay is not null");
            return (Criteria) this;
        }

        public Criteria andFeelimitdayEqualTo(Integer value) {
            addCriterion("feeLimitDay =", value, "feelimitday");
            return (Criteria) this;
        }

        public Criteria andFeelimitdayNotEqualTo(Integer value) {
            addCriterion("feeLimitDay <>", value, "feelimitday");
            return (Criteria) this;
        }

        public Criteria andFeelimitdayGreaterThan(Integer value) {
            addCriterion("feeLimitDay >", value, "feelimitday");
            return (Criteria) this;
        }

        public Criteria andFeelimitdayGreaterThanOrEqualTo(Integer value) {
            addCriterion("feeLimitDay >=", value, "feelimitday");
            return (Criteria) this;
        }

        public Criteria andFeelimitdayLessThan(Integer value) {
            addCriterion("feeLimitDay <", value, "feelimitday");
            return (Criteria) this;
        }

        public Criteria andFeelimitdayLessThanOrEqualTo(Integer value) {
            addCriterion("feeLimitDay <=", value, "feelimitday");
            return (Criteria) this;
        }

        public Criteria andFeelimitdayIn(List<Integer> values) {
            addCriterion("feeLimitDay in", values, "feelimitday");
            return (Criteria) this;
        }

        public Criteria andFeelimitdayNotIn(List<Integer> values) {
            addCriterion("feeLimitDay not in", values, "feelimitday");
            return (Criteria) this;
        }

        public Criteria andFeelimitdayBetween(Integer value1, Integer value2) {
            addCriterion("feeLimitDay between", value1, value2, "feelimitday");
            return (Criteria) this;
        }

        public Criteria andFeelimitdayNotBetween(Integer value1, Integer value2) {
            addCriterion("feeLimitDay not between", value1, value2, "feelimitday");
            return (Criteria) this;
        }

        public Criteria andSubpertimesIsNull() {
            addCriterion("subPerTimes is null");
            return (Criteria) this;
        }

        public Criteria andSubpertimesIsNotNull() {
            addCriterion("subPerTimes is not null");
            return (Criteria) this;
        }

        public Criteria andSubpertimesEqualTo(BigDecimal value) {
            addCriterion("subPerTimes =", value, "subpertimes");
            return (Criteria) this;
        }

        public Criteria andSubpertimesNotEqualTo(BigDecimal value) {
            addCriterion("subPerTimes <>", value, "subpertimes");
            return (Criteria) this;
        }

        public Criteria andSubpertimesGreaterThan(BigDecimal value) {
            addCriterion("subPerTimes >", value, "subpertimes");
            return (Criteria) this;
        }

        public Criteria andSubpertimesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("subPerTimes >=", value, "subpertimes");
            return (Criteria) this;
        }

        public Criteria andSubpertimesLessThan(BigDecimal value) {
            addCriterion("subPerTimes <", value, "subpertimes");
            return (Criteria) this;
        }

        public Criteria andSubpertimesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("subPerTimes <=", value, "subpertimes");
            return (Criteria) this;
        }

        public Criteria andSubpertimesIn(List<BigDecimal> values) {
            addCriterion("subPerTimes in", values, "subpertimes");
            return (Criteria) this;
        }

        public Criteria andSubpertimesNotIn(List<BigDecimal> values) {
            addCriterion("subPerTimes not in", values, "subpertimes");
            return (Criteria) this;
        }

        public Criteria andSubpertimesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("subPerTimes between", value1, value2, "subpertimes");
            return (Criteria) this;
        }

        public Criteria andSubpertimesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("subPerTimes not between", value1, value2, "subpertimes");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNull() {
            addCriterion("addtime is null");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNotNull() {
            addCriterion("addtime is not null");
            return (Criteria) this;
        }

        public Criteria andAddtimeEqualTo(Date value) {
            addCriterion("addtime =", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotEqualTo(Date value) {
            addCriterion("addtime <>", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThan(Date value) {
            addCriterion("addtime >", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("addtime >=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThan(Date value) {
            addCriterion("addtime <", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThanOrEqualTo(Date value) {
            addCriterion("addtime <=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeIn(List<Date> values) {
            addCriterion("addtime in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotIn(List<Date> values) {
            addCriterion("addtime not in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeBetween(Date value1, Date value2) {
            addCriterion("addtime between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotBetween(Date value1, Date value2) {
            addCriterion("addtime not between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andIsActivateIsNull() {
            addCriterion("is_activate is null");
            return (Criteria) this;
        }

        public Criteria andIsActivateIsNotNull() {
            addCriterion("is_activate is not null");
            return (Criteria) this;
        }

        public Criteria andIsActivateEqualTo(String value) {
            addCriterion("is_activate =", value, "isActivate");
            return (Criteria) this;
        }

        public Criteria andIsActivateNotEqualTo(String value) {
            addCriterion("is_activate <>", value, "isActivate");
            return (Criteria) this;
        }

        public Criteria andIsActivateGreaterThan(String value) {
            addCriterion("is_activate >", value, "isActivate");
            return (Criteria) this;
        }

        public Criteria andIsActivateGreaterThanOrEqualTo(String value) {
            addCriterion("is_activate >=", value, "isActivate");
            return (Criteria) this;
        }

        public Criteria andIsActivateLessThan(String value) {
            addCriterion("is_activate <", value, "isActivate");
            return (Criteria) this;
        }

        public Criteria andIsActivateLessThanOrEqualTo(String value) {
            addCriterion("is_activate <=", value, "isActivate");
            return (Criteria) this;
        }

        public Criteria andIsActivateLike(String value) {
            addCriterion("is_activate like", value, "isActivate");
            return (Criteria) this;
        }

        public Criteria andIsActivateNotLike(String value) {
            addCriterion("is_activate not like", value, "isActivate");
            return (Criteria) this;
        }

        public Criteria andIsActivateIn(List<String> values) {
            addCriterion("is_activate in", values, "isActivate");
            return (Criteria) this;
        }

        public Criteria andIsActivateNotIn(List<String> values) {
            addCriterion("is_activate not in", values, "isActivate");
            return (Criteria) this;
        }

        public Criteria andIsActivateBetween(String value1, String value2) {
            addCriterion("is_activate between", value1, value2, "isActivate");
            return (Criteria) this;
        }

        public Criteria andIsActivateNotBetween(String value1, String value2) {
            addCriterion("is_activate not between", value1, value2, "isActivate");
            return (Criteria) this;
        }

        public Criteria andDetailIsNull() {
            addCriterion("detail is null");
            return (Criteria) this;
        }

        public Criteria andDetailIsNotNull() {
            addCriterion("detail is not null");
            return (Criteria) this;
        }

        public Criteria andDetailEqualTo(String value) {
            addCriterion("detail =", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotEqualTo(String value) {
            addCriterion("detail <>", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThan(String value) {
            addCriterion("detail >", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThanOrEqualTo(String value) {
            addCriterion("detail >=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThan(String value) {
            addCriterion("detail <", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThanOrEqualTo(String value) {
            addCriterion("detail <=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLike(String value) {
            addCriterion("detail like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotLike(String value) {
            addCriterion("detail not like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailIn(List<String> values) {
            addCriterion("detail in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotIn(List<String> values) {
            addCriterion("detail not in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailBetween(String value1, String value2) {
            addCriterion("detail between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotBetween(String value1, String value2) {
            addCriterion("detail not between", value1, value2, "detail");
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