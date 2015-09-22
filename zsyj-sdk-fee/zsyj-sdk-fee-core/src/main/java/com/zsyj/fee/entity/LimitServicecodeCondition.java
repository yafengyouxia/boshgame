package com.zsyj.fee.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LimitServicecodeCondition {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LimitServicecodeCondition() {
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

        public Criteria andCodeIdIsNull() {
            addCriterion("code_id is null");
            return (Criteria) this;
        }

        public Criteria andCodeIdIsNotNull() {
            addCriterion("code_id is not null");
            return (Criteria) this;
        }

        public Criteria andCodeIdEqualTo(Integer value) {
            addCriterion("code_id =", value, "codeId");
            return (Criteria) this;
        }

        public Criteria andCodeIdNotEqualTo(Integer value) {
            addCriterion("code_id <>", value, "codeId");
            return (Criteria) this;
        }

        public Criteria andCodeIdGreaterThan(Integer value) {
            addCriterion("code_id >", value, "codeId");
            return (Criteria) this;
        }

        public Criteria andCodeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("code_id >=", value, "codeId");
            return (Criteria) this;
        }

        public Criteria andCodeIdLessThan(Integer value) {
            addCriterion("code_id <", value, "codeId");
            return (Criteria) this;
        }

        public Criteria andCodeIdLessThanOrEqualTo(Integer value) {
            addCriterion("code_id <=", value, "codeId");
            return (Criteria) this;
        }

        public Criteria andCodeIdIn(List<Integer> values) {
            addCriterion("code_id in", values, "codeId");
            return (Criteria) this;
        }

        public Criteria andCodeIdNotIn(List<Integer> values) {
            addCriterion("code_id not in", values, "codeId");
            return (Criteria) this;
        }

        public Criteria andCodeIdBetween(Integer value1, Integer value2) {
            addCriterion("code_id between", value1, value2, "codeId");
            return (Criteria) this;
        }

        public Criteria andCodeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("code_id not between", value1, value2, "codeId");
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

        public Criteria andTelCodeIsNull() {
            addCriterion("tel_code is null");
            return (Criteria) this;
        }

        public Criteria andTelCodeIsNotNull() {
            addCriterion("tel_code is not null");
            return (Criteria) this;
        }

        public Criteria andTelCodeEqualTo(String value) {
            addCriterion("tel_code =", value, "telCode");
            return (Criteria) this;
        }

        public Criteria andTelCodeNotEqualTo(String value) {
            addCriterion("tel_code <>", value, "telCode");
            return (Criteria) this;
        }

        public Criteria andTelCodeGreaterThan(String value) {
            addCriterion("tel_code >", value, "telCode");
            return (Criteria) this;
        }

        public Criteria andTelCodeGreaterThanOrEqualTo(String value) {
            addCriterion("tel_code >=", value, "telCode");
            return (Criteria) this;
        }

        public Criteria andTelCodeLessThan(String value) {
            addCriterion("tel_code <", value, "telCode");
            return (Criteria) this;
        }

        public Criteria andTelCodeLessThanOrEqualTo(String value) {
            addCriterion("tel_code <=", value, "telCode");
            return (Criteria) this;
        }

        public Criteria andTelCodeLike(String value) {
            addCriterion("tel_code like", value, "telCode");
            return (Criteria) this;
        }

        public Criteria andTelCodeNotLike(String value) {
            addCriterion("tel_code not like", value, "telCode");
            return (Criteria) this;
        }

        public Criteria andTelCodeIn(List<String> values) {
            addCriterion("tel_code in", values, "telCode");
            return (Criteria) this;
        }

        public Criteria andTelCodeNotIn(List<String> values) {
            addCriterion("tel_code not in", values, "telCode");
            return (Criteria) this;
        }

        public Criteria andTelCodeBetween(String value1, String value2) {
            addCriterion("tel_code between", value1, value2, "telCode");
            return (Criteria) this;
        }

        public Criteria andTelCodeNotBetween(String value1, String value2) {
            addCriterion("tel_code not between", value1, value2, "telCode");
            return (Criteria) this;
        }

        public Criteria andLimitUserFeeMonthIsNull() {
            addCriterion("limit_user_fee_month is null");
            return (Criteria) this;
        }

        public Criteria andLimitUserFeeMonthIsNotNull() {
            addCriterion("limit_user_fee_month is not null");
            return (Criteria) this;
        }

        public Criteria andLimitUserFeeMonthEqualTo(Integer value) {
            addCriterion("limit_user_fee_month =", value, "limitUserFeeMonth");
            return (Criteria) this;
        }

        public Criteria andLimitUserFeeMonthNotEqualTo(Integer value) {
            addCriterion("limit_user_fee_month <>", value, "limitUserFeeMonth");
            return (Criteria) this;
        }

        public Criteria andLimitUserFeeMonthGreaterThan(Integer value) {
            addCriterion("limit_user_fee_month >", value, "limitUserFeeMonth");
            return (Criteria) this;
        }

        public Criteria andLimitUserFeeMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("limit_user_fee_month >=", value, "limitUserFeeMonth");
            return (Criteria) this;
        }

        public Criteria andLimitUserFeeMonthLessThan(Integer value) {
            addCriterion("limit_user_fee_month <", value, "limitUserFeeMonth");
            return (Criteria) this;
        }

        public Criteria andLimitUserFeeMonthLessThanOrEqualTo(Integer value) {
            addCriterion("limit_user_fee_month <=", value, "limitUserFeeMonth");
            return (Criteria) this;
        }

        public Criteria andLimitUserFeeMonthIn(List<Integer> values) {
            addCriterion("limit_user_fee_month in", values, "limitUserFeeMonth");
            return (Criteria) this;
        }

        public Criteria andLimitUserFeeMonthNotIn(List<Integer> values) {
            addCriterion("limit_user_fee_month not in", values, "limitUserFeeMonth");
            return (Criteria) this;
        }

        public Criteria andLimitUserFeeMonthBetween(Integer value1, Integer value2) {
            addCriterion("limit_user_fee_month between", value1, value2, "limitUserFeeMonth");
            return (Criteria) this;
        }

        public Criteria andLimitUserFeeMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("limit_user_fee_month not between", value1, value2, "limitUserFeeMonth");
            return (Criteria) this;
        }

        public Criteria andLimitUserFeeDayIsNull() {
            addCriterion("limit_user_fee_day is null");
            return (Criteria) this;
        }

        public Criteria andLimitUserFeeDayIsNotNull() {
            addCriterion("limit_user_fee_day is not null");
            return (Criteria) this;
        }

        public Criteria andLimitUserFeeDayEqualTo(Integer value) {
            addCriterion("limit_user_fee_day =", value, "limitUserFeeDay");
            return (Criteria) this;
        }

        public Criteria andLimitUserFeeDayNotEqualTo(Integer value) {
            addCriterion("limit_user_fee_day <>", value, "limitUserFeeDay");
            return (Criteria) this;
        }

        public Criteria andLimitUserFeeDayGreaterThan(Integer value) {
            addCriterion("limit_user_fee_day >", value, "limitUserFeeDay");
            return (Criteria) this;
        }

        public Criteria andLimitUserFeeDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("limit_user_fee_day >=", value, "limitUserFeeDay");
            return (Criteria) this;
        }

        public Criteria andLimitUserFeeDayLessThan(Integer value) {
            addCriterion("limit_user_fee_day <", value, "limitUserFeeDay");
            return (Criteria) this;
        }

        public Criteria andLimitUserFeeDayLessThanOrEqualTo(Integer value) {
            addCriterion("limit_user_fee_day <=", value, "limitUserFeeDay");
            return (Criteria) this;
        }

        public Criteria andLimitUserFeeDayIn(List<Integer> values) {
            addCriterion("limit_user_fee_day in", values, "limitUserFeeDay");
            return (Criteria) this;
        }

        public Criteria andLimitUserFeeDayNotIn(List<Integer> values) {
            addCriterion("limit_user_fee_day not in", values, "limitUserFeeDay");
            return (Criteria) this;
        }

        public Criteria andLimitUserFeeDayBetween(Integer value1, Integer value2) {
            addCriterion("limit_user_fee_day between", value1, value2, "limitUserFeeDay");
            return (Criteria) this;
        }

        public Criteria andLimitUserFeeDayNotBetween(Integer value1, Integer value2) {
            addCriterion("limit_user_fee_day not between", value1, value2, "limitUserFeeDay");
            return (Criteria) this;
        }

        public Criteria andLimitTotalAmountDayIsNull() {
            addCriterion("limit_total_amount_day is null");
            return (Criteria) this;
        }

        public Criteria andLimitTotalAmountDayIsNotNull() {
            addCriterion("limit_total_amount_day is not null");
            return (Criteria) this;
        }

        public Criteria andLimitTotalAmountDayEqualTo(Integer value) {
            addCriterion("limit_total_amount_day =", value, "limitTotalAmountDay");
            return (Criteria) this;
        }

        public Criteria andLimitTotalAmountDayNotEqualTo(Integer value) {
            addCriterion("limit_total_amount_day <>", value, "limitTotalAmountDay");
            return (Criteria) this;
        }

        public Criteria andLimitTotalAmountDayGreaterThan(Integer value) {
            addCriterion("limit_total_amount_day >", value, "limitTotalAmountDay");
            return (Criteria) this;
        }

        public Criteria andLimitTotalAmountDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("limit_total_amount_day >=", value, "limitTotalAmountDay");
            return (Criteria) this;
        }

        public Criteria andLimitTotalAmountDayLessThan(Integer value) {
            addCriterion("limit_total_amount_day <", value, "limitTotalAmountDay");
            return (Criteria) this;
        }

        public Criteria andLimitTotalAmountDayLessThanOrEqualTo(Integer value) {
            addCriterion("limit_total_amount_day <=", value, "limitTotalAmountDay");
            return (Criteria) this;
        }

        public Criteria andLimitTotalAmountDayIn(List<Integer> values) {
            addCriterion("limit_total_amount_day in", values, "limitTotalAmountDay");
            return (Criteria) this;
        }

        public Criteria andLimitTotalAmountDayNotIn(List<Integer> values) {
            addCriterion("limit_total_amount_day not in", values, "limitTotalAmountDay");
            return (Criteria) this;
        }

        public Criteria andLimitTotalAmountDayBetween(Integer value1, Integer value2) {
            addCriterion("limit_total_amount_day between", value1, value2, "limitTotalAmountDay");
            return (Criteria) this;
        }

        public Criteria andLimitTotalAmountDayNotBetween(Integer value1, Integer value2) {
            addCriterion("limit_total_amount_day not between", value1, value2, "limitTotalAmountDay");
            return (Criteria) this;
        }

        public Criteria andLimitTotalAmountMonthIsNull() {
            addCriterion("limit_total_amount_month is null");
            return (Criteria) this;
        }

        public Criteria andLimitTotalAmountMonthIsNotNull() {
            addCriterion("limit_total_amount_month is not null");
            return (Criteria) this;
        }

        public Criteria andLimitTotalAmountMonthEqualTo(Integer value) {
            addCriterion("limit_total_amount_month =", value, "limitTotalAmountMonth");
            return (Criteria) this;
        }

        public Criteria andLimitTotalAmountMonthNotEqualTo(Integer value) {
            addCriterion("limit_total_amount_month <>", value, "limitTotalAmountMonth");
            return (Criteria) this;
        }

        public Criteria andLimitTotalAmountMonthGreaterThan(Integer value) {
            addCriterion("limit_total_amount_month >", value, "limitTotalAmountMonth");
            return (Criteria) this;
        }

        public Criteria andLimitTotalAmountMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("limit_total_amount_month >=", value, "limitTotalAmountMonth");
            return (Criteria) this;
        }

        public Criteria andLimitTotalAmountMonthLessThan(Integer value) {
            addCriterion("limit_total_amount_month <", value, "limitTotalAmountMonth");
            return (Criteria) this;
        }

        public Criteria andLimitTotalAmountMonthLessThanOrEqualTo(Integer value) {
            addCriterion("limit_total_amount_month <=", value, "limitTotalAmountMonth");
            return (Criteria) this;
        }

        public Criteria andLimitTotalAmountMonthIn(List<Integer> values) {
            addCriterion("limit_total_amount_month in", values, "limitTotalAmountMonth");
            return (Criteria) this;
        }

        public Criteria andLimitTotalAmountMonthNotIn(List<Integer> values) {
            addCriterion("limit_total_amount_month not in", values, "limitTotalAmountMonth");
            return (Criteria) this;
        }

        public Criteria andLimitTotalAmountMonthBetween(Integer value1, Integer value2) {
            addCriterion("limit_total_amount_month between", value1, value2, "limitTotalAmountMonth");
            return (Criteria) this;
        }

        public Criteria andLimitTotalAmountMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("limit_total_amount_month not between", value1, value2, "limitTotalAmountMonth");
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

        public Criteria andSubTypeIsNull() {
            addCriterion("sub_type is null");
            return (Criteria) this;
        }

        public Criteria andSubTypeIsNotNull() {
            addCriterion("sub_type is not null");
            return (Criteria) this;
        }

        public Criteria andSubTypeEqualTo(Integer value) {
            addCriterion("sub_type =", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeNotEqualTo(Integer value) {
            addCriterion("sub_type <>", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeGreaterThan(Integer value) {
            addCriterion("sub_type >", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("sub_type >=", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeLessThan(Integer value) {
            addCriterion("sub_type <", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeLessThanOrEqualTo(Integer value) {
            addCriterion("sub_type <=", value, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeIn(List<Integer> values) {
            addCriterion("sub_type in", values, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeNotIn(List<Integer> values) {
            addCriterion("sub_type not in", values, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeBetween(Integer value1, Integer value2) {
            addCriterion("sub_type between", value1, value2, "subType");
            return (Criteria) this;
        }

        public Criteria andSubTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("sub_type not between", value1, value2, "subType");
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