package com.zsyj.fee.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SdkStrategyCondition {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SdkStrategyCondition() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andFeeLimitMonthIsNull() {
            addCriterion("fee_limit_month is null");
            return (Criteria) this;
        }

        public Criteria andFeeLimitMonthIsNotNull() {
            addCriterion("fee_limit_month is not null");
            return (Criteria) this;
        }

        public Criteria andFeeLimitMonthEqualTo(Integer value) {
            addCriterion("fee_limit_month =", value, "feeLimitMonth");
            return (Criteria) this;
        }

        public Criteria andFeeLimitMonthNotEqualTo(Integer value) {
            addCriterion("fee_limit_month <>", value, "feeLimitMonth");
            return (Criteria) this;
        }

        public Criteria andFeeLimitMonthGreaterThan(Integer value) {
            addCriterion("fee_limit_month >", value, "feeLimitMonth");
            return (Criteria) this;
        }

        public Criteria andFeeLimitMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("fee_limit_month >=", value, "feeLimitMonth");
            return (Criteria) this;
        }

        public Criteria andFeeLimitMonthLessThan(Integer value) {
            addCriterion("fee_limit_month <", value, "feeLimitMonth");
            return (Criteria) this;
        }

        public Criteria andFeeLimitMonthLessThanOrEqualTo(Integer value) {
            addCriterion("fee_limit_month <=", value, "feeLimitMonth");
            return (Criteria) this;
        }

        public Criteria andFeeLimitMonthIn(List<Integer> values) {
            addCriterion("fee_limit_month in", values, "feeLimitMonth");
            return (Criteria) this;
        }

        public Criteria andFeeLimitMonthNotIn(List<Integer> values) {
            addCriterion("fee_limit_month not in", values, "feeLimitMonth");
            return (Criteria) this;
        }

        public Criteria andFeeLimitMonthBetween(Integer value1, Integer value2) {
            addCriterion("fee_limit_month between", value1, value2, "feeLimitMonth");
            return (Criteria) this;
        }

        public Criteria andFeeLimitMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("fee_limit_month not between", value1, value2, "feeLimitMonth");
            return (Criteria) this;
        }

        public Criteria andFeeLimitDayIsNull() {
            addCriterion("fee_limit_day is null");
            return (Criteria) this;
        }

        public Criteria andFeeLimitDayIsNotNull() {
            addCriterion("fee_limit_day is not null");
            return (Criteria) this;
        }

        public Criteria andFeeLimitDayEqualTo(Integer value) {
            addCriterion("fee_limit_day =", value, "feeLimitDay");
            return (Criteria) this;
        }

        public Criteria andFeeLimitDayNotEqualTo(Integer value) {
            addCriterion("fee_limit_day <>", value, "feeLimitDay");
            return (Criteria) this;
        }

        public Criteria andFeeLimitDayGreaterThan(Integer value) {
            addCriterion("fee_limit_day >", value, "feeLimitDay");
            return (Criteria) this;
        }

        public Criteria andFeeLimitDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("fee_limit_day >=", value, "feeLimitDay");
            return (Criteria) this;
        }

        public Criteria andFeeLimitDayLessThan(Integer value) {
            addCriterion("fee_limit_day <", value, "feeLimitDay");
            return (Criteria) this;
        }

        public Criteria andFeeLimitDayLessThanOrEqualTo(Integer value) {
            addCriterion("fee_limit_day <=", value, "feeLimitDay");
            return (Criteria) this;
        }

        public Criteria andFeeLimitDayIn(List<Integer> values) {
            addCriterion("fee_limit_day in", values, "feeLimitDay");
            return (Criteria) this;
        }

        public Criteria andFeeLimitDayNotIn(List<Integer> values) {
            addCriterion("fee_limit_day not in", values, "feeLimitDay");
            return (Criteria) this;
        }

        public Criteria andFeeLimitDayBetween(Integer value1, Integer value2) {
            addCriterion("fee_limit_day between", value1, value2, "feeLimitDay");
            return (Criteria) this;
        }

        public Criteria andFeeLimitDayNotBetween(Integer value1, Integer value2) {
            addCriterion("fee_limit_day not between", value1, value2, "feeLimitDay");
            return (Criteria) this;
        }

        public Criteria andConfirmDialogTypeIsNull() {
            addCriterion("confirm_dialog_type is null");
            return (Criteria) this;
        }

        public Criteria andConfirmDialogTypeIsNotNull() {
            addCriterion("confirm_dialog_type is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmDialogTypeEqualTo(Byte value) {
            addCriterion("confirm_dialog_type =", value, "confirmDialogType");
            return (Criteria) this;
        }

        public Criteria andConfirmDialogTypeNotEqualTo(Byte value) {
            addCriterion("confirm_dialog_type <>", value, "confirmDialogType");
            return (Criteria) this;
        }

        public Criteria andConfirmDialogTypeGreaterThan(Byte value) {
            addCriterion("confirm_dialog_type >", value, "confirmDialogType");
            return (Criteria) this;
        }

        public Criteria andConfirmDialogTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("confirm_dialog_type >=", value, "confirmDialogType");
            return (Criteria) this;
        }

        public Criteria andConfirmDialogTypeLessThan(Byte value) {
            addCriterion("confirm_dialog_type <", value, "confirmDialogType");
            return (Criteria) this;
        }

        public Criteria andConfirmDialogTypeLessThanOrEqualTo(Byte value) {
            addCriterion("confirm_dialog_type <=", value, "confirmDialogType");
            return (Criteria) this;
        }

        public Criteria andConfirmDialogTypeIn(List<Byte> values) {
            addCriterion("confirm_dialog_type in", values, "confirmDialogType");
            return (Criteria) this;
        }

        public Criteria andConfirmDialogTypeNotIn(List<Byte> values) {
            addCriterion("confirm_dialog_type not in", values, "confirmDialogType");
            return (Criteria) this;
        }

        public Criteria andConfirmDialogTypeBetween(Byte value1, Byte value2) {
            addCriterion("confirm_dialog_type between", value1, value2, "confirmDialogType");
            return (Criteria) this;
        }

        public Criteria andConfirmDialogTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("confirm_dialog_type not between", value1, value2, "confirmDialogType");
            return (Criteria) this;
        }

        public Criteria andResultDialogTypeIsNull() {
            addCriterion("result_dialog_type is null");
            return (Criteria) this;
        }

        public Criteria andResultDialogTypeIsNotNull() {
            addCriterion("result_dialog_type is not null");
            return (Criteria) this;
        }

        public Criteria andResultDialogTypeEqualTo(Byte value) {
            addCriterion("result_dialog_type =", value, "resultDialogType");
            return (Criteria) this;
        }

        public Criteria andResultDialogTypeNotEqualTo(Byte value) {
            addCriterion("result_dialog_type <>", value, "resultDialogType");
            return (Criteria) this;
        }

        public Criteria andResultDialogTypeGreaterThan(Byte value) {
            addCriterion("result_dialog_type >", value, "resultDialogType");
            return (Criteria) this;
        }

        public Criteria andResultDialogTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("result_dialog_type >=", value, "resultDialogType");
            return (Criteria) this;
        }

        public Criteria andResultDialogTypeLessThan(Byte value) {
            addCriterion("result_dialog_type <", value, "resultDialogType");
            return (Criteria) this;
        }

        public Criteria andResultDialogTypeLessThanOrEqualTo(Byte value) {
            addCriterion("result_dialog_type <=", value, "resultDialogType");
            return (Criteria) this;
        }

        public Criteria andResultDialogTypeIn(List<Byte> values) {
            addCriterion("result_dialog_type in", values, "resultDialogType");
            return (Criteria) this;
        }

        public Criteria andResultDialogTypeNotIn(List<Byte> values) {
            addCriterion("result_dialog_type not in", values, "resultDialogType");
            return (Criteria) this;
        }

        public Criteria andResultDialogTypeBetween(Byte value1, Byte value2) {
            addCriterion("result_dialog_type between", value1, value2, "resultDialogType");
            return (Criteria) this;
        }

        public Criteria andResultDialogTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("result_dialog_type not between", value1, value2, "resultDialogType");
            return (Criteria) this;
        }

        public Criteria andItemForFailresultIsNull() {
            addCriterion("item_for_failresult is null");
            return (Criteria) this;
        }

        public Criteria andItemForFailresultIsNotNull() {
            addCriterion("item_for_failresult is not null");
            return (Criteria) this;
        }

        public Criteria andItemForFailresultEqualTo(Boolean value) {
            addCriterion("item_for_failresult =", value, "itemForFailresult");
            return (Criteria) this;
        }

        public Criteria andItemForFailresultNotEqualTo(Boolean value) {
            addCriterion("item_for_failresult <>", value, "itemForFailresult");
            return (Criteria) this;
        }

        public Criteria andItemForFailresultGreaterThan(Boolean value) {
            addCriterion("item_for_failresult >", value, "itemForFailresult");
            return (Criteria) this;
        }

        public Criteria andItemForFailresultGreaterThanOrEqualTo(Boolean value) {
            addCriterion("item_for_failresult >=", value, "itemForFailresult");
            return (Criteria) this;
        }

        public Criteria andItemForFailresultLessThan(Boolean value) {
            addCriterion("item_for_failresult <", value, "itemForFailresult");
            return (Criteria) this;
        }

        public Criteria andItemForFailresultLessThanOrEqualTo(Boolean value) {
            addCriterion("item_for_failresult <=", value, "itemForFailresult");
            return (Criteria) this;
        }

        public Criteria andItemForFailresultIn(List<Boolean> values) {
            addCriterion("item_for_failresult in", values, "itemForFailresult");
            return (Criteria) this;
        }

        public Criteria andItemForFailresultNotIn(List<Boolean> values) {
            addCriterion("item_for_failresult not in", values, "itemForFailresult");
            return (Criteria) this;
        }

        public Criteria andItemForFailresultBetween(Boolean value1, Boolean value2) {
            addCriterion("item_for_failresult between", value1, value2, "itemForFailresult");
            return (Criteria) this;
        }

        public Criteria andItemForFailresultNotBetween(Boolean value1, Boolean value2) {
            addCriterion("item_for_failresult not between", value1, value2, "itemForFailresult");
            return (Criteria) this;
        }

        public Criteria andIsFreshOneIsNull() {
            addCriterion("is_fresh_one is null");
            return (Criteria) this;
        }

        public Criteria andIsFreshOneIsNotNull() {
            addCriterion("is_fresh_one is not null");
            return (Criteria) this;
        }

        public Criteria andIsFreshOneEqualTo(Byte value) {
            addCriterion("is_fresh_one =", value, "isFreshOne");
            return (Criteria) this;
        }

        public Criteria andIsFreshOneNotEqualTo(Byte value) {
            addCriterion("is_fresh_one <>", value, "isFreshOne");
            return (Criteria) this;
        }

        public Criteria andIsFreshOneGreaterThan(Byte value) {
            addCriterion("is_fresh_one >", value, "isFreshOne");
            return (Criteria) this;
        }

        public Criteria andIsFreshOneGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_fresh_one >=", value, "isFreshOne");
            return (Criteria) this;
        }

        public Criteria andIsFreshOneLessThan(Byte value) {
            addCriterion("is_fresh_one <", value, "isFreshOne");
            return (Criteria) this;
        }

        public Criteria andIsFreshOneLessThanOrEqualTo(Byte value) {
            addCriterion("is_fresh_one <=", value, "isFreshOne");
            return (Criteria) this;
        }

        public Criteria andIsFreshOneIn(List<Byte> values) {
            addCriterion("is_fresh_one in", values, "isFreshOne");
            return (Criteria) this;
        }

        public Criteria andIsFreshOneNotIn(List<Byte> values) {
            addCriterion("is_fresh_one not in", values, "isFreshOne");
            return (Criteria) this;
        }

        public Criteria andIsFreshOneBetween(Byte value1, Byte value2) {
            addCriterion("is_fresh_one between", value1, value2, "isFreshOne");
            return (Criteria) this;
        }

        public Criteria andIsFreshOneNotBetween(Byte value1, Byte value2) {
            addCriterion("is_fresh_one not between", value1, value2, "isFreshOne");
            return (Criteria) this;
        }

        public Criteria andFeeDetailIsNull() {
            addCriterion("fee_detail is null");
            return (Criteria) this;
        }

        public Criteria andFeeDetailIsNotNull() {
            addCriterion("fee_detail is not null");
            return (Criteria) this;
        }

        public Criteria andFeeDetailEqualTo(String value) {
            addCriterion("fee_detail =", value, "feeDetail");
            return (Criteria) this;
        }

        public Criteria andFeeDetailNotEqualTo(String value) {
            addCriterion("fee_detail <>", value, "feeDetail");
            return (Criteria) this;
        }

        public Criteria andFeeDetailGreaterThan(String value) {
            addCriterion("fee_detail >", value, "feeDetail");
            return (Criteria) this;
        }

        public Criteria andFeeDetailGreaterThanOrEqualTo(String value) {
            addCriterion("fee_detail >=", value, "feeDetail");
            return (Criteria) this;
        }

        public Criteria andFeeDetailLessThan(String value) {
            addCriterion("fee_detail <", value, "feeDetail");
            return (Criteria) this;
        }

        public Criteria andFeeDetailLessThanOrEqualTo(String value) {
            addCriterion("fee_detail <=", value, "feeDetail");
            return (Criteria) this;
        }

        public Criteria andFeeDetailLike(String value) {
            addCriterion("fee_detail like", value, "feeDetail");
            return (Criteria) this;
        }

        public Criteria andFeeDetailNotLike(String value) {
            addCriterion("fee_detail not like", value, "feeDetail");
            return (Criteria) this;
        }

        public Criteria andFeeDetailIn(List<String> values) {
            addCriterion("fee_detail in", values, "feeDetail");
            return (Criteria) this;
        }

        public Criteria andFeeDetailNotIn(List<String> values) {
            addCriterion("fee_detail not in", values, "feeDetail");
            return (Criteria) this;
        }

        public Criteria andFeeDetailBetween(String value1, String value2) {
            addCriterion("fee_detail between", value1, value2, "feeDetail");
            return (Criteria) this;
        }

        public Criteria andFeeDetailNotBetween(String value1, String value2) {
            addCriterion("fee_detail not between", value1, value2, "feeDetail");
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