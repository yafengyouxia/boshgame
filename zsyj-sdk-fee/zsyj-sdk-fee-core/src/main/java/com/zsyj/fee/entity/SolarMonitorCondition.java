package com.zsyj.fee.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SolarMonitorCondition {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SolarMonitorCondition() {
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

        public Criteria andMonnitorIdIsNull() {
            addCriterion("monnitor_id is null");
            return (Criteria) this;
        }

        public Criteria andMonnitorIdIsNotNull() {
            addCriterion("monnitor_id is not null");
            return (Criteria) this;
        }

        public Criteria andMonnitorIdEqualTo(Integer value) {
            addCriterion("monnitor_id =", value, "monnitorId");
            return (Criteria) this;
        }

        public Criteria andMonnitorIdNotEqualTo(Integer value) {
            addCriterion("monnitor_id <>", value, "monnitorId");
            return (Criteria) this;
        }

        public Criteria andMonnitorIdGreaterThan(Integer value) {
            addCriterion("monnitor_id >", value, "monnitorId");
            return (Criteria) this;
        }

        public Criteria andMonnitorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("monnitor_id >=", value, "monnitorId");
            return (Criteria) this;
        }

        public Criteria andMonnitorIdLessThan(Integer value) {
            addCriterion("monnitor_id <", value, "monnitorId");
            return (Criteria) this;
        }

        public Criteria andMonnitorIdLessThanOrEqualTo(Integer value) {
            addCriterion("monnitor_id <=", value, "monnitorId");
            return (Criteria) this;
        }

        public Criteria andMonnitorIdIn(List<Integer> values) {
            addCriterion("monnitor_id in", values, "monnitorId");
            return (Criteria) this;
        }

        public Criteria andMonnitorIdNotIn(List<Integer> values) {
            addCriterion("monnitor_id not in", values, "monnitorId");
            return (Criteria) this;
        }

        public Criteria andMonnitorIdBetween(Integer value1, Integer value2) {
            addCriterion("monnitor_id between", value1, value2, "monnitorId");
            return (Criteria) this;
        }

        public Criteria andMonnitorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("monnitor_id not between", value1, value2, "monnitorId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andAgentCodeIsNull() {
            addCriterion("agent_code is null");
            return (Criteria) this;
        }

        public Criteria andAgentCodeIsNotNull() {
            addCriterion("agent_code is not null");
            return (Criteria) this;
        }

        public Criteria andAgentCodeEqualTo(Integer value) {
            addCriterion("agent_code =", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeNotEqualTo(Integer value) {
            addCriterion("agent_code <>", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeGreaterThan(Integer value) {
            addCriterion("agent_code >", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("agent_code >=", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeLessThan(Integer value) {
            addCriterion("agent_code <", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeLessThanOrEqualTo(Integer value) {
            addCriterion("agent_code <=", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeIn(List<Integer> values) {
            addCriterion("agent_code in", values, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeNotIn(List<Integer> values) {
            addCriterion("agent_code not in", values, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeBetween(Integer value1, Integer value2) {
            addCriterion("agent_code between", value1, value2, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("agent_code not between", value1, value2, "agentCode");
            return (Criteria) this;
        }

        public Criteria andMonitorCodeIsNull() {
            addCriterion("monitor_code is null");
            return (Criteria) this;
        }

        public Criteria andMonitorCodeIsNotNull() {
            addCriterion("monitor_code is not null");
            return (Criteria) this;
        }

        public Criteria andMonitorCodeEqualTo(String value) {
            addCriterion("monitor_code =", value, "monitorCode");
            return (Criteria) this;
        }

        public Criteria andMonitorCodeNotEqualTo(String value) {
            addCriterion("monitor_code <>", value, "monitorCode");
            return (Criteria) this;
        }

        public Criteria andMonitorCodeGreaterThan(String value) {
            addCriterion("monitor_code >", value, "monitorCode");
            return (Criteria) this;
        }

        public Criteria andMonitorCodeGreaterThanOrEqualTo(String value) {
            addCriterion("monitor_code >=", value, "monitorCode");
            return (Criteria) this;
        }

        public Criteria andMonitorCodeLessThan(String value) {
            addCriterion("monitor_code <", value, "monitorCode");
            return (Criteria) this;
        }

        public Criteria andMonitorCodeLessThanOrEqualTo(String value) {
            addCriterion("monitor_code <=", value, "monitorCode");
            return (Criteria) this;
        }

        public Criteria andMonitorCodeLike(String value) {
            addCriterion("monitor_code like", value, "monitorCode");
            return (Criteria) this;
        }

        public Criteria andMonitorCodeNotLike(String value) {
            addCriterion("monitor_code not like", value, "monitorCode");
            return (Criteria) this;
        }

        public Criteria andMonitorCodeIn(List<String> values) {
            addCriterion("monitor_code in", values, "monitorCode");
            return (Criteria) this;
        }

        public Criteria andMonitorCodeNotIn(List<String> values) {
            addCriterion("monitor_code not in", values, "monitorCode");
            return (Criteria) this;
        }

        public Criteria andMonitorCodeBetween(String value1, String value2) {
            addCriterion("monitor_code between", value1, value2, "monitorCode");
            return (Criteria) this;
        }

        public Criteria andMonitorCodeNotBetween(String value1, String value2) {
            addCriterion("monitor_code not between", value1, value2, "monitorCode");
            return (Criteria) this;
        }

        public Criteria andMonitorNameIsNull() {
            addCriterion("monitor_name is null");
            return (Criteria) this;
        }

        public Criteria andMonitorNameIsNotNull() {
            addCriterion("monitor_name is not null");
            return (Criteria) this;
        }

        public Criteria andMonitorNameEqualTo(String value) {
            addCriterion("monitor_name =", value, "monitorName");
            return (Criteria) this;
        }

        public Criteria andMonitorNameNotEqualTo(String value) {
            addCriterion("monitor_name <>", value, "monitorName");
            return (Criteria) this;
        }

        public Criteria andMonitorNameGreaterThan(String value) {
            addCriterion("monitor_name >", value, "monitorName");
            return (Criteria) this;
        }

        public Criteria andMonitorNameGreaterThanOrEqualTo(String value) {
            addCriterion("monitor_name >=", value, "monitorName");
            return (Criteria) this;
        }

        public Criteria andMonitorNameLessThan(String value) {
            addCriterion("monitor_name <", value, "monitorName");
            return (Criteria) this;
        }

        public Criteria andMonitorNameLessThanOrEqualTo(String value) {
            addCriterion("monitor_name <=", value, "monitorName");
            return (Criteria) this;
        }

        public Criteria andMonitorNameLike(String value) {
            addCriterion("monitor_name like", value, "monitorName");
            return (Criteria) this;
        }

        public Criteria andMonitorNameNotLike(String value) {
            addCriterion("monitor_name not like", value, "monitorName");
            return (Criteria) this;
        }

        public Criteria andMonitorNameIn(List<String> values) {
            addCriterion("monitor_name in", values, "monitorName");
            return (Criteria) this;
        }

        public Criteria andMonitorNameNotIn(List<String> values) {
            addCriterion("monitor_name not in", values, "monitorName");
            return (Criteria) this;
        }

        public Criteria andMonitorNameBetween(String value1, String value2) {
            addCriterion("monitor_name between", value1, value2, "monitorName");
            return (Criteria) this;
        }

        public Criteria andMonitorNameNotBetween(String value1, String value2) {
            addCriterion("monitor_name not between", value1, value2, "monitorName");
            return (Criteria) this;
        }

        public Criteria andSaleUserIdIsNull() {
            addCriterion("sale_user_id is null");
            return (Criteria) this;
        }

        public Criteria andSaleUserIdIsNotNull() {
            addCriterion("sale_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andSaleUserIdEqualTo(Integer value) {
            addCriterion("sale_user_id =", value, "saleUserId");
            return (Criteria) this;
        }

        public Criteria andSaleUserIdNotEqualTo(Integer value) {
            addCriterion("sale_user_id <>", value, "saleUserId");
            return (Criteria) this;
        }

        public Criteria andSaleUserIdGreaterThan(Integer value) {
            addCriterion("sale_user_id >", value, "saleUserId");
            return (Criteria) this;
        }

        public Criteria andSaleUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sale_user_id >=", value, "saleUserId");
            return (Criteria) this;
        }

        public Criteria andSaleUserIdLessThan(Integer value) {
            addCriterion("sale_user_id <", value, "saleUserId");
            return (Criteria) this;
        }

        public Criteria andSaleUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("sale_user_id <=", value, "saleUserId");
            return (Criteria) this;
        }

        public Criteria andSaleUserIdIn(List<Integer> values) {
            addCriterion("sale_user_id in", values, "saleUserId");
            return (Criteria) this;
        }

        public Criteria andSaleUserIdNotIn(List<Integer> values) {
            addCriterion("sale_user_id not in", values, "saleUserId");
            return (Criteria) this;
        }

        public Criteria andSaleUserIdBetween(Integer value1, Integer value2) {
            addCriterion("sale_user_id between", value1, value2, "saleUserId");
            return (Criteria) this;
        }

        public Criteria andSaleUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sale_user_id not between", value1, value2, "saleUserId");
            return (Criteria) this;
        }

        public Criteria andAppidIsNull() {
            addCriterion("appid is null");
            return (Criteria) this;
        }

        public Criteria andAppidIsNotNull() {
            addCriterion("appid is not null");
            return (Criteria) this;
        }

        public Criteria andAppidEqualTo(Integer value) {
            addCriterion("appid =", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotEqualTo(Integer value) {
            addCriterion("appid <>", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThan(Integer value) {
            addCriterion("appid >", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThanOrEqualTo(Integer value) {
            addCriterion("appid >=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThan(Integer value) {
            addCriterion("appid <", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThanOrEqualTo(Integer value) {
            addCriterion("appid <=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidIn(List<Integer> values) {
            addCriterion("appid in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotIn(List<Integer> values) {
            addCriterion("appid not in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidBetween(Integer value1, Integer value2) {
            addCriterion("appid between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotBetween(Integer value1, Integer value2) {
            addCriterion("appid not between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Byte value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Byte value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Byte value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Byte value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Byte value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Byte> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Byte> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Byte value1, Byte value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andCpaCpsPriceIsNull() {
            addCriterion("cpa_cps_price is null");
            return (Criteria) this;
        }

        public Criteria andCpaCpsPriceIsNotNull() {
            addCriterion("cpa_cps_price is not null");
            return (Criteria) this;
        }

        public Criteria andCpaCpsPriceEqualTo(Double value) {
            addCriterion("cpa_cps_price =", value, "cpaCpsPrice");
            return (Criteria) this;
        }

        public Criteria andCpaCpsPriceNotEqualTo(Double value) {
            addCriterion("cpa_cps_price <>", value, "cpaCpsPrice");
            return (Criteria) this;
        }

        public Criteria andCpaCpsPriceGreaterThan(Double value) {
            addCriterion("cpa_cps_price >", value, "cpaCpsPrice");
            return (Criteria) this;
        }

        public Criteria andCpaCpsPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("cpa_cps_price >=", value, "cpaCpsPrice");
            return (Criteria) this;
        }

        public Criteria andCpaCpsPriceLessThan(Double value) {
            addCriterion("cpa_cps_price <", value, "cpaCpsPrice");
            return (Criteria) this;
        }

        public Criteria andCpaCpsPriceLessThanOrEqualTo(Double value) {
            addCriterion("cpa_cps_price <=", value, "cpaCpsPrice");
            return (Criteria) this;
        }

        public Criteria andCpaCpsPriceIn(List<Double> values) {
            addCriterion("cpa_cps_price in", values, "cpaCpsPrice");
            return (Criteria) this;
        }

        public Criteria andCpaCpsPriceNotIn(List<Double> values) {
            addCriterion("cpa_cps_price not in", values, "cpaCpsPrice");
            return (Criteria) this;
        }

        public Criteria andCpaCpsPriceBetween(Double value1, Double value2) {
            addCriterion("cpa_cps_price between", value1, value2, "cpaCpsPrice");
            return (Criteria) this;
        }

        public Criteria andCpaCpsPriceNotBetween(Double value1, Double value2) {
            addCriterion("cpa_cps_price not between", value1, value2, "cpaCpsPrice");
            return (Criteria) this;
        }

        public Criteria andUserRateIsNull() {
            addCriterion("user_rate is null");
            return (Criteria) this;
        }

        public Criteria andUserRateIsNotNull() {
            addCriterion("user_rate is not null");
            return (Criteria) this;
        }

        public Criteria andUserRateEqualTo(Double value) {
            addCriterion("user_rate =", value, "userRate");
            return (Criteria) this;
        }

        public Criteria andUserRateNotEqualTo(Double value) {
            addCriterion("user_rate <>", value, "userRate");
            return (Criteria) this;
        }

        public Criteria andUserRateGreaterThan(Double value) {
            addCriterion("user_rate >", value, "userRate");
            return (Criteria) this;
        }

        public Criteria andUserRateGreaterThanOrEqualTo(Double value) {
            addCriterion("user_rate >=", value, "userRate");
            return (Criteria) this;
        }

        public Criteria andUserRateLessThan(Double value) {
            addCriterion("user_rate <", value, "userRate");
            return (Criteria) this;
        }

        public Criteria andUserRateLessThanOrEqualTo(Double value) {
            addCriterion("user_rate <=", value, "userRate");
            return (Criteria) this;
        }

        public Criteria andUserRateIn(List<Double> values) {
            addCriterion("user_rate in", values, "userRate");
            return (Criteria) this;
        }

        public Criteria andUserRateNotIn(List<Double> values) {
            addCriterion("user_rate not in", values, "userRate");
            return (Criteria) this;
        }

        public Criteria andUserRateBetween(Double value1, Double value2) {
            addCriterion("user_rate between", value1, value2, "userRate");
            return (Criteria) this;
        }

        public Criteria andUserRateNotBetween(Double value1, Double value2) {
            addCriterion("user_rate not between", value1, value2, "userRate");
            return (Criteria) this;
        }

        public Criteria andMoneyRateIsNull() {
            addCriterion("money_rate is null");
            return (Criteria) this;
        }

        public Criteria andMoneyRateIsNotNull() {
            addCriterion("money_rate is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyRateEqualTo(Double value) {
            addCriterion("money_rate =", value, "moneyRate");
            return (Criteria) this;
        }

        public Criteria andMoneyRateNotEqualTo(Double value) {
            addCriterion("money_rate <>", value, "moneyRate");
            return (Criteria) this;
        }

        public Criteria andMoneyRateGreaterThan(Double value) {
            addCriterion("money_rate >", value, "moneyRate");
            return (Criteria) this;
        }

        public Criteria andMoneyRateGreaterThanOrEqualTo(Double value) {
            addCriterion("money_rate >=", value, "moneyRate");
            return (Criteria) this;
        }

        public Criteria andMoneyRateLessThan(Double value) {
            addCriterion("money_rate <", value, "moneyRate");
            return (Criteria) this;
        }

        public Criteria andMoneyRateLessThanOrEqualTo(Double value) {
            addCriterion("money_rate <=", value, "moneyRate");
            return (Criteria) this;
        }

        public Criteria andMoneyRateIn(List<Double> values) {
            addCriterion("money_rate in", values, "moneyRate");
            return (Criteria) this;
        }

        public Criteria andMoneyRateNotIn(List<Double> values) {
            addCriterion("money_rate not in", values, "moneyRate");
            return (Criteria) this;
        }

        public Criteria andMoneyRateBetween(Double value1, Double value2) {
            addCriterion("money_rate between", value1, value2, "moneyRate");
            return (Criteria) this;
        }

        public Criteria andMoneyRateNotBetween(Double value1, Double value2) {
            addCriterion("money_rate not between", value1, value2, "moneyRate");
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

        public Criteria andAddTimeIsNull() {
            addCriterion("add_time is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterion("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterion("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterion("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterion("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterion("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterion("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterion("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("add_time not between", value1, value2, "addTime");
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