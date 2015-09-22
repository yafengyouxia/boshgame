package com.zsyj.fee.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CfgIvrsCondition {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfgIvrsCondition() {
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

        public Criteria andTroneIsNull() {
            addCriterion("trone is null");
            return (Criteria) this;
        }

        public Criteria andTroneIsNotNull() {
            addCriterion("trone is not null");
            return (Criteria) this;
        }

        public Criteria andTroneEqualTo(String value) {
            addCriterion("trone =", value, "trone");
            return (Criteria) this;
        }

        public Criteria andTroneNotEqualTo(String value) {
            addCriterion("trone <>", value, "trone");
            return (Criteria) this;
        }

        public Criteria andTroneGreaterThan(String value) {
            addCriterion("trone >", value, "trone");
            return (Criteria) this;
        }

        public Criteria andTroneGreaterThanOrEqualTo(String value) {
            addCriterion("trone >=", value, "trone");
            return (Criteria) this;
        }

        public Criteria andTroneLessThan(String value) {
            addCriterion("trone <", value, "trone");
            return (Criteria) this;
        }

        public Criteria andTroneLessThanOrEqualTo(String value) {
            addCriterion("trone <=", value, "trone");
            return (Criteria) this;
        }

        public Criteria andTroneLike(String value) {
            addCriterion("trone like", value, "trone");
            return (Criteria) this;
        }

        public Criteria andTroneNotLike(String value) {
            addCriterion("trone not like", value, "trone");
            return (Criteria) this;
        }

        public Criteria andTroneIn(List<String> values) {
            addCriterion("trone in", values, "trone");
            return (Criteria) this;
        }

        public Criteria andTroneNotIn(List<String> values) {
            addCriterion("trone not in", values, "trone");
            return (Criteria) this;
        }

        public Criteria andTroneBetween(String value1, String value2) {
            addCriterion("trone between", value1, value2, "trone");
            return (Criteria) this;
        }

        public Criteria andTroneNotBetween(String value1, String value2) {
            addCriterion("trone not between", value1, value2, "trone");
            return (Criteria) this;
        }

        public Criteria andCommandIsNull() {
            addCriterion("command is null");
            return (Criteria) this;
        }

        public Criteria andCommandIsNotNull() {
            addCriterion("command is not null");
            return (Criteria) this;
        }

        public Criteria andCommandEqualTo(String value) {
            addCriterion("command =", value, "command");
            return (Criteria) this;
        }

        public Criteria andCommandNotEqualTo(String value) {
            addCriterion("command <>", value, "command");
            return (Criteria) this;
        }

        public Criteria andCommandGreaterThan(String value) {
            addCriterion("command >", value, "command");
            return (Criteria) this;
        }

        public Criteria andCommandGreaterThanOrEqualTo(String value) {
            addCriterion("command >=", value, "command");
            return (Criteria) this;
        }

        public Criteria andCommandLessThan(String value) {
            addCriterion("command <", value, "command");
            return (Criteria) this;
        }

        public Criteria andCommandLessThanOrEqualTo(String value) {
            addCriterion("command <=", value, "command");
            return (Criteria) this;
        }

        public Criteria andCommandLike(String value) {
            addCriterion("command like", value, "command");
            return (Criteria) this;
        }

        public Criteria andCommandNotLike(String value) {
            addCriterion("command not like", value, "command");
            return (Criteria) this;
        }

        public Criteria andCommandIn(List<String> values) {
            addCriterion("command in", values, "command");
            return (Criteria) this;
        }

        public Criteria andCommandNotIn(List<String> values) {
            addCriterion("command not in", values, "command");
            return (Criteria) this;
        }

        public Criteria andCommandBetween(String value1, String value2) {
            addCriterion("command between", value1, value2, "command");
            return (Criteria) this;
        }

        public Criteria andCommandNotBetween(String value1, String value2) {
            addCriterion("command not between", value1, value2, "command");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andServiceNameIsNull() {
            addCriterion("service_name is null");
            return (Criteria) this;
        }

        public Criteria andServiceNameIsNotNull() {
            addCriterion("service_name is not null");
            return (Criteria) this;
        }

        public Criteria andServiceNameEqualTo(String value) {
            addCriterion("service_name =", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotEqualTo(String value) {
            addCriterion("service_name <>", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameGreaterThan(String value) {
            addCriterion("service_name >", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameGreaterThanOrEqualTo(String value) {
            addCriterion("service_name >=", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLessThan(String value) {
            addCriterion("service_name <", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLessThanOrEqualTo(String value) {
            addCriterion("service_name <=", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLike(String value) {
            addCriterion("service_name like", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotLike(String value) {
            addCriterion("service_name not like", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameIn(List<String> values) {
            addCriterion("service_name in", values, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotIn(List<String> values) {
            addCriterion("service_name not in", values, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameBetween(String value1, String value2) {
            addCriterion("service_name between", value1, value2, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotBetween(String value1, String value2) {
            addCriterion("service_name not between", value1, value2, "serviceName");
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

        public Criteria andDeleteInfoIsNull() {
            addCriterion("delete_info is null");
            return (Criteria) this;
        }

        public Criteria andDeleteInfoIsNotNull() {
            addCriterion("delete_info is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteInfoEqualTo(String value) {
            addCriterion("delete_info =", value, "deleteInfo");
            return (Criteria) this;
        }

        public Criteria andDeleteInfoNotEqualTo(String value) {
            addCriterion("delete_info <>", value, "deleteInfo");
            return (Criteria) this;
        }

        public Criteria andDeleteInfoGreaterThan(String value) {
            addCriterion("delete_info >", value, "deleteInfo");
            return (Criteria) this;
        }

        public Criteria andDeleteInfoGreaterThanOrEqualTo(String value) {
            addCriterion("delete_info >=", value, "deleteInfo");
            return (Criteria) this;
        }

        public Criteria andDeleteInfoLessThan(String value) {
            addCriterion("delete_info <", value, "deleteInfo");
            return (Criteria) this;
        }

        public Criteria andDeleteInfoLessThanOrEqualTo(String value) {
            addCriterion("delete_info <=", value, "deleteInfo");
            return (Criteria) this;
        }

        public Criteria andDeleteInfoLike(String value) {
            addCriterion("delete_info like", value, "deleteInfo");
            return (Criteria) this;
        }

        public Criteria andDeleteInfoNotLike(String value) {
            addCriterion("delete_info not like", value, "deleteInfo");
            return (Criteria) this;
        }

        public Criteria andDeleteInfoIn(List<String> values) {
            addCriterion("delete_info in", values, "deleteInfo");
            return (Criteria) this;
        }

        public Criteria andDeleteInfoNotIn(List<String> values) {
            addCriterion("delete_info not in", values, "deleteInfo");
            return (Criteria) this;
        }

        public Criteria andDeleteInfoBetween(String value1, String value2) {
            addCriterion("delete_info between", value1, value2, "deleteInfo");
            return (Criteria) this;
        }

        public Criteria andDeleteInfoNotBetween(String value1, String value2) {
            addCriterion("delete_info not between", value1, value2, "deleteInfo");
            return (Criteria) this;
        }

        public Criteria andDeleteNoIsNull() {
            addCriterion("delete_no is null");
            return (Criteria) this;
        }

        public Criteria andDeleteNoIsNotNull() {
            addCriterion("delete_no is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteNoEqualTo(String value) {
            addCriterion("delete_no =", value, "deleteNo");
            return (Criteria) this;
        }

        public Criteria andDeleteNoNotEqualTo(String value) {
            addCriterion("delete_no <>", value, "deleteNo");
            return (Criteria) this;
        }

        public Criteria andDeleteNoGreaterThan(String value) {
            addCriterion("delete_no >", value, "deleteNo");
            return (Criteria) this;
        }

        public Criteria andDeleteNoGreaterThanOrEqualTo(String value) {
            addCriterion("delete_no >=", value, "deleteNo");
            return (Criteria) this;
        }

        public Criteria andDeleteNoLessThan(String value) {
            addCriterion("delete_no <", value, "deleteNo");
            return (Criteria) this;
        }

        public Criteria andDeleteNoLessThanOrEqualTo(String value) {
            addCriterion("delete_no <=", value, "deleteNo");
            return (Criteria) this;
        }

        public Criteria andDeleteNoLike(String value) {
            addCriterion("delete_no like", value, "deleteNo");
            return (Criteria) this;
        }

        public Criteria andDeleteNoNotLike(String value) {
            addCriterion("delete_no not like", value, "deleteNo");
            return (Criteria) this;
        }

        public Criteria andDeleteNoIn(List<String> values) {
            addCriterion("delete_no in", values, "deleteNo");
            return (Criteria) this;
        }

        public Criteria andDeleteNoNotIn(List<String> values) {
            addCriterion("delete_no not in", values, "deleteNo");
            return (Criteria) this;
        }

        public Criteria andDeleteNoBetween(String value1, String value2) {
            addCriterion("delete_no between", value1, value2, "deleteNo");
            return (Criteria) this;
        }

        public Criteria andDeleteNoNotBetween(String value1, String value2) {
            addCriterion("delete_no not between", value1, value2, "deleteNo");
            return (Criteria) this;
        }

        public Criteria andTroneTypeIsNull() {
            addCriterion("trone_type is null");
            return (Criteria) this;
        }

        public Criteria andTroneTypeIsNotNull() {
            addCriterion("trone_type is not null");
            return (Criteria) this;
        }

        public Criteria andTroneTypeEqualTo(String value) {
            addCriterion("trone_type =", value, "troneType");
            return (Criteria) this;
        }

        public Criteria andTroneTypeNotEqualTo(String value) {
            addCriterion("trone_type <>", value, "troneType");
            return (Criteria) this;
        }

        public Criteria andTroneTypeGreaterThan(String value) {
            addCriterion("trone_type >", value, "troneType");
            return (Criteria) this;
        }

        public Criteria andTroneTypeGreaterThanOrEqualTo(String value) {
            addCriterion("trone_type >=", value, "troneType");
            return (Criteria) this;
        }

        public Criteria andTroneTypeLessThan(String value) {
            addCriterion("trone_type <", value, "troneType");
            return (Criteria) this;
        }

        public Criteria andTroneTypeLessThanOrEqualTo(String value) {
            addCriterion("trone_type <=", value, "troneType");
            return (Criteria) this;
        }

        public Criteria andTroneTypeLike(String value) {
            addCriterion("trone_type like", value, "troneType");
            return (Criteria) this;
        }

        public Criteria andTroneTypeNotLike(String value) {
            addCriterion("trone_type not like", value, "troneType");
            return (Criteria) this;
        }

        public Criteria andTroneTypeIn(List<String> values) {
            addCriterion("trone_type in", values, "troneType");
            return (Criteria) this;
        }

        public Criteria andTroneTypeNotIn(List<String> values) {
            addCriterion("trone_type not in", values, "troneType");
            return (Criteria) this;
        }

        public Criteria andTroneTypeBetween(String value1, String value2) {
            addCriterion("trone_type between", value1, value2, "troneType");
            return (Criteria) this;
        }

        public Criteria andTroneTypeNotBetween(String value1, String value2) {
            addCriterion("trone_type not between", value1, value2, "troneType");
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