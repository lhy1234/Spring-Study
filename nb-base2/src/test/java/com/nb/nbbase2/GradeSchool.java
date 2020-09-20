package com.nb.nbbase2;

import lombok.Data;

import java.util.List;

/**
 * create by lihaoyang on 2020/9/3
 */
@Data
public class GradeSchool {

    private String schoolGrade;
    private List<School> schoolList;
}
