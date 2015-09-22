package com.zsyj.fee.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CfgSpCompanyCondition {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfgSpCompanyCondition() {
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

        public Criteria andSpSidIsNull() {
            addCriterion("sp_sid is null");
            return (Criteria) this;
        }

        public Criteria andSpSidIsNotNull() {
            addCriterion("sp_sid is not null");
            return (Criteria) this;
        }

        public Criteria andSpSidEqualTo(Integer value) {
            addCriterion("sp_sid =", value, "spSid");
            return (Criteria) this;
        }

        public Criteria andSpSidNotEqualTo(Integer value) {
            addCriterion("sp_sid <>", value, "spSid");
            return (Criteria) this;
        }

        public Criteria andSpSidGreaterThan(Integer value) {
            addCriterion("sp_sid >", value, "spSid");
            return (Criteria) this;
        }

        public Criteria andSpSidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sp_sid >=", value, "spSid");
            return (Criteria) this;
        }

        public Criteria andSpSidLessThan(Integer value) {
            addCriterion("sp_sid <", value, "spSid");
            return (Criteria) this;
        }

        public Criteria andSpSidLessThanOrEqualTo(Integer value) {
            addCriterion("sp_sid <=", value, "spSid");
            return (Criteria) this;
        }

        public Criteria andSpSidIn(List<Integer> values) {
            addCriterion("sp_sid in", values, "spSid");
            return (Criteria) this;
        }

        public Criteria andSpSidNotIn(List<Integer> values) {
            addCriterion("sp_sid not in", values, "spSid");
            return (Criteria) this;
        }

        public Criteria andSpSidBetween(Integer value1, Integer value2) {
            addCriterion("sp_sid between", value1, value2, "spSid");
            return (Criteria) this;
        }

        public Criteria andSpSidNotBetween(Integer value1, Integer value2) {
            addCriterion("sp_sid not between", value1, value2, "spSid");
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

        public Criteria andLogtimeIsNull() {
            addCriterion("logtime is null");
            return (Criteria) this;
        }

        public Criteria andLogtimeIsNotNull() {
            addCriterion("logtime is not null");
            return (Criteria) this;
        }

        public Criteria andLogtimeEqualTo(Date value) {
            addCriterion("logtime =", value, "logtime");
            return (Criteria) this;
        }

        public Criteria andLogtimeNotEqualTo(Date value) {
            addCriterion("logtime <>", value, "logtime");
            return (Criteria) this;
        }

        public Criteria andLogtimeGreaterThan(Date value) {
            addCriterion("logtime >", value, "logtime");
            return (Criteria) this;
        }

        public Criteria andLogtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("logtime >=", value, "logtime");
            return (Criteria) this;
        }

        public Criteria andLogtimeLessThan(Date value) {
            addCriterion("logtime <", value, "logtime");
            return (Criteria) this;
        }

        public Criteria andLogtimeLessThanOrEqualTo(Date value) {
            addCriterion("logtime <=", value, "logtime");
            return (Criteria) this;
        }

        public Criteria andLogtimeIn(List<Date> values) {
            addCriterion("logtime in", values, "logtime");
            return (Criteria) this;
        }

        public Criteria andLogtimeNotIn(List<Date> values) {
            addCriterion("logtime not in", values, "logtime");
            return (Criteria) this;
        }

        public Criteria andLogtimeBetween(Date value1, Date value2) {
            addCriterion("logtime between", value1, value2, "logtime");
            return (Criteria) this;
        }

        public Criteria andLogtimeNotBetween(Date value1, Date value2) {
            addCriterion("logtime not between", value1, value2, "logtime");
            return (Criteria) this;
        }

        public Criteria andFullnameIsNull() {
            addCriterion("fullname is null");
            return (Criteria) this;
        }

        public Criteria andFullnameIsNotNull() {
            addCriterion("fullname is not null");
            return (Criteria) this;
        }

        public Criteria andFullnameEqualTo(String value) {
            addCriterion("fullname =", value, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameNotEqualTo(String value) {
            addCriterion("fullname <>", value, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameGreaterThan(String value) {
            addCriterion("fullname >", value, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameGreaterThanOrEqualTo(String value) {
            addCriterion("fullname >=", value, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameLessThan(String value) {
            addCriterion("fullname <", value, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameLessThanOrEqualTo(String value) {
            addCriterion("fullname <=", value, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameLike(String value) {
            addCriterion("fullname like", value, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameNotLike(String value) {
            addCriterion("fullname not like", value, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameIn(List<String> values) {
            addCriterion("fullname in", values, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameNotIn(List<String> values) {
            addCriterion("fullname not in", values, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameBetween(String value1, String value2) {
            addCriterion("fullname between", value1, value2, "fullname");
            return (Criteria) this;
        }

        public Criteria andFullnameNotBetween(String value1, String value2) {
            addCriterion("fullname not between", value1, value2, "fullname");
            return (Criteria) this;
        }

        public Criteria andLimitDayIsNull() {
            addCriterion("limit_day is null");
            return (Criteria) this;
        }

        public Criteria andLimitDayIsNotNull() {
            addCriterion("limit_day is not null");
            return (Criteria) this;
        }

        public Criteria andLimitDayEqualTo(Integer value) {
            addCriterion("limit_day =", value, "limitDay");
            return (Criteria) this;
        }

        public Criteria andLimitDayNotEqualTo(Integer value) {
            addCriterion("limit_day <>", value, "limitDay");
            return (Criteria) this;
        }

        public Criteria andLimitDayGreaterThan(Integer value) {
            addCriterion("limit_day >", value, "limitDay");
            return (Criteria) this;
        }

        public Criteria andLimitDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("limit_day >=", value, "limitDay");
            return (Criteria) this;
        }

        public Criteria andLimitDayLessThan(Integer value) {
            addCriterion("limit_day <", value, "limitDay");
            return (Criteria) this;
        }

        public Criteria andLimitDayLessThanOrEqualTo(Integer value) {
            addCriterion("limit_day <=", value, "limitDay");
            return (Criteria) this;
        }

        public Criteria andLimitDayIn(List<Integer> values) {
            addCriterion("limit_day in", values, "limitDay");
            return (Criteria) this;
        }

        public Criteria andLimitDayNotIn(List<Integer> values) {
            addCriterion("limit_day not in", values, "limitDay");
            return (Criteria) this;
        }

        public Criteria andLimitDayBetween(Integer value1, Integer value2) {
            addCriterion("limit_day between", value1, value2, "limitDay");
            return (Criteria) this;
        }

        public Criteria andLimitDayNotBetween(Integer value1, Integer value2) {
            addCriterion("limit_day not between", value1, value2, "limitDay");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTechnologyIsNull() {
            addCriterion("technology is null");
            return (Criteria) this;
        }

        public Criteria andTechnologyIsNotNull() {
            addCriterion("technology is not null");
            return (Criteria) this;
        }

        public Criteria andTechnologyEqualTo(String value) {
            addCriterion("technology =", value, "technology");
            return (Criteria) this;
        }

        public Criteria andTechnologyNotEqualTo(String value) {
            addCriterion("technology <>", value, "technology");
            return (Criteria) this;
        }

        public Criteria andTechnologyGreaterThan(String value) {
            addCriterion("technology >", value, "technology");
            return (Criteria) this;
        }

        public Criteria andTechnologyGreaterThanOrEqualTo(String value) {
            addCriterion("technology >=", value, "technology");
            return (Criteria) this;
        }

        public Criteria andTechnologyLessThan(String value) {
            addCriterion("technology <", value, "technology");
            return (Criteria) this;
        }

        public Criteria andTechnologyLessThanOrEqualTo(String value) {
            addCriterion("technology <=", value, "technology");
            return (Criteria) this;
        }

        public Criteria andTechnologyLike(String value) {
            addCriterion("technology like", value, "technology");
            return (Criteria) this;
        }

        public Criteria andTechnologyNotLike(String value) {
            addCriterion("technology not like", value, "technology");
            return (Criteria) this;
        }

        public Criteria andTechnologyIn(List<String> values) {
            addCriterion("technology in", values, "technology");
            return (Criteria) this;
        }

        public Criteria andTechnologyNotIn(List<String> values) {
            addCriterion("technology not in", values, "technology");
            return (Criteria) this;
        }

        public Criteria andTechnologyBetween(String value1, String value2) {
            addCriterion("technology between", value1, value2, "technology");
            return (Criteria) this;
        }

        public Criteria andTechnologyNotBetween(String value1, String value2) {
            addCriterion("technology not between", value1, value2, "technology");
            return (Criteria) this;
        }

        public Criteria andBusinessmanIsNull() {
            addCriterion("businessman is null");
            return (Criteria) this;
        }

        public Criteria andBusinessmanIsNotNull() {
            addCriterion("businessman is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessmanEqualTo(String value) {
            addCriterion("businessman =", value, "businessman");
            return (Criteria) this;
        }

        public Criteria andBusinessmanNotEqualTo(String value) {
            addCriterion("businessman <>", value, "businessman");
            return (Criteria) this;
        }

        public Criteria andBusinessmanGreaterThan(String value) {
            addCriterion("businessman >", value, "businessman");
            return (Criteria) this;
        }

        public Criteria andBusinessmanGreaterThanOrEqualTo(String value) {
            addCriterion("businessman >=", value, "businessman");
            return (Criteria) this;
        }

        public Criteria andBusinessmanLessThan(String value) {
            addCriterion("businessman <", value, "businessman");
            return (Criteria) this;
        }

        public Criteria andBusinessmanLessThanOrEqualTo(String value) {
            addCriterion("businessman <=", value, "businessman");
            return (Criteria) this;
        }

        public Criteria andBusinessmanLike(String value) {
            addCriterion("businessman like", value, "businessman");
            return (Criteria) this;
        }

        public Criteria andBusinessmanNotLike(String value) {
            addCriterion("businessman not like", value, "businessman");
            return (Criteria) this;
        }

        public Criteria andBusinessmanIn(List<String> values) {
            addCriterion("businessman in", values, "businessman");
            return (Criteria) this;
        }

        public Criteria andBusinessmanNotIn(List<String> values) {
            addCriterion("businessman not in", values, "businessman");
            return (Criteria) this;
        }

        public Criteria andBusinessmanBetween(String value1, String value2) {
            addCriterion("businessman between", value1, value2, "businessman");
            return (Criteria) this;
        }

        public Criteria andBusinessmanNotBetween(String value1, String value2) {
            addCriterion("businessman not between", value1, value2, "businessman");
            return (Criteria) this;
        }

        public Criteria andTechContactIsNull() {
            addCriterion("tech_contact is null");
            return (Criteria) this;
        }

        public Criteria andTechContactIsNotNull() {
            addCriterion("tech_contact is not null");
            return (Criteria) this;
        }

        public Criteria andTechContactEqualTo(String value) {
            addCriterion("tech_contact =", value, "techContact");
            return (Criteria) this;
        }

        public Criteria andTechContactNotEqualTo(String value) {
            addCriterion("tech_contact <>", value, "techContact");
            return (Criteria) this;
        }

        public Criteria andTechContactGreaterThan(String value) {
            addCriterion("tech_contact >", value, "techContact");
            return (Criteria) this;
        }

        public Criteria andTechContactGreaterThanOrEqualTo(String value) {
            addCriterion("tech_contact >=", value, "techContact");
            return (Criteria) this;
        }

        public Criteria andTechContactLessThan(String value) {
            addCriterion("tech_contact <", value, "techContact");
            return (Criteria) this;
        }

        public Criteria andTechContactLessThanOrEqualTo(String value) {
            addCriterion("tech_contact <=", value, "techContact");
            return (Criteria) this;
        }

        public Criteria andTechContactLike(String value) {
            addCriterion("tech_contact like", value, "techContact");
            return (Criteria) this;
        }

        public Criteria andTechContactNotLike(String value) {
            addCriterion("tech_contact not like", value, "techContact");
            return (Criteria) this;
        }

        public Criteria andTechContactIn(List<String> values) {
            addCriterion("tech_contact in", values, "techContact");
            return (Criteria) this;
        }

        public Criteria andTechContactNotIn(List<String> values) {
            addCriterion("tech_contact not in", values, "techContact");
            return (Criteria) this;
        }

        public Criteria andTechContactBetween(String value1, String value2) {
            addCriterion("tech_contact between", value1, value2, "techContact");
            return (Criteria) this;
        }

        public Criteria andTechContactNotBetween(String value1, String value2) {
            addCriterion("tech_contact not between", value1, value2, "techContact");
            return (Criteria) this;
        }

        public Criteria andMasterIdIsNull() {
            addCriterion("master_id is null");
            return (Criteria) this;
        }

        public Criteria andMasterIdIsNotNull() {
            addCriterion("master_id is not null");
            return (Criteria) this;
        }

        public Criteria andMasterIdEqualTo(String value) {
            addCriterion("master_id =", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdNotEqualTo(String value) {
            addCriterion("master_id <>", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdGreaterThan(String value) {
            addCriterion("master_id >", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdGreaterThanOrEqualTo(String value) {
            addCriterion("master_id >=", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdLessThan(String value) {
            addCriterion("master_id <", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdLessThanOrEqualTo(String value) {
            addCriterion("master_id <=", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdLike(String value) {
            addCriterion("master_id like", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdNotLike(String value) {
            addCriterion("master_id not like", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdIn(List<String> values) {
            addCriterion("master_id in", values, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdNotIn(List<String> values) {
            addCriterion("master_id not in", values, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdBetween(String value1, String value2) {
            addCriterion("master_id between", value1, value2, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdNotBetween(String value1, String value2) {
            addCriterion("master_id not between", value1, value2, "masterId");
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