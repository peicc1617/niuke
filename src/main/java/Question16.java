import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Question16 {
    private static Map<String, Column> objectMap = new LinkedHashMap<String, Column>() {{
        put("id", new Column("id", "int(11)", "NO", "PRI", null, "auto_increment", "当前项目ID-NO_UPDATE-"));
        put("projectName", new Column("projectName", "varchar(255)", "YES", "", null, "", "项目名"));
        put("createTime", new Column("createTime", "datetime", "YES", "", "CURRENT_TIMESTAMP", "", "项目创建时间-NO_UPDATE-"));
        put("editTime", new Column("editTime", "datetime", "YES", "", "CURRENT_TIMESTAMP", "on update CURRENT_TIMESTAMP", "项目更新时间-NO_UPDATE-"));
        put("userID", new Column("userID", "int(11)", "NO", "", null, "", "用户ID"));
        put("memo", new Column("memo", "varchar(255)", "YES", "", null, "", "项目备注"));
        put("appResult", new Column("appResult", "longtext", "YES", "", null, "", "项目报告结果"));
        put("appContent", new Column("appContent", "longtext", "YES", "", null, "", "项目数据"));
        put("reservation", new Column("reservation", "text", "YES", "", null, "", "预留字段"));
        put("resultKey", new Column("resultKey", "varchar(255)", "YES", "", null, "", "记录密钥，用来获取共享数据"));
    }};

   public static  void main(String[] args){


       List<String> str=   objectMap.values().stream().map(Column::getSQLString).collect(Collectors.toList());




   }
}
