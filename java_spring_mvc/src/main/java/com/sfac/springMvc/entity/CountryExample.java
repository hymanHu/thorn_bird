package com.sfac.springMvc.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description: Country Example
 * @author HymanHu
 * @date 2020-12-09 11:16:49
 */
public class CountryExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public CountryExample() {
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

        public Criteria andCountryIdIsNull() {
            addCriterion("country_id is null");
            return (Criteria) this;
        }

        public Criteria andCountryIdIsNotNull() {
            addCriterion("country_id is not null");
            return (Criteria) this;
        }

        public Criteria andCountryIdEqualTo(Integer value) {
            addCriterion("country_id =", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdNotEqualTo(Integer value) {
            addCriterion("country_id <>", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdGreaterThan(Integer value) {
            addCriterion("country_id >", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("country_id >=", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdLessThan(Integer value) {
            addCriterion("country_id <", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdLessThanOrEqualTo(Integer value) {
            addCriterion("country_id <=", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdIn(List<Integer> values) {
            addCriterion("country_id in", values, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdNotIn(List<Integer> values) {
            addCriterion("country_id not in", values, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdBetween(Integer value1, Integer value2) {
            addCriterion("country_id between", value1, value2, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("country_id not between", value1, value2, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryNameIsNull() {
            addCriterion("country_name is null");
            return (Criteria) this;
        }

        public Criteria andCountryNameIsNotNull() {
            addCriterion("country_name is not null");
            return (Criteria) this;
        }

        public Criteria andCountryNameEqualTo(String value) {
            addCriterion("country_name =", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameNotEqualTo(String value) {
            addCriterion("country_name <>", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameGreaterThan(String value) {
            addCriterion("country_name >", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameGreaterThanOrEqualTo(String value) {
            addCriterion("country_name >=", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameLessThan(String value) {
            addCriterion("country_name <", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameLessThanOrEqualTo(String value) {
            addCriterion("country_name <=", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameLike(String value) {
            addCriterion("country_name like", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameNotLike(String value) {
            addCriterion("country_name not like", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameIn(List<String> values) {
            addCriterion("country_name in", values, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameNotIn(List<String> values) {
            addCriterion("country_name not in", values, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameBetween(String value1, String value2) {
            addCriterion("country_name between", value1, value2, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameNotBetween(String value1, String value2) {
            addCriterion("country_name not between", value1, value2, "countryName");
            return (Criteria) this;
        }

        public Criteria andLocalCountryNameIsNull() {
            addCriterion("local_country_name is null");
            return (Criteria) this;
        }

        public Criteria andLocalCountryNameIsNotNull() {
            addCriterion("local_country_name is not null");
            return (Criteria) this;
        }

        public Criteria andLocalCountryNameEqualTo(String value) {
            addCriterion("local_country_name =", value, "localCountryName");
            return (Criteria) this;
        }

        public Criteria andLocalCountryNameNotEqualTo(String value) {
            addCriterion("local_country_name <>", value, "localCountryName");
            return (Criteria) this;
        }

        public Criteria andLocalCountryNameGreaterThan(String value) {
            addCriterion("local_country_name >", value, "localCountryName");
            return (Criteria) this;
        }

        public Criteria andLocalCountryNameGreaterThanOrEqualTo(String value) {
            addCriterion("local_country_name >=", value, "localCountryName");
            return (Criteria) this;
        }

        public Criteria andLocalCountryNameLessThan(String value) {
            addCriterion("local_country_name <", value, "localCountryName");
            return (Criteria) this;
        }

        public Criteria andLocalCountryNameLessThanOrEqualTo(String value) {
            addCriterion("local_country_name <=", value, "localCountryName");
            return (Criteria) this;
        }

        public Criteria andLocalCountryNameLike(String value) {
            addCriterion("local_country_name like", value, "localCountryName");
            return (Criteria) this;
        }

        public Criteria andLocalCountryNameNotLike(String value) {
            addCriterion("local_country_name not like", value, "localCountryName");
            return (Criteria) this;
        }

        public Criteria andLocalCountryNameIn(List<String> values) {
            addCriterion("local_country_name in", values, "localCountryName");
            return (Criteria) this;
        }

        public Criteria andLocalCountryNameNotIn(List<String> values) {
            addCriterion("local_country_name not in", values, "localCountryName");
            return (Criteria) this;
        }

        public Criteria andLocalCountryNameBetween(String value1, String value2) {
            addCriterion("local_country_name between", value1, value2, "localCountryName");
            return (Criteria) this;
        }

        public Criteria andLocalCountryNameNotBetween(String value1, String value2) {
            addCriterion("local_country_name not between", value1, value2, "localCountryName");
            return (Criteria) this;
        }

        public Criteria andCountryCodeIsNull() {
            addCriterion("country_code is null");
            return (Criteria) this;
        }

        public Criteria andCountryCodeIsNotNull() {
            addCriterion("country_code is not null");
            return (Criteria) this;
        }

        public Criteria andCountryCodeEqualTo(String value) {
            addCriterion("country_code =", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeNotEqualTo(String value) {
            addCriterion("country_code <>", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeGreaterThan(String value) {
            addCriterion("country_code >", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("country_code >=", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeLessThan(String value) {
            addCriterion("country_code <", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeLessThanOrEqualTo(String value) {
            addCriterion("country_code <=", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeLike(String value) {
            addCriterion("country_code like", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeNotLike(String value) {
            addCriterion("country_code not like", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeIn(List<String> values) {
            addCriterion("country_code in", values, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeNotIn(List<String> values) {
            addCriterion("country_code not in", values, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeBetween(String value1, String value2) {
            addCriterion("country_code between", value1, value2, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeNotBetween(String value1, String value2) {
            addCriterion("country_code not between", value1, value2, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCode2IsNull() {
            addCriterion("country_code2 is null");
            return (Criteria) this;
        }

        public Criteria andCountryCode2IsNotNull() {
            addCriterion("country_code2 is not null");
            return (Criteria) this;
        }

        public Criteria andCountryCode2EqualTo(String value) {
            addCriterion("country_code2 =", value, "countryCode2");
            return (Criteria) this;
        }

        public Criteria andCountryCode2NotEqualTo(String value) {
            addCriterion("country_code2 <>", value, "countryCode2");
            return (Criteria) this;
        }

        public Criteria andCountryCode2GreaterThan(String value) {
            addCriterion("country_code2 >", value, "countryCode2");
            return (Criteria) this;
        }

        public Criteria andCountryCode2GreaterThanOrEqualTo(String value) {
            addCriterion("country_code2 >=", value, "countryCode2");
            return (Criteria) this;
        }

        public Criteria andCountryCode2LessThan(String value) {
            addCriterion("country_code2 <", value, "countryCode2");
            return (Criteria) this;
        }

        public Criteria andCountryCode2LessThanOrEqualTo(String value) {
            addCriterion("country_code2 <=", value, "countryCode2");
            return (Criteria) this;
        }

        public Criteria andCountryCode2Like(String value) {
            addCriterion("country_code2 like", value, "countryCode2");
            return (Criteria) this;
        }

        public Criteria andCountryCode2NotLike(String value) {
            addCriterion("country_code2 not like", value, "countryCode2");
            return (Criteria) this;
        }

        public Criteria andCountryCode2In(List<String> values) {
            addCriterion("country_code2 in", values, "countryCode2");
            return (Criteria) this;
        }

        public Criteria andCountryCode2NotIn(List<String> values) {
            addCriterion("country_code2 not in", values, "countryCode2");
            return (Criteria) this;
        }

        public Criteria andCountryCode2Between(String value1, String value2) {
            addCriterion("country_code2 between", value1, value2, "countryCode2");
            return (Criteria) this;
        }

        public Criteria andCountryCode2NotBetween(String value1, String value2) {
            addCriterion("country_code2 not between", value1, value2, "countryCode2");
            return (Criteria) this;
        }

        public Criteria andContinentIsNull() {
            addCriterion("continent is null");
            return (Criteria) this;
        }

        public Criteria andContinentIsNotNull() {
            addCriterion("continent is not null");
            return (Criteria) this;
        }

        public Criteria andContinentEqualTo(String value) {
            addCriterion("continent =", value, "continent");
            return (Criteria) this;
        }

        public Criteria andContinentNotEqualTo(String value) {
            addCriterion("continent <>", value, "continent");
            return (Criteria) this;
        }

        public Criteria andContinentGreaterThan(String value) {
            addCriterion("continent >", value, "continent");
            return (Criteria) this;
        }

        public Criteria andContinentGreaterThanOrEqualTo(String value) {
            addCriterion("continent >=", value, "continent");
            return (Criteria) this;
        }

        public Criteria andContinentLessThan(String value) {
            addCriterion("continent <", value, "continent");
            return (Criteria) this;
        }

        public Criteria andContinentLessThanOrEqualTo(String value) {
            addCriterion("continent <=", value, "continent");
            return (Criteria) this;
        }

        public Criteria andContinentLike(String value) {
            addCriterion("continent like", value, "continent");
            return (Criteria) this;
        }

        public Criteria andContinentNotLike(String value) {
            addCriterion("continent not like", value, "continent");
            return (Criteria) this;
        }

        public Criteria andContinentIn(List<String> values) {
            addCriterion("continent in", values, "continent");
            return (Criteria) this;
        }

        public Criteria andContinentNotIn(List<String> values) {
            addCriterion("continent not in", values, "continent");
            return (Criteria) this;
        }

        public Criteria andContinentBetween(String value1, String value2) {
            addCriterion("continent between", value1, value2, "continent");
            return (Criteria) this;
        }

        public Criteria andContinentNotBetween(String value1, String value2) {
            addCriterion("continent not between", value1, value2, "continent");
            return (Criteria) this;
        }

        public Criteria andRegionIsNull() {
            addCriterion("region is null");
            return (Criteria) this;
        }

        public Criteria andRegionIsNotNull() {
            addCriterion("region is not null");
            return (Criteria) this;
        }

        public Criteria andRegionEqualTo(String value) {
            addCriterion("region =", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotEqualTo(String value) {
            addCriterion("region <>", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThan(String value) {
            addCriterion("region >", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThanOrEqualTo(String value) {
            addCriterion("region >=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThan(String value) {
            addCriterion("region <", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThanOrEqualTo(String value) {
            addCriterion("region <=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLike(String value) {
            addCriterion("region like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotLike(String value) {
            addCriterion("region not like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionIn(List<String> values) {
            addCriterion("region in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotIn(List<String> values) {
            addCriterion("region not in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionBetween(String value1, String value2) {
            addCriterion("region between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotBetween(String value1, String value2) {
            addCriterion("region not between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andSurfaceAreaIsNull() {
            addCriterion("surface_area is null");
            return (Criteria) this;
        }

        public Criteria andSurfaceAreaIsNotNull() {
            addCriterion("surface_area is not null");
            return (Criteria) this;
        }

        public Criteria andSurfaceAreaEqualTo(Float value) {
            addCriterion("surface_area =", value, "surfaceArea");
            return (Criteria) this;
        }

        public Criteria andSurfaceAreaNotEqualTo(Float value) {
            addCriterion("surface_area <>", value, "surfaceArea");
            return (Criteria) this;
        }

        public Criteria andSurfaceAreaGreaterThan(Float value) {
            addCriterion("surface_area >", value, "surfaceArea");
            return (Criteria) this;
        }

        public Criteria andSurfaceAreaGreaterThanOrEqualTo(Float value) {
            addCriterion("surface_area >=", value, "surfaceArea");
            return (Criteria) this;
        }

        public Criteria andSurfaceAreaLessThan(Float value) {
            addCriterion("surface_area <", value, "surfaceArea");
            return (Criteria) this;
        }

        public Criteria andSurfaceAreaLessThanOrEqualTo(Float value) {
            addCriterion("surface_area <=", value, "surfaceArea");
            return (Criteria) this;
        }

        public Criteria andSurfaceAreaIn(List<Float> values) {
            addCriterion("surface_area in", values, "surfaceArea");
            return (Criteria) this;
        }

        public Criteria andSurfaceAreaNotIn(List<Float> values) {
            addCriterion("surface_area not in", values, "surfaceArea");
            return (Criteria) this;
        }

        public Criteria andSurfaceAreaBetween(Float value1, Float value2) {
            addCriterion("surface_area between", value1, value2, "surfaceArea");
            return (Criteria) this;
        }

        public Criteria andSurfaceAreaNotBetween(Float value1, Float value2) {
            addCriterion("surface_area not between", value1, value2, "surfaceArea");
            return (Criteria) this;
        }

        public Criteria andIndepYearIsNull() {
            addCriterion("indep_year is null");
            return (Criteria) this;
        }

        public Criteria andIndepYearIsNotNull() {
            addCriterion("indep_year is not null");
            return (Criteria) this;
        }

        public Criteria andIndepYearEqualTo(Integer value) {
            addCriterion("indep_year =", value, "indepYear");
            return (Criteria) this;
        }

        public Criteria andIndepYearNotEqualTo(Integer value) {
            addCriterion("indep_year <>", value, "indepYear");
            return (Criteria) this;
        }

        public Criteria andIndepYearGreaterThan(Integer value) {
            addCriterion("indep_year >", value, "indepYear");
            return (Criteria) this;
        }

        public Criteria andIndepYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("indep_year >=", value, "indepYear");
            return (Criteria) this;
        }

        public Criteria andIndepYearLessThan(Integer value) {
            addCriterion("indep_year <", value, "indepYear");
            return (Criteria) this;
        }

        public Criteria andIndepYearLessThanOrEqualTo(Integer value) {
            addCriterion("indep_year <=", value, "indepYear");
            return (Criteria) this;
        }

        public Criteria andIndepYearIn(List<Integer> values) {
            addCriterion("indep_year in", values, "indepYear");
            return (Criteria) this;
        }

        public Criteria andIndepYearNotIn(List<Integer> values) {
            addCriterion("indep_year not in", values, "indepYear");
            return (Criteria) this;
        }

        public Criteria andIndepYearBetween(Integer value1, Integer value2) {
            addCriterion("indep_year between", value1, value2, "indepYear");
            return (Criteria) this;
        }

        public Criteria andIndepYearNotBetween(Integer value1, Integer value2) {
            addCriterion("indep_year not between", value1, value2, "indepYear");
            return (Criteria) this;
        }

        public Criteria andPopulationIsNull() {
            addCriterion("population is null");
            return (Criteria) this;
        }

        public Criteria andPopulationIsNotNull() {
            addCriterion("population is not null");
            return (Criteria) this;
        }

        public Criteria andPopulationEqualTo(Integer value) {
            addCriterion("population =", value, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationNotEqualTo(Integer value) {
            addCriterion("population <>", value, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationGreaterThan(Integer value) {
            addCriterion("population >", value, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationGreaterThanOrEqualTo(Integer value) {
            addCriterion("population >=", value, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationLessThan(Integer value) {
            addCriterion("population <", value, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationLessThanOrEqualTo(Integer value) {
            addCriterion("population <=", value, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationIn(List<Integer> values) {
            addCriterion("population in", values, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationNotIn(List<Integer> values) {
            addCriterion("population not in", values, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationBetween(Integer value1, Integer value2) {
            addCriterion("population between", value1, value2, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationNotBetween(Integer value1, Integer value2) {
            addCriterion("population not between", value1, value2, "population");
            return (Criteria) this;
        }

        public Criteria andLifeExpectancyIsNull() {
            addCriterion("life_expectancy is null");
            return (Criteria) this;
        }

        public Criteria andLifeExpectancyIsNotNull() {
            addCriterion("life_expectancy is not null");
            return (Criteria) this;
        }

        public Criteria andLifeExpectancyEqualTo(Float value) {
            addCriterion("life_expectancy =", value, "lifeExpectancy");
            return (Criteria) this;
        }

        public Criteria andLifeExpectancyNotEqualTo(Float value) {
            addCriterion("life_expectancy <>", value, "lifeExpectancy");
            return (Criteria) this;
        }

        public Criteria andLifeExpectancyGreaterThan(Float value) {
            addCriterion("life_expectancy >", value, "lifeExpectancy");
            return (Criteria) this;
        }

        public Criteria andLifeExpectancyGreaterThanOrEqualTo(Float value) {
            addCriterion("life_expectancy >=", value, "lifeExpectancy");
            return (Criteria) this;
        }

        public Criteria andLifeExpectancyLessThan(Float value) {
            addCriterion("life_expectancy <", value, "lifeExpectancy");
            return (Criteria) this;
        }

        public Criteria andLifeExpectancyLessThanOrEqualTo(Float value) {
            addCriterion("life_expectancy <=", value, "lifeExpectancy");
            return (Criteria) this;
        }

        public Criteria andLifeExpectancyIn(List<Float> values) {
            addCriterion("life_expectancy in", values, "lifeExpectancy");
            return (Criteria) this;
        }

        public Criteria andLifeExpectancyNotIn(List<Float> values) {
            addCriterion("life_expectancy not in", values, "lifeExpectancy");
            return (Criteria) this;
        }

        public Criteria andLifeExpectancyBetween(Float value1, Float value2) {
            addCriterion("life_expectancy between", value1, value2, "lifeExpectancy");
            return (Criteria) this;
        }

        public Criteria andLifeExpectancyNotBetween(Float value1, Float value2) {
            addCriterion("life_expectancy not between", value1, value2, "lifeExpectancy");
            return (Criteria) this;
        }

        public Criteria andGnpIsNull() {
            addCriterion("gnp is null");
            return (Criteria) this;
        }

        public Criteria andGnpIsNotNull() {
            addCriterion("gnp is not null");
            return (Criteria) this;
        }

        public Criteria andGnpEqualTo(Float value) {
            addCriterion("gnp =", value, "gnp");
            return (Criteria) this;
        }

        public Criteria andGnpNotEqualTo(Float value) {
            addCriterion("gnp <>", value, "gnp");
            return (Criteria) this;
        }

        public Criteria andGnpGreaterThan(Float value) {
            addCriterion("gnp >", value, "gnp");
            return (Criteria) this;
        }

        public Criteria andGnpGreaterThanOrEqualTo(Float value) {
            addCriterion("gnp >=", value, "gnp");
            return (Criteria) this;
        }

        public Criteria andGnpLessThan(Float value) {
            addCriterion("gnp <", value, "gnp");
            return (Criteria) this;
        }

        public Criteria andGnpLessThanOrEqualTo(Float value) {
            addCriterion("gnp <=", value, "gnp");
            return (Criteria) this;
        }

        public Criteria andGnpIn(List<Float> values) {
            addCriterion("gnp in", values, "gnp");
            return (Criteria) this;
        }

        public Criteria andGnpNotIn(List<Float> values) {
            addCriterion("gnp not in", values, "gnp");
            return (Criteria) this;
        }

        public Criteria andGnpBetween(Float value1, Float value2) {
            addCriterion("gnp between", value1, value2, "gnp");
            return (Criteria) this;
        }

        public Criteria andGnpNotBetween(Float value1, Float value2) {
            addCriterion("gnp not between", value1, value2, "gnp");
            return (Criteria) this;
        }

        public Criteria andGovernmentFormIsNull() {
            addCriterion("government_form is null");
            return (Criteria) this;
        }

        public Criteria andGovernmentFormIsNotNull() {
            addCriterion("government_form is not null");
            return (Criteria) this;
        }

        public Criteria andGovernmentFormEqualTo(String value) {
            addCriterion("government_form =", value, "governmentForm");
            return (Criteria) this;
        }

        public Criteria andGovernmentFormNotEqualTo(String value) {
            addCriterion("government_form <>", value, "governmentForm");
            return (Criteria) this;
        }

        public Criteria andGovernmentFormGreaterThan(String value) {
            addCriterion("government_form >", value, "governmentForm");
            return (Criteria) this;
        }

        public Criteria andGovernmentFormGreaterThanOrEqualTo(String value) {
            addCriterion("government_form >=", value, "governmentForm");
            return (Criteria) this;
        }

        public Criteria andGovernmentFormLessThan(String value) {
            addCriterion("government_form <", value, "governmentForm");
            return (Criteria) this;
        }

        public Criteria andGovernmentFormLessThanOrEqualTo(String value) {
            addCriterion("government_form <=", value, "governmentForm");
            return (Criteria) this;
        }

        public Criteria andGovernmentFormLike(String value) {
            addCriterion("government_form like", value, "governmentForm");
            return (Criteria) this;
        }

        public Criteria andGovernmentFormNotLike(String value) {
            addCriterion("government_form not like", value, "governmentForm");
            return (Criteria) this;
        }

        public Criteria andGovernmentFormIn(List<String> values) {
            addCriterion("government_form in", values, "governmentForm");
            return (Criteria) this;
        }

        public Criteria andGovernmentFormNotIn(List<String> values) {
            addCriterion("government_form not in", values, "governmentForm");
            return (Criteria) this;
        }

        public Criteria andGovernmentFormBetween(String value1, String value2) {
            addCriterion("government_form between", value1, value2, "governmentForm");
            return (Criteria) this;
        }

        public Criteria andGovernmentFormNotBetween(String value1, String value2) {
            addCriterion("government_form not between", value1, value2, "governmentForm");
            return (Criteria) this;
        }

        public Criteria andHeadOfStateIsNull() {
            addCriterion("head_of_state is null");
            return (Criteria) this;
        }

        public Criteria andHeadOfStateIsNotNull() {
            addCriterion("head_of_state is not null");
            return (Criteria) this;
        }

        public Criteria andHeadOfStateEqualTo(String value) {
            addCriterion("head_of_state =", value, "headOfState");
            return (Criteria) this;
        }

        public Criteria andHeadOfStateNotEqualTo(String value) {
            addCriterion("head_of_state <>", value, "headOfState");
            return (Criteria) this;
        }

        public Criteria andHeadOfStateGreaterThan(String value) {
            addCriterion("head_of_state >", value, "headOfState");
            return (Criteria) this;
        }

        public Criteria andHeadOfStateGreaterThanOrEqualTo(String value) {
            addCriterion("head_of_state >=", value, "headOfState");
            return (Criteria) this;
        }

        public Criteria andHeadOfStateLessThan(String value) {
            addCriterion("head_of_state <", value, "headOfState");
            return (Criteria) this;
        }

        public Criteria andHeadOfStateLessThanOrEqualTo(String value) {
            addCriterion("head_of_state <=", value, "headOfState");
            return (Criteria) this;
        }

        public Criteria andHeadOfStateLike(String value) {
            addCriterion("head_of_state like", value, "headOfState");
            return (Criteria) this;
        }

        public Criteria andHeadOfStateNotLike(String value) {
            addCriterion("head_of_state not like", value, "headOfState");
            return (Criteria) this;
        }

        public Criteria andHeadOfStateIn(List<String> values) {
            addCriterion("head_of_state in", values, "headOfState");
            return (Criteria) this;
        }

        public Criteria andHeadOfStateNotIn(List<String> values) {
            addCriterion("head_of_state not in", values, "headOfState");
            return (Criteria) this;
        }

        public Criteria andHeadOfStateBetween(String value1, String value2) {
            addCriterion("head_of_state between", value1, value2, "headOfState");
            return (Criteria) this;
        }

        public Criteria andHeadOfStateNotBetween(String value1, String value2) {
            addCriterion("head_of_state not between", value1, value2, "headOfState");
            return (Criteria) this;
        }

        public Criteria andCapitalIsNull() {
            addCriterion("capital is null");
            return (Criteria) this;
        }

        public Criteria andCapitalIsNotNull() {
            addCriterion("capital is not null");
            return (Criteria) this;
        }

        public Criteria andCapitalEqualTo(Integer value) {
            addCriterion("capital =", value, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalNotEqualTo(Integer value) {
            addCriterion("capital <>", value, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalGreaterThan(Integer value) {
            addCriterion("capital >", value, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalGreaterThanOrEqualTo(Integer value) {
            addCriterion("capital >=", value, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalLessThan(Integer value) {
            addCriterion("capital <", value, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalLessThanOrEqualTo(Integer value) {
            addCriterion("capital <=", value, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalIn(List<Integer> values) {
            addCriterion("capital in", values, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalNotIn(List<Integer> values) {
            addCriterion("capital not in", values, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalBetween(Integer value1, Integer value2) {
            addCriterion("capital between", value1, value2, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalNotBetween(Integer value1, Integer value2) {
            addCriterion("capital not between", value1, value2, "capital");
            return (Criteria) this;
        }

        public Criteria andTimeZoneIsNull() {
            addCriterion("time_zone is null");
            return (Criteria) this;
        }

        public Criteria andTimeZoneIsNotNull() {
            addCriterion("time_zone is not null");
            return (Criteria) this;
        }

        public Criteria andTimeZoneEqualTo(String value) {
            addCriterion("time_zone =", value, "timeZone");
            return (Criteria) this;
        }

        public Criteria andTimeZoneNotEqualTo(String value) {
            addCriterion("time_zone <>", value, "timeZone");
            return (Criteria) this;
        }

        public Criteria andTimeZoneGreaterThan(String value) {
            addCriterion("time_zone >", value, "timeZone");
            return (Criteria) this;
        }

        public Criteria andTimeZoneGreaterThanOrEqualTo(String value) {
            addCriterion("time_zone >=", value, "timeZone");
            return (Criteria) this;
        }

        public Criteria andTimeZoneLessThan(String value) {
            addCriterion("time_zone <", value, "timeZone");
            return (Criteria) this;
        }

        public Criteria andTimeZoneLessThanOrEqualTo(String value) {
            addCriterion("time_zone <=", value, "timeZone");
            return (Criteria) this;
        }

        public Criteria andTimeZoneLike(String value) {
            addCriterion("time_zone like", value, "timeZone");
            return (Criteria) this;
        }

        public Criteria andTimeZoneNotLike(String value) {
            addCriterion("time_zone not like", value, "timeZone");
            return (Criteria) this;
        }

        public Criteria andTimeZoneIn(List<String> values) {
            addCriterion("time_zone in", values, "timeZone");
            return (Criteria) this;
        }

        public Criteria andTimeZoneNotIn(List<String> values) {
            addCriterion("time_zone not in", values, "timeZone");
            return (Criteria) this;
        }

        public Criteria andTimeZoneBetween(String value1, String value2) {
            addCriterion("time_zone between", value1, value2, "timeZone");
            return (Criteria) this;
        }

        public Criteria andTimeZoneNotBetween(String value1, String value2) {
            addCriterion("time_zone not between", value1, value2, "timeZone");
            return (Criteria) this;
        }

        public Criteria andLanguageIdIsNull() {
            addCriterion("language_id is null");
            return (Criteria) this;
        }

        public Criteria andLanguageIdIsNotNull() {
            addCriterion("language_id is not null");
            return (Criteria) this;
        }

        public Criteria andLanguageIdEqualTo(Integer value) {
            addCriterion("language_id =", value, "languageId");
            return (Criteria) this;
        }

        public Criteria andLanguageIdNotEqualTo(Integer value) {
            addCriterion("language_id <>", value, "languageId");
            return (Criteria) this;
        }

        public Criteria andLanguageIdGreaterThan(Integer value) {
            addCriterion("language_id >", value, "languageId");
            return (Criteria) this;
        }

        public Criteria andLanguageIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("language_id >=", value, "languageId");
            return (Criteria) this;
        }

        public Criteria andLanguageIdLessThan(Integer value) {
            addCriterion("language_id <", value, "languageId");
            return (Criteria) this;
        }

        public Criteria andLanguageIdLessThanOrEqualTo(Integer value) {
            addCriterion("language_id <=", value, "languageId");
            return (Criteria) this;
        }

        public Criteria andLanguageIdIn(List<Integer> values) {
            addCriterion("language_id in", values, "languageId");
            return (Criteria) this;
        }

        public Criteria andLanguageIdNotIn(List<Integer> values) {
            addCriterion("language_id not in", values, "languageId");
            return (Criteria) this;
        }

        public Criteria andLanguageIdBetween(Integer value1, Integer value2) {
            addCriterion("language_id between", value1, value2, "languageId");
            return (Criteria) this;
        }

        public Criteria andLanguageIdNotBetween(Integer value1, Integer value2) {
            addCriterion("language_id not between", value1, value2, "languageId");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdIsNull() {
            addCriterion("currency_id is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdIsNotNull() {
            addCriterion("currency_id is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdEqualTo(Integer value) {
            addCriterion("currency_id =", value, "currencyId");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdNotEqualTo(Integer value) {
            addCriterion("currency_id <>", value, "currencyId");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdGreaterThan(Integer value) {
            addCriterion("currency_id >", value, "currencyId");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("currency_id >=", value, "currencyId");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdLessThan(Integer value) {
            addCriterion("currency_id <", value, "currencyId");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdLessThanOrEqualTo(Integer value) {
            addCriterion("currency_id <=", value, "currencyId");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdIn(List<Integer> values) {
            addCriterion("currency_id in", values, "currencyId");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdNotIn(List<Integer> values) {
            addCriterion("currency_id not in", values, "currencyId");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdBetween(Integer value1, Integer value2) {
            addCriterion("currency_id between", value1, value2, "currencyId");
            return (Criteria) this;
        }

        public Criteria andCurrencyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("currency_id not between", value1, value2, "currencyId");
            return (Criteria) this;
        }

        public Criteria andDateModifiedIsNull() {
            addCriterion("date_modified is null");
            return (Criteria) this;
        }

        public Criteria andDateModifiedIsNotNull() {
            addCriterion("date_modified is not null");
            return (Criteria) this;
        }

        public Criteria andDateModifiedEqualTo(Date value) {
            addCriterion("date_modified =", value, "dateModified");
            return (Criteria) this;
        }

        public Criteria andDateModifiedNotEqualTo(Date value) {
            addCriterion("date_modified <>", value, "dateModified");
            return (Criteria) this;
        }

        public Criteria andDateModifiedGreaterThan(Date value) {
            addCriterion("date_modified >", value, "dateModified");
            return (Criteria) this;
        }

        public Criteria andDateModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("date_modified >=", value, "dateModified");
            return (Criteria) this;
        }

        public Criteria andDateModifiedLessThan(Date value) {
            addCriterion("date_modified <", value, "dateModified");
            return (Criteria) this;
        }

        public Criteria andDateModifiedLessThanOrEqualTo(Date value) {
            addCriterion("date_modified <=", value, "dateModified");
            return (Criteria) this;
        }

        public Criteria andDateModifiedIn(List<Date> values) {
            addCriterion("date_modified in", values, "dateModified");
            return (Criteria) this;
        }

        public Criteria andDateModifiedNotIn(List<Date> values) {
            addCriterion("date_modified not in", values, "dateModified");
            return (Criteria) this;
        }

        public Criteria andDateModifiedBetween(Date value1, Date value2) {
            addCriterion("date_modified between", value1, value2, "dateModified");
            return (Criteria) this;
        }

        public Criteria andDateModifiedNotBetween(Date value1, Date value2) {
            addCriterion("date_modified not between", value1, value2, "dateModified");
            return (Criteria) this;
        }

        public Criteria andDateCreatedIsNull() {
            addCriterion("date_created is null");
            return (Criteria) this;
        }

        public Criteria andDateCreatedIsNotNull() {
            addCriterion("date_created is not null");
            return (Criteria) this;
        }

        public Criteria andDateCreatedEqualTo(Date value) {
            addCriterion("date_created =", value, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedNotEqualTo(Date value) {
            addCriterion("date_created <>", value, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedGreaterThan(Date value) {
            addCriterion("date_created >", value, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("date_created >=", value, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedLessThan(Date value) {
            addCriterion("date_created <", value, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedLessThanOrEqualTo(Date value) {
            addCriterion("date_created <=", value, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedIn(List<Date> values) {
            addCriterion("date_created in", values, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedNotIn(List<Date> values) {
            addCriterion("date_created not in", values, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedBetween(Date value1, Date value2) {
            addCriterion("date_created between", value1, value2, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedNotBetween(Date value1, Date value2) {
            addCriterion("date_created not between", value1, value2, "dateCreated");
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