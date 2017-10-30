import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.classic.filter.ThresholdFilter

import static ch.qos.logback.classic.Level.*

def USER_HOME = System.getProperty("user.home")
def APP_NAME = "ds-atomix-server"

appender("STDOUT", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"
    }
}

appender("dailyRollingFileAppender", RollingFileAppender) {
    file = "logs/${APP_NAME}.log"
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "${APP_NAME}.log.%d{yyyy-MM-dd}"
        maxHistory = 30
    }
    filter(ThresholdFilter) {
        level = INFO
    }
    encoder(PatternLayoutEncoder) {
        pattern = "%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"
    }
}

root(DEBUG, ["STDOUT", "dailyRollingFileAppender"])