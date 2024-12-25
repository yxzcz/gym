package com.milotnt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 健身管理系统的Spring Boot应用启动类。
 * 这个类作为整个应用的入口点，用于启动Spring Boot应用。
 */
@SpringBootApplication
public class GymManagementSystemApplication {

    /**
     * 程序的主入口方法，用于启动Spring Boot应用。
     * @param args 命令行参数数组。
     */
    public static void main(String[] args) {
        SpringApplication.run(GymManagementSystemApplication.class, args);
    }

}