package com.zsyj.fee.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SolarChargeCondition {
    protected String orderByClause;

    protected boolean distinct;

    protected String tableName;
    
    protected List<Criteria> oredCriteria;

    public SolarChargeCondition() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public String getTableName() {
		return tableName;
	}



	public void setTableName(String tableName) {
		this.tableName = tableName;
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

        public Criteria andUserSidIsNull() {
            addCriterion("user_sid is null");
            return (Criteria) this;
        }

        public Criteria andUserSidIsNotNull() {
            addCriterion("user_sid is not null");
            return (Criteria) this;
        }

        public Criteria andUserSidEqualTo(String value) {
            addCriterion("user_sid =", value, "userSid");
            return (Criteria) this;
        }

        public Criteria andUserSidNotEqualTo(String value) {
            addCriterion("user_sid <>", value, "userSid");
            return (Criteria) this;
        }

        public Criteria andUserSidGreaterThan(String value) {
            addCriterion("user_sid >", value, "userSid");
            return (Criteria) this;
        }

        public Criteria andUserSidGreaterThanOrEqualTo(String value) {
            addCriterion("user_sid >=", value, "userSid");
            return (Criteria) this;
        }

        public Criteria andUserSidLessThan(String value) {
            addCriterion("user_sid <", value, "userSid");
            return (Criteria) this;
        }

        public Criteria andUserSidLessThanOrEqualTo(String value) {
            addCriterion("user_sid <=", value, "userSid");
            return (Criteria) this;
        }

        public Criteria andUserSidLike(String value) {
            addCriterion("user_sid like", value, "userSid");
            return (Criteria) this;
        }

        public Criteria andUserSidNotLike(String value) {
            addCriterion("user_sid not like", value, "userSid");
            return (Criteria) this;
        }

        public Criteria andUserSidIn(List<String> values) {
            addCriterion("user_sid in", values, "userSid");
            return (Criteria) this;
        }

        public Criteria andUserSidNotIn(List<String> values) {
            addCriterion("user_sid not in", values, "userSid");
            return (Criteria) this;
        }

        public Criteria andUserSidBetween(String value1, String value2) {
            addCriterion("user_sid between", value1, value2, "userSid");
            return (Criteria) this;
        }

        public Criteria andUserSidNotBetween(String value1, String value2) {
            addCriterion("user_sid not between", value1, value2, "userSid");
            return (Criteria) this;
        }

        public Criteria andUserCidIsNull() {
            addCriterion("user_cid is null");
            return (Criteria) this;
        }

        public Criteria andUserCidIsNotNull() {
            addCriterion("user_cid is not null");
            return (Criteria) this;
        }

        public Criteria andUserCidEqualTo(String value) {
            addCriterion("user_cid =", value, "userCid");
            return (Criteria) this;
        }

        public Criteria andUserCidNotEqualTo(String value) {
            addCriterion("user_cid <>", value, "userCid");
            return (Criteria) this;
        }

        public Criteria andUserCidGreaterThan(String value) {
            addCriterion("user_cid >", value, "userCid");
            return (Criteria) this;
        }

        public Criteria andUserCidGreaterThanOrEqualTo(String value) {
            addCriterion("user_cid >=", value, "userCid");
            return (Criteria) this;
        }

        public Criteria andUserCidLessThan(String value) {
            addCriterion("user_cid <", value, "userCid");
            return (Criteria) this;
        }

        public Criteria andUserCidLessThanOrEqualTo(String value) {
            addCriterion("user_cid <=", value, "userCid");
            return (Criteria) this;
        }

        public Criteria andUserCidLike(String value) {
            addCriterion("user_cid like", value, "userCid");
            return (Criteria) this;
        }

        public Criteria andUserCidNotLike(String value) {
            addCriterion("user_cid not like", value, "userCid");
            return (Criteria) this;
        }

        public Criteria andUserCidIn(List<String> values) {
            addCriterion("user_cid in", values, "userCid");
            return (Criteria) this;
        }

        public Criteria andUserCidNotIn(List<String> values) {
            addCriterion("user_cid not in", values, "userCid");
            return (Criteria) this;
        }

        public Criteria andUserCidBetween(String value1, String value2) {
            addCriterion("user_cid between", value1, value2, "userCid");
            return (Criteria) this;
        }

        public Criteria andUserCidNotBetween(String value1, String value2) {
            addCriterion("user_cid not between", value1, value2, "userCid");
            return (Criteria) this;
        }

        public Criteria andSaleIdIsNull() {
            addCriterion("sale_id is null");
            return (Criteria) this;
        }

        public Criteria andSaleIdIsNotNull() {
            addCriterion("sale_id is not null");
            return (Criteria) this;
        }

        public Criteria andSaleIdEqualTo(Integer value) {
            addCriterion("sale_id =", value, "saleId");
            return (Criteria) this;
        }

        public Criteria andSaleIdNotEqualTo(Integer value) {
            addCriterion("sale_id <>", value, "saleId");
            return (Criteria) this;
        }

        public Criteria andSaleIdGreaterThan(Integer value) {
            addCriterion("sale_id >", value, "saleId");
            return (Criteria) this;
        }

        public Criteria andSaleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sale_id >=", value, "saleId");
            return (Criteria) this;
        }

        public Criteria andSaleIdLessThan(Integer value) {
            addCriterion("sale_id <", value, "saleId");
            return (Criteria) this;
        }

        public Criteria andSaleIdLessThanOrEqualTo(Integer value) {
            addCriterion("sale_id <=", value, "saleId");
            return (Criteria) this;
        }

        public Criteria andSaleIdIn(List<Integer> values) {
            addCriterion("sale_id in", values, "saleId");
            return (Criteria) this;
        }

        public Criteria andSaleIdNotIn(List<Integer> values) {
            addCriterion("sale_id not in", values, "saleId");
            return (Criteria) this;
        }

        public Criteria andSaleIdBetween(Integer value1, Integer value2) {
            addCriterion("sale_id between", value1, value2, "saleId");
            return (Criteria) this;
        }

        public Criteria andSaleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sale_id not between", value1, value2, "saleId");
            return (Criteria) this;
        }

        public Criteria andImsiIsNull() {
            addCriterion("imsi is null");
            return (Criteria) this;
        }

        public Criteria andImsiIsNotNull() {
            addCriterion("imsi is not null");
            return (Criteria) this;
        }

        public Criteria andImsiEqualTo(String value) {
            addCriterion("imsi =", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiNotEqualTo(String value) {
            addCriterion("imsi <>", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiGreaterThan(String value) {
            addCriterion("imsi >", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiGreaterThanOrEqualTo(String value) {
            addCriterion("imsi >=", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiLessThan(String value) {
            addCriterion("imsi <", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiLessThanOrEqualTo(String value) {
            addCriterion("imsi <=", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiLike(String value) {
            addCriterion("imsi like", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiNotLike(String value) {
            addCriterion("imsi not like", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiIn(List<String> values) {
            addCriterion("imsi in", values, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiNotIn(List<String> values) {
            addCriterion("imsi not in", values, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiBetween(String value1, String value2) {
            addCriterion("imsi between", value1, value2, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiNotBetween(String value1, String value2) {
            addCriterion("imsi not between", value1, value2, "imsi");
            return (Criteria) this;
        }

        public Criteria andCpIdIsNull() {
            addCriterion("cp_id is null");
            return (Criteria) this;
        }

        public Criteria andCpIdIsNotNull() {
            addCriterion("cp_id is not null");
            return (Criteria) this;
        }

        public Criteria andCpIdEqualTo(Integer value) {
            addCriterion("cp_id =", value, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdNotEqualTo(Integer value) {
            addCriterion("cp_id <>", value, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdGreaterThan(Integer value) {
            addCriterion("cp_id >", value, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cp_id >=", value, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdLessThan(Integer value) {
            addCriterion("cp_id <", value, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdLessThanOrEqualTo(Integer value) {
            addCriterion("cp_id <=", value, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdIn(List<Integer> values) {
            addCriterion("cp_id in", values, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdNotIn(List<Integer> values) {
            addCriterion("cp_id not in", values, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdBetween(Integer value1, Integer value2) {
            addCriterion("cp_id between", value1, value2, "cpId");
            return (Criteria) this;
        }

        public Criteria andCpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cp_id not between", value1, value2, "cpId");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("app_id like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("app_id not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
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

        public Criteria andUsedCashIsNull() {
            addCriterion("used_cash is null");
            return (Criteria) this;
        }

        public Criteria andUsedCashIsNotNull() {
            addCriterion("used_cash is not null");
            return (Criteria) this;
        }

        public Criteria andUsedCashEqualTo(Double value) {
            addCriterion("used_cash =", value, "usedCash");
            return (Criteria) this;
        }

        public Criteria andUsedCashNotEqualTo(Double value) {
            addCriterion("used_cash <>", value, "usedCash");
            return (Criteria) this;
        }

        public Criteria andUsedCashGreaterThan(Double value) {
            addCriterion("used_cash >", value, "usedCash");
            return (Criteria) this;
        }

        public Criteria andUsedCashGreaterThanOrEqualTo(Double value) {
            addCriterion("used_cash >=", value, "usedCash");
            return (Criteria) this;
        }

        public Criteria andUsedCashLessThan(Double value) {
            addCriterion("used_cash <", value, "usedCash");
            return (Criteria) this;
        }

        public Criteria andUsedCashLessThanOrEqualTo(Double value) {
            addCriterion("used_cash <=", value, "usedCash");
            return (Criteria) this;
        }

        public Criteria andUsedCashIn(List<Double> values) {
            addCriterion("used_cash in", values, "usedCash");
            return (Criteria) this;
        }

        public Criteria andUsedCashNotIn(List<Double> values) {
            addCriterion("used_cash not in", values, "usedCash");
            return (Criteria) this;
        }

        public Criteria andUsedCashBetween(Double value1, Double value2) {
            addCriterion("used_cash between", value1, value2, "usedCash");
            return (Criteria) this;
        }

        public Criteria andUsedCashNotBetween(Double value1, Double value2) {
            addCriterion("used_cash not between", value1, value2, "usedCash");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andLinkIdIsNull() {
            addCriterion("link_id is null");
            return (Criteria) this;
        }

        public Criteria andLinkIdIsNotNull() {
            addCriterion("link_id is not null");
            return (Criteria) this;
        }

        public Criteria andLinkIdEqualTo(String value) {
            addCriterion("link_id =", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdNotEqualTo(String value) {
            addCriterion("link_id <>", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdGreaterThan(String value) {
            addCriterion("link_id >", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdGreaterThanOrEqualTo(String value) {
            addCriterion("link_id >=", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdLessThan(String value) {
            addCriterion("link_id <", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdLessThanOrEqualTo(String value) {
            addCriterion("link_id <=", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdLike(String value) {
            addCriterion("link_id like", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdNotLike(String value) {
            addCriterion("link_id not like", value, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdIn(List<String> values) {
            addCriterion("link_id in", values, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdNotIn(List<String> values) {
            addCriterion("link_id not in", values, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdBetween(String value1, String value2) {
            addCriterion("link_id between", value1, value2, "linkId");
            return (Criteria) this;
        }

        public Criteria andLinkIdNotBetween(String value1, String value2) {
            addCriterion("link_id not between", value1, value2, "linkId");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andMoIsNull() {
            addCriterion("mo is null");
            return (Criteria) this;
        }

        public Criteria andMoIsNotNull() {
            addCriterion("mo is not null");
            return (Criteria) this;
        }

        public Criteria andMoEqualTo(String value) {
            addCriterion("mo =", value, "mo");
            return (Criteria) this;
        }

        public Criteria andMoNotEqualTo(String value) {
            addCriterion("mo <>", value, "mo");
            return (Criteria) this;
        }

        public Criteria andMoGreaterThan(String value) {
            addCriterion("mo >", value, "mo");
            return (Criteria) this;
        }

        public Criteria andMoGreaterThanOrEqualTo(String value) {
            addCriterion("mo >=", value, "mo");
            return (Criteria) this;
        }

        public Criteria andMoLessThan(String value) {
            addCriterion("mo <", value, "mo");
            return (Criteria) this;
        }

        public Criteria andMoLessThanOrEqualTo(String value) {
            addCriterion("mo <=", value, "mo");
            return (Criteria) this;
        }

        public Criteria andMoLike(String value) {
            addCriterion("mo like", value, "mo");
            return (Criteria) this;
        }

        public Criteria andMoNotLike(String value) {
            addCriterion("mo not like", value, "mo");
            return (Criteria) this;
        }

        public Criteria andMoIn(List<String> values) {
            addCriterion("mo in", values, "mo");
            return (Criteria) this;
        }

        public Criteria andMoNotIn(List<String> values) {
            addCriterion("mo not in", values, "mo");
            return (Criteria) this;
        }

        public Criteria andMoBetween(String value1, String value2) {
            addCriterion("mo between", value1, value2, "mo");
            return (Criteria) this;
        }

        public Criteria andMoNotBetween(String value1, String value2) {
            addCriterion("mo not between", value1, value2, "mo");
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

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
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

        public Criteria andSpidEqualTo(Integer value) {
            addCriterion("spid =", value, "spid");
            return (Criteria) this;
        }

        public Criteria andSpidNotEqualTo(Integer value) {
            addCriterion("spid <>", value, "spid");
            return (Criteria) this;
        }

        public Criteria andSpidGreaterThan(Integer value) {
            addCriterion("spid >", value, "spid");
            return (Criteria) this;
        }

        public Criteria andSpidGreaterThanOrEqualTo(Integer value) {
            addCriterion("spid >=", value, "spid");
            return (Criteria) this;
        }

        public Criteria andSpidLessThan(Integer value) {
            addCriterion("spid <", value, "spid");
            return (Criteria) this;
        }

        public Criteria andSpidLessThanOrEqualTo(Integer value) {
            addCriterion("spid <=", value, "spid");
            return (Criteria) this;
        }

        public Criteria andSpidIn(List<Integer> values) {
            addCriterion("spid in", values, "spid");
            return (Criteria) this;
        }

        public Criteria andSpidNotIn(List<Integer> values) {
            addCriterion("spid not in", values, "spid");
            return (Criteria) this;
        }

        public Criteria andSpidBetween(Integer value1, Integer value2) {
            addCriterion("spid between", value1, value2, "spid");
            return (Criteria) this;
        }

        public Criteria andSpidNotBetween(Integer value1, Integer value2) {
            addCriterion("spid not between", value1, value2, "spid");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("operator is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("operator is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(Byte value) {
            addCriterion("operator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(Byte value) {
            addCriterion("operator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(Byte value) {
            addCriterion("operator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(Byte value) {
            addCriterion("operator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(Byte value) {
            addCriterion("operator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(Byte value) {
            addCriterion("operator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<Byte> values) {
            addCriterion("operator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<Byte> values) {
            addCriterion("operator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(Byte value1, Byte value2) {
            addCriterion("operator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(Byte value1, Byte value2) {
            addCriterion("operator not between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeIsNull() {
            addCriterion("disconnect_time is null");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeIsNotNull() {
            addCriterion("disconnect_time is not null");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeEqualTo(Date value) {
            addCriterion("disconnect_time =", value, "disconnectTime");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeNotEqualTo(Date value) {
            addCriterion("disconnect_time <>", value, "disconnectTime");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeGreaterThan(Date value) {
            addCriterion("disconnect_time >", value, "disconnectTime");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("disconnect_time >=", value, "disconnectTime");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeLessThan(Date value) {
            addCriterion("disconnect_time <", value, "disconnectTime");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeLessThanOrEqualTo(Date value) {
            addCriterion("disconnect_time <=", value, "disconnectTime");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeIn(List<Date> values) {
            addCriterion("disconnect_time in", values, "disconnectTime");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeNotIn(List<Date> values) {
            addCriterion("disconnect_time not in", values, "disconnectTime");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeBetween(Date value1, Date value2) {
            addCriterion("disconnect_time between", value1, value2, "disconnectTime");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeNotBetween(Date value1, Date value2) {
            addCriterion("disconnect_time not between", value1, value2, "disconnectTime");
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