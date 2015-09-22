package com.zsyj.fee.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CfgSdkTroneCondition {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfgSdkTroneCondition() {
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

        public Criteria andTroneStrategyIdIsNull() {
            addCriterion("trone_strategy_id is null");
            return (Criteria) this;
        }

        public Criteria andTroneStrategyIdIsNotNull() {
            addCriterion("trone_strategy_id is not null");
            return (Criteria) this;
        }

        public Criteria andTroneStrategyIdEqualTo(Integer value) {
            addCriterion("trone_strategy_id =", value, "troneStrategyId");
            return (Criteria) this;
        }

        public Criteria andTroneStrategyIdNotEqualTo(Integer value) {
            addCriterion("trone_strategy_id <>", value, "troneStrategyId");
            return (Criteria) this;
        }

        public Criteria andTroneStrategyIdGreaterThan(Integer value) {
            addCriterion("trone_strategy_id >", value, "troneStrategyId");
            return (Criteria) this;
        }

        public Criteria andTroneStrategyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("trone_strategy_id >=", value, "troneStrategyId");
            return (Criteria) this;
        }

        public Criteria andTroneStrategyIdLessThan(Integer value) {
            addCriterion("trone_strategy_id <", value, "troneStrategyId");
            return (Criteria) this;
        }

        public Criteria andTroneStrategyIdLessThanOrEqualTo(Integer value) {
            addCriterion("trone_strategy_id <=", value, "troneStrategyId");
            return (Criteria) this;
        }

        public Criteria andTroneStrategyIdIn(List<Integer> values) {
            addCriterion("trone_strategy_id in", values, "troneStrategyId");
            return (Criteria) this;
        }

        public Criteria andTroneStrategyIdNotIn(List<Integer> values) {
            addCriterion("trone_strategy_id not in", values, "troneStrategyId");
            return (Criteria) this;
        }

        public Criteria andTroneStrategyIdBetween(Integer value1, Integer value2) {
            addCriterion("trone_strategy_id between", value1, value2, "troneStrategyId");
            return (Criteria) this;
        }

        public Criteria andTroneStrategyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("trone_strategy_id not between", value1, value2, "troneStrategyId");
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

        public Criteria andFeeIsNull() {
            addCriterion("fee is null");
            return (Criteria) this;
        }

        public Criteria andFeeIsNotNull() {
            addCriterion("fee is not null");
            return (Criteria) this;
        }

        public Criteria andFeeEqualTo(Double value) {
            addCriterion("fee =", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotEqualTo(Double value) {
            addCriterion("fee <>", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThan(Double value) {
            addCriterion("fee >", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThanOrEqualTo(Double value) {
            addCriterion("fee >=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThan(Double value) {
            addCriterion("fee <", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThanOrEqualTo(Double value) {
            addCriterion("fee <=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeIn(List<Double> values) {
            addCriterion("fee in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotIn(List<Double> values) {
            addCriterion("fee not in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeBetween(Double value1, Double value2) {
            addCriterion("fee between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotBetween(Double value1, Double value2) {
            addCriterion("fee not between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andConfirmKeywordIsNull() {
            addCriterion("confirm_keyword is null");
            return (Criteria) this;
        }

        public Criteria andConfirmKeywordIsNotNull() {
            addCriterion("confirm_keyword is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmKeywordEqualTo(String value) {
            addCriterion("confirm_keyword =", value, "confirmKeyword");
            return (Criteria) this;
        }

        public Criteria andConfirmKeywordNotEqualTo(String value) {
            addCriterion("confirm_keyword <>", value, "confirmKeyword");
            return (Criteria) this;
        }

        public Criteria andConfirmKeywordGreaterThan(String value) {
            addCriterion("confirm_keyword >", value, "confirmKeyword");
            return (Criteria) this;
        }

        public Criteria andConfirmKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("confirm_keyword >=", value, "confirmKeyword");
            return (Criteria) this;
        }

        public Criteria andConfirmKeywordLessThan(String value) {
            addCriterion("confirm_keyword <", value, "confirmKeyword");
            return (Criteria) this;
        }

        public Criteria andConfirmKeywordLessThanOrEqualTo(String value) {
            addCriterion("confirm_keyword <=", value, "confirmKeyword");
            return (Criteria) this;
        }

        public Criteria andConfirmKeywordLike(String value) {
            addCriterion("confirm_keyword like", value, "confirmKeyword");
            return (Criteria) this;
        }

        public Criteria andConfirmKeywordNotLike(String value) {
            addCriterion("confirm_keyword not like", value, "confirmKeyword");
            return (Criteria) this;
        }

        public Criteria andConfirmKeywordIn(List<String> values) {
            addCriterion("confirm_keyword in", values, "confirmKeyword");
            return (Criteria) this;
        }

        public Criteria andConfirmKeywordNotIn(List<String> values) {
            addCriterion("confirm_keyword not in", values, "confirmKeyword");
            return (Criteria) this;
        }

        public Criteria andConfirmKeywordBetween(String value1, String value2) {
            addCriterion("confirm_keyword between", value1, value2, "confirmKeyword");
            return (Criteria) this;
        }

        public Criteria andConfirmKeywordNotBetween(String value1, String value2) {
            addCriterion("confirm_keyword not between", value1, value2, "confirmKeyword");
            return (Criteria) this;
        }

        public Criteria andConfirmCommandIsNull() {
            addCriterion("confirm_command is null");
            return (Criteria) this;
        }

        public Criteria andConfirmCommandIsNotNull() {
            addCriterion("confirm_command is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmCommandEqualTo(String value) {
            addCriterion("confirm_command =", value, "confirmCommand");
            return (Criteria) this;
        }

        public Criteria andConfirmCommandNotEqualTo(String value) {
            addCriterion("confirm_command <>", value, "confirmCommand");
            return (Criteria) this;
        }

        public Criteria andConfirmCommandGreaterThan(String value) {
            addCriterion("confirm_command >", value, "confirmCommand");
            return (Criteria) this;
        }

        public Criteria andConfirmCommandGreaterThanOrEqualTo(String value) {
            addCriterion("confirm_command >=", value, "confirmCommand");
            return (Criteria) this;
        }

        public Criteria andConfirmCommandLessThan(String value) {
            addCriterion("confirm_command <", value, "confirmCommand");
            return (Criteria) this;
        }

        public Criteria andConfirmCommandLessThanOrEqualTo(String value) {
            addCriterion("confirm_command <=", value, "confirmCommand");
            return (Criteria) this;
        }

        public Criteria andConfirmCommandLike(String value) {
            addCriterion("confirm_command like", value, "confirmCommand");
            return (Criteria) this;
        }

        public Criteria andConfirmCommandNotLike(String value) {
            addCriterion("confirm_command not like", value, "confirmCommand");
            return (Criteria) this;
        }

        public Criteria andConfirmCommandIn(List<String> values) {
            addCriterion("confirm_command in", values, "confirmCommand");
            return (Criteria) this;
        }

        public Criteria andConfirmCommandNotIn(List<String> values) {
            addCriterion("confirm_command not in", values, "confirmCommand");
            return (Criteria) this;
        }

        public Criteria andConfirmCommandBetween(String value1, String value2) {
            addCriterion("confirm_command between", value1, value2, "confirmCommand");
            return (Criteria) this;
        }

        public Criteria andConfirmCommandNotBetween(String value1, String value2) {
            addCriterion("confirm_command not between", value1, value2, "confirmCommand");
            return (Criteria) this;
        }

        public Criteria andConfirmTroneIsNull() {
            addCriterion("confirm_trone is null");
            return (Criteria) this;
        }

        public Criteria andConfirmTroneIsNotNull() {
            addCriterion("confirm_trone is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmTroneEqualTo(String value) {
            addCriterion("confirm_trone =", value, "confirmTrone");
            return (Criteria) this;
        }

        public Criteria andConfirmTroneNotEqualTo(String value) {
            addCriterion("confirm_trone <>", value, "confirmTrone");
            return (Criteria) this;
        }

        public Criteria andConfirmTroneGreaterThan(String value) {
            addCriterion("confirm_trone >", value, "confirmTrone");
            return (Criteria) this;
        }

        public Criteria andConfirmTroneGreaterThanOrEqualTo(String value) {
            addCriterion("confirm_trone >=", value, "confirmTrone");
            return (Criteria) this;
        }

        public Criteria andConfirmTroneLessThan(String value) {
            addCriterion("confirm_trone <", value, "confirmTrone");
            return (Criteria) this;
        }

        public Criteria andConfirmTroneLessThanOrEqualTo(String value) {
            addCriterion("confirm_trone <=", value, "confirmTrone");
            return (Criteria) this;
        }

        public Criteria andConfirmTroneLike(String value) {
            addCriterion("confirm_trone like", value, "confirmTrone");
            return (Criteria) this;
        }

        public Criteria andConfirmTroneNotLike(String value) {
            addCriterion("confirm_trone not like", value, "confirmTrone");
            return (Criteria) this;
        }

        public Criteria andConfirmTroneIn(List<String> values) {
            addCriterion("confirm_trone in", values, "confirmTrone");
            return (Criteria) this;
        }

        public Criteria andConfirmTroneNotIn(List<String> values) {
            addCriterion("confirm_trone not in", values, "confirmTrone");
            return (Criteria) this;
        }

        public Criteria andConfirmTroneBetween(String value1, String value2) {
            addCriterion("confirm_trone between", value1, value2, "confirmTrone");
            return (Criteria) this;
        }

        public Criteria andConfirmTroneNotBetween(String value1, String value2) {
            addCriterion("confirm_trone not between", value1, value2, "confirmTrone");
            return (Criteria) this;
        }

        public Criteria andFindRndKeywordIsNull() {
            addCriterion("find_rnd_keyword is null");
            return (Criteria) this;
        }

        public Criteria andFindRndKeywordIsNotNull() {
            addCriterion("find_rnd_keyword is not null");
            return (Criteria) this;
        }

        public Criteria andFindRndKeywordEqualTo(String value) {
            addCriterion("find_rnd_keyword =", value, "findRndKeyword");
            return (Criteria) this;
        }

        public Criteria andFindRndKeywordNotEqualTo(String value) {
            addCriterion("find_rnd_keyword <>", value, "findRndKeyword");
            return (Criteria) this;
        }

        public Criteria andFindRndKeywordGreaterThan(String value) {
            addCriterion("find_rnd_keyword >", value, "findRndKeyword");
            return (Criteria) this;
        }

        public Criteria andFindRndKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("find_rnd_keyword >=", value, "findRndKeyword");
            return (Criteria) this;
        }

        public Criteria andFindRndKeywordLessThan(String value) {
            addCriterion("find_rnd_keyword <", value, "findRndKeyword");
            return (Criteria) this;
        }

        public Criteria andFindRndKeywordLessThanOrEqualTo(String value) {
            addCriterion("find_rnd_keyword <=", value, "findRndKeyword");
            return (Criteria) this;
        }

        public Criteria andFindRndKeywordLike(String value) {
            addCriterion("find_rnd_keyword like", value, "findRndKeyword");
            return (Criteria) this;
        }

        public Criteria andFindRndKeywordNotLike(String value) {
            addCriterion("find_rnd_keyword not like", value, "findRndKeyword");
            return (Criteria) this;
        }

        public Criteria andFindRndKeywordIn(List<String> values) {
            addCriterion("find_rnd_keyword in", values, "findRndKeyword");
            return (Criteria) this;
        }

        public Criteria andFindRndKeywordNotIn(List<String> values) {
            addCriterion("find_rnd_keyword not in", values, "findRndKeyword");
            return (Criteria) this;
        }

        public Criteria andFindRndKeywordBetween(String value1, String value2) {
            addCriterion("find_rnd_keyword between", value1, value2, "findRndKeyword");
            return (Criteria) this;
        }

        public Criteria andFindRndKeywordNotBetween(String value1, String value2) {
            addCriterion("find_rnd_keyword not between", value1, value2, "findRndKeyword");
            return (Criteria) this;
        }

        public Criteria andDeleteTextIsNull() {
            addCriterion("delete_text is null");
            return (Criteria) this;
        }

        public Criteria andDeleteTextIsNotNull() {
            addCriterion("delete_text is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteTextEqualTo(String value) {
            addCriterion("delete_text =", value, "deleteText");
            return (Criteria) this;
        }

        public Criteria andDeleteTextNotEqualTo(String value) {
            addCriterion("delete_text <>", value, "deleteText");
            return (Criteria) this;
        }

        public Criteria andDeleteTextGreaterThan(String value) {
            addCriterion("delete_text >", value, "deleteText");
            return (Criteria) this;
        }

        public Criteria andDeleteTextGreaterThanOrEqualTo(String value) {
            addCriterion("delete_text >=", value, "deleteText");
            return (Criteria) this;
        }

        public Criteria andDeleteTextLessThan(String value) {
            addCriterion("delete_text <", value, "deleteText");
            return (Criteria) this;
        }

        public Criteria andDeleteTextLessThanOrEqualTo(String value) {
            addCriterion("delete_text <=", value, "deleteText");
            return (Criteria) this;
        }

        public Criteria andDeleteTextLike(String value) {
            addCriterion("delete_text like", value, "deleteText");
            return (Criteria) this;
        }

        public Criteria andDeleteTextNotLike(String value) {
            addCriterion("delete_text not like", value, "deleteText");
            return (Criteria) this;
        }

        public Criteria andDeleteTextIn(List<String> values) {
            addCriterion("delete_text in", values, "deleteText");
            return (Criteria) this;
        }

        public Criteria andDeleteTextNotIn(List<String> values) {
            addCriterion("delete_text not in", values, "deleteText");
            return (Criteria) this;
        }

        public Criteria andDeleteTextBetween(String value1, String value2) {
            addCriterion("delete_text between", value1, value2, "deleteText");
            return (Criteria) this;
        }

        public Criteria andDeleteTextNotBetween(String value1, String value2) {
            addCriterion("delete_text not between", value1, value2, "deleteText");
            return (Criteria) this;
        }

        public Criteria andDeleteNumberIsNull() {
            addCriterion("delete_number is null");
            return (Criteria) this;
        }

        public Criteria andDeleteNumberIsNotNull() {
            addCriterion("delete_number is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteNumberEqualTo(String value) {
            addCriterion("delete_number =", value, "deleteNumber");
            return (Criteria) this;
        }

        public Criteria andDeleteNumberNotEqualTo(String value) {
            addCriterion("delete_number <>", value, "deleteNumber");
            return (Criteria) this;
        }

        public Criteria andDeleteNumberGreaterThan(String value) {
            addCriterion("delete_number >", value, "deleteNumber");
            return (Criteria) this;
        }

        public Criteria andDeleteNumberGreaterThanOrEqualTo(String value) {
            addCriterion("delete_number >=", value, "deleteNumber");
            return (Criteria) this;
        }

        public Criteria andDeleteNumberLessThan(String value) {
            addCriterion("delete_number <", value, "deleteNumber");
            return (Criteria) this;
        }

        public Criteria andDeleteNumberLessThanOrEqualTo(String value) {
            addCriterion("delete_number <=", value, "deleteNumber");
            return (Criteria) this;
        }

        public Criteria andDeleteNumberLike(String value) {
            addCriterion("delete_number like", value, "deleteNumber");
            return (Criteria) this;
        }

        public Criteria andDeleteNumberNotLike(String value) {
            addCriterion("delete_number not like", value, "deleteNumber");
            return (Criteria) this;
        }

        public Criteria andDeleteNumberIn(List<String> values) {
            addCriterion("delete_number in", values, "deleteNumber");
            return (Criteria) this;
        }

        public Criteria andDeleteNumberNotIn(List<String> values) {
            addCriterion("delete_number not in", values, "deleteNumber");
            return (Criteria) this;
        }

        public Criteria andDeleteNumberBetween(String value1, String value2) {
            addCriterion("delete_number between", value1, value2, "deleteNumber");
            return (Criteria) this;
        }

        public Criteria andDeleteNumberNotBetween(String value1, String value2) {
            addCriterion("delete_number not between", value1, value2, "deleteNumber");
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

        public Criteria andTroneTypeEqualTo(Byte value) {
            addCriterion("trone_type =", value, "troneType");
            return (Criteria) this;
        }

        public Criteria andTroneTypeNotEqualTo(Byte value) {
            addCriterion("trone_type <>", value, "troneType");
            return (Criteria) this;
        }

        public Criteria andTroneTypeGreaterThan(Byte value) {
            addCriterion("trone_type >", value, "troneType");
            return (Criteria) this;
        }

        public Criteria andTroneTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("trone_type >=", value, "troneType");
            return (Criteria) this;
        }

        public Criteria andTroneTypeLessThan(Byte value) {
            addCriterion("trone_type <", value, "troneType");
            return (Criteria) this;
        }

        public Criteria andTroneTypeLessThanOrEqualTo(Byte value) {
            addCriterion("trone_type <=", value, "troneType");
            return (Criteria) this;
        }

        public Criteria andTroneTypeIn(List<Byte> values) {
            addCriterion("trone_type in", values, "troneType");
            return (Criteria) this;
        }

        public Criteria andTroneTypeNotIn(List<Byte> values) {
            addCriterion("trone_type not in", values, "troneType");
            return (Criteria) this;
        }

        public Criteria andTroneTypeBetween(Byte value1, Byte value2) {
            addCriterion("trone_type between", value1, value2, "troneType");
            return (Criteria) this;
        }

        public Criteria andTroneTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("trone_type not between", value1, value2, "troneType");
            return (Criteria) this;
        }

        public Criteria andSidCidOnlyIsNull() {
            addCriterion("sid_cid_only is null");
            return (Criteria) this;
        }

        public Criteria andSidCidOnlyIsNotNull() {
            addCriterion("sid_cid_only is not null");
            return (Criteria) this;
        }

        public Criteria andSidCidOnlyEqualTo(String value) {
            addCriterion("sid_cid_only =", value, "sidCidOnly");
            return (Criteria) this;
        }

        public Criteria andSidCidOnlyNotEqualTo(String value) {
            addCriterion("sid_cid_only <>", value, "sidCidOnly");
            return (Criteria) this;
        }

        public Criteria andSidCidOnlyGreaterThan(String value) {
            addCriterion("sid_cid_only >", value, "sidCidOnly");
            return (Criteria) this;
        }

        public Criteria andSidCidOnlyGreaterThanOrEqualTo(String value) {
            addCriterion("sid_cid_only >=", value, "sidCidOnly");
            return (Criteria) this;
        }

        public Criteria andSidCidOnlyLessThan(String value) {
            addCriterion("sid_cid_only <", value, "sidCidOnly");
            return (Criteria) this;
        }

        public Criteria andSidCidOnlyLessThanOrEqualTo(String value) {
            addCriterion("sid_cid_only <=", value, "sidCidOnly");
            return (Criteria) this;
        }

        public Criteria andSidCidOnlyLike(String value) {
            addCriterion("sid_cid_only like", value, "sidCidOnly");
            return (Criteria) this;
        }

        public Criteria andSidCidOnlyNotLike(String value) {
            addCriterion("sid_cid_only not like", value, "sidCidOnly");
            return (Criteria) this;
        }

        public Criteria andSidCidOnlyIn(List<String> values) {
            addCriterion("sid_cid_only in", values, "sidCidOnly");
            return (Criteria) this;
        }

        public Criteria andSidCidOnlyNotIn(List<String> values) {
            addCriterion("sid_cid_only not in", values, "sidCidOnly");
            return (Criteria) this;
        }

        public Criteria andSidCidOnlyBetween(String value1, String value2) {
            addCriterion("sid_cid_only between", value1, value2, "sidCidOnly");
            return (Criteria) this;
        }

        public Criteria andSidCidOnlyNotBetween(String value1, String value2) {
            addCriterion("sid_cid_only not between", value1, value2, "sidCidOnly");
            return (Criteria) this;
        }

        public Criteria andHelplineIsNull() {
            addCriterion("helpline is null");
            return (Criteria) this;
        }

        public Criteria andHelplineIsNotNull() {
            addCriterion("helpline is not null");
            return (Criteria) this;
        }

        public Criteria andHelplineEqualTo(String value) {
            addCriterion("helpline =", value, "helpline");
            return (Criteria) this;
        }

        public Criteria andHelplineNotEqualTo(String value) {
            addCriterion("helpline <>", value, "helpline");
            return (Criteria) this;
        }

        public Criteria andHelplineGreaterThan(String value) {
            addCriterion("helpline >", value, "helpline");
            return (Criteria) this;
        }

        public Criteria andHelplineGreaterThanOrEqualTo(String value) {
            addCriterion("helpline >=", value, "helpline");
            return (Criteria) this;
        }

        public Criteria andHelplineLessThan(String value) {
            addCriterion("helpline <", value, "helpline");
            return (Criteria) this;
        }

        public Criteria andHelplineLessThanOrEqualTo(String value) {
            addCriterion("helpline <=", value, "helpline");
            return (Criteria) this;
        }

        public Criteria andHelplineLike(String value) {
            addCriterion("helpline like", value, "helpline");
            return (Criteria) this;
        }

        public Criteria andHelplineNotLike(String value) {
            addCriterion("helpline not like", value, "helpline");
            return (Criteria) this;
        }

        public Criteria andHelplineIn(List<String> values) {
            addCriterion("helpline in", values, "helpline");
            return (Criteria) this;
        }

        public Criteria andHelplineNotIn(List<String> values) {
            addCriterion("helpline not in", values, "helpline");
            return (Criteria) this;
        }

        public Criteria andHelplineBetween(String value1, String value2) {
            addCriterion("helpline between", value1, value2, "helpline");
            return (Criteria) this;
        }

        public Criteria andHelplineNotBetween(String value1, String value2) {
            addCriterion("helpline not between", value1, value2, "helpline");
            return (Criteria) this;
        }

        public Criteria andSpIdIsNull() {
            addCriterion("sp_id is null");
            return (Criteria) this;
        }

        public Criteria andSpIdIsNotNull() {
            addCriterion("sp_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpIdEqualTo(String value) {
            addCriterion("sp_id =", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdNotEqualTo(String value) {
            addCriterion("sp_id <>", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdGreaterThan(String value) {
            addCriterion("sp_id >", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdGreaterThanOrEqualTo(String value) {
            addCriterion("sp_id >=", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdLessThan(String value) {
            addCriterion("sp_id <", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdLessThanOrEqualTo(String value) {
            addCriterion("sp_id <=", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdLike(String value) {
            addCriterion("sp_id like", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdNotLike(String value) {
            addCriterion("sp_id not like", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdIn(List<String> values) {
            addCriterion("sp_id in", values, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdNotIn(List<String> values) {
            addCriterion("sp_id not in", values, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdBetween(String value1, String value2) {
            addCriterion("sp_id between", value1, value2, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdNotBetween(String value1, String value2) {
            addCriterion("sp_id not between", value1, value2, "spId");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
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

        public Criteria andDivideRatioIsNull() {
            addCriterion("divide_ratio is null");
            return (Criteria) this;
        }

        public Criteria andDivideRatioIsNotNull() {
            addCriterion("divide_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andDivideRatioEqualTo(Double value) {
            addCriterion("divide_ratio =", value, "divideRatio");
            return (Criteria) this;
        }

        public Criteria andDivideRatioNotEqualTo(Double value) {
            addCriterion("divide_ratio <>", value, "divideRatio");
            return (Criteria) this;
        }

        public Criteria andDivideRatioGreaterThan(Double value) {
            addCriterion("divide_ratio >", value, "divideRatio");
            return (Criteria) this;
        }

        public Criteria andDivideRatioGreaterThanOrEqualTo(Double value) {
            addCriterion("divide_ratio >=", value, "divideRatio");
            return (Criteria) this;
        }

        public Criteria andDivideRatioLessThan(Double value) {
            addCriterion("divide_ratio <", value, "divideRatio");
            return (Criteria) this;
        }

        public Criteria andDivideRatioLessThanOrEqualTo(Double value) {
            addCriterion("divide_ratio <=", value, "divideRatio");
            return (Criteria) this;
        }

        public Criteria andDivideRatioIn(List<Double> values) {
            addCriterion("divide_ratio in", values, "divideRatio");
            return (Criteria) this;
        }

        public Criteria andDivideRatioNotIn(List<Double> values) {
            addCriterion("divide_ratio not in", values, "divideRatio");
            return (Criteria) this;
        }

        public Criteria andDivideRatioBetween(Double value1, Double value2) {
            addCriterion("divide_ratio between", value1, value2, "divideRatio");
            return (Criteria) this;
        }

        public Criteria andDivideRatioNotBetween(Double value1, Double value2) {
            addCriterion("divide_ratio not between", value1, value2, "divideRatio");
            return (Criteria) this;
        }

        public Criteria andIsFreshPvIsNull() {
            addCriterion("is_fresh_pv is null");
            return (Criteria) this;
        }

        public Criteria andIsFreshPvIsNotNull() {
            addCriterion("is_fresh_pv is not null");
            return (Criteria) this;
        }

        public Criteria andIsFreshPvEqualTo(Byte value) {
            addCriterion("is_fresh_pv =", value, "isFreshPv");
            return (Criteria) this;
        }

        public Criteria andIsFreshPvNotEqualTo(Byte value) {
            addCriterion("is_fresh_pv <>", value, "isFreshPv");
            return (Criteria) this;
        }

        public Criteria andIsFreshPvGreaterThan(Byte value) {
            addCriterion("is_fresh_pv >", value, "isFreshPv");
            return (Criteria) this;
        }

        public Criteria andIsFreshPvGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_fresh_pv >=", value, "isFreshPv");
            return (Criteria) this;
        }

        public Criteria andIsFreshPvLessThan(Byte value) {
            addCriterion("is_fresh_pv <", value, "isFreshPv");
            return (Criteria) this;
        }

        public Criteria andIsFreshPvLessThanOrEqualTo(Byte value) {
            addCriterion("is_fresh_pv <=", value, "isFreshPv");
            return (Criteria) this;
        }

        public Criteria andIsFreshPvIn(List<Byte> values) {
            addCriterion("is_fresh_pv in", values, "isFreshPv");
            return (Criteria) this;
        }

        public Criteria andIsFreshPvNotIn(List<Byte> values) {
            addCriterion("is_fresh_pv not in", values, "isFreshPv");
            return (Criteria) this;
        }

        public Criteria andIsFreshPvBetween(Byte value1, Byte value2) {
            addCriterion("is_fresh_pv between", value1, value2, "isFreshPv");
            return (Criteria) this;
        }

        public Criteria andIsFreshPvNotBetween(Byte value1, Byte value2) {
            addCriterion("is_fresh_pv not between", value1, value2, "isFreshPv");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Byte value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Byte value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Byte value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Byte value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Byte value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Byte value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Byte> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Byte> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Byte value1, Byte value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Byte value1, Byte value2) {
            addCriterion("weight not between", value1, value2, "weight");
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

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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