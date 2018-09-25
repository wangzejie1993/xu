package com.wangsocial.app.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.XMLDecoder;
import java.io.*;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串处理及转换工具类
 * Created by Martin on 2016/7/01.
 */
public class StringUtil {

    private static Pattern numericPattern = Pattern.compile("^[0-9\\-]+$");
    private static Pattern numericStringPattern = Pattern.compile("^[0-9\\-\\-]+$");
    private static Pattern floatNumericPattern = Pattern.compile("^[0-9\\-\\.]+$");
    private static Pattern abcPattern = Pattern.compile("^[a-z|A-Z]+$");
    public static final String splitStrPattern = ",|，|;|；|、|\\.|。|-|_|\\(|\\)|\\[|\\]|\\{|\\}|\\\\|/| |　|\"";
    private static Logger logger = LoggerFactory.getLogger(StringUtil.class);

    /**
     * 判断是否数字表示
     * @param src 源字符串
     * @return 是否数字的标志
     */
    public static boolean isNumeric(String src) {
        boolean return_value = false;
        if (src != null && src.length() > 0) {
            Matcher m = numericPattern.matcher(src);
            if (m.find()) {
                return_value = true;
            }
        }
        return return_value;
    }

    /**
     * 判断是否数字表示
     * @param src 源字符串
     * @return 是否数字的标志
     */
    public static boolean isNumericString(String src) {
        boolean return_value = false;
        if (src != null && src.length() > 0) {
            Matcher m = numericStringPattern.matcher(src);
            if (m.find()) {
                return_value = true;
            }
        }
        return return_value;
    }

    /**
     * 判断是否纯字母组合
     * @param src 源字符串
     * @return 是否纯字母组合的标志
     */
    public static boolean isABC(String src) {
        boolean return_value = false;
        if (src != null && src.length() > 0) {
            Matcher m = abcPattern.matcher(src);
            if (m.find()) {
                return_value = true;
            }
        }
        return return_value;
    }

    /**
     * 判断是否浮点数字表示
     * @param src 源字符串
     * @return 是否数字的标志
     */
    public static boolean isFloatNumeric(String src) {
        boolean return_value = false;
        if (src != null && src.length() > 0) {
            Matcher m = floatNumericPattern.matcher(src);
            if (m.find()) {
                return_value = true;
            }
        }
        return return_value;
    }

    /**
     * 是否符合逗号分隔的数字参数规范，示例： 1 true 1,2 true 1, false a false a,b false
     * @param src the src
     * @return the boolean
     */
    public static boolean isCommaSplitDigitalStr(String src){
        if(src == null) return false;
        return src.matches("(\\d+[,])*(\\d+)");
    }

    /**
     * 是否是逗号分隔的字符串(字母数字下划线和'-')
     * @param src the src
     * @return the boolean
     */
    public static boolean isCommaSplitStr(String src){
        if(src == null) return false;
        return src.matches("([a-zA-Z0-9-_]+[,])*([a-zA-Z0-9-_]+)");
    }

    /**
     * 将逗号分隔的字符串(字母数字下划线和'-')加上单引号
     * @param src the src  a,b,c
     * @return the string  'a',b','c'
     */
    public static String addSigleQuotesToCommaSplitStr(String src){
        if(isNotEmpty(src)){
            return  src.replaceAll("([a-zA-Z0-9-_]+)","'$1'");
        }else {
            return null;
        }
    }

    /**
     * 把string array or list用给定的符号symbol连接成一个字符串
     * @param array
     * @param symbol
     * @return
     */
    public static String joinString(List array, String symbol) {
        String result = "";
        if (array != null) {
            for (int i = 0; i < array.size(); i++) {
                String temp = array.get(i).toString();
                if (temp != null && temp.trim().length() > 0)
                    result += (temp + symbol);
            }
            if (result.length() > 1)
                result = result.substring(0, result.length() - 1);
        }
        return result;
    }

    /**
     * 截取字符串　超出的字符用symbol代替 　　
     * @param len 字符串长度　长度计量单位为一个GBK汉字　　两个英文字母计算为一个单位长度
     * @param str
     * @param symbol
     * @return
     */
    public static String getLimitLengthString(String str, int len, String symbol) {
        int iLen = len * 2;
        int counterOfDoubleByte = 0;
        String strRet = "";
        try {
            if (str != null) {
                byte[] b = str.getBytes("GBK");
                if (b.length <= iLen) {
                    return str;
                }
                for (int i = 0; i < iLen; i++) {
                    if (b[i] < 0) {
                        counterOfDoubleByte++;
                    }
                }
                if (counterOfDoubleByte % 2 == 0) {
                    strRet = new String(b, 0, iLen, "GBK") + symbol;
                    return strRet;
                } else {
                    strRet = new String(b, 0, iLen - 1, "GBK") + symbol;
                    return strRet;
                }
            } else {
                return "";
            }
        } catch (Exception ex) {
            return str.substring(0, len);
        } finally {
            strRet = null;
        }
    }

    /**
     * 截取字符串　超出的字符用symbol代替 　　
     * @param len 字符串长度　长度计量单位为一个GBK汉字　　两个英文字母计算为一个单位长度
     * @param str
     * @return
     */
    public static String getLimitLengthString(String str, int len) {
        return getLimitLengthString(str, len, "...");
    }

    /**
     * 截取字符，不转码
     * @param subject
     * @param size
     * @return
     */
    public static String subStrNotEncode(String subject, int size) {
        if (subject.length() > size) {
            subject = subject.substring(0, size);
        }
        return subject;
    }

    /**
     * 把string array or list用给定的符号symbol连接成一个字符串
     * @param array
     * @param symbol
     * @return
     */
    public static String joinString(String[] array, String symbol) {
        String result = "";
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                String temp = array[i];
                if (temp != null && temp.trim().length() > 0)
                    result += (temp + symbol);
            }
            if (result.length() > 1)
                result = result.substring(0, result.length() - 1);
        }
        return result;
    }

    /**
     * 取得字符串的实际长度（考虑了汉字的情况）
     * @param SrcStr 源字符串
     * @return 字符串的实际长度
     */
    public static int getStringLen(String SrcStr) {
        int return_value = 0;
        if (SrcStr != null) {
            char[] theChars = SrcStr.toCharArray();
            for (int i = 0; i < theChars.length; i++) {
                return_value += (theChars[i] <= 255) ? 1 : 2;
            }
        }
        return return_value;
    }

    /**
     * 检查数据串中是否包含非法字符集
     * @param str
     * @return [true]|[false] 包含|不包含
     */
    public static boolean check(String str) {
        String sIllegal = "'\"";
        int len = sIllegal.length();
        if (null == str)
            return false;
        for (int i = 0; i < len; i++) {
            if (str.indexOf(sIllegal.charAt(i)) != -1)
                return true;
        }
        return false;
    }

    /**
     * getHideEmailPrefix - 隐藏邮件地址前缀。
     * @param email EMail邮箱地址 例如: linwenguo@koubei.com 等等...
     * @return 返回已隐藏前缀邮件地址, 如 *********@koubei.com.
     */
    public static String getHideEmailPrefix(String email) {
        if (null != email) {
            int index = email.lastIndexOf('@');
            if (index > 0) {
                email = repeat("*", index).concat(email.substring(index));
            }
        }
        return email;
    }

    /**
     * repeat - 通过源字符串重复生成N次组成新的字符串。
     * @param src 源字符串 例如: 空格(" "), 星号("*"), "浙江" 等等...
     * @param num 重复生成次数
     * @return 返回已生成的重复字符串
     */
    public static String repeat(String src, int num) {
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < num; i++)
            s.append(src);
        return s.toString();
    }

    /**
     * 根据指定的字符把源字符串分割成一个数组
     * @param src
     * @return
     */
    public static List<String> parseString2ListByCustomerPattern(String pattern, String src) {
        if (src == null)
            return null;
        List<String> list = new ArrayList<String>();
        String[] result = src.split(pattern);
        for (int i = 0; i < result.length; i++) {
            list.add(result[i]);
        }
        return list;
    }

    /**
     * 根据指定的字符把源字符串分割成一个数组
     * @param src
     * @return
     */
    public static List<String> parseString2ListByPattern(String src) {
        String pattern = "，|,|、|。";
        return parseString2ListByCustomerPattern(pattern, src);
    }

    /**
     * 格式化一个float
     * @param format 要格式化成的格式 such as #.00, #.#
     */
    public static String formatFloat(float f, String format) {
        DecimalFormat df = new DecimalFormat(format);
        return df.format(f);
    }

    /**
     * 判断是否是空字符串 null和"" 都返回 true
     * @param s
     * @return
     */
    public static boolean isEmpty(String s) {
        if (s != null && !s.equals("")) {
            return false;
        }
        return true;
    }

    /**
     * 自定义的分隔字符串函数 例如: 1,2,3 =>[1,2,3] 3个元素 ,2,3=>[,2,3] 3个元素 ,2,3,=>[,2,3,] 4个元素 ,,,=>[,,,] 4个元素
     * 5.22算法修改，为提高速度不用正则表达式 两个间隔符,,返回""元素
     * @param split 分割字符 默认,
     * @param src 输入字符串
     * @return 分隔后的list
     */
    public static List<String> splitToList(String split, String src) {
        // 默认,
        String sp = ",";
        if (split != null && split.length() == 1) {
            sp = split;
        }
        List<String> r = new ArrayList<String>();
        int lastIndex = -1;
        int index = src.indexOf(sp);
        if (-1 == index && src != null) {
            r.add(src);
            return r;
        }
        while (index >= 0) {
            if (index > lastIndex) {
                r.add(src.substring(lastIndex + 1, index));
            } else {
                r.add("");
            }

            lastIndex = index;
            index = src.indexOf(sp, index + 1);
            if (index == -1) {
                r.add(src.substring(lastIndex + 1, src.length()));
            }
        }
        return r;
    }

    /**
     * 把 名=值 参数表转换成字符串 (a=1,b=2 =>a=1&b=2)
     * @param map
     * @return
     */
    public static String linkedHashMapToString(LinkedHashMap<String, String> map) {
        if (map != null && map.size() > 0) {
            String result = "";
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                String name = (String) it.next();
                String value = (String) map.get(name);
                result += (result.equals("")) ? "" : "&";
                result += String.format("%s=%s", name, value);
            }
            return result;
        }
        return null;
    }

    /**
     * 解析字符串返回 名称=值的参数表 (a=1&b=2 => a=1,b=2)
     * @param str
     * @return
     */
    public static LinkedHashMap<String, String> toLinkedHashMap(String str) {
        if (str != null && !str.equals("") && str.indexOf("=") > 0) {
            LinkedHashMap result = new LinkedHashMap();

            String name = null;
            String value = null;
            int i = 0;
            while (i < str.length()) {
                char c = str.charAt(i);
                switch (c) {
                    case 61: // =
                        value = "";
                        break;
                    case 38: // &
                        if (name != null && value != null && !name.equals("")) {
                            result.put(name, value);
                        }
                        name = null;
                        value = null;
                        break;
                    default:
                        if (value != null) {
                            value = (value != null) ? (value + c) : "" + c;
                        } else {
                            name = (name != null) ? (name + c) : "" + c;
                        }
                }
                i++;
            }
            if (name != null && value != null && !name.equals("")) {
                result.put(name, value);
            }
            return result;
        }
        return null;
    }

    /**
     * 根据输入的多个解释和下标返回一个值
     * @param captions 例如:"无,爱干净,一般,比较乱"
     * @param index 1
     * @return 一般
     */
    public static String getCaption(String captions, int index) {
        if (index > 0 && captions != null && !captions.equals("")) {
            String[] ss = captions.split(",");
            if (ss != null && ss.length > 0 && index < ss.length) {
                return ss[index];
            }
        }
        return null;
    }

    /**
     * 数字转字符串,如果num<=0 则输出"";
     * @param num
     * @return
     */
    public static String numberToString(Object num) {
        if (num == null) {
            return null;
        } else if (num instanceof Integer && (Integer) num > 0) {
            return Integer.toString((Integer) num);
        } else if (num instanceof Long && (Long) num > 0) {
            return Long.toString((Long) num);
        } else if (num instanceof Float && (Float) num > 0) {
            return Float.toString((Float) num);
        } else if (num instanceof Double && (Double) num > 0) {
            return Double.toString((Double) num);
        } else {
            return "";
        }
    }

    /**
     * 货币转字符串
     * @param money
     * @param style 样式 [default]要格式化成的格式 such as #.00, #.#
     * @return
     */
    public static String moneyToString(Object money, String style) {
        if (money != null && style != null && (money instanceof Double || money instanceof Float)) {
            Double num = (Double) money;

            if (style.equalsIgnoreCase("default")) {
                // 缺省样式 0 不输出 ,如果没有输出小数位则不输出.0
                if (num == 0) {
                    // 不输出0
                    return "";
                } else if ((num * 10 % 10) == 0) {
                    // 没有小数
                    return Integer.toString((int) num.intValue());
                } else {
                    // 有小数
                    return num.toString();
                }
            } else {
                DecimalFormat df = new DecimalFormat(style);
                return df.format(num);
            }
        }
        return null;
    }

    /**
     * 在sou中是否存在finds 如果指定的finds字符串有一个在sou中找到,返回true;
     * @param sou
     * @param finds
     * @return
     */
    public static boolean strPos(String sou, String... finds) {
        if (sou != null && finds != null && finds.length > 0) {
            for (int i = 0; i < finds.length; i++) {
                if (sou.indexOf(finds[i]) > -1)
                    return true;
            }
        }
        return false;
    }

    /**
     * 判断两个字符串是否相等 如果都为null则判断为相等,一个为null另一个not null则判断不相等 否则如果s1=s2则相等
     * @param s1
     * @param s2
     * @return
     */
    public static boolean equals(String s1, String s2) {
        if (StringUtil.isEmpty(s1) && StringUtil.isEmpty(s2)) {
            return true;
        } else if (!StringUtil.isEmpty(s1) && !StringUtil.isEmpty(s2)) {
            return s1.equals(s2);
        }
        return false;
    }

    /**
     * 把xml 转为object
     * @param xml
     * @return
     */
    public static Object xmlToObject(String xml) {
        try {
            ByteArrayInputStream in = new ByteArrayInputStream(xml.getBytes("UTF8"));
            XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(in));
            return decoder.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * string转long
     * @param s
     * @return
     */
    public static long toLong(String s) {
        try {
            if (s != null && !"".equals(s.trim()))
                return Long.parseLong(s);
        } catch (Exception exception) {
        }
        return 0L;
    }

    /**
     * string简单加密
     * @param str
     * @return
     */
    public static String simpleEncrypt(String str) {
        if (str != null && str.length() > 0) {
            // str = str.replaceAll("0","a");
            str = str.replaceAll("1", "b");
            // str = str.replaceAll("2","c");
            str = str.replaceAll("3", "d");
            // str = str.replaceAll("4","e");
            str = str.replaceAll("5", "f");
            str = str.replaceAll("6", "g");
            str = str.replaceAll("7", "h");
            str = str.replaceAll("8", "i");
            str = str.replaceAll("9", "j");
        }
        return str;
    }

    /**
     * 过滤用户输入的URL地址（防治用户广告） 目前只针对以http或www开头的URL地址 本方法调用的正则表达式，不建议用在对性能严格的地方例如:循环及list页面等
     * @param str 需要处理的字符串
     * @return 返回处理后的字符串
     */
    public static String removeURL(String str) {
        if (str != null)
            str = str.toLowerCase().replaceAll("(http|www|com|cn|org|\\.)+", "");
        return str;
    }

    /**
     * 随即生成指定位数的含数字验证码字符串
     * @param bit 指定生成验证码位数
     * @return String
     */
    public static String numRandom(int bit) {
        if (bit == 0)
            bit = 6; // 默认6位
        String str = "";
        str = "0123456789";// 初始化种子
        return RandomStringUtils.random(bit, str);// 返回6位的字符串
    }

    /**
     * 随即生成指定位数的含验证码字符串
     * @param bit 指定生成验证码位数
     * @return String
     */
    public static String random(int bit) {
        if (bit == 0)
            bit = 6; // 默认6位
        // 因为o和0,l和1很难区分,所以,去掉大小写的o和l
        String str = "";
        str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz";// 初始化种子
        return RandomStringUtils.random(bit, str);// 返回6位的字符串
    }

    /**
     * Wap页面的非法字符检查
     * @param str
     * @return
     */
    public static String replaceWapStr(String str) {
        if (str != null) {
            str = str.replaceAll("<span class=\"keyword\">", "");
            str = str.replaceAll("</span>", "");
            str = str.replaceAll("<strong class=\"keyword\">", "");
            str = str.replaceAll("<strong>", "");
            str = str.replaceAll("</strong>", "");
            str = str.replace('$', '＄');
            str = str.replaceAll("&amp;", "＆");
            str = str.replace('&', '＆');
            str = str.replace('<', '＜');
            str = str.replace('>', '＞');
        }
        return str;
    }

    /**
     * 字符串转float 如果异常返回0.00
     * @param s 输入的字符串
     * @return 转换后的float
     */
    public static Float toFloat(String s) {
        try {
            return Float.parseFloat(s);
        } catch (NumberFormatException e) {
            return new Float(0);
        }
    }

    /**
     * 页面中去除字符串中的空格、回车、换行符、制表符
     * @param str
     * @return
     */
    public static String replaceBlank(String str) {
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            str = m.replaceAll("");
        }
        return str;
    }

    /**
     * 全角生成半角
     * @param QJstr
     * @return
     */
    public static String Q2B(String QJstr) {
        String outStr = "";
        String Tstr = "";
        byte[] b = null;
        for (int i = 0; i < QJstr.length(); i++) {
            try {
                Tstr = QJstr.substring(i, i + 1);
                b = Tstr.getBytes("unicode");
            } catch (UnsupportedEncodingException e) {
                logger.error("",e);
            }
            if (b[3] == -1) {
                b[2] = (byte) (b[2] + 32);
                b[3] = 0;
                try {
                    outStr = outStr + new String(b, "unicode");
                } catch (UnsupportedEncodingException ex) {
                    logger.error("",ex);
                }
            } else {
                outStr = outStr + Tstr;
            }
        }
        return outStr;
    }

    /**
     *
     * 转换编码
     * @param s 源字符串
     * @param fencode 源编码格式
     * @param bencode 目标编码格式
     * @return 目标编码
     */
    public static String changCoding(String s, String fencode, String bencode) {
        String str;
        try {
            if (StringUtil.isNotEmpty(s)) {
                str = new String(s.getBytes(fencode), bencode);
            } else {
                str = "";
            }
            return str;
        } catch (UnsupportedEncodingException e) {
            return s;
        }
    }

    /**
     * 移除HTML格式
     * @param str
     * @return
     */
    public static String removeHTMLLableExe(String str) {
        str = stringReplace(str, ">\\s*<", "><");
        str = stringReplace(str, "&nbsp;", " ");// 替换空格
        str = stringReplace(str, "<br ?/?>", "\n");// 去<br><br />
        str = stringReplace(str, "<([^<>]+)>", "");// 去掉<>内的字符
        str = stringReplace(str, "\\s\\s\\s*", " ");// 将多个空白变成一个空格
        str = stringReplace(str, "^\\s*", "");// 去掉头的空白
        str = stringReplace(str, "\\s*$", "");// 去掉尾的空白
        str = stringReplace(str, " +", " ");
        return str;
    }

    /**
     * 除去html标签
     * @param str 源字符串
     * @return 目标字符串
     */
    public static String removeHTMLLable(String str) {
        str = stringReplace(str, "\\s", "");// 去掉页面上看不到的字符
        str = stringReplace(str, "<br ?/?>", "\n");// 去<br><br />
        str = stringReplace(str, "<([^<>]+)>", "");// 去掉<>内的字符
        str = stringReplace(str, "&nbsp;", " ");// 替换空格
        str = stringReplace(str, "&(\\S)(\\S?)(\\S?)(\\S?);", "");// 去<br><br />
        return str;
    }

    /**
     * 去掉HTML标签之外的字符串
     * @param str 源字符串
     * @return 目标字符串
     */
    public static String removeOutHTMLLable(String str) {
        str = stringReplace(str, ">([^<>]+)<", "><");
        str = stringReplace(str, "^([^<>]+)<", "<");
        str = stringReplace(str, ">([^<>]+)$", ">");
        return str;
    }

    /**
     * 字符串替换
     * @param str 源字符串
     * @param sr 正则表达式样式
     * @param sd 替换文本
     * @return 结果串
     */
    public static String stringReplace(String str, String sr, String sd) {
        String regEx = sr;
        Pattern p = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(str);
        str = m.replaceAll(sd);
        return str;
    }

    /**
     * 将html的省略写法替换成非省略写法
     * @param str html字符串
     * @param pt 标签如table
     * @return 结果串
     */
    public static String fomateToFullForm(String str, String pt) {
        String regEx = "<" + pt + "\\s+([\\S&&[^<>]]*)/>";
        Pattern p = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(str);
        String[] sa = null;
        String sf = "";
        String sf2 = "";
        String sf3 = "";
        for (; m.find();) {
            sa = p.split(str);
            if (sa == null) {
                break;
            }
            sf = str.substring(sa[0].length(), str.indexOf("/>", sa[0].length()));
            sf2 = sf + "></" + pt + ">";
            sf3 = str.substring(sa[0].length() + sf.length() + 2);
            str = sa[0] + sf2 + sf3;
            sa = null;
        }
        return str;
    }

    /**
     *
     * 得到字符串的子串位置序列
     * @param str 字符串
     * @param sub 子串
     * @param b true子串前端,false子串后端
     * @return 字符串的子串位置序列
     */
    public static int[] getSubStringPos(String str, String sub, boolean b) {
        // int[] i = new int[(new Integer((str.length()-stringReplace( str , sub
        // , "" ).length())/sub.length())).intValue()] ;
        String[] sp = null;
        int l = sub.length();
        sp = splitString(str, sub);
        if (sp == null) {
            return null;
        }
        int[] ip = new int[sp.length - 1];
        for (int i = 0; i < sp.length - 1; i++) {
            ip[i] = sp[i].length() + l;
            if (i != 0) {
                ip[i] += ip[i - 1];
            }
        }
        if (b) {
            for (int j = 0; j < ip.length; j++) {
                ip[j] = ip[j] - l;
            }
        }
        return ip;
    }

    /**
     *
     * 根据正则表达式分割字符串
     * @param str 源字符串
     * @param ms 正则表达式
     * @return 目标字符串组
     */
    public static String[] splitString(String str, String ms) {
        if (str == null) return null;
        String regEx = ms;
        Pattern p = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        String[] sp = p.split(str);
        return sp;
    }

    /**
     * 根据正则表达式提取字符串,相同的字符串只返回一个
     * @param str 源字符串
     * @param pattern 正则表达式
     * @return 目标字符串数据组
     */
    public static String[] getStringArrayByPattern(String str, String pattern) {
        // 传入一个字符串，把符合pattern格式的字符串放入字符串数组
        // java.util.regex是一个用正则表达式所订制的模式来对字符串进行匹配工作的类库包
        Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(str);
        // 范型
        Set<String> result = new HashSet<String>();// 目的是：相同的字符串只返回一个。。。 不重复元素
        // boolean find() 尝试在目标字符串里查找下一个匹配子串。
        while (matcher.find()) {
            for (int i = 0; i < matcher.groupCount(); i++) { // int groupCount()
                // 返回当前查找所获得的匹配组的数量。
                // org.jeecgframework.core.util.LogUtil.info(matcher.group(i));
                result.add(matcher.group(i));
            }
        }
        String[] resultStr = null;
        if (result.size() > 0) {
            resultStr = new String[result.size()];
            return result.toArray(resultStr);// 将Set result转化为String[] resultStr
        }
        return resultStr;

    }

    /**
     * 得到第一个b,e之间的字符串,并返回e后的子串
     * @param s 源字符串
     * @param b 标志开始
     * @param e 标志结束
     * @return b,e之间的字符串
     */
    public static String[] midString(String s, String b, String e) {
        int i = s.indexOf(b) + b.length();
        int j = s.indexOf(e, i);
        String[] sa = new String[2];
        if (i < b.length() || j < i + 1 || i > j) {
            sa[1] = s;
            sa[0] = null;
            return sa;
        } else {
            sa[0] = s.substring(i, j);
            sa[1] = s.substring(j);
            return sa;
        }
    }

    /**
     * 带有前一次替代序列的正则表达式替代
     * @param s
     * @param pf
     * @param pb
     * @param start
     * @return
     */
    public static String stringReplace(String s, String pf, String pb, int start) {
        Pattern pattern_hand = Pattern.compile(pf);
        Matcher matcher_hand = pattern_hand.matcher(s);
        int gc = matcher_hand.groupCount();
        int pos = start;
        String sf1 = "";
        String sf2 = "";
        String sf3 = "";
        int if1 = 0;
        String strr = "";
        while (matcher_hand.find(pos)) {
            sf1 = matcher_hand.group();
            if1 = s.indexOf(sf1, pos);
            if (if1 >= pos) {
                strr += s.substring(pos, if1);
                pos = if1 + sf1.length();
                sf2 = pb;
                for (int i = 1; i <= gc; i++) {
                    sf3 = "\\" + i;
                    sf2 = replaceAll(sf2, sf3, matcher_hand.group(i));
                }
                strr += sf2;
            } else {
                return s;
            }
        }
        strr = s.substring(0, start) + strr;
        return strr;
    }

    /**
     * 存文本替换
     * @param s 源字符串
     * @param sf 子字符串
     * @param sb 替换字符串
     * @return 替换后的字符串
     */
    public static String replaceAll(String s, String sf, String sb) {
        int i = 0, j = 0;
        int l = sf.length();
        boolean b = true;
        boolean o = true;
        String str = "";
        do {
            j = i;
            i = s.indexOf(sf, j);
            if (i > j) {
                str += s.substring(j, i);
                str += sb;
                i += l;
                o = false;
            } else {
                str += s.substring(j);
                b = false;
            }
        } while (b);
        if (o) {
            str = s;
        }
        return str;
    }

    /**
     * 判断是否与给定字符串样式匹配
     * @param str 字符串
     * @param pattern 正则表达式样式
     * @return 是否匹配 是true,否false
     */
    public static boolean isMatch(String str, String pattern) {
        Pattern pattern_hand = Pattern.compile(pattern);
        Matcher matcher_hand = pattern_hand.matcher(str);
        boolean b = matcher_hand.matches();
        return b;
    }

    /**
     * 截取字符串
     * @param s 源字符串
     * @param jmp 跳过jmp
     * @param sb 取在sb
     * @param se 于se之间的字符串
     * @return
     */
    public static String subStringExe(String s, String jmp, String sb, String se) {
        if (isEmpty(s)) {
            return "";
        }
        int i = s.indexOf(jmp);
        if (i >= 0 && i < s.length()) {
            s = s.substring(i + 1);
        }
        i = s.indexOf(sb);
        if (i >= 0 && i < s.length()) {
            s = s.substring(i + 1);
        }
        if (se == "") {
            return s;
        } else {
            i = s.indexOf(se);
            if (i >= 0 && i < s.length()) {
                s = s.substring(i + 1);
            }
            return s;
        }
    }

    /**
     * 用要通过URL传输的内容进行编码
     * @param src 源字符串
     * @return 经过编码的内容
     */
    public static String URLEncode(String src) {
        String return_value = "";
        try {
            if (src != null) {
                return_value = URLEncoder.encode(src, "GBK");

            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return_value = src;
        }
        return return_value;
    }

    /**
     * 获取GBK编码的字符串
     * @param str 传入&#31119;test&#29031;&#27004;&#65288;&#21271;&#22823;&#38376;&# 24635 ;&#24215;&#65289;&#31119;
     * @return 经过解码的内容
     */
    public static String getGBK(String str) {
        return transfer(str);
    }

    public static String transfer(String str) {
        Pattern p = Pattern.compile("&#\\d+;");
        Matcher m = p.matcher(str);
        while (m.find()) {
            String old = m.group();
            str = str.replaceAll(old, getChar(old));
        }
        return str;
    }

    public static String getChar(String str) {
        String dest = str.substring(2, str.length() - 1);
        char ch = (char) Integer.parseInt(dest);
        return "" + ch;
    }

    /**
     * 泛型方法(通用)，把list转换成以“,”相隔的字符串 调用时注意类型初始化（申明类型） 如：List<Integer> intList = new ArrayList<Integer>(); 调用方法：StringUtil.listTtoString(intList); 效率：list中4条信息，1000000次调用时间为850ms左右
     * @param <T>  泛型
     * @param list list列表
     * @return 以“,”相隔的字符串
     */
    public static <T> String listTtoString(List<T> list) {
        if (list == null || list.size() < 1)
            return "";
        Iterator<T> i = list.iterator();
        if (!i.hasNext())
            return "";
        StringBuilder sb = new StringBuilder();
        for (;;) {
            T e = i.next();
            sb.append(e);
            if (!i.hasNext())
                return sb.toString();
            sb.append(",");
        }
    }

    /**
     * 把整形数组转换成以“,”相隔的字符串
     * @param a 数组a 以“,”相隔的字符串
     * @return
     */
    public static String intArraytoString(int[] a) {
        if (a == null)
            return "";
        int iMax = a.length - 1;
        if (iMax == -1)
            return "";
        StringBuilder b = new StringBuilder();
        for (int i = 0;; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.toString();
            b.append(",");
        }
    }

    /**
     * 判断文字内容重复
     * @param content
     * @return
     */
    public static boolean isContentRepeat(String content) {
        int similarNum = 0;
        int forNum = 0;
        int subNum = 0;
        int thousandNum = 0;
        String startStr = "";
        String nextStr = "";
        boolean result = false;
        float endNum = (float) 0.0;
        if (content != null && content.length() > 0) {
            if (content.length() % 1000 > 0)
                thousandNum = (int) Math.floor(content.length() / 1000) + 1;
            else
                thousandNum = (int) Math.floor(content.length() / 1000);
            if (thousandNum < 3)
                subNum = 100 * thousandNum;
            else if (thousandNum < 6)
                subNum = 200 * thousandNum;
            else if (thousandNum < 9)
                subNum = 300 * thousandNum;
            else
                subNum = 3000;
            for (int j = 1; j < subNum; j++) {
                if (content.length() % j > 0)
                    forNum = (int) Math.floor(content.length() / j) + 1;
                else
                    forNum = (int) Math.floor(content.length() / j);
                if (result || j >= content.length())
                    break;
                else {
                    for (int m = 0; m < forNum; m++) {
                        if (m * j > content.length() || (m + 1) * j > content.length() || (m + 2) * j > content.length())
                            break;
                        startStr = content.substring(m * j, (m + 1) * j);
                        nextStr = content.substring((m + 1) * j, (m + 2) * j);
                        if (startStr.equals(nextStr)) {
                            similarNum = similarNum + 1;
                            endNum = (float) similarNum / forNum;
                            if (endNum > 0.4) {
                                result = true;
                                break;
                            }
                        } else
                            similarNum = 0;
                    }
                }
            }
        }
        return result;
    }

    /**
     * 判断是否是空字符串 null和"" null返回result,否则返回字符串
     * @param s
     * @return
     */
    public static String isEmpty(String s, String result) {
        if (s != null && !s.equals("")) {
            return s;
        }
        return result;
    }

    /**
     * 判断对象是否为空
     * @param str
     * @return
     */
    public static boolean isNotEmpty(Object str) {
        boolean flag = false;
        if (str != null && !str.equals("")&& !str.equals("null")) {
            if (str.toString().trim().length() > 0) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 全角字符变半角字符
     * @param str
     * @return
     */
    public static String full2Half(String str) {
        if (str == null || "".equals(str))
            return "";
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c >= 65281 && c < 65373)
                sb.append((char) (c - 65248));
            else
                sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    /**
     * 全角括号转为半角
     * @param str
     * @return
     */
    public static String replaceBracketStr(String str) {
        if (str != null && str.length() > 0) {
            str = str.replaceAll("（", "(");
            str = str.replaceAll("）", ")");
        }
        return str;
    }

    /**
     * 解析字符串返回map键值对(例：a=1&b=2 => a=1,b=2)
     * @param query 源参数字符串
     * @param split1 键值对之间的分隔符（例：&）
     * @param split2 key与value之间的分隔符（例：=）
     * @param dupLink 重复参数名的参数值之间的连接符，连接后的字符串作为该参数的参数值，可为null null：不允许重复参数名出现，则靠后的参数值会覆盖掉靠前的参数值。
     * @return map
     */
    public static Map<String, String> parseQuery(String query, char split1, char split2, String dupLink) {
        if (!isEmpty(query) && query.indexOf(split2) > 0) {
            Map<String, String> result = new HashMap();
            String name = null;
            String value = null;
            String tempValue = "";
            int len = query.length();
            for (int i = 0; i < len; i++) {
                char c = query.charAt(i);
                if (c == split2) {
                    value = "";
                } else if (c == split1) {
                    if (!isEmpty(name) && value != null) {
                        if (dupLink != null) {
                            tempValue = result.get(name);
                            if (tempValue != null) {
                                value += dupLink + tempValue;
                            }
                        }
                        result.put(name, value);
                    }
                    name = null;
                    value = null;
                } else if (value != null) {
                    value += c;
                } else {
                    name = (name != null) ? (name + c) : "" + c;
                }
            }
            if (!isEmpty(name) && value != null) {
                if (dupLink != null) {
                    tempValue = result.get(name);
                    if (tempValue != null) {
                        value += dupLink + tempValue;
                    }
                }
                result.put(name, value);
            }
            return result;
        }
        return null;
    }

    /**
     * 将list 用传入的分隔符组装为String
     * @param list
     * @param slipStr
     * @return String
     */
    public static String listToStringSlipStr(List list, String slipStr) {
        StringBuffer returnStr = new StringBuffer();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                returnStr.append(list.get(i)).append(slipStr);
            }
        }
        if (returnStr.toString().length() > 0)
            return returnStr.toString().substring(0, returnStr.toString().lastIndexOf(slipStr));
        else
            return "";
    }

    /**
     * 获取从start开始用*替换len个长度后的字符串
     * @param str 要替换的字符串
     * @param start 开始位置
     * @param len 长度
     * @return 替换后的字符串
     */
    public static String getMaskStr(String str, int start, int len) {
        if (StringUtil.isEmpty(str)) {
            return str;
        }
        if (str.length() < start) {
            return str;
        }
        // 获取*之前的字符串
        String ret = str.substring(0, start);
        // 获取最多能打的*个数
        int strLen = str.length();
        if (strLen < start + len) {
            len = strLen - start;
        }
        // 替换成*
        for (int i = 0; i < len; i++) {
            ret += "*";
        }
        // 加上*之后的字符串
        if (strLen > start + len) {
            ret += str.substring(start + len);
        }
        return ret;
    }

    /**
     * 根据传入的分割符号,把传入的字符串分割为List字符串
     * @param slipStr 分隔的字符串
     * @param src 字符串
     * @return 列表
     */
    public static List<String> stringToStringListBySlipStr(String slipStr, String src) {
        if (src == null)
            return null;
        List<String> list = new ArrayList<String>();
        String[] result = src.split(slipStr);
        for (int i = 0; i < result.length; i++) {
            list.add(result[i]);
        }
        return list;
    }

    /**
     * 截取字符串
     * @param str 原始字符串
     * @param len 要截取的长度
     * @param tail 结束加上的后缀
     * @return 截取后的字符串
     */
    public static String getHtmlSubString(String str, int len, String tail) {
        if (str == null || str.length() <= len) {
            return str;
        }
        int length = str.length();
        char c = ' ';
        String tag = null;
        String name = null;
        int size = 0;
        String result = "";
        boolean isTag = false;
        List<String> tags = new ArrayList<String>();
        int i = 0;
        for (int end = 0, spanEnd = 0; i < length && len > 0; i++) {
            c = str.charAt(i);
            if (c == '<') {
                end = str.indexOf('>', i);
            }

            if (end > 0) {
                // 截取标签
                tag = str.substring(i, end + 1);
                int n = tag.length();
                if (tag.endsWith("/>")) {
                    isTag = true;
                } else if (tag.startsWith("</")) { // 结束符
                    name = tag.substring(2, end - i);
                    size = tags.size() - 1;
                    // 堆栈取出html开始标签
                    if (size >= 0 && name.equals(tags.get(size))) {
                        isTag = true;
                        tags.remove(size);
                    }
                } else { // 开始符
                    spanEnd = tag.indexOf(' ', 0);
                    spanEnd = spanEnd > 0 ? spanEnd : n;
                    name = tag.substring(1, spanEnd);
                    if (name.trim().length() > 0) {
                        // 如果有结束符则为html标签
                        spanEnd = str.indexOf("</" + name + ">", end);
                        if (spanEnd > 0) {
                            isTag = true;
                            tags.add(name);
                        }
                    }
                }
                // 非html标签字符
                if (!isTag) {
                    if (n >= len) {
                        result += tag.substring(0, len);
                        break;
                    } else {
                        len -= n;
                    }
                }

                result += tag;
                isTag = false;
                i = end;
                end = 0;
            } else { // 非html标签字符
                len--;
                result += c;
            }
        }
        // 添加未结束的html标签
        for (String endTag : tags) {
            result += "</" + endTag + ">";
        }
        if (i < length) {
            result += tail;
        }
        return result;
    }

    /**
     * 解析前台encodeURIComponent编码后的参数
     * @param property (encodeURIComponent(no))
     * @return
     */
    public static String getEncodePra(String property) {
        String trem = "";
        if (isNotEmpty(property)) {
            try {
                trem = URLDecoder.decode(property, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return trem;
    }

    /**
     * 截取数字
     * @param content
     * @return
     */
    public String getNumbers(String content) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            return matcher.group(0);
        }
        return "";
    }

    /**
     * 截取非数字
     * @param content
     * @return
     */
    public String splitNotNumber(String content) {
        Pattern pattern = Pattern.compile("\\D+");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            return matcher.group(0);
        }
        return "";
    }

    /**
     * 判断某个字符串是否存在于数组中
     * @param stringArray 原数组
     * @param source 查找的字符串
     * @return
     */
    public static boolean contains(String[] stringArray, String source) {
        // 转换为list
        List<String> tempList = Arrays.asList(stringArray);
        // 利用list的包含方法,进行判断
        if (tempList.contains(source)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * html 必须是格式良好的
     * @param str
     * @return
     * @throws Exception
     */
//    public static String formatHtml(String str) throws Exception {
//        Document document = null;
//        document = DocumentHelper.parseText(str);
//        OutputFormat format = OutputFormat.createPrettyPrint();
//        format.setEncoding("utf-8");
//        StringWriter writer = new StringWriter();
//        HTMLWriter htmlWriter = new HTMLWriter(writer, format);
//        htmlWriter.write(document);
//        htmlWriter.close();
//        return writer.toString();
//    }

    /**
     * 首字母大写
     * @param realName
     * @return
     */
    public static String firstUpperCase(String realName) {
        return StringUtils.replaceChars(realName, realName.substring(0, 1), realName.substring(0, 1).toUpperCase());
    }

    /**
     * 首字母小写
     * @param realName
     * @return
     */
    public static String firstLowerCase(String realName) {
        return StringUtils.replaceChars(realName, realName.substring(0, 1), realName.substring(0, 1).toLowerCase());
    }
    /**
     * 判断这个类是不是java自带的类
     * @param clazz
     * @return
     */
    public static boolean isJavaClass(Class<?> clazz) {
        boolean isBaseClass = false;
        if(clazz.isArray()){
            isBaseClass = false;
        }else if (clazz.isPrimitive()||clazz.getPackage()==null
                || clazz.getPackage().getName().equals("java.lang")
                || clazz.getPackage().getName().equals("java.math")
                || clazz.getPackage().getName().equals("java.util")) {
            isBaseClass =  true;
        }
        return isBaseClass;
    }

    /**
     * 相似度比较
     * @param strA
     * @param strB
     * @return
     */
    public static double SimilarDegree(String strA, String strB){
        String newStrA = removeSign(strA);
        String newStrB = removeSign(strB);
        int temp = Math.max(newStrA.length(), newStrB.length());
        int temp2 = longestCommonSubstring(newStrA, newStrB).length();
        return temp2 * 1.0 / temp;
    }

    private static String removeSign(String str) {
        StringBuffer sb = new StringBuffer();
        for (char item : str.toCharArray())
            if (charReg(item)){
                sb.append(item);
            }
        return sb.toString();
    }

    private static boolean charReg(char charValue) {
        return (charValue >= 0x4E00 && charValue <= 0X9FA5)
                || (charValue >= 'a' && charValue <= 'z')
                || (charValue >= 'A' && charValue <= 'Z')
                || (charValue >= '0' && charValue <= '9');
    }

    private static String longestCommonSubstring(String strA, String strB) {
        char[] chars_strA = strA.toCharArray();
        char[] chars_strB = strB.toCharArray();
        int m = chars_strA.length;
        int n = chars_strB.length;
        int[][] matrix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (chars_strA[i - 1] == chars_strB[j - 1])
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                else
                    matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);
            }
        }
        char[] result = new char[matrix[m][n]];
        int currentIndex = result.length - 1;
        while (matrix[m][n] != 0) {
            if (matrix[m][n] == matrix[m][n - 1])
                n--;
            else if (matrix[m][n] == matrix[m - 1][n])
                m--;
            else {
                result[currentIndex] = chars_strA[m - 1];
                currentIndex--;
                n--;
                m--;
            }
        }
        return new String(result);
    }

    /**
     * 将字符串转换成十六进制编码
     * @param str
     * @return
     */
    public static String toHexString(String str) throws UnsupportedEncodingException {
        // 根据默认编码获取字节数组
        String hexString = "0123456789ABCDEF";
        byte[] bytes = str.getBytes("GB2312");
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        // 将字节数组中每个字节拆解成2位16进制整数
        for (byte b : bytes) {
            sb.append(Integer.toHexString(b + 0x800).substring(1));
        }
        return sb.toString();
    }

    /**
     * 字符串转Unicode
     * @param string
     * @return
     */
    public static String string2Unicode(String string) {
        StringBuffer unicode = new StringBuffer();
        for (int i = 0; i < string.length(); i++) {
            // 取出每一个字符
            char c = string.charAt(i);
            // 转换为unicode
            unicode.append("\\u" + Integer.toHexString(c));
        }
        return unicode.toString();
    }

    /**
     * 特殊字符处理
     */
    public static String deal2EmptyString(String str){
        if(StringUtils.isBlank(str)||str.equals("null")){
            str = "";
        }
        return str;
    }

    /**
     * unicode 转字符串
     * @param unicode
     * @return
     */
    public static String unicode2String(String unicode) {
        StringBuffer string = new StringBuffer();
        String[] hex = unicode.split("\\\\u");
        for (int i = 1; i < hex.length; i++) {
            // 转换出每一个代码点
            int data = Integer.parseInt(hex[i], 16);
            // 追加成string
            string.append((char) data);
        }
        return string.toString();
    }

    /**
     * 根据ID生成六位随机码
     * @param num ID
     * @return 随机码
     */
    public static String toSerialNumber(long num) {
        /**自定义进制(0,1没有加入)*/
        char[] r = new char[] { 'Q', 'w', 'E', '8', 'a', 'S', '2', 'd', 'Z', 'x', '9', 'c', '7', 'p', 'O', '5', 'i', 'K', '3', 'm', 'j', 'U', 'f', 'r', '4', 'V', 'y', 'L', 't', 'N', '6', 'b', 'g', 'H' };
        /**自动补全组(不能与自定义进制有重复)*/
        char[] b = new char[] { 'q', 'W', 'e', 'A', 's', 'D', 'z', 'X', 'C', 'P', 'o', 'I', 'k', 'M', 'J', 'u', 'F', 'R', 'v', 'Y', 'T', 'n', 'B', 'G', 'h' };
        /**进制长度*/
        int l = r.length;
        /**序列最小长度*/
        int s = 6;
        char[] buf = new char[32];
        int charPos = 32;

        while ((num / l) > 0) {
            buf[--charPos] = r[(int) (num % l)];
            num /= l;
        }
        buf[--charPos] = r[(int) (num % l)];
        String str = new String(buf, charPos, (32 - charPos));
        //不够长度的自动随机补全
        if (str.length() < s) {
            StringBuffer sb = new StringBuffer();
            Random rnd = new Random();
            for (int i = 0; i < s - str.length(); i++) {
                sb.append(b[rnd.nextInt(24)]);
            }
            str += sb.toString();
        }
        return str;
    }

    /**
     * 关键字合法性判断
     * @return
     */
    public static String keywordsSpellCheck(String string) {
        Pattern pattern = Pattern.compile("[0-9a-zA-Z\\u4e00-\\u9fa5\n~!@#$\\s%^&*_\\\\()`\\-+=|{}\\[\\],;./<>:\"']+");
        boolean b = pattern.matcher(string).matches();
        if (!b) {
            return "关键字不合法!关键字只能包含数字,字母,汉字,空格,英文标点符号以及如下特殊符号:[@#$%^&*(){}_-+|/~<>],"
                    + "禁止出现中文标点符号,禁止出现换行,关键字前后不要有空格,如果需要顿号请用'/'代替";
        } else if (string.contains(" ,") || string.contains(", ")) {
            return "每个关键字前后不能有空格!";
        } else if (string.startsWith(",") || string.endsWith(",")) {
            return "关键字不能以英文逗号结尾,英文逗号只是用于分隔!";
        } else if (string.startsWith(" ") || string.endsWith(" ")) {
            return "关键字开头和结尾不能有空格!";
        } else if (string.contains("\r\n") || string.contains("\r") || string.contains("\n")) {
            return "关键字不能包含换行!";
        } else if (string.contains(",,")) {
            return "关键字中两个英文逗号不能相邻!";
        }
        return null;
    }


    /**
     * 字节数组转16进制字符串
     */
    public static String bytes2HexString(byte[] b) {
        String r = "";

        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            r += hex.toUpperCase();
        }

        return r;
    }

    /**
     * 字符转换为字节
     */
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    /**
     * 16进制字符串转字节数组
     */
    public static byte[] hexString2Bytes(String hex) {

        if ((hex == null) || (hex.equals(""))){
            return null;
        }
        else if (hex.length()%2 != 0){
            return null;
        }
        else{
            hex = hex.toUpperCase();
            int len = hex.length()/2;
            byte[] b = new byte[len];
            char[] hc = hex.toCharArray();
            for (int i=0; i<len; i++){
                int p=2*i;
                b[i] = (byte) (charToByte(hc[p]) << 4 | charToByte(hc[p+1]));
            }
            return b;
        }

    }






    /**
     * 字节数组转字符串
     */
    public static String bytes2String(byte[] b) throws Exception {
        String r = new String (b,"UTF-8");
        return r;
    }

    /**
     * 字符串转字节数组
     */
    public static byte[] string2Bytes(String s){
        byte[] r = s.getBytes();
        return r;
    }

    /**
     * 16进制字符串转字符串
     */
    public static String hex2String(String hex) throws Exception{
        String r = bytes2String(hexString2Bytes(hex));
        return r;
    }

    /**
     * 字符串转16进制字符串
     */
    public static String string2HexString(String s) throws Exception{
        String r = bytes2HexString(string2Bytes(s));
        return r;
    }

    /**
     * 字节数组转16进制字符串
     */
    public static String byte2HexString(byte b) {
        String r = "";
        String hex = Integer.toHexString(b & 0xFF);
        if (hex.length() == 1) {
            hex = '0' + hex;
        }
        r = hex.toUpperCase();

        return r;
    }
    /**
     * 将16进制字符串转换为16进制byte
     *
     * @param str
     * @return
     */
    public static byte hex2Bytes(String str) {
        if(str == null || str.trim().equals("")) {
            return Byte.parseByte(null);
        }

        if(Integer.parseInt(str,16)>=128){
            byte v = Integer.valueOf(str, 16).byteValue();
            return v;
        }
        Byte by = Byte.parseByte(str,16);

        return by;
    }

    /**
     * 整数10进制转16进制字符串
     * @param a
     * @return
     */
    public static String int2HexString(int a){
        String r = "";
        String hex = Integer.toHexString(a & 0xFF);
        if (hex.length() == 1) {
            hex = '0' + hex;
        }
        r = hex.toUpperCase();

        return r;
    }

    /**
     * 10进制转16进制byte
     * @param a
     * @return
     */
    public static byte int2byte(int a){
        String hex = int2HexString(a);//16进制

        return hex2Bytes(hex);


    }
    /**
     * 获取strings字符串中所有str字符所在的下标
     * @param strings 母字符串
     * @param str 子字符串
     * @return 字符串在母字符串中下标集合，如果母字符串中不包含子字符串，集合长度为零
     */
    public static List<Integer> getIndex(String strings, String str){
        List<Integer> list=new ArrayList<>();
        int flag=0;
        while (strings.indexOf(str)!=-1){
            //截取包含自身在内的前边部分
            String aa= strings.substring(0,strings.indexOf(str)+str.length());
            flag=flag+aa.length();
            list.add(flag-str.length());
            strings=strings.substring(strings.indexOf(str)+str.length());
        }
        return list;
    }

    /**
     * 子字符串在父字符串中出现的次数
     * @param str
     * @param s
     * @return
     */
    public static int countString(String str,String s) {
        int count = 0;
        while(str.indexOf(s) != -1){

            str = str.substring(str.indexOf(s)+1,str.length());
            count++;

        }
        System.out.println(s+"出现的次数为"+count+"次");
        return count;
    }


    /**
     * 子字符串在父字符串中出现
     * @param obj1
     * @param Obj2
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> Map<String, String> compare(T obj1, T Obj2)
            throws Exception {

        Map<String, String> result = new HashMap<String, String>();

        Field[] fs = obj1.getClass().getDeclaredFields();//获取所有属性
        for (Field f : fs) {
            f.setAccessible(true);//设置访问性，反射类的方法，设置为true就可以访问private修饰的东西，否则无法访问
            Object v1 = f.get(obj1);
            Object v2 = f.get(Obj2);
            result.put(f.getName(), String.valueOf(equals(v1, v2)));
        }
        return result;
    }

    public static boolean equals(Object obj1, Object obj2) {

        if (obj1 == obj2) {
            return true;
        }
        if (obj1 == null || obj2 == null) {
            return false;
        }
        return obj1.equals(obj2);
    }

    /**
     * 子字符串在父字符串中出现的次数
     * 反射
     * @param obj1
     * @param obj2
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> boolean ObjectCompare(T obj1,T obj2) throws Exception{
        Field[] fs = obj1.getClass().getDeclaredFields();//获取所有属性
        for (Field field:fs) {
            field.setAccessible(true);//设置访问性，反射类方法，设置为true可以访问private修饰符修饰的，否则无法访问
            Object v1 = field.get(obj1);
            Object v2 = field.get(obj2);
            if (v1!=v2){
                return false;
            }
        }
        return true;
    }




    /**
     * CRC16-XMODEM算法（四字节）
     * @param bytes
     * @return
     */
    public static int crc16_ccitt_xmodem(byte[] bytes) {
        return crc16_ccitt_xmodem(bytes,0,bytes.length);
    }

    /**
     * CRC16-XMODEM算法（四字节）
     * @param bytes
     * @param offset
     * @param count
     * @return
     */
    public static int crc16_ccitt_xmodem(byte[] bytes,int offset,int count) {
        int crc = 0x0000; // initial value
        int polynomial = 0x1021; // poly value
        for (int index = offset; index < count; index++) {
            byte b = bytes[index];
            for (int i = 0; i < 8; i++) {
                boolean bit = ((b >> (7 - i) & 1) == 1);
                boolean c15 = ((crc >> 15 & 1) == 1);
                crc <<= 1;
                if (c15 ^ bit)
                    crc ^= polynomial;
            }
        }
        crc &= 0xffff;
        return crc;
    }

    /**
     * CRC16-XMODEM算法（两字节）
     * @param bytes
     * @param offset
     * @param count
     * @return
     */
    public static short crc16_ccitt_xmodem_short(byte[] bytes,int offset,int count) {
        return (short)crc16_ccitt_xmodem(bytes,offset,count);
    }
    /**
     * CRC16-XMODEM算法（两字节）
     * @param bytes
     * @return
     */
    public static short crc16_ccitt_xmodem_short(byte[] bytes) {
        return crc16_ccitt_xmodem_short(bytes,0,bytes.length);
    }


    /**
     * 每一行读取文件数据
     * @param fileName
     */
    public static void readFileByLines(String fileName) {

               File file = new File(fileName);

               BufferedReader reader = null;

                try {

                         System.out.println("以行为单位读取文件内容，一次读一整行：");

                       reader = new BufferedReader(new FileReader(file));

                      String tempString = null;

                        int line = 1;

                      // 一次读入一行，直到读入null为文件结束

                      while ((tempString = reader.readLine()) != null) {

                               // 显示行号

                               System.out.println("line " + line + ": " + tempString);

                                 line++;

                             }

                         reader.close();

                     } catch (IOException e) {

                        e.printStackTrace();

                   } finally {

                        if (reader != null) {

                                 try {

                                        reader.close();

                                    } catch (IOException e1) {

                                   }

                          }

                   }

           }

    /**
     * byte 数组合并
     * @param b1
     * @param b2
     * @return
     */
    public static byte[] byteMeger(byte[] b1,byte[] b2,byte[] b3){
                byte[] result = new byte[b1.length+b2.length+b3.length];
                System.arraycopy(b1,0,result,0,b1.length);
                System.arraycopy(b2,0,result,b1.length,b2.length);
                System.arraycopy(b3,0,result,b1.length+b2.length,b3.length);

                return result;
           }

    private static int checkAll(byte arr[]) {
        int len = arr.length;
        int sum = 0;
        if(len == 1) {
            return arr[0];
        }else {
            for (int i = 0; i < len; i++) {
                sum+=arr[i];
            }
            return sum;
        }
    }
    //        //头（AA）+ 命令（model）+ 数据（data）+长度（len）+校验和（sum）+尾（0d 0b）
    //        0xaa,0x00,0x00, 0x01,0x01, 0x0d ,0x0b
    public static byte[]  searchPackage(byte model,byte[] data,byte len){
        byte[] command_buff = new byte[data.length+6];
        byte[] head = new byte[2];
        head[0] = (byte)0XAA;//HEADER
        head[1] = (byte)model;//model

        byte[] mid = new byte[head.length+data.length];
        System.arraycopy(head,0,mid,0,head.length);
        System.arraycopy(data,0,mid,head.length,data.length);

        int te = checkAll(mid);
        int count=( te&0xff)+(len & 0xff) -170;
        byte[] end = new byte[4];
        end[0] = (byte)len;//len
        end[1] = (byte)StringUtil.int2byte(count);//校验和
        end[2] = (byte)0x0d;//0d
        end[3] = (byte)0x0b;//0b

        System.arraycopy(mid,0,command_buff,0,mid.length);
        System.arraycopy(end,0,command_buff,mid.length,end.length);
        return command_buff;
//

    }

    public static boolean getFlag(String data){
        List<Boolean> list = new ArrayList<>();
        String[] str = data.split("AA");
        if (str.length!=5){
            return false;
        }
        for (int i = 1; i < str.length; i++) {
            String tt = str[i];
            char[] chars =tt.toCharArray();
            if ('2' == chars[7]){
                list.add(true);
            }
        }
        if (list.size()==4){
            return true;
        }
        return false;
    }

    /**
     *
     * @param data
     * @return
     */
    public static boolean getBoolean(String data){
        String[] str = data.split("AA");
        System.out.println("接收到的返回值数据长度"+str.length);
        if (str.length!=5){
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        //14个2c
//        String str = "2447504747412c2c2c2c2c2c302c2c2c2c2c2c2c2c2a3636da";
//        byte[] by = new byte[]{0x03};
//        System.out.println("args = [" + bytes2HexString(by) + "]");

//        CanInfo canInfo = new CanInfo();
//        CanInfo canInfo1 = new CanInfo();
//        canInfo.setId(1);
//        canInfo.setCadence(2);
//        canInfo1.setId(2);
//        canInfo1.setCadence(2);
//
//        Map result = compare(canInfo,canInfo1);
//        System.out.println("args = [" + result + "]");

//        byte[] bytes = {0x31,0x32,0x33,0x34};
//
//        int a =   crc16_ccitt_xmodem(bytes);
//        System.out.println("args = [" + Integer.toString(a,16) + "]");

//        String name = "STM32.Bin";
//        byte[] bytes = name.getBytes();
//        byte[] by = new byte[12];
//
//        List list = new ArrayList();
//
//
//        for (int i = 0; i < bytes.length; i++) {
//            System.out.println("args = [" + bytes[i] + "]");
//        }
//        String temp = bytes2HexString(bytes);
//        System.out.println("args = [" + bytes + "]");
//
//        int a = 2700;
//
//       String aa = String.valueOf(a);
//       byte[] ida = aa.getBytes();
//        for (int i = 0; i < ida.length; i++) {
//            System.out.println("args = [" + ida[i] + "]");
//        }

        System.out.println(-1&0xff);

        int seq = 0;
        int offset = 0;
        byte[] nameBuffer = new byte[12];
        byte[] sizeBuffer = new byte[8];
        byte[] offsetBuffer = new byte[8];


        for (int i = 0; i < 8; i++) {
            offsetBuffer[i] = 0;
        }
        int size = 270000;
        String temp = String.valueOf(size);
        int sizeT = temp.length();
        int val = 8-sizeT;
        //根据val 0填充
        for (int i = 0; i < val; i++) {
            sizeBuffer[i] = 0;
        }

        byte[] sizeV = temp.getBytes();
        int bb = 0;
        for (int i = val; i <8 ; i++) {
            sizeBuffer[i]= sizeV[bb];
            bb++;
        }

       String name = "STM32.Bin";
        byte[] bytes = name.getBytes();
        int tp = 0;
        for (int i = 3; i < nameBuffer.length; i++) {
            nameBuffer[i] = bytes[tp];
            tp++;
        }
        //nameBuffer + sizeBuffer + offsetBuffer)
        // 合并三个数组
        byte[] fileHeadBuffer = new byte[nameBuffer.length + sizeBuffer.length + offsetBuffer.length];
        System.arraycopy(nameBuffer, 0, fileHeadBuffer, 0, nameBuffer.length);
        System.arraycopy(sizeBuffer, 0, fileHeadBuffer, nameBuffer.length, sizeBuffer.length);
        System.arraycopy(offsetBuffer, 0, fileHeadBuffer, nameBuffer.length + sizeBuffer.length, offsetBuffer.length);

        byte[] data = new byte[128];
        System.arraycopy(fileHeadBuffer,0,data,0,fileHeadBuffer.length);


//        for (int i = 0; i < data.length; i++) {
//           System.out.print( data[i]);
//        }



        int seqchr=  seq & 0xff;
        int seqchrNeg = (-seq-1) & 0xff;



        int crc16 =  crc16_ccitt_xmodem(data);//crc16十进制
        //System.out.println("args = [" + crc16 + "]");
        String toHexstr = Integer.toHexString(crc16);//转换成16进制字符串
        if (toHexstr.length() == 1) {
            toHexstr = "000" + toHexstr;
        } else if (toHexstr.length() == 2) {
            toHexstr = "00" + toHexstr;
        } else if (toHexstr.length() == 3) {
            toHexstr = "0" + toHexstr;
        }

        String fhex = toHexstr.substring(0,2);
        String lhex =toHexstr.substring(2,toHexstr.length());

        int intCrc = Integer.parseInt(fhex,16);
        int intCrcLast = Integer.parseInt(lhex,16);

        byte[] crc = new byte[2];
        crc[0] =(byte)intCrc;
        crc[1] =(byte)intCrcLast;

        byte[] packetBuf = new byte[]{0x01, 0x00, (byte) 0xff};
        byte[] result = new byte[packetBuf.length+data.length+crc.length];


        //let packetBuf = Buffer.concat([Buffer.from([Y_MODEM.PACKET_MARK]), seqchr, seqchrNeg, dataBuffer, Buffer(crc16, 'hex')]);
        System.arraycopy(packetBuf,0,result,0,packetBuf.length);
        System.arraycopy(fileHeadBuffer,0,result,packetBuf.length,fileHeadBuffer.length);

        result[result.length-2] = crc[0];
        result[result.length-1] = crc[1];
        for (int i = 0; i < result.length; i++) {
            //System.out.print( (result[i] & 0xff) );
        }

       String str = bytes2HexString(result);
        //System.out.println("args = [" + str + "]");

       // System.out.println("args = [" + big + "]");

        int a = 0x20;
        a = a>>8;
        //System.out.println("args = [" + a + "]");


        byte[] target = new byte[]{0x05,0x06};

        byte[] bt1 = {(byte) 0xAA, 0x0C, 0x05};
        byte[] bt2 = {(byte) 0x01, 0X20, 0X00, 0x08};
        byte[] byteReadHead = StringUtil.byteMeger(bt1,target,bt2);

        for (int i = 0; i < byteReadHead.length; i++) {
//            System.out.println("args = [" + byteReadHead[i] + "]");
        }

        //byte bbt = int2byte(140);
        //Byte by = Byte.parseByte("8C");
        //Integer.parseInt("0x8C", 16)

        byte v = Integer.valueOf("8C", 16).byteValue();
        System.out.println("args = [" +  hex2Bytes("00") + "]");
    }

}
