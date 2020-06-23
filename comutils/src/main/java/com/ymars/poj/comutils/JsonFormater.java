package com.ymars.poj.comutils;

/**
 * @author Mars
 * @desc Json格式化输出
 */
public class JsonFormater {
    public static String format(String json) {
        //缩进
        StringBuilder indent = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        for (char c : json.toCharArray()) {
            switch (c) {
                case '{':
                    indent.append(" ");
                    sb.append("{").append(indent);
                    break;
                case '}':
                    indent.deleteCharAt(indent.length() - 1);
                    sb.append("").append(indent).append("}");
                    break;
                case '[':
                    indent.append(" ");
                    sb.append("[").append(indent);
                    break;
                case ']':
                    indent.deleteCharAt(indent.length() - 1);
                    sb.append("").append(indent).append("]");
                    break;
                case ',':
                    sb.append(",").append(indent);
                    break;
                default:
                    sb.append(c);
            }
        }
        return sb.toString();
    }
}