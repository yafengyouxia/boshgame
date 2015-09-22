package com.zsyj.fee.entity;

import java.util.ArrayList;
import java.util.List;

public class SmsconfigInfoCondition {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SmsconfigInfoCondition() {
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

        public Criteria andSysidIsNull() {
            addCriterion("sysID is null");
            return (Criteria) this;
        }

        public Criteria andSysidIsNotNull() {
            addCriterion("sysID is not null");
            return (Criteria) this;
        }

        public Criteria andSysidEqualTo(Integer value) {
            addCriterion("sysID =", value, "sysid");
            return (Criteria) this;
        }

        public Criteria andSysidNotEqualTo(Integer value) {
            addCriterion("sysID <>", value, "sysid");
            return (Criteria) this;
        }

        public Criteria andSysidGreaterThan(Integer value) {
            addCriterion("sysID >", value, "sysid");
            return (Criteria) this;
        }

        public Criteria andSysidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sysID >=", value, "sysid");
            return (Criteria) this;
        }

        public Criteria andSysidLessThan(Integer value) {
            addCriterion("sysID <", value, "sysid");
            return (Criteria) this;
        }

        public Criteria andSysidLessThanOrEqualTo(Integer value) {
            addCriterion("sysID <=", value, "sysid");
            return (Criteria) this;
        }

        public Criteria andSysidIn(List<Integer> values) {
            addCriterion("sysID in", values, "sysid");
            return (Criteria) this;
        }

        public Criteria andSysidNotIn(List<Integer> values) {
            addCriterion("sysID not in", values, "sysid");
            return (Criteria) this;
        }

        public Criteria andSysidBetween(Integer value1, Integer value2) {
            addCriterion("sysID between", value1, value2, "sysid");
            return (Criteria) this;
        }

        public Criteria andSysidNotBetween(Integer value1, Integer value2) {
            addCriterion("sysID not between", value1, value2, "sysid");
            return (Criteria) this;
        }

        public Criteria andConfigidIsNull() {
            addCriterion("configID is null");
            return (Criteria) this;
        }

        public Criteria andConfigidIsNotNull() {
            addCriterion("configID is not null");
            return (Criteria) this;
        }

        public Criteria andConfigidEqualTo(Integer value) {
            addCriterion("configID =", value, "configid");
            return (Criteria) this;
        }

        public Criteria andConfigidNotEqualTo(Integer value) {
            addCriterion("configID <>", value, "configid");
            return (Criteria) this;
        }

        public Criteria andConfigidGreaterThan(Integer value) {
            addCriterion("configID >", value, "configid");
            return (Criteria) this;
        }

        public Criteria andConfigidGreaterThanOrEqualTo(Integer value) {
            addCriterion("configID >=", value, "configid");
            return (Criteria) this;
        }

        public Criteria andConfigidLessThan(Integer value) {
            addCriterion("configID <", value, "configid");
            return (Criteria) this;
        }

        public Criteria andConfigidLessThanOrEqualTo(Integer value) {
            addCriterion("configID <=", value, "configid");
            return (Criteria) this;
        }

        public Criteria andConfigidIn(List<Integer> values) {
            addCriterion("configID in", values, "configid");
            return (Criteria) this;
        }

        public Criteria andConfigidNotIn(List<Integer> values) {
            addCriterion("configID not in", values, "configid");
            return (Criteria) this;
        }

        public Criteria andConfigidBetween(Integer value1, Integer value2) {
            addCriterion("configID between", value1, value2, "configid");
            return (Criteria) this;
        }

        public Criteria andConfigidNotBetween(Integer value1, Integer value2) {
            addCriterion("configID not between", value1, value2, "configid");
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

        public Criteria andConfirmcommandIsNull() {
            addCriterion("confirmCommand is null");
            return (Criteria) this;
        }

        public Criteria andConfirmcommandIsNotNull() {
            addCriterion("confirmCommand is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmcommandEqualTo(String value) {
            addCriterion("confirmCommand =", value, "confirmcommand");
            return (Criteria) this;
        }

        public Criteria andConfirmcommandNotEqualTo(String value) {
            addCriterion("confirmCommand <>", value, "confirmcommand");
            return (Criteria) this;
        }

        public Criteria andConfirmcommandGreaterThan(String value) {
            addCriterion("confirmCommand >", value, "confirmcommand");
            return (Criteria) this;
        }

        public Criteria andConfirmcommandGreaterThanOrEqualTo(String value) {
            addCriterion("confirmCommand >=", value, "confirmcommand");
            return (Criteria) this;
        }

        public Criteria andConfirmcommandLessThan(String value) {
            addCriterion("confirmCommand <", value, "confirmcommand");
            return (Criteria) this;
        }

        public Criteria andConfirmcommandLessThanOrEqualTo(String value) {
            addCriterion("confirmCommand <=", value, "confirmcommand");
            return (Criteria) this;
        }

        public Criteria andConfirmcommandLike(String value) {
            addCriterion("confirmCommand like", value, "confirmcommand");
            return (Criteria) this;
        }

        public Criteria andConfirmcommandNotLike(String value) {
            addCriterion("confirmCommand not like", value, "confirmcommand");
            return (Criteria) this;
        }

        public Criteria andConfirmcommandIn(List<String> values) {
            addCriterion("confirmCommand in", values, "confirmcommand");
            return (Criteria) this;
        }

        public Criteria andConfirmcommandNotIn(List<String> values) {
            addCriterion("confirmCommand not in", values, "confirmcommand");
            return (Criteria) this;
        }

        public Criteria andConfirmcommandBetween(String value1, String value2) {
            addCriterion("confirmCommand between", value1, value2, "confirmcommand");
            return (Criteria) this;
        }

        public Criteria andConfirmcommandNotBetween(String value1, String value2) {
            addCriterion("confirmCommand not between", value1, value2, "confirmcommand");
            return (Criteria) this;
        }

        public Criteria andConfirmtroneIsNull() {
            addCriterion("confirmTrone is null");
            return (Criteria) this;
        }

        public Criteria andConfirmtroneIsNotNull() {
            addCriterion("confirmTrone is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmtroneEqualTo(String value) {
            addCriterion("confirmTrone =", value, "confirmtrone");
            return (Criteria) this;
        }

        public Criteria andConfirmtroneNotEqualTo(String value) {
            addCriterion("confirmTrone <>", value, "confirmtrone");
            return (Criteria) this;
        }

        public Criteria andConfirmtroneGreaterThan(String value) {
            addCriterion("confirmTrone >", value, "confirmtrone");
            return (Criteria) this;
        }

        public Criteria andConfirmtroneGreaterThanOrEqualTo(String value) {
            addCriterion("confirmTrone >=", value, "confirmtrone");
            return (Criteria) this;
        }

        public Criteria andConfirmtroneLessThan(String value) {
            addCriterion("confirmTrone <", value, "confirmtrone");
            return (Criteria) this;
        }

        public Criteria andConfirmtroneLessThanOrEqualTo(String value) {
            addCriterion("confirmTrone <=", value, "confirmtrone");
            return (Criteria) this;
        }

        public Criteria andConfirmtroneLike(String value) {
            addCriterion("confirmTrone like", value, "confirmtrone");
            return (Criteria) this;
        }

        public Criteria andConfirmtroneNotLike(String value) {
            addCriterion("confirmTrone not like", value, "confirmtrone");
            return (Criteria) this;
        }

        public Criteria andConfirmtroneIn(List<String> values) {
            addCriterion("confirmTrone in", values, "confirmtrone");
            return (Criteria) this;
        }

        public Criteria andConfirmtroneNotIn(List<String> values) {
            addCriterion("confirmTrone not in", values, "confirmtrone");
            return (Criteria) this;
        }

        public Criteria andConfirmtroneBetween(String value1, String value2) {
            addCriterion("confirmTrone between", value1, value2, "confirmtrone");
            return (Criteria) this;
        }

        public Criteria andConfirmtroneNotBetween(String value1, String value2) {
            addCriterion("confirmTrone not between", value1, value2, "confirmtrone");
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

        public Criteria andFeeEqualTo(String value) {
            addCriterion("fee =", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotEqualTo(String value) {
            addCriterion("fee <>", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThan(String value) {
            addCriterion("fee >", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThanOrEqualTo(String value) {
            addCriterion("fee >=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThan(String value) {
            addCriterion("fee <", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThanOrEqualTo(String value) {
            addCriterion("fee <=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLike(String value) {
            addCriterion("fee like", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotLike(String value) {
            addCriterion("fee not like", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeIn(List<String> values) {
            addCriterion("fee in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotIn(List<String> values) {
            addCriterion("fee not in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeBetween(String value1, String value2) {
            addCriterion("fee between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotBetween(String value1, String value2) {
            addCriterion("fee not between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andServicecodeIsNull() {
            addCriterion("serviceCode is null");
            return (Criteria) this;
        }

        public Criteria andServicecodeIsNotNull() {
            addCriterion("serviceCode is not null");
            return (Criteria) this;
        }

        public Criteria andServicecodeEqualTo(String value) {
            addCriterion("serviceCode =", value, "servicecode");
            return (Criteria) this;
        }

        public Criteria andServicecodeNotEqualTo(String value) {
            addCriterion("serviceCode <>", value, "servicecode");
            return (Criteria) this;
        }

        public Criteria andServicecodeGreaterThan(String value) {
            addCriterion("serviceCode >", value, "servicecode");
            return (Criteria) this;
        }

        public Criteria andServicecodeGreaterThanOrEqualTo(String value) {
            addCriterion("serviceCode >=", value, "servicecode");
            return (Criteria) this;
        }

        public Criteria andServicecodeLessThan(String value) {
            addCriterion("serviceCode <", value, "servicecode");
            return (Criteria) this;
        }

        public Criteria andServicecodeLessThanOrEqualTo(String value) {
            addCriterion("serviceCode <=", value, "servicecode");
            return (Criteria) this;
        }

        public Criteria andServicecodeLike(String value) {
            addCriterion("serviceCode like", value, "servicecode");
            return (Criteria) this;
        }

        public Criteria andServicecodeNotLike(String value) {
            addCriterion("serviceCode not like", value, "servicecode");
            return (Criteria) this;
        }

        public Criteria andServicecodeIn(List<String> values) {
            addCriterion("serviceCode in", values, "servicecode");
            return (Criteria) this;
        }

        public Criteria andServicecodeNotIn(List<String> values) {
            addCriterion("serviceCode not in", values, "servicecode");
            return (Criteria) this;
        }

        public Criteria andServicecodeBetween(String value1, String value2) {
            addCriterion("serviceCode between", value1, value2, "servicecode");
            return (Criteria) this;
        }

        public Criteria andServicecodeNotBetween(String value1, String value2) {
            addCriterion("serviceCode not between", value1, value2, "servicecode");
            return (Criteria) this;
        }

        public Criteria andConfignameIsNull() {
            addCriterion("configName is null");
            return (Criteria) this;
        }

        public Criteria andConfignameIsNotNull() {
            addCriterion("configName is not null");
            return (Criteria) this;
        }

        public Criteria andConfignameEqualTo(String value) {
            addCriterion("configName =", value, "configname");
            return (Criteria) this;
        }

        public Criteria andConfignameNotEqualTo(String value) {
            addCriterion("configName <>", value, "configname");
            return (Criteria) this;
        }

        public Criteria andConfignameGreaterThan(String value) {
            addCriterion("configName >", value, "configname");
            return (Criteria) this;
        }

        public Criteria andConfignameGreaterThanOrEqualTo(String value) {
            addCriterion("configName >=", value, "configname");
            return (Criteria) this;
        }

        public Criteria andConfignameLessThan(String value) {
            addCriterion("configName <", value, "configname");
            return (Criteria) this;
        }

        public Criteria andConfignameLessThanOrEqualTo(String value) {
            addCriterion("configName <=", value, "configname");
            return (Criteria) this;
        }

        public Criteria andConfignameLike(String value) {
            addCriterion("configName like", value, "configname");
            return (Criteria) this;
        }

        public Criteria andConfignameNotLike(String value) {
            addCriterion("configName not like", value, "configname");
            return (Criteria) this;
        }

        public Criteria andConfignameIn(List<String> values) {
            addCriterion("configName in", values, "configname");
            return (Criteria) this;
        }

        public Criteria andConfignameNotIn(List<String> values) {
            addCriterion("configName not in", values, "configname");
            return (Criteria) this;
        }

        public Criteria andConfignameBetween(String value1, String value2) {
            addCriterion("configName between", value1, value2, "configname");
            return (Criteria) this;
        }

        public Criteria andConfignameNotBetween(String value1, String value2) {
            addCriterion("configName not between", value1, value2, "configname");
            return (Criteria) this;
        }

        public Criteria andDeleteinfoIsNull() {
            addCriterion("deleteInfo is null");
            return (Criteria) this;
        }

        public Criteria andDeleteinfoIsNotNull() {
            addCriterion("deleteInfo is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteinfoEqualTo(String value) {
            addCriterion("deleteInfo =", value, "deleteinfo");
            return (Criteria) this;
        }

        public Criteria andDeleteinfoNotEqualTo(String value) {
            addCriterion("deleteInfo <>", value, "deleteinfo");
            return (Criteria) this;
        }

        public Criteria andDeleteinfoGreaterThan(String value) {
            addCriterion("deleteInfo >", value, "deleteinfo");
            return (Criteria) this;
        }

        public Criteria andDeleteinfoGreaterThanOrEqualTo(String value) {
            addCriterion("deleteInfo >=", value, "deleteinfo");
            return (Criteria) this;
        }

        public Criteria andDeleteinfoLessThan(String value) {
            addCriterion("deleteInfo <", value, "deleteinfo");
            return (Criteria) this;
        }

        public Criteria andDeleteinfoLessThanOrEqualTo(String value) {
            addCriterion("deleteInfo <=", value, "deleteinfo");
            return (Criteria) this;
        }

        public Criteria andDeleteinfoLike(String value) {
            addCriterion("deleteInfo like", value, "deleteinfo");
            return (Criteria) this;
        }

        public Criteria andDeleteinfoNotLike(String value) {
            addCriterion("deleteInfo not like", value, "deleteinfo");
            return (Criteria) this;
        }

        public Criteria andDeleteinfoIn(List<String> values) {
            addCriterion("deleteInfo in", values, "deleteinfo");
            return (Criteria) this;
        }

        public Criteria andDeleteinfoNotIn(List<String> values) {
            addCriterion("deleteInfo not in", values, "deleteinfo");
            return (Criteria) this;
        }

        public Criteria andDeleteinfoBetween(String value1, String value2) {
            addCriterion("deleteInfo between", value1, value2, "deleteinfo");
            return (Criteria) this;
        }

        public Criteria andDeleteinfoNotBetween(String value1, String value2) {
            addCriterion("deleteInfo not between", value1, value2, "deleteinfo");
            return (Criteria) this;
        }

        public Criteria andDeletenoIsNull() {
            addCriterion("deleteNo is null");
            return (Criteria) this;
        }

        public Criteria andDeletenoIsNotNull() {
            addCriterion("deleteNo is not null");
            return (Criteria) this;
        }

        public Criteria andDeletenoEqualTo(String value) {
            addCriterion("deleteNo =", value, "deleteno");
            return (Criteria) this;
        }

        public Criteria andDeletenoNotEqualTo(String value) {
            addCriterion("deleteNo <>", value, "deleteno");
            return (Criteria) this;
        }

        public Criteria andDeletenoGreaterThan(String value) {
            addCriterion("deleteNo >", value, "deleteno");
            return (Criteria) this;
        }

        public Criteria andDeletenoGreaterThanOrEqualTo(String value) {
            addCriterion("deleteNo >=", value, "deleteno");
            return (Criteria) this;
        }

        public Criteria andDeletenoLessThan(String value) {
            addCriterion("deleteNo <", value, "deleteno");
            return (Criteria) this;
        }

        public Criteria andDeletenoLessThanOrEqualTo(String value) {
            addCriterion("deleteNo <=", value, "deleteno");
            return (Criteria) this;
        }

        public Criteria andDeletenoLike(String value) {
            addCriterion("deleteNo like", value, "deleteno");
            return (Criteria) this;
        }

        public Criteria andDeletenoNotLike(String value) {
            addCriterion("deleteNo not like", value, "deleteno");
            return (Criteria) this;
        }

        public Criteria andDeletenoIn(List<String> values) {
            addCriterion("deleteNo in", values, "deleteno");
            return (Criteria) this;
        }

        public Criteria andDeletenoNotIn(List<String> values) {
            addCriterion("deleteNo not in", values, "deleteno");
            return (Criteria) this;
        }

        public Criteria andDeletenoBetween(String value1, String value2) {
            addCriterion("deleteNo between", value1, value2, "deleteno");
            return (Criteria) this;
        }

        public Criteria andDeletenoNotBetween(String value1, String value2) {
            addCriterion("deleteNo not between", value1, value2, "deleteno");
            return (Criteria) this;
        }

        public Criteria andTronetypeIsNull() {
            addCriterion("tronetype is null");
            return (Criteria) this;
        }

        public Criteria andTronetypeIsNotNull() {
            addCriterion("tronetype is not null");
            return (Criteria) this;
        }

        public Criteria andTronetypeEqualTo(Byte value) {
            addCriterion("tronetype =", value, "tronetype");
            return (Criteria) this;
        }

        public Criteria andTronetypeNotEqualTo(Byte value) {
            addCriterion("tronetype <>", value, "tronetype");
            return (Criteria) this;
        }

        public Criteria andTronetypeGreaterThan(Byte value) {
            addCriterion("tronetype >", value, "tronetype");
            return (Criteria) this;
        }

        public Criteria andTronetypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("tronetype >=", value, "tronetype");
            return (Criteria) this;
        }

        public Criteria andTronetypeLessThan(Byte value) {
            addCriterion("tronetype <", value, "tronetype");
            return (Criteria) this;
        }

        public Criteria andTronetypeLessThanOrEqualTo(Byte value) {
            addCriterion("tronetype <=", value, "tronetype");
            return (Criteria) this;
        }

        public Criteria andTronetypeIn(List<Byte> values) {
            addCriterion("tronetype in", values, "tronetype");
            return (Criteria) this;
        }

        public Criteria andTronetypeNotIn(List<Byte> values) {
            addCriterion("tronetype not in", values, "tronetype");
            return (Criteria) this;
        }

        public Criteria andTronetypeBetween(Byte value1, Byte value2) {
            addCriterion("tronetype between", value1, value2, "tronetype");
            return (Criteria) this;
        }

        public Criteria andTronetypeNotBetween(Byte value1, Byte value2) {
            addCriterion("tronetype not between", value1, value2, "tronetype");
            return (Criteria) this;
        }

        public Criteria andBelongIsNull() {
            addCriterion("belong is null");
            return (Criteria) this;
        }

        public Criteria andBelongIsNotNull() {
            addCriterion("belong is not null");
            return (Criteria) this;
        }

        public Criteria andBelongEqualTo(String value) {
            addCriterion("belong =", value, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongNotEqualTo(String value) {
            addCriterion("belong <>", value, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongGreaterThan(String value) {
            addCriterion("belong >", value, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongGreaterThanOrEqualTo(String value) {
            addCriterion("belong >=", value, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongLessThan(String value) {
            addCriterion("belong <", value, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongLessThanOrEqualTo(String value) {
            addCriterion("belong <=", value, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongLike(String value) {
            addCriterion("belong like", value, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongNotLike(String value) {
            addCriterion("belong not like", value, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongIn(List<String> values) {
            addCriterion("belong in", values, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongNotIn(List<String> values) {
            addCriterion("belong not in", values, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongBetween(String value1, String value2) {
            addCriterion("belong between", value1, value2, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongNotBetween(String value1, String value2) {
            addCriterion("belong not between", value1, value2, "belong");
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

        public Criteria andFirstMtKeywordIsNull() {
            addCriterion("first_mt_keyword is null");
            return (Criteria) this;
        }

        public Criteria andFirstMtKeywordIsNotNull() {
            addCriterion("first_mt_keyword is not null");
            return (Criteria) this;
        }

        public Criteria andFirstMtKeywordEqualTo(String value) {
            addCriterion("first_mt_keyword =", value, "firstMtKeyword");
            return (Criteria) this;
        }

        public Criteria andFirstMtKeywordNotEqualTo(String value) {
            addCriterion("first_mt_keyword <>", value, "firstMtKeyword");
            return (Criteria) this;
        }

        public Criteria andFirstMtKeywordGreaterThan(String value) {
            addCriterion("first_mt_keyword >", value, "firstMtKeyword");
            return (Criteria) this;
        }

        public Criteria andFirstMtKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("first_mt_keyword >=", value, "firstMtKeyword");
            return (Criteria) this;
        }

        public Criteria andFirstMtKeywordLessThan(String value) {
            addCriterion("first_mt_keyword <", value, "firstMtKeyword");
            return (Criteria) this;
        }

        public Criteria andFirstMtKeywordLessThanOrEqualTo(String value) {
            addCriterion("first_mt_keyword <=", value, "firstMtKeyword");
            return (Criteria) this;
        }

        public Criteria andFirstMtKeywordLike(String value) {
            addCriterion("first_mt_keyword like", value, "firstMtKeyword");
            return (Criteria) this;
        }

        public Criteria andFirstMtKeywordNotLike(String value) {
            addCriterion("first_mt_keyword not like", value, "firstMtKeyword");
            return (Criteria) this;
        }

        public Criteria andFirstMtKeywordIn(List<String> values) {
            addCriterion("first_mt_keyword in", values, "firstMtKeyword");
            return (Criteria) this;
        }

        public Criteria andFirstMtKeywordNotIn(List<String> values) {
            addCriterion("first_mt_keyword not in", values, "firstMtKeyword");
            return (Criteria) this;
        }

        public Criteria andFirstMtKeywordBetween(String value1, String value2) {
            addCriterion("first_mt_keyword between", value1, value2, "firstMtKeyword");
            return (Criteria) this;
        }

        public Criteria andFirstMtKeywordNotBetween(String value1, String value2) {
            addCriterion("first_mt_keyword not between", value1, value2, "firstMtKeyword");
            return (Criteria) this;
        }

        public Criteria andSpCidIsNull() {
            addCriterion("sp_cid is null");
            return (Criteria) this;
        }

        public Criteria andSpCidIsNotNull() {
            addCriterion("sp_cid is not null");
            return (Criteria) this;
        }

        public Criteria andSpCidEqualTo(Integer value) {
            addCriterion("sp_cid =", value, "spCid");
            return (Criteria) this;
        }

        public Criteria andSpCidNotEqualTo(Integer value) {
            addCriterion("sp_cid <>", value, "spCid");
            return (Criteria) this;
        }

        public Criteria andSpCidGreaterThan(Integer value) {
            addCriterion("sp_cid >", value, "spCid");
            return (Criteria) this;
        }

        public Criteria andSpCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sp_cid >=", value, "spCid");
            return (Criteria) this;
        }

        public Criteria andSpCidLessThan(Integer value) {
            addCriterion("sp_cid <", value, "spCid");
            return (Criteria) this;
        }

        public Criteria andSpCidLessThanOrEqualTo(Integer value) {
            addCriterion("sp_cid <=", value, "spCid");
            return (Criteria) this;
        }

        public Criteria andSpCidIn(List<Integer> values) {
            addCriterion("sp_cid in", values, "spCid");
            return (Criteria) this;
        }

        public Criteria andSpCidNotIn(List<Integer> values) {
            addCriterion("sp_cid not in", values, "spCid");
            return (Criteria) this;
        }

        public Criteria andSpCidBetween(Integer value1, Integer value2) {
            addCriterion("sp_cid between", value1, value2, "spCid");
            return (Criteria) this;
        }

        public Criteria andSpCidNotBetween(Integer value1, Integer value2) {
            addCriterion("sp_cid not between", value1, value2, "spCid");
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