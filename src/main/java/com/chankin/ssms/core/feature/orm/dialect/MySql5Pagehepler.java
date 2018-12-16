package com.chankin.ssms.core.feature.orm.dialect;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MySql5Pagehepler {
    //得到查询总数的sql
    public static String getCountString(String querySelect) {

        querySelect = getLineSql(querySelect);

        int orderIndex = getLastOrderInsertPoint(querySelect);
        int formIndex = getAfterInserPoint(querySelect);
        String select = querySelect.substring(0, formIndex);

        //SELECT 中包含DISTINCT 只能在外层包含COUNT
        if (select.toLowerCase().indexOf("select distinc") != -1 || querySelect.toLowerCase().indexOf("group by") != -1) {
            return new StringBuffer(querySelect.length()).append("select count(1) count from (").append(querySelect.substring(0, orderIndex)).append(" ) t").toString();
        } else {
            return new StringBuffer(querySelect.length()).append("select count(1) count ").
                    append(querySelect.substring(formIndex, orderIndex)).toString();
        }
    }

    //得到分页的sql
    public static String getLimitString(String sql, int offset, int limit) {
        sql = getLineSql(sql);
        String sql2 = sql + " limit " + offset + " ," + limit;
        return sql2;
    }

    //将SQL语句变成一条语句，并且每个单词的间隔为1个空格  如果sql 为空返null，else返回转化的sql
    private static String getLineSql(String sql) {
        //  \s匹配任何空白字符，包括空格、制表符、换页符等
        return sql.replaceAll("[\r\n]", " ").replaceAll("\\s{2,}", " ");
    }

    //得到sql正确的from插入点
    private static int getAfterInserPoint(String sql) {
        String regex = "\\s+FROM\\s+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sql);
        while (matcher.find()) {
            int fromStartIndex = matcher.start(0);
            String text = sql.substring(0, fromStartIndex);
            if (isBracketCanpartnership(text)) {
                return fromStartIndex;
            }
        }
        return 0;
    }

    //的得到一个Order by插入点的位置
    private static int getLastOrderInsertPoint(String sql) {
        int orderIndex = sql.toLowerCase().lastIndexOf("order by");
        if (orderIndex == -1) {
            orderIndex = sql.length();
        }
        if (!isBracketCanpartnership(sql.substring(orderIndex, sql.length()))) {
            throw new RuntimeException("Mysql 分页必须要有order by 语句！");
        }
        return orderIndex;
    }

    //判断括号"()"是否匹配,并不会判断排列顺序是否正确
    private static boolean isBracketCanpartnership(String text) {
        if (text == null || (getIndexOfCount(text, '(') != getIndexOfCount(text, ')'))) {
            return false;
        }
        return true;
    }


    //得到一个字符在另一个字符串中出现的次数
    private static int getIndexOfCount(String text, char ch) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            count = (text.charAt(i) == ch) ? count + 1 : count;
        }
        return count;
    }
}
