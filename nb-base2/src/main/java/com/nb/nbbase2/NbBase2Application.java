package com.nb.nbbase2;

import org.apache.commons.io.IOUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan(basePackages = "com.nb.nbbase2.servlet")
@SpringBootApplication
public class NbBase2Application {

    public static void main(String[] args) {

        SpringApplication.run(NbBase2Application.class, args);
    }

}









