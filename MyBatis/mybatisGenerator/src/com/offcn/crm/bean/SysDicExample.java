package com.offcn.crm.bean;

import java.util.ArrayList;
import java.util.List;

public class SysDicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysDicExample() {
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

        public Criteria andDidIsNull() {
            addCriterion("dID is null");
            return (Criteria) this;
        }

        public Criteria andDidIsNotNull() {
            addCriterion("dID is not null");
            return (Criteria) this;
        }

        public Criteria andDidEqualTo(Integer value) {
            addCriterion("dID =", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotEqualTo(Integer value) {
            addCriterion("dID <>", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidGreaterThan(Integer value) {
            addCriterion("dID >", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidGreaterThanOrEqualTo(Integer value) {
            addCriterion("dID >=", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidLessThan(Integer value) {
            addCriterion("dID <", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidLessThanOrEqualTo(Integer value) {
            addCriterion("dID <=", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidIn(List<Integer> values) {
            addCriterion("dID in", values, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotIn(List<Integer> values) {
            addCriterion("dID not in", values, "did");
            return (Criteria) this;
        }

        public Criteria andDidBetween(Integer value1, Integer value2) {
            addCriterion("dID between", value1, value2, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotBetween(Integer value1, Integer value2) {
            addCriterion("dID not between", value1, value2, "did");
            return (Criteria) this;
        }

        public Criteria andTablenameIsNull() {
            addCriterion("tablename is null");
            return (Criteria) this;
        }

        public Criteria andTablenameIsNotNull() {
            addCriterion("tablename is not null");
            return (Criteria) this;
        }

        public Criteria andTablenameEqualTo(String value) {
            addCriterion("tablename =", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotEqualTo(String value) {
            addCriterion("tablename <>", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameGreaterThan(String value) {
            addCriterion("tablename >", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameGreaterThanOrEqualTo(String value) {
            addCriterion("tablename >=", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLessThan(String value) {
            addCriterion("tablename <", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLessThanOrEqualTo(String value) {
            addCriterion("tablename <=", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLike(String value) {
            addCriterion("tablename like", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotLike(String value) {
            addCriterion("tablename not like", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameIn(List<String> values) {
            addCriterion("tablename in", values, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotIn(List<String> values) {
            addCriterion("tablename not in", values, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameBetween(String value1, String value2) {
            addCriterion("tablename between", value1, value2, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotBetween(String value1, String value2) {
            addCriterion("tablename not between", value1, value2, "tablename");
            return (Criteria) this;
        }

        public Criteria andColumnnameIsNull() {
            addCriterion("columnname is null");
            return (Criteria) this;
        }

        public Criteria andColumnnameIsNotNull() {
            addCriterion("columnname is not null");
            return (Criteria) this;
        }

        public Criteria andColumnnameEqualTo(String value) {
            addCriterion("columnname =", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameNotEqualTo(String value) {
            addCriterion("columnname <>", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameGreaterThan(String value) {
            addCriterion("columnname >", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameGreaterThanOrEqualTo(String value) {
            addCriterion("columnname >=", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameLessThan(String value) {
            addCriterion("columnname <", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameLessThanOrEqualTo(String value) {
            addCriterion("columnname <=", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameLike(String value) {
            addCriterion("columnname like", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameNotLike(String value) {
            addCriterion("columnname not like", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameIn(List<String> values) {
            addCriterion("columnname in", values, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameNotIn(List<String> values) {
            addCriterion("columnname not in", values, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameBetween(String value1, String value2) {
            addCriterion("columnname between", value1, value2, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameNotBetween(String value1, String value2) {
            addCriterion("columnname not between", value1, value2, "columnname");
            return (Criteria) this;
        }

        public Criteria andDcodeIsNull() {
            addCriterion("dcode is null");
            return (Criteria) this;
        }

        public Criteria andDcodeIsNotNull() {
            addCriterion("dcode is not null");
            return (Criteria) this;
        }

        public Criteria andDcodeEqualTo(String value) {
            addCriterion("dcode =", value, "dcode");
            return (Criteria) this;
        }

        public Criteria andDcodeNotEqualTo(String value) {
            addCriterion("dcode <>", value, "dcode");
            return (Criteria) this;
        }

        public Criteria andDcodeGreaterThan(String value) {
            addCriterion("dcode >", value, "dcode");
            return (Criteria) this;
        }

        public Criteria andDcodeGreaterThanOrEqualTo(String value) {
            addCriterion("dcode >=", value, "dcode");
            return (Criteria) this;
        }

        public Criteria andDcodeLessThan(String value) {
            addCriterion("dcode <", value, "dcode");
            return (Criteria) this;
        }

        public Criteria andDcodeLessThanOrEqualTo(String value) {
            addCriterion("dcode <=", value, "dcode");
            return (Criteria) this;
        }

        public Criteria andDcodeLike(String value) {
            addCriterion("dcode like", value, "dcode");
            return (Criteria) this;
        }

        public Criteria andDcodeNotLike(String value) {
            addCriterion("dcode not like", value, "dcode");
            return (Criteria) this;
        }

        public Criteria andDcodeIn(List<String> values) {
            addCriterion("dcode in", values, "dcode");
            return (Criteria) this;
        }

        public Criteria andDcodeNotIn(List<String> values) {
            addCriterion("dcode not in", values, "dcode");
            return (Criteria) this;
        }

        public Criteria andDcodeBetween(String value1, String value2) {
            addCriterion("dcode between", value1, value2, "dcode");
            return (Criteria) this;
        }

        public Criteria andDcodeNotBetween(String value1, String value2) {
            addCriterion("dcode not between", value1, value2, "dcode");
            return (Criteria) this;
        }

        public Criteria andDvalueIsNull() {
            addCriterion("dvalue is null");
            return (Criteria) this;
        }

        public Criteria andDvalueIsNotNull() {
            addCriterion("dvalue is not null");
            return (Criteria) this;
        }

        public Criteria andDvalueEqualTo(String value) {
            addCriterion("dvalue =", value, "dvalue");
            return (Criteria) this;
        }

        public Criteria andDvalueNotEqualTo(String value) {
            addCriterion("dvalue <>", value, "dvalue");
            return (Criteria) this;
        }

        public Criteria andDvalueGreaterThan(String value) {
            addCriterion("dvalue >", value, "dvalue");
            return (Criteria) this;
        }

        public Criteria andDvalueGreaterThanOrEqualTo(String value) {
            addCriterion("dvalue >=", value, "dvalue");
            return (Criteria) this;
        }

        public Criteria andDvalueLessThan(String value) {
            addCriterion("dvalue <", value, "dvalue");
            return (Criteria) this;
        }

        public Criteria andDvalueLessThanOrEqualTo(String value) {
            addCriterion("dvalue <=", value, "dvalue");
            return (Criteria) this;
        }

        public Criteria andDvalueLike(String value) {
            addCriterion("dvalue like", value, "dvalue");
            return (Criteria) this;
        }

        public Criteria andDvalueNotLike(String value) {
            addCriterion("dvalue not like", value, "dvalue");
            return (Criteria) this;
        }

        public Criteria andDvalueIn(List<String> values) {
            addCriterion("dvalue in", values, "dvalue");
            return (Criteria) this;
        }

        public Criteria andDvalueNotIn(List<String> values) {
            addCriterion("dvalue not in", values, "dvalue");
            return (Criteria) this;
        }

        public Criteria andDvalueBetween(String value1, String value2) {
            addCriterion("dvalue between", value1, value2, "dvalue");
            return (Criteria) this;
        }

        public Criteria andDvalueNotBetween(String value1, String value2) {
            addCriterion("dvalue not between", value1, value2, "dvalue");
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