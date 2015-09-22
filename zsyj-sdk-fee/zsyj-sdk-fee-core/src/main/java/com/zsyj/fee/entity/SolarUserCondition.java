package com.zsyj.fee.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SolarUserCondition {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SolarUserCondition() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("USER_NAME =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("USER_NAME <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("USER_NAME >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NAME >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("USER_NAME <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("USER_NAME <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("USER_NAME like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("USER_NAME not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("USER_NAME in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("USER_NAME not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("USER_NAME between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("USER_NAME not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("PASSWORD =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("PASSWORD <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("PASSWORD like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("PASSWORD not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("PASSWORD in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("PASSWORD not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("PASSWORD between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andRoleCodeIsNull() {
            addCriterion("ROLE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andRoleCodeIsNotNull() {
            addCriterion("ROLE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andRoleCodeEqualTo(String value) {
            addCriterion("ROLE_CODE =", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeNotEqualTo(String value) {
            addCriterion("ROLE_CODE <>", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeGreaterThan(String value) {
            addCriterion("ROLE_CODE >", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_CODE >=", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeLessThan(String value) {
            addCriterion("ROLE_CODE <", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeLessThanOrEqualTo(String value) {
            addCriterion("ROLE_CODE <=", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeLike(String value) {
            addCriterion("ROLE_CODE like", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeNotLike(String value) {
            addCriterion("ROLE_CODE not like", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeIn(List<String> values) {
            addCriterion("ROLE_CODE in", values, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeNotIn(List<String> values) {
            addCriterion("ROLE_CODE not in", values, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeBetween(String value1, String value2) {
            addCriterion("ROLE_CODE between", value1, value2, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeNotBetween(String value1, String value2) {
            addCriterion("ROLE_CODE not between", value1, value2, "roleCode");
            return (Criteria) this;
        }

        public Criteria andInfoDescIsNull() {
            addCriterion("INFO_DESC is null");
            return (Criteria) this;
        }

        public Criteria andInfoDescIsNotNull() {
            addCriterion("INFO_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andInfoDescEqualTo(String value) {
            addCriterion("INFO_DESC =", value, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andInfoDescNotEqualTo(String value) {
            addCriterion("INFO_DESC <>", value, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andInfoDescGreaterThan(String value) {
            addCriterion("INFO_DESC >", value, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andInfoDescGreaterThanOrEqualTo(String value) {
            addCriterion("INFO_DESC >=", value, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andInfoDescLessThan(String value) {
            addCriterion("INFO_DESC <", value, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andInfoDescLessThanOrEqualTo(String value) {
            addCriterion("INFO_DESC <=", value, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andInfoDescLike(String value) {
            addCriterion("INFO_DESC like", value, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andInfoDescNotLike(String value) {
            addCriterion("INFO_DESC not like", value, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andInfoDescIn(List<String> values) {
            addCriterion("INFO_DESC in", values, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andInfoDescNotIn(List<String> values) {
            addCriterion("INFO_DESC not in", values, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andInfoDescBetween(String value1, String value2) {
            addCriterion("INFO_DESC between", value1, value2, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andInfoDescNotBetween(String value1, String value2) {
            addCriterion("INFO_DESC not between", value1, value2, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("IP is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("IP is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("IP =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("IP <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("IP >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("IP >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("IP <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("IP <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("IP like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("IP not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("IP in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("IP not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("IP between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("IP not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andSynchAddressIsNull() {
            addCriterion("SYNCH_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andSynchAddressIsNotNull() {
            addCriterion("SYNCH_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andSynchAddressEqualTo(String value) {
            addCriterion("SYNCH_ADDRESS =", value, "synchAddress");
            return (Criteria) this;
        }

        public Criteria andSynchAddressNotEqualTo(String value) {
            addCriterion("SYNCH_ADDRESS <>", value, "synchAddress");
            return (Criteria) this;
        }

        public Criteria andSynchAddressGreaterThan(String value) {
            addCriterion("SYNCH_ADDRESS >", value, "synchAddress");
            return (Criteria) this;
        }

        public Criteria andSynchAddressGreaterThanOrEqualTo(String value) {
            addCriterion("SYNCH_ADDRESS >=", value, "synchAddress");
            return (Criteria) this;
        }

        public Criteria andSynchAddressLessThan(String value) {
            addCriterion("SYNCH_ADDRESS <", value, "synchAddress");
            return (Criteria) this;
        }

        public Criteria andSynchAddressLessThanOrEqualTo(String value) {
            addCriterion("SYNCH_ADDRESS <=", value, "synchAddress");
            return (Criteria) this;
        }

        public Criteria andSynchAddressLike(String value) {
            addCriterion("SYNCH_ADDRESS like", value, "synchAddress");
            return (Criteria) this;
        }

        public Criteria andSynchAddressNotLike(String value) {
            addCriterion("SYNCH_ADDRESS not like", value, "synchAddress");
            return (Criteria) this;
        }

        public Criteria andSynchAddressIn(List<String> values) {
            addCriterion("SYNCH_ADDRESS in", values, "synchAddress");
            return (Criteria) this;
        }

        public Criteria andSynchAddressNotIn(List<String> values) {
            addCriterion("SYNCH_ADDRESS not in", values, "synchAddress");
            return (Criteria) this;
        }

        public Criteria andSynchAddressBetween(String value1, String value2) {
            addCriterion("SYNCH_ADDRESS between", value1, value2, "synchAddress");
            return (Criteria) this;
        }

        public Criteria andSynchAddressNotBetween(String value1, String value2) {
            addCriterion("SYNCH_ADDRESS not between", value1, value2, "synchAddress");
            return (Criteria) this;
        }

        public Criteria andSmsTypeIsNull() {
            addCriterion("SMS_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andSmsTypeIsNotNull() {
            addCriterion("SMS_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSmsTypeEqualTo(String value) {
            addCriterion("SMS_TYPE =", value, "smsType");
            return (Criteria) this;
        }

        public Criteria andSmsTypeNotEqualTo(String value) {
            addCriterion("SMS_TYPE <>", value, "smsType");
            return (Criteria) this;
        }

        public Criteria andSmsTypeGreaterThan(String value) {
            addCriterion("SMS_TYPE >", value, "smsType");
            return (Criteria) this;
        }

        public Criteria andSmsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("SMS_TYPE >=", value, "smsType");
            return (Criteria) this;
        }

        public Criteria andSmsTypeLessThan(String value) {
            addCriterion("SMS_TYPE <", value, "smsType");
            return (Criteria) this;
        }

        public Criteria andSmsTypeLessThanOrEqualTo(String value) {
            addCriterion("SMS_TYPE <=", value, "smsType");
            return (Criteria) this;
        }

        public Criteria andSmsTypeLike(String value) {
            addCriterion("SMS_TYPE like", value, "smsType");
            return (Criteria) this;
        }

        public Criteria andSmsTypeNotLike(String value) {
            addCriterion("SMS_TYPE not like", value, "smsType");
            return (Criteria) this;
        }

        public Criteria andSmsTypeIn(List<String> values) {
            addCriterion("SMS_TYPE in", values, "smsType");
            return (Criteria) this;
        }

        public Criteria andSmsTypeNotIn(List<String> values) {
            addCriterion("SMS_TYPE not in", values, "smsType");
            return (Criteria) this;
        }

        public Criteria andSmsTypeBetween(String value1, String value2) {
            addCriterion("SMS_TYPE between", value1, value2, "smsType");
            return (Criteria) this;
        }

        public Criteria andSmsTypeNotBetween(String value1, String value2) {
            addCriterion("SMS_TYPE not between", value1, value2, "smsType");
            return (Criteria) this;
        }

        public Criteria andFeecaseidIsNull() {
            addCriterion("feeCaseID is null");
            return (Criteria) this;
        }

        public Criteria andFeecaseidIsNotNull() {
            addCriterion("feeCaseID is not null");
            return (Criteria) this;
        }

        public Criteria andFeecaseidEqualTo(String value) {
            addCriterion("feeCaseID =", value, "feecaseid");
            return (Criteria) this;
        }

        public Criteria andFeecaseidNotEqualTo(String value) {
            addCriterion("feeCaseID <>", value, "feecaseid");
            return (Criteria) this;
        }

        public Criteria andFeecaseidGreaterThan(String value) {
            addCriterion("feeCaseID >", value, "feecaseid");
            return (Criteria) this;
        }

        public Criteria andFeecaseidGreaterThanOrEqualTo(String value) {
            addCriterion("feeCaseID >=", value, "feecaseid");
            return (Criteria) this;
        }

        public Criteria andFeecaseidLessThan(String value) {
            addCriterion("feeCaseID <", value, "feecaseid");
            return (Criteria) this;
        }

        public Criteria andFeecaseidLessThanOrEqualTo(String value) {
            addCriterion("feeCaseID <=", value, "feecaseid");
            return (Criteria) this;
        }

        public Criteria andFeecaseidLike(String value) {
            addCriterion("feeCaseID like", value, "feecaseid");
            return (Criteria) this;
        }

        public Criteria andFeecaseidNotLike(String value) {
            addCriterion("feeCaseID not like", value, "feecaseid");
            return (Criteria) this;
        }

        public Criteria andFeecaseidIn(List<String> values) {
            addCriterion("feeCaseID in", values, "feecaseid");
            return (Criteria) this;
        }

        public Criteria andFeecaseidNotIn(List<String> values) {
            addCriterion("feeCaseID not in", values, "feecaseid");
            return (Criteria) this;
        }

        public Criteria andFeecaseidBetween(String value1, String value2) {
            addCriterion("feeCaseID between", value1, value2, "feecaseid");
            return (Criteria) this;
        }

        public Criteria andFeecaseidNotBetween(String value1, String value2) {
            addCriterion("feeCaseID not between", value1, value2, "feecaseid");
            return (Criteria) this;
        }

        public Criteria andFeedmmenuidIsNull() {
            addCriterion("feeDmmenuID is null");
            return (Criteria) this;
        }

        public Criteria andFeedmmenuidIsNotNull() {
            addCriterion("feeDmmenuID is not null");
            return (Criteria) this;
        }

        public Criteria andFeedmmenuidEqualTo(String value) {
            addCriterion("feeDmmenuID =", value, "feedmmenuid");
            return (Criteria) this;
        }

        public Criteria andFeedmmenuidNotEqualTo(String value) {
            addCriterion("feeDmmenuID <>", value, "feedmmenuid");
            return (Criteria) this;
        }

        public Criteria andFeedmmenuidGreaterThan(String value) {
            addCriterion("feeDmmenuID >", value, "feedmmenuid");
            return (Criteria) this;
        }

        public Criteria andFeedmmenuidGreaterThanOrEqualTo(String value) {
            addCriterion("feeDmmenuID >=", value, "feedmmenuid");
            return (Criteria) this;
        }

        public Criteria andFeedmmenuidLessThan(String value) {
            addCriterion("feeDmmenuID <", value, "feedmmenuid");
            return (Criteria) this;
        }

        public Criteria andFeedmmenuidLessThanOrEqualTo(String value) {
            addCriterion("feeDmmenuID <=", value, "feedmmenuid");
            return (Criteria) this;
        }

        public Criteria andFeedmmenuidLike(String value) {
            addCriterion("feeDmmenuID like", value, "feedmmenuid");
            return (Criteria) this;
        }

        public Criteria andFeedmmenuidNotLike(String value) {
            addCriterion("feeDmmenuID not like", value, "feedmmenuid");
            return (Criteria) this;
        }

        public Criteria andFeedmmenuidIn(List<String> values) {
            addCriterion("feeDmmenuID in", values, "feedmmenuid");
            return (Criteria) this;
        }

        public Criteria andFeedmmenuidNotIn(List<String> values) {
            addCriterion("feeDmmenuID not in", values, "feedmmenuid");
            return (Criteria) this;
        }

        public Criteria andFeedmmenuidBetween(String value1, String value2) {
            addCriterion("feeDmmenuID between", value1, value2, "feedmmenuid");
            return (Criteria) this;
        }

        public Criteria andFeedmmenuidNotBetween(String value1, String value2) {
            addCriterion("feeDmmenuID not between", value1, value2, "feedmmenuid");
            return (Criteria) this;
        }

        public Criteria andIsLoginIsNull() {
            addCriterion("is_login is null");
            return (Criteria) this;
        }

        public Criteria andIsLoginIsNotNull() {
            addCriterion("is_login is not null");
            return (Criteria) this;
        }

        public Criteria andIsLoginEqualTo(Integer value) {
            addCriterion("is_login =", value, "isLogin");
            return (Criteria) this;
        }

        public Criteria andIsLoginNotEqualTo(Integer value) {
            addCriterion("is_login <>", value, "isLogin");
            return (Criteria) this;
        }

        public Criteria andIsLoginGreaterThan(Integer value) {
            addCriterion("is_login >", value, "isLogin");
            return (Criteria) this;
        }

        public Criteria andIsLoginGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_login >=", value, "isLogin");
            return (Criteria) this;
        }

        public Criteria andIsLoginLessThan(Integer value) {
            addCriterion("is_login <", value, "isLogin");
            return (Criteria) this;
        }

        public Criteria andIsLoginLessThanOrEqualTo(Integer value) {
            addCriterion("is_login <=", value, "isLogin");
            return (Criteria) this;
        }

        public Criteria andIsLoginIn(List<Integer> values) {
            addCriterion("is_login in", values, "isLogin");
            return (Criteria) this;
        }

        public Criteria andIsLoginNotIn(List<Integer> values) {
            addCriterion("is_login not in", values, "isLogin");
            return (Criteria) this;
        }

        public Criteria andIsLoginBetween(Integer value1, Integer value2) {
            addCriterion("is_login between", value1, value2, "isLogin");
            return (Criteria) this;
        }

        public Criteria andIsLoginNotBetween(Integer value1, Integer value2) {
            addCriterion("is_login not between", value1, value2, "isLogin");
            return (Criteria) this;
        }

        public Criteria andIsDivideIsNull() {
            addCriterion("is_divide is null");
            return (Criteria) this;
        }

        public Criteria andIsDivideIsNotNull() {
            addCriterion("is_divide is not null");
            return (Criteria) this;
        }

        public Criteria andIsDivideEqualTo(Integer value) {
            addCriterion("is_divide =", value, "isDivide");
            return (Criteria) this;
        }

        public Criteria andIsDivideNotEqualTo(Integer value) {
            addCriterion("is_divide <>", value, "isDivide");
            return (Criteria) this;
        }

        public Criteria andIsDivideGreaterThan(Integer value) {
            addCriterion("is_divide >", value, "isDivide");
            return (Criteria) this;
        }

        public Criteria andIsDivideGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_divide >=", value, "isDivide");
            return (Criteria) this;
        }

        public Criteria andIsDivideLessThan(Integer value) {
            addCriterion("is_divide <", value, "isDivide");
            return (Criteria) this;
        }

        public Criteria andIsDivideLessThanOrEqualTo(Integer value) {
            addCriterion("is_divide <=", value, "isDivide");
            return (Criteria) this;
        }

        public Criteria andIsDivideIn(List<Integer> values) {
            addCriterion("is_divide in", values, "isDivide");
            return (Criteria) this;
        }

        public Criteria andIsDivideNotIn(List<Integer> values) {
            addCriterion("is_divide not in", values, "isDivide");
            return (Criteria) this;
        }

        public Criteria andIsDivideBetween(Integer value1, Integer value2) {
            addCriterion("is_divide between", value1, value2, "isDivide");
            return (Criteria) this;
        }

        public Criteria andIsDivideNotBetween(Integer value1, Integer value2) {
            addCriterion("is_divide not between", value1, value2, "isDivide");
            return (Criteria) this;
        }

        public Criteria andNAreaIdIsNull() {
            addCriterion("n_area_id is null");
            return (Criteria) this;
        }

        public Criteria andNAreaIdIsNotNull() {
            addCriterion("n_area_id is not null");
            return (Criteria) this;
        }

        public Criteria andNAreaIdEqualTo(Integer value) {
            addCriterion("n_area_id =", value, "nAreaId");
            return (Criteria) this;
        }

        public Criteria andNAreaIdNotEqualTo(Integer value) {
            addCriterion("n_area_id <>", value, "nAreaId");
            return (Criteria) this;
        }

        public Criteria andNAreaIdGreaterThan(Integer value) {
            addCriterion("n_area_id >", value, "nAreaId");
            return (Criteria) this;
        }

        public Criteria andNAreaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("n_area_id >=", value, "nAreaId");
            return (Criteria) this;
        }

        public Criteria andNAreaIdLessThan(Integer value) {
            addCriterion("n_area_id <", value, "nAreaId");
            return (Criteria) this;
        }

        public Criteria andNAreaIdLessThanOrEqualTo(Integer value) {
            addCriterion("n_area_id <=", value, "nAreaId");
            return (Criteria) this;
        }

        public Criteria andNAreaIdIn(List<Integer> values) {
            addCriterion("n_area_id in", values, "nAreaId");
            return (Criteria) this;
        }

        public Criteria andNAreaIdNotIn(List<Integer> values) {
            addCriterion("n_area_id not in", values, "nAreaId");
            return (Criteria) this;
        }

        public Criteria andNAreaIdBetween(Integer value1, Integer value2) {
            addCriterion("n_area_id between", value1, value2, "nAreaId");
            return (Criteria) this;
        }

        public Criteria andNAreaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("n_area_id not between", value1, value2, "nAreaId");
            return (Criteria) this;
        }

        public Criteria andIsMobileSaleIsNull() {
            addCriterion("is_mobile_sale is null");
            return (Criteria) this;
        }

        public Criteria andIsMobileSaleIsNotNull() {
            addCriterion("is_mobile_sale is not null");
            return (Criteria) this;
        }

        public Criteria andIsMobileSaleEqualTo(Integer value) {
            addCriterion("is_mobile_sale =", value, "isMobileSale");
            return (Criteria) this;
        }

        public Criteria andIsMobileSaleNotEqualTo(Integer value) {
            addCriterion("is_mobile_sale <>", value, "isMobileSale");
            return (Criteria) this;
        }

        public Criteria andIsMobileSaleGreaterThan(Integer value) {
            addCriterion("is_mobile_sale >", value, "isMobileSale");
            return (Criteria) this;
        }

        public Criteria andIsMobileSaleGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_mobile_sale >=", value, "isMobileSale");
            return (Criteria) this;
        }

        public Criteria andIsMobileSaleLessThan(Integer value) {
            addCriterion("is_mobile_sale <", value, "isMobileSale");
            return (Criteria) this;
        }

        public Criteria andIsMobileSaleLessThanOrEqualTo(Integer value) {
            addCriterion("is_mobile_sale <=", value, "isMobileSale");
            return (Criteria) this;
        }

        public Criteria andIsMobileSaleIn(List<Integer> values) {
            addCriterion("is_mobile_sale in", values, "isMobileSale");
            return (Criteria) this;
        }

        public Criteria andIsMobileSaleNotIn(List<Integer> values) {
            addCriterion("is_mobile_sale not in", values, "isMobileSale");
            return (Criteria) this;
        }

        public Criteria andIsMobileSaleBetween(Integer value1, Integer value2) {
            addCriterion("is_mobile_sale between", value1, value2, "isMobileSale");
            return (Criteria) this;
        }

        public Criteria andIsMobileSaleNotBetween(Integer value1, Integer value2) {
            addCriterion("is_mobile_sale not between", value1, value2, "isMobileSale");
            return (Criteria) this;
        }

        public Criteria andIsBizsysEnabledIsNull() {
            addCriterion("is_bizsys_enabled is null");
            return (Criteria) this;
        }

        public Criteria andIsBizsysEnabledIsNotNull() {
            addCriterion("is_bizsys_enabled is not null");
            return (Criteria) this;
        }

        public Criteria andIsBizsysEnabledEqualTo(String value) {
            addCriterion("is_bizsys_enabled =", value, "isBizsysEnabled");
            return (Criteria) this;
        }

        public Criteria andIsBizsysEnabledNotEqualTo(String value) {
            addCriterion("is_bizsys_enabled <>", value, "isBizsysEnabled");
            return (Criteria) this;
        }

        public Criteria andIsBizsysEnabledGreaterThan(String value) {
            addCriterion("is_bizsys_enabled >", value, "isBizsysEnabled");
            return (Criteria) this;
        }

        public Criteria andIsBizsysEnabledGreaterThanOrEqualTo(String value) {
            addCriterion("is_bizsys_enabled >=", value, "isBizsysEnabled");
            return (Criteria) this;
        }

        public Criteria andIsBizsysEnabledLessThan(String value) {
            addCriterion("is_bizsys_enabled <", value, "isBizsysEnabled");
            return (Criteria) this;
        }

        public Criteria andIsBizsysEnabledLessThanOrEqualTo(String value) {
            addCriterion("is_bizsys_enabled <=", value, "isBizsysEnabled");
            return (Criteria) this;
        }

        public Criteria andIsBizsysEnabledLike(String value) {
            addCriterion("is_bizsys_enabled like", value, "isBizsysEnabled");
            return (Criteria) this;
        }

        public Criteria andIsBizsysEnabledNotLike(String value) {
            addCriterion("is_bizsys_enabled not like", value, "isBizsysEnabled");
            return (Criteria) this;
        }

        public Criteria andIsBizsysEnabledIn(List<String> values) {
            addCriterion("is_bizsys_enabled in", values, "isBizsysEnabled");
            return (Criteria) this;
        }

        public Criteria andIsBizsysEnabledNotIn(List<String> values) {
            addCriterion("is_bizsys_enabled not in", values, "isBizsysEnabled");
            return (Criteria) this;
        }

        public Criteria andIsBizsysEnabledBetween(String value1, String value2) {
            addCriterion("is_bizsys_enabled between", value1, value2, "isBizsysEnabled");
            return (Criteria) this;
        }

        public Criteria andIsBizsysEnabledNotBetween(String value1, String value2) {
            addCriterion("is_bizsys_enabled not between", value1, value2, "isBizsysEnabled");
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