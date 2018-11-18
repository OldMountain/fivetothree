<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${daoPackage + "."}${dao}">
    <resultMap id="BaseResultMap" type="${entityPackage + "."}${entity}">
      <#list table as row>
        <result column="${row.columnName}" property="${row.filedName}"/>
      </#list>
    </resultMap>
    <sql id="column">
        <trim suffixOverrides=",">
          <#list table as row>
              ${row.columnName},
          </#list>
        </trim>
    </sql>
    <select id="list" parameterType="${entityPackage + "."}${entity}" resultMap="BaseResultMap">
        select
           <include refid="column" />
        from ${tableName}
        <where>
            <#list table as row>
                <#if row.dataType != 'Date' && row.dataType != 'Integer' && row.dataType != 'Integer'>
            <if test="${row.filedName} != null and ${row.filedName} !=''">
                and ${row.columnName} = ${"#{" + row.filedName + "}"}
            </if>
                <#elseif row.dataType == 'Date'>
            <if test="${row.filedName} != null">
                and ${row.columnName} = ${"#{" + row.filedName + "}"}
            </if>
                <#else>
            <if test="${row.filedName} != null and (${row.filedName} != '' or ${row.filedName} == 0) ">
                and ${row.columnName} = ${"#{" + row.filedName + "}"}
            </if>
                </#if>
            </#list>
        </where>
    </select>
    <select id="findById" parameterType="${entityPackage + "."}${entity}" resultMap="BaseResultMap">
        select
           <include refid="column" />
        from ${tableName}
        where ${primaryKey.columnName} = ${"#{" + primaryKey.filedName + "}"}
    </select>
    <delete id="batchDelete" parameterType="java.lang.String">
        delete from ${tableName}
        where ${primaryKey.columnName} in
        <foreach item="item" index="index" collection="array" open="(" separator="," close=")">
        ${"#"+"{item}"}
        </foreach>
    </delete>
    <insert id="insert" parameterType="${entityPackage + "."}${entity}">
        insert into ${tableName}
        <trim prefix="(" suffix=")" suffixOverrides=",">
            <#list table as row>
                <#if row.dataType != 'Date' && row.dataType != 'Integer' && row.dataType != 'Integer'>
            <if test="${row.filedName} != null and ${row.filedName} !=''">
                ${row.columnName},
            </if>
                <#elseif row.dataType == 'Date'>
            <if test="${row.filedName} != null">
                ${row.columnName},
            </if>
                <#else>
            <if test="${row.filedName} != null and (${row.filedName} != '' or ${row.filedName} == 0) ">
                ${row.columnName},
            </if>
                </#if>
            </#list>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides=",">
            <#list table as row>
                <#if row.dataType != 'Date' && row.dataType != 'Integer'>
            <if test="${row.filedName} != null and ${row.filedName} !=''">
                ${"#{" + row.filedName + "}"},
            </if>
                <#elseif row.dataType == 'Date'>
            <if test="${row.filedName} != null">
                ${"#{" + row.filedName + "}"},
            </if>
                <#else>
            <if test="${row.filedName} != null and (${row.filedName} != '' or ${row.filedName} == 0) ">
                ${"#{" + row.filedName + "}"},
            </if>
                </#if>
            </#list>
        </trim>
    </insert>
    <update id="update" parameterType="${entityPackage + "."}${entity}">
        update ${tableName}
        set
        <trim suffixOverrides=",">
            <#list table as row>
                <#if row.dataType != 'Date' && row.dataType != 'Integer'>
            <if test="${row.filedName} != null and ${row.filedName} !=''">
                ${row.columnName} = ${"#{" + row.filedName + "}"},
            </if>
                <#elseif row.dataType == 'Date'>
            <if test="${row.filedName} != null">
                ${row.columnName} = ${"#{" + row.filedName + "}"},
            </if>
                <#else>
            <if test="${row.filedName} != null and (${row.filedName} != '' or ${row.filedName} == 0) ">
                ${row.columnName} = ${"#{" + row.filedName + "}"},
            </if>
                </#if>
            </#list>
        </trim>
        where ${primaryKey.columnName} = ${"#{" + primaryKey.filedName + "}"}
    </update>
    <delete id="delete" parameterType="${entityPackage + "."}${entity}">
        delete from ${tableName}
        where ${primaryKey.columnName} = ${"#{" + primaryKey.filedName + "}"}
    </delete>
</mapper>