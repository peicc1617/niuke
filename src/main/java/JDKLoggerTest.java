import java.util.logging.*;
//logger对象有三个比较重要的概念：level、handler、formatter
//level称为日志级别
//handler解决的问题主要是日志输出到哪里
//formatter定义了日志输出的格式
public class JDKLoggerTest {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("logger");
        logger.info("hello world");

        Handler handler = new Handler() {
            @Override
            public void publish(LogRecord record) {
            }
            @Override
            public void flush() {
            }
            @Override
            public void close() throws SecurityException {
            }
        };

        handler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return null;
            }
        });

        logger.setLevel(Level.WARNING);
        logger.log(Level.WARNING, "hello world");
    }
}
