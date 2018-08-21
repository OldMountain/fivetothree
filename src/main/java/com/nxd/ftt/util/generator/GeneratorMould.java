package com.nxd.ftt.util.generator;

import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;

public class GeneratorMould extends PluginAdapter {

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }


    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        String s = introspectedTable.getMyBatis3SqlProviderType();
        s = s.replace("Mapper", "Dao");
        introspectedTable.setMyBatis3SqlProviderType(s);
        String tableName = introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime();//数据库表名
        XmlElement parentElement = document.getRootElement();
        List<IntrospectedColumn> columns = introspectedTable.getBaseColumns();
//        String key = introspectedTable.getGeneratedKey().getColumn();
        String key = columns.get(0).getActualColumnName();
        String keyProp = columns.get(0).getJavaProperty();
        GeneratedJavaFile javaFile = introspectedTable.getGeneratedJavaFiles().get(0);
        String parameterType = javaFile.getCompilationUnit().getType().toString();
        String selcols = "";
        String selprops = "";
        String props = "";
        String updateProps = "";
        String cols = "";
        for (int i = 0; i < columns.size(); i++) {
            String property = columns.get(i).getJavaProperty();
            String col = columns.get(i).getActualColumnName();
            //查询
            selcols += "            " + col + ",\n";
            selprops += "            <if test=\"" + property + " != null and " + property + " !=''\">\n"
                    + "                 and " + col + " = #{" + property + "}"
                    + "  \n            </if>\n";

            props += "            <if test=\"" + property + " != null and " + property + " !=''\">\n"
                    + "                " + col
                    + " , \n            </if>\n";
            cols += "            <if test=\"" + property + " != null and " + property + " !=''\">\n"
                    + "                #{" + property
                    + "} , \n            </if>\n";


            updateProps += "            <if test=\"" + property + " != null and " + property + " !=''\">\n"
                    + "                " + col + " = #{" + property + "} ,"
                    + "\n            </if>\n";
        }
        //查询
        XmlElement selectElement = new XmlElement("select");
        selectElement.addAttribute(new Attribute("id", "select"));
        selectElement.addAttribute(new Attribute("parameterType", parameterType));
        selectElement.addAttribute(new Attribute("resultMap", "BaseResultMap"));
        selectElement.addElement(
                new TextElement(
                        "    select" +
                                "\n       <trim  suffixOverrides=\",\">\n" + selcols +
                                "       </trim>" +
                                "\n       from " + tableName +
                                "\n       <where>\n" + selprops +
                                "       </where>"
                )
        );
        // 批量删除
        XmlElement batchDeleteElement = new XmlElement("delete");
        batchDeleteElement.addAttribute(new Attribute("id", "batchDelete"));
        batchDeleteElement.addAttribute(new Attribute("parameterType", "java.lang.String"));
        batchDeleteElement.addElement(
                new TextElement(
                        "delete from " + tableName + "\n    where " + key + " in "
                                + " \n    <foreach item=\"item\" index=\"index\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">\n       #{item}\n    </foreach> "
                ));

        //插入
        XmlElement insertElement = new XmlElement("insert");
        insertElement.addAttribute(new Attribute("id", "insert"));
        insertElement.addAttribute(new Attribute("parameterType", parameterType));
        insertElement.addElement(
                new TextElement(
                        "      insert into " + tableName
                                + "\n        <trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">\n"
                                + props
                                + "        </trim>"
                                + "\n        <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\">\n"
                                + cols
                                + "        </trim>"
                ));

        //修改
        XmlElement updateElement = new XmlElement("update");
        updateElement.addAttribute(new Attribute("id", "update"));
        updateElement.addAttribute(new Attribute("parameterType", "java.lang.String"));
        updateElement.addElement(
                new TextElement(
                        "      update " + tableName
                                + "\n          <set>"
                                + updateProps
                                + "        <set>"
                                + "\n        where " + key + " = #{" + keyProp + "}"
                ));

        //删除
        XmlElement deleteElement = new XmlElement("delete");
        deleteElement.addAttribute(new Attribute("id", "delete"));
        deleteElement.addAttribute(new Attribute("parameterType", parameterType));
        deleteElement.addElement(
                new TextElement(
                        "delete from " + tableName + "\n    where " + key + " = #{" + keyProp + "}"
                ));

        parentElement.addElement(selectElement);
        parentElement.addElement(batchDeleteElement);
        parentElement.addElement(insertElement);
        parentElement.addElement(updateElement);
        parentElement.addElement(deleteElement);

        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }

    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String objectName = introspectedTable.getFullyQualifiedTable().getDomainObjectName();
        String paramsName = objectName.substring(0, 1).toLowerCase() + objectName.substring(1);
        List<IntrospectedColumn> columns = introspectedTable.getBaseColumns();
        String keyProp = columns.get(0).getJavaProperty();

        Method methodSelect = new Method("select");
        methodSelect.addJavaDocLine("/**");
        methodSelect.addJavaDocLine(" * 查询");
        methodSelect.addJavaDocLine(" * @param " + paramsName);
        methodSelect.addJavaDocLine(" * @return int");
        methodSelect.addJavaDocLine(" */");
        methodSelect.setReturnType(new FullyQualifiedJavaType("List<" + introspectedTable.getFullyQualifiedTable().getDomainObjectName() + ">"));
        methodSelect.addParameter(new Parameter(new FullyQualifiedJavaType(objectName), paramsName));


        Method methodBatchDelete = new Method("batchDelete");
        methodBatchDelete.addJavaDocLine("/**");
        methodBatchDelete.addJavaDocLine(" * 批量删除");
        methodBatchDelete.addJavaDocLine(" * @param " + introspectedTable.getBaseColumns().get(0).getJavaProperty());
        methodBatchDelete.addJavaDocLine(" * @return int");
        methodBatchDelete.addJavaDocLine(" */");
        methodBatchDelete.setReturnType(new FullyQualifiedJavaType("int"));
        methodBatchDelete.addParameter(new Parameter(new FullyQualifiedJavaType("String[]"), introspectedTable.getBaseColumns().get(0).getJavaProperty()));


        Method methodInsert = new Method("insert");
        methodInsert.addJavaDocLine("/**");
        methodInsert.addJavaDocLine(" * 根据" + keyProp + "插入");
        methodInsert.addJavaDocLine(" * @param " + paramsName);
        methodInsert.addJavaDocLine(" * @return int");
        methodInsert.addJavaDocLine(" */");
//        method.setReturnType(new FullyQualifiedJavaType("List<" + introspectedTable.getFullyQualifiedTable().getDomainObjectName() + ">"));
        methodInsert.setReturnType(new FullyQualifiedJavaType("int"));
        methodInsert.addParameter(new Parameter(new FullyQualifiedJavaType(objectName), paramsName));


        Method methodUpdate = new Method("update");
        methodUpdate.addJavaDocLine("/**");
        methodUpdate.addJavaDocLine(" * 根据" + keyProp + "更新");
        methodUpdate.addJavaDocLine(" * @param " + paramsName);
        methodUpdate.addJavaDocLine(" * @return int");
        methodUpdate.addJavaDocLine(" */");
//        method.setReturnType(new FullyQualifiedJavaType("List<" + introspectedTable.getFullyQualifiedTable().getDomainObjectName() + ">"));
        methodUpdate.setReturnType(new FullyQualifiedJavaType("int"));
        methodUpdate.addParameter(new Parameter(new FullyQualifiedJavaType(objectName), paramsName));

        Method methodDelete = new Method("delete");
        methodDelete.addJavaDocLine("/**");
        methodDelete.addJavaDocLine(" * 根据" + keyProp + "删除");
        methodDelete.addJavaDocLine(" * @param " + introspectedTable.getBaseColumns().get(0).getJavaProperty());
        methodDelete.addJavaDocLine(" * @return int");
        methodDelete.addJavaDocLine(" */");
        methodDelete.setReturnType(new FullyQualifiedJavaType("int"));
        methodDelete.addParameter(new Parameter(new FullyQualifiedJavaType("String"), introspectedTable.getBaseColumns().get(0).getJavaProperty()));


        interfaze.addMethod(methodSelect);
        interfaze.addMethod(methodBatchDelete);
        interfaze.addMethod(methodInsert);
        interfaze.addMethod(methodUpdate);
        interfaze.addMethod(methodDelete);
        interfaze.addAnnotation("@Repository");
        interfaze.addImportedType(new FullyQualifiedJavaType("org.springframework.stereotype.Repository"));
        return super.clientGenerated(interfaze, topLevelClass, introspectedTable);
    }

}
