package converter;
import java.util.List;

/*
1. Если находим зяпятую - закрываем tr, открываем tr
2. Если находим двойные кавычки
 */
public class Converter {
    public static String convertToHTML(List<String> text) {
        StringBuilder sb = new StringBuilder();
        boolean nextLine = false;

        //Цикл, работающий тогда, когда идет перенос строки
        sb.append("<table>\n<tr>\n<td>");
        for (String e : text) {
            if (nextLine) {
                for (int j = 0; j < e.length() && nextLine; j++) {
                    char c2 = e.charAt(j);
                    if (c2 == '"' && (e.charAt(j + 1) == ',' || j + 1 == e.length())) {
                        sb.append(c2).append("</td>\n<td>");
                        nextLine = false;
                    } else if (j + 1 == e.length()) {
                        sb.append(c2).append("<br>");
                    } else {
                        sb.append(c2);
                    }
                }
         //Цикл, работающий тогда, когда нет переноса строки
            } else {
                for (int i = 0; i < e.length() && !nextLine; i++) {
                    char c1 = e.charAt(i);
                    if (c1 == ',') {
                        sb.append("</td>\n<td>");
                        break;
                    } else if (c1 == '"') {
                        for (int j = i + 1; i < e.length(); i++) {
                            char c2 = e.charAt(j);
                            if (c2 == '"' && (e.charAt(j + 1) == ',' || j + 1 == e.length())) {
                                sb.append(c2).append("</td>\n<td>");
                                break;
                            } else if (j + 1 == e.length()) {
                                sb.append(c2).append("<br>");
                                nextLine = true;
                            } else {
                                sb.append(c2);
                            }
                        }
                    } else {
                        sb.append(c1);
                    }
                }
            }
        }
        sb.append("</td>\n</tr>\n</table>");
        return sb.toString();
    }
}