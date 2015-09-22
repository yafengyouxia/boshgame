package com.zsyj.fee.entity;

import java.util.ArrayList;
import java.util.List;

public class CfgTelcodeCondition {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfgTelcodeCondition() {
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

        public Criteria andTelcodeIsNull() {
            addCriterion("telCode is null");
            return (Criteria) this;
        }

        public Criteria andTelcodeIsNotNull() {
            addCriterion("telCode is not null");
            return (Criteria) this;
        }

        public Criteria andTelcodeEqualTo(String value) {
            addCriterion("telCode =", value, "telcode");
            return (Criteria) this;
        }

        public Criteria andTelcodeNotEqualTo(String value) {
            addCriterion("telCode <>", value, "telcode");
            return (Criteria) this;
        }

        public Criteria andTelcodeGreaterThan(String value) {
            addCriterion("telCode >", value, "telcode");
            return (Criteria) this;
        }

        public Criteria andTelcodeGreaterThanOrEqualTo(String value) {
            addCriterion("telCode >=", value, "telcode");
            return (Criteria) this;
        }

        public Criteria andTelcodeLessThan(String value) {
            addCriterion("telCode <", value, "telcode");
            return (Criteria) this;
        }

        public Criteria andTelcodeLessThanOrEqualTo(String value) {
            addCriterion("telCode <=", value, "telcode");
            return (Criteria) this;
        }

        public Criteria andTelcodeLike(String value) {
            addCriterion("telCode like", value, "telcode");
            return (Criteria) this;
        }

        public Criteria andTelcodeNotLike(String value) {
            addCriterion("telCode not like", value, "telcode");
            return (Criteria) this;
        }

        public Criteria andTelcodeIn(List<String> values) {
            addCriterion("telCode in", values, "telcode");
            return (Criteria) this;
        }

        public Criteria andTelcodeNotIn(List<String> values) {
            addCriterion("telCode not in", values, "telcode");
            return (Criteria) this;
        }

        public Criteria andTelcodeBetween(String value1, String value2) {
            addCriterion("telCode between", value1, value2, "telcode");
            return (Criteria) this;
        }

        public Criteria andTelcodeNotBetween(String value1, String value2) {
            addCriterion("telCode not between", value1, value2, "telcode");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andAreacodeIsNull() {
            addCriterion("areaCode is null");
            return (Criteria) this;
        }

        public Criteria andAreacodeIsNotNull() {
            addCriterion("areaCode is not null");
            return (Criteria) this;
        }

        public Criteria andAreacodeEqualTo(String value) {
            addCriterion("areaCode =", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeNotEqualTo(String value) {
            addCriterion("areaCode <>", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeGreaterThan(String value) {
            addCriterion("areaCode >", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeGreaterThanOrEqualTo(String value) {
            addCriterion("areaCode >=", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeLessThan(String value) {
            addCriterion("areaCode <", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeLessThanOrEqualTo(String value) {
            addCriterion("areaCode <=", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeLike(String value) {
            addCriterion("areaCode like", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeNotLike(String value) {
            addCriterion("areaCode not like", value, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeIn(List<String> values) {
            addCriterion("areaCode in", values, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeNotIn(List<String> values) {
            addCriterion("areaCode not in", values, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeBetween(String value1, String value2) {
            addCriterion("areaCode between", value1, value2, "areacode");
            return (Criteria) this;
        }

        public Criteria andAreacodeNotBetween(String value1, String value2) {
            addCriterion("areaCode not between", value1, value2, "areacode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeIsNull() {
            addCriterion("district_code is null");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeIsNotNull() {
            addCriterion("district_code is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeEqualTo(String value) {
            addCriterion("district_code =", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeNotEqualTo(String value) {
            addCriterion("district_code <>", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeGreaterThan(String value) {
            addCriterion("district_code >", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeGreaterThanOrEqualTo(String value) {
            addCriterion("district_code >=", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeLessThan(String value) {
            addCriterion("district_code <", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeLessThanOrEqualTo(String value) {
            addCriterion("district_code <=", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeLike(String value) {
            addCriterion("district_code like", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeNotLike(String value) {
            addCriterion("district_code not like", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeIn(List<String> values) {
            addCriterion("district_code in", values, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeNotIn(List<String> values) {
            addCriterion("district_code not in", values, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeBetween(String value1, String value2) {
            addCriterion("district_code between", value1, value2, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeNotBetween(String value1, String value2) {
            addCriterion("district_code not between", value1, value2, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeListIsNull() {
            addCriterion("district_code_list is null");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeListIsNotNull() {
            addCriterion("district_code_list is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeListEqualTo(String value) {
            addCriterion("district_code_list =", value, "districtCodeList");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeListNotEqualTo(String value) {
            addCriterion("district_code_list <>", value, "districtCodeList");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeListGreaterThan(String value) {
            addCriterion("district_code_list >", value, "districtCodeList");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeListGreaterThanOrEqualTo(String value) {
            addCriterion("district_code_list >=", value, "districtCodeList");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeListLessThan(String value) {
            addCriterion("district_code_list <", value, "districtCodeList");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeListLessThanOrEqualTo(String value) {
            addCriterion("district_code_list <=", value, "districtCodeList");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeListLike(String value) {
            addCriterion("district_code_list like", value, "districtCodeList");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeListNotLike(String value) {
            addCriterion("district_code_list not like", value, "districtCodeList");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeListIn(List<String> values) {
            addCriterion("district_code_list in", values, "districtCodeList");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeListNotIn(List<String> values) {
            addCriterion("district_code_list not in", values, "districtCodeList");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeListBetween(String value1, String value2) {
            addCriterion("district_code_list between", value1, value2, "districtCodeList");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeListNotBetween(String value1, String value2) {
            addCriterion("district_code_list not between", value1, value2, "districtCodeList");
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